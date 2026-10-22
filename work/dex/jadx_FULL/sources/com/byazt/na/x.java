package com.byazt.na;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 71})
public final class x extends uj {
    public final transient byte[][] sp;
    public final transient int[] x;

    public x(c cVar, int i) {
        super(null);
        da.c(cVar.tt, 0L, i);
        a aVar = cVar.c;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = aVar.ve;
            int i6 = aVar.tt;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            aVar = aVar.f28805a;
        }
        this.sp = new byte[i4][];
        this.x = new int[i4 * 2];
        a aVar2 = cVar.c;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.sp;
            bArr[i7] = aVar2.c;
            int i8 = aVar2.ve;
            int i9 = aVar2.tt;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.x;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            aVar2.uj = true;
            i7++;
            aVar2 = aVar2.f28805a;
        }
    }

    private uj n() {
        return new uj(uj());
    }

    @Override // com.byazt.na.uj
    public String c() {
        return n().c();
    }

    @Override // com.byazt.na.uj
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof uj) {
            uj ujVar = (uj) obj;
            if (ujVar.ve() == ve() && c(0, ujVar, 0, ve())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.na.uj
    public int hashCode() {
        int i = this.n;
        if (i != 0) {
            return i;
        }
        int length = this.sp.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.sp[i2];
            int[] iArr = this.x;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.n = i3;
        return i3;
    }

    @Override // com.byazt.na.uj
    public String toString() {
        return n().toString();
    }

    @Override // com.byazt.na.uj
    public String tt() {
        return n().tt();
    }

    @Override // com.byazt.na.uj
    public byte[] uj() {
        int[] iArr = this.x;
        byte[][] bArr = this.sp;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.x;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.sp[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.byazt.na.uj
    public int ve() {
        return this.x[this.sp.length - 1];
    }

    private int tt(int i) {
        int iBinarySearch = Arrays.binarySearch(this.x, 0, this.sp.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.byazt.na.uj
    public uj c(int i, int i2) {
        return n().c(i, i2);
    }

    @Override // com.byazt.na.uj
    public byte c(int i) {
        da.c(this.x[this.sp.length - 1], i, 1L);
        int iTt = tt(i);
        int i2 = iTt == 0 ? 0 : this.x[iTt - 1];
        int[] iArr = this.x;
        byte[][] bArr = this.sp;
        return bArr[iTt][(i - i2) + iArr[bArr.length + iTt]];
    }

    @Override // com.byazt.na.uj
    public boolean c(int i, uj ujVar, int i2, int i3) {
        if (i < 0 || i > ve() - i3) {
            return false;
        }
        int iTt = tt(i);
        while (i3 > 0) {
            int i4 = iTt == 0 ? 0 : this.x[iTt - 1];
            int iMin = Math.min(i3, ((this.x[iTt] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr = this.sp;
            if (!ujVar.c(i2, bArr[iTt], (i - i4) + iArr[bArr.length + iTt], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iTt++;
        }
        return true;
    }

    @Override // com.byazt.na.uj
    public boolean c(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > ve() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iTt = tt(i);
        while (i3 > 0) {
            int i4 = iTt == 0 ? 0 : this.x[iTt - 1];
            int iMin = Math.min(i3, ((this.x[iTt] - i4) + i4) - i);
            int[] iArr = this.x;
            byte[][] bArr2 = this.sp;
            if (!da.c(bArr2[iTt], (i - i4) + iArr[bArr2.length + iTt], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iTt++;
        }
        return true;
    }
}
