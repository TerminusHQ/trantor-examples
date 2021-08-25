package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "创建员工信息")
public interface CreateStaffFunc {
    Staff execute(Staff staff);
}
