package com.byazt.ete;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 110})
public class qy {
    public Map<String, c> c = new HashMap();

    @com.byazt.zqa.c(c = {0, 1, 8, 1539})
    public static class c {
        public int c;
        public String tt;
        public String uj;
        public String ve;

        public c(JSONObject jSONObject) {
            try {
                this.c = jSONObject.optInt("type");
                this.tt = jSONObject.optString("url");
                this.ve = jSONObject.optString("pid");
                this.uj = jSONObject.optString("ecom_live_params");
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.c);
                jSONObject.put("url", this.tt);
                jSONObject.put("pid", this.ve);
                jSONObject.put("ecom_live_params", this.uj);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean tt() {
            if (3 == this.c) {
                return !TextUtils.isEmpty(this.uj);
            }
            return !TextUtils.isEmpty(this.tt);
        }
    }

    public qy(JSONObject jSONObject, boolean z) {
        if (z) {
            try {
                jSONObject = jSONObject.optJSONObject("sub_convert_link");
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                return;
            }
        }
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                c cVar = new c(jSONObject.optJSONObject(next));
                if (cVar.tt()) {
                    this.c.put(next, cVar);
                }
            }
        }
    }

    public static String n(qy qyVar, String str) {
        c cVar;
        return (qyVar == null || (cVar = qyVar.c.get(str)) == null) ? "" : cVar.uj;
    }

    public static int tt(qy qyVar, String str) {
        c cVar;
        if (qyVar == null || (cVar = qyVar.c.get(str)) == null) {
            return 0;
        }
        return cVar.c;
    }

    public static JSONObject uj(qy qyVar, String str) {
        c cVar;
        if (qyVar == null || (cVar = qyVar.c.get(str)) == null) {
            return null;
        }
        return cVar.c();
    }

    public static String ve(qy qyVar, String str) {
        c cVar;
        return (qyVar == null || (cVar = qyVar.c.get(str)) == null) ? "" : cVar.tt;
    }

    public void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, c> entry : this.c.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().c());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    private static qy c(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.u();
    }

    public static boolean c(qy qyVar, String str) {
        return (qyVar == null || !qyVar.c.containsKey(str) || TextUtils.isEmpty(ve(qyVar, str))) ? false : true;
    }

    public static String c(ic icVar, String str) {
        c cVar;
        qy qyVarC = c(icVar);
        return (qyVarC == null || (cVar = qyVarC.c.get(str)) == null) ? "" : cVar.ve;
    }
}
