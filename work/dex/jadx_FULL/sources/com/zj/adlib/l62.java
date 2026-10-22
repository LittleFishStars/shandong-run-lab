package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class l62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f17884a;

    public l62(int i, byte[] bArr) {
        this.f43003a = i;
        this.f17884a = bArr;
    }

    public static l62[] b(byte[] bArr, km9 km9Var) {
        km9.c cVarD = km9Var.d();
        km9.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (km9.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        l62[] l62VarArr = new l62[iA];
        int i = 0;
        for (km9.b bVar2 : bVarArrA) {
            int i2 = 0;
            while (i2 < bVar2.a()) {
                int iB = bVar2.b();
                l62VarArr[i] = new l62(iB, new byte[cVarD.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = l62VarArr[0].f17884a.length - cVarD.b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                l62VarArr[i6].f17884a[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = km9Var.i() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            l62VarArr[i8].f17884a[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = l62VarArr[0].f17884a.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                l62VarArr[i10].f17884a[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return l62VarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.f17884a;
    }

    public int c() {
        return this.f43003a;
    }
}
