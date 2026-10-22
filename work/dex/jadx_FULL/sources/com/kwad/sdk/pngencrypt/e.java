package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    int bkA;
    int bkB;
    int bkC;
    final k bkt;
    private int bkv;
    private int bkw;
    int bkx;
    int bky;
    int bkz;
    private int bku = 0;
    private int bkD = -1;
    private int bkE = -1;
    private int bkF = 0;
    private boolean bkH = false;
    int bkG = 0;

    public e(k kVar) {
        this.bkt = kVar;
        fm(1);
        fl(0);
    }

    private int Ta() {
        return SZ();
    }

    private void fl(int i) {
        this.bkD = i;
        int i2 = (i * this.bkx) + this.bkz;
        this.bkE = i2;
        if (i2 < 0 || i2 >= this.bkt.bkv) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void fm(int i) {
        if (this.bku == i) {
            return;
        }
        this.bku = i;
        byte[] bArrFn = fn(i);
        byte b = bArrFn[0];
        this.bky = b;
        byte b2 = bArrFn[1];
        this.bkx = b2;
        byte b3 = bArrFn[2];
        this.bkA = b3;
        byte b4 = bArrFn[3];
        this.bkz = b4;
        k kVar = this.bkt;
        int i2 = kVar.bkv;
        this.bkv = i2 > b4 ? (((i2 + b2) - 1) - b4) / b2 : 0;
        int i3 = kVar.bkw;
        int i4 = i3 > b3 ? (((i3 + b) - 1) - b3) / b : 0;
        this.bkw = i4;
        if (i4 == 0) {
            this.bkv = 0;
        }
        int i5 = kVar.bkP;
        this.bkC = b * i5;
        this.bkB = b3 * i5;
    }

    private static byte[] fn(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    public final boolean SU() {
        int i;
        while (true) {
            this.bkF++;
            int i2 = this.bkv;
            if (i2 != 0 && (i = this.bkD) < i2 - 1) {
                fl(i + 1);
                break;
            }
            int i3 = this.bku;
            if (i3 != 7) {
                fm(i3 + 1);
                if (this.bkv != 0) {
                    fl(0);
                    break;
                }
                this.bkF--;
            } else {
                this.bkH = true;
                return false;
            }
        }
        return true;
    }

    public final int SV() {
        return this.bkD;
    }

    public final int SW() {
        return this.bkE;
    }

    public final int SX() {
        return this.bku;
    }

    public final int SY() {
        return this.bkv;
    }

    public final int SZ() {
        return this.bkw;
    }

    public final int Tb() {
        return ((this.bkt.bkU * Ta()) + 7) / 8;
    }
}
