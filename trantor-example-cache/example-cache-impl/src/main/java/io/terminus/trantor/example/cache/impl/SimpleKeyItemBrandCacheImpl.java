package io.terminus.trantor.example.cache.impl;

import io.terminus.trantor.example.cache.SimpleKeyItemBrandCache;
import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.CacheImpl;
import io.terminus.trantorframework.sdk.sql.DS;

@CacheImpl(name = "Item cache", expire = 30 * 60 * 1000)
public class SimpleKeyItemBrandCacheImpl implements SimpleKeyItemBrandCache {

    @Override
    public BrandBO get(Long id) {
        ItemBO itemBO = DS.findOne(
                ItemBO.class, "*, brand.*", "id = ?", id
        );
        return null == itemBO ? null : itemBO.getBrand();
    }
}
