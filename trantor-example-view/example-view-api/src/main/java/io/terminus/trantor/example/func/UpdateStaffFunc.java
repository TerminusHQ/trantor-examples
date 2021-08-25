package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "更新员工信息")
public interface UpdateStaffFunc {

    void execute(Staff staff);
}
