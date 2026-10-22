package com.kc.cw.ad.a;

import android.text.TextUtils;
import com.kc.cw.ad.model.ComplianceInfo;
import com.kc.cw.ad.model.ShakeValue;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class c {

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.kc.cw.ad.a.g.f f38666a;
        private String b;
        private String c;
        private List<e> d;

        public com.kc.cw.ad.a.g.f a() {
            return this.f38666a;
        }

        public void a(com.kc.cw.ad.a.g.f fVar) {
            this.f38666a = fVar;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(List<e> list) {
            this.d = list;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.c = str;
        }

        public List<e> c() {
            return this.d;
        }

        public int d() {
            List<e> list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38667a;
        private String b;
        private String c;
        private int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private com.kc.cw.ad.a.e j;
        private ComplianceInfo k;
        private com.kc.cw.ad.a.i l;
        private String m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r;
        private i s;
        private a t;
        private C0965b u;
        private List<z> v;
        private List<i> w;

        @Keep
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List<String> f38668a;
            private List<String> b;
            private List<String> c;
            private List<String> d;
            private List<String> e;
            private List<String> f;
            private List<String> g;
            private List<String> h;
            private List<String> i;
            private List<String> j;
            private List<String> k;
            private List<String> l;
            private List<String> m;
            private List<String> n;
            private List<String> o;

            public List<String> a() {
                return this.b;
            }

            public void a(List<String> list) {
                this.f38668a = list;
            }

            public List<String> b() {
                return this.c;
            }

            public void b(List<String> list) {
                this.b = list;
            }

            public List<String> c() {
                return this.d;
            }

            public void c(List<String> list) {
                this.c = list;
            }

            public List<String> d() {
                return this.e;
            }

            public void d(List<String> list) {
                this.d = list;
            }

            public void e(List<String> list) {
                this.e = list;
            }

            public void f(List<String> list) {
                this.f = list;
            }

            public void g(List<String> list) {
                this.g = list;
            }

            public void h(List<String> list) {
                this.h = list;
            }

            public void i(List<String> list) {
                this.i = list;
            }

            public void j(List<String> list) {
                this.j = list;
            }

            public void k(List<String> list) {
                this.k = list;
            }

            public void l(List<String> list) {
                this.l = list;
            }

            public void m(List<String> list) {
                this.m = list;
            }

            public void n(List<String> list) {
                this.n = list;
            }

            public void o(List<String> list) {
                this.o = list;
            }
        }

        /* JADX INFO: renamed from: com.kc.cw.ad.a.c$b$b, reason: collision with other inner class name */
        @Keep
        public static class C0965b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List<String> f38669a;
            private List<String> b;
            private List<String> c;
            private List<String> d;
            private List<String> e;
            private List<a> f;

            /* JADX INFO: renamed from: com.kc.cw.ad.a.c$b$b$a */
            @Keep
            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private int f38670a;
                private List<String> b;

                public void a(int i) {
                    this.f38670a = i;
                }

                public void a(List<String> list) {
                    this.b = list;
                }
            }

            public void a(List<String> list) {
                this.f38669a = list;
            }

            public void b(List<String> list) {
                this.b = list;
            }

            public void c(List<String> list) {
                this.c = list;
            }

            public void d(List<String> list) {
                this.d = list;
            }

            public void e(List<String> list) {
                this.e = list;
            }

            public void f(List<a> list) {
                this.f = list;
            }
        }

        public String a() {
            return this.f38667a;
        }

        public void a(int i) {
            this.d = i;
        }

        public void a(a aVar) {
            this.t = aVar;
        }

        public void a(C0965b c0965b) {
            this.u = c0965b;
        }

        public void a(com.kc.cw.ad.a.e eVar) {
            this.j = eVar;
        }

        public void a(com.kc.cw.ad.a.i iVar) {
            this.l = iVar;
        }

        public void a(ComplianceInfo complianceInfo) {
            this.k = complianceInfo;
        }

        public void a(String str) {
            this.f38667a = str;
        }

        public void a(List<z> list) {
            this.v = list;
        }

        public void a(boolean z) {
            this.o = z;
        }

        public String b() {
            return this.b;
        }

        public void b(int i) {
            this.r = i;
        }

        public void b(String str) {
            this.b = str;
        }

        public void b(List<i> list) {
            this.w = list;
        }

        public void b(boolean z) {
            this.n = z;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public void c(boolean z) {
            this.p = z;
        }

        public int d() {
            return this.d;
        }

        public void d(String str) {
            this.e = str;
        }

        public void d(boolean z) {
            this.q = z;
        }

        public String e() {
            return this.e;
        }

        public void e(String str) {
            this.f = str;
        }

        public String f() {
            return this.f;
        }

        public void f(String str) {
            this.g = str;
        }

        public String g() {
            return this.h;
        }

        public void g(String str) {
            this.h = str;
        }

        public String h() {
            return this.i;
        }

        public void h(String str) {
            this.i = str;
        }

        public ComplianceInfo i() {
            return this.k;
        }

        public String j() {
            return this.m;
        }

        public i k() {
            return this.s;
        }

        public boolean l() {
            return this.o;
        }

        public boolean m() {
            return this.n;
        }

        public boolean n() {
            return this.p;
        }

        public boolean o() {
            return this.q;
        }

        public a p() {
            return this.t;
        }

        public com.kc.cw.ad.a.i q() {
            return this.l;
        }

        public com.kc.cw.ad.a.e r() {
            return this.j;
        }

        public List<z> s() {
            return this.v;
        }

        public List<i> t() {
            return this.w;
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.a.c$c, reason: collision with other inner class name */
    @Keep
    public static class C0966c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38671a;
        private String b;
        private String c;
        private String d;

        public String a() {
            return this.f38671a;
        }

        public void a(String str) {
            this.f38671a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }
    }

    @Keep
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38672a;
        private b b;
        private C0966c c;
        private List<a> d;
        private List<Object> e;
        private int f;
        private String g;
        private String h;
        private long i;

        public String a() {
            return this.f38672a;
        }

        public void a(int i) {
            this.f = i;
        }

        public void a(long j) {
            this.i = j;
        }

        public void a(b bVar) {
            this.b = bVar;
        }

        public void a(C0966c c0966c) {
            this.c = c0966c;
        }

        public void a(String str) {
            this.f38672a = str;
        }

        public void a(List<a> list) {
            this.d = list;
        }

        public String b() {
            return this.h;
        }

        public void b(String str) {
            this.h = str;
        }

        public long c() {
            return this.i;
        }

        public void c(String str) {
            this.g = str;
        }

        public b d() {
            return this.b;
        }

        public int e() {
            List<a> list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public C0966c f() {
            return this.c;
        }

        public List<a> g() {
            return this.d;
        }

        public List<Object> h() {
            return this.e;
        }

        public int i() {
            List<Object> list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int j() {
            return this.f;
        }

        public String k() {
            return this.g;
        }
    }

    @Keep
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38673a;
        private String b;
        private String c;

        public String a() {
            return this.c;
        }

        public void a(String str) {
            this.f38673a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }
    }

    @Keep
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38674a;
        private String b;

        public String a() {
            return this.f38674a;
        }

        public void a(String str) {
            this.f38674a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }
    }

    @Keep
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38675a;
        private int b;
        private int c;
        private int d;

        public int a() {
            return this.f38675a;
        }

        public void a(int i) {
            this.f38675a = i;
        }

        public int b() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.d;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.d = i;
        }
    }

    @Keep
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38676a;
        private int b;

        public void a(int i) {
            this.f38676a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    @Keep
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38677a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;

        public String a() {
            return this.f38677a;
        }

        public void a(String str) {
            this.f38677a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public void e(String str) {
            this.e = str;
        }

        public void f(String str) {
            this.f = str;
        }

        public void g(String str) {
            this.g = str;
        }

        public void h(String str) {
            this.h = str;
        }

        public void i(String str) {
            this.i = str;
        }
    }

    @Keep
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38678a;

        public int a() {
            return this.f38678a;
        }

        public void a(int i) {
            this.f38678a = i;
        }
    }

    @Keep
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38679a;
        private int b;
        private double c;
        private double d;

        public int a() {
            return this.f38679a;
        }

        public void a(double d) {
            this.c = d;
        }

        public void a(int i) {
            this.f38679a = i;
        }

        public int b() {
            return this.b;
        }

        public void b(double d) {
            this.d = d;
        }

        public void b(int i) {
            this.b = i;
        }

        public double c() {
            return this.c;
        }

        public double d() {
            return this.d;
        }
    }

    @Keep
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38680a;
        private int b;
        private String c;
        private String d;

        public int a() {
            return this.f38680a;
        }

        public void a(int i) {
            this.f38680a = i;
        }

        public void a(String str) {
            this.c = str;
        }

        public int b() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }
    }

    @Keep
    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38681a;
        private int b;

        public int a() {
            return this.b;
        }

        public void a(int i) {
            this.f38681a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    @Keep
    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38682a;
        private int b;

        public void a(int i) {
            this.f38682a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    @Keep
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private m f38683a;
        private r b;
        private u c;
        private s d;

        public m a() {
            return this.f38683a;
        }

        public void a(m mVar) {
            this.f38683a = mVar;
        }

        public void a(r rVar) {
            this.b = rVar;
        }

        public void a(s sVar) {
            this.d = sVar;
        }

        public void a(u uVar) {
            this.c = uVar;
        }

        public r b() {
            return this.b;
        }

        public u c() {
            return this.c;
        }

        public s d() {
            return this.d;
        }
    }

    @Keep
    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38684a;
        private int b;
        private int c;
        private int d;

        public int a() {
            return this.f38684a;
        }

        public void a(int i) {
            this.f38684a = i;
        }

        public int b() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.c;
        }

        public void c(int i) {
            this.c = i;
        }

        public int d() {
            return this.d;
        }

        public void d(int i) {
            this.d = i;
        }
    }

    @Keep
    public static class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38685a;
        private int b;

        public void a(int i) {
            this.f38685a = i;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    @Keep
    public static class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38686a;
        private String b;

        public int a() {
            return this.f38686a;
        }

        public void a(int i) {
            this.f38686a = i;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.b;
        }
    }

    @Keep
    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38687a;
        private String b;

        public int a() {
            return this.f38687a;
        }

        public void a(int i) {
            this.f38687a = i;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.b;
        }
    }

    @Keep
    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38688a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private int h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l = true;
        private Boolean m;
        private boolean n;
        private boolean o;
        private long p;
        private k q;
        private l r;
        private y s;
        private com.kc.cw.ad.a.h t;
        private ShakeValue u;
        private List<v> v;
        private Map<String, Object> w;

        public static t a(InputStream inputStream, String str, String str2, long j, boolean z) {
            if (inputStream == null) {
                return null;
            }
            try {
                String strA = a(inputStream);
                if (TextUtils.isEmpty(strA)) {
                    return null;
                }
                com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "是否缓存广告：" + z);
                if (z) {
                    com.kc.cw.ad.internal.c.o.a(com.kc.cw.ad.internal.q.a().l(), "adPreRsp_" + str, strA + "@#&!" + str2 + "@#&!" + System.currentTimeMillis());
                }
                return b(str, str2, j, strA, false);
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }

        public static t a(String str, String str2, long j, String str3, boolean z) {
            try {
                return b(str, str2, j, str3, z);
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                return null;
            }
        }

        private static String a(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        }

        private static ArrayList<String> a(JSONArray jSONArray) throws JSONException {
            ArrayList<String> arrayList = new ArrayList<>();
            if (b(jSONArray)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 35491. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        private static com.kc.cw.ad.a.c.t b(java.lang.String r41, java.lang.String r42, long r43, java.lang.String r45, boolean r46) throws org.json.JSONException {
            /*
                Method dump skipped, instruction units count: 3549
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kc.cw.ad.a.c.t.b(java.lang.String, java.lang.String, long, java.lang.String, boolean):com.kc.cw.ad.a.c$t");
        }

        private static boolean b(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }

        public int a() {
            List<v> list = this.v;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(int i) {
            this.f38688a = i;
        }

        public void a(long j) {
            this.p = j;
        }

        public void a(k kVar) {
            this.q = kVar;
        }

        public void a(l lVar) {
            this.r = lVar;
        }

        public void a(y yVar) {
            this.s = yVar;
        }

        public void a(com.kc.cw.ad.a.h hVar) {
            this.t = hVar;
        }

        public void a(ShakeValue shakeValue) {
            this.u = shakeValue;
        }

        public void a(Boolean bool) {
            this.m = bool;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(List<v> list) {
            this.v = list;
        }

        public void a(Map<String, Object> map) {
            this.w = map;
        }

        public void a(boolean z) {
            this.i = z;
        }

        public int b() {
            return this.f38688a;
        }

        public void b(int i) {
            this.h = i;
        }

        public void b(String str) {
            this.c = str;
        }

        public void b(boolean z) {
            this.j = z;
        }

        public String c() {
            return this.b;
        }

        public void c(String str) {
            this.d = str;
        }

        public void c(boolean z) {
            this.k = z;
        }

        public void d(String str) {
            this.f = str;
        }

        public void d(boolean z) {
            com.kc.cw.ad.internal.c.o.a(com.kc.cw.ad.internal.q.a().l(), "logReportFlag", Boolean.valueOf(z));
        }

        public boolean d() {
            return this.i;
        }

        public int e() {
            return this.h;
        }

        public void e(String str) {
            this.g = str;
        }

        public void e(boolean z) {
            this.l = z;
        }

        public void f(String str) {
            this.e = str;
        }

        public void f(boolean z) {
            this.n = z;
        }

        public boolean f() {
            return this.j;
        }

        public void g(boolean z) {
            this.o = z;
        }

        public boolean g() {
            return this.k;
        }

        public String h() {
            return this.d;
        }

        public String i() {
            return this.e;
        }

        public String j() {
            return this.f;
        }

        public String k() {
            return this.g;
        }

        public boolean l() {
            return this.l;
        }

        public Boolean m() {
            return this.m;
        }

        public boolean n() {
            return this.n;
        }

        public boolean o() {
            return this.o;
        }

        public k p() {
            return this.q;
        }

        public l q() {
            return this.r;
        }

        public y r() {
            return this.s;
        }

        public com.kc.cw.ad.a.h s() {
            return this.t;
        }

        public ShakeValue t() {
            return this.u;
        }

        public Map<String, Object> u() {
            return this.w;
        }

        public List<v> v() {
            return this.v;
        }
    }

    @Keep
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38689a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private double h;
        private double i;
        private String j;

        public u() {
            this.c = 1;
            this.h = 1.5d;
        }

        public u(double d, double d2, int i, String str, int i2, int i3, int i4, int i5) {
            this.h = d;
            this.d = i;
            this.i = d2;
            this.j = str;
            this.c = i2;
            this.b = i3;
            this.e = i4;
            this.f = i5;
        }

        public int a() {
            return this.f38689a;
        }

        public void a(double d) {
            this.h = d;
        }

        public void a(int i) {
            this.f38689a = i;
        }

        public void a(String str) {
            this.j = str;
        }

        public int b() {
            return this.b;
        }

        public void b(double d) {
            this.i = d;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.d;
        }

        public void c(int i) {
            this.d = i;
        }

        public double d() {
            return this.h;
        }

        public void d(int i) {
            this.c = i;
        }

        public String e() {
            return this.j;
        }

        public void e(int i) {
            this.e = i;
        }

        public double f() {
            return this.i;
        }

        public void f(int i) {
            this.f = i;
        }

        public int g() {
            return this.c;
        }

        public void g(int i) {
            this.g = i;
        }

        public int h() {
            return this.e;
        }

        public int i() {
            return this.g;
        }
    }

    @Keep
    public static class v {
        private boolean A;
        private boolean B;
        private boolean C;
        private boolean D;
        private boolean E;
        private boolean F;
        private boolean G;
        private boolean H;
        private String I;
        private int J;
        private int K;
        private int L;
        private int M;
        private String N;
        private int O;
        private List<d> P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38690a;
        private String b;
        private com.kc.cw.ad.a.g.a c;
        private int d;
        private String e;
        private com.kc.cw.ad.a.g.h f;
        private int g;
        private String h;
        private String i;
        private f j;
        private o k;
        private w l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private int s;
        private int t;
        private int u;
        private int v;
        private boolean w;
        private boolean x;
        private boolean y;
        private boolean z;

        public int A() {
            return this.L;
        }

        public int B() {
            return this.v;
        }

        public boolean C() {
            return this.B;
        }

        public boolean D() {
            return this.C;
        }

        public boolean E() {
            return this.D;
        }

        public boolean F() {
            return this.E;
        }

        public boolean G() {
            return this.F;
        }

        public boolean H() {
            return this.G;
        }

        public boolean I() {
            return this.H;
        }

        public String J() {
            return this.I;
        }

        public int K() {
            return this.J;
        }

        public int L() {
            return this.O;
        }

        public List<d> M() {
            return this.P;
        }

        public int N() {
            List<d> list = this.P;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String a() {
            return this.f38690a;
        }

        public void a(int i) {
            this.d = i;
        }

        public void a(f fVar) {
            this.j = fVar;
        }

        public void a(o oVar) {
            this.k = oVar;
        }

        public void a(w wVar) {
            this.l = wVar;
        }

        public void a(com.kc.cw.ad.a.g.a aVar) {
            this.c = aVar;
        }

        public void a(com.kc.cw.ad.a.g.h hVar) {
            this.f = hVar;
        }

        public void a(String str) {
            this.f38690a = str;
        }

        public void a(List<d> list) {
            this.P = list;
        }

        public void a(boolean z) {
            this.m = z;
        }

        public String b() {
            return this.b;
        }

        public void b(int i) {
            this.g = i;
        }

        public void b(String str) {
            this.b = str;
        }

        public void b(boolean z) {
            this.n = z;
        }

        public com.kc.cw.ad.a.g.a c() {
            return this.c;
        }

        public void c(int i) {
            this.s = i;
        }

        public void c(String str) {
            this.e = str;
        }

        public void c(boolean z) {
            this.o = z;
        }

        public int d() {
            return this.d;
        }

        public void d(int i) {
            this.t = i;
        }

        public void d(String str) {
            this.h = str;
        }

        public void d(boolean z) {
            this.p = z;
        }

        public String e() {
            return this.e;
        }

        public void e(int i) {
            this.u = i;
        }

        public void e(String str) {
            this.i = str;
        }

        public void e(boolean z) {
            this.q = z;
        }

        public com.kc.cw.ad.a.g.h f() {
            return this.f;
        }

        public void f(int i) {
            this.L = i;
        }

        public void f(String str) {
            this.I = str;
        }

        public void f(boolean z) {
            this.r = z;
        }

        public int g() {
            return this.g;
        }

        public void g(int i) {
            this.v = i;
        }

        public void g(String str) {
            this.N = str;
        }

        public void g(boolean z) {
            this.w = z;
        }

        public String h() {
            return this.h;
        }

        public void h(int i) {
            this.J = i;
        }

        public void h(boolean z) {
            this.x = z;
        }

        public String i() {
            return this.i;
        }

        public void i(int i) {
            this.K = i;
        }

        public void i(boolean z) {
            this.y = z;
        }

        public f j() {
            return this.j;
        }

        public void j(int i) {
            this.M = i;
        }

        public void j(boolean z) {
            this.z = z;
        }

        public o k() {
            return this.k;
        }

        public void k(int i) {
            this.O = i;
        }

        public void k(boolean z) {
            this.A = z;
        }

        public w l() {
            return this.l;
        }

        public void l(boolean z) {
            this.B = z;
        }

        public void m(boolean z) {
            this.C = z;
        }

        public boolean m() {
            return this.m;
        }

        public void n(boolean z) {
            this.D = z;
        }

        public boolean n() {
            return this.n;
        }

        public void o(boolean z) {
            this.E = z;
        }

        public boolean o() {
            return this.o;
        }

        public void p(boolean z) {
            this.F = z;
        }

        public boolean p() {
            return this.p;
        }

        public void q(boolean z) {
            this.H = z;
        }

        public boolean q() {
            return this.q;
        }

        public boolean r() {
            return this.r;
        }

        public int s() {
            return this.s;
        }

        public int t() {
            return this.t;
        }

        public int u() {
            return this.u;
        }

        public boolean v() {
            return this.w;
        }

        public boolean w() {
            return this.x;
        }

        public boolean x() {
            return this.y;
        }

        public boolean y() {
            return this.z;
        }

        public boolean z() {
            return this.A;
        }
    }

    @Keep
    public static class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q f38691a;
        private g b;
        private n c;
        private h d;
        private x e;
        private j f;
        private p g;
        private k h;
        private l i;
        private y j;

        public g a() {
            return this.b;
        }

        public void a(g gVar) {
            this.b = gVar;
        }

        public void a(h hVar) {
            this.d = hVar;
        }

        public void a(j jVar) {
            this.f = jVar;
        }

        public void a(k kVar) {
            this.h = kVar;
        }

        public void a(l lVar) {
            this.i = lVar;
        }

        public void a(n nVar) {
            this.c = nVar;
        }

        public void a(p pVar) {
            this.g = pVar;
        }

        public void a(q qVar) {
            this.f38691a = qVar;
        }

        public void a(x xVar) {
            this.e = xVar;
        }

        public void a(y yVar) {
            this.j = yVar;
        }

        public j b() {
            return this.f;
        }

        public p c() {
            return this.g;
        }
    }

    @Keep
    public static class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38692a;

        public void a(int i) {
            this.f38692a = i;
        }
    }

    @Keep
    public static class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38693a;
        private int b;

        public int a() {
            return this.f38693a;
        }

        public void a(int i) {
            this.f38693a = i;
        }

        public int b() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }
    }

    @Keep
    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f38694a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public String a() {
            return this.f38694a;
        }

        public void a(String str) {
            this.f38694a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public String e() {
            return this.e;
        }

        public void e(String str) {
            this.e = str;
        }

        public String f() {
            return this.f;
        }

        public void f(String str) {
            this.f = str;
        }

        public String g() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }
    }
}
