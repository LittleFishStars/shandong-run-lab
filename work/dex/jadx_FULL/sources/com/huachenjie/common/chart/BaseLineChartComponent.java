package com.huachenjie.common.chart;

import android.content.res.Resources;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.core.content.res.ResourcesCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseLineChartComponent<T> extends BaseComponent<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LineChart f33654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Float> f8532a;

    public class a implements IFillFormatter {
        public a() {
        }

        @Override // com.github.mikephil.charting.formatter.IFillFormatter
        public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
            return BaseLineChartComponent.this.f33654a.getAxisLeft().getAxisMinimum();
        }
    }

    public BaseLineChartComponent(T context) {
        super(context);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    public abstract int d();

    public boolean drawFilled() {
        return true;
    }

    public boolean drawValue() {
        return false;
    }

    @ColorRes
    public abstract int e();

    public boolean enableDashedHighlightLine() {
        return false;
    }

    public abstract float f();

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        LineChart lineChart = (LineChart) a(d());
        this.f33654a = lineChart;
        lineChart.setBackgroundColor(-1);
        this.f33654a.getDescription().setEnabled(false);
        this.f33654a.setTouchEnabled(false);
        this.f33654a.setDrawGridBackground(false);
        this.f33654a.setDragEnabled(true);
        this.f33654a.setScaleEnabled(true);
        this.f33654a.setPinchZoom(false);
        XAxis xAxis = this.f33654a.getXAxis();
        if (useXGridDashedLine()) {
            xAxis.enableGridDashedLine(getXGridDashedLineLength(), getXGridDashedLineSpaceLength(), 0.0f);
        } else {
            xAxis.disableGridDashedLine();
        }
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(getXLabelCount(), true);
        Resources resources = b().getResources();
        int i = R.color.percent_60_translucent_black;
        xAxis.setTextColor(ResourcesCompat.getColor(resources, i, null));
        YAxis axisLeft = this.f33654a.getAxisLeft();
        this.f33654a.getAxisRight().setEnabled(false);
        axisLeft.enableGridDashedLine(getYGridDashedLineLength(), getYGridDashedLineSpaceLength(), 0.0f);
        axisLeft.setLabelCount(getYLabelCount(), true);
        axisLeft.setAxisLineColor(ResourcesCompat.getColor(b().getResources(), R.color.transparent, null));
        axisLeft.setTextColor(ResourcesCompat.getColor(b().getResources(), i, null));
        this.f33654a.getLegend().setForm(Legend.LegendForm.LINE);
    }

    public float g(List<Float> valueList) {
        if (valueList == null || valueList.isEmpty()) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Float> it = valueList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int i2 = 0;
            while (i2 < (arrayList.size() - 1) - i) {
                int i3 = i2 + 1;
                if (((Float) arrayList.get(i2)).floatValue() > ((Float) arrayList.get(i3)).floatValue()) {
                    float fFloatValue = ((Float) arrayList.get(i2)).floatValue();
                    arrayList.set(i2, (Float) arrayList.get(i3));
                    arrayList.set(i3, Float.valueOf(fFloatValue));
                }
                i2 = i3;
            }
        }
        int iFloatValue = (int) ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (iFloatValue % 4 > 0) {
            iFloatValue = ((iFloatValue / 4) + 1) * 4;
        }
        return iFloatValue;
    }

    public Drawable getFilledDrawable() {
        return ResourcesCompat.getDrawable(b().getResources(), R.drawable.shape_chart_fill, null);
    }

    public float getXGridDashedLineLength() {
        return 0.0f;
    }

    public float getXGridDashedLineSpaceLength() {
        return 5.0f;
    }

    public int getXLabelCount() {
        return 6;
    }

    public float getYGridDashedLineLength() {
        return 5.0f;
    }

    public float getYGridDashedLineSpaceLength() {
        return 5.0f;
    }

    public int getYLabelCount() {
        return 5;
    }

    public float h(int xValue) {
        if (xValue % 5 > 0) {
            xValue = ((xValue / 5) + 1) * 5;
        }
        return xValue;
    }

    public float i() {
        List<Float> list = this.f8532a;
        if (list == null) {
            return 0.0f;
        }
        return h(list.size());
    }

    public void initData(List<Float> list) {
        if (list == null) {
            this.f8532a = new ArrayList();
        } else {
            this.f8532a = list;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.f8532a.size()) {
            int i2 = i + 1;
            arrayList.add(new Entry(i2, this.f8532a.get(i).floatValue(), (Drawable) null));
            i = i2;
        }
        if (this.f33654a.getData() != null && ((LineData) this.f33654a.getData()).getDataSetCount() > 0) {
            LineDataSet lineDataSet = (LineDataSet) ((LineData) this.f33654a.getData()).getDataSetByIndex(0);
            lineDataSet.setValues(arrayList);
            lineDataSet.notifyDataSetChanged();
            ((LineData) this.f33654a.getData()).notifyDataChanged();
            this.f33654a.notifyDataSetChanged();
            return;
        }
        LineDataSet lineDataSet2 = new LineDataSet(arrayList, "");
        lineDataSet2.setDrawIcons(false);
        lineDataSet2.enableDashedLine(10.0f, 5.0f, 0.0f);
        lineDataSet2.disableDashedLine();
        lineDataSet2.setColor(ResourcesCompat.getColor(b().getResources(), e(), null));
        lineDataSet2.setLineWidth(f());
        lineDataSet2.setDrawCircles(true);
        lineDataSet2.setCircleRadius(f() / 2.0f);
        lineDataSet2.setCircleColor(ResourcesCompat.getColor(b().getResources(), e(), null));
        lineDataSet2.setDrawCircleHole(false);
        lineDataSet2.setFormLineWidth(5.0f);
        lineDataSet2.setFormLineDashEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        lineDataSet2.setFormSize(0.0f);
        lineDataSet2.setDrawValues(drawValue());
        lineDataSet2.setValueTextSize(9.0f);
        if (enableDashedHighlightLine()) {
            lineDataSet2.enableDashedHighlightLine(10.0f, 0.0f, 0.0f);
        } else {
            lineDataSet2.disableDashedHighlightLine();
        }
        lineDataSet2.setDrawFilled(drawFilled());
        lineDataSet2.setFillFormatter(new a());
        if (Utils.getSDKInt() >= 18) {
            lineDataSet2.setFillDrawable(getFilledDrawable());
        } else {
            lineDataSet2.setFillColor(0);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(lineDataSet2);
        this.f33654a.setData(new LineData(arrayList2));
        this.f33654a.getXAxis().setAxisMaximum(i());
        this.f33654a.getXAxis().setAxisMinimum(j());
        this.f33654a.getAxisLeft().setAxisMaximum(k());
        this.f33654a.getAxisLeft().setAxisMinimum(l());
        this.f33654a.postInvalidate();
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
    }

    public float j() {
        return 0.0f;
    }

    public float k() {
        List<Float> list = this.f8532a;
        if (list == null) {
            return 0.0f;
        }
        return g(list);
    }

    public float l() {
        return 0.0f;
    }

    public boolean useXGridDashedLine() {
        return true;
    }
}
