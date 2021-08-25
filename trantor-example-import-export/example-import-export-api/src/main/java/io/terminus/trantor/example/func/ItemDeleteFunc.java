package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/3/10
 */
@Function(name = "商品删除函数")
public interface ItemDeleteFunc {
    void execute(ItemBO item);
}
