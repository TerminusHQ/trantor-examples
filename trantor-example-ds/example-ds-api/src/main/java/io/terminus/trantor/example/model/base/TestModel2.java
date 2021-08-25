package io.terminus.trantor.example.model.base;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.DeleteStrategy;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import lombok.Data;

/**
 * @author weichao
 * @date 6/7/21 2:04 PM
 * @Description: 测试模型2
 **/
@Data
@Model(
        name = "test model2",
        mainField = TestModel2.stringField_field,
        deleteStrategy = DeleteStrategy.Logical
)
public class TestModel2 extends BaseModel<Long> {

    @Field(name = "string field", nullable = false)
    private String stringField;

    /**
     * 通过 @LinkMeta 声明与其他模型实体的关联关系
     */
    @Field(name = "test model3", nullable = false)
    @LinkMeta
    private TestModel3 testModel3;
}
