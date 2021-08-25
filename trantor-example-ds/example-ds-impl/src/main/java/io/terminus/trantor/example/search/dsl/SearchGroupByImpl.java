package io.terminus.trantor.example.search.dsl;

import io.terminus.autumn.model.search.domain.*;
import io.terminus.autumn.model.search.function.BoolQueryBuilderSearch;
import io.terminus.autumn.model.search.function.SearchQuery;
import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantorframework.Page;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.sdk.sql.Search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author thn
 * @date 6/4/21 11:19 AM
 * @Description: SearchQuery GroupBy分组方式查询
 * 由于分组和聚合参数无法映射到模型上，所以使用返回Map对象
 * map对的key对应入参时的别名，value对应分组的数据
 **/
public class SearchGroupByImpl {

    /**
     * 查询stringField like %描述% 的数据,并根据stringField分组，求min(intField)的聚合结果
     * map返回格式:
     * stringField_alias: "描述"
     * intField_min: 1
     * doc_count: 2
     * 表示stringField为描述的分组中intField最小值为1，总共两条数据
     */
    public List<Map<String, Object>> testSearchModelGroupBy() {

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool()
                .must(a.wildcardQuery(TestSearchModel.stringField_field, "描述").boosts(2.00f)))
                .aggregation(agg -> agg.terms(TestSearchModel.stringField_field + "_alias", TestSearchModel.stringField_field)
                        .min(TestSearchModel.intField_field + "_min", TestSearchModel.intField_field));

        List<Map<String, Object>> mapList = Search.find(TestSearchModel.class, searchQuery);
        return mapList;
    }

    /**
     * 查询stringField like %描述% 的数据,并根据stringField和booleanField分组，并求min(intField)的聚合结果
     * 多字段分组，表示使用stringField和booleanField双字段进行分组
     * stringField_alias: "描述"
     * booleanField_alias: true
     * intField_min: 1
     * doc_count: 2
     * 表示stringField为描述和booleanField为true的分组中intField最小值为1，总共两条数据
     */
    public List<Map<String, Object>> testSearchModelManyFieldGroupBy() {

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool()
                .must(a.wildcardQuery(TestSearchModel.stringField_field, "描述").boosts(2.00f)))
                .aggregation(agg -> agg.terms(TestSearchModel.stringField_field + "_alias", TestSearchModel.stringField_field)
                        .min(TestSearchModel.intField_field + "_min", TestSearchModel.intField_field)
                        .terms(TestSearchModel.booleanField_field+"_alias",TestSearchModel.booleanField_field));

        List<Map<String, Object>> mapList = Search.find(TestSearchModel.class, searchQuery);
        return mapList;
    }

    /**
     * 查询stringField like %描述% 的数据,并根据stringField分组，求min(intField),max(floatField),max(floatField)的聚合结果
     * 单字段分组，求分组后的各个聚合函数
     * stringField_alias: "描述"
     * floatField_max: 5.00
     * floatField_sum: 10.00
     * intField_min: 1
     * doc_count: 2
     * 表示stringField为描述和booleanField为true的分组中intField最小值为1，总共两条数据
     */
    public List<Map<String, Object>> testSearchModelManyFieldGroupBy2() {

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool()
                .must(a.wildcardQuery(TestSearchModel.stringField_field, "描述").boosts(2.00f)))
                .aggregation(agg -> agg.terms(TestSearchModel.stringField_field + "_alias", TestSearchModel.stringField_field)
                        .min(TestSearchModel.intField_field + "_min", TestSearchModel.intField_field)
                        .max(TestSearchModel.floatField_field+"_max",TestSearchModel.floatField_field)
                        .sum(TestSearchModel.floatField_field+"_sum",TestSearchModel.floatField_field));

        List<Map<String, Object>> mapList = Search.find(TestSearchModel.class, searchQuery);
        return mapList;
    }

}
