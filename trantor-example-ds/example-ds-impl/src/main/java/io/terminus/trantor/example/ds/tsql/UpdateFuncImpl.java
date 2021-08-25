package io.terminus.trantor.example.ds.tsql;

import io.terminus.trantor.example.func.base.tsql.UpdateFunc;
import io.terminus.trantor.example.model.base.TestModel1;
import io.terminus.trantorframework.sdk.sql.DS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: SDK更新demo
 **/
public class UpdateFuncImpl implements UpdateFunc {
    @Override
    public void update() {

        /**
         * 更新模型,会忽略值为null的属性
         */
        TestModel1 testModel1 = new TestModel1();
        testModel1.setId(1L);
        testModel1.setLongField(1L);
        testModel1.setStringField("test");
        DS.update(testModel1);

        /**
         * 批量更新模型，会忽略值为null的属性
         */
        List<TestModel1> testModel1List = new ArrayList<>();
        testModel1List.add(testModel1);
        DS.update(testModel1List);

        /**
         * 更新模型,不会忽略值为null的属性
         */
        DS.updateWithNull(testModel1);

        /**
         * 批量更新模型,不会忽略值为null的属性
         */
        DS.updateWithNull(testModel1List);

        /**
         * upsert操作，会忽略值为null的属性
         * 注：内部实现是通过模型对象中id是否设置值来决定是走create操作还是update操作
         */
        TestModel1 createTestModel1 = new TestModel1();
        createTestModel1.setStringField("test");
        //没有设置id值，走create操作
        DS.save(createTestModel1);

        TestModel1 updateTestModel1 = new TestModel1();
        updateTestModel1.setId(1L);
        updateTestModel1.setStringField("test1");
        //设置了id值，走update操作
        DS.save(updateTestModel1);

        /**
         * upsert操作，不会忽略值为null的属性
         * 注：内部实现是通过模型对象中id是否设置值来决定是走create操作还是update操作
         */
        TestModel1 createTestModel1WithNull = new TestModel1();
        createTestModel1WithNull.setStringField("test");
        //没有设置id值，走create操作
        DS.saveWithNull(createTestModel1WithNull);

        TestModel1 updateTestModel1WithNull = new TestModel1();
        updateTestModel1WithNull.setId(1L);
        updateTestModel1WithNull.setStringField("test1");
        //设置了id值，走update操作
        DS.saveWithNull(updateTestModel1WithNull);


    }
}

