package io.terminus.trantor.example.model.relation;


import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Model;

/**
 * @author ymf
 * 学生卡信息，这里用来描述学生卡与学生之间一对一的关系
 */
@Model(name = "学生校园卡")
public class StudentCard extends BaseModel<Long> {
    private static final long serialVersionUID = 8278850590518272963L;
}
