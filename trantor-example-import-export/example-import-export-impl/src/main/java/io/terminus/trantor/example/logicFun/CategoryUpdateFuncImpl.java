package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.CategoryUpdateFunc;
import io.terminus.trantor.example.model.CategoryBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "商品类别创建函数")
public class CategoryUpdateFuncImpl implements CategoryUpdateFunc {
    @Override
    public CategoryBO execute(CategoryBO category) {
        //商品特性更新
        DS.update(category);
        return category;
    }
}