package io.terminus.trantor.example.ds.dsl;

import io.terminus.datastore.dsl.Query;
import io.terminus.datastore.dsl.impl.TSQL;
import io.terminus.trantor.example.func.base.dsl.DeleteFunc;
import io.terminus.trantor.example.model.base.TestModel1;
import io.terminus.trantor.example.model.base.TestModel2;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: DSL 删除demo
 **/
@Slf4j
public class DeleteFuncImpl implements DeleteFunc {
    @Override
    public void delete() {

        /**
         * 根据当前模型id删除数据: delete from TestModel1 where id = 1
         */
        Query deleteById = TSQL.delete(TestModel1.class)
                .where(TSQL.field(TestModel1.id_field).eq(1));
        IntResult deleteResult = DS.delete(deleteById);
        log.info("delete by id result:{}", deleteResult.getValue());

        /**
         * 根据当前模型其他字段删除数据: delete from TestModel1 where stringField = 'test';
         */
        Query deleteByOtherField = TSQL.delete(TestModel1.class)
                .where(TSQL.field(TestModel1.stringField_field).eq("test"));
        IntResult deleteByOtherFieldResult = DS.delete(deleteByOtherField);
        log.info("delete by other field result:{}", deleteByOtherFieldResult.getValue());

        /**
         * 根据当前模型的link字段删除数据 delete from TestModel1 where testModel2.stringField = 'test';
         */
        Query deleteByLinkField = TSQL.delete(TestModel1.class)
                .where(TSQL.field(TestModel1.testModel2_field, TestModel2.stringField_field).eq("test"));
        IntResult deleteByLinkFieldResult = DS.delete(deleteByLinkField);
        log.info("delete by link field result:{}", deleteByLinkFieldResult.getValue());
    }
}
