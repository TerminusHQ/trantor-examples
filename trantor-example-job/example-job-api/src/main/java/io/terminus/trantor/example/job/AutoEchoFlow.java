package io.terminus.trantor.example.job;

import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author stan
 * @date 2021/5/8
 */
@Flow
public interface AutoEchoFlow {
    void execute();
}
