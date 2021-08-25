package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.UpdateStaffFunc;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FunctionImpl(name = "更新人员信息")
public class UpdateStaffFuncImpl implements UpdateStaffFunc {
    @Override
    public void execute(Staff staff) {
        DS.update(staff);
    }
}
