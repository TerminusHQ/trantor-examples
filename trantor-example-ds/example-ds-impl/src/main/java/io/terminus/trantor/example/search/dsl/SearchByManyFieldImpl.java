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
 * @Description: SearchQuery多字段方式查询搜索模型
 * 多条件查询会存在权重的概念，默认权重值为1.00
 **/
public class SearchByManyFieldImpl {

    /**
     * 查询stringField不为null和id在(1,2,3)之间的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdListAndStringFieldIsExist() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(boolQueryBuilderSearch -> {
            BoolQueryBuilderSearch bool = boolQueryBuilderSearch.bool();
            bool.filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, idList).boosts(2.00f));
            bool.filter(boolQueryBuilderSearch.existsQuery(TestSearchModel.stringField_field));
            return bool;
        });

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询stringField不为null或id在(1,2,3)之间的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdListOrStringFieldIsExist() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(boolQueryBuilderSearch -> {
            BoolQueryBuilderSearch bool = boolQueryBuilderSearch.bool();
            bool.filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, idList).boosts(2.00f));
            bool.should(boolQueryBuilderSearch.existsQuery(TestSearchModel.stringField_field));
            return bool;
        });

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询id在(1,2,3)之间和intField=1或者stringField不为null的数据
     * 注意在同一个boolQueryBuilderSearch下搜索filter或者must都是必须条件，should都是非必须条件
     * 相当于id in (1,2,3) and intField=1 or stringField is not null
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdListAndIntFieldOrStringFieldIsExist() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(boolQueryBuilderSearch -> {
            BoolQueryBuilderSearch bool = boolQueryBuilderSearch.bool();
            bool.filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, idList).boosts(2.00f));
            bool.should(boolQueryBuilderSearch.existsQuery(TestSearchModel.stringField_field));
            bool.filter(boolQueryBuilderSearch.termQuery(TestSearchModel.intField_field, 2).boosts(2.00f));
            return bool;
        });

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询id在(1,2,3)之间和(intField=1或者stringField不为null)的数据
     * 相当于id in (1,2,3) and (intField=1 or stringField is not null)
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdListOrIntFieldAndStringFieldIsExist() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(boolQueryBuilderSearch -> {
            BoolQueryBuilderSearch bool = boolQueryBuilderSearch.bool();
            bool.filter(boolQueryBuilderSearch.termsQuery(TestSearchModel.id_field, idList).boosts(2.00f));

            BoolQueryBuilderSearch subBool = boolQueryBuilderSearch.bool();
            subBool.should(boolQueryBuilderSearch.existsQuery(TestSearchModel.stringField_field));
            subBool.filter(boolQueryBuilderSearch.termQuery(TestSearchModel.intField_field, 2).boosts(2.00f));
            bool.filter(subBool);
            return bool;
        });

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }

    /**
     * 查询id在(1,2,3)之间和intField大于10小于18和stringField不为null的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelInIdListAndIntFieldAndStringFieldIsExist() {
        Page page = new Page(0, 20);

        SearchQuery searchQuery = new SearchQuery();
        List<Integer> idList = Arrays.asList(1, 2, 3);
        searchQuery.where(f -> f.bool()
                .must(f.existsQuery(TestSearchModel.stringField_field).boosts(2.00f))
                .filter(f.rangeQuery(TestSearchModel.intField_field).gt(10).lt(18))
                .must(f.termsQuery(TestSearchModel.id_field, 1, 2, 3)));

        Paging<TestSearchModel> testSearchModelList = Search.searchDSL(TestSearchModel.class, page, searchQuery);
        return testSearchModelList;
    }
}
