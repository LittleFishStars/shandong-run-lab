package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.i;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class SignedBytes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f32242a = 64;

    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int iMin = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < iMin; i++) {
                int iB = SignedBytes.b(bArr[i], bArr2[i]);
                if (iB != 0) {
                    return iB;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static byte a(long j) {
        byte b = (byte) j;
        i.p(((long) b) == j, "Out of range: %s", j);
        return b;
    }

    public static int b(byte b, byte b2) {
        return b - b2;
    }

    public static String c(String str, byte... bArr) {
        i.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            sb.append(str);
            sb.append((int) bArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> d() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte e(byte... bArr) {
        i.d(bArr.length > 0);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    public static byte f(byte... bArr) {
        i.d(bArr.length > 0);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    public static byte g(long j) {
        if (j > 127) {
            return (byte) 127;
        }
        return j < -128 ? UnsignedBytes.f32243a : (byte) j;
    }

    public static void h(byte[] bArr) {
        i.E(bArr);
        i(bArr, 0, bArr.length);
    }

    public static void i(byte[] bArr, int i, int i2) {
        i.E(bArr);
        i.f0(i, i2, bArr.length);
        Arrays.sort(bArr, i, i2);
        Bytes.n(bArr, i, i2);
    }
}
