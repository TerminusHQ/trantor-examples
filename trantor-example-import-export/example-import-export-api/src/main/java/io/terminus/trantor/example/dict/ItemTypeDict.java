package io.terminus.trantor.example.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * @author DongZhao
 * Date:2021/2/24
 */
@Dictionary(name = "商品类型")
public class ItemTypeDict {

    @DictionaryItem("食物")
    public static final String Food = "food";

    @DictionaryItem("电子产品")
    public static final String Electronics = "electronics";
}