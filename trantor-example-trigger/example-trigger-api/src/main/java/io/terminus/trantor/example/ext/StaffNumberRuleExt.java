package io.terminus.trantor.example.ext;

import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Extension;

@Extension(name = "设置员工信息编号")
public interface StaffNumberRuleExt {

    String execute(Staff staff);
}
