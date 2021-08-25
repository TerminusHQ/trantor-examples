package io.terminus.trantor.example.model.base;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.DeleteStrategy;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.CurrencyMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import io.terminus.trantorframework.api.type.Currency;
import lombok.Data;

/**
 * @author weichao
 * @date 6/7/21 2:02 PM
 * @Description: 测试模型1
 **/
@Data
@Model(
        name = "test model1",
        mainField = TestModel1.stringField_field,
        deleteStrategy = DeleteStrategy.Logical
)
public class TestModel1 extends BaseModel<Long> {

    @Field(name = "int field", nullable = false)
    private int intField;

    @Field(name = "long field", nullable = false)
    private long longField;

    @Field(name = "float field", nullable = false)
    private float floatField;

    @Field(name = "boolean field", nullable = false)
    private boolean booleanField;

    @Field(name = "string field", nullable = false)
    private String stringField;

    @Field(name = "Item price", nullable = false, type = FieldType.Currency)
    @CurrencyMeta(intDigits = 12, decimalDigits = 4)
    private Currency currency;

    /**
     * 通过 @LinkMeta 声明与其他模型实体的关联关系
     */
    @Field(name = "test model2", nullable = false)
    @LinkMeta
    private TestModel2 testModel2;
}
