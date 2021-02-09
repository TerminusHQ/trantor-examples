package io.terminus.trantor.example.model.relation;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;

import java.util.List;

/**
 * @author ymf
 * @date 2021/1/19 10:29 上午
 */
@TModel(name = "科目")
public class Subject extends BaseModel<Long> {

    private static final long serialVersionUID = -2678865156665873594L;

    @TModelField(name = "科目名称", nullable = false)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
