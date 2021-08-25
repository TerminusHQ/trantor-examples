package io.terminus.trantor.example;

import io.terminus.trantor.example.cache.ItemBrandCache;
import io.terminus.trantor.example.cache.SimpleKeyItemBrandCache;
import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantorframework.sdk.sql.DS;
import io.terminus.trantorframework.test.TSpringRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@Slf4j
@RunWith(TSpringRunner.class)
@SpringBootTest
public class CacheTests {

    private SimpleKeyItemBrandCache simpleKeyItemBrandCache;
    private ItemBrandCache itemBrandCache;

    private static Long itemId;

    @Before
    public void initData() {
        // init brand data
        log.info("ready brand data");
        BrandBO brandBO = new BrandBO();
        brandBO.setBrandName("Apple");
        DS.save(brandBO);
        // init item data
        log.info("ready item data");
        ItemBO itemBO = new ItemBO();
        itemBO.setItemName("iPhone 11");
        itemBO.setItemDesc("iPhone 11是美国苹果公司于北京时间2019年9月11日凌晨1点在史蒂夫·乔布斯剧院（Steve Jobs theater）发布的iPhone手机，起售价格5499元。");
        itemBO.setItemImage("https://img.alicdn.com/bao/uploaded/i4/1917047079/O1CN01cFWuDS22AEQen1bTL_!!0-item_pic.jpg_240x240.jpg");
        itemBO.setItemPrice(BigDecimal.valueOf(5499));
        itemBO.setItemNumber("iPhone 11");
        itemBO.setBrand(brandBO);
        itemId = DS.save(itemBO).getValue().longValue();
    }

    @Test
    public void testGetBrandByItemId() {
        Long id = itemId;
        BrandBO brandBO = simpleKeyItemBrandCache.get(id);
        log.info("brand info of item id {} : {}", id, brandBO.toString());
        simpleKeyItemBrandCache.clear();
    }

    @Test
    public void testGetBrandByItem() {
        ItemBO itemBO = new ItemBO();
        itemBO.setId(itemId);
        BrandBO brandBO = itemBrandCache.get(itemBO);
        log.info("brand info: {}", brandBO.toString());
    }
}
