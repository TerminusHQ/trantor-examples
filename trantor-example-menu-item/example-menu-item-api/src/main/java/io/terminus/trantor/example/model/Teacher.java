package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.ImageMeta;
import io.terminus.trantor.api.annotation.typemeta.NumberMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import io.terminus.trantor.api.annotation.typemeta.TextMeta;

import javax.security.auth.Subject;

/**
 * @author ymf
 * @date 2021/1/21 8:25 下午
 */
@TModel(
        key = "Teacher",
        name = "教师模型",
        fieldGroups = {
                @FieldGroup(fieldName = {Teacher.id_field, Teacher.name_field, Teacher.mobile_field, Teacher.email_field}),
                @FieldGroup(fieldName = {Teacher.name_field, Teacher.mobile_field, Teacher.email_field}, type = FieldGroupType.SEARCHABLE),
                @FieldGroup(fieldName = {Teacher.name_field, Teacher.mobile_field, Teacher.email_field}, type = FieldGroupType.SEARCH_SHOW),
        },
        enableSearch = true,
        enableImport = true,
        enableExport = true

)
public class Teacher extends BaseModel<Long> {

    private static final long serialVersionUID = 2209884803300659565L;

    @TModelField(name = "员工工号")
    @TextMeta(length = 11, rule = "STRING(DEP)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String teaNo;

    @TModelField(name = "教师姓名")
    private String name;

    @TModelField(name = "手机号", type = TModelFieldType.Phone)
    private String mobile;

    @TModelField(name = "邮箱", type = TModelFieldType.Email)
    private String email;

    @TModelField(name = "图片")
    @ImageMeta(maxSize = 3 * 1024)
    private String image;

    @TModelField(name = "简述", type = TModelFieldType.MultiText)
    @TextMeta(length = 512)
    private String desc;

    @TModelField(name = "个人履历", type = TModelFieldType.RichText)
    private String resume;

    @TModelField(name = "薪水")
    @NumberMeta(unit = "元")
    private Double salary;

    public String getTeaNo() {
        return teaNo;
    }

    public void setTeaNo(String teaNo) {
        this.teaNo = teaNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
