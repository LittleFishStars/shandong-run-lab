package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p extends zzcm implements RandomAccess, zzei, zzfw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f31390a = new p(new float[0], 0, false);
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f5821a;

    public p() {
        this(new float[10], 0, true);
    }

    public static p b() {
        return f31390a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei
    public final void S(float f) {
        zza();
        int i = this.K;
        float[] fArr = this.f5821a;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f5821a = fArr2;
        }
        float[] fArr3 = this.f5821a;
        int i2 = this.K;
        this.K = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        if (i < 0 || i > (i2 = this.K)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        float[] fArr = this.f5821a;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f5821a, i, fArr2, i + 1, this.K - i);
            this.f5821a = fArr2;
        }
        this.f5821a[i] = fFloatValue;
        this.K++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = rmc.f19385a;
        collection.getClass();
        if (!(collection instanceof p)) {
            return super.addAll(collection);
        }
        p pVar = (p) collection;
        int i = pVar.K;
        if (i == 0) {
            return false;
        }
        int i2 = this.K;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.f5821a;
        if (i3 > fArr.length) {
            this.f5821a = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(pVar.f5821a, 0, this.f5821a, this.K, pVar.K);
        this.K = i3;
        ((AbstractList) this).modCount++;
        return true;
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
        if (!(obj instanceof p)) {
            return super.equals(obj);
        }
        p pVar = (p) obj;
        if (this.K != pVar.K) {
            return false;
        }
        float[] fArr = pVar.f5821a;
        for (int i = 0; i < this.K; i++) {
            if (Float.floatToIntBits(this.f5821a[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        d(i);
        return Float.valueOf(this.f5821a[i]);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.K; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f5821a[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.K;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f5821a[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final zzei W(int i) {
        if (i >= this.K) {
            return new p(Arrays.copyOf(this.f5821a, i), this.K, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        d(i);
        float[] fArr = this.f5821a;
        float f = fArr[i];
        int i2 = this.K;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.K--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f5821a;
        System.arraycopy(fArr, i2, fArr, i, this.K - i2);
        this.K -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zza();
        d(i);
        float[] fArr = this.f5821a;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.K;
    }

    public p(float[] fArr, int i, boolean z) {
        super(z);
        this.f5821a = fArr;
        this.K = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        S(((Float) obj).floatValue());
        return true;
    }
}
