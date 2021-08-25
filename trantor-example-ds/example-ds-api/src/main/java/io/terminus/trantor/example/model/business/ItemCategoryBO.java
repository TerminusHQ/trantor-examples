package io.terminus.trantor.example.model.business;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import lombok.Data;

/**
 * @author tianhuannan
 */
@Data
@Model(name = "Item category", mainField = ItemCategoryBO.name_field)
public class ItemCategoryBO extends BaseModel<Long> {

    @Field(name = "category code", nullable = false)
    private String code;
    @Field(name = "category name", nullable = false)
    private String name;
}
