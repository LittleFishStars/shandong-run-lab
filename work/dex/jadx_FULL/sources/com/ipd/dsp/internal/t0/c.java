package com.ipd.dsp.internal.t0;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends AppCompatImageView implements e {
    public final d<c> f;

    public c(Context context) {
        super(context);
        this.f = new d<>(this);
    }

    @Override // com.ipd.dsp.internal.t0.e
    public void a(a aVar, float f, float f2) {
        d<c> dVar = this.f;
        if (dVar != null) {
            dVar.a(aVar, f, f2);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        d<c> dVar = this.f;
        if (dVar != null) {
            dVar.b(i, i2);
            i = this.f.b();
            i2 = this.f.a();
        }
        super.onMeasure(i, i2);
    }

    @Override // com.ipd.dsp.internal.t0.e
    public void setAspectRatio(float f) {
        d<c> dVar = this.f;
        if (dVar != null) {
            dVar.a(f);
        }
    }

    @Override // com.ipd.dsp.internal.t0.e
    public void setSquare(boolean z) {
        d<c> dVar = this.f;
        if (dVar != null) {
            dVar.a(z);
        }
    }
}
