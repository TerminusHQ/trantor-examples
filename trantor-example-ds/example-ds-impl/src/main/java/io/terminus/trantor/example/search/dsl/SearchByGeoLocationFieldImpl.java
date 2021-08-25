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
 * @Description: SearchQuery单字段方式查询搜索模型
 **/
public class SearchByGeoLocationFieldImpl {

    /**
     * 查询覆盖coordinates的geoArea列表，coordinates表示一个矩形范围
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoEnvelopeByDSL() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个矩形
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));//左上角坐标点
        coordinates.add(new DSGeoLocation(101.0, 0.0));//右上角坐标点

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.contains) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .type(ShapeType.envelope)));//表示coordinates的形状是一个矩形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询覆盖coordinates的geoArea列表，coordinates表示一个多边形范围
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoPolygonByDSL() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个多边形，多边形的第一个和最后一个坐标点要保持一致，不然会报格式错误
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));
        coordinates.add(new DSGeoLocation(101.0, 0.0));
        coordinates.add(new DSGeoLocation(101.0, 1.0));
        coordinates.add(new DSGeoLocation(100.4, 2.0));
        coordinates.add(new DSGeoLocation(100.3, 1.0));

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.contains) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .type(ShapeType.polygon)));//表示coordinates的形状是一个多边形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }


    /**
     * 查询覆盖coordinates的geoArea列表，coordinates表示一个坐标点为(100.3, 1.0)和半径为100.00m的圆形范围
     * 这里coordinates类型是List<DSGeoLocation>，因为是坐标圆心，同样可以直接使用DSGeoLocation对象。
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoCircleByDSL() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个圆形
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.contains) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .radius(100.00)
                        .type(ShapeType.circle)));//表示coordinates的形状是一个圆形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询覆盖coordinates的geoArea列表，coordinates表示一个坐标点
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoPointByDSL() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个坐标点
        DSGeoLocation coordinates = new DSGeoLocation(100.3, 1.0);

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.contains) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .type(ShapeType.point)));//表示coordinates的形状是一个坐标点
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 地理位置类型范围搜索有个类型ShapeRelation，他表示索引上的geoArea和查询的传参对象的关系，目前支持四种类型。
     * intersects：查询的形状与索引的形状有重叠（默认）, 即图形有交集则匹配
     * disjoint：查询的形状与索引的形状完全不重叠
     * within：查询的形状包含索引的形状
     * contains：索引的形状包含查询的形状
     * 详细的用法可参考下面的用例
     */

    /**
     * 查询和coordinates毫无接触的geoArea列表，coordinates表示一个矩形范围
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoEnvelopeByDSL2() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个矩形
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));//左上角坐标点
        coordinates.add(new DSGeoLocation(101.0, 0.0));//右上角坐标点

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.disjoint) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .type(ShapeType.envelope)));//表示coordinates的形状是一个矩形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询被coordinates覆盖的geoArea列表，coordinates表示一个矩形范围
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoEnvelopeByDSL3() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个矩形
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));//左上角坐标点
        coordinates.add(new DSGeoLocation(101.0, 0.0));//右上角坐标点

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.within) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .type(ShapeType.envelope)));//表示coordinates的形状是一个矩形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询和coordinates相交的geoArea列表，coordinates表示一个矩形范围
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoEnvelopeByDSL4() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        //根据下面的type类型设置，coordinates表示一个矩形
        List<DSGeoLocation> coordinates = new LinkedList<>();
        coordinates.add(new DSGeoLocation(100.3, 1.0));//左上角坐标点
        coordinates.add(new DSGeoLocation(101.0, 0.0));//右上角坐标点

        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.intField_field, 10, 20).boosts(2.00f))
                .filter(a.geoShapeSearch(TestSearchModel.geoCircle_field)
                        .relation(ShapeRelation.intersects) //表示搜索出覆盖coordinates的geoArea
                        .locations(coordinates)
                        .type(ShapeType.envelope)));//表示coordinates的形状是一个矩形
        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询id在(1，2)里的数据，并按照两点之间的距离排序
     */
    public Paging<TestSearchModel> pageTestSearchModelGeoDistanceSortOrderBy() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(a -> a.bool().must(a.termsQuery(TestSearchModel.id_field, 1, 2)))
                .geoDistanceSort(s -> s.field(TestSearchModel.geoLocation_field)
                        .location(new DSGeoLocation(12.174381, 31.254079))
                        .order(Order.DESC).unit(UnitEnum.m));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

}
