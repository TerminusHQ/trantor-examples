package io.terminus.trantor.example.busicontext;

import io.terminus.trantor.module.base.model.User;
import io.terminus.trantorframework.api.annotation.BusinessContextImpl;
import io.terminus.trantorframework.sdk.context.TContext;


/**
 * 业务上下文最简单的实现
 */
@BusinessContextImpl
public class TestContextImpl implements TestContext {

    /**
     * 业务上下文里边可以通过 TContext.getCurrentUser() 获取到当前用户
     * 该例子中主要是给 flow/func 调用， 可以直接postman 调用 TestFunc 触发
     */
    @Override
    public User getCurrentUser() {
        return TContext.getCurrentUser();
    }

    /**
     * 同时可以响应一些上下文实体，给页面作为过滤条件
     * <p>可以通过该表达式去做过滤 @context.example_busicontext_TestContext.getItem.itemName</p>
     */
    @Override
    public ItemBO getItem() {
        ItemBO itemBO = new ItemBO();
        itemBO.setItemName("filter");
        return itemBO;
    }


}
