package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "query item brand function")
public interface QueryItemBrandFunc {
    BrandBO execute(ItemBO item);
}
