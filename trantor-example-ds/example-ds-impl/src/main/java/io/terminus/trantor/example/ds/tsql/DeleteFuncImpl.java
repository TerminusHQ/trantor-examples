package io.terminus.trantor.example.ds.tsql;

import io.terminus.trantor.example.func.base.tsql.DeleteFunc;
import io.terminus.trantor.example.model.base.TestModel1;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: SDK删除demo
 **/
@Slf4j
public class DeleteFuncImpl implements DeleteFunc {
    @Override
    public void delete() {

        /**
         * 根据模型删除，本质上是根据id
         */
        TestModel1 testModel1 = new TestModel1();
        testModel1.setId(1L);
        BooleanResult deleteByModelResult = DS.delete(testModel1);
        log.info("delete result:{}", deleteByModelResult.getValue());

        /**
         * 根据id删除
         */
        BooleanResult deleteByIdResult = DS.delete(TestModel1.class, 1L);
        log.info("delete result:{}", deleteByIdResult.getValue());

        /**
         * 根据id批量删除
         */
        List<Long> deleteIds = new ArrayList<>();
        deleteIds.add(1L);
        deleteIds.add(2L);
        DS.delete(TestModel1.class, deleteIds);

        /**
         * 条件删除，请使用DSL
         */

    }
}
