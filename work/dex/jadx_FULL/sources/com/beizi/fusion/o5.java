package com.beizi.fusion;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27594a;
    private String b;
    private String c;
    private long d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27595a;
        private String b;
        private String c;
        private long d;

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.f27595a = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public o5 a() {
            o5 o5Var = new o5();
            o5Var.f27594a = this.f27595a;
            o5Var.b = this.b;
            o5Var.c = this.c;
            o5Var.d = this.d;
            return o5Var;
        }
    }

    private o5() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("longitude", this.f27594a);
            jSONObject.put("latitude", this.b);
            jSONObject.put("name", this.c);
            jSONObject.put("timeStamp", this.d);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
