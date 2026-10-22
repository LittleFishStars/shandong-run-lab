package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o3 extends c0 {
    public RectF d;

    public o3(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iD = this.f22906a.d();
        if (iD <= 1) {
            return;
        }
        int i = 0;
        float fE = 0.0f;
        while (i < iD) {
            this.b.setColor(this.f22906a.a() == i ? this.f22906a.j() : this.f22906a.g());
            int iK = this.f22906a.a() == i ? this.f22906a.k() : this.f22906a.h();
            this.d.set(fE, 0.0f, iK + fE, this.f22906a.c());
            fE += iK + this.f22906a.e();
            canvas.drawRoundRect(this.d, this.f22906a.i(), this.f22906a.i(), this.b);
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iD = this.f22906a.d();
        if (iD <= 1) {
            return;
        }
        int i3 = iD - 1;
        setMeasuredDimension((this.f22906a.e() * i3) + (this.f22906a.h() * i3) + this.f22906a.k(), this.f22906a.c());
    }

    public o3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new RectF();
    }
}
