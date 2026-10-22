package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EnvironmentUtilities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f26493a;
    static String b;
    static String c;
    static int d;
    static int e;
    static int f;
    static int g;
    private static e h;

    public static String getAppCachePath() {
        return b;
    }

    public static String getAppSDCardPath() {
        String str = f26493a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return c;
    }

    public static int getDomTmpStgMax() {
        return e;
    }

    public static int getItsTmpStgMax() {
        return f;
    }

    public static int getMapTmpStgMax() {
        return d;
    }

    public static String getSDCardPath() {
        return f26493a;
    }

    public static int getSsgTmpStgMax() {
        return g;
    }

    public static void initAppDirectory(Context context) {
        if (h == null) {
            e eVarB = e.b();
            h = eVarB;
            eVarB.b(context);
        }
        String str = f26493a;
        if (str != null && str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(f26493a);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("BaiduMapSDKNew");
            sb.append(str2);
            sb.append("cache");
            b = sb.toString();
        } else if (h.a() != null) {
            f26493a = h.a().c();
            b = h.a().b();
        }
        if (h.a() != null) {
            c = h.a().d();
        }
        d = 52428800;
        e = 52428800;
        f = 5242880;
        g = 52428800;
    }

    public static void setSDCardPath(String str) {
        f26493a = str;
    }
}
