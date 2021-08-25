package io.terminus.trantor.example.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * TODO
 *
 * @author 孙城(苏仕)
 */
@Dictionary(name = "岗位类型")
public interface PositionType {

    @DictionaryItem("高级")
    String High = "high";

    @DictionaryItem("中级")
    String middle = "middle";

    @DictionaryItem("初级")
    String primary = "primary";

}
