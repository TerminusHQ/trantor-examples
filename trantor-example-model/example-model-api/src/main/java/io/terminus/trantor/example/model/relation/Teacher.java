package io.terminus.trantor.example.model.relation;



import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;

import java.util.List;

/**
 * @author ymf
 * @date 2021/1/19 10:33 上午
 */
@Model(name = "教师模型")
public class Teacher extends BaseModel<Long> {

    private static final long serialVersionUID = 2209884803300659565L;

    @Field(name = "教师姓名")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
