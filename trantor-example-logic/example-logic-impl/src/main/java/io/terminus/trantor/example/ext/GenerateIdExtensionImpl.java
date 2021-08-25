package io.terminus.trantor.example.ext;

import io.terminus.trantorframework.api.annotation.ExtensionImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author lihao
 * @email wb-lh940642@alibaba-inc.com
 * @createTime 2021-07-06 11:07:38
 */

@Slf4j
@ExtensionImpl
public class GenerateIdExtensionImpl implements GenerateIdExtension {

    @Override
    public String execute() {
        String randomNumber = RandomStringUtils.randomAlphabetic(8);
        log.info("generate code: {}", "Staff_" + randomNumber);
        return "Staff_" + randomNumber;
    }

}
