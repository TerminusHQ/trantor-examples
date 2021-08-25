package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.cache.ItemBrandCache;
import io.terminus.trantor.example.func.InvalidateItemBrandFunc;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.module.base.model.BusinessMessage;
import io.terminus.trantorframework.api.annotation.FunctionImpl;

@FunctionImpl(name = "invalidate item brand")
public class InvalidateItemBrandFuncImpl implements InvalidateItemBrandFunc {

    // 通过构造方法自动注入
    private ItemBrandCache itemBrandCache;

    public InvalidateItemBrandFuncImpl(ItemBrandCache itemBrandCache) {
        this.itemBrandCache = itemBrandCache;
    }

    @Override
    public BusinessMessage execute(ItemBO item) {
        itemBrandCache.invalidate(item);
        return BusinessMessage.success("当前商品的品牌数据缓存已失效");
    }
}
