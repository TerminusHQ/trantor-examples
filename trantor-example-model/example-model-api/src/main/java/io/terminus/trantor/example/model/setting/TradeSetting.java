package io.terminus.trantor.example.model.setting;

import io.terminus.trantorframework.api.BaseSettingModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.SettingModel;
import lombok.Data;

@Data
@SettingModel(name = "交易相关的配置")
public class TradeSetting extends BaseSettingModel {

    @Field(name = "交易编码前缀")
    private String tradeNumberPrefix;

    @Field(name = "交易超时时间")
    private Long tradeTimeout;

    @Field(name = "支付超时时间")
    private Long paymentTimeout;
}
