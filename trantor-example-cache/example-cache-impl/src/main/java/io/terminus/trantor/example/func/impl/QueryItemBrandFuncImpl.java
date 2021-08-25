package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.cache.ItemBrandCache;
import io.terminus.trantor.example.func.QueryItemBrandFunc;
import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;

@FunctionImpl(name = "query item brand")
public class QueryItemBrandFuncImpl implements QueryItemBrandFunc {

    // 通过构造方法自动注入
    private ItemBrandCache itemBrandCache;

    public QueryItemBrandFuncImpl(ItemBrandCache itemBrandCache) {
        this.itemBrandCache = itemBrandCache;
    }

    @Override
    public BrandBO execute(ItemBO item) {
        return itemBrandCache.get(item);
    }
}
