package com.kwad.framework.filedownloader.a;

import com.ipd.dsp.internal.l0.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.framework.filedownloader.f.c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int ab(long j) {
        if (j < 1048576) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < g.f) {
            return 3;
        }
        return j < g.g ? 4 : 5;
    }
}
