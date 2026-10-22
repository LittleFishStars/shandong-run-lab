package com.byazt.mg;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 54})
public class ve {
    public static boolean c = false;

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return tt();
        }
        return true;
    }

    private static String tt(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                a.c(bufferedReader);
                return line;
            } catch (Throwable unused) {
                a.c(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean uj() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean ve() {
        if (!c) {
            try {
                Class.forName("miui.os.Build");
                com.byazt.jz.tt.c = true;
                c = true;
                return true;
            } catch (Exception unused) {
                c = true;
            }
        }
        return com.byazt.jz.tt.c;
    }

    public static String c() {
        return tt("ro.build.version.emui");
    }

    public static boolean tt() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith(AssistUtils.BRAND_HW)) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2) || !str2.toLowerCase(Locale.getDefault()).startsWith(AssistUtils.BRAND_HW)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
