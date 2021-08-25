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
public class SearchByOneFieldImpl {

    /**
     * in查询
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdList() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(boolQueryBuilderSearch -> {
            BoolQueryBuilderSearch bool = boolQueryBuilderSearch.bool();
            bool.filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, idList));
            return bool;
        });

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * in查询 方式2
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdList2() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> {
            BoolQueryBuilderSearch bool = boolQueryBuilderSearch.bool();
            bool.filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, 1, 2, 3));
            return bool;
        });

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * in查询 方式3
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdList3() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, idList)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 范围查询 查询1到10的intField
     * 相当于sql 1<intField<10  两端都是闭合
     */
    public Paging<TestSearchModel> pageTestSearchModelRangeQuery() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.rangeQuery(TestSearchModel.intField_field, 1, 10)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 范围查询 查询大于1的intField
     * 相当于sql 1<intField
     */
    public Paging<TestSearchModel> pageTestSearchModelRangeQuery1() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.rangeQuery(TestSearchModel.intField_field).gt(1)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 范围查询 查询小于10的intField
     * 相当于sql intField<10
     */
    public Paging<TestSearchModel> pageTestSearchModelRangeQuery2() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.rangeQuery(TestSearchModel.intField_field).lt(10)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 范围查询 查询大于等于1的intField
     * 相当于sql intField>=1
     */
    public Paging<TestSearchModel> pageTestSearchModelRangeQuery3() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.rangeQuery(TestSearchModel.intField_field).gte(1)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 范围查询 查询小于等于10的intField
     * 相当于sql intField<=10
     */
    public Paging<TestSearchModel> pageTestSearchModelRangeQuery4() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.rangeQuery(TestSearchModel.intField_field).lte(10)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询intField=1的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelTermQuery() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.termQuery(TestSearchModel.intField_field, 1)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询stringField='描述'的数据
     * 和term精确查询的区别是: 当stringField有分词器的时候，matchQuery支持分词器查询
     */
    public Paging<TestSearchModel> pageTestSearchModelMatchQuery() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.matchQuery(TestSearchModel.stringField_field, "描述")));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 模糊查询 查询stringField like %描述% 的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelContainerQuery() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.wildcardQuery(TestSearchModel.stringField_field, "描述")));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询stringField 不为null 的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelExistsQuery() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.existsQuery(TestSearchModel.stringField_field)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * jsonField类型是个List<Long>,查询和(1,2,3)有相交元素的jsonField列表
     */
    public Paging<TestSearchModel> pageTestSearchModelJsonFieldOrderBy() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.termsQuery(TestSearchModel.jsonField_field, 1L, 2L, 3L)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * jsonField类型是个List<Long>,查询元素中等于2L的jsonField列表
     */
    public Paging<TestSearchModel> pageTestSearchModelJsonFieldOrderBy2() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        searchQuery.where(boolQueryBuilderSearch -> boolQueryBuilderSearch.bool()
                .must(boolQueryBuilderSearch.termQuery(TestSearchModel.jsonField_field, 2L)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

}
