package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.SpuUpdateFunc;
import io.terminus.trantor.example.model.SpuBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "商品特性创建函数")
public class SpuUpdateFuncImpl implements SpuUpdateFunc {
    @Override
    public SpuBO execute(SpuBO spu) {
        //商品特性更新
        DS.update(spu);
        return spu;
    }
}