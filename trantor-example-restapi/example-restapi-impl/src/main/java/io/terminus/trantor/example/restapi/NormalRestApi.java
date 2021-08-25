package io.terminus.trantor.example.restapi;

import io.terminus.trantorframework.api.RestAPI;
import io.terminus.trantorframework.api.annotation.RestApi;
import io.terminus.trantorframework.api.annotation.RestApiMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 常规的原生接口
 * @author stan
 * @date 2021/3/5
 */
@RestApi(path = "/test/normal", method = RestApiMethod.GET)
public class NormalRestApi implements RestAPI {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req);
        System.out.println(resp);
    }
}
