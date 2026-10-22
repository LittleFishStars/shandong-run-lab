package com.kc.dw.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c1 {
    public static String a(String str, String str2) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            string = com.kc.dw.base.a.getSharedPreferences().getString(str, null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    string = new String(Base64.decode(string, 0), d1.f39359a);
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.kc.dw.base.a.getSharedPreferences().edit().putString(str, Base64.encodeToString(str2.getBytes(d1.f39359a), 0)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
