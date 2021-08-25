package io.terminus.trantor.example.setting.listener;

import io.terminus.trantor.example.func.TradeConfigFunc;
import io.terminus.trantor.example.model.business.TradeConfig;
import io.terminus.trantor.example.model.setting.TradeSetting;
import io.terminus.trantorframework.api.annotation.SettingListener;
import io.terminus.trantorframework.sdk.setting.FieldChangedEvent;
import io.terminus.trantorframework.sdk.setting.SettingChangedListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SettingListener(modelClass = TradeSetting.class, field = TradeSetting.tradeTimeout_field)
public class TradeSettingListener implements SettingChangedListener<Long> {

    private final TradeConfigFunc tradeConfigFunc;

    public TradeSettingListener(TradeConfigFunc tradeConfigFunc) {
        this.tradeConfigFunc = tradeConfigFunc;
    }

    @Override
    public void onChanged(FieldChangedEvent<Long> event) {
        log.info("TradeSetting has changed, change field: {}, old value: {}, new value: {}",
                TradeSetting.tradeTimeout_field, event.getOldValue(), event.getValue());
        // 获取到最新的配置, 做相应处理
        TradeConfig tradeConfig = new TradeConfig();
        tradeConfig.setTradeTimeout(event.getValue());
        this.tradeConfigFunc.execute(tradeConfig);
    }
}
