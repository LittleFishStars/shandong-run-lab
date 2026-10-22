package com.aliyun.svideosdk.editor.impl;

import android.graphics.Paint;
import com.aliyun.svideosdk.editor.AliyunIPaint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class i implements AliyunIPaint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25749a = 10.0f;
    private int b = -1;
    private Paint c;

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public Paint getPaint() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(this.b);
        this.c.setStrokeWidth(this.f25749a);
        return this.c;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public void setCurrentColor(int i) {
        this.b = i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public void setCurrentSize(float f) {
        this.f25749a = f;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPaint
    public void setPaint(Paint paint) {
        this.f25749a = paint.getStrokeWidth();
        this.b = paint.getColor();
    }
}
