package com.google.zxing.datamatrix.encoder;

import com.baidu.mapapi.UIMsg;
import com.zj.adlib.g1a;
import com.zj.adlib.o39;
import com.zj.adlib.tn2;
import com.zj.adlib.v13;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f32512a = 129;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f6736a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f6737a = "[)>\u001e05\u001d";
    public static final char b = 230;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f6738b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f6739b = "[)>\u001e06\u001d";
    public static final char c = 231;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f6740c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f6741c = "\u001e\u0004";
    public static final char d = 235;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f6742d = 3;
    public static final char e = 236;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final int f6743e = 4;
    public static final char f = 237;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int f6744f = 5;
    public static final char g = 238;
    public static final char h = 239;
    public static final char i = 240;
    public static final char j = 254;
    public static final char k = 254;

    public static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = i2;
        while (i3 < length && h(charSequence.charAt(i3))) {
            i3++;
        }
        return i3 - i2;
    }

    public static String b(String str) {
        return d(str, SymbolShapeHint.FORCE_NONE, null, null, false);
    }

    public static String c(String str, SymbolShapeHint symbolShapeHint, tn2 tn2Var, tn2 tn2Var2) {
        return d(str, symbolShapeHint, tn2Var, tn2Var2, false);
    }

    public static String d(String str, SymbolShapeHint symbolShapeHint, tn2 tn2Var, tn2 tn2Var2, boolean z) {
        c cVar = new c();
        int iF = 0;
        Encoder[] encoderArr = {new a(), cVar, new o39(), new g1a(), new d(), new b()};
        v13 v13Var = new v13(str);
        v13Var.o(symbolShapeHint);
        v13Var.m(tn2Var, tn2Var2);
        if (str.startsWith(f6737a) && str.endsWith(f6741c)) {
            v13Var.s(e);
            v13Var.n(2);
            v13Var.f45269a += 7;
        } else if (str.startsWith(f6739b) && str.endsWith(f6741c)) {
            v13Var.s(f);
            v13Var.n(2);
            v13Var.f45269a += 7;
        }
        if (z) {
            cVar.e(v13Var);
            iF = v13Var.f();
            v13Var.k();
        }
        while (v13Var.j()) {
            encoderArr[iF].a(v13Var);
            if (v13Var.f() >= 0) {
                iF = v13Var.f();
                v13Var.k();
            }
        }
        int iA = v13Var.a();
        v13Var.q();
        int iB = v13Var.h().b();
        if (iA < iB && iF != 0 && iF != 5 && iF != 4) {
            v13Var.s((char) 254);
        }
        StringBuilder sbB = v13Var.b();
        if (sbB.length() < iB) {
            sbB.append(f32512a);
        }
        while (sbB.length() < iB) {
            sbB.append(t(sbB.length() + 1));
        }
        return v13Var.b().toString();
    }

    public static int e(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i3 = 0; i3 < 6; i3++) {
            int iCeil = (int) Math.ceil(fArr[i3]);
            iArr[i3] = iCeil;
            if (i2 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i2 = iCeil;
            }
            if (i2 == iCeil) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    public static int f(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        return i2;
    }

    public static void g(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean h(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean i(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    public static boolean j(char c2) {
        return c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z');
    }

    public static boolean k(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }

    public static boolean l(char c2) {
        return c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'z');
    }

    public static boolean m(char c2) {
        return o(c2) || c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z');
    }

    public static boolean n(char c2) {
        return false;
    }

    public static boolean o(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    public static int p(CharSequence charSequence, int i2, int i3) {
        int iQ = q(charSequence, i2, i3);
        if (i3 == 3 && iQ == 3) {
            int iMin = Math.min(i2 + 3, charSequence.length());
            while (i2 < iMin) {
                if (!m(charSequence.charAt(i2))) {
                    return 0;
                }
                i2++;
            }
        } else if (i3 == 4 && iQ == 4) {
            int iMin2 = Math.min(i2 + 4, charSequence.length());
            while (i2 < iMin2) {
                if (!k(charSequence.charAt(i2))) {
                    return 0;
                }
                i2++;
            }
        }
        return iQ;
    }

    public static int q(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        char c2;
        if (i2 >= charSequence.length()) {
            return i3;
        }
        int i4 = 6;
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i5 = 0;
        while (true) {
            int i6 = i2 + i5;
            if (i6 == charSequence.length()) {
                byte[] bArr = new byte[i4];
                int[] iArr = new int[i4];
                int iE = e(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iF = f(bArr);
                if (iArr[0] == iE) {
                    return 0;
                }
                if (iF == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (iF == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (iF != 1 || bArr[2] <= 0) {
                    return (iF != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char cCharAt = charSequence.charAt(i6);
            i5++;
            if (h(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (i(cCharAt)) {
                float fCeil = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil;
                fArr[0] = fCeil + 2.0f;
            } else {
                float fCeil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil2;
                fArr[0] = fCeil2 + 1.0f;
            }
            if (j(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (i(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (l(cCharAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (i(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (m(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (i(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (k(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (i(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (n(cCharAt)) {
                c2 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c2 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i5 >= 4) {
                int[] iArr2 = new int[i4];
                e(fArr, iArr2, Integer.MAX_VALUE, new byte[i4]);
                if (iArr2[0] < s(iArr2[c2], iArr2[1], iArr2[2], iArr2[3], iArr2[4])) {
                    return 0;
                }
                int i7 = iArr2[c2];
                if (i7 < iArr2[0] || i7 + 1 < r(iArr2[1], iArr2[2], iArr2[3], iArr2[4])) {
                    return 5;
                }
                if (iArr2[4] + 1 < s(iArr2[5], iArr2[1], iArr2[2], iArr2[3], iArr2[0])) {
                    return 4;
                }
                if (iArr2[2] + 1 < s(iArr2[5], iArr2[1], iArr2[4], iArr2[3], iArr2[0])) {
                    return 2;
                }
                if (iArr2[3] + 1 < s(iArr2[5], iArr2[1], iArr2[4], iArr2[2], iArr2[0])) {
                    return 3;
                }
                if (iArr2[1] + 1 >= r(iArr2[0], iArr2[5], iArr2[4], iArr2[2])) {
                    continue;
                } else {
                    int i8 = iArr2[1];
                    int i9 = iArr2[3];
                    if (i8 < i9) {
                        return 1;
                    }
                    if (i8 == i9) {
                        for (int i10 = i2 + i5 + 1; i10 < charSequence.length(); i10++) {
                            char cCharAt2 = charSequence.charAt(i10);
                            if (o(cCharAt2)) {
                                return 3;
                            }
                            if (!m(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
            i4 = 6;
        }
    }

    public static int r(int i2, int i3, int i4, int i5) {
        return Math.min(i2, Math.min(i3, Math.min(i4, i5)));
    }

    public static int s(int i2, int i3, int i4, int i5, int i6) {
        return Math.min(r(i2, i3, i4, i5), i6);
    }

    public static char t(int i2) {
        int i3 = ((i2 * 149) % 253) + 1 + 129;
        if (i3 > 254) {
            i3 += UIMsg.m_AppUI.V_WM_LISTLISTUPDATE;
        }
        return (char) i3;
    }
}
