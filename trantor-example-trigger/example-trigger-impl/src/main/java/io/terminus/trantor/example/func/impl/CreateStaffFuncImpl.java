package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.ext.StaffNumberRuleExt;
import io.terminus.trantor.example.func.CreateCompanyFunc;
import io.terminus.trantor.example.func.CreateStaffFunc;
import io.terminus.trantor.example.model.Company;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@FunctionImpl(name = "创建员工信息")
public class CreateStaffFuncImpl implements CreateStaffFunc {

    private final StaffNumberRuleExt staffNumberRuleExt;

    private final CreateCompanyFunc createCompanyFunc;

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

    /**
     * 初始化一个公司的信息供触发器基本使用展示
     */
    @PostConstruct
    public void initCompany() {
        Company company = DS.findById(Company.class, 1L);
        if (!Objects.isNull(company)) {
            log.info("公司信息已存在！");
            return;
        }
//        long count = DS.count(Staff.class, "", "");
        Company trantor = new Company("000001", "Trantor", 0L);
        log.info("当前公司信息：" + trantor.toString());
        createCompanyFunc.execute(trantor);
    }
}
