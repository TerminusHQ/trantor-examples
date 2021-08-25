package io.terminus.trantor.example.flow;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@Flow(name = "商品更新流程")
public interface ItemUpdateFlow {
    ItemBO execute(ItemBO itemBo);
}