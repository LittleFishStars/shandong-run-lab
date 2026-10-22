package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IMarker {
    void draw(Canvas canvas, float f, float f2);

    MPPointF getOffset();

    MPPointF getOffsetForDrawingAtPoint(float f, float f2);

    void refreshContent(Entry entry, Highlight highlight);
}
