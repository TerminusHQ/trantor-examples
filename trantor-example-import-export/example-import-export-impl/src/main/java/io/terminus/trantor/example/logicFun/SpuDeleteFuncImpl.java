package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.SpuDeleteFunc;
import io.terminus.trantor.example.model.SpuBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/3/10
 */
@FunctionImpl(name = "商品特性创建函数")
public class SpuDeleteFuncImpl implements SpuDeleteFunc {
    @Override
    public  void execute(SpuBO spu){
        DS.delete(spu);
    }
}
