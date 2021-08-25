package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.ItemListCreateFunc;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

import java.util.List;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "商品批量创建函数")
public class ItemListCreateFunImpl implements ItemListCreateFunc {

    @Override
    public List<ItemBO> execute(List<ItemBO> items) {
        List<IntResult> ids = DS.create(items);
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setId(ids.get(i).getValue().longValue());
        }
        return items;
    }
}
