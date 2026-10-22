package com.kc.dw.core.utils;

import android.content.Context;
import android.webkit.WebSettings;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f39354a;

    public static String a(Context context) {
        try {
            String string = com.kc.dw.base.a.getSharedPreferences().getString("user_agent", null);
            f39354a = string;
            if (string == null) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                f39354a = defaultUserAgent;
                if (defaultUserAgent != null) {
                    com.kc.dw.base.a.getSharedPreferences().edit().putString("user_agent", f39354a).apply();
                }
            }
        } catch (Throwable unused) {
        }
        return f39354a;
    }
}
