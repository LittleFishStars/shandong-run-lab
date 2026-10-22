package com.byazt.bh;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 892, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f28319a;
    public String c;
    public c n;
    public String tt;
    public final Map<String, c> uj = new HashMap();
    public boolean ve;

    public ve(JSONObject jSONObject) {
        this.ve = false;
        String next = jSONObject.keys().next();
        this.tt = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.c = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.ve = zOptBoolean;
        if (zOptBoolean) {
            this.f28319a = jSONObjectOptJSONObject;
        } else {
            c(jSONObjectOptJSONObject);
        }
    }

    private void c(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("events");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            c cVar = new c(jSONArrayOptJSONArray.optJSONObject(i));
            this.uj.put(cVar.c(), cVar);
            if (cVar.c().equals(jSONObject.optString("main"))) {
                this.n = cVar;
            }
        }
    }

    public c tt() {
        if (this.ve) {
            c(this.f28319a);
        }
        return this.n;
    }

    public String ve() {
        return this.tt;
    }

    public List<c> ve(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        List<c.C0352c> listSp = cVar.sp();
        ArrayList arrayList = new ArrayList();
        for (c.C0352c c0352c : listSp) {
            if (c0352c != null && c(c0352c.tt(), jSONObject, map)) {
                arrayList.add(c(c0352c.c()));
            }
        }
        return arrayList;
    }

    public List<c> tt(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        return c(jSONObject, map, cVar.i());
    }

    public c c(String str) {
        if (this.ve) {
            c(this.f28319a);
        }
        return this.uj.get(str);
    }

    public Map<String, c> c() {
        return this.uj;
    }

    public List<c> c(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        return c(jSONObject, map, cVar.x());
    }

    private List<c> c(JSONObject jSONObject, Map<String, Object> map, List<c.C0352c> list) {
        c cVarC;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (c.C0352c c0352c : list) {
            if (c0352c != null && (cVarC = c(c0352c.c())) != null && c(c0352c.tt(), jSONObject, map)) {
                arrayList.add(cVarC);
            }
        }
        return arrayList;
    }

    public static boolean c(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.byazt.kx.c.c(str.substring(2, str.length() - 1)).c(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
