package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Company;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "更新公司信息")
public interface UpdateCompanyFunc {

    void execute(Company company);
}
