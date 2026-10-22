package com.google.android.exoplayer2.extractor.avi;

import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30636a;

    public f(String str) {
        this.f30636a = str;
    }

    public static f a(om6 om6Var) {
        return new f(om6Var.D(om6Var.a()));
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return 1852994675;
    }
}
