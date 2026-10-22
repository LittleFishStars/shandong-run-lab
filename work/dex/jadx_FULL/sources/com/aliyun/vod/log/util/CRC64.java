package com.aliyun.vod.log.util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CRC64 {
    private static final long[] crcTable = new long[256];
    private static final long poly = -3932672073523589310L;
    private long crc = -1;

    static {
        for (int i = 0; i < crcTable.length; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j & 1) == 1 ? (j >>> 1) ^ poly : j >>> 1;
            }
            crcTable[i] = j;
        }
    }

    public long getValue() {
        return ~this.crc;
    }

    public void update(byte b) {
        long[] jArr = crcTable;
        long j = this.crc;
        this.crc = (j >>> 8) ^ jArr[(b ^ ((int) j)) & 255];
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            long[] jArr = crcTable;
            int i4 = i + 1;
            byte b = bArr[i];
            long j = this.crc;
            this.crc = (j >>> 8) ^ jArr[(b ^ ((int) j)) & 255];
            i = i4;
        }
    }
}
