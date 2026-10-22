package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class crc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzcv f41033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzpj f15878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final asd f15879a;
    public final zzcv b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Boolean f15882b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Boolean f15881a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ukd f15880a = null;

    public /* synthetic */ crc(vqc vqcVar, yqc yqcVar) {
        this.f15878a = vqcVar.f20272a;
        this.f15882b = vqcVar.f20274a;
        this.f15879a = vqcVar.f20273a;
        this.f41033a = vqcVar.f45422a;
        this.b = vqcVar.b;
    }

    @Nullable
    @zzfg(zza = 6)
    public final zzcv a() {
        return this.f41033a;
    }

    @Nullable
    @zzfg(zza = 7)
    public final zzcv b() {
        return this.b;
    }

    @Nullable
    @zzfg(zza = 1)
    public final zzpj c() {
        return this.f15878a;
    }

    @Nullable
    @zzfg(zza = 5)
    public final asd d() {
        return this.f15879a;
    }

    @Nullable
    @zzfg(zza = 3)
    public final Boolean e() {
        return this.f15882b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof crc)) {
            return false;
        }
        crc crcVar = (crc) obj;
        return i76.b(this.f15878a, crcVar.f15878a) && i76.b(null, null) && i76.b(this.f15882b, crcVar.f15882b) && i76.b(null, null) && i76.b(this.f15879a, crcVar.f15879a) && i76.b(this.f41033a, crcVar.f41033a) && i76.b(this.b, crcVar.b);
    }

    public final int hashCode() {
        return i76.c(this.f15878a, null, this.f15882b, null, this.f15879a, this.f41033a, this.b);
    }
}
