package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i extends zzcm implements RandomAccess, zzel, zzfw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f31378a = new i(new boolean[0], 0, false);
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f5807a;

    public i() {
        this(new boolean[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel W(int i) {
        if (i >= this.K) {
            return new i(Arrays.copyOf(this.f5807a, i), this.K, true);
        }
        throw new IllegalArgumentException();
    }

    public final void a(boolean z) {
        zza();
        int i = this.K;
        boolean[] zArr = this.f5807a;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f5807a = zArr2;
        }
        boolean[] zArr3 = this.f5807a;
        int i2 = this.K;
        this.K = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i < 0 || i > (i2 = this.K)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        boolean[] zArr = this.f5807a;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f5807a, i, zArr2, i + 1, this.K - i);
            this.f5807a = zArr2;
        }
        this.f5807a[i] = zBooleanValue;
        this.K++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = rmc.f19385a;
        collection.getClass();
        if (!(collection instanceof i)) {
            return super.addAll(collection);
        }
        i iVar = (i) collection;
        int i = iVar.K;
        if (i == 0) {
            return false;
        }
        int i2 = this.K;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.f5807a;
        if (i3 > zArr.length) {
            this.f5807a = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(iVar.f5807a, 0, this.f5807a, this.K, iVar.K);
        this.K = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final String b(int i) {
        return "Index:" + i + ", Size:" + this.K;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.K) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return super.equals(obj);
        }
        i iVar = (i) obj;
        if (this.K != iVar.K) {
            return false;
        }
        boolean[] zArr = iVar.f5807a;
        for (int i = 0; i < this.K; i++) {
            if (this.f5807a[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        c(i);
        return Boolean.valueOf(this.f5807a[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.K; i++) {
            iA = (iA * 31) + rmc.a(this.f5807a[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.K;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f5807a[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        c(i);
        boolean[] zArr = this.f5807a;
        boolean z = zArr[i];
        int i2 = this.K;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.K--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f5807a;
        System.arraycopy(zArr, i2, zArr, i, this.K - i2);
        this.K -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zza();
        c(i);
        boolean[] zArr = this.f5807a;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.K;
    }

    public i(boolean[] zArr, int i, boolean z) {
        super(z);
        this.f5807a = zArr;
        this.K = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }
}
