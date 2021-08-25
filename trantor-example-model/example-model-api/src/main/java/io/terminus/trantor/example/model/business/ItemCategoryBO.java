package io.terminus.trantor.example.model.business;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.LookupMeta;
import lombok.Data;

import java.util.List;

@Data
@Model(name = "Item category", mainField = ItemCategoryBO.name_field)
public class ItemCategoryBO extends BaseModel<Long> {

    @Field(name = "category code", nullable = false)
    private String code;
    @Field(name = "category name", nullable = false)
    private String name;
    @Field(name = "商品", type = FieldType.LookupMany)
    @LookupMeta
    private List<ItemBO> itemBOS;
}
