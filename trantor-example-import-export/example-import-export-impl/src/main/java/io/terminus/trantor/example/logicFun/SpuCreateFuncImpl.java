package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.SpuCreateFunc;
import io.terminus.trantor.example.model.SpuBO;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/1/27
 */

@FunctionImpl(name = "商品特性创建函数")
public class SpuCreateFuncImpl implements SpuCreateFunc {

    @Override
    public SpuBO execute(SpuBO spu) {
        IntResult result = DS.create(spu);
        spu.setId(result.getValue().longValue());
        return spu;
    }
}
