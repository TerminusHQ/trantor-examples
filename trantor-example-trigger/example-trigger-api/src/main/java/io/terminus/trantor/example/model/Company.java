package io.terminus.trantor.example.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Model(
        name = "公司模型"
)
public class Company extends BaseModel<Long> {

    @Field(name = "公司编码", nullable = false)
    private String companyCode;

    @Field(name = "公司名称", nullable = false)
    private String companyName;

    @Field(name = "职员人数", nullable = false)
    private Long staffNumber;

}
