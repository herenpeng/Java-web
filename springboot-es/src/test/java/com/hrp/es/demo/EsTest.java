package com.hrp.es.demo;

import com.hrp.es.pojo.Item;
import com.hrp.es.repository.ItemRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hrp
 * 2020/2/11 17:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCreateIndex() {
        //创建索引库
        template.createIndex(Item.class);
        //映射关系
        template.putMapping(Item.class);
    }

    @Test
    public void testDelete() {
        template.deleteIndex("hrp");
    }

    @Test
    public void testInsertIndex() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "坚果手机", "手机", "锤子", 3699.00, ""));
        list.add(new Item(2L, "苹果手机", "手机", "苹果", 8899.00, ""));
        list.add(new Item(3L, "三星手机", "手机", "三星", 2699.00, ""));
        list.add(new Item(4L, "小米手机", "手机", "小米", 3499.00, ""));
        list.add(new Item(5L, "荣耀手机", "手机", "华为", 5999.00, ""));
        itemRepository.saveAll(list);
    }

    @Test
    public void testFind() {
        Iterable<Item> list = itemRepository.findAll();
        for (Item item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void testFindBy() {
        List<Item> list = itemRepository.findByPriceBetween(2000d, 4000d);
        for (Item item : list) {
            System.out.println(item);
        }
    }


    @Test
    public void testQuery() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //结果过滤
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{"id", "title"}, null));
        //添加查询条件
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
        //排序(倒序)
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        //分页
        queryBuilder.withPageable(PageRequest.of(0, 2));

        Page<Item> result = itemRepository.search(queryBuilder.build());
        for (Item item : result) {
            System.out.println(item);
        }
    }

    @Test
    public void testAgg() {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        String aggName = "popularBrand";
        //聚合
        queryBuilder.addAggregation(AggregationBuilders.terms(aggName).field("brand"));
        //查询并返回带聚合结果
        AggregatedPage<Item> result = template.queryForPage(queryBuilder.build(), Item.class);
        //解析聚合
        Aggregations aggs = result.getAggregations();
        //获取指定名称的聚合
        StringTerms terms = aggs.get(aggName);
        //获取桶
        List<StringTerms.Bucket> buckets = terms.getBuckets();
        for (StringTerms.Bucket bucket : buckets) {
            System.out.println("key" + bucket.getKeyAsString());
            System.out.println("docCount" + bucket.getDocCount());
        }
    }


}
