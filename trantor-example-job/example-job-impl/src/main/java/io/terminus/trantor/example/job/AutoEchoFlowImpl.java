package io.terminus.trantor.example.job;

import io.terminus.trantorframework.api.annotation.FlowImpl;
import lombok.AllArgsConstructor;

/**
 * @author stan
 * @date 2021/7/15
 */
@FlowImpl
@AllArgsConstructor
public class AutoEchoFlowImpl implements AutoEchoFlow {

    @Override
    public void execute() {
        System.out.println("hello world from job!");
    }
}
