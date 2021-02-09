package io.terminus.trantor.example.model.relation;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.ImageMeta;
import io.terminus.trantor.api.annotation.typemeta.NumberMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import io.terminus.trantor.api.annotation.typemeta.TextMeta;


import java.util.List;

/**
 * @author ymf
 * @date 2021/1/19 10:33 上午
 */
@TModel(name = "教师模型")
public class Teacher extends BaseModel<Long> {

    private static final long serialVersionUID = 2209884803300659565L;

    @TModelField(name = "教师姓名")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
