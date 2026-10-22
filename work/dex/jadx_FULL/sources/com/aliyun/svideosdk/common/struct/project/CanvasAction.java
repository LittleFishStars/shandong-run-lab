package com.aliyun.svideosdk.common.struct.project;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CanvasAction {
    public static final float TOUCH_TOLERANCE = 4.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f25674a;
    float b;
    public Paint paint;
    public Path path;

    public CanvasAction(float f, float f2, Paint paint) {
        this.path = new Path();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setStrokeJoin(Paint.Join.ROUND);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStyle(Paint.Style.STROKE);
        this.path.moveTo(f, f2);
        this.path.lineTo(f, f2);
        this.f25674a = f;
        this.b = f2;
    }

    public CanvasAction(Paint paint, Path path) {
        this.paint = paint;
        this.path = path;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public Path getPath() {
        return this.path;
    }

    public void move(float f, float f2, Canvas canvas) {
        float fAbs = Math.abs(f - this.f25674a);
        float fAbs2 = Math.abs(this.b - f2);
        if (fAbs >= 4.0f || fAbs2 >= 4.0f) {
            Path path = this.path;
            float f3 = this.f25674a;
            float f4 = this.b;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.f25674a = f;
            this.b = f2;
        }
        canvas.drawPath(this.path, this.paint);
    }

    public void point(float f, float f2, Canvas canvas) {
        canvas.drawPoint(f, f2, this.paint);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
