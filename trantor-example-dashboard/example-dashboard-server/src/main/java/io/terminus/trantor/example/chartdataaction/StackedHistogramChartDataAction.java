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
public class StackedHistogramChartDataAction implements ChartDataAction {

    @Override
    public ChartDataResult load(ChartDataParams chartDataParams) {

        ChartDataResult chartDataResult = new ChartDataResult();
        List<DashboardChartItem> result = new ArrayList<>();
        DashboardChartItem item = new DashboardChartItem();
        item.setGroup("2020");
        item.setLabel("一班");
        item.setValue(432L);
        result.add(item);

        DashboardChartItem item0 = new DashboardChartItem();
        item0.setGroup("2021");
        item0.setLabel("二班");
        item0.setValue(42L);
        result.add(item0);

        DashboardChartItem item1 = new DashboardChartItem();
        item1.setGroup("2020");
        item1.setLabel("一班");
        item1.setValue(2312L);
        result.add(item1);

        DashboardChartItem item11 = new DashboardChartItem();
        item11.setGroup("2021");
        item11.setLabel("二班");
        item11.setValue(212L);
        result.add(item11);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
