package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.i;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class UnsignedBytes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f32243a = -128;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f6435a = 255;
    public static final byte b = -1;

    @VisibleForTesting
    public static class LexicographicalComparatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f32244a = LexicographicalComparatorHolder.class.getName().concat("$UnsafeComparator");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final Comparator<byte[]> f6436a = a();

        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                for (int i = 0; i < iMin; i++) {
                    int iB = UnsignedBytes.b(bArr[i], bArr2[i]);
                    if (iB != 0) {
                        return iB;
                    }
                }
                return bArr.length - bArr2.length;
            }
        }

        @VisibleForTesting
        public enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            public class a implements PrivilegedExceptionAction<Unsafe> {
                @Override // java.security.PrivilegedExceptionAction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            }

            static {
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int iArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = iArrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || iArrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe getUnsafe() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e) {
                        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new a());
                }
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                int i = iMin & (-8);
                int i2 = 0;
                while (i2 < i) {
                    Unsafe unsafe = theUnsafe;
                    int i3 = BYTE_ARRAY_BASE_OFFSET;
                    long j = i2;
                    long j2 = unsafe.getLong(bArr, ((long) i3) + j);
                    long j3 = unsafe.getLong(bArr2, ((long) i3) + j);
                    if (j2 != j3) {
                        if (BIG_ENDIAN) {
                            return UnsignedLongs.a(j2, j3);
                        }
                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j2 ^ j3) & (-8);
                        return ((int) ((j2 >>> iNumberOfTrailingZeros) & 255)) - ((int) ((j3 >>> iNumberOfTrailingZeros) & 255));
                    }
                    i2 += 8;
                }
                while (i2 < iMin) {
                    int iB = UnsignedBytes.b(bArr[i2], bArr2[i2]);
                    if (iB != 0) {
                        return iB;
                    }
                    i2++;
                }
                return bArr.length - bArr2.length;
            }
        }

        public static Comparator<byte[]> a() {
            try {
                Object[] enumConstants = Class.forName(f32244a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.f();
            }
        }
    }

    @CanIgnoreReturnValue
    public static byte a(long j) {
        i.p((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int b(byte b2, byte b3) {
        return p(b2) - p(b3);
    }

    public static byte c(byte b2) {
        return (byte) (b2 ^ f32243a);
    }

    public static String d(String str, byte... bArr) {
        i.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(p(bArr[0]));
        for (int i = 1; i < bArr.length; i++) {
            sb.append(str);
            sb.append(q(bArr[i]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> e() {
        return LexicographicalComparatorHolder.f6436a;
    }

    @VisibleForTesting
    public static Comparator<byte[]> f() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte g(byte... bArr) {
        i.d(bArr.length > 0);
        int iP = p(bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            int iP2 = p(bArr[i]);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return (byte) iP;
    }

    public static byte h(byte... bArr) {
        i.d(bArr.length > 0);
        int iP = p(bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            int iP2 = p(bArr[i]);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return (byte) iP;
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte i(String str) {
        return j(str, 10);
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte j(String str, int i) {
        int i2 = Integer.parseInt((String) i.E(str), i);
        if ((i2 >> 8) == 0) {
            return (byte) i2;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("out of range: ");
        sb.append(i2);
        throw new NumberFormatException(sb.toString());
    }

    public static byte k(long j) {
        if (j > p((byte) -1)) {
            return (byte) -1;
        }
        if (j < 0) {
            return (byte) 0;
        }
        return (byte) j;
    }

    public static void l(byte[] bArr) {
        i.E(bArr);
        m(bArr, 0, bArr.length);
    }

    public static void m(byte[] bArr, int i, int i2) {
        i.E(bArr);
        i.f0(i, i2, bArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3] = c(bArr[i3]);
        }
        Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = c(bArr[i]);
            i++;
        }
    }

    public static void n(byte[] bArr) {
        i.E(bArr);
        o(bArr, 0, bArr.length);
    }

    public static void o(byte[] bArr, int i, int i2) {
        i.E(bArr);
        i.f0(i, i2, bArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ 127);
        }
        Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = (byte) (bArr[i] ^ 127);
            i++;
        }
    }

    public static int p(byte b2) {
        return b2 & 255;
    }

    @Beta
    public static String q(byte b2) {
        return r(b2, 10);
    }

    @Beta
    public static String r(byte b2, int i) {
        i.k(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        return Integer.toString(p(b2), i);
    }
}
