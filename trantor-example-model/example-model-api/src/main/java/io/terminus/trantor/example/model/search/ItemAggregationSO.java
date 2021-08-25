package io.terminus.trantor.example.model.search;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.SearchModel;
import io.terminus.trantorframework.api.type.Currency;
import lombok.Data;

/**
 * @author hzj273812（黄子敬）
 * @email hzj273812@alibaba-inc.com
 * @create 2021/5/28 下午2:26
 **/
@Data
@Model
@SearchModel(name = "Item aggregation search model object")
public class ItemAggregationSO extends BaseModel<Long> {

    @Field(name = "商品名称")
    private String itemName;
    @Field(name = "品牌名称")
    private String brandName;
    @Field(name = "分类名称")
    private String categoryName;
    @Field(name = "商品价格")
    private Currency itemPrice;
}