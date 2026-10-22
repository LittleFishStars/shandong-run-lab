package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends zzz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzag f31328a;

    public a(zzag zzagVar, int i) {
        super(zzagVar.size(), i);
        this.f31328a = zzagVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final Object zza(int i) {
        return this.f31328a.get(i);
    }
}
