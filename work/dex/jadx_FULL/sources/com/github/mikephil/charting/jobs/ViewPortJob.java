package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
    protected Transformer mTrans;
    protected ViewPortHandler mViewPortHandler;
    protected float[] pts = new float[2];
    protected View view;
    protected float xValue;
    protected float yValue;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        this.mViewPortHandler = viewPortHandler;
        this.xValue = f;
        this.yValue = f2;
        this.mTrans = transformer;
        this.view = view;
    }

    public float getXValue() {
        return this.xValue;
    }

    public float getYValue() {
        return this.yValue;
    }
}
