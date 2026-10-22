package com.hihonor.push.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class c {
    public static void a(String str) {
        String strSubstring;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(c.class)) {
                String className = stackTrace[i].getClassName();
                strSubstring = className.substring(className.lastIndexOf(46) + 1);
                a("HonorPush_" + strSubstring, str, null);
            }
        }
        strSubstring = "";
        a("HonorPush_" + strSubstring, str, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2.length() > 4000) {
            int i = 0;
            while (i < str2.length()) {
                int i2 = i + 4000;
                if (str2.length() > i2) {
                    str2.substring(i, i2);
                } else {
                    str2.substring(i);
                }
                i = i2;
            }
        }
    }
}
