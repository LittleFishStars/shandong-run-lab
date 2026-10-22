package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ed extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25912a = Color.argb(255, 235, 235, 235);
    public static final int b = Color.argb(255, 21, 21, 21);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f794a;

    public ed(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f794a = paint;
        paint.setAntiAlias(true);
        this.f794a.setColor(f25912a);
    }

    public final void a(int i) {
        Paint paint = this.f794a;
        if (paint != null) {
            paint.setColor(i);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f794a);
    }

    public final void a() {
        setVisibility(8);
    }
}
