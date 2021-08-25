package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "删除员工信息")
public interface DeleteStaffFunc {

    void execute(Staff staff);
}
