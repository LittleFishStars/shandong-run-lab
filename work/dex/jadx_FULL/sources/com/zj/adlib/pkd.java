package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzoq;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzoq f44004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f18881a;

    public final pkd a(zzoq zzoqVar) {
        this.f44004a = zzoqVar;
        return this;
    }

    public final pkd b(Integer num) {
        this.f18881a = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final ukd d() {
        return new ukd(this, null);
    }
}
