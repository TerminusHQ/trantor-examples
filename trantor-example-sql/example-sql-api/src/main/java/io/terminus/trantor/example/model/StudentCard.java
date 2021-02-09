package io.terminus.trantor.example.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import lombok.Data;


/**
 * @author ymf
 * 学生卡信息，这里用来描述学生卡与学生之间一对一的关系
 */
@Data
@TModel(name = "学生校园卡")
public class StudentCard extends BaseModel<Long> {
    private static final long serialVersionUID = 8278850590518272963L;
    @TModelField(name = "编号")
    private String studentCardId;

}
