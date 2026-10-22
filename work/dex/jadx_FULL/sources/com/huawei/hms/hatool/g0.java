package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g0 {
    private static g0 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37556a;
    private final Object b = new Object();

    private g0() {
    }

    public static g0 a() {
        if (c == null) {
            b();
        }
        return c;
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void b() {
        if (c == null) {
            c = new g0();
        }
    }

    public void a(Context context) {
        synchronized (this.b) {
            if (this.f37556a != null) {
                return;
            }
            this.f37556a = context;
            e.a().a(context);
        }
    }

    public void a(String str, int i) {
        e.a().a(str, i);
    }

    public void a(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public void b(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i, str2, a(linkedHashMap), System.currentTimeMillis());
    }
}
