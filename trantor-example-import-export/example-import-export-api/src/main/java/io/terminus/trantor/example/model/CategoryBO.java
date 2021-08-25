package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.ModelConfig;
import lombok.Data;

/**
 * @author DongZhao
 * Date:2021/3/9
 */

@Data
@Model(
        name = "商品类别",
        mainField = CategoryBO.name_field,
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        )
)
public class CategoryBO extends BaseModel<Long> {

    @Field(name = "code", nullable = false)
    private String code;

    @Field(name = "name", nullable = false)
    private String name;

    @Field(name = "description")
    private String desc;

    @Field(name = "timestamp")
    private Long timestamp;


}
