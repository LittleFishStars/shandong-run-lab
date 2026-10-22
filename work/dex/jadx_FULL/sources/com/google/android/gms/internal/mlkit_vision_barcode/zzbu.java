package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.ybc;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzbu extends zzby implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzbu(Map map) {
        ybc.c(map.isEmpty());
        this.zza = map;
    }

    public static /* bridge */ /* synthetic */ void zzr(zzbu zzbuVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzbuVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzbuVar.zzb -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb() {
        throw null;
    }

    public Collection zzc(Collection collection) {
        throw null;
    }

    public Collection zzd(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final int zzh() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    public final Collection zzi() {
        return this instanceof zzdt ? new m(this) : new l(this);
    }

    public final Collection zzj(Object obj) {
        Collection collectionZza = (Collection) this.zza.get(obj);
        if (collectionZza == null) {
            collectionZza = zza();
        }
        return zzd(obj, collectionZza);
    }

    public final Collection zzk(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return zzb();
        }
        Collection collectionZza = zza();
        collectionZza.addAll(collection);
        this.zzb -= collection.size();
        collection.clear();
        return zzc(collectionZza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    public final Iterator zzl() {
        return new a(this);
    }

    public final List zzm(Object obj, List list, @CheckForNull i iVar) {
        return list instanceof RandomAccess ? new g(this, obj, list, iVar) : new k(this, obj, list, iVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    public final Map zzo() {
        return new d(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby
    public final Set zzp() {
        return new f(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final void zzs() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby, com.google.android.gms.internal.mlkit_vision_barcode.zzdj
    public final boolean zzt(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(obj, collectionZza);
        return true;
    }
}
