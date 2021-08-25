package io.terminus.trantor.example.logicflow;

import io.terminus.trantor.example.flow.ItemCreateFlow;
import io.terminus.trantor.example.func.ItemCreateFun;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@FlowImpl(name = "电子产品订单配送模式实现类")
@RouteRuleValue({"electronics"})
public class ElecItemCreateFlowImpl implements ItemCreateFlow {

    private final ItemCreateFun itemCreateFun;

    /**
     * 电子产品订单处理流程
     * @param item
     * @return
     */
    @Override
    public ItemBO execute(ItemBO item) {
        //商品创建
        ItemBO result = itemCreateFun.execute(item);
        return result;
    }


}
