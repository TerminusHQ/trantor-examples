package io.terminus.trantor.example.func;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.example.model.query.QItemBO;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@Function(name = "商品列表数据")
public interface ItemPagingDataFunc {
    Paging<ItemBO> execute(QItemBO itemBo);
}