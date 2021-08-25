package io.terminus.trantor.example.dynamicview;

import io.terminus.trantorframework.api.DynamicModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Model(name = "用户", mainField = "name")
@EqualsAndHashCode(callSuper = true)
public class MyUser extends DynamicModel<Long> {

    @Field(name = "名称")
    private String name;

    @Field(name = "年龄")
    private Integer age;

}
