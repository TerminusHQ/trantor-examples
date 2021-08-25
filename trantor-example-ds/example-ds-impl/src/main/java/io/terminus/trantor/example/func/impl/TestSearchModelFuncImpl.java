package io.terminus.trantor.example.func.impl;

import io.terminus.autumn.model.search.domain.*;
import io.terminus.autumn.model.search.function.BoolQueryBuilderSearch;
import io.terminus.autumn.model.search.function.SearchQuery;
import io.terminus.trantor.example.func.TestSearchModelFunc;
import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantorframework.Page;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.sdk.sql.Search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SearchTestSearchModelFuncImpl
 * @Description:
 * @Author: tianhuannan
 * @Date: 2021/5/10 1:56 下午
 **/
public class TestSearchModelFuncImpl implements TestSearchModelFunc {

    public Paging<TestSearchModel> pageTestSearchModelContainQueryOrderByTSQL() {
        String select = "*";
        String where = "stringField like '%描述%' order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, new Page(0,
                20));
        return testSearchModelList;
    }

    /**
     * in查询
     */
    public Paging<TestSearchModel> pageTestSearchModelInQueryOrderByTSQL() {
        String select = "*";
        String where = "intField in (1,2,3) order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, new Page(0,
                20));
        return testSearchModelList;
    }

    /**
     * in查询
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdListOrderBy() {
        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, new Page(0, 1),
                searchQuery.where(it -> {
            BoolQueryBuilderSearch bool = it.bool();
            bool.filter(it.termsQuery(TestSearchModel.id_field, idList));
            return bool;
        }));
        return testSearchModelList;
    }

    /**
     * 范围查询 查询1 到 10的intField
     */
    public Paging<TestSearchModel> pageTestSearchModelRangeQueryOrderBy() {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool()
                .must(a.rangeQuery(TestSearchModel.intField_field, 1, 10).boosts(2.00f)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, new Page(0, 20),
                searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询覆盖coordinates的geoCircle列表，coordinates表示一个矩形范围
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoPolygonByDSL() {
        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个矩形
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));//左上角坐标点
        coordinates.add(new DSGeoLocation(101.0, 0.0));//右上角坐标点

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.contains) //表示搜索出覆盖coordinates的geoCircle
                        .locations(coordinates)
                        .type(ShapeType.envelope)));//表示coordinates的形状是一个矩形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, new Page(0, 20),
                searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询id在(1，2)里的数据，并按照两点之间的距离排序
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoDistanceSortOrderBy() {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.id_field, 1, 2)))
                .geoDistanceSort(s -> s.field(TestSearchModel.geoLocation_field)
                        .location(new DSGeoLocation(12.174381, 31.254079))
                        .order(Order.DESC).unit(UnitEnum.m));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, new Page(0, 20),
                searchQuery);
        return testSearchModelList;
    }

    /**
     * jsonField类型是个List<Long>,查询和(1,2,3)有相交元素的jsonField列表
     */
    public Paging<TestSearchModel> pageTestSearchModelJsonFieldOrderBy() {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool()
                .must(a.termsQuery(TestSearchModel.jsonField_field, 1L, 2L, 3L).boosts(2.00f)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, new Page(0, 20),
                searchQuery);
        return testSearchModelList;
    }
}
