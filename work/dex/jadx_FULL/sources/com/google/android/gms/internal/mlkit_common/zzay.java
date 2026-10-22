package com.google.android.gms.internal.mlkit_common;

import com.zj.adlib.r8c;
import java.util.AbstractMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzay extends zzar {
    final /* synthetic */ zzaz zza;

    public zzay(zzaz zzazVar) {
        this.zza = zzazVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        r8c.a(i, this.zza.zzc, "index");
        zzaz zzazVar = this.zza;
        int i2 = i + i;
        Object obj = zzazVar.zzb[i2];
        obj.getClass();
        Object obj2 = zzazVar.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
