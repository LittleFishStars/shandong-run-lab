package com.getui.gtc.dyc.b;

import android.content.Context;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dyc.f;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {
    public static Map<String, Map<String, String>> a(Context context) {
        if (!CommonUtil.isGtcProcess()) {
            GtcProvider.setContext(context);
        }
        return com.getui.gtc.dyc.a.a().c();
    }

    public static Map<String, String> a(Context context, b bVar) {
        if (!CommonUtil.isGtcProcess()) {
            GtcProvider.setContext(context);
        }
        if (a(bVar)) {
            return com.getui.gtc.dyc.a.a().a(bVar);
        }
        return null;
    }

    public static Map<String, String> a(Context context, String str) {
        if (!CommonUtil.isGtcProcess()) {
            GtcProvider.setContext(context);
        }
        return com.getui.gtc.dyc.a.a().a(str);
    }

    public static void a(Context context, c cVar) {
        if (!CommonUtil.isGtcProcess()) {
            GtcProvider.setContext(context);
        }
        f.a().a(cVar);
    }

    public static void a(Context context, String str, Map<String, String> map) {
        if (!CommonUtil.isGtcProcess()) {
            GtcProvider.setContext(context);
        }
        com.getui.gtc.dyc.a.a().a(str, map);
    }

    private static boolean a(b bVar) {
        boolean z;
        if (TextUtils.isEmpty(bVar.a())) {
            com.getui.gtc.dyc.a.a.a.a("url missing for dyc request: " + bVar.g());
            z = false;
        } else {
            z = true;
        }
        if (TextUtils.isEmpty(bVar.b())) {
            com.getui.gtc.dyc.a.a.a.a("moduleName missing for dyc request: " + bVar.g());
            z = false;
        }
        if (TextUtils.isEmpty(bVar.c())) {
            com.getui.gtc.dyc.a.a.a.a("appid missing for dyc request: " + bVar.g());
            z = false;
        }
        if (!TextUtils.isEmpty(bVar.g())) {
            return z;
        }
        com.getui.gtc.dyc.a.a.a.a("version missing for dyc request: " + bVar.g());
        return false;
    }

    public static void b(Context context, c cVar) {
        if (!CommonUtil.isGtcProcess()) {
            GtcProvider.setContext(context);
        }
        f.a().c(cVar);
    }
}
