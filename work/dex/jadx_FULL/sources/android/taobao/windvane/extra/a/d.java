package android.taobao.windvane.extra.a;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.alibaba.triver.kit.api.TinyApp;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.assist.sdk.AssistPushConsts;
import com.zj.adlib.u15;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f21219a = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", TinyApp.SUB_TYPE_BRAND_ZONE, "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", AssistPushConsts.MSG_KEY_ACTION, "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};
    private static final byte[] b = {63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 63, 63, 63, 63, 63, 63, 63, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 10, 11, 12, 13, com.google.common.base.a.p, com.google.common.base.a.q, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63};

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ') {
                stringBuffer.append('+');
            } else if ('A' <= cCharAt && cCharAt <= 'Z') {
                stringBuffer.append(cCharAt);
            } else if ('a' <= cCharAt && cCharAt <= 'z') {
                stringBuffer.append(cCharAt);
            } else if ('0' <= cCharAt && cCharAt <= '9') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '-' || cCharAt == '_' || cCharAt == '.' || cCharAt == '!' || cCharAt == '~' || cCharAt == '*' || cCharAt == '/' || cCharAt == '(' || cCharAt == ')') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt <= 127) {
                stringBuffer.append('%');
                stringBuffer.append(f21219a[cCharAt]);
            } else {
                stringBuffer.append('%');
                stringBuffer.append('u');
                String[] strArr = f21219a;
                stringBuffer.append(strArr[cCharAt >>> '\b']);
                stringBuffer.append(strArr[cCharAt & 255]);
            }
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '+') {
                stringBuffer.append(' ');
            } else if ('A' <= cCharAt && cCharAt <= 'Z') {
                stringBuffer.append(cCharAt);
            } else if ('a' <= cCharAt && cCharAt <= 'z') {
                stringBuffer.append(cCharAt);
            } else if ('0' <= cCharAt && cCharAt <= '9') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '-' || cCharAt == '_' || cCharAt == '.' || cCharAt == '!' || cCharAt == '~' || cCharAt == '*' || cCharAt == '/' || cCharAt == '(' || cCharAt == ')') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '%') {
                int i3 = i2 + 1;
                if ('u' != str.charAt(i3)) {
                    byte[] bArr = b;
                    i2 += 2;
                    i = ((bArr[str.charAt(i3)] | 0) << 4) | bArr[str.charAt(i2)];
                } else {
                    byte[] bArr2 = b;
                    int i4 = (((((bArr2[str.charAt(i2 + 2)] | 0) << 4) | bArr2[str.charAt(i2 + 3)]) << 4) | bArr2[str.charAt(i2 + 4)]) << 4;
                    i2 += 5;
                    i = bArr2[str.charAt(i2)] | i4;
                }
                stringBuffer.append((char) i);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public static String c(String str) {
        try {
            URI.create(str);
            return str;
        } catch (Throwable unused) {
            return e(str);
        }
    }

    private static String d(String str) {
        String strDecode = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                strDecode = URLDecoder.decode(str, "utf-8");
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(strDecode)) {
                try {
                    strDecode = URLDecoder.decode(str, "gbk");
                } catch (Throwable unused2) {
                }
            }
            if (TextUtils.isEmpty(strDecode)) {
                try {
                    strDecode = b(str);
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(strDecode)) {
                return str;
            }
        }
        return strDecode;
    }

    private static String e(String str) {
        try {
            URL url = new URL(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url.getProtocol());
            stringBuffer.append("://");
            stringBuffer.append(url.getHost());
            int port = url.getPort();
            if (port != 80 && port != -1) {
                stringBuffer.append(u15.f19942b + port);
            }
            String path = url.getPath();
            String query = url.getQuery();
            if (!TextUtils.isEmpty(path)) {
                boolean z = true;
                if (path.length() <= 1 || path.lastIndexOf(WVNativeCallbackUtil.SEPERATER) != path.length() - 1) {
                    z = false;
                }
                String[] strArrSplit = path.split(WVNativeCallbackUtil.SEPERATER);
                if (strArrSplit != null) {
                    stringBuffer.append(WVNativeCallbackUtil.SEPERATER);
                    int length = strArrSplit.length;
                    for (int i = 0; i < length; i++) {
                        if (!TextUtils.isEmpty(strArrSplit[i])) {
                            stringBuffer.append(URLEncoder.encode(d(strArrSplit[i]), "utf-8"));
                            if (i < length - 1) {
                                stringBuffer.append(WVNativeCallbackUtil.SEPERATER);
                            }
                        }
                    }
                }
                if (z) {
                    stringBuffer.append(WVNativeCallbackUtil.SEPERATER);
                }
            }
            if (!TextUtils.isEmpty(query)) {
                stringBuffer.append("?");
                String[] strArrSplit2 = query.split("&");
                if (strArrSplit2 != null) {
                    int length2 = strArrSplit2.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        int iIndexOf = strArrSplit2[i2].indexOf(61);
                        if (-1 != iIndexOf) {
                            stringBuffer.append(strArrSplit2[i2].substring(0, iIndexOf) + "=" + URLEncoder.encode(d(strArrSplit2[i2].substring(iIndexOf + 1)), "utf-8"));
                            if (i2 < length2 - 1) {
                                stringBuffer.append("&");
                            }
                        }
                    }
                }
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
