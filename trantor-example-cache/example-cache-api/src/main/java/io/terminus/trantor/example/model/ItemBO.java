package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.ImageMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Model(name = "商品", mainField = ItemBO.itemName_field)
public class ItemBO extends BaseModel<Long> {

    @Field(name = "商品名称")
    private String itemName;

    @Field(name = "商品编号")
    private String itemNumber;

    @Field(name = "商品详细描述")
    private String itemDesc;

    @ImageMeta
    @Field(name = "商品图片")
    private String itemImage;

    @Field(name = "商品价格")
    private BigDecimal itemPrice;

    @Field(name = "品牌")
    @LinkMeta
    private BrandBO brand;
}
