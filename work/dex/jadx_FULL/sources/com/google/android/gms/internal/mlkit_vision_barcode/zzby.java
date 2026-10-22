package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzby implements zzdj {

    @CheckForNull
    private transient Collection zza;

    @CheckForNull
    private transient Set zzb;

    @CheckForNull
    private transient Map zzc;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdj) {
            return zzv().equals(((zzdj) obj).zzv());
        }
        return false;
    }

    public final int hashCode() {
        return zzv().hashCode();
    }

    public final String toString() {
        return zzv().toString();
    }

    public abstract Collection zzi();

    public abstract Iterator zzl();

    public abstract Map zzo();

    public abstract Set zzp();

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public boolean zzt(Object obj, Object obj2) {
        throw null;
    }

    public final Collection zzu() {
        Collection collection = this.zza;
        if (collection != null) {
            return collection;
        }
        Collection collectionZzi = zzi();
        this.zza = collectionZzi;
        return collectionZzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final Map zzv() {
        Map map = this.zzc;
        if (map != null) {
            return map;
        }
        Map mapZzo = zzo();
        this.zzc = mapZzo;
        return mapZzo;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final Set zzw() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        Set setZzp = zzp();
        this.zzb = setZzp;
        return setZzp;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final boolean zzx(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection collection = ((d) zzv()).get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final boolean zzy(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection collection = ((d) zzv()).get(obj);
        return collection != null && collection.remove(obj2);
    }
}
