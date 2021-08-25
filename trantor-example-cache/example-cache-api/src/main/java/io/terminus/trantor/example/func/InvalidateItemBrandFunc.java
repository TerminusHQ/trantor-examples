package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.module.base.model.BusinessMessage;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "invalidate item brand function")
public interface InvalidateItemBrandFunc {
    BusinessMessage execute(ItemBO item);
}
