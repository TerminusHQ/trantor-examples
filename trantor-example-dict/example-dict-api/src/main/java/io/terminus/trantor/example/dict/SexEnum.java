package io.terminus.trantor.example.dict;

import io.terminus.trantor.api.annotation.ItemDisplaySortRule;
import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.TDictType;
import io.terminus.trantor.api.annotation.typemeta.Icon;
import io.terminus.trantor.api.annotation.typemeta.Label;


/**
 * @author ymf
 * 通过@TDict注解来标明这是一个字典类，name标签标明字典类的名称
 * 通过实现ItemDisplaySortRule接口来排序（下拉框展示的顺序）
 * 字典类型为Integer
 */
@TDict(
        name = "性别",
        desc = "性别枚举",
        type = TDictType.Int
)
public class SexEnum implements ItemDisplaySortRule {

    /**
     * 通过@Label注解对每一个类型进行标注,iconColor：字典类型的颜色；icon字典类型的图标
     */
    @Label(value = "男", icon = Icon.dot, iconColor = Icon.Color.Green, displayOrder = 1)
    public static final Integer male = 0;

    @Label(value = "女", icon = Icon.dot, iconColor = Icon.Color.Purple, displayOrder = 2)
    public static final Integer female = 1;

    @Label(value = "保密", icon = Icon.dot, iconColor = Icon.Color.Orange, displayOrder = 3)
    public static final Integer unknown = 2;
}
