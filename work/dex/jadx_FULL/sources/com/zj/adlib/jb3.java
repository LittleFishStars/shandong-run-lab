package com.zj.adlib;

import com.google.common.base.a;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.result.ResultParser;
import com.huachenjie.common.constants.UserConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class jb3 extends ResultParser {
    public static String i(int i, String str) {
        char cCharAt;
        if (str.charAt(i) != '(') {
            return null;
        }
        String strSubstring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strSubstring.length() && (cCharAt = strSubstring.charAt(i2)) != ')'; i2++) {
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String j(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i);
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (i(i2, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ib3 e(ug7 ug7Var) {
        ib3 ib3Var = null;
        if (ug7Var.b() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(ug7Var);
        HashMap map = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String strSubstring = null;
        String str10 = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        int i = 0;
        while (i < massagedText.length()) {
            String strI = i(i, massagedText);
            if (strI == null) {
                return ib3Var;
            }
            byte b = 2;
            int length = i + strI.length() + 2;
            String strJ = j(length, massagedText);
            int length2 = length + strJ.length();
            switch (strI.hashCode()) {
                case 1536:
                    b = !strI.equals("00") ? (byte) -1 : (byte) 0;
                    break;
                case UserConstants.LOGIN_ERROR.d /* 1537 */:
                    b = !strI.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01) ? (byte) -1 : (byte) 1;
                    break;
                case 1567:
                    if (!strI.equals("10")) {
                        b = -1;
                    }
                    break;
                case 1568:
                    b = !strI.equals("11") ? (byte) -1 : (byte) 3;
                    break;
                case 1570:
                    b = !strI.equals("13") ? (byte) -1 : (byte) 4;
                    break;
                case 1572:
                    b = !strI.equals("15") ? (byte) -1 : (byte) 5;
                    break;
                case 1574:
                    b = !strI.equals("17") ? (byte) -1 : (byte) 6;
                    break;
                case 1567966:
                    b = !strI.equals("3100") ? (byte) -1 : (byte) 7;
                    break;
                case 1567967:
                    b = !strI.equals("3101") ? (byte) -1 : (byte) 8;
                    break;
                case 1567968:
                    b = !strI.equals("3102") ? (byte) -1 : (byte) 9;
                    break;
                case 1567969:
                    b = !strI.equals("3103") ? (byte) -1 : (byte) 10;
                    break;
                case 1567970:
                    b = !strI.equals("3104") ? (byte) -1 : (byte) 11;
                    break;
                case 1567971:
                    b = !strI.equals("3105") ? (byte) -1 : (byte) 12;
                    break;
                case 1567972:
                    b = !strI.equals("3106") ? (byte) -1 : (byte) 13;
                    break;
                case 1567973:
                    b = !strI.equals("3107") ? (byte) -1 : a.p;
                    break;
                case 1567974:
                    b = !strI.equals("3108") ? (byte) -1 : a.q;
                    break;
                case 1567975:
                    b = !strI.equals("3109") ? (byte) -1 : a.r;
                    break;
                case 1568927:
                    b = !strI.equals("3200") ? (byte) -1 : (byte) 17;
                    break;
                case 1568928:
                    b = !strI.equals("3201") ? (byte) -1 : a.u;
                    break;
                case 1568929:
                    b = !strI.equals("3202") ? (byte) -1 : (byte) 19;
                    break;
                case 1568930:
                    b = !strI.equals("3203") ? (byte) -1 : a.x;
                    break;
                case 1568931:
                    b = !strI.equals("3204") ? (byte) -1 : a.y;
                    break;
                case 1568932:
                    b = !strI.equals("3205") ? (byte) -1 : a.z;
                    break;
                case 1568933:
                    b = !strI.equals("3206") ? (byte) -1 : a.A;
                    break;
                case 1568934:
                    b = !strI.equals("3207") ? (byte) -1 : a.B;
                    break;
                case 1568935:
                    b = !strI.equals("3208") ? (byte) -1 : a.C;
                    break;
                case 1568936:
                    b = !strI.equals("3209") ? (byte) -1 : a.D;
                    break;
                case 1575716:
                    b = !strI.equals("3920") ? (byte) -1 : a.E;
                    break;
                case 1575717:
                    b = !strI.equals("3921") ? (byte) -1 : a.F;
                    break;
                case 1575718:
                    b = !strI.equals("3922") ? (byte) -1 : a.G;
                    break;
                case 1575719:
                    b = !strI.equals("3923") ? (byte) -1 : a.H;
                    break;
                case 1575747:
                    b = !strI.equals("3930") ? (byte) -1 : (byte) 31;
                    break;
                case 1575748:
                    b = !strI.equals("3931") ? (byte) -1 : (byte) 32;
                    break;
                case 1575749:
                    b = !strI.equals("3932") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.e;
                    break;
                case 1575750:
                    b = !strI.equals("3933") ? (byte) -1 : (byte) 34;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    str2 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 1:
                    str = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 2:
                    str3 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 3:
                    str4 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 4:
                    str5 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 5:
                    str6 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 6:
                    str7 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    strSubstring = strI.substring(3);
                    str9 = ib3.o;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    strSubstring = strI.substring(3);
                    str9 = ib3.p;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    strSubstring2 = strI.substring(3);
                    str10 = strJ;
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                case 31:
                case 32:
                case 33:
                case 34:
                    if (strJ.length() < 4) {
                        return null;
                    }
                    String strSubstring4 = strJ.substring(3);
                    strSubstring3 = strJ.substring(0, 3);
                    str10 = strSubstring4;
                    strSubstring2 = strI.substring(3);
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
                default:
                    map.put(strI, strJ);
                    continue;
                    i = length2;
                    ib3Var = null;
                    break;
            }
            str8 = strJ;
            i = length2;
            ib3Var = null;
        }
        return new ib3(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, str10, strSubstring2, strSubstring3, map);
    }
}
