package io.terminus.trantor.example.model;


import io.terminus.trantor.example.dict.SexDict;
import io.terminus.trantor.example.dict.SubjectDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Index;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Collection;


/**
 * @author ymf
 * @date 2021/1/19 10:31 上午
 */
@Data
@Model(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {
                @Index(columns = Student.sex_field)
        }
)
public class Student extends BaseModel<Long> {

    @Field(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @Field(name = "性别")
    @DictionaryMeta(value = SexDict.class)
    private Integer sex;

    @Field(name = "主修课程")
    @DictionaryMeta(value = SubjectDict.class)
    private Collection<String> subjects;
}
