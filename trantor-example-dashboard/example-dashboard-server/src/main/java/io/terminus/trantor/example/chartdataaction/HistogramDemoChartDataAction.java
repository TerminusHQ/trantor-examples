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
public class HistogramDemoChartDataAction implements ChartDataAction {


    @Override
    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult histogramChartDataResult = new ChartDataResult();
        List<DashboardChartItem> data = new ArrayList<>();

        DashboardChartItem item1 = new DashboardChartItem();
        item1.setLabel("中国");
        item1.setValue(10L);
        data.add(item1);

        DashboardChartItem item2 = new DashboardChartItem();
        item2.setLabel("美国");
        item2.setValue(5L);
        data.add(item2);

        DashboardChartItem item3 = new DashboardChartItem();
        item3.setLabel("德国");
        item3.setValue(15L);
        data.add(item3);

        histogramChartDataResult.setData(data);
        return histogramChartDataResult;
    }
}
