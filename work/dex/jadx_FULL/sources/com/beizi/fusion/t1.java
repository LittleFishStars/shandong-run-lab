package com.beizi.fusion;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27768a;
    private String b;
    private String c;
    private long d;
    private String e;
    private int f;
    private List g;
    private int h;
    private String i;
    private String j;
    private String k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27769a;
        private String b;
        private String c;
        private long d;
        private String e;
        private int f;
        private List g;
        private int h;
        private String i;
        private String j;
        private String k;

        public a a(List list) {
            this.g = list;
            return this;
        }

        public a b(int i) {
            this.f = i;
            return this;
        }

        public a c(String str) {
            this.k = str;
            return this;
        }

        public a d(String str) {
            this.c = str;
            return this;
        }

        public a e(String str) {
            this.f27769a = str;
            return this;
        }

        public a a(int i) {
            this.h = i;
            return this;
        }

        public a b(String str) {
            this.i = str;
            return this;
        }

        public a a(String str) {
            this.j = str;
            return this;
        }

        public t1 a() {
            t1 t1Var = new t1();
            t1Var.d = this.d;
            t1Var.c = this.c;
            t1Var.e = this.e;
            t1Var.b = this.b;
            t1Var.f27768a = this.f27769a;
            t1Var.f = this.f;
            t1Var.g = this.g;
            t1Var.h = this.h;
            t1Var.i = this.i;
            t1Var.j = this.j;
            t1Var.k = this.k;
            return t1Var;
        }
    }

    private t1() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("spaceID", this.f27768a);
            jSONObject.put("spaceParam", this.b);
            jSONObject.put("requestUUID", this.c);
            jSONObject.put("channelReserveTs", this.d);
            jSONObject.put("sdkExtInfo", this.e);
            jSONObject.put("isCache", this.f);
            List list = this.g;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.g.size(); i++) {
                    jSONArray.put(this.g.get(i));
                }
                jSONObject.put("orderList", jSONArray);
            }
            jSONObject.put("interactionType", this.h);
            jSONObject.put("modelVersion", this.i);
            jSONObject.put("blackListVersion", this.j);
            jSONObject.put("oppoInfo", this.k);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
