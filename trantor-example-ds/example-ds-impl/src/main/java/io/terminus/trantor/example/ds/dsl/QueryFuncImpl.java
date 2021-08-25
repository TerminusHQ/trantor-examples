package io.terminus.trantor.example.ds.dsl;

import io.terminus.datastore.dsl.Query;
import io.terminus.datastore.dsl.SelectConditionStep;
import io.terminus.datastore.dsl.conf.ParamType;
import io.terminus.datastore.dsl.impl.TSQL;
import io.terminus.trantor.example.func.base.dsl.QueryFunc;
import io.terminus.trantor.example.model.base.TestModel1;
import io.terminus.trantor.example.model.base.TestModel2;
import io.terminus.trantor.example.model.base.TestModel3;
import io.terminus.trantorframework.Page;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: TSQL-DSL查询demo
 **/
@Slf4j
public class QueryFuncImpl implements QueryFunc {
    @Override
    public void query() {

        /**
         * 无条件简单查询: select `*` from  `TestModel1`;
         */
        Query queryAll = TSQL.select(TSQL.field("*")).from(TestModel1.class);
        List<TestModel1> queryAllResult = DS.findAll(queryAll);
        log.info("query all result:{}", queryAllResult);

        /**
         * 根据id简单等值查询: select `*` from  `TestModel1` where `id` = 1;
         */
        Query queryById = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.id_field).eq(1));
        log.info("tsql:{}", queryById.getSQL());
        TestModel1 queryByIdResult = DS.findOne(queryById);
        log.info("query by id result:{}", queryByIdResult);

        /**
         * 根据id查询指定字段: select `id`, `stringField` from `TestModel1` where id = 1;
         */
        Query queryAssignFieldById = TSQL.select(TSQL.field(TestModel1.id_field))
                .select(TSQL.field(TestModel1.stringField_field))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.id_field).eq(1));
        TestModel1 queryAssignFieldByIddResult = DS.findOne(queryAssignFieldById);
        log.info("query assign field by id result:{}", queryAssignFieldByIddResult);

        /**
         * 根据link字段查询: select `*` from  `TestModel1` where `testModel2`.`id` = 1;
         */
        Query queryByLink = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.testModel2_field, TestModel2.id_field).eq(1));
        TestModel1 queryByLinkResult = DS.findOne(queryByLink);
        log.info("query by link result:{}", queryByLinkResult);

        /**
         * 根据多级link查询: select `*` from  `TestModel1` where `testModel2`.`testModel3`.`id` = 1;
         */
        Query queryByManyLink = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.testModel2_field, TestModel2.testModel3_field, TestModel3.id_field).eq(1));
        TestModel1 queryByManyLinkResult = DS.findOne(queryByManyLink);
        log.info("query by many link result:{}", queryByManyLinkResult);

        /**
         * 根据某字段（如时间）范围查询: select * from `TestModel1` where `createdAt` > '2021-10-09 12:12:12' and `createdAt` < '2021-10-10 12:12:12';
         * 补充：
         * lt 小于
         * gt 大于
         * le 小于等于
         * ge 大于等于
         *
         */
        Query queryByRange = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.createdAt_field).lt("2021-10-10 12:12:12"))
                .and(TSQL.field(TestModel1.createdAt_field).gt("2021-10-09 12:12:12"));
        List<TestModel1> queryByRangeResult = DS.findAll(queryByRange);
        log.info("query by range result:{}", queryByRangeResult);

        /**
         * 空值查询: select * from `TestModel1` where stringField is null;
         */
        Query queryByIsNull = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).isNull());
        List<TestModel1> queryByIsNullResult = DS.findAll(queryByIsNull);
        log.info("query by isNull result:{}", queryByIsNullResult);

        /**
         * 非空值查询: select * from `TestModel1` where stringField is not null;
         */
        Query queryByIsNotNull = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).isNotNull());
        List<TestModel1> queryByIsNotNullResult = DS.findAll(queryByIsNotNull);
        log.info("query by isNotNull result:{}", queryByIsNotNullResult);

        /**
         * order排序，正序或者倒序
         * desc 倒序: select * from `TestModel1` where `longField` = 1 order by `stringField` desc;
         * asc 正序: select * from `TestModel1` where `longField` = 1 order by `stringField` asc;
         */
        Query queryByOrderDesc = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.longField_field).eq(1))
                .orderBy(TSQL.field(TestModel1.stringField_field).desc());
        List<TestModel1> queryByOrderDescResult = DS.findAll(queryByOrderDesc);
        log.info("query by order desc result:{}", queryByOrderDescResult);

        /**
         * groupBy max: select max(intField`) as intField from `TestModel1` where `longField` = 1 group by `intField`;
         */
        Query queryByGroupByAndMax = TSQL.select(TSQL.max(TSQL.field(TestModel1.intField_field)).as(TestModel1.intField_field))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.longField_field).eq(1))
                .groupBy(TSQL.field(TestModel1.intField_field));
        List<TestModel1> queryByGroupByAndMaxResult = DS.findAll(queryByGroupByAndMax);
        log.info("query by group by max result:{}", queryByGroupByAndMaxResult);

        /**
         * select count(*)
         */
        Query queryCount = TSQL.select(TSQL.count()).from(TestModel1.class);
        long queryCountResult = DS.count(queryCount);
        log.info("query count result:{}", queryCountResult);

        /**
         * select sum(x)
         */
        Query querySum = TSQL.select(TSQL.sum(TSQL.field(TestModel1.longField_field)).as("total")).from(TestModel1.class);
        //TODO DS.find(Query query) 接口待提供
        List<Map<String, Object>> querySumResult = DS.find(queryCount.getSQL(ParamType.INDEXED), queryCount.getParams());
        log.info("query sum result:{}", querySumResult);


        /**
         * 分页查询
         * 使用DSL分页查询与使用DS.paging(.....)的不同之处在于paging接口内存拼装了count查询语句，某些场景下拼装的count并不符合预期，
         * 使用DSL要自己拼装count查询语句。
         * select
         *   *
         * from
         *   TestModel1
         * where
         *   `createdAt` < '2021-10-10 12:12:12'
         * order by createdAt desc
         * limit 0, 20;
         *
         */
        //mock Page对象
        Page page = new Page(1, 20);
        Query queryPage = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.createdAt_field).lt("2021-10-10 12:12:12"))
                .orderBy(TSQL.field(TestModel1.createdAt_field))
                .limit(page.first(), page.limit());

        Query queryPageTotal = TSQL.selectCount()
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.createdAt_field).lt("2021-10-10 12:12:12"));
        long pageTotal = DS.count(queryPageTotal);
        Paging<TestModel1> paging = new Paging<>();
        if (pageTotal > 0) {
            paging.setTotal(pageTotal);
            List<TestModel1> pageResult = DS.findAll(queryPage);
            paging.setData(pageResult);
        }
        //return paging;

        /**
         * 关联查询,通过主模型id查询子模型数据: select `*`, `testModel2`.`*` from TestModel1 where `id` = 1;
         */
        Query queryParentAndChildByParentId = TSQL.select(TSQL.field("*"))
                .select(TSQL.field(TestModel1.testModel2_field, "*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.id_field).eq(1));
        TestModel1 queryParentAndChildByParentIdResult = DS.findOne(queryParentAndChildByParentId);
        log.info("query parent and child by parentId result:{}", queryParentAndChildByParentIdResult);

        /**
         * 关联查询,通过主模型id查询多级子模型数据: select `*`, `testModel2`.`*`, `testModel2`.`testModel3`.`*` from `TestModel1` where `id` = 1;
         */
        Query queryParentAndManyChildByParentId = TSQL.select(TSQL.field("*"))
                .select(TSQL.field(TestModel1.testModel2_field, "*"))
                .select(TSQL.field(TestModel1.testModel2_field, TestModel2.testModel3_field, "*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.id_field).eq(1));
        TestModel1 queryParentAndManyChildByParentIdResult = DS.findOne(queryParentAndManyChildByParentId);
        log.info("query parent and child by parentId result:{}", queryParentAndManyChildByParentIdResult);


        /**
         * 关联查询,通过子模型id查询父子模型数据: select `*`, `testModel2`.`*` from TestModel1 where `testModel2`.`id` = 1;
         */
        Query queryParentAndChildByChildId = TSQL.select(TSQL.field("*"))
                .select(TSQL.field(TestModel1.testModel2_field, "*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.testModel2_field, TestModel2.id_field).eq(1));
        TestModel1 queryParentAndChildByChildIdResult = DS.findOne(queryParentAndChildByChildId);
        log.info("query parent and child by childId result:{}", queryParentAndChildByChildIdResult);


        /**
         * 左匹配模糊查询: select `*` from TestModel1 where stringField like 'test%'
         * startsWith: 'xxx%'
         * endsWith: '%xxx'
         * contains: '%xxx%'
         */
        Query queryLeftMatching = TSQL.selectFrom(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).startsWith("test"));
        List<TestModel1> queryLeftMatchingResult = DS.findAll(queryLeftMatching);
        log.info("query left matching result:{}", queryLeftMatchingResult);

        /**
         * 右匹配模糊查询: select `*` from TestModel1 where stringField like '%test'
         */
        Query queryRightMatching = TSQL.selectFrom(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).endsWith("test"));
        List<TestModel1> queryRightMatchingResult = DS.findAll(queryRightMatching);
        log.info("query right matching result:{}", queryRightMatchingResult);

        /**
         * 左右%模糊查询: select `*` from TestModel1 where stringField like '%test%'
         */
        Query queryContains = TSQL.selectFrom(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).contains("test"));
        List<TestModel1> queryContainsResult = DS.findAll(queryContains);
        log.info("query contains result:{}", queryContainsResult);

        /**
         * 左右%不模糊查询: select `*` from TestModel1 where stringField not like '%test%'
         */
        Query queryNotContains = TSQL.selectFrom(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).notContains("test"));
        List<TestModel1> queryNotContainsResult = DS.findAll(queryNotContains);
        log.info("query not contains result:{}", queryNotContainsResult);

        /**
         * 简单动态SQL
         * 根据值是否为空决定是否拼接查询条件
         */
        //Mock数据
        TestModel1 testModel1 = new TestModel1();
        testModel1.setFloatField(1.25f);
        testModel1.setStringField("test");
        //查询动态SQL拼装 select * from TestModel1 where floatField = 1.25 and .....
        SelectConditionStep selectConditionStep = TSQL.select(TSQL.field("*"))
                .from(TestModel1.class)
                .where(TSQL.field(TestModel1.floatField_field).eq(testModel1.getFloatField()));
        if (StringUtils.isNotEmpty(testModel1.getStringField())) {
            selectConditionStep = selectConditionStep.and(TSQL.field(TestModel1.stringField_field).eq(testModel1.getStringField()));
        }
        if (testModel1.getCurrency() != null) {
            selectConditionStep = selectConditionStep.and(TSQL.field(TestModel1.currency_field).eq(testModel1.getCurrency().getValue()));
        }
        //Query为DSL顶层接口，SelectConditionStep也实现了该接口
        List<TestModel1> queryDynamicSqlResult = DS.findAll(selectConditionStep);
        log.info("query dynamic sql result:{}", queryDynamicSqlResult);
    }
}
