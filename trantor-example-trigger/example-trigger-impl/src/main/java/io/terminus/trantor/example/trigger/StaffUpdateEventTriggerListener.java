package io.terminus.trantor.example.trigger;

import io.terminus.trantor.example.model.Staff;
import io.terminus.trantorframework.api.annotation.Trigger;
import io.terminus.trantorframework.sdk.trigger.UpdateEvent;
import io.terminus.trantorframework.sdk.trigger.UpdateEventTriggerListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@Trigger(
        modelClass = Staff.class,
        listenFields = {"staffMobile", "StaffEmail"}
)
public class StaffUpdateEventTriggerListener implements UpdateEventTriggerListener<Staff> {

    @Override
    public void execute(UpdateEvent<Staff> updateEvent) {
        log.info("人员信息更新操作，无需更改公司的人数！");
    }
}
