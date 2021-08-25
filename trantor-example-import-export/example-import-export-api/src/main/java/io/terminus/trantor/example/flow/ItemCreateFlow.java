package io.terminus.trantor.example.flow;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.Flow;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@Flow(name = "商品创建流程")
@RouteRuleMatch("item.itemType")
public interface ItemCreateFlow {
    ItemBO execute(ItemBO item);
}