package io.terminus.trantor.example.model.snapshot;

import io.terminus.trantor.example.dict.ItemTypeDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.SearchModel;
import io.terminus.trantorframework.api.annotation.Snapshot;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.ImageMeta;
import lombok.Data;

import java.math.BigDecimal;

// 声明此模型为搜索模型
// 当搜索模型同时声明了持久化模型时，在触发全量同步后，该模型会自动同步至该的搜索模型
// 如需关闭同步，可以通过 @SearchModel(searchSyncEnabled = false) 来声明
// 默认情况下，所有字段都会成为可搜索字段
@Data
@Model(name = "Item search model", snapshot = @Snapshot())
public class BrandBO extends BaseModel<Long> {

    @Field(name = "Item name")
    private String itemName;

    @Field(name = "Item number")
    private String itemNumber;

    @Field(name = "Item type")
    @DictionaryMeta(ItemTypeDict.class)
    private String itemType;

    @Field(name = "Item description")
    private String desc;

    @ImageMeta
    @Field(name = "Item image")
    private String itemImage;

    @Field(name = "Item price")
    private BigDecimal itemPrice;
}
