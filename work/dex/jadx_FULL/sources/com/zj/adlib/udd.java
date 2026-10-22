package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_common.zzbo;
import com.google.android.gms.internal.mlkit_common.zzlw;
import com.google.android.gms.internal.mlkit_common.zzlx;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class udd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzlw f45124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzlx f20043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20046a;
    public final String d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f20047b = null;
    public final String c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Long f20045a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Boolean f20044a = null;
    public final Boolean b = null;

    public /* synthetic */ udd(kdd kddVar, rdd rddVar) {
        this.f20046a = kddVar.f17666a;
        this.f20043a = kddVar.f17665a;
        this.d = kddVar.b;
        this.f45124a = kddVar.f42797a;
    }

    @Nullable
    @zzbo(zza = 6)
    public final zzlw a() {
        return this.f45124a;
    }

    @Nullable
    @zzbo(zza = 3)
    public final zzlx b() {
        return this.f20043a;
    }

    @Nullable
    @zzbo(zza = 5)
    public final String c() {
        return this.d;
    }

    @Nullable
    @zzbo(zza = 1)
    public final String d() {
        return this.f20046a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof udd)) {
            return false;
        }
        udd uddVar = (udd) obj;
        return i76.b(this.f20046a, uddVar.f20046a) && i76.b(null, null) && i76.b(this.f20043a, uddVar.f20043a) && i76.b(null, null) && i76.b(this.d, uddVar.d) && i76.b(this.f45124a, uddVar.f45124a) && i76.b(null, null) && i76.b(null, null) && i76.b(null, null);
    }

    public final int hashCode() {
        return i76.c(this.f20046a, null, this.f20043a, null, this.d, this.f45124a, null, null, null);
    }
}
