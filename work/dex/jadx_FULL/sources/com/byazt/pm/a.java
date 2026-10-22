package com.byazt.pm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1355, 34})
public class a {
    public c c;
    public List<c> tt;
    public boolean ve = false;
    public int uj = 0;

    @com.byazt.zqa.c(c = {0, 1, 1355, 464})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, Object> f28948a;
        public String c;
        public Map<String, Object> n;
        public String tt;
        public String uj;
        public String ve = "global";

        public String c() {
            return this.ve;
        }

        public String n() {
            return this.tt;
        }

        public String toString() {
            return "Action{scheme='" + this.ve + "', name='" + this.uj + "', params=" + this.n + ", host='" + this.tt + "', origin='" + this.c + "', extra=" + this.f28948a + '}';
        }

        public String tt() {
            return this.uj;
        }

        public String uj() {
            return this.c;
        }

        public Map<String, Object> ve() {
            return this.n;
        }

        public void c(String str) {
            this.ve = str;
        }

        public void tt(String str) {
            this.uj = str;
        }

        public void uj(String str) {
            this.tt = str;
        }

        public void ve(String str) {
            this.c = str;
        }

        public void c(Map<String, Object> map) {
            this.n = map;
        }
    }

    public c c() {
        return this.c;
    }

    public List<c> tt() {
        return this.tt;
    }

    public int uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    public static a c(JSONObject jSONObject, JSONObject jSONObject2) {
        c cVarC;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        Object objOpt = jSONObject.opt("on");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        c cVarC2 = objOpt instanceof String ? t.c((String) objOpt, jSONObject2) : objOpt instanceof JSONObject ? t.c((JSONObject) objOpt, jSONObject2) : null;
        if (cVarC2 != null) {
            aVar.c = cVarC2;
        }
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            Object objOpt2 = jSONArrayOptJSONArray.opt(i);
            if (objOpt2 instanceof String) {
                c cVarC3 = t.c((String) objOpt2, jSONObject2);
                if (cVarC3 != null) {
                    arrayList.add(cVarC3);
                }
            } else if ((objOpt2 instanceof JSONObject) && (cVarC = t.c((JSONObject) objOpt2, jSONObject2)) != null) {
                arrayList.add(cVarC);
            }
        }
        aVar.tt = arrayList;
        if (jSONObject.has("delay")) {
            aVar.uj = com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("delay"), jSONObject2), 0);
        }
        if (jSONObject.has("disable")) {
            aVar.ve = com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("disable"), jSONObject2), false);
        }
        return aVar;
    }
}
