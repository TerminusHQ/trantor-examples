package io.terminus.trantor.example.flow;

import io.terminus.trantor.example.model.Position;
import io.terminus.trantorframework.api.annotation.Flow;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
/**
 * 注解内的 position.type 为路由规则，符合 MVEL 表达式规范，其中 position 为入参名称， type 为入参对象类型 Staff 内的字段名称。
 * 其中postType仅支持Dictionary、Mult Dictionary、Boolean三种类型
 */

@Flow(name = "Crete position flow")
public interface CreatePositionFlow {

    Position execute(Position position);

}

