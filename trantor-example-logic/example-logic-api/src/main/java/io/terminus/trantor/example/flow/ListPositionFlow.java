package io.terminus.trantor.example.flow;

import io.terminus.trantor.module.base.model.Position;
import io.terminus.trantorframework.api.annotation.AnonymousAccess;
import io.terminus.trantorframework.api.annotation.Flow;

import java.util.List;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
@AnonymousAccess
@Flow(name = "List position flow")
public interface ListPositionFlow {

    List<Position> execute(Position position);

}
