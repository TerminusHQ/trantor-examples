package io.terminus.trantor.example.flow;

import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.example.model.query.QItemBO;
import io.terminus.trantorframework.api.annotation.Flow;

import java.util.List;

/**
 * @author DongZhao
 * Date:2021/1/27
 */
@Flow(name = "商品列表数据")
public interface ItemListDataFlow {
    List<ItemBO> execute(QItemBO itemBo);
}