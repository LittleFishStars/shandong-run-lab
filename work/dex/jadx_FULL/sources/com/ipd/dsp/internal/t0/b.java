package com.ipd.dsp.internal.t0;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends com.ipd.dsp.internal.x1.c implements e {
    public final d<b> g;

    public b(Context context) {
        super(context);
        this.g = new d<>(this);
    }

    @Override // com.ipd.dsp.internal.t0.e
    public void a(a aVar, float f, float f2) {
        d<b> dVar = this.g;
        if (dVar != null) {
            dVar.a(aVar, f, f2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        d<b> dVar = this.g;
        if (dVar != null) {
            dVar.b(i, i2);
            i = this.g.b();
            i2 = this.g.a();
        }
        super.onMeasure(i, i2);
    }

    @Override // com.ipd.dsp.internal.t0.e
    public void setAspectRatio(float f) {
        d<b> dVar = this.g;
        if (dVar != null) {
            dVar.a(f);
        }
    }

    @Override // com.ipd.dsp.internal.t0.e
    public void setSquare(boolean z) {
        d<b> dVar = this.g;
        if (dVar != null) {
            dVar.a(z);
        }
    }
}
