package io.terminus.trantor.example.model;

import io.terminus.trantor.example.dict.SubjectDict;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.Label;
import lombok.Data;

/**
 * @author ymf
 * @date 2021/1/19 10:29 上午
 */
@Data
@Model(name = "科目")
public class Subject extends BaseModel<Long> {

    public enum Type {
        @Label("所有")
        all,
        @Label("文科")
        arts,
        @Label("理科")
        science,
    }

    @Field(name = "课程类别")
    private Subject.Type type;

    @Field(name = "科目名称", nullable = false)
    @DictionaryMeta(value = SubjectDict.class)
    private String name;
}
