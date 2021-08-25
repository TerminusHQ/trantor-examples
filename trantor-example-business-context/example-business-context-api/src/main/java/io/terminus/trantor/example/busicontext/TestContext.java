package io.terminus.trantor.example.busicontext;

import io.terminus.trantor.module.base.model.User;
import io.terminus.trantorframework.api.annotation.BusinessContext;

/**
 * 定义业务上下文
 * @author stan
 * @date 2021/3/14
 */
@BusinessContext
public interface TestContext {

    User getCurrentUser();


    ItemBO getItem();

}
