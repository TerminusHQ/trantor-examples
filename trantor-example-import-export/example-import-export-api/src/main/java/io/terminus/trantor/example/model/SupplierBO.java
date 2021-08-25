package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.ModelConfig;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import lombok.Data;

/**
 * 供应商
 * @author DongZhao
 * Date:2021/6/22
 */
@Data
@Model(
        name = "供应商",
        mainField = SupplierBO.name_field,
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        )
)
public class SupplierBO extends BaseModel<Long> {

    @Field(name = "code", nullable = false)
    private String code;

    @Field(name = "name", nullable = false)
    private String name;

    @Field(name = "mobile",type = FieldType.Phone)
    private String mobile;

    @Field(name = "供应商品")
    @LinkMeta
    private ItemBO item;
}