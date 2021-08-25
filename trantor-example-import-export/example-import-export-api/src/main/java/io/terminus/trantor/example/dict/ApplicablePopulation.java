package io.terminus.trantor.example.dict;

import io.terminus.trantorframework.api.annotation.typemeta.Label;

/**
 * @author DongZhao
 * Date:2021/6/2
 */

public enum ApplicablePopulation {
    @Label(value = "婴幼儿")
    Baby,
    @Label(value = "年轻人")
    Young,
    @Label(value = "成人")
    Adult,
    @Label(value = "中年人")
    Middle,
    @Label(value = "老年人")
    Elder
}
