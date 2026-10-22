package com.kwad.sdk.core.a;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static class b {
        static final b aSD = new b(false, null, -1, true);
        static final b aSE = new b(true, null, -1, false);
        private static final char[] toBase64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] toBase64URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean doPadding;
        private final boolean isURL;
        private final byte[] newline = null;
        private final int linemax = -1;

        private b(boolean z, byte[] bArr, int i, boolean z2) {
            this.isURL = z;
            this.doPadding = z2;
        }

        private int encode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            char[] cArr = this.isURL ? toBase64URL : toBase64;
            int i3 = ((i2 + 0) / 3) * 3;
            int i4 = i3 + 0;
            int i5 = this.linemax;
            if (i5 > 0 && i3 > (i5 / 4) * 3) {
                i3 = (i5 / 4) * 3;
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                int iMin = Math.min(i6 + i3, i4);
                int i8 = i6;
                int i9 = i7;
                while (i8 < iMin) {
                    int i10 = i8 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((bArr[i8] & 255) << 16) | ((bArr[i10] & 255) << 8);
                    int i13 = i11 + 1;
                    int i14 = i12 | (bArr[i11] & 255);
                    int i15 = i9 + 1;
                    bArr2[i9] = (byte) cArr[(i14 >>> 18) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i14 >>> 12) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) cArr[(i14 >>> 6) & 63];
                    i9 = i17 + 1;
                    bArr2[i17] = (byte) cArr[i14 & 63];
                    i8 = i13;
                }
                int i18 = ((iMin - i6) / 3) * 4;
                i7 += i18;
                if (i18 == this.linemax && iMin < i2) {
                    byte[] bArr3 = this.newline;
                    int length = bArr3.length;
                    int i19 = 0;
                    while (i19 < length) {
                        bArr2[i7] = bArr3[i19];
                        i19++;
                        i7++;
                    }
                }
                i6 = iMin;
            }
            if (i6 >= i2) {
                return i7;
            }
            int i20 = i6 + 1;
            int i21 = bArr[i6] & 255;
            int i22 = i7 + 1;
            bArr2[i7] = (byte) cArr[i21 >> 2];
            if (i20 == i2) {
                int i23 = i22 + 1;
                bArr2[i22] = (byte) cArr[(i21 << 4) & 63];
                if (!this.doPadding) {
                    return i23;
                }
                int i24 = i23 + 1;
                bArr2[i23] = 61;
                int i25 = i24 + 1;
                bArr2[i24] = 61;
                return i25;
            }
            int i26 = bArr[i20] & 255;
            int i27 = i22 + 1;
            bArr2[i22] = (byte) cArr[((i21 << 4) & 63) | (i26 >> 4)];
            int i28 = i27 + 1;
            bArr2[i27] = (byte) cArr[(i26 << 2) & 63];
            if (!this.doPadding) {
                return i28;
            }
            int i29 = i28 + 1;
            bArr2[i28] = 61;
            return i29;
        }

        private final int outLength(int i) {
            int i2;
            if (this.doPadding) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.linemax;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.newline.length) : i2;
        }

        public final byte[] encode(byte[] bArr) {
            int iOutLength = outLength(bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iEncode0 = encode0(bArr, 0, bArr.length, bArr2);
            return iEncode0 != iOutLength ? Arrays.copyOf(bArr2, iEncode0) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] bArrEncode = encode(bArr);
            return new String(bArrEncode, 0, 0, bArrEncode.length);
        }
    }

    public static b LN() {
        return b.aSD;
    }

    public static b LO() {
        return b.aSE;
    }

    public static a LP() {
        return a.aSA;
    }

    public static a LQ() {
        return a.aSC;
    }

    public static a LR() {
        return a.aSB;
    }

    public static String decodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.startsWith("sDAkk/dS") ? new String(LP().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static String encodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(LN().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static boolean isEncodeKsSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    public static class a {
        private static final int[] fromBase64;
        private final boolean isMIME;
        private final boolean isURL;
        static final a aSA = new a(false, false);
        static final a aSB = new a(true, false);
        static final a aSC = new a(false, true);
        private static final int[] fromBase64URL = new int[256];

        static {
            int[] iArr = new int[256];
            fromBase64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < b.toBase64.length; i++) {
                fromBase64[b.toBase64[i]] = i;
            }
            fromBase64[61] = -2;
            Arrays.fill(fromBase64URL, -1);
            for (int i2 = 0; i2 < b.toBase64URL.length; i2++) {
                fromBase64URL[b.toBase64URL[i2]] = i2;
            }
            fromBase64URL[61] = -2;
        }

        private a(boolean z, boolean z2) {
            this.isURL = z;
            this.isMIME = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        
            if (r4 != 18) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int decode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i3 = 18;
            int i4 = 0;
            int i5 = 0;
            while (i < i2) {
                int i6 = i + 1;
                int i7 = iArr[bArr[i] & 255];
                if (i7 >= 0) {
                    int i8 = (i7 << i3) | i4;
                    i3 -= 6;
                    if (i3 < 0) {
                        int i9 = i5 + 1;
                        bArr2[i5] = (byte) (i8 >> 16);
                        int i10 = i9 + 1;
                        bArr2[i9] = (byte) (i8 >> 8);
                        i5 = i10 + 1;
                        bArr2[i10] = (byte) i8;
                        i3 = 18;
                        i4 = 0;
                    } else {
                        i4 = i8;
                    }
                } else if (i7 == -2) {
                    if (i3 == 6) {
                        if (i6 != i2) {
                            i = i6 + 1;
                            if (bArr[i6] == 61) {
                                break;
                            }
                        }
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    i = i6;
                } else if (!this.isMIME) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i6 - 1], 16));
                }
                i = i6;
            }
            if (i3 == 6) {
                bArr2[i5] = (byte) (i4 >> 16);
                i5++;
            } else if (i3 == 0) {
                int i11 = i5 + 1;
                bArr2[i5] = (byte) (i4 >> 16);
                i5 = i11 + 1;
                bArr2[i11] = (byte) (i4 >> 8);
            } else if (i3 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i < i2) {
                if (this.isMIME) {
                    int i12 = i + 1;
                    if (iArr[bArr[i]] < 0) {
                        i = i12;
                    } else {
                        i = i12;
                    }
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i);
            }
            return i5;
        }

        private int outLength(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.isURL ? fromBase64URL : fromBase64;
            int i4 = i2 + 0;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.isMIME && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int i6 = 0;
                while (i < i2) {
                    int i7 = i + 1;
                    int i8 = bArr[i] & 255;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        public final byte[] decode(byte[] bArr) {
            int iOutLength = outLength(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iDecode0 = decode0(bArr, 0, bArr.length, bArr2);
            return iDecode0 != iOutLength ? Arrays.copyOf(bArr2, iDecode0) : bArr2;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }
    }
}
