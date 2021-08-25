package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.ModelConfig;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;

import java.math.BigDecimal;

/**
 * @author DongZhao
 * Date:2021/5/14
 */
@Model(
        desc = "交易基础订单行模型",
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        )
)
public class OrderLineBO extends BaseModel<Long> {
    /**
     * 订单行编码
     */
    @TextMeta(length = 32, rule = "STRING(TOL)+TIMES(yyyyMMdd)+INCRE(1,6,4,1)")
    @Field(name = "Order line code", desc = "订单行编码")
    private String code;

    /**
     * 关联的交易订单
     */
    @LinkMeta
    @Field(name = "Order", desc = "关联的订单")
    private OrderBO order;

    /**
     * 交易数量
     */
    @Field(name = "Quantity", desc = "交易数量")
    private BigDecimal quantity;

    /**
     * sku
     */
    @Field(name = "Sku", type = FieldType.Json, desc = "Sku")
    private ItemBO sku;
}
