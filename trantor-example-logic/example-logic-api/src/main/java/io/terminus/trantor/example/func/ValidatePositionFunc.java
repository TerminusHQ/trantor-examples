package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Position;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * CreatePositionFlow 参数防御
 *
 * @author 孙城(苏仕)
 */
@Function(name = "CreatePositionFlow validate")
public interface ValidatePositionFunc {

    void execute(Position position);

}
