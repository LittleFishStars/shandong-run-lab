package com.huachenjie.run.page.run_detail.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.huachenjie.common.chart.BaseLineChartComponent;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.chart.StepLineChartComponent;
import com.zj.adlib.xj7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class StepLineChartComponent extends BaseLineChartComponent<View> {
    public static final int M = Color.parseColor("#1A3BCD69");
    public static final int N = Color.parseColor(xj7.f20670a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f35914a = 140.0f;
    public static final float b = 190.0f;
    public static final float c = 200.0f;

    public class a extends ValueFormatter {
        public a() {
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float value) {
            return Math.abs(value) < 0.01f ? "" : String.valueOf(Math.round(value));
        }
    }

    public class b extends YAxisRenderer {
        public b(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer trans) {
            super(viewPortHandler, yAxis, trans);
        }

        @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
        public void renderGridLines(Canvas c) {
            if (this.mYAxis.isEnabled() && this.mYAxis.isDrawGridLinesEnabled()) {
                int iSave = c.save();
                c.clipRect(getGridClippingRect());
                float[] transformedPositions = getTransformedPositions();
                this.mGridPaint.setColor(this.mYAxis.getGridColor());
                this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
                this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
                Path path = this.mRenderGridLinesPath;
                path.reset();
                for (int i = 0; i < transformedPositions.length; i += 2) {
                    if (Math.abs(this.mYAxis.mEntries[i / 2]) >= 0.01f) {
                        c.drawPath(linePath(path, i, transformedPositions), this.mGridPaint);
                        path.reset();
                    }
                }
                c.restoreToCount(iSave);
            }
        }
    }

    public StepLineChartComponent(View chartView) {
        super(chartView);
    }

    public static /* synthetic */ float p(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        return 140.0f;
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent
    public int d() {
        return R.id.chart_step;
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent
    public boolean drawFilled() {
        return false;
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent
    public int e() {
        return R.color.color_0BD3FF;
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent
    public float f() {
        return 2.5f;
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent, com.huachenjie.common.base.BaseComponent
    public void findViews() {
        super.findViews();
        ((BaseLineChartComponent) this).f33654a.getLegend().setEnabled(false);
        ((BaseLineChartComponent) this).f33654a.setExtraLeftOffset(4.0f);
        YAxis axisLeft = ((BaseLineChartComponent) this).f33654a.getAxisLeft();
        axisLeft.setDrawLabels(true);
        axisLeft.setEnabled(true);
        axisLeft.setDrawZeroLine(false);
        axisLeft.setDrawLimitLinesBehindData(false);
        axisLeft.setValueFormatter(new a());
        LineChart lineChart = ((BaseLineChartComponent) this).f33654a;
        lineChart.setRendererLeftYAxis(new b(lineChart.getViewPortHandler(), axisLeft, ((BaseLineChartComponent) this).f33654a.getTransformer(YAxis.AxisDependency.LEFT)));
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent
    public int getYLabelCount() {
        return 5;
    }

    @Override // com.huachenjie.common.chart.BaseLineChartComponent
    public float k() {
        return Math.max(super.k(), 200.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n() {
        YAxis axisLeft = ((BaseLineChartComponent) this).f33654a.getAxisLeft();
        axisLeft.removeAllLimitLines();
        axisLeft.addLimitLine(o(140.0f));
        axisLeft.addLimitLine(o(190.0f));
        LineData lineData = (LineData) ((BaseLineChartComponent) this).f33654a.getData();
        if (lineData == null) {
            return;
        }
        float axisMinimum = ((BaseLineChartComponent) this).f33654a.getXAxis().getAxisMinimum();
        float axisMaximum = ((BaseLineChartComponent) this).f33654a.getXAxis().getAxisMaximum();
        if (axisMaximum <= axisMinimum) {
            axisMaximum = 1.0f + axisMinimum;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Entry(axisMinimum, 190.0f));
        arrayList.add(new Entry(axisMaximum, 190.0f));
        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setHighlightEnabled(false);
        lineDataSet.setColor(0);
        lineDataSet.setLineWidth(0.0f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillDrawable(new ColorDrawable(M));
        lineDataSet.setFillFormatter(new IFillFormatter() { // from class: com.zj.adlib.pr8
            @Override // com.github.mikephil.charting.formatter.IFillFormatter
            public final float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                return StepLineChartComponent.p(iLineDataSet, lineDataProvider);
            }
        });
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(lineDataSet);
        for (int i = 0; i < lineData.getDataSetCount(); i++) {
            arrayList2.add((ILineDataSet) lineData.getDataSetByIndex(i));
        }
        ((BaseLineChartComponent) this).f33654a.setData(new LineData(arrayList2));
    }

    public final LimitLine o(float value) {
        LimitLine limitLine = new LimitLine(value);
        limitLine.setLineColor(N);
        limitLine.setLineWidth(1.0f);
        limitLine.enableDashedLine(8.0f, 6.0f, 0.0f);
        limitLine.setLabel("");
        return limitLine;
    }

    public void q(List<Float> valueList) {
        ((BaseLineChartComponent) this).f33654a.clear();
        initData(valueList);
        n();
        ((BaseLineChartComponent) this).f33654a.postInvalidate();
    }
}
