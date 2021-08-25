package io.terminus.trantor.example.func;


import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @ClassName: SearchTestSearchModelFun
 * @Description:
 * @Author: tianhuannan
 * @Date: 2021/5/10 1:56 下午
 **/
public interface TestSearchModelFunc {

    Paging<TestSearchModel> pageTestSearchModelContainQueryOrderByTSQL();

    Paging<TestSearchModel> pageTestSearchModelGeoPolygonByDSL();

    Paging<TestSearchModel> pageTestSearchModelGeoDistanceSortOrderBy();

    Paging<TestSearchModel> pageTestSearchModelJsonFieldOrderBy();

    Paging<TestSearchModel> pageTestSearchModelInIdListOrderBy();

    Paging<TestSearchModel> pageTestSearchModelInQueryOrderByTSQL();

    Paging<TestSearchModel> pageTestSearchModelRangeQueryOrderBy();
}
