package io.terminus.trantor.example.cache;

import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantorframework.api.annotation.Cache;
import io.terminus.trantorframework.api.cache.FunctionCache;

/**
 * 通过商品ID（ItemBO ID）获取品牌信息（BrandBO）
 **/
@Cache(name = "Brand cache", desc = "Get brand cache via item id")
public interface SimpleKeyItemBrandCache extends FunctionCache<Long, BrandBO> {

}
