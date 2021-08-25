package io.terminus.trantor.example.search.dsl;

import io.terminus.autumn.model.search.domain.DSGeoLocation;
import io.terminus.autumn.model.search.domain.Order;
import io.terminus.autumn.model.search.domain.UnitEnum;
import io.terminus.autumn.model.search.function.BoolQueryBuilderSearch;
import io.terminus.autumn.model.search.function.SearchQuery;
import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantorframework.Page;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.sdk.sql.Search;

import java.util.Arrays;
import java.util.List;

/**
 * @author thn
 * @date 6/4/21 11:19 AM
 * @Description: SearchQuery单字段方式查询搜索模型
 **/
public class SearchOrderByImpl {

    /**
     * 查询所有数据,并根据intField倒序
     */
    public Paging<TestSearchModel> pageTestSearchModelOrderBy() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.matchAllQuery()))
                .sort(s -> s.field(TestSearchModel.intField_field).order(Order.DESC));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询所有数据,并根据intField正序
     */
    public Paging<TestSearchModel> pageTestSearchModelOrderBy2() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.matchAllQuery()))
                .sort(s -> s.field(TestSearchModel.intField_field).order(Order.ASC));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询所有数据,并先根据intField正序，再根据floatField倒叙
     */
    public Paging<TestSearchModel> pageTestSearchModelManyFieldOrderBy() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.matchAllQuery()))
                .sort(sort -> sort.field(TestSearchModel.intField_field).order(Order.ASC))
                .sort(sort -> sort.field(TestSearchModel.floatField_field).order(Order.DESC));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询所有数据,并先根据intField正序，再根据floatField倒叙，再根据longField正序
     */
    public Paging<TestSearchModel> pageTestSearchModelManyFieldOrderBy2() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.matchAllQuery()))
                .sort(sort -> sort.field(TestSearchModel.intField_field).order(Order.ASC))
                .sort(sort -> sort.field(TestSearchModel.floatField_field).order(Order.DESC))
                .sort(sort -> sort.field(TestSearchModel.longField_field).order(Order.ASC));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }


    /**
     * 特殊场景: 和坐标点之间的距离一起排序
     * 查询所有数据,先根据两点之间的距离排序，然后再先根据intField正序，再根据floatField倒序
     */
    public Paging<TestSearchModel> pageTestSearchModelManyFieldOrderBy3() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.matchAllQuery()))
                .geoDistanceSort(s -> s.field(TestSearchModel.geoLocation_field)
                        .location(new DSGeoLocation(12.174381, 31.254079))
                        .order(Order.DESC).unit(UnitEnum.m))
                .sort(sort -> sort.field(TestSearchModel.intField_field).order(Order.ASC))
                .sort(sort -> sort.field(TestSearchModel.floatField_field).order(Order.DESC));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }
}
