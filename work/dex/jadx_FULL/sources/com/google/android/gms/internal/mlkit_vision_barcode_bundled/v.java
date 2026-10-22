package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.qwc;
import com.zj.adlib.rmc;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v extends zzcm implements RandomAccess, zzew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f31397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Deprecated
    public static final zzew f5830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f5831a;

    static {
        v vVar = new v(false);
        f31397a = vVar;
        f5830a = vVar;
    }

    public v() {
        this(10);
    }

    public static String b(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzdb ? ((zzdb) obj).zzt(rmc.b) : rmc.d((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final zzew F() {
        return r() ? new qwc(this) : this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel W(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f5831a);
        return new v(arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.f5831a.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdb) {
            zzdb zzdbVar = (zzdb) obj;
            String strZzt = zzdbVar.zzt(rmc.b);
            if (zzdbVar.zzn()) {
                this.f5831a.set(i, strZzt);
            }
            return strZzt;
        }
        byte[] bArr = (byte[]) obj;
        String strD = rmc.d(bArr);
        if (u0.g(bArr)) {
            this.f5831a.set(i, strD);
        }
        return strD;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.f5831a.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzew) {
            collection = ((zzew) collection).b0();
        }
        boolean zAddAll = this.f5831a.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final List b0() {
        return Collections.unmodifiableList(this.f5831a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.f5831a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew
    public final Object k(int i) {
        return this.f5831a.get(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.f5831a.remove(i);
        ((AbstractList) this).modCount++;
        return b(objRemove);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return b(this.f5831a.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5831a.size();
    }

    public v(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.f5831a = arrayList;
    }

    public v(ArrayList arrayList) {
        super(true);
        this.f5831a = arrayList;
    }

    public v(boolean z) {
        super(false);
        this.f5831a = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
