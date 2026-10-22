package com.king.zxing.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.zj.adlib.mx6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    private static FrontLightMode parse(String str) {
        return str == null ? AUTO : valueOf(str);
    }

    public static void put(Context context, FrontLightMode frontLightMode) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(mx6.k, frontLightMode.toString()).commit();
    }

    public static FrontLightMode readPref(SharedPreferences sharedPreferences) {
        return parse(sharedPreferences.getString(mx6.k, AUTO.toString()));
    }
}
