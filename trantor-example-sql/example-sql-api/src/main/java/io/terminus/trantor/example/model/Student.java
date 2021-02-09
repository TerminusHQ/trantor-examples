package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import io.terminus.trantor.module.base.dictionary.Country;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author ymf
 * @date 2021/1/21 8:26 下午
 */
@Data
@TModel(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {
                @Index(columns = Student.stuNo_field, unique = true)
        }


)
public class Student extends BaseModel<Long> {

    private static final long serialVersionUID = -4434701696846600802L;

    @TModelField(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @TModelField(name = "年纪")
    private Integer age;

    @TModelField(name = "学号")
    private String stuNo;

    /**
     * 定义OneToOne：一个学生只能含有一张校园卡,一张校园卡同时只能对应一个学生
     */
    @TModelField(name = "学生卡")
    @RelationMeta(name = "StudentCard")
    private StudentCard studentCard;

    /**
     * 非持久化，从studentCard获取
     */
    @TModelField(name = "学生卡id", store = false)
    private String studentCardId;


}
