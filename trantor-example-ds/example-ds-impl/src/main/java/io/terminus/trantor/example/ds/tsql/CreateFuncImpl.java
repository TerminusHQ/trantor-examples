package io.terminus.trantor.example.ds.tsql;

import io.terminus.trantor.example.func.base.tsql.CreateFunc;
import io.terminus.trantor.example.model.base.TestModel1;
import io.terminus.trantor.example.model.base.TestModel2;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: SDK 创建demo
 **/
@Slf4j
public class CreateFuncImpl implements CreateFunc {
    @Override
    public void create() {

        /**
         * 创建
         */
        TestModel1 testModel1 = new TestModel1();
        testModel1.setFloatField(1.25f);
        testModel1.setBooleanField(true);
        testModel1.setIntField(1);
        testModel1.setLongField(1L);
        IntResult createResult = DS.create(testModel1);
        log.info("create test model1 id:{}", createResult.getValue());

        /**
         * 批量创建
         */
        List<TestModel1> testModel1s = new ArrayList<>();
        testModel1s.add(testModel1);
        List<IntResult> batchCreateResult = DS.create(testModel1s);
        log.info("batch create test model1 ids:{}", batchCreateResult);

        /**
         * 关联创建, 按子父顺序创建
         */
        TestModel2 testModel2 = new TestModel2();
        //create接口会自动将创建完获取的id塞到TestModel2对象中
        DS.create(testModel2);
        testModel1.setTestModel2(testModel2);
        DS.create(testModel1);

        /**
         * 关联创建：预取子模型id方式
         */
        TestModel2 testModel2New = new TestModel2();
        Long testModel2Id = DS.nextId(TestModel2.class);
        testModel2New.setId(testModel2Id);
        testModel1.setTestModel2(testModel2);
        DS.create(testModel1);
        DS.create(testModel2New);
    }
}
