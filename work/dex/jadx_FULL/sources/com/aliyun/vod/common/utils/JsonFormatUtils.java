package com.aliyun.vod.common.utils;

import com.zj.adlib.bv9;
import com.zj.adlib.o61;
import com.zj.adlib.u15;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class JsonFormatUtils {
    private static void doFill(StringBuilder sb, int i, String str) {
        sb.append("\n");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(str);
        }
    }

    public static String formatJson(String str) {
        int length;
        int i;
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        while (str.length() > 0) {
            String token = getToken(str);
            str = str.substring(token.length());
            arrayList.add(token.trim());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int length2 = ((String) arrayList.get(i3)).getBytes().length;
            if (length2 > i2 && i3 < arrayList.size() - 1 && ((String) arrayList.get(i3 + 1)).equals(u15.f19942b)) {
                i2 = length2;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        int i5 = 0;
        while (i4 < arrayList.size()) {
            String str2 = (String) arrayList.get(i4);
            if (str2.equals(",")) {
                sb.append(str2);
                doFill(sb, i5, "\t");
            } else if (str2.equals(u15.f19942b)) {
                sb.append(" ");
                sb.append(str2);
                sb.append(" ");
            } else if (str2.equals(bv9.b)) {
                i = i4 + 1;
                if (((String) arrayList.get(i)).equals("}")) {
                    sb.append("{ }");
                    i4 = i;
                } else {
                    i5++;
                    sb.append(str2);
                    doFill(sb, i5, "\t");
                }
            } else if (str2.equals("}")) {
                i5--;
                doFill(sb, i5, "\t");
                sb.append(str2);
            } else if (str2.equals("[")) {
                i = i4 + 1;
                if (((String) arrayList.get(i)).equals("]")) {
                    sb.append("[ ]");
                    i4 = i;
                } else {
                    i5++;
                    sb.append(str2);
                    doFill(sb, i5, "\t");
                }
            } else if (str2.equals("]")) {
                i5--;
                doFill(sb, i5, "\t");
                sb.append(str2);
            } else {
                sb.append(str2);
                if (i4 < arrayList.size() - 1 && ((String) arrayList.get(i4 + 1)).equals(u15.f19942b) && (length = i2 - str2.getBytes().length) > 0) {
                    for (int i6 = 0; i6 < length; i6++) {
                        sb.append(" ");
                    }
                }
            }
            i4++;
        }
        return sb.toString();
    }

    private static String getToken(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (str.length() > 0) {
            String strSubstring = str.substring(0, 1);
            str = str.substring(1);
            if (!z && (strSubstring.equals(u15.f19942b) || strSubstring.equals(bv9.b) || strSubstring.equals("}") || strSubstring.equals("[") || strSubstring.equals("]") || strSubstring.equals(","))) {
                if (sb.toString().trim().length() != 0) {
                    break;
                }
                sb.append(strSubstring);
                break;
            }
            if (strSubstring.equals(o61.h)) {
                sb.append(strSubstring);
                sb.append(str.substring(0, 1));
                str = str.substring(1);
            } else if (strSubstring.equals("\"")) {
                sb.append(strSubstring);
                if (z) {
                    break;
                }
                z = true;
            } else {
                sb.append(strSubstring);
            }
        }
        return sb.toString();
    }
}
