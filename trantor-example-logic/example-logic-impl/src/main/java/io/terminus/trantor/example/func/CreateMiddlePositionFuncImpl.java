package io.terminus.trantor.example.func;

import io.terminus.trantor.example.dict.PositionType;
import io.terminus.trantor.example.ext.GenerateIdExtension;
import io.terminus.trantor.example.model.Position;
import io.terminus.trantor.example.msg.PositionMsg;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
@Slf4j
@RouteRuleValue({PositionType.middle})
@FunctionImpl(name = "create position function impl")
public class CreateMiddlePositionFuncImpl implements CreatePositionFunc {

    private GenerateIdExtension generateIdExtension;

    @Override
    public Position execute(Position position) {
        log.info("create middle position: {}", position.toString());
        position.setCode(generateIdExtension.execute());
        IntResult id = DS.create(position);

        Position positionResult = DS.findById(Position.class, id.getValue().longValue());
        if (Objects.isNull(positionResult)) {
            throw new BusinessException(PositionMsg.EX_POSITION_NOT_FOUND, id);
        }
        return positionResult;
    }

}
