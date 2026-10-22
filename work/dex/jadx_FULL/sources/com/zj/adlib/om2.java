package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class om2 {
    public static int a() {
        String str = Build.MANUFACTURER;
        if ("xiaomi".equalsIgnoreCase(str)) {
            return 1;
        }
        if (AssistUtils.BRAND_HW.equalsIgnoreCase(str)) {
            return 2;
        }
        if ("vivo".equalsIgnoreCase(str)) {
            return 3;
        }
        if ("oppo".equalsIgnoreCase(str)) {
            return 4;
        }
        if (AssistUtils.BRAND_MZ.equalsIgnoreCase(str)) {
            return 5;
        }
        return "oneplus".equalsIgnoreCase(str) ? 6 : 1;
    }

    public static String b(Context context) {
        String string;
        String strI = r90.i();
        if (c(strI)) {
            return strI;
        }
        String string2 = Settings.System.getString(context.getContentResolver(), "android_id");
        if (c(string2)) {
            r90.O(string2);
            return string2;
        }
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.SUPPORTED_ABIS.length % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        try {
            string = Build.class.getField("SERIAL").get(null).toString();
        } catch (Exception unused) {
            string = "serial";
        }
        String str2 = new UUID(str.hashCode(), string.hashCode()).toString() + UUID.randomUUID().toString();
        r90.O(str2);
        return str2;
    }

    public static boolean c(String id) {
        return (TextUtils.isEmpty(id) || "9774d56d682e549c".equals(id) || "0000000000000000".equals(id)) ? false : true;
    }

    public static void d(Context context, long timeOut, String tag) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager.isInteractive() || (wakeLockNewWakeLock = powerManager.newWakeLock(268435462, tag)) == null) {
            return;
        }
        wakeLockNewWakeLock.acquire(timeOut);
        wakeLockNewWakeLock.release();
    }
}
