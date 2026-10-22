package com.kc.dw.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.kc.dw.core.SsdAdConfig;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    public static SsdAdConfig adConfig;
    public static Context context;

    public static SsdAdConfig adConfig() {
        if (adConfig == null) {
            Log.e("Sdk", "adConfig is null ,check sdk init");
        }
        return adConfig;
    }

    public static Context getContext() {
        return context;
    }

    public static SharedPreferences getSharedPreferences() {
        return context.getApplicationContext().getSharedPreferences(LogUtil.TAG, 0);
    }
}
