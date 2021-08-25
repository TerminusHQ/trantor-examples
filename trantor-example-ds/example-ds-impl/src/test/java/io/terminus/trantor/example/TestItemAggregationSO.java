package io.terminus.trantor.example;

import io.terminus.trantor.example.func.TestSearchModelFunc;
import io.terminus.trantor.example.model.search.TestSearchModel;
import io.terminus.trantorframework.api.type.*;
import io.terminus.trantorframework.sdk.sql.DS;
import io.terminus.trantorframework.test.TSpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author hzj273812（黄子敬）
 * @email hzj273812@alibaba-inc.com
 * @create 2021/5/31 下午4:05
 **/
@SpringBootTest
@RunWith(TSpringRunner.class)
public class TestItemAggregationSO {

    @Autowired
    private TestSearchModelFunc testSearchModelFunc;

    @Before
    public void initItem() {
        testCreate();
    }

    public void testCreate() {
        // 定义 SearchModel 维护检索信息
        TestSearchModel testSearchModel = new TestSearchModel();
        testSearchModel.setStringField("小米米家走步机多功能自动跑步机");
        testSearchModel.setBooleanField(Boolean.FALSE);
        testSearchModel.setFloatField(2.00f);
        testSearchModel.setJsonField(Arrays.asList(1L,2L,3L));
        testSearchModel.setLongTextField("长文本长文本长文本长文本长文本长文本长文本长文本长文本长文本长文本长文本");
        testSearchModel.setIntField(4);

        // 地理位置字段，存储地理位置坐标点
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setLat(-28.00);
        geoLocation.setLon(14.00);
        testSearchModel.setGeoLocation(geoLocation);

        //画一个以(18.00,24.00)为中心点，半径为100m的圆
        GeoCircle geoCircle=new GeoCircle();
        GeoLocation center = new GeoLocation();
        center.setLat(18.00);
        center.setLon(24.00);
        geoCircle.setCenter(center);
        geoCircle.setRadius(100.00);
        testSearchModel.setGeoCircle(geoCircle);

        DS.save(testSearchModel);
    }

    @Test
    public void testSelect(){
        testSearchModelFunc.pageTestSearchModelInIdListOrderBy();
    }

}
