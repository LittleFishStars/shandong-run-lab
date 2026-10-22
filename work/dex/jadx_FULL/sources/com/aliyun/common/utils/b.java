package com.aliyun.common.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements Comparable<b>, Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25577a;
    private final int b;
    private static final SparseArray<SparseArray<b>> c = new SparseArray<>(16);
    public static final Parcelable.Creator<b> CREATOR = new a();

    public static class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return b.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(int i, int i2) {
        this.f25577a = i;
        this.b = i2;
    }

    private static int a(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    public static b b(int i, int i2) {
        int iA = a(i, i2);
        int i3 = i / iA;
        int i4 = i2 / iA;
        SparseArray<SparseArray<b>> sparseArray = c;
        SparseArray<b> sparseArray2 = sparseArray.get(i3);
        if (sparseArray2 == null) {
            b bVar = new b(i3, i4);
            SparseArray<b> sparseArray3 = new SparseArray<>();
            sparseArray3.put(i4, bVar);
            sparseArray.put(i3, sparseArray3);
            return bVar;
        }
        b bVar2 = sparseArray2.get(i4);
        if (bVar2 != null) {
            return bVar2;
        }
        b bVar3 = new b(i3, i4);
        sparseArray2.put(i4, bVar3);
        return bVar3;
    }

    public float a() {
        return this.f25577a / this.b;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (equals(bVar)) {
            return 0;
        }
        return a() - bVar.a() > 0.0f ? 1 : -1;
    }

    public boolean a(Size size) {
        int iA = a(size.getWidth(), size.getHeight());
        return this.f25577a == size.getWidth() / iA && this.b == size.getHeight() / iA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f25577a == bVar.f25577a && this.b == bVar.b;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.f25577a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.f25577a + u15.f19942b + this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f25577a);
        parcel.writeInt(this.b);
    }
}
