package com.byazt.ete;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 350})
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28507a;
    public boolean c;
    public String n;
    public ir tt;
    public int uj;
    public c ve;

    @com.byazt.zqa.c(c = {0, 1, 8, 2191})
    public static class c extends u {
        public C0397c tt;
        public C0397c ve;

        /* JADX INFO: renamed from: com.byazt.ete.p$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 8, 2291})
        public static class C0397c {
            public String c;
            public int tt;

            public C0397c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.c = jSONObject.optString(RVParams.LONG_URL_WITH_ENTRY_KEY);
                this.tt = jSONObject.optInt("displayAreaAndroid");
            }

            public boolean c() {
                return !TextUtils.isEmpty(this.c);
            }
        }

        public c(JSONObject jSONObject, int i) {
            if (jSONObject == null) {
                return;
            }
            this.tt = new C0397c(jSONObject.optJSONObject("vertical"));
            this.ve = new C0397c(jSONObject.optJSONObject("horizontal"));
            this.c = i;
        }

        public boolean a() {
            C0397c c0397c = this.ve;
            if (c0397c != null && c0397c.c()) {
                return true;
            }
            C0397c c0397c2 = this.tt;
            return c0397c2 != null && c0397c2.c();
        }

        public String c(boolean z) {
            C0397c c0397c;
            if (z && (c0397c = this.tt) != null && c0397c.c()) {
                return this.tt.c;
            }
            C0397c c0397c2 = this.ve;
            if (c0397c2 != null && c0397c2.c()) {
                return this.ve.c;
            }
            C0397c c0397c3 = this.tt;
            return (c0397c3 == null || !c0397c3.c()) ? "" : this.tt.c;
        }

        @Override // com.byazt.ete.u
        public String n() {
            return "";
        }

        @Override // com.byazt.ete.u
        public int uj() {
            C0397c c0397c = this.tt;
            if (c0397c != null) {
                return c0397c.tt;
            }
            C0397c c0397c2 = this.ve;
            if (c0397c2 != null) {
                return c0397c2.tt;
            }
            return 0;
        }

        @Override // com.byazt.ete.u
        public int ve() {
            return 0;
        }
    }

    public p(JSONObject jSONObject) {
        this.c = false;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optBoolean("use_interact_webview", false);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable_client");
        if (jSONObjectOptJSONObject != null) {
            this.tt = new ir(jSONObjectOptJSONObject.optJSONObject("components"), 1);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject2 != null) {
            this.ve = new c(jSONObjectOptJSONObject2.optJSONObject("components"), 2);
        }
        this.uj = jSONObject.optInt("style_category");
        this.n = jSONObject.optString("exp_id");
        this.f28507a = jSONObject.optString("group_id");
    }

    public static String a(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.vt().f28507a;
    }

    public static boolean c(ic icVar) {
        return tt(icVar) || ve(icVar);
    }

    public static String n(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.vt().n;
    }

    public static c sp(ic icVar) {
        p pVarVt;
        if (icVar == null || (pVarVt = icVar.vt()) == null) {
            return null;
        }
        return pVarVt.ve;
    }

    public static boolean tt(ic icVar) {
        p pVarVt;
        ir irVar;
        return (icVar == null || (pVarVt = icVar.vt()) == null || (irVar = pVarVt.tt) == null || !irVar.t()) ? false : true;
    }

    public static int uj(ic icVar) {
        if (icVar == null) {
            return 0;
        }
        return icVar.vt().uj;
    }

    public static boolean ve(ic icVar) {
        p pVarVt;
        c cVar;
        return (icVar == null || (pVarVt = icVar.vt()) == null || !pVarVt.c || (cVar = pVarVt.ve) == null || !cVar.a()) ? false : true;
    }

    public static ir x(ic icVar) {
        p pVarVt;
        if (icVar == null || (pVarVt = icVar.vt()) == null) {
            return null;
        }
        return pVarVt.tt;
    }

    public static boolean c() {
        int i = com.byazt.omf.p.uj;
        return (i >= 6322 && i < 6400) || i >= 6406;
    }
}
