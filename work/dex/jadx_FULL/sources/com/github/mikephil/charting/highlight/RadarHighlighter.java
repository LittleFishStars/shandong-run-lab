package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    public Highlight getClosestHighlight(int i, float f, float f2) {
        List<Highlight> highlightsAtIndex = getHighlightsAtIndex(i);
        float fDistanceToCenter = ((RadarChart) this.mChart).distanceToCenter(f, f2) / ((RadarChart) this.mChart).getFactor();
        Highlight highlight = null;
        float f3 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < highlightsAtIndex.size(); i2++) {
            Highlight highlight2 = highlightsAtIndex.get(i2);
            float fAbs = Math.abs(highlight2.getY() - fDistanceToCenter);
            if (fAbs < f3) {
                highlight = highlight2;
                f3 = fAbs;
            }
        }
        return highlight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.BaseEntry, com.github.mikephil.charting.data.Entry] */
    public List<Highlight> getHighlightsAtIndex(int i) {
        this.mHighlightBuffer.clear();
        float phaseX = ((RadarChart) this.mChart).getAnimator().getPhaseX();
        float phaseY = ((RadarChart) this.mChart).getAnimator().getPhaseY();
        float sliceAngle = ((RadarChart) this.mChart).getSliceAngle();
        float factor = ((RadarChart) this.mChart).getFactor();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i2 = 0; i2 < ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetCount(); i2++) {
            IRadarDataSet dataSetByIndex = ((RadarData) ((RadarChart) this.mChart).getData()).getDataSetByIndex(i2);
            ?? entryForIndex = dataSetByIndex.getEntryForIndex(i);
            float f = i;
            Utils.getPosition(((RadarChart) this.mChart).getCenterOffsets(), (entryForIndex.getY() - ((RadarChart) this.mChart).getYChartMin()) * factor * phaseY, (sliceAngle * f * phaseX) + ((RadarChart) this.mChart).getRotationAngle(), mPPointF);
            this.mHighlightBuffer.add(new Highlight(f, entryForIndex.getY(), mPPointF.x, mPPointF.y, i2, dataSetByIndex.getAxisDependency()));
        }
        return this.mHighlightBuffer;
    }
}
