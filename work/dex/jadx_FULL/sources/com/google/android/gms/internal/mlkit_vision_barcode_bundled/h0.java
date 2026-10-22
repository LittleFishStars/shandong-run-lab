package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h0 extends zzcm implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f31377a = new h0(new Object[0], 0, false);
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f5806a;

    public h0() {
        this(new Object[10], 0, true);
    }

    public static h0 b() {
        return f31377a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final /* bridge */ /* synthetic */ zzel W(int i) {
        if (i >= this.K) {
            return new h0(Arrays.copyOf(this.f5806a, i), this.K, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.K)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        Object[] objArr = this.f5806a;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f5806a, i, objArr2, i + 1, this.K - i);
            this.f5806a = objArr2;
        }
        this.f5806a[i] = obj;
        this.K++;
        ((AbstractList) this).modCount++;
    }

    public final String c(int i) {
        return "Index:" + i + ", Size:" + this.K;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.K) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        d(i);
        return this.f5806a[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zza();
        d(i);
        Object[] objArr = this.f5806a;
        Object obj = objArr[i];
        int i2 = this.K;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.K--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zza();
        d(i);
        Object[] objArr = this.f5806a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.K;
    }

    public h0(Object[] objArr, int i, boolean z) {
        super(z);
        this.f5806a = objArr;
        this.K = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i = this.K;
        Object[] objArr = this.f5806a;
        if (i == objArr.length) {
            this.f5806a = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f5806a;
        int i2 = this.K;
        this.K = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
