package com.google.android.gms.internal.mlkit_common;

import com.zj.adlib.r8c;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzaq extends zzar {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzar zzc;

    public zzaq(zzar zzarVar, int i, int i2) {
        this.zzc = zzarVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        r8c.a(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzar, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzan
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzan
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzan
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzar
    /* JADX INFO: renamed from: zzf */
    public final zzar subList(int i, int i2) {
        r8c.d(i, i2, this.zzb);
        zzar zzarVar = this.zzc;
        int i3 = this.zza;
        return zzarVar.subList(i + i3, i2 + i3);
    }
}
