package io.terminus.trantor.example.dynamicview;

import io.terminus.trantor.module.base.dynamicview.DataContainer;
import io.terminus.trantor.module.base.dynamicview.DynamicView;
import io.terminus.trantor.module.base.dynamicview.DynamicViewField;
import io.terminus.trantor.module.base.dynamicview.DynamicViewGroup;
import io.terminus.trantorframework.api.annotation.DictType;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.api.typeMeta.DictItem;
import io.terminus.trantorframework.api.typeMeta.DictionaryType;
import io.terminus.trantorframework.api.typeMeta.IntType;
import io.terminus.trantorframework.api.typeMeta.TextType;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@FunctionImpl
public class DynamicViewFuncImpl implements DynamicViewFunc {
    @Override
    public List<DynamicView> execute(MyUser myUser) {
        List<DynamicView> list = new ArrayList<>();
        DynamicView form = generateForm();
        list.add(form);
        DynamicView tableForm = generateTableForm();
        list.add(tableForm);
        return list;
    }

    @NotNull
    private DynamicView generateForm() {
        DynamicView form = new DynamicView();
        form.setTitle("公司");
        form.setModel("company");
        form.setDataContainer(DataContainer.Form);

        DynamicViewGroup g1 = new DynamicViewGroup();
        g1.setTitle("小分组");
        g1.setSingleColumn(false);
        form.setGroups(Collections.singletonList(g1));
        DynamicViewField f1 = generateField("name", "名称", 0);
        DynamicViewField f2 = generateField("info", "信息", 3);
        DynamicViewField f3 = generateField("location", "地址", 2);

        DynamicViewField f4 = new DynamicViewField();
        f4.setName("age");
        f4.setLabel("年龄");
        f4.setType(FieldType.Int);
        f4.setTypeMeta(IntType.DEFAULT.get());
        f4.setDefaultValue("12");
        // f4.setDslProperties(Collections.singletonList("readonly=\"true\""));
        f4.setReadonly(true);


        DynamicViewField d1 = new DynamicViewField();
        d1.setName("type");
        d1.setLabel("类型");
        d1.setType(FieldType.MultiDictionary);
        DictionaryType dictionaryTypeMeta = new DictionaryType("custom_dict", DictType.String);
        dictionaryTypeMeta.setOptions(Arrays.asList(
                new DictItem("a", "第一个字母"),
                new DictItem("b", "第二个字母"),
                new DictItem("c", "第三个字母")));
        d1.setTypeMeta(dictionaryTypeMeta);

        DynamicViewField d2 = new DynamicViewField();
        d2.setName("type2");
        d2.setLabel("类型2");
        d2.setType(FieldType.MultiDictionary);
        DictionaryType dictionaryTypeMeta2 = new DictionaryType("item_ItemTypeDict", DictType.String);
        d2.setTypeMeta(dictionaryTypeMeta2);

        g1.setFields(Arrays.asList(f1, f2, f3, f4, d1, d2));
        return form;
    }

    @NotNull
    private DynamicView generateTableForm() {
        DynamicView tableForm = new DynamicView();
        tableForm.setTitle("岗位");
        tableForm.setModel("position");
        tableForm.setDataContainer(DataContainer.TableForm);
        DynamicViewGroup defaultGroup = new DynamicViewGroup();
        tableForm.setDefaultGroup(defaultGroup);
        DynamicViewField f1 = generateField("name", "名称", 0);
        DynamicViewField f2 = generateField("info", "信息", 3);
        DynamicViewField f3 = generateField("location", "地址", 2);
        defaultGroup.setFields(Arrays.asList(f1, f2, f3));
        return tableForm;
    }


    @NotNull
    private DynamicViewField generateField(String name, String label, int order) {
        DynamicViewField dynamicViewField = new DynamicViewField();
        dynamicViewField.setName(name);
        dynamicViewField.setLabel(label);
        dynamicViewField.setType(FieldType.Text);
        dynamicViewField.setTypeMeta(TextType.DEFAULT.get());
        dynamicViewField.setOrder(order);
        return dynamicViewField;
    }
}
