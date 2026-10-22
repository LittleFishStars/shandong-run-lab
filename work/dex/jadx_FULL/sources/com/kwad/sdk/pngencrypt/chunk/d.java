package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public final byte[] blB;
    private CRC32 blE;
    public final String id;
    public final int len;
    public byte[] data = null;
    private long blC = 0;
    public byte[] blD = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.id = str;
        this.blB = b.hp(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.blB[i2];
            if (b < 65 || b > 122 || (b > 90 && b < 97)) {
                new PngjException("Bad id chunk: must be ascii letters " + str);
            }
        }
        if (z) {
            Tn();
        }
    }

    private void Tn() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream To() {
        return new ByteArrayInputStream(this.data);
    }

    public final long Tp() {
        return this.blC;
    }

    public final void aZ(long j) {
        this.blC = j;
    }

    public final void ck(boolean z) {
        int value = (int) this.blE.getValue();
        int iG = com.kwad.sdk.pngencrypt.n.g(this.blD, 0);
        if (value != iG) {
            String str = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.id, Long.valueOf(this.blC), Integer.valueOf(iG), Integer.valueOf(value));
            if (z) {
                new PngjException(str);
            }
        }
    }

    public final void e(byte[] bArr, int i, int i2) {
        if (this.blE == null) {
            this.blE = new CRC32();
        }
        this.blE.update(bArr, i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.id;
        if (str == null) {
            if (dVar.id != null) {
                return false;
            }
        } else if (!str.equals(dVar.id)) {
            return false;
        }
        return this.blC == dVar.blC;
    }

    public final int hashCode() {
        String str = this.id;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.blC;
        return ((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.m(this.blB) + " len=" + this.len;
    }
}
