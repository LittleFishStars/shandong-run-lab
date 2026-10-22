package com.ipd.dsp.internal.q;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends com.ipd.dsp.internal.s.d<BitmapDrawable> implements com.ipd.dsp.internal.i.r {
    public final com.ipd.dsp.internal.j.e g;

    public c(BitmapDrawable bitmapDrawable, com.ipd.dsp.internal.j.e eVar) {
        super(bitmapDrawable);
        this.g = eVar;
    }

    @Override // com.ipd.dsp.internal.s.d, com.ipd.dsp.internal.i.r
    public void a() {
        ((BitmapDrawable) this.f).getBitmap().prepareToDraw();
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return com.ipd.dsp.internal.d0.o.a(((BitmapDrawable) this.f).getBitmap());
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
        this.g.a(((BitmapDrawable) this.f).getBitmap());
    }
}
