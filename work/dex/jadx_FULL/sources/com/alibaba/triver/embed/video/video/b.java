package com.alibaba.triver.embed.video.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f24901a;
    private final Paint b;
    private final float c;
    private final float d;
    private final float e;
    private int f;
    private final float g;
    private final float h;
    private final float i;

    public b(Context context, float f, float f2, float f3, int i, float f4, float f5, int i2) {
        this.c = f;
        this.d = f + f3;
        this.e = f2;
        int i3 = i - 1;
        this.f = i3;
        this.f24901a = f3 / i3;
        float fApplyDimension = TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
        this.g = fApplyDimension;
        this.h = f2 - (fApplyDimension / 2.0f);
        this.i = f2 + (fApplyDimension / 2.0f);
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(i2);
        paint.setStrokeWidth(f5);
        paint.setAntiAlias(true);
    }

    public void a(Canvas canvas) {
        b(canvas);
    }

    public float b() {
        return this.d;
    }

    public float a() {
        return this.c;
    }

    public int b(f fVar) {
        float fW = fVar.w() - this.c;
        float f = this.f24901a;
        return (int) ((fW + (f / 2.0f)) / f);
    }

    private void b(Canvas canvas) {
        for (int i = 0; i < this.f; i++) {
            float f = (i * this.f24901a) + this.c;
            canvas.drawLine(f, this.h, f, this.i, this.b);
        }
        float f2 = this.d;
        canvas.drawLine(f2, this.h, f2, this.i, this.b);
    }

    public float a(f fVar) {
        return this.c + (b(fVar) * this.f24901a);
    }

    public void a(int i) {
        float f = this.d - this.c;
        int i2 = i - 1;
        this.f = i2;
        this.f24901a = f / i2;
    }
}
