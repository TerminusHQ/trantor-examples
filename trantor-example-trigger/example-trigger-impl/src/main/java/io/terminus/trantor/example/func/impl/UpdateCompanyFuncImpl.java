package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.UpdateCompanyFunc;
import io.terminus.trantor.example.model.Company;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

@FunctionImpl(name = "更新公司信息")
public class UpdateCompanyFuncImpl implements UpdateCompanyFunc {

    @Override
    public void execute(Company company) {
        DS.update(company);
    }
}
