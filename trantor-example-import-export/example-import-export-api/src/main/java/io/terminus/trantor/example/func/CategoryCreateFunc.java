package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.CategoryBO;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/1/27
 */

@Function(name = "商品类别创建函数")
public interface CategoryCreateFunc {

    CategoryBO execute(CategoryBO category);
}
