package io.terminus.trantor.example.ext.impl;

import io.terminus.trantor.example.ext.StaffNumberRuleExt;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.ExtensionImpl;
import org.apache.commons.lang3.RandomStringUtils;

@ExtensionImpl(name = "设置员工编码")
public class StaffNumberRuleExtImpl implements StaffNumberRuleExt {
    @Override
    public String execute(Staff staff) {
        String randomNumber = RandomStringUtils.randomAlphabetic(8);
        return "staff: " + randomNumber;
    }
}
