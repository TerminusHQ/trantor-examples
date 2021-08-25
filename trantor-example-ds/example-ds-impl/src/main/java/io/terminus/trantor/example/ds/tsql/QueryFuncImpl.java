package io.terminus.trantor.example.ds.tsql;

import io.terminus.trantor.example.func.base.tsql.QueryFunc;
import io.terminus.trantor.example.model.base.TestModel1;
import io.terminus.trantorframework.Page;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: SDK 查询demo
 **/
@Slf4j
public class QueryFuncImpl implements QueryFunc {
    @Override
    public void query() {
        /**
         * 无条件简单查询: select `*` from  `TestModel1`;
         */
        List<TestModel1> queryAllResult = DS.findAll(TestModel1.class, "*", null);
        log.info("query all result:{}", queryAllResult);

        /**
         * 根据id简单等值查询: select `*` from  `TestModel1` where `id` = 1;
         */
        TestModel1 queryByIdResult = DS.findOne(TestModel1.class, "*", "id = ?", 1);
        log.info("query by id result:{}", queryByIdResult);

        /**
         * 根据id查询指定字段: select `id`, `stringField` from `TestModel1` where id = 1;
         */
        TestModel1 queryAssignFieldByIddResult = DS.findOne(TestModel1.class, "`id`, `stringField`", "`id` = ?", 1);
        log.info("query assign field by id result:{}", queryAssignFieldByIddResult);

        /**
         * 根据link字段查询: select `*` from  `TestModel1` where `testModel2`.`id` = 1;
         */
        TestModel1 queryByLinkResult = DS.findOne(TestModel1.class, "*", "`testModel2`.`id` = ?", 1);
        log.info("query by link result:{}", queryByLinkResult);

        /**
         * 根据多级link查询: select `*` from  `TestModel1` where `testModel2`.`testModel3`.`id` = 1;
         */
        TestModel1 queryByManyLinkResult = DS.findOne(TestModel1.class, "*", "`testModel2`.`testModel3`.`id` = ?", 1);
        log.info("query by many link result:{}", queryByManyLinkResult);

        /**
         * 根据某字段（如时间）范围查询: select * from `TestModel1` where `createdAt` > '2021-10-09 12:12:12' and `createdAt` < '2021-10-10 12:12:12';
         */
        List<TestModel1> queryByRangeResult = DS.findAll(TestModel1.class, "*",
                "`createdAt` > ? and `createdAt` < ?", "2021-10-09 12:12:12", "2021-10-10 12:12:12");
        log.info("query by range result:{}", queryByRangeResult);

        /**
         * 空值查询: select * from `TestModel1` where stringField is null;
         */
        List<TestModel1> queryByIsNullResult = DS.findAll(TestModel1.class, "*", "stringField is null");
        log.info("query by isNull result:{}", queryByIsNullResult);

        /**
         * 非空值查询: select * from `TestModel1` where stringField is not null;
         */
        List<TestModel1> queryByIsNotNullResult = DS.findAll(TestModel1.class, "*", "stringField is not null");
        log.info("query by isNotNull result:{}", queryByIsNotNullResult);

        /**
         * order排序，正序或者倒序
         * desc 倒序: select * from `TestModel1` where `longField` = 1 order by `stringField` desc;
         * asc 正序: select * from `TestModel1` where `longField` = 1 order by `stringField` asc;
         */
        List<TestModel1> queryByOrderDescResult = DS.findAll(TestModel1.class, "*",
                "`longField` = ? order by `stringField` desc;", 1);
        log.info("query by order desc result:{}", queryByOrderDescResult);

        /**
         * groupBy max: select max(`intField`) as stringField from `TestModel1` where `longField` = 1 group by `intField`;
         */
        List<TestModel1> queryByGroupByAndMaxResult = DS.findAll(TestModel1.class, "max(`intField`) as intField",
                "`longField` = ? group by `intField`", 1);
        log.info("query by group by max result:{}", queryByGroupByAndMaxResult);

        /**
         * select count(*) from TestModel1 where stringField = 'test';
         */
        long queryCountResult = DS.count(TestModel1.class, "stringField = ?", "test");
        log.info("query count result:{}", queryCountResult);


        /**
         * 分页查询
         * select
         *   *
         * from
         *   TestModel1
         * where
         *   `createdAt` <= '2021-10-10 12:12:12'
         * order by createdAt desc
         * limit 10, 100;
         *
         */
        //mock Page对象
        Page page = new Page(1, 20);
        Paging<TestModel1> pageResult = DS.paging(TestModel1.class, "*", "`createdAt` <= ?", page, "2021-10-10 12:12:12");
        //return pageResult;

        /**
         * 关联查询,通过主模型id查询子模型数据: select `*`, `testModel2`.`*` from TestModel1 where `id` = 1;
         */
        TestModel1 queryParentAndChildByParentIdResult = DS.findOne(TestModel1.class, "`*`, `testModel2`.`*`", "`id` = ?", 1);
        log.info("query parent and child by parentId result:{}", queryParentAndChildByParentIdResult);

        /**
         * 关联查询,通过主模型id查询多级子模型数据: select `*`, `testModel2`.`*`, `testModel2`.`testModel3`.`*` from `TestModel1` where `id` = 1;
         */
        TestModel1 queryParentAndManyChildByParentIdResult = DS.findOne(TestModel1.class, "`*`, `testModel2`.`*`, `testModel2`.`testModel3`.`*`",
                "`id` = ?", 1);
        log.info("query parent and child by parentId result:{}", queryParentAndManyChildByParentIdResult);


        /**
         * 关联查询,通过子模型id查询父子模型数据: select `*`, `testModel2`.`*` from TestModel1 where `testModel2`.`id` = 1;
         */
        TestModel1 queryParentAndChildByChildIdResult = DS.findOne(TestModel1.class, "`*`, `testModel2`.`*`",
                "`testModel2`.`id` = ?", 1);
        log.info("query parent and child by childId result:{}", queryParentAndChildByChildIdResult);


        /**
         * 左匹配模糊查询: select `*` from TestModel1 where stringField like 'test%'
         */
        List<TestModel1> queryLeftMatchingResult = DS.findAll(TestModel1.class, "*",
                "`stringField` like ?", "test%");
        log.info("query left matching result:{}", queryLeftMatchingResult);

        /**
         * 简单动态SQL
         * 根据值是否为空决定是否拼接查询条件
         * 使用该方式实现动态只能走非预编译模式，容易存在SQL注入
         */
        //Mock数据
        TestModel1 testModel1 = new TestModel1();
        testModel1.setFloatField(1.25f);
        testModel1.setStringField("test");
        StringBuilder where = new StringBuilder();
        where.append("`floatField` = " + testModel1.getFloatField());
        if (StringUtils.isNotEmpty(testModel1.getStringField())) {
            where.append(" and ").append("`stringField` = " + testModel1.getStringField());
        }
        if (testModel1.getCurrency() != null) {
            where.append(" and ").append("`currency` = " + testModel1.getCurrency().getValue());
        }

        List<TestModel1> queryDynamicSqlResult = DS.findAll(TestModel1.class, "*", where.toString());
        log.info("query dynamic sql result:{}", queryDynamicSqlResult);
    }

}
