package com.fl.saas.common.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.fl.saas.common.util.feature.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class StringUtils {
    public static String checkEmpty(String str, @NonNull Supplier<String> supplier) {
        return TextUtils.isEmpty(str) ? supplier.get() : str;
    }

    public static boolean containsField(String[] strArr, String str) {
        try {
            for (String str2 : strArr) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean fieldContainsKey(String[] strArr, String str) {
        try {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isStrEmpty(String str) {
        return str == null || str.isEmpty() || str.equalsIgnoreCase("null");
    }

    public static int strToInt(String str) {
        return strToInt(str, 0);
    }

    public static int strToInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }
}
