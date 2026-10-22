package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ybc;
import java.util.AbstractMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzdo extends zzcv {
    final /* synthetic */ zzdp zza;

    public zzdo(zzdp zzdpVar) {
        this.zza = zzdpVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        ybc.a(i, this.zza.zzc, "index");
        zzdp zzdpVar = this.zza;
        int i2 = i + i;
        Object obj = zzdpVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzdpVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
