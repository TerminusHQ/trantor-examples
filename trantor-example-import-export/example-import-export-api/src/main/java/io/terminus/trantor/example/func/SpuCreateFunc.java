package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.SpuBO;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/1/27
 */

@Function(name = "商品特性创建函数")
public interface SpuCreateFunc {

    SpuBO execute(SpuBO spu);
}
