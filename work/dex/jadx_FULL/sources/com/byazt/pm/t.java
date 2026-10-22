package com.byazt.pm;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1355, 66})
public class t {
    public static a.c c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a.c cVar = new a.c();
        String strC = com.byazt.wj.tt.c(str, jSONObject);
        if (strC.contains("#")) {
            strC = strC.replace("#", "%23");
        }
        Uri uri = Uri.parse(strC);
        if (uri == null) {
            return null;
        }
        cVar.ve(strC);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            cVar.c(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        cVar.tt(authority);
        cVar.uj(cVar.c() + "://" + cVar.tt());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.byazt.wj.tt.c(uri.getQueryParameter(str2), jSONObject));
            }
        }
        cVar.c(map);
        return cVar;
    }

    public static a.c c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        a.c cVar = new a.c();
        String strC = com.byazt.wj.tt.c(jSONObject.optString("protocol"), jSONObject2);
        cVar.tt(com.byazt.wj.tt.c(jSONObject.optString("name"), jSONObject2));
        if (TextUtils.isEmpty(strC)) {
            cVar.c("global");
        } else {
            cVar.c(strC);
        }
        cVar.uj(cVar.c() + "://" + cVar.tt());
        cVar.ve(String.valueOf(jSONObject.hashCode()));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, com.byazt.wj.tt.c(jSONObjectOptJSONObject.opt(next), jSONObject2));
            }
        }
        cVar.c(map);
        return cVar;
    }
}
