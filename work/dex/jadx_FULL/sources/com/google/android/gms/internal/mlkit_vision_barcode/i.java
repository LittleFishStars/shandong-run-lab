package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class i extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public final i f31349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zzbu f5753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Collection f5755a;

    @CheckForNull
    public final Collection b;

    public i(zzbu zzbuVar, Object obj, @CheckForNull Collection collection, i iVar) {
        this.f5753a = zzbuVar;
        this.f5754a = obj;
        this.f5755a = collection;
        this.f31349a = iVar;
        this.b = iVar == null ? null : iVar.f5755a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        p();
        boolean zIsEmpty = this.f5755a.isEmpty();
        boolean zAdd = this.f5755a.add(obj);
        if (zAdd) {
            this.f5753a.zzb++;
            if (zIsEmpty) {
                b();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f5755a.addAll(collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.f5755a.size();
        this.f5753a.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        b();
        return true;
    }

    final void b() {
        i iVar = this.f31349a;
        if (iVar != null) {
            iVar.b();
        } else {
            this.f5753a.zza.put(this.f5754a, this.f5755a);
        }
    }

    final void c() {
        i iVar = this.f31349a;
        if (iVar != null) {
            iVar.c();
        } else if (this.f5755a.isEmpty()) {
            this.f5753a.zza.remove(this.f5754a);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f5755a.clear();
        this.f5753a.zzb -= size;
        c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        p();
        return this.f5755a.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        p();
        return this.f5755a.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        p();
        return this.f5755a.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        p();
        return this.f5755a.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        p();
        return new h(this);
    }

    final void p() {
        Collection collection;
        i iVar = this.f31349a;
        if (iVar != null) {
            iVar.p();
            if (this.f31349a.f5755a != this.b) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f5755a.isEmpty() || (collection = (Collection) this.f5753a.zza.get(this.f5754a)) == null) {
                return;
            }
            this.f5755a = collection;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        p();
        boolean zRemove = this.f5755a.remove(obj);
        if (zRemove) {
            this.f5753a.zzb--;
            c();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f5755a.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.f5755a.size();
            this.f5753a.zzb += size2 - size;
            c();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f5755a.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.f5755a.size();
            this.f5753a.zzb += size2 - size;
            c();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        p();
        return this.f5755a.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        p();
        return this.f5755a.toString();
    }
}
