package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 137})
public final class nu extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient byte[][] f28793a;
    public final transient int[] sp;

    public nu(ve veVar, int i) {
        super(null);
        rl.c(veVar.tt, 0L, i);
        z zVar = veVar.c;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = zVar.ve;
            int i6 = zVar.tt;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            zVar = zVar.f28794a;
        }
        this.f28793a = new byte[i4][];
        this.sp = new int[i4 * 2];
        z zVar2 = veVar.c;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f28793a;
            bArr[i7] = zVar2.c;
            int i8 = zVar2.ve;
            int i9 = zVar2.tt;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.sp;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            zVar2.uj = true;
            i7++;
            zVar2 = zVar2.f28794a;
        }
    }

    private a i() {
        return new a(x());
    }

    @Override // com.byazt.mk.a
    public a a() {
        return i().a();
    }

    @Override // com.byazt.mk.a
    public String c() {
        return i().c();
    }

    @Override // com.byazt.mk.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.sp() == sp() && c(0, aVar, 0, sp())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.mk.a
    public int hashCode() {
        int i = this.uj;
        if (i != 0) {
            return i;
        }
        int length = this.f28793a.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f28793a[i2];
            int[] iArr = this.sp;
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
        this.uj = i3;
        return i3;
    }

    @Override // com.byazt.mk.a
    public String n() {
        return i().n();
    }

    @Override // com.byazt.mk.a
    public int sp() {
        return this.sp[this.f28793a.length - 1];
    }

    @Override // com.byazt.mk.a
    public String toString() {
        return i().toString();
    }

    @Override // com.byazt.mk.a
    public String tt() {
        return i().tt();
    }

    @Override // com.byazt.mk.a
    public a uj() {
        return i().uj();
    }

    @Override // com.byazt.mk.a
    public a ve() {
        return i().ve();
    }

    @Override // com.byazt.mk.a
    public byte[] x() {
        int[] iArr = this.sp;
        byte[][] bArr = this.f28793a;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.sp;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f28793a[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    private int tt(int i) {
        int iBinarySearch = Arrays.binarySearch(this.sp, 0, this.f28793a.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.byazt.mk.a
    public a c(int i, int i2) {
        return i().c(i, i2);
    }

    @Override // com.byazt.mk.a
    public byte c(int i) {
        rl.c(this.sp[this.f28793a.length - 1], i, 1L);
        int iTt = tt(i);
        int i2 = iTt == 0 ? 0 : this.sp[iTt - 1];
        int[] iArr = this.sp;
        byte[][] bArr = this.f28793a;
        return bArr[iTt][(i - i2) + iArr[bArr.length + iTt]];
    }

    @Override // com.byazt.mk.a
    public void c(ve veVar) {
        int length = this.f28793a.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.sp;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            z zVar = new z(this.f28793a[i], i3, (i3 + i4) - i2, true, false);
            z zVar2 = veVar.c;
            if (zVar2 == null) {
                zVar.sp = zVar;
                zVar.f28794a = zVar;
                veVar.c = zVar;
            } else {
                zVar2.sp.c(zVar);
            }
            i++;
            i2 = i4;
        }
        veVar.tt += (long) i2;
    }

    @Override // com.byazt.mk.a
    public boolean c(int i, a aVar, int i2, int i3) {
        if (i < 0 || i > sp() - i3) {
            return false;
        }
        int iTt = tt(i);
        while (i3 > 0) {
            int i4 = iTt == 0 ? 0 : this.sp[iTt - 1];
            int iMin = Math.min(i3, ((this.sp[iTt] - i4) + i4) - i);
            int[] iArr = this.sp;
            byte[][] bArr = this.f28793a;
            if (!aVar.c(i2, bArr[iTt], (i - i4) + iArr[bArr.length + iTt], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iTt++;
        }
        return true;
    }

    @Override // com.byazt.mk.a
    public boolean c(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > sp() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iTt = tt(i);
        while (i3 > 0) {
            int i4 = iTt == 0 ? 0 : this.sp[iTt - 1];
            int iMin = Math.min(i3, ((this.sp[iTt] - i4) + i4) - i);
            int[] iArr = this.sp;
            byte[][] bArr2 = this.f28793a;
            if (!rl.c(bArr2[iTt], (i - i4) + iArr[bArr2.length + iTt], bArr, i2, iMin)) {
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
