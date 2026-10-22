package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.UPCEANReader;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class gf9 {
    public static final int[] b = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f16754a = new int[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f41893a = new StringBuilder();

    public static int c(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == b[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    public static String e(String str) {
        String str2;
        byte b2 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                switch (str.hashCode()) {
                    case 54118329:
                        if (!str.equals("90000")) {
                            b2 = -1;
                        }
                        break;
                    case 54395376:
                        b2 = !str.equals("99990") ? (byte) -1 : (byte) 1;
                        break;
                    case 54395377:
                        b2 = !str.equals("99991") ? (byte) -1 : (byte) 2;
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return null;
                    case 1:
                        return "Used";
                    case 2:
                        return "0.00";
                }
            }
        } else {
            str2 = "$";
        }
        int i = Integer.parseInt(str.substring(1));
        String strValueOf = String.valueOf(i / 100);
        int i2 = i % 100;
        return str2 + strValueOf + '.' + (i2 < 10 ? "0" + i2 : String.valueOf(i2));
    }

    public static Map<ResultMetadataType, Object> f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, strE);
        return enumMap;
    }

    public final int a(qv0 qv0Var, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f16754a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iS = qv0Var.s();
        int iR = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iR < iS; i2++) {
            int iF = UPCEANReader.f(qv0Var, iArr2, iR, UPCEANReader.f6759b);
            sb.append((char) ((iF % 10) + 48));
            for (int i3 : iArr2) {
                iR += i3;
            }
            if (iF >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iR = qv0Var.r(qv0Var.p(iR));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb.toString()) == c(i)) {
            return iR;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ug7 b(int i, qv0 qv0Var, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f41893a;
        sb.setLength(0);
        int iA = a(qv0Var, iArr, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> mapF = f(string);
        float f = i;
        ug7 ug7Var = new ug7(string, null, new xg7[]{new xg7((iArr[0] + iArr[1]) / 2.0f, f), new xg7(iA, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapF != null) {
            ug7Var.i(mapF);
        }
        return ug7Var;
    }
}
