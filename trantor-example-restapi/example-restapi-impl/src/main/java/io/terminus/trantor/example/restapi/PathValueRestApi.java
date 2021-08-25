package io.terminus.trantor.example.restapi;

import io.terminus.trantorframework.api.RestAPI;
import io.terminus.trantorframework.api.annotation.RestApi;
import io.terminus.trantorframework.api.annotation.RestApiMethod;
import io.terminus.trantorframework.restapi.RestApiUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 支持 path value 的接口
 * @author stan
 * @date 2021/3/10
 */
@RestApi(path = "/test/{id}", method = RestApiMethod.POST)
public class PathValueRestApi implements RestAPI {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Long id = RestApiUtils.extractPathValue(req, Long.class);
        System.out.println(id);

        Map<String, Object> obj = RestApiUtils.extractBody(req);
        System.out.println(obj);
        RestApiUtils.toJsonResp(resp, obj);
    }
}
