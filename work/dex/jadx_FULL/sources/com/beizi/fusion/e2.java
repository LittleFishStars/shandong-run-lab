package com.beizi.fusion;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class e2 {
    public static String a(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
            if (TextUtils.isEmpty(string) || Boolean.parseBoolean(string)) {
                return "";
            }
            String string2 = Settings.Global.getString(context.getContentResolver(), DeviceIdType.OAID);
            return !TextUtils.isEmpty(string2) ? string2 : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
