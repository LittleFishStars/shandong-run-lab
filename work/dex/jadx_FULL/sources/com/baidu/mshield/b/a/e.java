package com.baidu.mshield.b.a;

import android.os.Build;
import android.os.Process;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e {
    public static String a() {
        try {
            String[] strArr = Build.SUPPORTED_ABIS;
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(',');
            }
            String string = sb.toString();
            return string.substring(0, string.length() - 1);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static int b() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return 0;
        }
    }

    public static boolean c() {
        return Process.is64Bit();
    }
}
