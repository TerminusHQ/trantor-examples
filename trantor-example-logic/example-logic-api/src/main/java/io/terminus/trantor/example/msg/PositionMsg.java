package io.terminus.trantor.example.msg;

import io.terminus.trantorframework.api.annotation.Message;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
public interface PositionMsg {

    /**
     * Position为空
     */
    @Message("Position is null")
    String EX_POSITION_ISNULL = "Example.Position.IsNull";

    /**
     * Position中的id为空
     */
    @Message("Position id is null")
    String EX_POSITION_ID_ISNULL = "Example.Position.Id.IsNull";

    /**
     * Position 未找到
     */
    @Message("Position ${id} not found")
    String EX_POSITION_NOT_FOUND = "Example.Position.not.found";

}
