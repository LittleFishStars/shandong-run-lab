package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.cic;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbu f31346a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(zzbu zzbuVar, Map map) {
        super(map);
        this.f31346a = zzbuVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.y, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        cic.a(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return super.f31361a.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || super.f31361a.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return super.f31361a.keySet().hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.y, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new e(this, super.f31361a.entrySet().iterator());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.y, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        Collection collection = (Collection) super.f31361a.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        this.f31346a.zzb -= size;
        return size > 0;
    }
}
