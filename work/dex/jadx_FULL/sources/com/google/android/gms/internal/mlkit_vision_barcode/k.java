package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class k extends i implements List {
    public final /* synthetic */ zzbu b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(zzbu zzbuVar, Object obj, @CheckForNull List list, i iVar) {
        super(zzbuVar, obj, list, iVar);
        this.b = zzbuVar;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        p();
        boolean zIsEmpty = ((i) this).f5755a.isEmpty();
        ((List) ((i) this).f5755a).add(i, obj);
        this.b.zzb++;
        if (zIsEmpty) {
            b();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) ((i) this).f5755a).addAll(i, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = ((i) this).f5755a.size();
        this.b.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        b();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        p();
        return ((List) ((i) this).f5755a).get(i);
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        p();
        return ((List) ((i) this).f5755a).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        p();
        return ((List) ((i) this).f5755a).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        p();
        return new j(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        p();
        Object objRemove = ((List) ((i) this).f5755a).remove(i);
        this.b.zzb--;
        c();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        p();
        return ((List) ((i) this).f5755a).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        p();
        zzbu zzbuVar = this.b;
        Object obj = ((i) this).f5754a;
        List listSubList = ((List) ((i) this).f5755a).subList(i, i2);
        i iVar = ((i) this).f31349a;
        if (iVar == null) {
            iVar = this;
        }
        return zzbuVar.zzm(obj, listSubList, iVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        p();
        return new j(this, i);
    }
}
