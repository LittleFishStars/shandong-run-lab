package com.alibaba.alibcprotocol.base;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcUrlCheck {
    public static boolean containCheck(String[] strArr, String str) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean equalCheck(String[] strArr, String str) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean regularCheck(String[] strArr, String str) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.matches(str2)) {
                return true;
            }
        }
        return false;
    }
}
