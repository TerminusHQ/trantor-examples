package io.terminus.trantor.example.tmodel;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.ModelConfig;
import io.terminus.trantorframework.api.annotation.TransientModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author bolin
 * @date 2021/2/1 17:02
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TransientModel(
        name = "店铺模型",
        config = @ModelConfig(
                enableImport = true,
                enableExport = true
        )
)
public class ShopTO extends BaseModel<Long> {
    private static final long serialVersionUID = 8032034866331050575L;

    @Field(name = "店铺名称")
    private String name;
}
