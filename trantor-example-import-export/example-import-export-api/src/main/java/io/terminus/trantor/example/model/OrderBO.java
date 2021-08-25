package io.terminus.trantor.example.model;

import io.terminus.trantor.example.dict.PayStatusDict;
import io.terminus.trantor.module.base.model.User;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LookupMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import io.terminus.trantorframework.api.type.Currency;
import lombok.Data;

import java.util.List;

/**
 * @author DongZhao
 * Date:2021/5/14
 */
@Data
@Model(
        name = "订单",
        indexes = {
                @Index(name = "order_code_index", columns = {OrderBO.code_field}, unique = true)
        },
        mainField = OrderBO.code_field,
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        )
)
public class OrderBO extends BaseModel<Long> {

    /**
     * 订单编码
     */
    @TextMeta(length = 32, rule = "STRING(TRO)+TIMES(yyyyMMdd)+INCRE(1,6,4,1)")
    @Field(name = "订单编码", desc = "订单编码", nullable = false)
    private String code;

    @Field(name = "标题")
    @TextMeta(length = 64)
    private String title;

    @Field(name = "购买人")
    @TextMeta(length = 128)
    private User buyer;

    /**
     * 支付金额
     */
    @Transient
    @Field(name = "Amount", desc = "金额")
    private Currency paidAmount;

    /**
     * 店铺运费总额
     */
    @Field(name = "Shipping amount")
    private Currency shippingAmount = new Currency(0);

    /**
     * 支付状态
     */
    @DictionaryMeta(PayStatusDict.class)
    @Field(name = "Pay status", desc = "支付状态", defaultValue = PayStatusDict.UNPAID)
    private String payStatus;

    /**
     * 关联的订单行
     */
    @LookupMeta
    @Field(name = "Order line list")
    private List<OrderLineBO> tradeOrderLineList;


}
