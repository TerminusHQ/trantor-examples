package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.DeleteStaffFunc;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

@FunctionImpl(name = "删除人员信息")
public final class DeleteStaffFuncImpl implements DeleteStaffFunc {
    @Override
    public void execute(Staff staff) {
        DS.delete(staff);
    }
}
