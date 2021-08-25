package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.ItemDeleteFunc;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "")
public class ItemDeleteFunImpl implements ItemDeleteFunc {

    @Override
    public void execute(ItemBO item) {
        DS.delete(item);
    }

}
