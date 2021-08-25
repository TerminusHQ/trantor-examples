package io.terminus.trantor.example.model;

import io.terminus.trantor.example.dict.ItemTypeDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.*;
import io.terminus.trantorframework.api.type.Attachment;
import lombok.*;

/**
 * @author DongZhao
 * Date:2021/3/9
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Model(
        name = "商品特性",
        mainField = SpuBO.name_field,
        deleteStrategy = DeleteStrategy.Logical,
        indexes = {
                @Index(name = "spu_code_index", columns = {SpuBO.spuCode_field}, unique = true)
        },
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        ))
public class SpuBO extends BaseModel<Long> {
    private static final long serialVersionUID = 8051312668964123329L;

    @Field(name = "spu编码", nullable = false)
    private String spuCode;

    @Field(name = "商品计量单位")
    @TextMeta(length = 64)
    private String unit;

    @Field(name = "类目id", type = FieldType.Json)
    private CategoryBO category;

    @Field(name = "商品")
    @LinkMeta
    private ItemBO item;

    @Field(name = "品牌名称")
    @TextMeta(length = 128)
    private String brandName;

    @Field(name = "商品名称", nullable = false)
    @TextMeta(length = 128)
    private String name;

    @DictionaryMeta(ItemTypeDict.class)
    @Field(name = "商品类型")
    private String itemTypeDict;

    @Field(name = "商品主图url", type = FieldType.Image)
    @TextMeta(length = 512)
    private String mainImage;

    @Field(name = "mainImageAttachment")
    @Transient
    @AttachmentMeta(countLimit = 9, maxSize = 1024)
    private Attachment mainImageAttachment;

}
