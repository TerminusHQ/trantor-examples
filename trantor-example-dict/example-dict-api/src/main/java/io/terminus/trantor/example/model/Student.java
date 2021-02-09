package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.*;
import io.terminus.trantor.example.dict.SexEnum;

import javax.validation.constraints.NotNull;


/**
 * @author ymf
 * @date 2021/1/19 10:31 上午
 */
@TModel(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {
                @Index(columns = Student.sex_field)
        }
)
public class Student extends BaseModel<Long> {

    private static final long serialVersionUID = -4434701696846600802L;


    @TModelField(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @TModelField(name = "性别")
    @DictionaryMeta(clazz = SexEnum.class)
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

}
