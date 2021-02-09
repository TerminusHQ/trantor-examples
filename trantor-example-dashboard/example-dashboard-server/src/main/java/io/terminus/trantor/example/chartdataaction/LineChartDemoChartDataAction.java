package io.terminus.trantor.example.chartdataaction;

import io.terminus.trantor.module.base.model.DashboardChartItem;
import io.terminus.trantor.sdk.datasource.ChartDataAction;
import io.terminus.trantor.sdk.datasource.ChartDataParams;
import io.terminus.trantor.sdk.datasource.ChartDataResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdy
 */
@Component
public class LineChartDemoChartDataAction implements ChartDataAction {


    @Override
    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<DashboardChartItem> data = new ArrayList<>();

        // 第一组数据

        DashboardChartItem item1 = new DashboardChartItem();
        item1.setLabel("item1");
        item1.setValue(111L);
        item1.setGroup("item1");
        data.add(item1);

        DashboardChartItem item2 = new DashboardChartItem();
        item2.setLabel("item1");
        item2.setValue(222L);
        item2.setGroup("item2");
        data.add(item2);

        DashboardChartItem item3 = new DashboardChartItem();
        item3.setLabel("item1");
        item3.setValue(333L);
        item3.setGroup("item3");
        data.add(item3);

        DashboardChartItem item4 = new DashboardChartItem();
        item4.setLabel("item1");
        item4.setValue(444L);
        item4.setGroup("item4");
        data.add(item4);

        DashboardChartItem item5 = new DashboardChartItem();
        item5.setLabel("item1");
        item5.setValue(555L);
        item5.setGroup("item5");
        data.add(item5);

        // 第二组数据

        DashboardChartItem item11 = new DashboardChartItem();
        item11.setLabel("item11");
        item11.setValue(151L);
        item11.setGroup("item1");
        data.add(item11);

        DashboardChartItem item22 = new DashboardChartItem();
        item22.setLabel("item11");
        item22.setValue(262L);
        item22.setGroup("item2");
        data.add(item22);

        DashboardChartItem item33 = new DashboardChartItem();
        item33.setLabel("item11");
        item33.setValue(373L);
        item33.setGroup("item3");
        data.add(item33);

        DashboardChartItem item44 = new DashboardChartItem();
        item44.setLabel("item11");
        item44.setValue(484L);
        item44.setGroup("item4");
        data.add(item44);

        DashboardChartItem item55 = new DashboardChartItem();
        item55.setLabel("item11");
        item55.setValue(595L);
        item55.setGroup("item5");
        data.add(item55);

        chartDataResult.setData(data);
        return chartDataResult;
    }
}
