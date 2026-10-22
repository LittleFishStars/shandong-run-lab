package com.beizi.fusion;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27798a;
    private p7 b;
    private o7 c;
    private long d;
    private String e;
    private String f;
    private String g;
    private long h;
    private long i;
    private n5 j;
    private p5 k;
    private ArrayList l;
    private boolean m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27799a;
        private p7 b;
        private o7 c;
        private long d;
        private String e;
        private String f;
        private String g;
        private long h;
        private long i;
        private n5 j;
        private p5 k;
        private ArrayList l = new ArrayList();
        private boolean m;

        public a a(p7 p7Var) {
            this.b = p7Var;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a c(long j) {
            this.d = j;
            return this;
        }

        public a d(String str) {
            this.f27799a = str;
            return this;
        }

        public a a(o7 o7Var) {
            this.c = o7Var;
            return this;
        }

        public a b(long j) {
            this.i = j;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a a(String str) {
            this.g = str;
            return this;
        }

        public a a(long j) {
            this.h = j;
            return this;
        }

        public a a(n5 n5Var) {
            this.j = n5Var;
            return this;
        }

        public a a(p5 p5Var) {
            this.k = p5Var;
            return this;
        }

        public a a(boolean z) {
            this.m = z;
            return this;
        }

        public u1 a() {
            u1 u1Var = new u1();
            u1Var.e = this.e;
            u1Var.j = this.j;
            u1Var.c = this.c;
            u1Var.h = this.h;
            u1Var.b = this.b;
            u1Var.d = this.d;
            u1Var.g = this.g;
            u1Var.i = this.i;
            u1Var.k = this.k;
            u1Var.l = this.l;
            u1Var.f = this.f;
            u1Var.f27798a = this.f27799a;
            u1Var.m = this.m;
            return u1Var;
        }

        public void a(t1 t1Var) {
            this.l.add(t1Var);
        }
    }

    private u1() {
    }

    private String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f27798a);
            if (this.m) {
                jSONObject.put("srcType", this.b.b());
                jSONObject.put("reqType", this.c.b());
            } else {
                jSONObject.put("srcType", this.b);
                jSONObject.put("reqType", this.c);
            }
            jSONObject.put("timeStamp", this.d);
            jSONObject.put("appid", this.e);
            jSONObject.put("appVersion", this.f);
            jSONObject.put("apkName", this.g);
            jSONObject.put("appInstallTime", this.h);
            jSONObject.put("appUpdateTime", this.i);
            n5 n5Var = this.j;
            if (n5Var != null) {
                jSONObject.put("devInfo", n5Var.a());
            }
            p5 p5Var = this.k;
            if (p5Var != null) {
                jSONObject.put("envInfo", p5Var.a());
            }
            ArrayList arrayList = this.l;
            if (arrayList != null && arrayList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.l.size(); i++) {
                    jSONArray.put(((t1) this.l.get(i)).a());
                }
                jSONObject.put("adReqInfo", jSONArray);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return a();
    }
}
