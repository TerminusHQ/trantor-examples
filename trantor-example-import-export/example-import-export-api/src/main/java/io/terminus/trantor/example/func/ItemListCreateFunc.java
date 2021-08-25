package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.Function;

import java.util.List;

/**
 * @author DongZhao
 * Date:2021/1/27
 */

@Function(name = "商品批量创建函数")
public interface ItemListCreateFunc {
    List<ItemBO> execute(List<ItemBO> items);
}
