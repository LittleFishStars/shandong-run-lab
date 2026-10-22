package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z extends zzcm implements RandomAccess, zzel, zzfw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f31399a = new z(new long[0], 0, false);
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f5832a;

    public z() {
        this(new long[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel W(int i) {
        if (i >= this.K) {
            return new z(Arrays.copyOf(this.f5832a, i), this.K, true);
        }
        throw new IllegalArgumentException();
    }

    public final long a(int i) {
        d(i);
        return this.f5832a[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i < 0 || i > (i2 = this.K)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        long[] jArr = this.f5832a;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f5832a, i, jArr2, i + 1, this.K - i);
            this.f5832a = jArr2;
        }
        this.f5832a[i] = jLongValue;
        this.K++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = rmc.f19385a;
        collection.getClass();
        if (!(collection instanceof z)) {
            return super.addAll(collection);
        }
        z zVar = (z) collection;
        int i = zVar.K;
        if (i == 0) {
            return false;
        }
        int i2 = this.K;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f5832a;
        if (i3 > jArr.length) {
            this.f5832a = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(zVar.f5832a, 0, this.f5832a, this.K, zVar.K);
        this.K = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(long j) {
        zza();
        int i = this.K;
        long[] jArr = this.f5832a;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f5832a = jArr2;
        }
        long[] jArr3 = this.f5832a;
        int i2 = this.K;
        this.K = i2 + 1;
        jArr3[i2] = j;
    }

    public final String c(int i) {
        return "Index:" + i + ", Size:" + this.K;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.K) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return super.equals(obj);
        }
        z zVar = (z) obj;
        if (this.K != zVar.K) {
            return false;
        }
        long[] jArr = zVar.f5832a;
        for (int i = 0; i < this.K; i++) {
            if (this.f5832a[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        d(i);
        return Long.valueOf(this.f5832a[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.K; i2++) {
            long j = this.f5832a[i2];
            byte[] bArr = rmc.f19385a;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.K;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f5832a[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        d(i);
        long[] jArr = this.f5832a;
        long j = jArr[i];
        int i2 = this.K;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.K--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f5832a;
        System.arraycopy(jArr, i2, jArr, i, this.K - i2);
        this.K -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        d(i);
        long[] jArr = this.f5832a;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.K;
    }

    public z(long[] jArr, int i, boolean z) {
        super(z);
        this.f5832a = jArr;
        this.K = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        b(((Long) obj).longValue());
        return true;
    }
}
