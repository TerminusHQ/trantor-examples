package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.CategoryCreateFunc;
import io.terminus.trantor.example.model.CategoryBO;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "商品类别创建函数")
public class CategoryCreateFuncImpl implements CategoryCreateFunc {

    @Override
    public CategoryBO execute(CategoryBO category) {
        IntResult result = DS.create(category);
        category.setId(result.getValue().longValue());
        return category;
    }
}
