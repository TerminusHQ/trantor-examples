package io.terminus.trantor.example.dic;

import io.terminus.trantor.api.annotation.ItemDisplaySortRule;
import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Icon;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 *
 * @author chengong
 * @date 2021/1/25 4:14 下午 
 */ 
@TDict(name = "学生成绩")
public class ScoreEnum implements ItemDisplaySortRule {

    /**
     * 通过@Label注解对每一个类型进行标注,iconColor：字典类型的颜色；icon字典类型的图标
     */
    @Label(value = "优秀", iconColor = Icon.Color.Blue, icon = Icon.bell)
    public static final String Excellent = "Excellent";

    @Label("良")
    public static final String Good = "Good";

}
