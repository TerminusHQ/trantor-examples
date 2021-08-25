package io.terminus.trantor.example.dynamicview;

import io.terminus.trantorframework.api.annotation.Function;

@Function
public interface DynamicSubmitFunc {

    MyUser execute(MyUser myUser);

}
