package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import io.terminus.trantor.module.base.dictionary.Country;

import javax.validation.constraints.NotNull;

/**
 * @author ymf
 * @date 2021/1/21 8:26 下午
 */
@TModel(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {
                @Index(columns = Student.stuNo_field, unique = true),
                @Index(columns = Student.country_field)
        }


)
public class Student extends BaseModel<Long> {

    private static final long serialVersionUID = -4434701696846600802L;

    @TModelField(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @TModelField(name = "学号")
    private String stuNo;

    @TModelField(name = "邮箱", type = TModelFieldType.Email)
    private String email;

    @TModelField(name = "国家")
    @DictionaryMeta(clazz = Country.class)
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
