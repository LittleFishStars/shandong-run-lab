package com.ipd.dsp.internal.m0;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends IOException {
    public final com.ipd.dsp.internal.i0.b f;

    public f(com.ipd.dsp.internal.i0.b bVar) {
        super("Resume failed because of " + bVar);
        this.f = bVar;
    }

    public com.ipd.dsp.internal.i0.b a() {
        return this.f;
    }
}
