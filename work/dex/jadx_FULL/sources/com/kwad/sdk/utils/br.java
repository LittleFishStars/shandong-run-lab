package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class br {
    private static final SimpleDateFormat bqA;
    private static final SimpleDateFormat bqB;
    private static final SimpleDateFormat bqC;
    private static final SimpleDateFormat bqD;
    private static final SimpleDateFormat bqE;
    private static final SimpleDateFormat bqF;
    private static final SimpleDateFormat bqG;

    static {
        Locale locale = Locale.US;
        bqA = new SimpleDateFormat("MM/dd", locale);
        bqB = new SimpleDateFormat("yyyy/MM/dd", locale);
        bqC = new SimpleDateFormat("MM月dd日", locale);
        bqD = new SimpleDateFormat("yyyy年MM月dd日", locale);
        bqE = new SimpleDateFormat("HH:mm", locale);
        bqF = new SimpleDateFormat("MM-dd", locale);
        bqG = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean ig(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}
