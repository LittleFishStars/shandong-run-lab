package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class zzbh extends zzbu implements zzdb {
    public zzbh(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbu
    public /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbu
    public final /* synthetic */ Collection zzb() {
        return Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbu
    public final Collection zzc(Collection collection) {
        return Collections.unmodifiableList(collection);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbu
    public final Collection zzd(Object obj, Collection collection) {
        return zzm(obj, (List) collection, null);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection, java.util.List] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdb
    public final List zze(Object obj) {
        return super.zzj(obj);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection, java.util.List] */
    public final List zzf(@CheckForNull Object obj) {
        return super.zzk(obj);
    }
}
