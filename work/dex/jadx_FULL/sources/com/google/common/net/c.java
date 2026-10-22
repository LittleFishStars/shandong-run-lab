package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.i;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Ints;
import com.ipd.dsp.internal.v0.q;
import com.zj.adlib.u15;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f32225a = '.';

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f6387a = 4;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f6390b = 8;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final CharMatcher f6388a = CharMatcher.q('.');
    public static final char b = ':';

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final CharMatcher f6391b = CharMatcher.q(b);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Inet4Address f6389a = (Inet4Address) g(q.i);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Inet4Address f6392b = (Inet4Address) g("0.0.0.0");

    @Beta
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32226a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Inet4Address f6393a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final Inet4Address f6394b;

        public a(@CheckForNull Inet4Address inet4Address, @CheckForNull Inet4Address inet4Address2, int i, int i2) {
            i.k(i >= 0 && i <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i);
            i.k(i2 >= 0 && i2 <= 65535, "flags '%s' is out of range (0 <= flags <= 0xffff)", i2);
            this.f6393a = (Inet4Address) com.google.common.base.e.a(inet4Address, c.f6392b);
            this.f6394b = (Inet4Address) com.google.common.base.e.a(inet4Address2, c.f6392b);
            this.f32226a = i;
            this.b = i2;
        }

        public Inet4Address a() {
            return this.f6394b;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.f32226a;
        }

        public Inet4Address d() {
            return this.f6393a;
        }
    }

    public static boolean A(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean B(Inet6Address inet6Address) {
        byte b2;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b2 = address[15]) == 0 || b2 == 1)) ? false : true;
    }

    public static boolean C(String str) {
        return z(str) != null;
    }

    public static boolean D(Inet6Address inet6Address) {
        if (G(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean E(String str) {
        byte[] bArrZ = z(str);
        if (bArrZ == null || bArrZ.length != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= 10) {
                for (int i2 = 10; i2 < 12; i2++) {
                    if (bArrZ[i2] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (bArrZ[i] != 0) {
                return false;
            }
            i++;
        }
    }

    public static boolean F(InetAddress inetAddress) {
        for (byte b2 : inetAddress.getAddress()) {
            if (b2 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean G(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean H(String str) {
        return i(str) != null;
    }

    public static short I(String str, int i, int i2) {
        int i3 = i2 - i;
        if (i3 <= 0 || i3 > 4) {
            throw new NumberFormatException();
        }
        int iDigit = 0;
        while (i < i2) {
            iDigit = (iDigit << 4) | Character.digit(str.charAt(i), 16);
            i++;
        }
        return (short) iDigit;
    }

    public static byte J(String str, int i, int i2) {
        int i3 = i2 - i;
        if (i3 <= 0 || i3 > 3) {
            throw new NumberFormatException();
        }
        if (i3 > 1 && str.charAt(i) == '0') {
            throw new NumberFormatException();
        }
        int i4 = 0;
        while (i < i2) {
            int i5 = i4 * 10;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException();
            }
            i4 = i5 + iDigit;
            i++;
        }
        if (i4 <= 255) {
            return (byte) i4;
        }
        throw new NumberFormatException();
    }

    @CheckForNull
    public static byte[] K(String str) {
        if (f6388a.i(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int iIndexOf = str.indexOf(46, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            try {
                bArr[i2] = J(str, i, iIndexOf);
                i = iIndexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    @CheckForNull
    public static byte[] L(String str) {
        int i = f6391b.i(str);
        if (i >= 2 && i <= 8) {
            int i2 = 1;
            int i3 = i + 1;
            int i4 = 8 - i3;
            boolean z = false;
            for (int i5 = 0; i5 < str.length() - 1; i5++) {
                if (str.charAt(i5) == ':' && str.charAt(i5 + 1) == ':') {
                    if (z) {
                        return null;
                    }
                    i4++;
                    if (i5 == 0) {
                        i4++;
                    }
                    if (i5 == str.length() - 2) {
                        i4++;
                    }
                    z = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z && i4 <= 0) {
                return null;
            }
            if (!z && i3 != 8) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i2 = 0;
                }
                while (i2 < str.length()) {
                    int iIndexOf = str.indexOf(58, i2);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    if (str.charAt(i2) == ':') {
                        for (int i6 = 0; i6 < i4; i6++) {
                            byteBufferAllocate.putShort((short) 0);
                        }
                    } else {
                        byteBufferAllocate.putShort(I(str, i2, iIndexOf));
                    }
                    i2 = iIndexOf + 1;
                }
                return byteBufferAllocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String M(InetAddress inetAddress) {
        i.E(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        i.d(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            int i2 = i * 2;
            iArr[i] = Ints.k((byte) 0, (byte) 0, address[i2], address[i2 + 1]);
        }
        d(iArr);
        return x(iArr);
    }

    public static BigInteger N(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String O(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return M(inetAddress);
        }
        String strM = M(inetAddress);
        StringBuilder sb = new StringBuilder(String.valueOf(strM).length() + 2);
        sb.append("[");
        sb.append(strM);
        sb.append("]");
        return sb.toString();
    }

    public static InetAddress b(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static int c(InetAddress inetAddress) {
        return com.google.common.io.b.h(q(inetAddress).getAddress()).readInt();
    }

    public static void d(int[] iArr) {
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < iArr.length + 1; i4++) {
            if (i4 >= iArr.length || iArr[i4] != 0) {
                if (i3 >= 0) {
                    int i5 = i4 - i3;
                    if (i5 > i) {
                        i2 = i3;
                        i = i5;
                    }
                    i3 = -1;
                }
            } else if (i3 < 0) {
                i3 = i4;
            }
        }
        if (i >= 2) {
            Arrays.fill(iArr, i2, i + i2, -1);
        }
    }

    @CheckForNull
    public static String e(String str) {
        int iLastIndexOf = str.lastIndexOf(58) + 1;
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrK = K(str.substring(iLastIndexOf));
        if (bArrK == null) {
            return null;
        }
        String hexString = Integer.toHexString(((bArrK[0] & 255) << 8) | (bArrK[1] & 255));
        String hexString2 = Integer.toHexString((bArrK[3] & 255) | ((bArrK[2] & 255) << 8));
        StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 1 + String.valueOf(hexString).length() + String.valueOf(hexString2).length());
        sb.append(strSubstring);
        sb.append(hexString);
        sb.append(u15.f19942b);
        sb.append(hexString2);
        return sb.toString();
    }

    public static InetAddress f(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        i.u(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return b(address);
    }

    public static InetAddress g(String str) {
        byte[] bArrZ = z(str);
        if (bArrZ != null) {
            return b(bArrZ);
        }
        throw j("'%s' is not an IP string literal.", str);
    }

    public static InetAddress h(String str) {
        InetAddress inetAddressI = i(str);
        if (inetAddressI != null) {
            return inetAddressI;
        }
        throw j("Not a valid URI IP literal: '%s'", str);
    }

    @CheckForNull
    public static InetAddress i(String str) {
        int i;
        i.E(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i = 16;
        } else {
            i = 4;
        }
        byte[] bArrZ = z(str);
        if (bArrZ == null || bArrZ.length != i) {
            return null;
        }
        return b(bArrZ);
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    public static InetAddress k(BigInteger bigInteger, boolean z) {
        i.e(bigInteger.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i = z ? 16 : 4;
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i];
        int iMax = Math.max(0, byteArray.length - i);
        int length = byteArray.length - iMax;
        int i2 = i - length;
        for (int i3 = 0; i3 < iMax; i3++) {
            if (byteArray[i3] != 0) {
                throw j("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i), bigInteger);
            }
        }
        System.arraycopy(byteArray, iMax, bArr, i2, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static Inet4Address l(BigInteger bigInteger) {
        return (Inet4Address) k(bigInteger, false);
    }

    public static Inet6Address m(BigInteger bigInteger) {
        return (Inet6Address) k(bigInteger, true);
    }

    public static Inet4Address n(int i) {
        return t(Ints.C(i));
    }

    public static InetAddress o(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address p(Inet6Address inet6Address) {
        i.u(A(inet6Address), "Address '%s' is not a 6to4 address.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address q(InetAddress inetAddress) {
        boolean z;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            if (i >= 15) {
                z = true;
                break;
            }
            if (address[i] != 0) {
                z = false;
                break;
            }
            i++;
        }
        if (z && address[15] == 1) {
            return f6389a;
        }
        if (z && address[15] == 0) {
            return f6392b;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int iAsInt = Hashing.A().hashLong(w(inet6Address) ? s(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | (-536870912);
        if (iAsInt == -1) {
            iAsInt = -2;
        }
        return t(Ints.C(iAsInt));
    }

    public static Inet4Address r(Inet6Address inet6Address) {
        i.u(B(inet6Address), "Address '%s' is not IPv4-compatible.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address s(Inet6Address inet6Address) {
        if (B(inet6Address)) {
            return r(inet6Address);
        }
        if (A(inet6Address)) {
            return p(inet6Address);
        }
        if (G(inet6Address)) {
            return v(inet6Address).a();
        }
        throw j("'%s' has no embedded IPv4 address.", M(inet6Address));
    }

    public static Inet4Address t(byte[] bArr) {
        i.k(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) b(bArr);
    }

    public static Inet4Address u(Inet6Address inet6Address) {
        i.u(D(inet6Address), "Address '%s' is not an ISATAP address.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static a v(Inet6Address inet6Address) {
        i.u(G(inet6Address), "Address '%s' is not a Teredo address.", M(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4AddressT = t(Arrays.copyOfRange(address, 4, 8));
        int i = com.google.common.io.b.i(address, 8).readShort() & 65535;
        int i2 = 65535 & (~com.google.common.io.b.i(address, 10).readShort());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i3 = 0; i3 < bArrCopyOfRange.length; i3++) {
            bArrCopyOfRange[i3] = (byte) (~bArrCopyOfRange[i3]);
        }
        return new a(inet4AddressT, t(bArrCopyOfRange), i2, i);
    }

    public static boolean w(Inet6Address inet6Address) {
        return B(inet6Address) || A(inet6Address) || G(inet6Address);
    }

    public static String x(int[] iArr) {
        StringBuilder sb = new StringBuilder(39);
        int i = 0;
        boolean z = false;
        while (i < iArr.length) {
            boolean z2 = iArr[i] >= 0;
            if (z2) {
                if (z) {
                    sb.append(b);
                }
                sb.append(Integer.toHexString(iArr[i]));
            } else if (i == 0 || z) {
                sb.append("::");
            }
            i++;
            z = z2;
        }
        return sb.toString();
    }

    public static InetAddress y(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        i.u(length >= 0, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return b(address);
    }

    @CheckForNull
    public static byte[] z(String str) {
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (i >= str.length()) {
                i = -1;
                break;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '.') {
                z = true;
            } else if (cCharAt == ':') {
                if (z) {
                    return null;
                }
                z2 = true;
            } else {
                if (cCharAt == '%') {
                    break;
                }
                if (Character.digit(cCharAt, 16) == -1) {
                    return null;
                }
            }
            i++;
        }
        if (!z2) {
            if (z && i == -1) {
                return K(str);
            }
            return null;
        }
        if (z && (str = e(str)) == null) {
            return null;
        }
        if (i != -1) {
            str = str.substring(0, i);
        }
        return L(str);
    }
}
