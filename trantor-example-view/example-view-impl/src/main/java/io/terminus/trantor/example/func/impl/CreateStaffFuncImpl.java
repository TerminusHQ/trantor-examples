package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.ext.StaffNumberRuleExt;
import io.terminus.trantor.example.func.CreateStaffFunc;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@FunctionImpl(name = "创建员工信息")
public class CreateStaffFuncImpl implements CreateStaffFunc {

    private final StaffNumberRuleExt staffNumberRuleExt;

    @Override
    public Staff execute(Staff staff) {
        String itemNumber = staffNumberRuleExt.execute(staff);
        staff.setStaffNumber(itemNumber);
        IntResult id = DS.create(staff);
        Staff status = DS.findById(Staff.class, id.getValue().longValue());
        if (Objects.isNull(status)) {
            throw new BusinessException("保存人员信息失败");
        }
        return status;
    }
}
