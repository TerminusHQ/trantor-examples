package io.terminus.trantor.example.model;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
import io.terminus.trantor.example.dict.ApplicablePopulation;
import io.terminus.trantor.example.dict.ItemTypeDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.*;
import lombok.Data;

import java.util.List;


@Data
@Model(
        name = "商品",
        indexes = {
                @Index(name = "item_code_index",columns ={ItemBO.itemCode_field},unique = true)
        },
        mainField = ItemBO.itemName_field,
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        )
)
public class ItemBO extends BaseModel<Long> {

    @Field(name = "商品特性")
    @LinkMeta
    private SpuBO spu;

    @Field(name = "商品编码", nullable = false)
    @TextMeta(length = 64)
    private String itemCode;

    @Field(name = "商品名称", nullable = false)
    @TextMeta(length = 128)
    private String itemName;

    @DictionaryMeta(ItemTypeDict.class)
    @Field(name = "商品类型", nullable = false)
    private String itemType;

    /**
     * 商品重量
     */
    @NumberMeta(unit = "g")
    @Field(name = "商品重量")
    private Integer itemWeight;


    @Field(name = "商品类别")
    @LinkMeta
    private CategoryBO category;

    @Field(name = "商品类别快照", type = FieldType.Json)
    private CategoryBO snapshotCategory;

    @Field(name = "商品描述")
    @TextMeta(length = 128)
    private String desc;

    @Field(name = "是否过期")
    @BooleanMeta(trueLabel = @Label(value = "过期"), falseLabel = @Label(value = "正常"))
    private Boolean expired;

    @Field(name = "使用人群")
    private ApplicablePopulation population;

    @Field(name = "商品特性列表")
    @LookupMeta
    private List<SpuBO> spuList;

    @Field(name = "供应商列表")
    @LookupMeta
    private List<SupplierBO> supplierList;
}


