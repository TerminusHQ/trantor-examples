package io.terminus.trantor.example.logicflow;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.example.flow.ItemUpdateFlow;
import io.terminus.trantor.example.func.ItemCreateFun;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.example.model.query.QItemBO;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.querymodel.type.support.QString;
import io.terminus.trantorframework.sdk.flow.LF;
import io.terminus.trantorframework.sdk.sql.DS;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;


@FlowImpl(name = "商品更新实现类")
public class ItemUpdateFlowImpl implements ItemUpdateFlow {

    @Autowired
    private ItemCreateFun itemCreateFun;

    @Override
    @DSTransaction
    public ItemBO execute(ItemBO itemBo) {
        QItemBO qItemBO = new QItemBO();
        qItemBO.setItemCode(new QString(itemBo.getItemCode()));
        ItemBO updateItem = DS.findOne(qItemBO);
        itemBo.setId(updateItem.getId());
        //商品更新
        DS.update(itemBo);

        if(!CollectionUtils.isEmpty(itemBo.getSpuList())){
            LF.foreach(itemBo.getSpuList(), spu -> {
                spu.setItem(itemBo);
                DS.save(spu);
            });
        }

        if(!CollectionUtils.isEmpty(itemBo.getSupplierList())){
            LF.foreach(itemBo.getSupplierList(), supplier -> {
                supplier.setItem(itemBo);
                DS.save(supplier);
            });
        }
        return itemBo;
    }
}
