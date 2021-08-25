package io.terminus.trantor.example.logicFun;

import io.terminus.trantor.example.func.ItemPagingDataFunc;
import io.terminus.trantor.example.model.ItemBO;
import io.terminus.trantor.example.model.query.QItemBO;
import io.terminus.trantorframework.Paging;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;


/**
 * @author DongZhao
 * Date:2021/1/27
 */
@FunctionImpl(name = "商品列表数据")
public class ItemPagingDataFuncImpl implements ItemPagingDataFunc {

    @Override
    public Paging<ItemBO> execute(QItemBO itemBo) {
        //分页查询数据
        Paging<ItemBO> result = DS.paging(itemBo);
        return result;
    }
}