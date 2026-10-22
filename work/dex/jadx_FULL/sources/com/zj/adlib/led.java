package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_common.zzbo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class led {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final udd f17927a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hed f43052a = null;
    public final hed b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Boolean f17928a = null;

    public /* synthetic */ led(fed fedVar, jed jedVar) {
        this.f17927a = fedVar.f41661a;
    }

    @Nullable
    @zzbo(zza = 1)
    public final udd a() {
        return this.f17927a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof led) && i76.b(this.f17927a, ((led) obj).f17927a) && i76.b(null, null) && i76.b(null, null) && i76.b(null, null);
    }

    public final int hashCode() {
        return i76.c(this.f17927a, null, null, null);
    }
}
