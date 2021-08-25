package io.terminus.trantor.example.tree;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Chen Gong
 * @date：2021/8/24 8:10 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Model(mainField = "name")
public class Category extends BaseModel<Long> {
    @Field(name = "姓名")
    private String name;
    @Field
    @LinkMeta
    private Category parent;
    @Field(name = "子节点")
    private Boolean hasChildren;
}
