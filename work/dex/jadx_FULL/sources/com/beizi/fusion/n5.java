package com.beizi.fusion;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.hms.adapter.internal.CommonCode;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class n5 {
    private String A;
    private String B;
    private int C;
    private String D;
    private String E;
    private boolean F;
    private String G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27553a;
    private String b;
    private String c;
    private m7 d;
    private j7 e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private HashSet s;
    private String t;
    private boolean u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public static class a {
        private String A;
        private String B;
        private int C;
        private String D;
        private String E;
        private boolean F;
        private String G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27554a;
        private String b;
        private String c;
        private m7 d;
        private j7 e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private String q;
        private String r;
        private HashSet s;
        private String t;
        private boolean u;
        private String v;
        private String w;
        private String x;
        private String y;
        private String z;

        public a a(m7 m7Var) {
            this.d = m7Var;
            return this;
        }

        public a b(boolean z) {
            this.u = z;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.l = str;
            return this;
        }

        public a e(String str) {
            this.z = str;
            return this;
        }

        public a f(String str) {
            this.A = str;
            return this;
        }

        public a g(String str) {
            this.o = str;
            return this;
        }

        public a h(String str) {
            this.b = str;
            return this;
        }

        public a i(String str) {
            this.k = str;
            return this;
        }

        public a j(String str) {
            this.h = str;
            return this;
        }

        public a k(String str) {
            this.g = str;
            return this;
        }

        public a l(String str) {
            this.n = str;
            return this;
        }

        public a m(String str) {
            this.w = str;
            return this;
        }

        public a n(String str) {
            this.v = str;
            return this;
        }

        public a o(String str) {
            this.c = str;
            return this;
        }

        public a p(String str) {
            this.y = str;
            return this;
        }

        public a q(String str) {
            this.i = str;
            return this;
        }

        public a r(String str) {
            this.B = str;
            return this;
        }

        public a s(String str) {
            this.m = str;
            return this;
        }

        public a t(String str) {
            this.j = str;
            return this;
        }

        public a u(String str) {
            this.f27554a = str;
            return this;
        }

        public a v(String str) {
            this.E = str;
            return this;
        }

        public a w(String str) {
            this.G = str;
            return this;
        }

        public a x(String str) {
            this.r = str;
            return this;
        }

        public a y(String str) {
            this.x = str;
            return this;
        }

        public a a(j7 j7Var) {
            this.e = j7Var;
            return this;
        }

        public a b(String str) {
            this.D = str;
            return this;
        }

        public a a(String str) {
            this.t = str;
            return this;
        }

        public a a(int i) {
            this.C = i;
            return this;
        }

        public a a(boolean z) {
            this.F = z;
            return this;
        }

        public n5 a() {
            n5 n5Var = new n5();
            n5Var.e = this.e;
            n5Var.d = this.d;
            n5Var.m = this.m;
            n5Var.k = this.k;
            n5Var.l = this.l;
            n5Var.g = this.g;
            n5Var.h = this.h;
            n5Var.i = this.i;
            n5Var.j = this.j;
            n5Var.c = this.c;
            n5Var.f27553a = this.f27554a;
            n5Var.n = this.n;
            n5Var.o = this.o;
            n5Var.p = this.p;
            n5Var.b = this.b;
            n5Var.f = this.f;
            n5Var.s = this.s;
            n5Var.q = this.q;
            n5Var.r = this.r;
            n5Var.t = this.t;
            n5Var.u = this.u;
            n5Var.v = this.v;
            n5Var.w = this.w;
            n5Var.x = this.x;
            n5Var.y = this.y;
            n5Var.z = this.z;
            n5Var.A = this.A;
            n5Var.B = this.B;
            n5Var.C = this.C;
            n5Var.D = this.D;
            n5Var.E = this.E;
            n5Var.F = this.F;
            n5Var.G = this.G;
            return n5Var;
        }
    }

    private n5() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkUID", this.f27553a);
            jSONObject.put("idfa", this.b);
            jSONObject.put("os", this.c);
            if (this.F) {
                jSONObject.put("platform", this.d.b());
                jSONObject.put("devType", this.e.b());
            } else {
                jSONObject.put("platform", this.d);
                jSONObject.put("devType", this.e);
            }
            jSONObject.put("brand", this.f);
            jSONObject.put(ze1.k, this.g);
            jSONObject.put(ze1.p, this.h);
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.i);
            jSONObject.put("screenSize", this.j);
            jSONObject.put(MediaFormat.KEY_LANGUAGE, this.k);
            jSONObject.put("density", this.l);
            jSONObject.put("root", this.m);
            jSONObject.put(DeviceIdType.OAID, this.n);
            jSONObject.put("honorOaid", this.o);
            jSONObject.put(DeviceIdType.GAID, this.p);
            jSONObject.put("bootMark", this.q);
            jSONObject.put("updateMark", this.r);
            jSONObject.put("ag_vercode", this.t);
            jSONObject.put("wx_installed", this.u);
            jSONObject.put("opensdk_ver", this.v);
            jSONObject.put("opensdk_appid", this.w);
            jSONObject.put("wx_api_ver", this.x);
            jSONObject.put("physicalMemory", this.y);
            jSONObject.put("harddiskSize", this.z);
            jSONObject.put("hmsCoreVersion", this.A);
            jSONObject.put("romVersion", this.B);
            jSONObject.put("dpStatus", this.C);
            jSONObject.put(DeviceIdType.ANDROID_ID, this.D);
            jSONObject.put("storeVersion", this.E);
            jSONObject.put("ua", this.G);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
