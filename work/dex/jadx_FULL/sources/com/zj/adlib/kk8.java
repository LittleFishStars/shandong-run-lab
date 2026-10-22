package com.zj.adlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class kk8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<b> f42842a = new Comparator() { // from class: com.zj.adlib.ik8
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return kk8.g((kk8.b) obj, (kk8.b) obj2);
        }
    };
    public static final Comparator<b> b = new Comparator() { // from class: com.zj.adlib.jk8
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return kk8.h((kk8.b) obj, (kk8.b) obj2);
        }
    };
    public static final int f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17736a;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b[] f17738a = new b[5];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<b> f17737a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f17739b = -1;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f42843a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f17740a;
        public int b;

        public b() {
        }
    }

    public kk8(int i2) {
        this.f17736a = i2;
    }

    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f17740a - bVar2.f17740a;
    }

    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f42843a, bVar2.f42843a);
    }

    public void c(int i2, float f2) {
        b bVar;
        d();
        int i3 = this.e;
        if (i3 > 0) {
            b[] bVarArr = this.f17738a;
            int i4 = i3 - 1;
            this.e = i4;
            bVar = bVarArr[i4];
        } else {
            bVar = new b();
        }
        int i5 = this.c;
        this.c = i5 + 1;
        bVar.f17740a = i5;
        bVar.b = i2;
        bVar.f42843a = f2;
        this.f17737a.add(bVar);
        this.d += i2;
        while (true) {
            int i6 = this.d;
            int i7 = this.f17736a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            b bVar2 = this.f17737a.get(0);
            int i9 = bVar2.b;
            if (i9 <= i8) {
                this.d -= i9;
                this.f17737a.remove(0);
                int i10 = this.e;
                if (i10 < 5) {
                    b[] bVarArr2 = this.f17738a;
                    this.e = i10 + 1;
                    bVarArr2[i10] = bVar2;
                }
            } else {
                bVar2.b = i9 - i8;
                this.d -= i8;
            }
        }
    }

    public final void d() {
        if (this.f17739b != 1) {
            Collections.sort(this.f17737a, f42842a);
            this.f17739b = 1;
        }
    }

    public final void e() {
        if (this.f17739b != 0) {
            Collections.sort(this.f17737a, b);
            this.f17739b = 0;
        }
    }

    public float f(float f2) {
        e();
        float f3 = f2 * this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f17737a.size(); i3++) {
            b bVar = this.f17737a.get(i3);
            i2 += bVar.b;
            if (i2 >= f3) {
                return bVar.f42843a;
            }
        }
        if (this.f17737a.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.f17737a;
        return arrayList.get(arrayList.size() - 1).f42843a;
    }

    public void i() {
        this.f17737a.clear();
        this.f17739b = -1;
        this.c = 0;
        this.d = 0;
    }
}
