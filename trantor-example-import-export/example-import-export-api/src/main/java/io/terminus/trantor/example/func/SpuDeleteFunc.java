package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.SpuBO;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/3/10
 */
@Function(name = "商品特性删除函数")
public interface SpuDeleteFunc {
    void execute(SpuBO spu);
}
