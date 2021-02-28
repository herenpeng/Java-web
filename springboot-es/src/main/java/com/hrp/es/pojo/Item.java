package com.hrp.es.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author hrp
 * 2020/2/11 16:58
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "hrp", type = "item", shards = 1, replicas = 1)
public class Item {
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String title;

    @Field(type = FieldType.Keyword)
    private String category;

    @Field(type = FieldType.Keyword)
    private String brand;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Keyword, index = false)
    private String images;
}
