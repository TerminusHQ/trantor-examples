package io.terminus.trantor.example.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;
import io.terminus.trantorframework.api.annotation.ItemDisplaySortRule;

/**
 * @author ymf
 * 通过 @Dictionary 注解来标明这是一个字典类，name 标签标明字典类的名称
 * 通过继承 ItemDisplaySortRule 接口来排序（前端视图下拉框展示的顺序）
 * 字典类型为Integer
 */
@Dictionary(name = "课程枚举", desc = "所有课程枚举")
public interface SubjectDict extends ItemDisplaySortRule {
    /**
     * 通过dictItemGroup属性为字典项进行分组
     */
    @DictionaryItem(value = "语文", dictItemGroup = {"arts"})
    String Chinese = "Chinese";

    @DictionaryItem(value = "数学", dictItemGroup = {"science"})
    String Mathematics = "Mathematics";

    @DictionaryItem(value = "英语", dictItemGroup = {"arts", "science"})
    String English = "English";
}
