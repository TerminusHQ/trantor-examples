package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.CategoryBO;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/3/10
 */
@Function(name = "商品类别删除函数")
public interface CategoryDeleteFunc {
    void execute(CategoryBO category);
}
