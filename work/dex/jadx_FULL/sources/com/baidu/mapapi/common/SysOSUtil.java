package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SysOSUtil {
    public static String getAuthToken() {
        return f.a();
    }

    public static float getDensity() {
        return f.y;
    }

    public static int getDensityDpi() {
        return f.d();
    }

    public static String getDeviceID() {
        String strC = f.c();
        return TextUtils.isEmpty(strC) ? strC : strC.substring(0, strC.indexOf("|"));
    }

    public static String getModuleFileName() {
        return f.e();
    }

    public static String getPhoneType() {
        return f.k();
    }

    public static int getScreenSizeX() {
        return f.l();
    }

    public static int getScreenSizeY() {
        return f.m();
    }

    public static void updateCuid() {
        f.c();
    }
}
