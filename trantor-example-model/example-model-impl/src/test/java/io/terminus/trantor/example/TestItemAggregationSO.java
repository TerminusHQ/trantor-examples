package io.terminus.trantor.example;

import io.terminus.trantor.example.model.business.ItemBO;
import io.terminus.trantor.example.model.search.ItemAggregationSO;
import io.terminus.trantorframework.api.type.Currency;
import io.terminus.trantorframework.sdk.sql.DS;
import io.terminus.trantorframework.sdk.sql.Search;
import io.terminus.trantorframework.test.TSpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hzj273812（黄子敬）
 * @email hzj273812@alibaba-inc.com
 * @create 2021/5/31 下午4:05
 **/
@SpringBootTest
@RunWith(TSpringRunner.class)
public class TestItemAggregationSO {

    @Before
    public void initItem() {
        ItemBO itemBO = new ItemBO();
    }

    @Test
    public void testCreate() {
        // 定义 SearchModel 维护检索信息
        ItemAggregationSO aggregationSO = new ItemAggregationSO();
        aggregationSO.setItemName("小米米家走步机多功能自动跑步机");
        aggregationSO.setBrandName("MIJIA/米家");
        aggregationSO.setCategoryName("健身器材");
        aggregationSO.setItemPrice(new Currency(Currency.getDefaultType(), 1799.00));
        // 存储目标商品数据主键ID，通过搜索模型 id 字段维护目标商品关联，1000L是模拟商品主键ID
        aggregationSO.setId(1000L);
        DS.save(aggregationSO);
    }
}
