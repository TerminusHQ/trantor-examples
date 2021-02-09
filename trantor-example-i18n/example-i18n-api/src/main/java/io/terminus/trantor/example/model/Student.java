package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantor.example.dic.ScoreEnum;
import io.terminus.trantor.example.enums.Gender;

import javax.validation.constraints.NotNull;

/**
 * @author chengong
 * @date bgk, lo 4:44 下午
 */
@TModel(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {@Index(columns = Student.name_field, unique = true)}
)
public class Student extends BaseModel<Long> {

    private static final long serialVersionUID = -4434701696846600802L;


    @TModelField(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @TModelField(name = "性别")
    private Gender gender;

    @TModelField(name = "成绩")
    @DictionaryMeta(clazz = ScoreEnum.class)
    private String score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
