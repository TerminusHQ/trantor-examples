package io.terminus.trantor.example.dict;

import io.terminus.trantorframework.api.annotation.DictType;
import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;
import io.terminus.trantorframework.api.annotation.ItemDisplaySortRule;
import io.terminus.trantorframework.api.annotation.typemeta.Icon;

/**
 * @author ymf
 * 通过 @Dictionary 注解来标明这是一个字典类，name 标签标明字典类的名称
 * 通过继承 ItemDisplaySortRule 接口来排序（前端视图下拉框展示的顺序）
 * 字典类型为Integer
 */
@Dictionary(name = "性别", desc = "性别枚举", type = DictType.Int)
public interface SexDict extends ItemDisplaySortRule {
    /**
     * 通过@DictionaryItem注解对每一个类型进行标注,iconColor：字典类型的颜色；icon字典类型的图标
     */
    @DictionaryItem(value = "男", icon = Icon.dot, iconColor = Icon.Color.Green, displayOrder = 1)
    Integer male = 0;

    @DictionaryItem(value = "女", icon = Icon.dot, iconColor = Icon.Color.Purple, displayOrder = 2)
    Integer female = 1;

    @DictionaryItem(value = "保密", icon = Icon.dot, iconColor = Icon.Color.Orange, displayOrder = 3)
    Integer unknown = 2;
}
