package com.byazt.ek;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2014, 20})
public class c {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt < 'A' || cCharAt > 'Z') {
                    sb.append(cCharAt);
                } else {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                    sb.append((char) (cCharAt + ' '));
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z) {
            str = str.substring(1);
        }
        return c(str);
    }
}
