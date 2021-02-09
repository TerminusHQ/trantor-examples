package io.terminus.trantor.example.dict;

import io.terminus.trantor.api.annotation.ItemDisplaySortRule;
import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * @author ymf
 * 通过@TDict注解来标明这是一个字典类，name标签标明字典类的名称
 * 通过实现ItemDisplaySortRule接口来排序（下拉框展示的顺序）
 * 字典类型为String
 */
@TDict(
        name = "课程枚举",
        desc = "所有课程枚举"
)
public class SubjectEnum implements ItemDisplaySortRule {


    /**
     * 通过dictItemGroup属性为字典项进行分组
     */
    @Label(value = "语文", dictItemGroup = {"arts"})
    public static final String Chinese = "Chinese";

    @Label(value = "数学", dictItemGroup = {"science"})
    public static final String Mathematics = "Mathematics";

    @Label(value = "英语", dictItemGroup = {"arts", "science"})
    public static final String English = "English";

}
