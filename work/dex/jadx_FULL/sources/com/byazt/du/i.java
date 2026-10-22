package com.byazt.du;

import com.byazt.nr.m;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 441, 42})
public class i {
    public static void c(String str, JSONObject jSONObject) {
        JSONObject jSONObjectIu = com.byazt.sr.tt.iu(str);
        if (jSONObjectIu == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectIu.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        c(jSONObjectOptJSONObject, jSONObject);
    }

    public static String tt(String str, String str2) {
        if (!com.byazt.sr.uj.c()) {
            return c.c(str);
        }
        if (str.indexOf(46) < 0) {
            str = str + ".png";
        }
        return str2 + "static/images/" + str;
    }

    public static JSONObject c(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectIu = com.byazt.sr.tt.iu(str);
        if (jSONObjectIu == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return c(jSONObject2, jSONObjectIu.optJSONObject("themeValues"), jSONObject);
    }

    private static void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
    }

    public static JSONObject c(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                        m.c(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String c(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectIu = com.byazt.sr.tt.iu(str);
        if (jSONObjectIu == null || (jSONObjectOptJSONObject = jSONObjectIu.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String c(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectIu = com.byazt.sr.tt.iu(str);
        if (jSONObjectIu == null || (jSONObjectOptJSONObject = jSONObjectIu.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }
}
