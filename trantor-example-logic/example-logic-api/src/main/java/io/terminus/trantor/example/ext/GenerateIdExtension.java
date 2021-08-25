package io.terminus.trantor.example.ext;

import io.terminus.trantorframework.api.annotation.Extension;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * @author lihao
 * @email wb-lh940642@alibaba-inc.com
 * @createTime 2021-07-06 11:05:43
 */

@Extension
public interface GenerateIdExtension {

    String execute();

}
