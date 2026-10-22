package com.alipay.sdk.m.t;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alipay.sdk.m.y.f;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.p;
import com.alipay.sdk.m.y.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class e {
    public static final String c = "msp-gzip";
    public static final String d = "Msp-Param";
    public static final String e = "Operation-Type";
    public static final String f = "content-type";
    public static final String g = "Version";
    public static final String h = "AppId";
    public static final String i = "des-mode";
    public static final String j = "namespace";
    public static final String k = "api_name";
    public static final String l = "api_version";
    public static final String m = "data";
    public static final String n = "params";
    public static final String o = "public_key";
    public static final String p = "device";
    public static final String q = "action";
    public static final String r = "type";
    public static final String s = "method";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25509a = true;
    public boolean b = true;

    public Map<String, String> a(boolean z, String str) {
        HashMap map = new HashMap();
        map.put(c, String.valueOf(z));
        map.put(e, "alipay.msp.cashier.dispatch.bytes");
        map.put(f, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        map.put("Version", "2.0");
        map.put("AppId", "TAOBAO");
        map.put(d, a.a(str));
        map.put(i, "CBC");
        return map;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public abstract boolean c();

    public String a(com.alipay.sdk.m.w.a aVar) throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", Build.MODEL);
        map.put("namespace", "com.alipay.mobilecashier");
        map.put("api_name", "com.alipay.mcpay");
        map.put(l, b());
        return a(aVar, map, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(com.alipay.sdk.m.w.a aVar, String str, JSONObject jSONObject) {
        com.alipay.sdk.m.w.b bVarC = com.alipay.sdk.m.w.b.c();
        com.alipay.sdk.m.x.a aVarA = com.alipay.sdk.m.x.a.a(bVarC.b());
        JSONObject jSONObjectA = f.a(new JSONObject(), jSONObject);
        try {
            jSONObjectA.put(com.alipay.sdk.m.n.b.d, str);
            jSONObjectA.put("tid", aVarA.f());
            jSONObjectA.put("user_agent", bVarC.a().a(aVar, aVarA, c()));
            jSONObjectA.put(com.alipay.sdk.m.n.b.e, q.a(aVar, bVarC.b(), com.alipay.sdk.m.l.a.d, false));
            jSONObjectA.put(com.alipay.sdk.m.n.b.f, q.h(bVarC.b()));
            jSONObjectA.put(com.alipay.sdk.m.n.b.h, com.alipay.sdk.m.n.a.h);
            jSONObjectA.put("utdid", bVarC.d());
            jSONObjectA.put(com.alipay.sdk.m.n.b.j, aVarA.e());
            jSONObjectA.put(com.alipay.sdk.m.n.b.k, com.alipay.sdk.m.o.c.b(bVarC.b()));
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "BodyErr", th);
            g.a(th);
        }
        return jSONObjectA.toString();
    }

    public static boolean a(com.alipay.sdk.m.s.b.C0207b c0207b) {
        return Boolean.valueOf(a(c0207b, c)).booleanValue();
    }

    public static String a(com.alipay.sdk.m.s.b.C0207b c0207b, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (c0207b == null || str == null || (map = c0207b.f25502a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(com.alipay.sdk.m.w.a aVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (map2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String strOptString = jSONObject.getJSONObject("params").optString(o, null);
            if (TextUtils.isEmpty(strOptString)) {
                return false;
            }
            com.alipay.sdk.m.o.c.a(strOptString);
            return true;
        } catch (JSONException e2) {
            g.a(e2);
            return false;
        }
    }

    public b a(com.alipay.sdk.m.w.a aVar, Context context) throws Throwable {
        return a(aVar, context, "");
    }

    public b a(com.alipay.sdk.m.w.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, p.b(context));
    }

    public b a(com.alipay.sdk.m.w.a aVar, Context context, String str, String str2) throws Throwable {
        return a(aVar, context, str, str2, true);
    }

    public b a(com.alipay.sdk.m.w.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        g.b(com.alipay.sdk.m.n.a.B, "Packet: " + str2);
        c cVar = new c(this.b);
        b bVar = new b(a(aVar), a(aVar, str, a()));
        Map<String, String> mapA = a(false, str);
        d dVarA = cVar.a(bVar, this.f25509a, mapA.get("iSr"));
        com.alipay.sdk.m.s.b.C0207b c0207bA = com.alipay.sdk.m.s.b.a(context, new com.alipay.sdk.m.s.b.a(str2, a(dVarA.b(), str), dVarA.a()));
        if (c0207bA != null) {
            b bVarA = cVar.a(new d(a(c0207bA), c0207bA.c), mapA.get("iSr"));
            return (bVarA != null && a(bVarA.b()) && z) ? a(aVar, context, str, str2, false) : bVarA;
        }
        throw new RuntimeException("Response is null.");
    }
}
