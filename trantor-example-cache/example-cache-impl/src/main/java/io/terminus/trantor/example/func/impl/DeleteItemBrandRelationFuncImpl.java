package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.DeleteItemBrandRelationFunc;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.module.base.model.BusinessMessage;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

@FunctionImpl
public class DeleteItemBrandRelationFuncImpl implements DeleteItemBrandRelationFunc {
    @Override
    public BusinessMessage execute(ItemBO itemBO) {
        itemBO.setBrand(null);
        BooleanResult booleanResult = DS.updateWithNull(itemBO);
        if (booleanResult.getValue()) {
            return BusinessMessage.success("解除品牌关联成功");
        }
        return BusinessMessage.error("解除品牌关联失败");
    }
}
