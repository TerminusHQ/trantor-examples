package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Position;
import io.terminus.trantorframework.api.annotation.Function;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */

@RouteRuleMatch("position.type")
@Function(name = "create position function")
public interface CreatePositionFunc {

    Position execute(Position position);

}
