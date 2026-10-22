package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzoq;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ukd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzoq f45168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f20087a;
    public final Integer b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Boolean f20086a = null;

    public /* synthetic */ ukd(pkd pkdVar, skd skdVar) {
        this.f45168a = pkdVar.f44004a;
        this.f20087a = pkdVar.f18881a;
    }

    @Nullable
    @zzfg(zza = 1)
    public final zzoq a() {
        return this.f45168a;
    }

    @Nullable
    @zzfg(zza = 2)
    public final Integer b() {
        return this.f20087a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ukd)) {
            return false;
        }
        ukd ukdVar = (ukd) obj;
        return i76.b(this.f45168a, ukdVar.f45168a) && i76.b(this.f20087a, ukdVar.f20087a) && i76.b(null, null) && i76.b(null, null);
    }

    public final int hashCode() {
        return i76.c(this.f45168a, this.f20087a, null, null);
    }
}
