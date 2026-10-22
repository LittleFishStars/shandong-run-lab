package com.alibaba.triver.embed.video.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f24902a;
    private final float b;
    private final float c;

    public c(Context context, float f, float f2, int i) {
        float fApplyDimension = TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        this.b = fApplyDimension;
        Paint paint = new Paint();
        this.f24902a = paint;
        paint.setColor(i);
        paint.setStrokeWidth(fApplyDimension);
        paint.setAntiAlias(true);
        this.c = f;
    }

    public void a(Canvas canvas, f fVar, f fVar2) {
        canvas.drawLine(fVar.w(), this.c, fVar2.w(), this.c, this.f24902a);
    }
}
