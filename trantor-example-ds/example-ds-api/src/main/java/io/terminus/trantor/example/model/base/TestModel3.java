package io.terminus.trantor.example.model.base;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.DeleteStrategy;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import lombok.Data;

/**
 * @author weichao
 * @date 6/7/21 2:04 PM
 * @Description: 测试模型3
 **/
@Data
@Model(
        name = "test model3",
        mainField = TestModel3.stringField_field,
        deleteStrategy = DeleteStrategy.Logical
)
public class TestModel3 extends BaseModel<Long> {

    @Field(name = "string field", nullable = false)
    private String stringField;
}
