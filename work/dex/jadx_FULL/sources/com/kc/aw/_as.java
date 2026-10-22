package com.kc.aw;

import android.content.Context;
import android.os.BatteryManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _as {
    public static int _a(Context context) {
        try {
            return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean _b(Context context) {
        try {
            return ((BatteryManager) context.getSystemService("batterymanager")).isCharging();
        } catch (Exception unused) {
            return false;
        }
    }
}
