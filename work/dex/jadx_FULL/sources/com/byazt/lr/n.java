package com.byazt.lr;

import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.hu.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28779a;
    public boolean c;
    public String da;
    public int i;
    public int n = 15;
    public long sl;
    public String sp;
    public String t;
    public c tt;
    public String u;
    public int uj;
    public int ve;
    public String x;
    public tt yp;
    public String z;

    @com.byazt.zqa.c(c = {0, 1, 155, 151})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28780a;
        public String c;
        public String da;
        public String i;
        public String n;
        public String sl;
        public List<C0464c> sp;
        public String t;
        public String tt;
        public long uj;
        public long ve;
        public String x;

        /* JADX INFO: renamed from: com.byazt.lr.n$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 155, 156})
        public static class C0464c {
            public String c;
            public String tt;

            public void c(String str) {
                this.c = str;
            }

            public void tt(String str) {
                this.tt = str;
            }
        }

        public void a(String str) {
            this.i = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void i(String str) {
            this.t = str;
        }

        public void n(String str) {
            this.x = str;
        }

        public void sp(String str) {
            this.da = str;
        }

        public void tt(String str) {
            this.tt = str;
        }

        public void uj(String str) {
            this.f28780a = str;
        }

        public void ve(String str) {
            this.n = str;
        }

        public void x(String str) {
            this.sl = str;
        }

        public void c(long j) {
            this.ve = j;
        }

        public void tt(long j) {
            this.uj = j;
        }

        public void c(List<C0464c> list) {
            this.sp = list;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 155, 934})
    public static class tt {
        public int c;
        public String tt;

        public void c(int i) {
            this.c = i;
        }

        public void c(String str) {
            this.tt = str;
        }
    }

    public static n sp(String str) {
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVarC = c(jSONObject);
            tt ttVarTt = tt(jSONObject);
            nVar.c(cVarC);
            nVar.c(ttVarTt);
            nVar.c(jSONObject.optInt("show_auth", 0) == 1);
            nVar.c(jSONObject.optInt("download_permit"));
            nVar.tt(jSONObject.optInt("appstore_permit"));
            nVar.ve(jSONObject.optInt("market_online_status", 15));
            nVar.uj(jSONObject.optInt("hijack_permit"));
            nVar.c(jSONObject.optString("package_name"));
            nVar.tt(jSONObject.optString("hijack_url"));
            nVar.n(jSONObject.optInt("code"));
            nVar.ve(jSONObject.optString("message"));
            nVar.c(jSONObject.optLong("request_duration", 0L));
            nVar.uj(jSONObject.optString("back_web_url"));
            nVar.n(jSONObject.optString("hw_app_id"));
            nVar.a(jSONObject.optString("deep_link"));
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult fromJson");
        }
        return nVar;
    }

    public void a(String str) {
        this.u = str;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void n(int i) {
        this.i = i;
    }

    public String toString() {
        return c(this);
    }

    public void tt(int i) {
        this.uj = i;
    }

    public void uj(int i) {
        this.f28779a = i;
    }

    public void ve(int i) {
        this.n = i;
    }

    public void c(c cVar) {
        this.tt = cVar;
    }

    public void n(String str) {
        this.t = str;
    }

    public void tt(String str) {
        this.x = str;
    }

    public void uj(String str) {
        this.z = str;
    }

    public void ve(String str) {
        this.da = str;
    }

    private static JSONArray ve(c cVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<c.C0464c> list = cVar.sp;
        if (list != null && list.size() > 0) {
            for (c.C0464c c0464c : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0464c.c);
                jSONObject.putOpt("permission_desc", c0464c.tt);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public void c(int i) {
        this.ve = i;
    }

    public String tt() {
        return this.u;
    }

    private static JSONObject tt(c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            jSONObject.putOpt("app_name", cVar.c);
            jSONObject.putOpt("version_name", cVar.tt);
            jSONObject.putOpt("update_time", Long.valueOf(cVar.ve));
            jSONObject.putOpt("size", Long.valueOf(cVar.uj));
            jSONObject.putOpt("developer_name", cVar.n);
            jSONObject.putOpt("policy_url", cVar.i);
            jSONObject.putOpt("icon_url", cVar.da);
            jSONObject.putOpt("download_url", cVar.sl);
            jSONObject.putOpt(RequestPermission.PERMISSIONS, ve(cVar));
            jSONObject.putOpt("permission_classify_url", cVar.x);
            jSONObject.putOpt("desc_url", cVar.t);
        }
        return jSONObject;
    }

    public void c(String str) {
        this.sp = str;
    }

    public int c() {
        return this.i;
    }

    public void c(long j) {
        this.sl = j;
    }

    public void c(tt ttVar) {
        this.yp = ttVar;
    }

    public static String c(n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(nVar.c ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(nVar.ve));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(nVar.uj));
            jSONObject.putOpt("market_online_status", Integer.valueOf(nVar.n));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(nVar.f28779a));
            jSONObject.putOpt("package_name", nVar.sp);
            jSONObject.putOpt("hijack_url", nVar.x);
            jSONObject.putOpt("code", Integer.valueOf(nVar.i));
            jSONObject.putOpt("message", nVar.da);
            jSONObject.putOpt("request_duration", Long.valueOf(nVar.sl));
            jSONObject.putOpt("auth_info", tt(nVar.tt));
            jSONObject.putOpt("status", tt(nVar.yp));
            jSONObject.putOpt("back_web_url", nVar.z);
            jSONObject.putOpt("hw_app_id", nVar.t);
            jSONObject.putOpt("deep_link", nVar.u);
        } catch (JSONException e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static tt tt(JSONObject jSONObject) {
        tt ttVar = new tt();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                ttVar.c(jSONObjectOptJSONObject.optInt("status"));
                ttVar.c(jSONObjectOptJSONObject.optString("message"));
            }
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult getStatus");
        }
        return ttVar;
    }

    private static JSONObject tt(tt ttVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (ttVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(ttVar.c));
            jSONObject.putOpt("message", ttVar.tt);
        }
        return jSONObject;
    }

    private static c c(JSONObject jSONObject) {
        c cVar = new c();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                cVar.c(jSONObjectOptJSONObject.optString("app_name"));
                cVar.tt(jSONObjectOptJSONObject.optString("version_name"));
                cVar.c(u.c(jSONObjectOptJSONObject, "update_time"));
                cVar.tt(u.c(jSONObjectOptJSONObject, "size"));
                cVar.ve(jSONObjectOptJSONObject.optString("developer_name"));
                cVar.uj(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(RequestPermission.PERMISSIONS);
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    c(jSONArrayOptJSONArray, arrayList);
                    cVar.c(arrayList);
                }
                cVar.n(jSONObjectOptJSONObject.optString("permission_classify_url"));
                cVar.a(jSONObjectOptJSONObject.optString("policy_url"));
                cVar.sp(jSONObjectOptJSONObject.optString("icon_url"));
                cVar.x(jSONObjectOptJSONObject.optString("download_url"));
                cVar.i(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult getAuthInfo");
        }
        return cVar;
    }

    private static void c(JSONArray jSONArray, List<c.C0464c> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                c.C0464c c0464c = new c.C0464c();
                c0464c.c(jSONObjectOptJSONObject.optString("permission_name"));
                c0464c.tt(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0464c);
            }
        }
    }
}
