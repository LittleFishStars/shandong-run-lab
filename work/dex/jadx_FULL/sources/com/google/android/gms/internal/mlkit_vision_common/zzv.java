package com.google.android.gms.internal.mlkit_vision_common;

import com.zj.adlib.joc;
import java.util.AbstractMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzv extends zzp {
    final /* synthetic */ zzw zza;

    public zzv(zzw zzwVar) {
        this.zza = zzwVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        joc.a(i, this.zza.zzc, "index");
        zzw zzwVar = this.zza;
        int i2 = i + i;
        Object obj = zzwVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzwVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
