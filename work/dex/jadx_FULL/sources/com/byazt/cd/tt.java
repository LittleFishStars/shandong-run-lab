package com.byazt.cd;

import android.text.TextUtils;
import com.byazt.nr.m;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 43, 13})
public class tt {
    public static void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    public static JSONObject c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            m.c(e);
            return jSONObject;
        }
    }

    public static JSONArray c(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str)) {
            return jSONArray;
        }
        try {
            return new JSONArray(com.byazt.wj.tt.c(str, jSONObject));
        } catch (JSONException unused) {
            return jSONArray;
        }
    }

    public static JSONArray c(String str, JSONArray jSONArray) {
        return c(null, str, jSONArray);
    }

    public static void c(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return;
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            Object objOpt = jSONArray2.opt(i);
            if (objOpt != null) {
                jSONArray.put(objOpt);
            }
        }
    }
}
