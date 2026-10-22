package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.cic;
import com.zj.adlib.zic;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends zzdh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbu f31343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final transient Map f5746a;

    public d(zzbu zzbuVar, Map map) {
        this.f31343a = zzbuVar;
        this.f5746a = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Collection get(@CheckForNull Object obj) {
        Collection collection = (Collection) zic.a(this.f5746a, obj);
        if (collection == null) {
            return null;
        }
        return this.f31343a.zzd(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map = this.f5746a;
        zzbu zzbuVar = this.f31343a;
        if (map == zzbuVar.zza) {
            zzbuVar.zzs();
        } else {
            cic.a(new c(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return zic.b(this.f5746a, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.f5746a.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f5746a.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f31343a.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.f5746a.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionZza = this.f31343a.zza();
        collectionZza.addAll(collection);
        this.f31343a.zzb -= collection.size();
        collection.clear();
        return collectionZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5746a.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f5746a.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh
    public final Set zzb() {
        return new b(this);
    }
}
