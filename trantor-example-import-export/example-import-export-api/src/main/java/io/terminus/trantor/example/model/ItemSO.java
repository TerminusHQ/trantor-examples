package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.SearchModel;
import lombok.Data;

/**
 * @author DongZhao
 * Date:2021/6/22
 */
@Data
@SearchModel
@Model(name = "商品")
public class ItemSO extends BaseModel<Long> {

    @Field(name = "商品编码")
    private String itemCode;

    @Field(name = "商品名称")
    private String itemName;


}
