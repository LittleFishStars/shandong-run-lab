package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class asd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzcv f40604a;

    public /* synthetic */ asd(yrd yrdVar, zrd zrdVar) {
        this.f40604a = yrdVar.f46103a;
    }

    @Nullable
    @zzfg(zza = 1)
    public final zzcv a() {
        return this.f40604a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof asd) {
            return i76.b(this.f40604a, ((asd) obj).f40604a);
        }
        return false;
    }

    public final int hashCode() {
        return i76.c(this.f40604a);
    }
}
