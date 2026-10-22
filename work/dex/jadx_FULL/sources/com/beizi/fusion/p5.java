package com.beizi.fusion;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l7 f27643a;
    private k7 b;
    private o5 c;
    private boolean d;
    private int e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private l7 f27644a;
        private k7 b;
        private o5 c;
        private boolean d;
        private int e;

        public a a(l7 l7Var) {
            this.f27644a = l7Var;
            return this;
        }

        public a a(k7 k7Var) {
            this.b = k7Var;
            return this;
        }

        public a a(o5 o5Var) {
            this.c = o5Var;
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public p5 a() {
            p5 p5Var = new p5();
            p5Var.c = this.c;
            p5Var.f27643a = this.f27644a;
            p5Var.b = this.b;
            p5Var.d = this.d;
            p5Var.e = this.e;
            return p5Var;
        }
    }

    private p5() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.d) {
                jSONObject.put("net", this.f27643a.b());
                jSONObject.put("isp", this.b.b());
            } else {
                jSONObject.put("net", this.f27643a);
                jSONObject.put("isp", this.b);
            }
            o5 o5Var = this.c;
            if (o5Var != null) {
                jSONObject.put("geo", o5Var.a());
            }
            jSONObject.put("isVpn", this.e);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
