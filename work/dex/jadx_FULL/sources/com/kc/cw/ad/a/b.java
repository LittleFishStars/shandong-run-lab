package com.kc.cw.ad.a;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.model.ShakeValue;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class b {

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38662a;
        private String b;
        private String c;
        private long d;
        private String e;

        /* JADX INFO: renamed from: com.kc.cw.ad.a.b$a$a, reason: collision with other inner class name */
        @Keep
        public static final class C0963a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f38663a;
            private String b;
            private String c;
            private long d;
            private String e;

            public C0963a a(String str) {
                this.f38663a = str;
                return this;
            }

            public a a() {
                a aVar = new a();
                aVar.d = this.d;
                aVar.c = this.c;
                aVar.e = this.e;
                aVar.b = this.b;
                aVar.f38662a = this.f38663a;
                return aVar;
            }

            public C0963a b(String str) {
                this.b = str;
                return this;
            }

            public C0963a c(String str) {
                this.c = str;
                return this;
            }
        }

        private a() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("slotId", this.f38662a);
                jSONObject.put("spaceParam", this.b);
                jSONObject.put("requestUUID", this.c);
                jSONObject.put("channelReserveTs", this.d);
                jSONObject.put("sdkExtInfo", this.e);
                jSONObject.put("ssl", q.a().f);
                jSONObject.put("ipv6", q.a().g);
                return jSONObject;
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.a.b$b, reason: collision with other inner class name */
    @Keep
    public static class C0964b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38664a;
        private String b;
        private g.i c;
        private g.EnumC0968g d;
        private long e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private int k;
        private long l;
        private long m;
        private boolean n;
        private ShakeValue o;
        private f.a p;
        private f.c q;
        private f.b r;
        private ArrayList<a> s;

        /* JADX INFO: renamed from: com.kc.cw.ad.a.b$b$a */
        @Keep
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f38665a;
            private String b;
            private g.i c;
            private g.EnumC0968g d;
            private long e;
            private String f;
            private String g;
            private String h;
            private String i;
            private String j;
            private int k;
            private long l;
            private long m;
            private ShakeValue o;
            private f.a p;
            private f.c q;
            private f.b r;
            private boolean n = true;
            private ArrayList<a> s = new ArrayList<>();

            public a a(int i) {
                this.k = i;
                return this;
            }

            public a a(long j) {
                this.e = j;
                return this;
            }

            public a a(f.a aVar) {
                this.p = aVar;
                return this;
            }

            public a a(f.b bVar) {
                this.r = bVar;
                return this;
            }

            public a a(f.c cVar) {
                this.q = cVar;
                return this;
            }

            public a a(g.EnumC0968g enumC0968g) {
                this.d = enumC0968g;
                return this;
            }

            public a a(g.i iVar) {
                this.c = iVar;
                return this;
            }

            public a a(ShakeValue shakeValue) {
                this.o = shakeValue;
                return this;
            }

            public a a(String str) {
                this.f38665a = str;
                return this;
            }

            public a a(boolean z) {
                this.n = z;
                return this;
            }

            public C0964b a() {
                C0964b c0964b = new C0964b();
                c0964b.f = this.f;
                c0964b.g = this.g;
                c0964b.k = this.k;
                c0964b.p = this.p;
                c0964b.d = this.d;
                c0964b.l = this.l;
                c0964b.c = this.c;
                c0964b.e = this.e;
                c0964b.i = this.i;
                c0964b.j = this.j;
                c0964b.m = this.m;
                c0964b.n = this.n;
                c0964b.o = this.o;
                c0964b.q = this.q;
                c0964b.r = this.r;
                c0964b.s = this.s;
                c0964b.h = this.h;
                c0964b.f38664a = this.f38665a;
                c0964b.b = this.b;
                return c0964b;
            }

            public void a(a aVar) {
                this.s.add(aVar);
            }

            public a b(long j) {
                this.l = j;
                return this;
            }

            public a b(String str) {
                this.b = str;
                return this;
            }

            public a c(long j) {
                this.m = j;
                return this;
            }

            public a c(String str) {
                this.f = str;
                return this;
            }

            public a d(String str) {
                this.g = str;
                return this;
            }

            public a e(String str) {
                this.h = str;
                return this;
            }

            public a f(String str) {
                this.i = str;
                return this;
            }

            public a g(String str) {
                this.j = str;
                return this;
            }
        }

        private C0964b() {
        }

        private String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", this.f38664a);
                jSONObject.put("groupVersion", this.b);
                jSONObject.put("srcType", this.c);
                jSONObject.put("reqType", this.d);
                jSONObject.put("timeStamp", this.e);
                jSONObject.put("appid", this.f);
                jSONObject.put("reqid", this.g);
                jSONObject.put("retryReq", this.k);
                jSONObject.put("appVersion", this.h);
                jSONObject.put("appName", this.i);
                jSONObject.put(ALPParamConstant.PACKAGENAME, this.j);
                jSONObject.put("appInstallTime", this.l);
                jSONObject.put("appUpdateTime", this.m);
                jSONObject.put("isCanShake", this.n ? 1 : 0);
                if (this.o != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("acceleration", this.o.getAcceleration());
                    jSONObject2.put("angle", this.o.getAngle());
                    jSONObject2.put("time", this.o.getTime());
                    jSONObject.put("shakeValue", jSONObject2);
                }
                f.a aVar = this.p;
                if (aVar != null) {
                    jSONObject.put("devInfo", aVar.a());
                }
                f.c cVar = this.q;
                if (cVar != null) {
                    jSONObject.put("envInfo", cVar.a());
                }
                f.b bVar = this.r;
                if (bVar != null) {
                    jSONObject.put("locInfo", bVar.a());
                }
                ArrayList<a> arrayList = this.s;
                if (arrayList != null && !arrayList.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.s.size(); i++) {
                        jSONArray.put(this.s.get(i).a());
                    }
                    jSONObject.put("adReqInfo", jSONArray);
                }
                return jSONObject.toString();
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }

        public String toString() {
            return a();
        }
    }
}
