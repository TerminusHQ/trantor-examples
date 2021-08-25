package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString(callSuper = true)
@Model(
        name = "员工信息",
        mainField = "staffName"
)
public class Staff extends BaseModel<Long> {

    @TextMeta(rule = "STRING(STAFF)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    @Field(name = "员工编号")
    private String staffNumber;

    @Field(name = "员工名称")
    private String staffName;

    @Field(name = "员工手机号", type = FieldType.Phone, nullable = false)
    @NotNull(message = "手机号不能为空")
    private String staffMobile;

    @Field(name = "员工邮箱", type = FieldType.Email)
    private String StaffEmail;

    @Field(name = "个人介绍")
    private String staffDesc;

}

