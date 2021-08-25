package io.terminus.trantor.example.dynamicview;

import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.json.Json;
import io.terminus.trantorframework.sdk.sql.DS;

@FunctionImpl
public class DynamicSubmitFuncImpl implements DynamicSubmitFunc {
    @Override
    public MyUser execute(MyUser myUser) {
        System.out.format("saving user %s\n", Json.toJson(myUser));
        DS.save(myUser);
        return myUser;
    }
}
