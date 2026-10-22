package com.zj.adlib;

import android.content.Context;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.ip;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bcb extends ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f40722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15487a;

    public bcb(Context context, boolean z) {
        this.f40722a = context;
        this.f15487a = z;
    }

    @Override // com.amap.api.col.p0003l.ip
    public final boolean c() {
        return fj.Y(this.f40722a) == 1 || this.f15487a;
    }
}
