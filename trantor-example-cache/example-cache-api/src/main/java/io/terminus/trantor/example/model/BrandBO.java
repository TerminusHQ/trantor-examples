package io.terminus.trantor.example.model;


import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import lombok.Data;

@Data
@Model(name = "品牌", mainField = BrandBO.brandName_field)
public class BrandBO extends BaseModel<Long> {

    @Field(name = "品牌名称")
    private String brandName;

}
