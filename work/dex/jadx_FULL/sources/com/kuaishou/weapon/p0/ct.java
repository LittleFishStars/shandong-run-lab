package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f40096a = "appkey";
    public static String b = "secretkey";
    public static String c = "pver";
    public static String d = "sdkver";
    public static String e = "ksid";
    public static String f = "timestamp";
    public static String g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.4.3");
            jSONObject.put("device_id", ck.b(context));
            jSONObject.put("iv", com.alipay.sdk.m.c0.c.c);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", br.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bf.q(context));
            try {
                String strB = h.a(context, "re_po_rt").b(dd.i, bo.e);
                if (TextUtils.isEmpty(strB)) {
                    strB = bo.e;
                }
                jSONObject.put("pver", strB);
            } catch (Exception unused) {
                jSONObject.put("pver", bo.e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bo.g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.4.3");
            jSONObject.put("device_id", ck.b(context));
            jSONObject.put("iv", com.alipay.sdk.m.c0.c.c);
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap map = new HashMap();
            map.put(f40096a, str);
            map.put(b, str2);
            map.put(f, String.valueOf(System.currentTimeMillis() / 1000));
            map.put(g, b(map));
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map mapD = d(context);
        if (mapD == null || mapD.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : mapD.entrySet()) {
            str = str + "&" + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f40096a));
            sb.append(map.get(b));
            sb.append(map.get(f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", br.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bf.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(dd.g, bo.e));
            jSONObject.put("platform", 1);
            jSONObject.put("pk", bo.g);
        } catch (Exception unused) {
        }
    }
}
