package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.Company;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

@Function(name = "创建公司信息")
public interface CreateCompanyFunc {
    void execute(Company company);
}
