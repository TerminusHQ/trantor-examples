package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.module.base.model.BusinessMessage;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "delete item and brand relation")
public interface DeleteItemBrandRelationFunc {
    BusinessMessage execute(ItemBO itemBO);
}
