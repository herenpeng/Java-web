package com.hrp.es.repository;

import com.hrp.es.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author hrp
 * 2020/2/11 17:17
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

    /**
     * 根据价格区间来查询
     * @param start
     * @param end
     * @return
     */
    List<Item> findByPriceBetween(Double start,Double end);

}
