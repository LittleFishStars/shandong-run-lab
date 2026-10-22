package com.alibaba.triver.kit.api.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VersionCompareUtils {
    private static int BIGGER = 1;
    private static int SAME = 0;
    private static int SMALLER = -1;

    public static boolean aBiggerThanB(String str, String str2) {
        try {
            return aBiggerThanBInner(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean aBiggerThanBInner(String str, String str2) {
        return parseResult(str, str2) == BIGGER;
    }

    public static boolean aSmallerThanB(String str, String str2) {
        try {
            return aSmallerThanBInner(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean aSmallerThanBInner(String str, String str2) {
        return aBiggerThanBInner(str2, str);
    }

    private static int parseResult(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        if (strArrSplit.length == strArrSplit2.length) {
            while (i < strArrSplit.length) {
                String str3 = strArrSplit[i];
                String str4 = strArrSplit2[i];
                int i2 = Integer.parseInt(str3);
                int i3 = Integer.parseInt(str4);
                if (i2 != i3) {
                    return i2 > i3 ? BIGGER : SMALLER;
                }
                i++;
            }
            return SAME;
        }
        if (strArrSplit.length < strArrSplit2.length) {
            while (i < strArrSplit.length) {
                String str5 = strArrSplit[i];
                String str6 = strArrSplit2[i];
                int i4 = Integer.parseInt(str5);
                int i5 = Integer.parseInt(str6);
                if (i4 != i5) {
                    return i4 > i5 ? BIGGER : SMALLER;
                }
                i++;
            }
            return Integer.parseInt(strArrSplit2[strArrSplit2.length + (-1)]) == 0 ? SAME : SMALLER;
        }
        while (i < strArrSplit2.length) {
            String str7 = strArrSplit[i];
            String str8 = strArrSplit2[i];
            int i6 = Integer.parseInt(str7);
            int i7 = Integer.parseInt(str8);
            if (i6 != i7) {
                return i6 > i7 ? BIGGER : SMALLER;
            }
            i++;
        }
        return Integer.parseInt(strArrSplit[strArrSplit.length + (-1)]) == 0 ? SAME : BIGGER;
    }

    public static boolean versionIsSame(String str, String str2) {
        return TextUtils.equals(str, str2) || parseResult(str, str2) == SAME;
    }
}
