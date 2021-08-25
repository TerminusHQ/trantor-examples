package io.terminus.trantor.example;

import io.terminus.trantor.example.func.QueryItemBrandFunc;
import io.terminus.trantor.example.model.BrandBO;
import io.terminus.trantor.example.model.ItemBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class FuncTests extends BaseTests {

    private QueryItemBrandFunc queryItemBrandFunc;

    @Test
    public void testGetBrandByItem() {
        ItemBO itemBO = new ItemBO();
        itemBO.setId(100L);
        BrandBO brandBO = queryItemBrandFunc.execute(itemBO);
        log.info("brand info: {}", brandBO.toString());
    }
}
