package com.alipay.sdk.m.y;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25526a = "ap_req";
    public static final String b = "ap_args";
    public static final String c = "ap_resp";

    public static com.alipay.sdk.m.i.a a() {
        try {
            try {
                return com.alipay.sdk.m.j.a.a("NP", System.currentTimeMillis(), new com.alipay.sdk.m.j.c(com.alipay.sdk.m.w.b.c().d()), (short) com.alipay.sdk.m.m.a.d.a(com.alipay.sdk.m.w.b.c().b()), new com.alipay.sdk.m.j.f());
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return com.alipay.sdk.m.j.a.c();
        }
    }

    public static HashMap<String, String> a(com.alipay.sdk.m.w.a aVar) {
        HashMap<String, String> map = new HashMap<>();
        try {
            com.alipay.sdk.m.i.a aVarA = a();
            JSONObject jSONObject = new JSONObject();
            Context contextB = aVar != null ? aVar.b() : null;
            if (contextB == null) {
                contextB = com.alipay.sdk.m.w.b.c().b().getApplicationContext();
            }
            String strA = q.a(aVar, contextB);
            String strB = com.alipay.sdk.m.a0.b.b(aVar, contextB);
            jSONObject.put("ap_q", aVarA != null ? aVarA.a() : "");
            jSONObject.put(com.alipay.sdk.m.w.a.B, aVar != null ? aVar.d : "");
            jSONObject.put("u_pd", String.valueOf(q.g()));
            jSONObject.put("u_lk", String.valueOf(q.e(q.b())));
            jSONObject.put("u_pi", String.valueOf(aVar != null ? aVar.g : LoginConstants.UNDER_LINE));
            jSONObject.put("u_fu", strA);
            jSONObject.put("u_oi", strB);
            map.put(f25526a, jSONObject.toString());
            StringBuilder sb = new StringBuilder();
            sb.append(aVarA != null ? aVarA.a() : "");
            sb.append("|");
            sb.append(strA);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "ap_q", sb.toString());
        } catch (Exception e) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "APMEx1", e);
        }
        return map;
    }

    public static JSONObject a(com.alipay.sdk.m.w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(c);
        try {
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return new JSONObject(strOptString);
        } catch (JSONException e) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "APMEx2", e);
            return null;
        }
    }

    public static void a(com.alipay.sdk.m.w.a aVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt(b, jSONObject2);
        } catch (JSONException e) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "APMEx2", e);
        }
    }

    public static void a(com.alipay.sdk.m.w.a aVar, HashMap<String, String> map) {
        JSONObject jSONObjectA = com.alipay.sdk.m.o.b.i().a();
        if (map == null || jSONObjectA == null) {
            return;
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "ap_r", jSONObjectA.optString("ap_r"));
        map.putAll(q.a(jSONObjectA));
    }
}
