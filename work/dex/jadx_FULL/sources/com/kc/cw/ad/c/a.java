package com.kc.cw.ad.c;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    public static c a() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b.b()) {
            return new com.kc.cw.ad.c.b.a();
        }
        if (b.c()) {
            return new com.kc.cw.ad.c.c.a();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new com.kc.cw.ad.c.f.b();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new com.kc.cw.ad.c.j.e();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new com.kc.cw.ad.c.h.f();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new com.kc.cw.ad.c.d.b();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new com.kc.cw.ad.c.g.a();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new com.kc.cw.ad.c.i.b();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu") || b.a()) {
            return new com.kc.cw.ad.c.e.a();
        }
        if (b.d()) {
            return new com.kc.cw.ad.c.a.a();
        }
        return null;
    }
}
