package io.terminus.trantor.example.job;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Model(name = "商品")
public class ItemBO extends BaseModel<Long> {
    @Field(name = "商品名称")
    private String itemName;

    @Field(name = "商品详细描述")
    private String desc;
}
