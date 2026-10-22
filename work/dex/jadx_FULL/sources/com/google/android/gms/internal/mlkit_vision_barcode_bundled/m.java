package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m extends zzcm implements RandomAccess, zzel, zzfw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f31386a = new m(new double[0], 0, false);
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double[] f5814a;

    public m() {
        this(new double[10], 0, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel W(int i) {
        if (i >= this.K) {
            return new m(Arrays.copyOf(this.f5814a, i), this.K, true);
        }
        throw new IllegalArgumentException();
    }

    public final void a(double d) {
        zza();
        int i = this.K;
        double[] dArr = this.f5814a;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f5814a = dArr2;
        }
        double[] dArr3 = this.f5814a;
        int i2 = this.K;
        this.K = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        if (i < 0 || i > (i2 = this.K)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        double[] dArr = this.f5814a;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f5814a, i, dArr2, i + 1, this.K - i);
            this.f5814a = dArr2;
        }
        this.f5814a[i] = dDoubleValue;
        this.K++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = rmc.f19385a;
        collection.getClass();
        if (!(collection instanceof m)) {
            return super.addAll(collection);
        }
        m mVar = (m) collection;
        int i = mVar.K;
        if (i == 0) {
            return false;
        }
        int i2 = this.K;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.f5814a;
        if (i3 > dArr.length) {
            this.f5814a = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(mVar.f5814a, 0, this.f5814a, this.K, mVar.K);
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
        if (!(obj instanceof m)) {
            return super.equals(obj);
        }
        m mVar = (m) obj;
        if (this.K != mVar.K) {
            return false;
        }
        double[] dArr = mVar.f5814a;
        for (int i = 0; i < this.K; i++) {
            if (Double.doubleToLongBits(this.f5814a[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        c(i);
        return Double.valueOf(this.f5814a[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.K; i2++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.f5814a[i2]);
            byte[] bArr = rmc.f19385a;
            i = (i * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i = this.K;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f5814a[i2] == dDoubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        c(i);
        double[] dArr = this.f5814a;
        double d = dArr[i];
        int i2 = this.K;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.K--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f5814a;
        System.arraycopy(dArr, i2, dArr, i, this.K - i2);
        this.K -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zza();
        c(i);
        double[] dArr = this.f5814a;
        double d = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.K;
    }

    public m(double[] dArr, int i, boolean z) {
        super(z);
        this.f5814a = dArr;
        this.K = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }
}
