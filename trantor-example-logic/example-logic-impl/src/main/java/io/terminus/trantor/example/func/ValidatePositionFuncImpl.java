package io.terminus.trantor.example.func;

import io.terminus.trantor.example.msg.PositionMsg;
import io.terminus.trantor.example.model.Position;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;

import java.util.Objects;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
@FunctionImpl(name = "validate position func impl")
public class ValidatePositionFuncImpl implements ValidatePositionFunc {

    @Override
    public void execute(Position position) {
        if (Objects.isNull(position)) {
            throw new BusinessException(PositionMsg.EX_POSITION_ISNULL);
        }
    }

}
