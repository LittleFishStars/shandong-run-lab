package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k {
    public final int bkO;
    public final int bkP;
    public final boolean bkQ;
    public final boolean bkR;
    public final boolean bkS;
    public final boolean bkT;
    public final int bkU;
    public final int bkV;
    public final int bkW;
    public final int bkX;
    public final int bkY;
    public final int bkv;
    public final int bkw;
    private long bkZ = -1;
    private long bla = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        int i4;
        this.bkw = i;
        this.bkv = i2;
        this.bkQ = z;
        this.bkS = z3;
        this.bkR = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        if (z2 || z3) {
            i4 = z ? 2 : 1;
        } else {
            i4 = z ? 4 : 3;
        }
        this.bkP = i4;
        this.bkO = i3;
        boolean z4 = i3 < 8;
        this.bkT = z4;
        int i5 = i4 * i3;
        this.bkU = i5;
        this.bkV = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.bkW = i6;
        int i7 = i4 * i;
        this.bkX = i7;
        this.bkY = z4 ? i6 : i7;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            if (!z3 && !z2) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i3);
            }
        } else if (i3 != 8) {
            if (i3 != 16) {
                throw new PngjException("invalid bitdepth=" + i3);
            }
            if (z3) {
                throw new PngjException("indexed can't have bitdepth=" + i3);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        }
        if (i2 > 0 && i2 <= 16777216) {
            if (i7 <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.bkQ == kVar.bkQ && this.bkO == kVar.bkO && this.bkw == kVar.bkw && this.bkR == kVar.bkR && this.bkS == kVar.bkS && this.bkv == kVar.bkv;
    }

    public final int hashCode() {
        return (((((((((((this.bkQ ? 1231 : 1237) + 31) * 31) + this.bkO) * 31) + this.bkw) * 31) + (this.bkR ? 1231 : 1237)) * 31) + (this.bkS ? 1231 : 1237)) * 31) + this.bkv;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.bkw + ", rows=" + this.bkv + ", bitDepth=" + this.bkO + ", channels=" + this.bkP + ", alpha=" + this.bkQ + ", greyscale=" + this.bkR + ", indexed=" + this.bkS + "]";
    }
}
