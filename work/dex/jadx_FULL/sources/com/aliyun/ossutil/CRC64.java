package com.aliyun.ossutil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CRC64 {
    private static final long POLY = -3932672073523589310L;
    private static final long[] table = new long[256];
    private long value = 0;

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j & 1) == 1 ? (j >>> 1) ^ POLY : j >>> 1;
            }
            table[i] = j;
        }
    }

    public String getValue() {
        long j = this.value;
        long j2 = (j >>> 1) / 5;
        return String.valueOf(j2) + (j - (10 * j2));
    }

    public void update(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            update(bArr[i2]);
        }
    }

    public void update(byte b) {
        long j = ~this.value;
        this.value = ~((j >>> 8) ^ table[((int) (((long) b) ^ j)) & 255]);
    }
}
