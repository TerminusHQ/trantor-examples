package io.terminus.trantor.example.model.business;

import io.terminus.trantor.example.dict.ItemTypeDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.CurrencyMeta;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.ImageMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import io.terminus.trantorframework.api.type.Currency;
import lombok.Data;

import java.util.List;

@Data
@Model(name = "Item business model", mainField = ItemBO.itemName_field)
public class ItemBO extends BaseModel<Long> {

    @Field(name = "Item code", nullable = false)
    private String itemCode;

    @Field(name = "Item name", nullable = false)
    private String itemName;

    @Field(name = "Item type", type = FieldType.MultiDictionary)
    @DictionaryMeta(ItemTypeDict.class)
    private List<String> itemType;

    @Field(name = "Item description")
    private String itemDesc;

    @ImageMeta
    @Field(name = "Item image", type = FieldType.Image)
    private String itemImage;

    @Field(name = "Item price", nullable = false, type = FieldType.Currency)
    @CurrencyMeta(intDigits = 12, decimalDigits = 4)
    private Currency itemPrice;

    // 通过 @LinkMeta 声明与其他模型实体的关联关系
    @Field(name = "item category", nullable = false)
    @LinkMeta
    private ItemCategoryBO categoryBO;
}
