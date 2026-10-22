package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t extends zzcm implements RandomAccess, zzej, zzfw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f31394a = new t(new int[0], 0, false);
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f5826a;

    public t() {
        this(new int[10], 0, true);
    }

    public static t b() {
        return f31394a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel W(int i) {
        if (i >= this.K) {
            return new t(Arrays.copyOf(this.f5826a, i), this.K, true);
        }
        throw new IllegalArgumentException();
    }

    public final int a(int i) {
        e(i);
        return this.f5826a[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        zza();
        if (i < 0 || i > (i2 = this.K)) {
            throw new IndexOutOfBoundsException(d(i));
        }
        int[] iArr = this.f5826a;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f5826a, i, iArr2, i + 1, this.K - i);
            this.f5826a = iArr2;
        }
        this.f5826a[i] = iIntValue;
        this.K++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = rmc.f19385a;
        collection.getClass();
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i = tVar.K;
        if (i == 0) {
            return false;
        }
        int i2 = this.K;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f5826a;
        if (i3 > iArr.length) {
            this.f5826a = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(tVar.f5826a, 0, this.f5826a, this.K, tVar.K);
        this.K = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void c(int i) {
        zza();
        int i2 = this.K;
        int[] iArr = this.f5826a;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f5826a = iArr2;
        }
        int[] iArr3 = this.f5826a;
        int i3 = this.K;
        this.K = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final String d(int i) {
        return "Index:" + i + ", Size:" + this.K;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.K) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.K != tVar.K) {
            return false;
        }
        int[] iArr = tVar.f5826a;
        for (int i = 0; i < this.K; i++) {
            if (this.f5826a[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Integer.valueOf(this.f5826a[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.K; i2++) {
            i = (i * 31) + this.f5826a[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.K;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f5826a[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        e(i);
        int[] iArr = this.f5826a;
        int i2 = iArr[i];
        int i3 = this.K;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.K--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f5826a;
        System.arraycopy(iArr, i2, iArr, i, this.K - i2);
        this.K -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zza();
        e(i);
        int[] iArr = this.f5826a;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.K;
    }

    public t(int[] iArr, int i, boolean z) {
        super(z);
        this.f5826a = iArr;
        this.K = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        c(((Integer) obj).intValue());
        return true;
    }
}
