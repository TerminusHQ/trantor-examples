package io.terminus.trantor.example.busicontext;

import io.terminus.trantorframework.api.annotation.FunctionImpl;
import lombok.AllArgsConstructor;

/**
 * @author stan
 * @date 2021/5/8
 */
@FunctionImpl
@AllArgsConstructor
public class TestFuncImpl implements TestFunc {

    private final TestContext testContext;

    @Override
    public void execute() {
        System.out.println(testContext.getCurrentUser());
    }
}
