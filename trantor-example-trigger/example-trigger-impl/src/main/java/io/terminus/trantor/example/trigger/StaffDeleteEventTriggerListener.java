package io.terminus.trantor.example.trigger;

import io.terminus.trantor.example.func.UpdateCompanyFunc;
import io.terminus.trantor.example.model.Company;
import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Trigger;
import io.terminus.trantorframework.sdk.sql.DS;
import io.terminus.trantorframework.sdk.trigger.DeleteEvent;
import io.terminus.trantorframework.sdk.trigger.DeleteEventTriggerListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@Trigger(
        modelClass = Staff.class,
        listenFields = {"staffNumber", "staffName"}
)
public class StaffDeleteEventTriggerListener implements DeleteEventTriggerListener<Staff> {

    private final UpdateCompanyFunc updateCompanyFunc;

    @Override
    public void execute(DeleteEvent<Staff> deleteEvent) {
        log.info("在职人数-1");
        Company company = DS.findById(Company.class, 1L);
        company.setStaffNumber(company.getStaffNumber() - 1);
        updateCompanyFunc.execute(company);
        log.info("当前公司信息：" + company.toString());
    }
}
