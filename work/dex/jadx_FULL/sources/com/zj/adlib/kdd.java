package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzlw;
import com.google.android.gms.internal.mlkit_common.zzlx;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kdd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzlw f42797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzlx f17665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17666a;
    public String b;

    public final kdd a(String str) {
        this.b = str;
        return this;
    }

    public final kdd b(zzlw zzlwVar) {
        this.f42797a = zzlwVar;
        return this;
    }

    public final kdd c(String str) {
        this.f17666a = str;
        return this;
    }

    public final kdd d(zzlx zzlxVar) {
        this.f17665a = zzlxVar;
        return this;
    }

    public final udd g() {
        return new udd(this, null);
    }
}
