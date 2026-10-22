package com.kc.dw.core.utils;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m implements MiitHelper.a {
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l.f39380a = str;
        try {
            try {
                String strB = d1.b(str);
                com.kc.dw.base.a.getSharedPreferences().edit().putString("oaid_e", strB).apply();
                r.a().b("oaid_e", strB);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.d("DeviceUtil", "Write oaid to cache, oaid=" + l.f39380a);
        } catch (Throwable th) {
            LogUtil.d("DeviceUtil", "Write oaid to cache failed");
            th.printStackTrace();
        }
    }
}
