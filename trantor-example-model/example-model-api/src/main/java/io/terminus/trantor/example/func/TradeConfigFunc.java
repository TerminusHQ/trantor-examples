package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.business.TradeConfig;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "trade config func")
public interface TradeConfigFunc {

    TradeConfig execute(TradeConfig tradeConfig);

}
