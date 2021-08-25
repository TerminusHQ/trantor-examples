package io.terminus.trantor.example.cache.impl;

import io.terminus.trantor.example.cache.ItemBrandCache;
import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.CacheImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CacheImpl(name = "Item cache", expire = 30 * 60 * 1000)
public class ItemBrandCacheImpl implements ItemBrandCache {

    @Override
    public BrandBO get(ItemBO item) {
        log.info("Query brand info from DB and cache it");
        ItemBO itemBO = DS.findOne(
                ItemBO.class, "*, brand.*", "id = ?", item.getId()
        );
        return null == itemBO ? null : itemBO.getBrand();
    }
}
