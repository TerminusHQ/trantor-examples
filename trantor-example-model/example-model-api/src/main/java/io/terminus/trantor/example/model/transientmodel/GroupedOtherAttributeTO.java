package io.terminus.trantor.example.model.transientmodel;

import io.terminus.trantorframework.api.RootModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.TransientModel;
import lombok.Data;

@Data
@TransientModel(name = "Grouped other attributes")
public class GroupedOtherAttributeTO extends RootModel<Long> {

    @Field(name = "Attribute key")
    private String attrKey;

    @Field(name = "Attribute value")
    private String attrVal;

    @Field(name = "Attribute group")
    private String group;
}
