package io.terminus.trantor.example.dynamicview;

import io.terminus.trantor.module.base.dynamicview.DynamicView;
import io.terminus.trantorframework.api.annotation.Function;

import java.util.List;

/**
 * @author stan
 * @date 2021/4/23
 */
@Function
public interface DynamicViewFunc {

    List<DynamicView> execute(MyUser myUser);

}
