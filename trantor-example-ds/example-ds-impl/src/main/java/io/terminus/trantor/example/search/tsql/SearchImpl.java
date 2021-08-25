package io.terminus.trantor.example.search.tsql;

import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantorframework.Page;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.sdk.sql.Search;

import java.util.List;
import java.util.Map;

/**
 * @author thn
 * @date 6/4/21 11:19 AM
 * @Description: TSQL方式查询搜索模型
 **/
public class SearchImpl {

    /**
     * 模糊查询
     */
    public Paging<TestSearchModel> pageTestSearchModelContainQueryOrderByTSQL() {
        Page page = new Page(0, 20);

        String select = "*";
        String where = "stringField like '%描述%' order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, page);
        return testSearchModelList;
    }

    /**
     * in查询
     */
    public Paging<TestSearchModel> pageTestSearchModelInQueryOrderByTSQL() {
        Page page = new Page(0, 20);

        String select = "*";
        String where = "intField in (1,2,3) order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, page);
        return testSearchModelList;
    }

    /**
     * 查询intField不为null的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelExistQueryOrderByTSQL() {
        Page page = new Page(0, 20);

        String select = "*";
        String where = "intField is not null order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, page);
        return testSearchModelList;
    }

    /**
     * 查询intField=1的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelMatchQueryOrderByTSQL() {
        Page page = new Page(0, 20);

        String select = "*";
        String where = "intField = 1 order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, page);
        return testSearchModelList;
    }

    /**
     * 查询intField在1和20之间的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelBetweenAndQueryOrderByTSQL() {
        Page page = new Page(0, 20);

        String select = "*";
        String where = "intField between 1 and 20 order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, page);
        return testSearchModelList;
    }

    /**
     * 查询intField大于1的数据
     */
    public Paging<TestSearchModel> pageTestSearchModelGtQueryOrderByTSQL() {
        Page page = new Page(0, 20);

        String select = "*";
        String where = "intField > 1  order by id desc";
        Paging<TestSearchModel> testSearchModelList = Search.paging(TestSearchModel.class, select, where, page);
        return testSearchModelList;
    }

    /**
     * 查询intField大于1并且按照intField，longField的数据
     * 分组和聚合参数无法映射到模型上，所以使用返回Map对象
     */
    public List<Map<String, Object>> testSearchModelGroupByTSQL() {

        String sql = "select intField,longField,min(intField),max(longField) from testSearchModel where" +
                " intField > 1 group by intField,longField";
        List<Map<String, Object>> mapList = Search.find(sql);
        return mapList;
    }


    
}
