package io.terminus.trantor.example.logicflow;

import io.terminus.trantor.example.flow.ItemListDataFlow;
import io.terminus.trantor.example.func.ItemCreateFun;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.example.model.query.QItemBO;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FlowImpl(name = "商品列表数据")
public class ItemListDataFlowImpl implements ItemListDataFlow {

    @Autowired
    private ItemCreateFun itemCreateFun;

    @Override
    public List<ItemBO> execute(QItemBO itemBo) {
        //查询所有记录
        List<ItemBO> result = DS.findAll(itemBo);
        return result;
    }
}