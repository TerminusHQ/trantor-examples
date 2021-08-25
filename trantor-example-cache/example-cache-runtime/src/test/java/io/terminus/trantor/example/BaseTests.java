package io.terminus.trantor.example;

import io.terminus.trantorframework.test.TSpringRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(TSpringRunner.class)
@SpringBootTest(properties = {
        "DUBBO_ENABLED=false",
        "USER_MOCK=true",
        "ACL_MOCK=true",
        "DS_PORT=8081",
        "REDIS_PORT=6380",
        "REDIS_PASSWORD=password"
})
public class BaseTests {
}
