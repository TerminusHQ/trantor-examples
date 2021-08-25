package io.terminus.trantor.example.model.search;

import io.terminus.trantor.example.dict.ItemTypeDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.SearchModel;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.ImageMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import io.terminus.trantorframework.api.type.GeoArea;
import io.terminus.trantorframework.api.type.GeoCircle;
import io.terminus.trantorframework.api.type.GeoLocation;
import io.terminus.trantorframework.api.type.GeoPolygon;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 定义的时候添加两个注解@Model和@SearchModel。该模型添加后DS会根据模型定义生成索引到搜索引擎上, 当模型发生变更时，需要用户手动执行全量同步来同步变更的模型信息。
 * 搜索模型的字段类型只支持Trantor中的普通类型，比如：Integer、Long、Json、String、BigDecimal等。关联字段Link和Relation都不支持。
 * 当模型数据发生变更时，DS会自动将变化同步至搜索引擎，但是搜索内容会有所延迟，但大概率优化极限是接近1秒。
 */
@Data
@SearchModel(name = "test search model")
@Model(name = "test search model")
public class TestSearchModel extends BaseModel<Long> {

    @Field(name = "stringField")
    private String stringField;

    @Field(name = "intField")
    private Integer intField;

    @Field(name = "longField")
    private Long longField;

    @Field(name = "booleanField")
    private Boolean booleanField;

    @TextMeta(length = 128)
    @Field(name = "longTextField", type = FieldType.Text)
    private String longTextField;

    @Field(name = "floatField")
    private Float floatField;

    @Field(name = "jsonField", type = FieldType.Json)
    private List<Long> jsonField;

    @Field(name = "Geo Location")
    private GeoLocation geoLocation;

    /**
     *地理位置类型，此字段表示一个圆形(地理位置总共三个类型: 矩形,圆形,多边形)
     */
    @Field(name = "Geo Circle")
    private GeoCircle geoCircle;

}
