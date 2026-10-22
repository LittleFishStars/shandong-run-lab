package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.oned.UPCEANReader;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ff9 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f16517a = new int[4];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f41667a = new StringBuilder();

    public static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    public final int a(qv0 qv0Var, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f16517a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iS = qv0Var.s();
        int iR = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iR < iS; i2++) {
            int iF = UPCEANReader.f(qv0Var, iArr2, iR, UPCEANReader.f6759b);
            sb.append((char) ((iF % 10) + 48));
            for (int i3 : iArr2) {
                iR += i3;
            }
            if (iF >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iR = qv0Var.r(qv0Var.p(iR));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i) {
            return iR;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ug7 b(int i, qv0 qv0Var, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.f41667a;
        sb.setLength(0);
        int iA = a(qv0Var, iArr, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> mapC = c(string);
        float f = i;
        ug7 ug7Var = new ug7(string, null, new xg7[]{new xg7((iArr[0] + iArr[1]) / 2.0f, f), new xg7(iA, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapC != null) {
            ug7Var.i(mapC);
        }
        return ug7Var;
    }
}
