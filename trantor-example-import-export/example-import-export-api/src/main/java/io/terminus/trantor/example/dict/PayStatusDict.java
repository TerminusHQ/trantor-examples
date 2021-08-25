package io.terminus.trantor.example.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * @author DongZhao
 * Date:2021/5/14
 */
@Dictionary
public interface PayStatusDict {

    @DictionaryItem("Unpaid")
    String UNPAID = "UNPAID";

    @DictionaryItem("Partial paid")
    String PARTIAL_PAID = "PARTIAL_PAID";

    @DictionaryItem("Paid")
    String PAID = "PAID";
}
