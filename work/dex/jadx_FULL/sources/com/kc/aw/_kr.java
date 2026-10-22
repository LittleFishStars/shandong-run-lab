package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kr {
    public static final char[] _a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final char[] _b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
    public static final int[] _c;
    public static final int[] _d;
    public static final _kr _e;

    static {
        int[] iArr = new int[256];
        _c = iArr;
        Arrays.fill(iArr, -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr = _a;
            if (i2 >= 64) {
                break;
            }
            _c[cArr[i2]] = i2;
            i2++;
        }
        _c[61] = -2;
        int[] iArr2 = new int[256];
        _d = iArr2;
        Arrays.fill(iArr2, -1);
        while (true) {
            char[] cArr2 = _b;
            if (i >= 64) {
                _d[61] = -2;
                _e = new _kr();
                return;
            } else {
                _d[cArr2[i]] = i;
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        if (r10 != 18) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] _a(String str) {
        int i;
        int i2;
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        int length = bytes.length;
        int i3 = length + 0;
        if (i3 == 0) {
            i = 0;
        } else {
            int i4 = 2;
            if (i3 < 2) {
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (bytes[length - 1] != 61) {
                i4 = 0;
            } else if (bytes[length - 2] != 61) {
                i4 = 1;
            }
            if (i4 == 0 && (i2 = i3 & 3) != 0) {
                i4 = 4 - i2;
            }
            i = (((i3 + 3) / 4) * 3) - i4;
        }
        byte[] bArr = new byte[i];
        int length2 = bytes.length;
        int[] iArr = _c;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 18;
        while (i5 < length2) {
            int i9 = i5 + 1;
            int i10 = iArr[bytes[i5] & 255];
            if (i10 < 0) {
                if (i10 != -2) {
                    StringBuilder sb_a = _jf._a("Illegal base64 character ");
                    sb_a.append(Integer.toString(bytes[i9 - 1], 16));
                    throw new IllegalArgumentException(sb_a.toString());
                }
                if (i8 != 6) {
                    i5 = i9;
                } else if (i9 != length2 && bytes[i9] == 61) {
                    i9++;
                    i5 = i9;
                }
                throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
            }
            int i11 = (i10 << i8) | i6;
            i8 -= 6;
            if (i8 < 0) {
                int i12 = i7 + 1;
                bArr[i7] = (byte) (i11 >> 16);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i11 >> 8);
                i7 = i13 + 1;
                bArr[i13] = (byte) i11;
                i6 = 0;
                i8 = 18;
            } else {
                i6 = i11;
            }
            i5 = i9;
        }
        if (i8 == 6) {
            bArr[i7] = (byte) (i6 >> 16);
            i7++;
        } else if (i8 == 0) {
            int i14 = i7 + 1;
            bArr[i7] = (byte) (i6 >> 16);
            i7 = i14 + 1;
            bArr[i14] = (byte) (i6 >> 8);
        } else if (i8 == 12) {
            throw new IllegalArgumentException("Last unit does not have enough valid bits");
        }
        if (i5 >= length2) {
            return i7 != i ? Arrays.copyOf(bArr, i7) : bArr;
        }
        throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i5);
    }
}
