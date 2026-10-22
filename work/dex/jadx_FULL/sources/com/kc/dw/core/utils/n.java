package com.kc.dw.core.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class n implements com.kc.dw.core.oaid.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39388a;

    @Keep
    public class a implements com.kc.dw.core.oaid.honor.a.c {
        public a(n nVar) {
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(l.f39380a)) {
                l.f39380a = str;
            }
            com.kc.dw.base.a.getSharedPreferences().edit().putString("honor_oaid", str).apply();
            r.a().b("honor_oaid", str);
        }
    }

    public n(Context context) {
        this.f39388a = context;
    }

    public void a(Exception exc) {
        try {
            LogUtil.d("DeviceUtil", exc.getMessage());
            if (Build.MANUFACTURER.equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                com.kc.dw.core.oaid.honor.a aVar = new com.kc.dw.core.oaid.honor.a();
                aVar.f39275a = new a(this);
                aVar.a(this.f39388a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l.f39380a = str;
        try {
            String strB = d1.b(str);
            com.kc.dw.base.a.getSharedPreferences().edit().putString("oaid_e", strB).apply();
            r.a().b("oaid_e", strB);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.a.getSharedPreferences().edit().putString(DeviceIdType.OAID, str).apply();
            r.a().b(DeviceIdType.OAID, str);
        }
    }
}
