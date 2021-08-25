package io.terminus.trantor.example.func.impl;

import io.terminus.trantor.example.func.CreateCompanyFunc;
import io.terminus.trantor.example.model.Company;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@FunctionImpl(name = "创建公司信息")
public class CreateCompanyFuncImpl implements CreateCompanyFunc {

    @Override
    public void execute(Company company) {
        IntResult result = DS.create(company);
    }
}
