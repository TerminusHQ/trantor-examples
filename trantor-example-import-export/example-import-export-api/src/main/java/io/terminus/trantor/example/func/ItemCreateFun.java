package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/1/27
 */

@Function(name = "商品创建函数")
public interface ItemCreateFun {
    ItemBO execute(ItemBO item);
}
