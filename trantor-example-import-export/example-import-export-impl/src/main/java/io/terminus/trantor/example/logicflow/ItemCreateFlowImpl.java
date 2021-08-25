package io.terminus.trantor.example.logicflow;

import io.terminus.trantor.example.flow.ItemCreateFlow;
import io.terminus.trantor.example.func.ItemCreateFun;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import org.springframework.beans.factory.annotation.Autowired;

@FlowImpl(name = "食品类订单配送模式实现类")
@RouteRuleValue({"food"})
public class ItemCreateFlowImpl implements ItemCreateFlow {

    @Autowired
    private ItemCreateFun itemCreateFun;

    /**
     * 商品创建方法
     * @param item
     * @return
     */
    @Override
    public ItemBO execute(ItemBO item) {
        //创建商品
        ItemBO result = itemCreateFun.execute(item);
        return result;
    }
}
