package io.terminus.trantor.example.flow;

import io.terminus.trantor.example.dict.PositionType;
import io.terminus.trantor.example.func.CreatePositionFunc;
import io.terminus.trantor.example.func.ValidatePositionFunc;
import io.terminus.trantor.example.model.Position;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */

@FlowImpl(name = "create other position with dynamic route")
public class CreatePositionFlowImpl implements CreatePositionFlow {

    private ValidatePositionFunc validatePositionFunc;
    private CreatePositionFunc createPositionFunc;

    @Override
    public Position execute(Position position) {
        // 参数防御
        validatePositionFunc.execute(position);

        // 创建岗位
        Position result = createPositionFunc.execute(position);
        return result;
    }
}
