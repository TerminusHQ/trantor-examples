package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantor.api.annotation.typemeta.Label;
import io.terminus.trantor.example.dict.SubjectEnum;

/**
 * @author ymf
 * @date 2021/1/19 10:29 上午
 */
@TModel(name = "科目")
public class Subject extends BaseModel<Long> {

    private static final long serialVersionUID = -2678865156665873594L;

    public enum Type {
        @Label("所有")
        all,
        @Label("文科")
        arts,
        @Label("理科")
        science,
    }

    @TModelField(name = "课程类别", store = false)
    private Subject.Type type;
    @TModelField(name = "科目名称", nullable = false)
    @DictionaryMeta(clazz = SubjectEnum.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
