package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.TradeConfigFunc;
import io.terminus.trantor.example.model.business.TradeConfig;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

@FunctionImpl(name = "trade config func")
public class TradeConfigFuncImpl implements TradeConfigFunc {
    @Override
    public TradeConfig execute(TradeConfig tradeConfig) {
        DS.save(tradeConfig);
        return tradeConfig;
    }
}
