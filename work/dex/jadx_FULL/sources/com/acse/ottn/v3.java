package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v3 extends c0 {
    public v3(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f22906a.d() <= 1) {
            return;
        }
        this.b.setColor(this.f22906a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f22906a.c()), this.f22906a.i(), this.f22906a.i(), this.b);
        this.b.setColor(this.f22906a.j());
        int iA = this.f22906a.a() * this.f22906a.k();
        canvas.drawRoundRect(new RectF(iA, 0.0f, iA + this.f22906a.k(), this.f22906a.c()), this.f22906a.i(), this.f22906a.i(), this.b);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iD = this.f22906a.d();
        if (iD <= 1) {
            return;
        }
        setMeasuredDimension(this.f22906a.k() * iD, this.f22906a.c());
    }

    public v3(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public v3(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b.setStyle(Paint.Style.FILL);
    }
}
