package io.terminus.trantor.example.logicFun;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.example.func.ItemCreateFun;
import io.terminus.trantor.example.func.SpuCreateFunc;
import io.terminus.trantor.example.model.CategoryBO;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.flow.LF;
import io.terminus.trantorframework.sdk.sql.DS;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "")
public class ItemCreateFunImpl implements ItemCreateFun {

    private SpuCreateFunc spuCreateFunc;

    @Override
    @DSTransaction
    public ItemBO execute(ItemBO item) {
        CategoryBO categoryBO = new CategoryBO();
        categoryBO.setId(1L);
        categoryBO.setName("fruit");
        categoryBO.setCode("f1");
        //设置商品创建时刻的快照信息，更新时不改变，测试Json类型字段导出
        item.setSnapshotCategory(categoryBO);
        IntResult result = DS.create(item);

        item.setId(result.getValue().longValue());

        if(!CollectionUtils.isEmpty(item.getSpuList())){
            LF.foreach(item.getSpuList(), spu -> {
                spu.setItem(item);
                spuCreateFunc.execute(spu);
            });
        }

        if(!CollectionUtils.isEmpty(item.getSupplierList())){
            LF.foreach(item.getSupplierList(), supplier -> {
                supplier.setItem(item);
                DS.create(supplier);
            });
        }
        return item;
    }
}
