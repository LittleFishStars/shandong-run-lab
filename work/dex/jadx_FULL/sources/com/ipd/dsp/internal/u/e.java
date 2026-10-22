package com.ipd.dsp.internal.u;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.i.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends com.ipd.dsp.internal.s.d<c> implements r {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.ipd.dsp.internal.s.d, com.ipd.dsp.internal.i.r
    public void a() {
        ((c) this.f).e().prepareToDraw();
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return ((c) this.f).j();
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<c> d() {
        return c.class;
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
        ((c) this.f).stop();
        ((c) this.f).m();
    }
}
