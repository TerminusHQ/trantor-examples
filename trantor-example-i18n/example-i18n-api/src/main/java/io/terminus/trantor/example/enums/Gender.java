package io.terminus.trantor.example.enums;

import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * @author chengong
 * @date 2021/1/22 4:19 下午
 */
public enum Gender {
    @Label("男")
    MALE,
    @Label("女")
    FEMALE,
    @Label("未知")
    UN_KNOW
}