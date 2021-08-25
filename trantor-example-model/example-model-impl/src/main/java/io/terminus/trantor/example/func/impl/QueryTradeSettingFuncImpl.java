package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.QueryTradeSettingFunc;
import io.terminus.trantor.example.model.setting.TradeSetting;
import io.terminus.trantorframework.api.annotation.FunctionImpl;

/**
 * @author hzj273812（黄子敬）
 * @email hzj273812@alibaba-inc.com
 * @create 2021/6/30 下午4:20
 **/
@FunctionImpl
public class QueryTradeSettingFuncImpl implements QueryTradeSettingFunc {

    private TradeSetting tradeSetting;

    public QueryTradeSettingFuncImpl(TradeSetting tradeSetting) {
        this.tradeSetting = tradeSetting;
    }

    @Override
    public TradeSetting execute() {
        return this.tradeSetting;
    }
}
