package com.byazt.gy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 54})
public class ve {
    public int[] c = new int[32];
    public int tt;
    public int ve;

    private void sp() {
        int[] iArr = this.c;
        int length = iArr.length;
        int i = this.tt;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.c = iArr2;
        }
    }

    public final void a() {
        int i = this.tt;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.c[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.tt = i - (i3 + 2);
                this.ve--;
            }
        }
    }

    public final void c() {
        this.tt = 0;
        this.ve = 0;
    }

    public final void n() {
        sp();
        int i = this.tt;
        int[] iArr = this.c;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.tt = i + 2;
        this.ve++;
    }

    public final int tt() {
        int i = this.tt;
        if (i == 0) {
            return 0;
        }
        return this.c[i - 1];
    }

    public final int uj() {
        return this.ve;
    }

    public final void ve() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.tt;
        if (i3 == 0 || (i2 = (iArr = this.c)[(i = i3 - 1)]) == 0) {
            return;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.tt = i3 - 2;
    }

    public final void c(int i, int i2) {
        if (this.ve == 0) {
            n();
        }
        sp();
        int i3 = this.tt;
        int i4 = i3 - 1;
        int[] iArr = this.c;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.tt = i3 + 2;
    }
}
