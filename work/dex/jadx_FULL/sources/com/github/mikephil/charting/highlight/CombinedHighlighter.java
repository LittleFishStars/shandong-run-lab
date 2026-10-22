package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {
    protected BarHighlighter barHighlighter;

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        this.barHighlighter = barDataProvider.getBarData() == null ? null : new BarHighlighter(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    public List<Highlight> getHighlightsAtXValue(float f, float f2, float f3) {
        this.mHighlightBuffer.clear();
        List<BarLineScatterCandleBubbleData> allData = ((CombinedDataProvider) this.mChart).getCombinedData().getAllData();
        for (int i = 0; i < allData.size(); i++) {
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = allData.get(i);
            BarHighlighter barHighlighter = this.barHighlighter;
            if (barHighlighter == null || !(barLineScatterCandleBubbleData instanceof BarData)) {
                int dataSetCount = barLineScatterCandleBubbleData.getDataSetCount();
                for (int i2 = 0; i2 < dataSetCount; i2++) {
                    IDataSet dataSetByIndex = allData.get(i).getDataSetByIndex(i2);
                    if (dataSetByIndex.isHighlightEnabled()) {
                        for (Highlight highlight : buildHighlights(dataSetByIndex, i2, f, DataSet.Rounding.CLOSEST)) {
                            highlight.setDataIndex(i);
                            this.mHighlightBuffer.add(highlight);
                        }
                    }
                }
            } else {
                Highlight highlight2 = barHighlighter.getHighlight(f2, f3);
                if (highlight2 != null) {
                    highlight2.setDataIndex(i);
                    this.mHighlightBuffer.add(highlight2);
                }
            }
        }
        return this.mHighlightBuffer;
    }
}
