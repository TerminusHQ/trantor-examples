package io.terminus.trantor.example.model.business;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import lombok.Data;

@Data
@Model(name = "交易配置")
public class TradeConfig extends BaseModel<Long> {

    @Field(name = "交易编码前缀")
    private String tradeNumberPrefix;

    @Field(name = "交易超时时间")
    private Long tradeTimeout;

    @Field(name = "支付超时时间")
    private Long paymentTimeout;
}
