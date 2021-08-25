package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.setting.TradeSetting;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author hzj273812（黄子敬）
 * @email hzj273812@alibaba-inc.com
 * @create 2021/6/30 下午4:19
 **/
@Function
public interface QueryTradeSettingFunc {
    TradeSetting execute();
}
