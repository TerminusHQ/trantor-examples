package io.terminus.trantor.example.ds.dsl;

import io.terminus.trantor.example.func.base.dsl.CreateFunc;

/**
 * @author weichao
 * @date 6/4/21 11:19 AM
 * @Description: TODO
 **/
public class CreateFuncImpl implements CreateFunc {
    @Override
    public void create() {
        //DSL 不支持Create,Create操作建议使用DS.create(Model model)相关接口，比较方便。
    }
}
