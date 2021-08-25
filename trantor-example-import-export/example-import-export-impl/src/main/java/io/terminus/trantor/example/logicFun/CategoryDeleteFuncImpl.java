package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.CategoryDeleteFunc;
import io.terminus.trantor.example.model.CategoryBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author DongZhao
 * Date:2021/3/10
 */
@FunctionImpl(name = "商品类别创建函数")
public class CategoryDeleteFuncImpl implements CategoryDeleteFunc {
    @Override
    public  void execute(CategoryBO category){
        DS.delete(category);
    }
}
