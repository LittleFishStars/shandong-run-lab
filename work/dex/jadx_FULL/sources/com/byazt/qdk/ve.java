package com.byazt.qdk;

import android.text.TextUtils;
import com.byazt.pm.a;
import com.byazt.sz.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1262, 54})
public final class ve {
    public final String c;
    public final Map<String, Object> tt;

    private ve(String str, Map<String, Object> map) {
        this.c = str;
        this.tt = map;
    }

    public static ve c(m mVar, JSONObject jSONObject, Map<String, Object> map) {
        String strC;
        JSONObject jSONObjectVe = mVar != null ? mVar.ve() : null;
        HashMap map2 = new HashMap();
        if (jSONObjectVe != null) {
            strC = com.byazt.wj.tt.c(jSONObjectVe.optString("type"), jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObjectVe.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, c(jSONObjectOptJSONObject.opt(next), jSONObject));
                }
            }
        } else {
            strC = "";
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return new ve(strC, map2);
    }

    public Map<String, Object> tt() {
        return this.tt;
    }

    public JSONArray ve(String str) {
        Map<String, Object> map = this.tt;
        Object obj = map != null ? map.get(str) : null;
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                return new JSONArray(String.valueOf(obj));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public JSONObject tt(String str) {
        Map<String, Object> map = this.tt;
        Object obj = map != null ? map.get(str) : null;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
            try {
                return new JSONObject(String.valueOf(obj));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static ve c(a.c cVar, JSONObject jSONObject, Map<String, Object> map) {
        String strC = com.byazt.wj.tt.c(cVar != null ? cVar.tt() : "", jSONObject);
        HashMap map2 = new HashMap();
        if (cVar != null && cVar.ve() != null) {
            for (Map.Entry<String, Object> entry : cVar.ve().entrySet()) {
                map2.put(entry.getKey(), c(entry.getValue(), jSONObject));
            }
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return new ve(strC, map2);
    }

    public String c() {
        return this.c;
    }

    public String c(String str) {
        Map<String, Object> map = this.tt;
        Object obj = map != null ? map.get(str) : null;
        return obj == null ? "" : String.valueOf(obj);
    }

    public int c(String str, int i) {
        Map<String, Object> map = this.tt;
        Object obj = map != null ? map.get(str) : null;
        if (obj == null) {
            return i;
        }
        try {
            return Integer.parseInt(String.valueOf(obj));
        } catch (Exception unused) {
            return i;
        }
    }

    public <T> T c(String str, Class<T> cls) {
        Map<String, Object> map = this.tt;
        T t = map != null ? (T) map.get(str) : null;
        if (t != null && cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    private static Object c(Object obj, JSONObject jSONObject) {
        return obj instanceof JSONObject ? obj : com.byazt.wj.tt.c(Objects.toString(obj, ""), jSONObject);
    }
}
