package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vrc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aac f45435a = new aac();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f20293a;

    public vrc() {
    }

    public final vrc a(zzs zzsVar) {
        r8c.c(this.f20293a, "Must call internal() or external() before appending rules.");
        this.f45435a.b(zzsVar);
        return this;
    }

    public final vrc b() {
        r8c.e(this.f20293a == null, "A SourcePolicy can only set internal() or external() once.");
        this.f20293a = Boolean.FALSE;
        return this;
    }

    public final vrc c() {
        r8c.e(this.f20293a == null, "A SourcePolicy can only set internal() or external() once.");
        this.f20293a = Boolean.TRUE;
        return this;
    }

    public final pzc d() {
        r8c.c(this.f20293a, "Must call internal() or external() when building a SourcePolicy.");
        return new pzc(this.f20293a.booleanValue(), false, this.f45435a.c(), null);
    }

    public /* synthetic */ vrc(hoc hocVar) {
    }
}
