package com.alibaba.ariver.kernel.api.bytedata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ByteOrderValues {
    public static final int BIG_ENDIAN = 1;
    public static final int LITTLE_ENDIAN = 2;

    private ByteOrderValues() {
    }

    public static boolean getBoolean(byte[] bArr) {
        return bArr[0] > 0;
    }

    public static byte getByte(byte[] bArr) {
        return getByte(bArr, 1);
    }

    public static double getDouble(byte[] bArr) {
        return getDouble(bArr, 1);
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 1);
    }

    public static int getInt(byte[] bArr) {
        return getInt(bArr, 1);
    }

    public static long getLong(byte[] bArr) {
        return getLong(bArr, 1);
    }

    public static short getShort(byte[] bArr) {
        return getShort(bArr, 1);
    }

    public static void putBoolean(boolean z, byte[] bArr) {
        bArr[0] = z ? (byte) 1 : (byte) 0;
    }

    public static void putByte(byte b, byte[] bArr) {
        putByte(b, bArr, 1);
    }

    public static void putDouble(double d, byte[] bArr) {
        putDouble(d, bArr, 1);
    }

    public static void putFloat(float f, byte[] bArr) {
        putFloat(f, bArr, 1);
    }

    public static void putInt(int i, byte[] bArr) {
        putInt(i, bArr, 1);
    }

    public static void putLong(long j, byte[] bArr) {
        putLong(j, bArr, 1);
    }

    public static void putShort(short s, byte[] bArr) {
        putShort(s, bArr, 1);
    }

    public static byte getByte(byte[] bArr, int i) {
        return bArr[0];
    }

    public static double getDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(getLong(bArr, i));
    }

    public static float getFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(getInt(bArr, i));
    }

    public static int getInt(byte[] bArr, int i) {
        int i2;
        byte b;
        if (i == 1) {
            i2 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
            b = bArr[3];
        } else {
            i2 = ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
            b = bArr[0];
        }
        return (b & 255) | i2;
    }

    public static long getLong(byte[] bArr, int i) {
        return i == 1 ? (((long) (bArr[0] & 255)) << 56) | (((long) (bArr[1] & 255)) << 48) | (((long) (bArr[2] & 255)) << 40) | (((long) (bArr[3] & 255)) << 32) | (((long) (bArr[4] & 255)) << 24) | (((long) (bArr[5] & 255)) << 16) | (((long) (bArr[6] & 255)) << 8) | ((long) (bArr[7] & 255)) : (((long) (bArr[7] & 255)) << 56) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[1] & 255)) << 8) | ((long) (bArr[0] & 255));
    }

    public static short getShort(byte[] bArr, int i) {
        int i2;
        byte b;
        if (i == 1) {
            i2 = (bArr[0] & 255) << 8;
            b = bArr[1];
        } else {
            i2 = (bArr[1] & 255) << 8;
            b = bArr[0];
        }
        return (short) ((b & 255) | i2);
    }

    public static void putByte(byte b, byte[] bArr, int i) {
        bArr[0] = b;
    }

    public static void putDouble(double d, byte[] bArr, int i) {
        putLong(Double.doubleToLongBits(d), bArr, i);
    }

    public static void putFloat(float f, byte[] bArr, int i) {
        putInt(Float.floatToIntBits(f), bArr, i);
    }

    public static void putInt(int i, byte[] bArr, int i2) {
        if (i2 == 1) {
            bArr[0] = (byte) (i >> 24);
            bArr[1] = (byte) (i >> 16);
            bArr[2] = (byte) (i >> 8);
            bArr[3] = (byte) i;
            return;
        }
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) (i >> 24);
    }

    public static void putLong(long j, byte[] bArr, int i) {
        if (i == 1) {
            bArr[0] = (byte) (j >> 56);
            bArr[1] = (byte) (j >> 48);
            bArr[2] = (byte) (j >> 40);
            bArr[3] = (byte) (j >> 32);
            bArr[4] = (byte) (j >> 24);
            bArr[5] = (byte) (j >> 16);
            bArr[6] = (byte) (j >> 8);
            bArr[7] = (byte) j;
            return;
        }
        bArr[0] = (byte) j;
        bArr[1] = (byte) (j >> 8);
        bArr[2] = (byte) (j >> 16);
        bArr[3] = (byte) (j >> 24);
        bArr[4] = (byte) (j >> 32);
        bArr[5] = (byte) (j >> 40);
        bArr[6] = (byte) (j >> 48);
        bArr[7] = (byte) (j >> 56);
    }

    public static void putShort(short s, byte[] bArr, int i) {
        if (i == 1) {
            bArr[0] = (byte) (s >> 8);
            bArr[1] = (byte) s;
        } else {
            bArr[0] = (byte) s;
            bArr[1] = (byte) (s >> 8);
        }
    }
}
