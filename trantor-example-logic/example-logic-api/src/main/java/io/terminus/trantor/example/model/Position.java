package io.terminus.trantor.example.model;

import io.terminus.trantor.example.dict.PositionType;
import io.terminus.trantor.module.base.enums.OrgStatus;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
@EqualsAndHashCode(callSuper = true)
@Model(
        name = "岗位模型",
        mainField = Position.name_field
)
@Data
public class Position extends BaseModel<Long> {

    @Field(name = "岗位编码")
    @TextMeta(rule = "STRING(POS)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;

    @Field(name = "岗位名称")
    @NotNull(message = "岗位名称不能为空")
    private String name;

    @Field(name = "岗位类型", defaultValue = PositionType.primary, nullable = false)
    @DictionaryMeta(value = PositionType.class)
    @NotNull(message = "岗位类型不能为空")
    private String type;

    @Field(name = "岗位详情", type = FieldType.RichText)
    private String remark;

    @Field(name = "状态", defaultValue = "Enable", nullable = false)
    private OrgStatus status;

}
