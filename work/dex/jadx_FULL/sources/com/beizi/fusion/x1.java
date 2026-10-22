package com.beizi.fusion;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class x1 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private n7 f28003a;
        private String b;
        private List c;

        public void a(n7 n7Var) {
            this.f28003a = n7Var;
        }

        public int b() {
            List list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public n7 c() {
            return this.f28003a;
        }

        public String d() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }

        public List a() {
            return this.c;
        }

        public void a(List list) {
            this.c = list;
        }
    }

    public static class b {
        private int A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28004a;
        private String b;
        private int c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private boolean j;
        private int k;
        private C0333b l;
        private c m;
        private List n;
        private String o;
        private String p;
        private String q;
        private String r;
        private String s;
        private String t;
        private String u;
        private a v;
        private String w;
        private String x;
        private String y;
        private String z;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f28005a;
            private int b;
            private int c;

            public int a() {
                return this.f28005a;
            }

            public int b() {
                return this.b;
            }

            public int c() {
                return this.c;
            }

            public void a(int i) {
                this.f28005a = i;
            }

            public void b(int i) {
                this.b = i;
            }

            public void c(int i) {
                this.c = i;
            }
        }

        /* JADX INFO: renamed from: com.beizi.fusion.x1$b$b, reason: collision with other inner class name */
        public static class C0333b implements Serializable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List f28006a;
            private List b;
            private List c;
            private List d;
            private List e;
            private List f;
            private List g;
            private List h;
            private List i;
            private List j;
            private List k;
            private List l;
            private List m;
            private List n;
            private List o;
            private List p;
            private List q;
            private List r;

            public List a() {
                return this.b;
            }

            public void b(List list) {
                this.b = list;
            }

            public void c(List list) {
                this.d = list;
            }

            public void d(List list) {
                this.g = list;
            }

            public List e() {
                return this.c;
            }

            public void f(List list) {
                this.l = list;
            }

            public void g(List list) {
                this.c = list;
            }

            public void h(List list) {
                this.o = list;
            }

            public List i() {
                return this.f28006a;
            }

            public void j(List list) {
                this.e = list;
            }

            public List k() {
                return this.m;
            }

            public void l(List list) {
                this.f28006a = list;
            }

            public void m(List list) {
                this.k = list;
            }

            public void n(List list) {
                this.j = list;
            }

            public void o(List list) {
                this.i = list;
            }

            public void p(List list) {
                this.q = list;
            }

            public void q(List list) {
                this.m = list;
            }

            public void r(List list) {
                this.h = list;
            }

            public void a(List list) {
                this.f = list;
            }

            public List b() {
                return this.d;
            }

            public List c() {
                return this.n;
            }

            public List d() {
                return this.l;
            }

            public void e(List list) {
                this.n = list;
            }

            public List f() {
                return this.o;
            }

            public List g() {
                return this.p;
            }

            public List h() {
                return this.r;
            }

            public void i(List list) {
                this.p = list;
            }

            public List j() {
                return this.q;
            }

            public void k(List list) {
                this.r = list;
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List f28007a;
            private List b;
            private List c;
            private List d;
            private List e;
            private List f;

            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private int f28008a;
                private List b;

                public void a(int i) {
                    this.f28008a = i;
                }

                public void a(List list) {
                    this.b = list;
                }
            }

            public void a(List list) {
                this.e = list;
            }

            public void b(List list) {
                this.c = list;
            }

            public void c(List list) {
                this.d = list;
            }

            public void d(List list) {
                this.b = list;
            }

            public void e(List list) {
                this.f = list;
            }

            public void f(List list) {
                this.f28007a = list;
            }
        }

        public void a(int i) {
            this.c = i;
        }

        public String b() {
            return this.g;
        }

        public void c(int i) {
            this.k = i;
        }

        public String d() {
            return this.h;
        }

        public String e() {
            return this.t;
        }

        public String f() {
            return this.q;
        }

        public String g() {
            return this.r;
        }

        public String h() {
            return this.s;
        }

        public void i(String str) {
            this.f = str;
        }

        public void j(String str) {
            this.o = str;
        }

        public String k() {
            return this.b;
        }

        public void l(String str) {
            this.b = str;
        }

        public void m(String str) {
            this.f28004a = str;
        }

        public int n() {
            return this.c;
        }

        public void o(String str) {
            this.w = str;
        }

        public String p() {
            return this.f28004a;
        }

        public void q(String str) {
            this.e = str;
        }

        public String r() {
            return this.w;
        }

        public String s() {
            return this.x;
        }

        public String t() {
            return this.e;
        }

        public String u() {
            return this.i;
        }

        public List v() {
            return this.n;
        }

        public String w() {
            return this.z;
        }

        public String a() {
            return this.d;
        }

        public void b(String str) {
            this.g = str;
        }

        public String c() {
            return this.p;
        }

        public void d(String str) {
            this.h = str;
        }

        public void e(String str) {
            this.t = str;
        }

        public void f(String str) {
            this.q = str;
        }

        public void g(String str) {
            this.r = str;
        }

        public void h(String str) {
            this.s = str;
        }

        public String i() {
            return this.o;
        }

        public String j() {
            return this.u;
        }

        public void k(String str) {
            this.u = str;
        }

        public a l() {
            return this.v;
        }

        public C0333b m() {
            return this.l;
        }

        public void n(String str) {
            this.y = str;
        }

        public int o() {
            return this.A;
        }

        public void p(String str) {
            this.x = str;
        }

        public String q() {
            return this.y;
        }

        public void r(String str) {
            this.z = str;
        }

        public void a(String str) {
            this.d = str;
        }

        public void b(int i) {
            this.A = i;
        }

        public void c(String str) {
            this.p = str;
        }

        public void a(boolean z) {
            this.j = z;
        }

        public void a(C0333b c0333b) {
            this.l = c0333b;
        }

        public void a(c cVar) {
            this.m = cVar;
        }

        public void a(List list) {
            this.n = list;
        }

        public void a(a aVar) {
            this.v = aVar;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28009a;
        private String b;
        private String c;
        private String d;

        public String a() {
            return this.b;
        }

        public String b() {
            return this.f28009a;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.c;
        }

        public void a(String str) {
            this.b = str;
        }

        public void b(String str) {
            this.f28009a = str;
        }

        public void c(String str) {
            this.d = str;
        }

        public void d(String str) {
            this.c = str;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28010a;
        private b b;
        private c c;
        private List d;
        private List e;
        private String f;
        private String g;
        private e h;
        private w5 i;
        private String j;
        private int k;
        private im l;
        private String m;
        private String n;
        private String o;
        private kj p;
        private wk q;
        private nh r;
        private int s;
        private boolean t;
        private boolean u;
        private rn v;
        private cl w;
        private List x;
        private uk y;

        public void a(String str) {
            this.g = str;
        }

        public String b() {
            return this.g;
        }

        public void c(String str) {
            this.f28010a = str;
        }

        public int d() {
            List list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void e(String str) {
            this.f = str;
        }

        public void f(String str) {
            this.m = str;
        }

        public void g(String str) {
            this.j = str;
        }

        public w5 h() {
            return this.i;
        }

        public int i() {
            List list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public List j() {
            return this.d;
        }

        public int k() {
            return this.k;
        }

        public b l() {
            return this.b;
        }

        public nh m() {
            return this.r;
        }

        public kj n() {
            return this.p;
        }

        public uk o() {
            return this.y;
        }

        public wk p() {
            return this.q;
        }

        public String q() {
            return this.n;
        }

        public String r() {
            return this.f;
        }

        public String s() {
            return this.m;
        }

        public im t() {
            return this.l;
        }

        public String u() {
            return this.j;
        }

        public e v() {
            return this.h;
        }

        public rn w() {
            return this.v;
        }

        public int x() {
            return this.s;
        }

        public boolean y() {
            return this.u;
        }

        public boolean z() {
            return this.t;
        }

        public void a(b bVar) {
            this.b = bVar;
        }

        public void b(List list) {
            this.d = list;
        }

        public List c() {
            return this.e;
        }

        public void d(String str) {
            this.n = str;
        }

        public String e() {
            return this.o;
        }

        public List f() {
            return this.x;
        }

        public cl g() {
            return this.w;
        }

        public c a() {
            return this.c;
        }

        public void b(String str) {
            this.o = str;
        }

        public void a(c cVar) {
            this.c = cVar;
        }

        public void b(int i) {
            this.s = i;
        }

        public void a(e eVar) {
            this.h = eVar;
        }

        public void b(boolean z) {
            this.t = z;
        }

        public void a(w5 w5Var) {
            this.i = w5Var;
        }

        public void a(int i) {
            this.k = i;
        }

        public void a(im imVar) {
            this.l = imVar;
        }

        public void a(kj kjVar) {
            this.p = kjVar;
        }

        public void a(wk wkVar) {
            this.q = wkVar;
        }

        public void a(nh nhVar) {
            this.r = nhVar;
        }

        public void a(boolean z) {
            this.u = z;
        }

        public void a(rn rnVar) {
            this.v = rnVar;
        }

        public void a(cl clVar) {
            this.w = clVar;
        }

        public void a(List list) {
            this.x = list;
        }

        public void a(uk ukVar) {
            this.y = ukVar;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f28011a;
        private double b;
        private double c;

        public void a(boolean z) {
            this.f28011a = z;
        }

        public double b() {
            return this.b;
        }

        public boolean c() {
            return this.f28011a;
        }

        public double a() {
            return this.c;
        }

        public void b(double d) {
            this.b = d;
        }

        public void a(double d) {
            this.c = d;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28012a;
        private String b;

        public String a() {
            return this.b;
        }

        public void b(String str) {
            this.f28012a = str;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28013a = -1;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private String e;
        private String f;
        private String g;

        public int a() {
            return this.c;
        }

        public void b(int i) {
            this.b = i;
        }

        public int c() {
            return this.b;
        }

        public void d(int i) {
            this.f28013a = i;
        }

        public int e() {
            return this.f28013a;
        }

        public String f() {
            return this.f;
        }

        public String g() {
            return this.e;
        }

        public void a(int i) {
            this.c = i;
        }

        public void b(String str) {
            this.f = str;
        }

        public void c(int i) {
            this.d = i;
        }

        public int d() {
            return this.d;
        }

        public void a(String str) {
            this.g = str;
        }

        public String b() {
            return this.g;
        }

        public void c(String str) {
            this.e = str;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28014a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;

        public String a() {
            return this.b;
        }

        public void b(String str) {
            this.c = str;
        }

        public String c() {
            return this.d;
        }

        public void d(String str) {
            this.e = str;
        }

        public void e(String str) {
            this.f = str;
        }

        public void f(String str) {
            this.d = str;
        }

        public String g() {
            return this.f28014a;
        }

        public void h(String str) {
            this.i = str;
        }

        public void i(String str) {
            this.j = str;
        }

        public void j(String str) {
            this.f28014a = str;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.g;
        }

        public void c(String str) {
            this.g = str;
        }

        public String d() {
            return this.h;
        }

        public String e() {
            return this.i;
        }

        public String f() {
            return this.j;
        }

        public void g(String str) {
            this.h = str;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28015a;
        private String b;
        private String c;
        private long d;
        private List e;

        public void a(int i) {
            this.f28015a = i;
        }

        public int b() {
            List list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int c() {
            return this.f28015a;
        }

        public long d() {
            return this.d;
        }

        public void a(long j) {
            this.d = j;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        private static ArrayList b(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (a(jSONArray)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        }

        public List a() {
            return this.e;
        }

        public void a(List list) {
            this.e = list;
        }

        public static String a(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:214:0x07bf  */
        /* JADX WARN: Code duplicated, block: B:222:0x07df  */
        /* JADX WARN: Code duplicated, block: B:237:0x0812  */
        /* JADX WARN: Code duplicated, block: B:248:0x0832 A[Catch: Exception -> 0x083e, TryCatch #27 {Exception -> 0x083e, blocks: (B:246:0x082c, B:248:0x0832, B:249:0x0839), top: B:435:0x082c }] */
        /* JADX WARN: Code duplicated, block: B:276:0x08ae A[Catch: Exception -> 0x08b2, TRY_LEAVE, TryCatch #8 {Exception -> 0x08b2, blocks: (B:274:0x08a4, B:276:0x08ae), top: B:397:0x08a4 }] */
        /* JADX WARN: Code duplicated, block: B:281:0x08c0  */
        /* JADX WARN: Code duplicated, block: B:288:0x08d9  */
        /* JADX WARN: Code duplicated, block: B:297:0x08f6 A[Catch: Exception -> 0x08e9, TRY_ENTER, TryCatch #5 {Exception -> 0x08e9, blocks: (B:291:0x08e1, B:297:0x08f6, B:299:0x0900, B:302:0x0909, B:304:0x0913), top: B:391:0x08e1 }] */
        /* JADX WARN: Code duplicated, block: B:302:0x0909 A[Catch: Exception -> 0x08e9, TRY_ENTER, TryCatch #5 {Exception -> 0x08e9, blocks: (B:291:0x08e1, B:297:0x08f6, B:299:0x0900, B:302:0x0909, B:304:0x0913), top: B:391:0x08e1 }] */
        /* JADX WARN: Code duplicated, block: B:310:0x0928 A[Catch: Exception -> 0x092c, TRY_LEAVE, TryCatch #3 {Exception -> 0x092c, blocks: (B:308:0x091e, B:310:0x0928, B:316:0x093a, B:318:0x0944, B:321:0x094d, B:323:0x0957), top: B:387:0x091e }] */
        /* JADX WARN: Code duplicated, block: B:314:0x0934 A[Catch: Exception -> 0x09d1, TRY_ENTER, TRY_LEAVE, TryCatch #26 {Exception -> 0x09d1, blocks: (B:306:0x0918, B:314:0x0934, B:319:0x0947), top: B:433:0x0918 }] */
        /* JADX WARN: Code duplicated, block: B:316:0x093a A[Catch: Exception -> 0x092c, TRY_ENTER, TryCatch #3 {Exception -> 0x092c, blocks: (B:308:0x091e, B:310:0x0928, B:316:0x093a, B:318:0x0944, B:321:0x094d, B:323:0x0957), top: B:387:0x091e }] */
        /* JADX WARN: Code duplicated, block: B:321:0x094d A[Catch: Exception -> 0x092c, TRY_ENTER, TryCatch #3 {Exception -> 0x092c, blocks: (B:308:0x091e, B:310:0x0928, B:316:0x093a, B:318:0x0944, B:321:0x094d, B:323:0x0957), top: B:387:0x091e }] */
        /* JADX WARN: Code duplicated, block: B:329:0x096c A[Catch: Exception -> 0x0970, TRY_LEAVE, TryCatch #0 {Exception -> 0x0970, blocks: (B:327:0x0962, B:329:0x096c), top: B:381:0x0962 }] */
        /* JADX WARN: Code duplicated, block: B:336:0x097e A[Catch: Exception -> 0x09cb, TryCatch #19 {Exception -> 0x09cb, blocks: (B:334:0x0978, B:336:0x097e, B:338:0x0988, B:339:0x098b, B:341:0x0993, B:343:0x099f, B:344:0x09a2, B:346:0x09aa, B:348:0x09b6, B:349:0x09b9, B:351:0x09c1), top: B:419:0x0978 }] */
        /* JADX WARN: Code duplicated, block: B:341:0x0993 A[Catch: Exception -> 0x09cb, TryCatch #19 {Exception -> 0x09cb, blocks: (B:334:0x0978, B:336:0x097e, B:338:0x0988, B:339:0x098b, B:341:0x0993, B:343:0x099f, B:344:0x09a2, B:346:0x09aa, B:348:0x09b6, B:349:0x09b9, B:351:0x09c1), top: B:419:0x0978 }] */
        /* JADX WARN: Code duplicated, block: B:346:0x09aa A[Catch: Exception -> 0x09cb, TryCatch #19 {Exception -> 0x09cb, blocks: (B:334:0x0978, B:336:0x097e, B:338:0x0988, B:339:0x098b, B:341:0x0993, B:343:0x099f, B:344:0x09a2, B:346:0x09aa, B:348:0x09b6, B:349:0x09b9, B:351:0x09c1), top: B:419:0x0978 }] */
        /* JADX WARN: Code duplicated, block: B:351:0x09c1 A[Catch: Exception -> 0x09cb, TRY_LEAVE, TryCatch #19 {Exception -> 0x09cb, blocks: (B:334:0x0978, B:336:0x097e, B:338:0x0988, B:339:0x098b, B:341:0x0993, B:343:0x099f, B:344:0x09a2, B:346:0x09aa, B:348:0x09b6, B:349:0x09b9, B:351:0x09c1), top: B:419:0x0978 }] */
        /* JADX WARN: Code duplicated, block: B:381:0x0962 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:383:0x07e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:385:0x07a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:387:0x091e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:391:0x08e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:397:0x08a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:407:0x081c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:413:0x08c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:415:0x07c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:437:0x0800 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public static i a(String str) {
            JSONException jSONException;
            String str2;
            String str3;
            String str4;
            ArrayList arrayList;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            JSONObject jSONObject;
            String str14;
            String str15;
            j jVar;
            String str16;
            Exception exc;
            Exception exc2;
            im imVarK;
            kj kjVarG;
            gp gpVarM;
            f5 f5VarC;
            np npVarN;
            x4 x4VarA;
            nh nhVarE;
            wk wkVarI;
            kj kjVarG2;
            w5 w5VarD;
            JSONObject jSONObjectOptJSONObject;
            String str17;
            int i;
            String str18;
            j jVar2;
            ArrayList arrayList2;
            String str19;
            ArrayList arrayList3;
            Exception exc3;
            uk ukVarH;
            cl clVarJ;
            rn rnVarL;
            nh nhVarE2;
            wk wkVarI2;
            kj kjVarG3;
            im imVarK2;
            w5 w5VarD2;
            String str20;
            String str21 = "secondPrice";
            String str22 = "customData";
            String str23 = "winPriceMax";
            String str24 = "winPriceMin";
            String str25 = "isLastLook";
            String str26 = "endNotification";
            String str27 = "auctionType";
            String str28 = "effectRate";
            String str29 = "raiseSortPrice";
            String str30 = "auctionStrategy";
            String str31 = "blackListInfo";
            String strA = h2.a(rg.a(), str);
            StringBuilder sb = new StringBuilder();
            String str32 = "unconventionalNative";
            sb.append("decryptStr = ");
            sb.append(strA);
            kh.b("ServerResponse", sb.toString());
            JSONObject jSONObject2 = new JSONObject(strA);
            i iVar = new i();
            try {
                iVar.b(jSONObject2.optString("errcode"));
                iVar.c(jSONObject2.optString("errmsg"));
                iVar.a(jSONObject2.optInt("status"));
                String str33 = "totalSecondPrice";
                String str34 = "totalPrice";
                iVar.a(jSONObject2.optLong("ts"));
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("spaceInfo");
                ArrayList arrayList4 = new ArrayList();
                if (a(jSONArrayOptJSONArray)) {
                    int i2 = 0;
                    while (i2 < jSONArrayOptJSONArray.length()) {
                        j jVar3 = new j();
                        i iVar2 = iVar;
                        try {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                            if (jSONObjectOptJSONObject2 != null) {
                                jVar3.a(jSONObjectOptJSONObject2.optString("spaceID"));
                                jVar3.a(i7.a(jSONObjectOptJSONObject2.optInt("adpType")));
                                jVar3.c(jSONObjectOptJSONObject2.optInt("refreshInterval"));
                                jVar3.a(jSONObjectOptJSONObject2.optBoolean("autoClose"));
                                jVar3.a(jSONObjectOptJSONObject2.optInt("maxTime"));
                                jVar3.b(jSONObjectOptJSONObject2.optInt("minTime"));
                                jVar3.c(jSONObjectOptJSONObject2.optBoolean(com.alibaba.ariver.jsapi.multimedia.video.a.f));
                                jVar3.b(jSONObjectOptJSONObject2.optBoolean("autoPlay"));
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("adResponse");
                                ArrayList arrayList5 = new ArrayList();
                                ArrayList arrayList6 = arrayList4;
                                String str35 = "lpOptimize";
                                String str36 = str26;
                                String str37 = str22;
                                String str38 = str23;
                                String str39 = str24;
                                if (a(jSONArrayOptJSONArray2)) {
                                    int i3 = 0;
                                    while (i3 < jSONArrayOptJSONArray2.length()) {
                                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i3);
                                        if (jSONObjectOptJSONObject3 != null) {
                                            d dVar = new d();
                                            dVar.c(jSONObjectOptJSONObject3.optString(com.alipay.sdk.m.w.a.A));
                                            dVar.a(jSONObjectOptJSONObject3.optString("adid"));
                                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray("contentInfo");
                                            ArrayList arrayList7 = new ArrayList();
                                            if (a(jSONArrayOptJSONArray3)) {
                                                int i4 = 0;
                                                while (i4 < jSONArrayOptJSONArray3.length()) {
                                                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray3.optJSONObject(i4);
                                                    if (jSONObjectOptJSONObject4 != null) {
                                                        a aVar = new a();
                                                        aVar.a(jSONObjectOptJSONObject4.optString("template"));
                                                        aVar.a(n7.a(jSONObjectOptJSONObject4.optInt("renderType")));
                                                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.optJSONArray("adcontentSlot");
                                                        if (a(jSONArrayOptJSONArray4)) {
                                                            ArrayList arrayList8 = new ArrayList();
                                                            int i5 = 0;
                                                            while (i5 < jSONArrayOptJSONArray4.length()) {
                                                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(i5);
                                                                if (jSONObjectOptJSONObject5 != null) {
                                                                    f fVar = new f();
                                                                    fVar.b(jSONObjectOptJSONObject5.optString(TKDownloadReason.KSAD_TK_MD5));
                                                                    fVar.a(jSONObjectOptJSONObject5.optString("content"));
                                                                    arrayList8.add(fVar);
                                                                }
                                                                i5++;
                                                                jSONArrayOptJSONArray4 = jSONArrayOptJSONArray4;
                                                                str35 = str35;
                                                            }
                                                            str20 = str35;
                                                            aVar.a(arrayList8);
                                                        } else {
                                                            str20 = str35;
                                                        }
                                                        arrayList7.add(aVar);
                                                    } else {
                                                        i3 = i3;
                                                        str20 = str35;
                                                        arrayList5 = arrayList5;
                                                    }
                                                    i4++;
                                                    jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                                                    jVar3 = jVar3;
                                                    i3 = i3;
                                                    arrayList5 = arrayList5;
                                                    str35 = str20;
                                                }
                                                i = i3;
                                                str19 = str35;
                                                jVar2 = jVar3;
                                                arrayList3 = arrayList5;
                                                dVar.b(arrayList7);
                                            } else {
                                                i = i3;
                                                str19 = str35;
                                                jVar2 = jVar3;
                                                arrayList3 = arrayList5;
                                            }
                                            JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject3.optJSONObject("adLogo");
                                            if (jSONObjectOptJSONObject6 != null) {
                                                c cVar = new c();
                                                cVar.a(jSONObjectOptJSONObject6.optString("adLabel"));
                                                cVar.b(jSONObjectOptJSONObject6.optString("adLabelUrl"));
                                                cVar.c(jSONObjectOptJSONObject6.optString("sourceLabel"));
                                                cVar.d(jSONObjectOptJSONObject6.optString("sourceUrl"));
                                                dVar.a(cVar);
                                            }
                                            dVar.e(jSONObjectOptJSONObject3.optString("price"));
                                            if (jSONObjectOptJSONObject3.has(str21)) {
                                                dVar.g(jSONObjectOptJSONObject3.optString(str21));
                                            }
                                            b bVar = new b();
                                            JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject3.optJSONObject("interactInfo");
                                            if (jSONObjectOptJSONObject7 != null) {
                                                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject7.optJSONArray("thirdpartInfo");
                                                if (a(jSONArrayOptJSONArray5)) {
                                                    ArrayList arrayList9 = new ArrayList();
                                                    for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                                                        JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray5.optJSONObject(i6);
                                                        if (jSONObjectOptJSONObject8 != null) {
                                                            h hVar = new h();
                                                            hVar.a(jSONObjectOptJSONObject8.optString("clickUrl"));
                                                            hVar.j(jSONObjectOptJSONObject8.optString("viewUrl"));
                                                            hVar.b(jSONObjectOptJSONObject8.optString("convertUrl"));
                                                            hVar.c(jSONObjectOptJSONObject8.optString("onFinish"));
                                                            hVar.d(jSONObjectOptJSONObject8.optString("onPause"));
                                                            hVar.e(jSONObjectOptJSONObject8.optString("onRecover"));
                                                            hVar.f(jSONObjectOptJSONObject8.optString("onStart"));
                                                            hVar.g(jSONObjectOptJSONObject8.optString("percent25"));
                                                            hVar.h(jSONObjectOptJSONObject8.optString("percent50"));
                                                            hVar.i(jSONObjectOptJSONObject8.optString("percent75"));
                                                            arrayList9.add(hVar);
                                                        }
                                                    }
                                                    bVar.a(arrayList9);
                                                }
                                                bVar.a(jSONObjectOptJSONObject7.optString("apkName"));
                                                bVar.b(jSONObjectOptJSONObject7.optString("appDesc"));
                                                bVar.j(jSONObjectOptJSONObject7.optString("appVersion"));
                                                bVar.c(jSONObjectOptJSONObject7.optString("appDeveloper"));
                                                bVar.f(jSONObjectOptJSONObject7.optString("appPermissionsDesc"));
                                                bVar.g(jSONObjectOptJSONObject7.optString("appPermissionsUrl"));
                                                bVar.h(jSONObjectOptJSONObject7.optString("appPrivacyUrl"));
                                                bVar.e(jSONObjectOptJSONObject7.optString("appIconURL"));
                                                bVar.k(jSONObjectOptJSONObject7.optString("appintro"));
                                                bVar.d(jSONObjectOptJSONObject7.optString("appDownloadURL"));
                                                bVar.i(jSONObjectOptJSONObject7.optString("appStoreID"));
                                                bVar.m(jSONObjectOptJSONObject7.optString("landingPageUrl"));
                                                bVar.l(jSONObjectOptJSONObject7.optString("deeplinkUrl"));
                                                bVar.a(jSONObjectOptJSONObject7.optInt("interactType"));
                                                bVar.q(jSONObjectOptJSONObject7.optString(ALPParamConstant.PACKAGENAME));
                                                bVar.a(jSONObjectOptJSONObject7.optBoolean("useBuiltInBrow"));
                                                bVar.c(jSONObjectOptJSONObject7.optInt("openExternal"));
                                                JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject7.optJSONObject("followTrackExt");
                                                b.C0333b c0333b = new b.C0333b();
                                                if (jSONObjectOptJSONObject9 != null) {
                                                    c0333b.l(b(jSONObjectOptJSONObject9.optJSONArray("open")));
                                                    c0333b.b(b(jSONObjectOptJSONObject9.optJSONArray("beginDownload")));
                                                    c0333b.g(b(jSONObjectOptJSONObject9.optJSONArray("download")));
                                                    c0333b.c(b(jSONObjectOptJSONObject9.optJSONArray("beginInstall")));
                                                    c0333b.j(b(jSONObjectOptJSONObject9.optJSONArray("install")));
                                                    c0333b.a(b(jSONObjectOptJSONObject9.optJSONArray("active")));
                                                    c0333b.d(b(jSONObjectOptJSONObject9.optJSONArray("close")));
                                                    c0333b.r(b(jSONObjectOptJSONObject9.optJSONArray("showSlide")));
                                                    c0333b.n(b(jSONObjectOptJSONObject9.optJSONArray("pageClose")));
                                                    c0333b.o(b(jSONObjectOptJSONObject9.optJSONArray("pageLoad")));
                                                    c0333b.m(b(jSONObjectOptJSONObject9.optJSONArray("pageAction")));
                                                    c0333b.f(b(jSONObjectOptJSONObject9.optJSONArray("deepLinkSuccess")));
                                                    c0333b.q(b(jSONObjectOptJSONObject9.optJSONArray("realDeepLinkSuccess")));
                                                    c0333b.e(b(jSONObjectOptJSONObject9.optJSONArray("deepLinkFail")));
                                                    c0333b.h(b(jSONObjectOptJSONObject9.optJSONArray("dpAppInstalled")));
                                                    c0333b.i(b(jSONObjectOptJSONObject9.optJSONArray("dpAppNotInstalled")));
                                                    bVar.a(c0333b);
                                                    c0333b.p(b(jSONObjectOptJSONObject9.optJSONArray("realDeepLinkFail")));
                                                    c0333b.k(b(jSONObjectOptJSONObject9.optJSONArray("miniProgramOpen")));
                                                }
                                                JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject7.optJSONObject("videoTrackExt");
                                                b.c cVar2 = new b.c();
                                                if (jSONObjectOptJSONObject10 != null) {
                                                    cVar2.f(b(jSONObjectOptJSONObject10.optJSONArray("start")));
                                                    cVar2.d(b(jSONObjectOptJSONObject10.optJSONArray("pause")));
                                                    cVar2.b(b(jSONObjectOptJSONObject10.optJSONArray("continue")));
                                                    cVar2.c(b(jSONObjectOptJSONObject10.optJSONArray(com.alipay.sdk.m.c0.d.A)));
                                                    cVar2.a(b(jSONObjectOptJSONObject10.optJSONArray("complete")));
                                                    JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject10.optJSONArray("showTrack");
                                                    ArrayList arrayList10 = new ArrayList();
                                                    if (a(jSONArrayOptJSONArray6)) {
                                                        int i7 = 0;
                                                        while (i7 < jSONArrayOptJSONArray6.length()) {
                                                            JSONObject jSONObjectOptJSONObject11 = jSONArrayOptJSONArray6.optJSONObject(i7);
                                                            if (jSONObjectOptJSONObject11 != null) {
                                                                b.c.a aVar2 = new b.c.a();
                                                                aVar2.a(jSONObjectOptJSONObject11.optInt("t"));
                                                                aVar2.a(b(jSONObjectOptJSONObject11.optJSONArray("url")));
                                                                arrayList10.add(aVar2);
                                                            }
                                                            i7++;
                                                            str21 = str21;
                                                        }
                                                        str17 = str21;
                                                        cVar2.e(arrayList10);
                                                    } else {
                                                        str17 = str21;
                                                    }
                                                    bVar.a(cVar2);
                                                } else {
                                                    str17 = str21;
                                                }
                                                try {
                                                    if (jSONObjectOptJSONObject7.has(LoginConstants.EXT)) {
                                                        JSONObject jSONObject3 = jSONObjectOptJSONObject7.getJSONObject(LoginConstants.EXT);
                                                        b.a aVar3 = new b.a();
                                                        if (jSONObject3 != null) {
                                                            if (jSONObject3.has("canJumpStore")) {
                                                                aVar3.a(jSONObject3.optInt("canJumpStore"));
                                                            }
                                                            if (jSONObject3.has("isCloseConfirm")) {
                                                                aVar3.b(jSONObject3.optInt("isCloseConfirm"));
                                                            }
                                                            if (jSONObject3.has("webDeepLink")) {
                                                                aVar3.c(jSONObject3.optInt("webDeepLink"));
                                                            }
                                                            bVar.a(aVar3);
                                                        }
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                bVar.o(jSONObjectOptJSONObject7.optString("miniProgramId"));
                                                bVar.p(jSONObjectOptJSONObject7.optString("miniProgramPath"));
                                                bVar.n(jSONObjectOptJSONObject7.optString("miniProgramExt"));
                                                bVar.r(jSONObjectOptJSONObject7.optString("wechat_canvas"));
                                                bVar.b(jSONObjectOptJSONObject7.optInt("isMiniProgram"));
                                                dVar.a(bVar);
                                            } else {
                                                str17 = str21;
                                            }
                                            try {
                                                if (jSONObjectOptJSONObject3.has("sensor")) {
                                                    try {
                                                        JSONObject jSONObjectOptJSONObject12 = jSONObjectOptJSONObject3.optJSONObject("sensor");
                                                        if (jSONObjectOptJSONObject12 != null) {
                                                            e eVar = new e();
                                                            if (jSONObjectOptJSONObject12.has("forceUnreal")) {
                                                                eVar.a(jSONObjectOptJSONObject12.optBoolean("forceUnreal"));
                                                            }
                                                            if (jSONObjectOptJSONObject12.has("maxAcc")) {
                                                                eVar.b(jSONObjectOptJSONObject12.optDouble("maxAcc"));
                                                            }
                                                            if (jSONObjectOptJSONObject12.has("angle")) {
                                                                eVar.a(jSONObjectOptJSONObject12.optDouble("angle"));
                                                            }
                                                            dVar.a(eVar);
                                                        }
                                                    } catch (Exception e2) {
                                                        exc3 = e2;
                                                        str18 = str19;
                                                        exc3.printStackTrace();
                                                    }
                                                }
                                                if (jSONObjectOptJSONObject3.has("complianceSensor") && (w5VarD2 = x1.d(jSONObjectOptJSONObject3.optJSONObject("complianceSensor"))) != null) {
                                                    dVar.a(w5VarD2);
                                                }
                                                if (jSONObjectOptJSONObject3.has("rewardedVideo") && (imVarK2 = x1.k(jSONObjectOptJSONObject3.optJSONObject("rewardedVideo"))) != null) {
                                                    dVar.a(imVarK2);
                                                }
                                                if (jSONObjectOptJSONObject3.has("notification") && (kjVarG3 = x1.g(jSONObjectOptJSONObject3.optJSONObject("notification"))) != null) {
                                                    dVar.a(kjVarG3);
                                                }
                                                if (jSONObjectOptJSONObject3.has("optimize") && (wkVarI2 = x1.i(jSONObjectOptJSONObject3.optJSONObject("optimize"))) != null) {
                                                    dVar.a(wkVarI2);
                                                }
                                                str18 = str19;
                                                try {
                                                    if (jSONObjectOptJSONObject3.has(str18) && (nhVarE2 = x1.e(jSONObjectOptJSONObject3.optJSONObject(str18))) != null) {
                                                        dVar.a(nhVarE2);
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("showType")) {
                                                        dVar.b(jSONObjectOptJSONObject3.optInt("showType"));
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("shake") && (rnVarL = x1.l(jSONObjectOptJSONObject3.optJSONObject("shake"))) != null) {
                                                        dVar.a(rnVarL);
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("closePosition") && (clVarJ = x1.j(jSONObjectOptJSONObject3.optJSONObject("closePosition"))) != null) {
                                                        dVar.a(clVarJ);
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("chartlet")) {
                                                        JSONArray jSONArrayOptJSONArray7 = jSONObjectOptJSONObject3.optJSONArray("chartlet");
                                                        if (a(jSONArrayOptJSONArray7)) {
                                                            ArrayList arrayList11 = new ArrayList();
                                                            for (int i8 = 0; i8 < jSONArrayOptJSONArray7.length(); i8++) {
                                                                c5 c5VarB = x1.b(jSONArrayOptJSONArray7.optJSONObject(i8));
                                                                if (c5VarB != null) {
                                                                    arrayList11.add(c5VarB);
                                                                }
                                                            }
                                                            if (arrayList11.size() > 0) {
                                                                dVar.a(arrayList11);
                                                            }
                                                        }
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("oppoInfo") && (ukVarH = x1.h(jSONObjectOptJSONObject3.optJSONObject("oppoInfo"))) != null) {
                                                        dVar.a(ukVarH);
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    exc3 = e;
                                                    exc3.printStackTrace();
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                str18 = str19;
                                            }
                                            if (jSONObjectOptJSONObject3.has("expireSec")) {
                                                dVar.a(jSONObjectOptJSONObject3.optInt("expireSec"));
                                            }
                                            dVar.f(jSONObjectOptJSONObject3.optString("requestUUID"));
                                            dVar.d(jSONObjectOptJSONObject3.optString("orderId"));
                                            dVar.b(jSONObjectOptJSONObject3.optString("adxCrid"));
                                            arrayList2 = arrayList3;
                                            arrayList2.add(dVar);
                                        } else {
                                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject2;
                                            str17 = str21;
                                            i = i3;
                                            str18 = str35;
                                            jVar2 = jVar3;
                                            str30 = str30;
                                            arrayList2 = arrayList5;
                                        }
                                        i3 = i + 1;
                                        str35 = str18;
                                        arrayList5 = arrayList2;
                                        jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                                        str28 = str28;
                                        str29 = str29;
                                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject2;
                                        str30 = str30;
                                        str21 = str17;
                                        jVar3 = jVar2;
                                    }
                                    jSONObject = jSONObjectOptJSONObject2;
                                    str2 = str21;
                                    str14 = str28;
                                    str4 = str29;
                                    str15 = str35;
                                    jVar = jVar3;
                                    str16 = str30;
                                    jVar.a(arrayList5);
                                } else {
                                    jSONObject = jSONObjectOptJSONObject2;
                                    str2 = str21;
                                    str14 = str28;
                                    str4 = str29;
                                    str15 = "lpOptimize";
                                    jVar = jVar3;
                                    str16 = str30;
                                }
                                JSONObject jSONObject4 = jSONObject;
                                str5 = str16;
                                try {
                                    if (!jSONObject4.has(str5) || (jSONObjectOptJSONObject = jSONObject4.optJSONObject(str5)) == null) {
                                        str5 = str5;
                                        str9 = str25;
                                        str7 = str37;
                                        str13 = str38;
                                        str8 = str39;
                                        str3 = str27;
                                        str11 = str14;
                                    } else {
                                        g gVar = new g();
                                        str4 = str4;
                                        try {
                                            if (jSONObjectOptJSONObject.has(str4)) {
                                                try {
                                                    gVar.d(jSONObjectOptJSONObject.optInt(str4));
                                                    str11 = str14;
                                                    try {
                                                        if (jSONObjectOptJSONObject.has(str11)) {
                                                            try {
                                                                gVar.b(jSONObjectOptJSONObject.optInt(str11));
                                                                str3 = str27;
                                                                try {
                                                                    if (jSONObjectOptJSONObject.has(str3)) {
                                                                        try {
                                                                            gVar.a(jSONObjectOptJSONObject.optInt(str3));
                                                                            str9 = str25;
                                                                            try {
                                                                                if (jSONObjectOptJSONObject.has(str9)) {
                                                                                    try {
                                                                                        gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                                                    } catch (Exception e5) {
                                                                                        exc = e5;
                                                                                        str7 = str37;
                                                                                        str13 = str38;
                                                                                        str8 = str39;
                                                                                        exc.printStackTrace();
                                                                                        if (jSONObject4.has("rewardedVideo")) {
                                                                                            try {
                                                                                                imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                                                                if (imVarK != null) {
                                                                                                    jVar.a(imVarK);
                                                                                                }
                                                                                                str12 = str34;
                                                                                                try {
                                                                                                    if (jSONObject4.has(str12)) {
                                                                                                        try {
                                                                                                            jVar.e(jSONObject4.optInt(str12));
                                                                                                            str6 = str33;
                                                                                                            try {
                                                                                                                if (jSONObject4.has(str6)) {
                                                                                                                    try {
                                                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                                                    } catch (Exception e6) {
                                                                                                                        exc2 = e6;
                                                                                                                        str10 = str36;
                                                                                                                        exc2.printStackTrace();
                                                                                                                        arrayList = arrayList6;
                                                                                                                        arrayList.add(jVar);
                                                                                                                        str32 = str32;
                                                                                                                        str26 = str10;
                                                                                                                        str31 = str31;
                                                                                                                        str34 = str12;
                                                                                                                        str23 = str13;
                                                                                                                        str33 = str6;
                                                                                                                        str22 = str7;
                                                                                                                        str28 = str11;
                                                                                                                        str27 = str3;
                                                                                                                        str25 = str9;
                                                                                                                        str24 = str8;
                                                                                                                        iVar = iVar2;
                                                                                                                        str29 = str4;
                                                                                                                        str30 = str5;
                                                                                                                        arrayList4 = arrayList;
                                                                                                                        i2++;
                                                                                                                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                                                        str21 = str2;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (jSONObject4.has("complianceSensor")) {
                                                                                                                    jVar.a(w5VarD);
                                                                                                                }
                                                                                                                if (jSONObject4.has("notification")) {
                                                                                                                    jVar.b(kjVarG2);
                                                                                                                }
                                                                                                                str10 = str36;
                                                                                                                try {
                                                                                                                    if (jSONObject4.has(str10)) {
                                                                                                                        try {
                                                                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                                            if (kjVarG != null) {
                                                                                                                                jVar.a(kjVarG);
                                                                                                                            }
                                                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                                                jVar.a(wkVarI);
                                                                                                                            }
                                                                                                                            if (jSONObject4.has(str15)) {
                                                                                                                                jVar.a(nhVarE);
                                                                                                                            }
                                                                                                                            str32 = str32;
                                                                                                                            try {
                                                                                                                                if (jSONObject4.has(str32)) {
                                                                                                                                    try {
                                                                                                                                        gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                                                        if (gpVarM != null) {
                                                                                                                                            jVar.a(gpVarM);
                                                                                                                                        }
                                                                                                                                    } catch (Exception e7) {
                                                                                                                                        exc2 = e7;
                                                                                                                                        str31 = str31;
                                                                                                                                        exc2.printStackTrace();
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                str31 = str31;
                                                                                                                                try {
                                                                                                                                    if (jSONObject4.has(str31)) {
                                                                                                                                        jVar.a(x4VarA);
                                                                                                                                    }
                                                                                                                                    if (jSONObject4.has("nativeOptimize")) {
                                                                                                                                        jVar.a(npVarN);
                                                                                                                                    }
                                                                                                                                    if (jSONObject4.has("clickOptimize")) {
                                                                                                                                        jVar.a(f5VarC);
                                                                                                                                    }
                                                                                                                                    if (jSONObject4.has("switchFiveVersion")) {
                                                                                                                                        jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                                                    }
                                                                                                                                } catch (Exception e8) {
                                                                                                                                    e = e8;
                                                                                                                                    exc2 = e;
                                                                                                                                    exc2.printStackTrace();
                                                                                                                                }
                                                                                                                            } catch (Exception e9) {
                                                                                                                                e = e9;
                                                                                                                                str31 = str31;
                                                                                                                            }
                                                                                                                        } catch (Exception e10) {
                                                                                                                            exc2 = e10;
                                                                                                                            str31 = str31;
                                                                                                                            str32 = str32;
                                                                                                                            exc2.printStackTrace();
                                                                                                                            arrayList = arrayList6;
                                                                                                                            arrayList.add(jVar);
                                                                                                                            str32 = str32;
                                                                                                                            str26 = str10;
                                                                                                                            str31 = str31;
                                                                                                                            str34 = str12;
                                                                                                                            str23 = str13;
                                                                                                                            str33 = str6;
                                                                                                                            str22 = str7;
                                                                                                                            str28 = str11;
                                                                                                                            str27 = str3;
                                                                                                                            str25 = str9;
                                                                                                                            str24 = str8;
                                                                                                                            iVar = iVar2;
                                                                                                                            str29 = str4;
                                                                                                                            str30 = str5;
                                                                                                                            arrayList4 = arrayList;
                                                                                                                            i2++;
                                                                                                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                                                            str21 = str2;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                                            jVar.a(wkVarI);
                                                                                                                        }
                                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                                            jVar.a(nhVarE);
                                                                                                                        }
                                                                                                                        str32 = str32;
                                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                                            if (gpVarM != null) {
                                                                                                                                jVar.a(gpVarM);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        str31 = str31;
                                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                                            jVar.a(x4VarA);
                                                                                                                        }
                                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                                            jVar.a(npVarN);
                                                                                                                        }
                                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                                            jVar.a(f5VarC);
                                                                                                                        }
                                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                                        }
                                                                                                                    }
                                                                                                                } catch (Exception e11) {
                                                                                                                    e = e11;
                                                                                                                    str31 = str31;
                                                                                                                    str32 = str32;
                                                                                                                }
                                                                                                            } catch (Exception e12) {
                                                                                                                e = e12;
                                                                                                                str10 = str36;
                                                                                                                exc2 = e;
                                                                                                                exc2.printStackTrace();
                                                                                                                arrayList = arrayList6;
                                                                                                                arrayList.add(jVar);
                                                                                                                str32 = str32;
                                                                                                                str26 = str10;
                                                                                                                str31 = str31;
                                                                                                                str34 = str12;
                                                                                                                str23 = str13;
                                                                                                                str33 = str6;
                                                                                                                str22 = str7;
                                                                                                                str28 = str11;
                                                                                                                str27 = str3;
                                                                                                                str25 = str9;
                                                                                                                str24 = str8;
                                                                                                                iVar = iVar2;
                                                                                                                str29 = str4;
                                                                                                                str30 = str5;
                                                                                                                arrayList4 = arrayList;
                                                                                                                i2++;
                                                                                                                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                                                str21 = str2;
                                                                                                            }
                                                                                                        } catch (Exception e13) {
                                                                                                            exc2 = e13;
                                                                                                            str6 = str33;
                                                                                                            str10 = str36;
                                                                                                            exc2.printStackTrace();
                                                                                                            arrayList = arrayList6;
                                                                                                            arrayList.add(jVar);
                                                                                                            str32 = str32;
                                                                                                            str26 = str10;
                                                                                                            str31 = str31;
                                                                                                            str34 = str12;
                                                                                                            str23 = str13;
                                                                                                            str33 = str6;
                                                                                                            str22 = str7;
                                                                                                            str28 = str11;
                                                                                                            str27 = str3;
                                                                                                            str25 = str9;
                                                                                                            str24 = str8;
                                                                                                            iVar = iVar2;
                                                                                                            str29 = str4;
                                                                                                            str30 = str5;
                                                                                                            arrayList4 = arrayList;
                                                                                                            i2++;
                                                                                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                                            str21 = str2;
                                                                                                        }
                                                                                                    } else {
                                                                                                        str6 = str33;
                                                                                                        if (jSONObject4.has(str6)) {
                                                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                                                        }
                                                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                                                            jVar.a(w5VarD);
                                                                                                        }
                                                                                                        if (jSONObject4.has("notification")) {
                                                                                                            jVar.b(kjVarG2);
                                                                                                        }
                                                                                                        str10 = str36;
                                                                                                        if (jSONObject4.has(str10)) {
                                                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                            if (kjVarG != null) {
                                                                                                                jVar.a(kjVarG);
                                                                                                            }
                                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                                jVar.a(wkVarI);
                                                                                                            }
                                                                                                            if (jSONObject4.has(str15)) {
                                                                                                                jVar.a(nhVarE);
                                                                                                            }
                                                                                                            str32 = str32;
                                                                                                            if (jSONObject4.has(str32)) {
                                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                                if (gpVarM != null) {
                                                                                                                    jVar.a(gpVarM);
                                                                                                                }
                                                                                                            }
                                                                                                            str31 = str31;
                                                                                                            if (jSONObject4.has(str31)) {
                                                                                                                jVar.a(x4VarA);
                                                                                                            }
                                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                                jVar.a(npVarN);
                                                                                                            }
                                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                                jVar.a(f5VarC);
                                                                                                            }
                                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                                jVar.a(wkVarI);
                                                                                                            }
                                                                                                            if (jSONObject4.has(str15)) {
                                                                                                                jVar.a(nhVarE);
                                                                                                            }
                                                                                                            str32 = str32;
                                                                                                            if (jSONObject4.has(str32)) {
                                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                                if (gpVarM != null) {
                                                                                                                    jVar.a(gpVarM);
                                                                                                                }
                                                                                                            }
                                                                                                            str31 = str31;
                                                                                                            if (jSONObject4.has(str31)) {
                                                                                                                jVar.a(x4VarA);
                                                                                                            }
                                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                                jVar.a(npVarN);
                                                                                                            }
                                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                                jVar.a(f5VarC);
                                                                                                            }
                                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                } catch (Exception e14) {
                                                                                                    e = e14;
                                                                                                    str6 = str33;
                                                                                                }
                                                                                            } catch (Exception e15) {
                                                                                                exc2 = e15;
                                                                                                str6 = str33;
                                                                                                str12 = str34;
                                                                                                str10 = str36;
                                                                                                exc2.printStackTrace();
                                                                                                arrayList = arrayList6;
                                                                                                arrayList.add(jVar);
                                                                                                str32 = str32;
                                                                                                str26 = str10;
                                                                                                str31 = str31;
                                                                                                str34 = str12;
                                                                                                str23 = str13;
                                                                                                str33 = str6;
                                                                                                str22 = str7;
                                                                                                str28 = str11;
                                                                                                str27 = str3;
                                                                                                str25 = str9;
                                                                                                str24 = str8;
                                                                                                iVar = iVar2;
                                                                                                str29 = str4;
                                                                                                str30 = str5;
                                                                                                arrayList4 = arrayList;
                                                                                                i2++;
                                                                                                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                                str21 = str2;
                                                                                            }
                                                                                        } else {
                                                                                            str12 = str34;
                                                                                            if (jSONObject4.has(str12)) {
                                                                                                jVar.e(jSONObject4.optInt(str12));
                                                                                                str6 = str33;
                                                                                                if (jSONObject4.has(str6)) {
                                                                                                    jVar.f(jSONObject4.optInt(str6));
                                                                                                }
                                                                                                if (jSONObject4.has("complianceSensor")) {
                                                                                                    jVar.a(w5VarD);
                                                                                                }
                                                                                                if (jSONObject4.has("notification")) {
                                                                                                    jVar.b(kjVarG2);
                                                                                                }
                                                                                                str10 = str36;
                                                                                                if (jSONObject4.has(str10)) {
                                                                                                    kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                    if (kjVarG != null) {
                                                                                                        jVar.a(kjVarG);
                                                                                                    }
                                                                                                    if (jSONObject4.has("optimize")) {
                                                                                                        jVar.a(wkVarI);
                                                                                                    }
                                                                                                    if (jSONObject4.has(str15)) {
                                                                                                        jVar.a(nhVarE);
                                                                                                    }
                                                                                                    str32 = str32;
                                                                                                    if (jSONObject4.has(str32)) {
                                                                                                        gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                        if (gpVarM != null) {
                                                                                                            jVar.a(gpVarM);
                                                                                                        }
                                                                                                    }
                                                                                                    str31 = str31;
                                                                                                    if (jSONObject4.has(str31)) {
                                                                                                        jVar.a(x4VarA);
                                                                                                    }
                                                                                                    if (jSONObject4.has("nativeOptimize")) {
                                                                                                        jVar.a(npVarN);
                                                                                                    }
                                                                                                    if (jSONObject4.has("clickOptimize")) {
                                                                                                        jVar.a(f5VarC);
                                                                                                    }
                                                                                                    if (jSONObject4.has("switchFiveVersion")) {
                                                                                                        jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                    }
                                                                                                } else {
                                                                                                    if (jSONObject4.has("optimize")) {
                                                                                                        jVar.a(wkVarI);
                                                                                                    }
                                                                                                    if (jSONObject4.has(str15)) {
                                                                                                        jVar.a(nhVarE);
                                                                                                    }
                                                                                                    str32 = str32;
                                                                                                    if (jSONObject4.has(str32)) {
                                                                                                        gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                        if (gpVarM != null) {
                                                                                                            jVar.a(gpVarM);
                                                                                                        }
                                                                                                    }
                                                                                                    str31 = str31;
                                                                                                    if (jSONObject4.has(str31)) {
                                                                                                        jVar.a(x4VarA);
                                                                                                    }
                                                                                                    if (jSONObject4.has("nativeOptimize")) {
                                                                                                        jVar.a(npVarN);
                                                                                                    }
                                                                                                    if (jSONObject4.has("clickOptimize")) {
                                                                                                        jVar.a(f5VarC);
                                                                                                    }
                                                                                                    if (jSONObject4.has("switchFiveVersion")) {
                                                                                                        jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                str6 = str33;
                                                                                                if (jSONObject4.has(str6)) {
                                                                                                    jVar.f(jSONObject4.optInt(str6));
                                                                                                }
                                                                                                if (jSONObject4.has("complianceSensor")) {
                                                                                                    jVar.a(w5VarD);
                                                                                                }
                                                                                                if (jSONObject4.has("notification")) {
                                                                                                    jVar.b(kjVarG2);
                                                                                                }
                                                                                                str10 = str36;
                                                                                                if (jSONObject4.has(str10)) {
                                                                                                    kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                    if (kjVarG != null) {
                                                                                                        jVar.a(kjVarG);
                                                                                                    }
                                                                                                    if (jSONObject4.has("optimize")) {
                                                                                                        jVar.a(wkVarI);
                                                                                                    }
                                                                                                    if (jSONObject4.has(str15)) {
                                                                                                        jVar.a(nhVarE);
                                                                                                    }
                                                                                                    str32 = str32;
                                                                                                    if (jSONObject4.has(str32)) {
                                                                                                        gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                        if (gpVarM != null) {
                                                                                                            jVar.a(gpVarM);
                                                                                                        }
                                                                                                    }
                                                                                                    str31 = str31;
                                                                                                    if (jSONObject4.has(str31)) {
                                                                                                        jVar.a(x4VarA);
                                                                                                    }
                                                                                                    if (jSONObject4.has("nativeOptimize")) {
                                                                                                        jVar.a(npVarN);
                                                                                                    }
                                                                                                    if (jSONObject4.has("clickOptimize")) {
                                                                                                        jVar.a(f5VarC);
                                                                                                    }
                                                                                                    if (jSONObject4.has("switchFiveVersion")) {
                                                                                                        jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                    }
                                                                                                } else {
                                                                                                    if (jSONObject4.has("optimize")) {
                                                                                                        jVar.a(wkVarI);
                                                                                                    }
                                                                                                    if (jSONObject4.has(str15)) {
                                                                                                        jVar.a(nhVarE);
                                                                                                    }
                                                                                                    str32 = str32;
                                                                                                    if (jSONObject4.has(str32)) {
                                                                                                        gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                        if (gpVarM != null) {
                                                                                                            jVar.a(gpVarM);
                                                                                                        }
                                                                                                    }
                                                                                                    str31 = str31;
                                                                                                    if (jSONObject4.has(str31)) {
                                                                                                        jVar.a(x4VarA);
                                                                                                    }
                                                                                                    if (jSONObject4.has("nativeOptimize")) {
                                                                                                        jVar.a(npVarN);
                                                                                                    }
                                                                                                    if (jSONObject4.has("clickOptimize")) {
                                                                                                        jVar.a(f5VarC);
                                                                                                    }
                                                                                                    if (jSONObject4.has("switchFiveVersion")) {
                                                                                                        jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        arrayList = arrayList6;
                                                                                        arrayList.add(jVar);
                                                                                        str32 = str32;
                                                                                        str26 = str10;
                                                                                        str31 = str31;
                                                                                        str34 = str12;
                                                                                        str23 = str13;
                                                                                        str33 = str6;
                                                                                        str22 = str7;
                                                                                        str28 = str11;
                                                                                        str27 = str3;
                                                                                        str25 = str9;
                                                                                        str24 = str8;
                                                                                        iVar = iVar2;
                                                                                        str29 = str4;
                                                                                        str30 = str5;
                                                                                        arrayList4 = arrayList;
                                                                                        i2++;
                                                                                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                        str21 = str2;
                                                                                    }
                                                                                }
                                                                                str8 = str39;
                                                                                try {
                                                                                    str5 = str5;
                                                                                    if (jSONObjectOptJSONObject.has(str8)) {
                                                                                        try {
                                                                                            gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                                                            str13 = str38;
                                                                                            try {
                                                                                                str4 = str4;
                                                                                                if (jSONObjectOptJSONObject.has(str13)) {
                                                                                                    try {
                                                                                                        gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                                                    } catch (Exception e16) {
                                                                                                        exc = e16;
                                                                                                        str7 = str37;
                                                                                                        exc.printStackTrace();
                                                                                                    }
                                                                                                }
                                                                                                str7 = str37;
                                                                                                try {
                                                                                                    if (jSONObjectOptJSONObject.has(str7)) {
                                                                                                        gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                                                    }
                                                                                                    jVar.a(gVar);
                                                                                                } catch (Exception e17) {
                                                                                                    e = e17;
                                                                                                    exc = e;
                                                                                                    exc.printStackTrace();
                                                                                                }
                                                                                            } catch (Exception e18) {
                                                                                                e = e18;
                                                                                                str4 = str4;
                                                                                                str7 = str37;
                                                                                            }
                                                                                        } catch (Exception e19) {
                                                                                            exc = e19;
                                                                                            str4 = str4;
                                                                                            str7 = str37;
                                                                                            str13 = str38;
                                                                                            exc.printStackTrace();
                                                                                            if (jSONObject4.has("rewardedVideo")) {
                                                                                                imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                                                                if (imVarK != null) {
                                                                                                    jVar.a(imVarK);
                                                                                                }
                                                                                                str12 = str34;
                                                                                                if (jSONObject4.has(str12)) {
                                                                                                    jVar.e(jSONObject4.optInt(str12));
                                                                                                    str6 = str33;
                                                                                                    if (jSONObject4.has(str6)) {
                                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                                    }
                                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                                        jVar.a(w5VarD);
                                                                                                    }
                                                                                                    if (jSONObject4.has("notification")) {
                                                                                                        jVar.b(kjVarG2);
                                                                                                    }
                                                                                                    str10 = str36;
                                                                                                    if (jSONObject4.has(str10)) {
                                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                        if (kjVarG != null) {
                                                                                                            jVar.a(kjVarG);
                                                                                                        }
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    str6 = str33;
                                                                                                    if (jSONObject4.has(str6)) {
                                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                                    }
                                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                                        jVar.a(w5VarD);
                                                                                                    }
                                                                                                    if (jSONObject4.has("notification")) {
                                                                                                        jVar.b(kjVarG2);
                                                                                                    }
                                                                                                    str10 = str36;
                                                                                                    if (jSONObject4.has(str10)) {
                                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                        if (kjVarG != null) {
                                                                                                            jVar.a(kjVarG);
                                                                                                        }
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                str12 = str34;
                                                                                                if (jSONObject4.has(str12)) {
                                                                                                    jVar.e(jSONObject4.optInt(str12));
                                                                                                    str6 = str33;
                                                                                                    if (jSONObject4.has(str6)) {
                                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                                    }
                                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                                        jVar.a(w5VarD);
                                                                                                    }
                                                                                                    if (jSONObject4.has("notification")) {
                                                                                                        jVar.b(kjVarG2);
                                                                                                    }
                                                                                                    str10 = str36;
                                                                                                    if (jSONObject4.has(str10)) {
                                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                        if (kjVarG != null) {
                                                                                                            jVar.a(kjVarG);
                                                                                                        }
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    str6 = str33;
                                                                                                    if (jSONObject4.has(str6)) {
                                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                                    }
                                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                                        jVar.a(w5VarD);
                                                                                                    }
                                                                                                    if (jSONObject4.has("notification")) {
                                                                                                        jVar.b(kjVarG2);
                                                                                                    }
                                                                                                    str10 = str36;
                                                                                                    if (jSONObject4.has(str10)) {
                                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                                        if (kjVarG != null) {
                                                                                                            jVar.a(kjVarG);
                                                                                                        }
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (jSONObject4.has("optimize")) {
                                                                                                            jVar.a(wkVarI);
                                                                                                        }
                                                                                                        if (jSONObject4.has(str15)) {
                                                                                                            jVar.a(nhVarE);
                                                                                                        }
                                                                                                        str32 = str32;
                                                                                                        if (jSONObject4.has(str32)) {
                                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                            if (gpVarM != null) {
                                                                                                                jVar.a(gpVarM);
                                                                                                            }
                                                                                                        }
                                                                                                        str31 = str31;
                                                                                                        if (jSONObject4.has(str31)) {
                                                                                                            jVar.a(x4VarA);
                                                                                                        }
                                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                                            jVar.a(npVarN);
                                                                                                        }
                                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                                            jVar.a(f5VarC);
                                                                                                        }
                                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            arrayList = arrayList6;
                                                                                            arrayList.add(jVar);
                                                                                            str32 = str32;
                                                                                            str26 = str10;
                                                                                            str31 = str31;
                                                                                            str34 = str12;
                                                                                            str23 = str13;
                                                                                            str33 = str6;
                                                                                            str22 = str7;
                                                                                            str28 = str11;
                                                                                            str27 = str3;
                                                                                            str25 = str9;
                                                                                            str24 = str8;
                                                                                            iVar = iVar2;
                                                                                            str29 = str4;
                                                                                            str30 = str5;
                                                                                            arrayList4 = arrayList;
                                                                                            i2++;
                                                                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                            str21 = str2;
                                                                                        }
                                                                                    } else {
                                                                                        str13 = str38;
                                                                                        str4 = str4;
                                                                                        if (jSONObjectOptJSONObject.has(str13)) {
                                                                                            gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                                        }
                                                                                        str7 = str37;
                                                                                        if (jSONObjectOptJSONObject.has(str7)) {
                                                                                            gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                                        }
                                                                                        jVar.a(gVar);
                                                                                    }
                                                                                } catch (Exception e20) {
                                                                                    e = e20;
                                                                                    str5 = str5;
                                                                                    str4 = str4;
                                                                                    str7 = str37;
                                                                                    str13 = str38;
                                                                                }
                                                                            } catch (Exception e21) {
                                                                                e = e21;
                                                                                str7 = str37;
                                                                                str13 = str38;
                                                                                str8 = str39;
                                                                                exc = e;
                                                                                exc.printStackTrace();
                                                                                if (jSONObject4.has("rewardedVideo")) {
                                                                                    imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                                                    if (imVarK != null) {
                                                                                        jVar.a(imVarK);
                                                                                    }
                                                                                    str12 = str34;
                                                                                    if (jSONObject4.has(str12)) {
                                                                                        jVar.e(jSONObject4.optInt(str12));
                                                                                        str6 = str33;
                                                                                        if (jSONObject4.has(str6)) {
                                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                                        }
                                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                                            jVar.a(w5VarD);
                                                                                        }
                                                                                        if (jSONObject4.has("notification")) {
                                                                                            jVar.b(kjVarG2);
                                                                                        }
                                                                                        str10 = str36;
                                                                                        if (jSONObject4.has(str10)) {
                                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                            if (kjVarG != null) {
                                                                                                jVar.a(kjVarG);
                                                                                            }
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        } else {
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        str6 = str33;
                                                                                        if (jSONObject4.has(str6)) {
                                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                                        }
                                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                                            jVar.a(w5VarD);
                                                                                        }
                                                                                        if (jSONObject4.has("notification")) {
                                                                                            jVar.b(kjVarG2);
                                                                                        }
                                                                                        str10 = str36;
                                                                                        if (jSONObject4.has(str10)) {
                                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                            if (kjVarG != null) {
                                                                                                jVar.a(kjVarG);
                                                                                            }
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        } else {
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    str12 = str34;
                                                                                    if (jSONObject4.has(str12)) {
                                                                                        jVar.e(jSONObject4.optInt(str12));
                                                                                        str6 = str33;
                                                                                        if (jSONObject4.has(str6)) {
                                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                                        }
                                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                                            jVar.a(w5VarD);
                                                                                        }
                                                                                        if (jSONObject4.has("notification")) {
                                                                                            jVar.b(kjVarG2);
                                                                                        }
                                                                                        str10 = str36;
                                                                                        if (jSONObject4.has(str10)) {
                                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                            if (kjVarG != null) {
                                                                                                jVar.a(kjVarG);
                                                                                            }
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        } else {
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        str6 = str33;
                                                                                        if (jSONObject4.has(str6)) {
                                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                                        }
                                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                                            jVar.a(w5VarD);
                                                                                        }
                                                                                        if (jSONObject4.has("notification")) {
                                                                                            jVar.b(kjVarG2);
                                                                                        }
                                                                                        str10 = str36;
                                                                                        if (jSONObject4.has(str10)) {
                                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                            if (kjVarG != null) {
                                                                                                jVar.a(kjVarG);
                                                                                            }
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        } else {
                                                                                            if (jSONObject4.has("optimize")) {
                                                                                                jVar.a(wkVarI);
                                                                                            }
                                                                                            if (jSONObject4.has(str15)) {
                                                                                                jVar.a(nhVarE);
                                                                                            }
                                                                                            str32 = str32;
                                                                                            if (jSONObject4.has(str32)) {
                                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                                if (gpVarM != null) {
                                                                                                    jVar.a(gpVarM);
                                                                                                }
                                                                                            }
                                                                                            str31 = str31;
                                                                                            if (jSONObject4.has(str31)) {
                                                                                                jVar.a(x4VarA);
                                                                                            }
                                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                                jVar.a(npVarN);
                                                                                            }
                                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                                jVar.a(f5VarC);
                                                                                            }
                                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                arrayList = arrayList6;
                                                                                arrayList.add(jVar);
                                                                                str32 = str32;
                                                                                str26 = str10;
                                                                                str31 = str31;
                                                                                str34 = str12;
                                                                                str23 = str13;
                                                                                str33 = str6;
                                                                                str22 = str7;
                                                                                str28 = str11;
                                                                                str27 = str3;
                                                                                str25 = str9;
                                                                                str24 = str8;
                                                                                iVar = iVar2;
                                                                                str29 = str4;
                                                                                str30 = str5;
                                                                                arrayList4 = arrayList;
                                                                                i2++;
                                                                                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                                str21 = str2;
                                                                            }
                                                                        } catch (Exception e22) {
                                                                            exc = e22;
                                                                            str9 = str25;
                                                                            str7 = str37;
                                                                            str13 = str38;
                                                                            str8 = str39;
                                                                            exc.printStackTrace();
                                                                            if (jSONObject4.has("rewardedVideo")) {
                                                                                imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                                                if (imVarK != null) {
                                                                                    jVar.a(imVarK);
                                                                                }
                                                                                str12 = str34;
                                                                                if (jSONObject4.has(str12)) {
                                                                                    jVar.e(jSONObject4.optInt(str12));
                                                                                    str6 = str33;
                                                                                    if (jSONObject4.has(str6)) {
                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                    }
                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                        jVar.a(w5VarD);
                                                                                    }
                                                                                    if (jSONObject4.has("notification")) {
                                                                                        jVar.b(kjVarG2);
                                                                                    }
                                                                                    str10 = str36;
                                                                                    if (jSONObject4.has(str10)) {
                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                        if (kjVarG != null) {
                                                                                            jVar.a(kjVarG);
                                                                                        }
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    } else {
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    str6 = str33;
                                                                                    if (jSONObject4.has(str6)) {
                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                    }
                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                        jVar.a(w5VarD);
                                                                                    }
                                                                                    if (jSONObject4.has("notification")) {
                                                                                        jVar.b(kjVarG2);
                                                                                    }
                                                                                    str10 = str36;
                                                                                    if (jSONObject4.has(str10)) {
                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                        if (kjVarG != null) {
                                                                                            jVar.a(kjVarG);
                                                                                        }
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    } else {
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                str12 = str34;
                                                                                if (jSONObject4.has(str12)) {
                                                                                    jVar.e(jSONObject4.optInt(str12));
                                                                                    str6 = str33;
                                                                                    if (jSONObject4.has(str6)) {
                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                    }
                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                        jVar.a(w5VarD);
                                                                                    }
                                                                                    if (jSONObject4.has("notification")) {
                                                                                        jVar.b(kjVarG2);
                                                                                    }
                                                                                    str10 = str36;
                                                                                    if (jSONObject4.has(str10)) {
                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                        if (kjVarG != null) {
                                                                                            jVar.a(kjVarG);
                                                                                        }
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    } else {
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    str6 = str33;
                                                                                    if (jSONObject4.has(str6)) {
                                                                                        jVar.f(jSONObject4.optInt(str6));
                                                                                    }
                                                                                    if (jSONObject4.has("complianceSensor")) {
                                                                                        jVar.a(w5VarD);
                                                                                    }
                                                                                    if (jSONObject4.has("notification")) {
                                                                                        jVar.b(kjVarG2);
                                                                                    }
                                                                                    str10 = str36;
                                                                                    if (jSONObject4.has(str10)) {
                                                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                                        if (kjVarG != null) {
                                                                                            jVar.a(kjVarG);
                                                                                        }
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    } else {
                                                                                        if (jSONObject4.has("optimize")) {
                                                                                            jVar.a(wkVarI);
                                                                                        }
                                                                                        if (jSONObject4.has(str15)) {
                                                                                            jVar.a(nhVarE);
                                                                                        }
                                                                                        str32 = str32;
                                                                                        if (jSONObject4.has(str32)) {
                                                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                            if (gpVarM != null) {
                                                                                                jVar.a(gpVarM);
                                                                                            }
                                                                                        }
                                                                                        str31 = str31;
                                                                                        if (jSONObject4.has(str31)) {
                                                                                            jVar.a(x4VarA);
                                                                                        }
                                                                                        if (jSONObject4.has("nativeOptimize")) {
                                                                                            jVar.a(npVarN);
                                                                                        }
                                                                                        if (jSONObject4.has("clickOptimize")) {
                                                                                            jVar.a(f5VarC);
                                                                                        }
                                                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            arrayList = arrayList6;
                                                                            arrayList.add(jVar);
                                                                            str32 = str32;
                                                                            str26 = str10;
                                                                            str31 = str31;
                                                                            str34 = str12;
                                                                            str23 = str13;
                                                                            str33 = str6;
                                                                            str22 = str7;
                                                                            str28 = str11;
                                                                            str27 = str3;
                                                                            str25 = str9;
                                                                            str24 = str8;
                                                                            iVar = iVar2;
                                                                            str29 = str4;
                                                                            str30 = str5;
                                                                            arrayList4 = arrayList;
                                                                            i2++;
                                                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                            str21 = str2;
                                                                        }
                                                                    } else {
                                                                        str9 = str25;
                                                                        if (jSONObjectOptJSONObject.has(str9)) {
                                                                            gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                                        }
                                                                        str8 = str39;
                                                                        str5 = str5;
                                                                        if (jSONObjectOptJSONObject.has(str8)) {
                                                                            gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                                            str13 = str38;
                                                                            str4 = str4;
                                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                            }
                                                                            str7 = str37;
                                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                            }
                                                                            jVar.a(gVar);
                                                                        } else {
                                                                            str13 = str38;
                                                                            str4 = str4;
                                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                            }
                                                                            str7 = str37;
                                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                            }
                                                                            jVar.a(gVar);
                                                                        }
                                                                    }
                                                                } catch (Exception e23) {
                                                                    e = e23;
                                                                    str9 = str25;
                                                                }
                                                            } catch (Exception e24) {
                                                                exc = e24;
                                                                str5 = str5;
                                                                str4 = str4;
                                                                str9 = str25;
                                                                str7 = str37;
                                                                str13 = str38;
                                                                str8 = str39;
                                                                str3 = str27;
                                                                exc.printStackTrace();
                                                                if (jSONObject4.has("rewardedVideo")) {
                                                                    imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                                    if (imVarK != null) {
                                                                        jVar.a(imVarK);
                                                                    }
                                                                    str12 = str34;
                                                                    if (jSONObject4.has(str12)) {
                                                                        jVar.e(jSONObject4.optInt(str12));
                                                                        str6 = str33;
                                                                        if (jSONObject4.has(str6)) {
                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                        }
                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                            jVar.a(w5VarD);
                                                                        }
                                                                        if (jSONObject4.has("notification")) {
                                                                            jVar.b(kjVarG2);
                                                                        }
                                                                        str10 = str36;
                                                                        if (jSONObject4.has(str10)) {
                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                            if (kjVarG != null) {
                                                                                jVar.a(kjVarG);
                                                                            }
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        } else {
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str6 = str33;
                                                                        if (jSONObject4.has(str6)) {
                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                        }
                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                            jVar.a(w5VarD);
                                                                        }
                                                                        if (jSONObject4.has("notification")) {
                                                                            jVar.b(kjVarG2);
                                                                        }
                                                                        str10 = str36;
                                                                        if (jSONObject4.has(str10)) {
                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                            if (kjVarG != null) {
                                                                                jVar.a(kjVarG);
                                                                            }
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        } else {
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    str12 = str34;
                                                                    if (jSONObject4.has(str12)) {
                                                                        jVar.e(jSONObject4.optInt(str12));
                                                                        str6 = str33;
                                                                        if (jSONObject4.has(str6)) {
                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                        }
                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                            jVar.a(w5VarD);
                                                                        }
                                                                        if (jSONObject4.has("notification")) {
                                                                            jVar.b(kjVarG2);
                                                                        }
                                                                        str10 = str36;
                                                                        if (jSONObject4.has(str10)) {
                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                            if (kjVarG != null) {
                                                                                jVar.a(kjVarG);
                                                                            }
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        } else {
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str6 = str33;
                                                                        if (jSONObject4.has(str6)) {
                                                                            jVar.f(jSONObject4.optInt(str6));
                                                                        }
                                                                        if (jSONObject4.has("complianceSensor")) {
                                                                            jVar.a(w5VarD);
                                                                        }
                                                                        if (jSONObject4.has("notification")) {
                                                                            jVar.b(kjVarG2);
                                                                        }
                                                                        str10 = str36;
                                                                        if (jSONObject4.has(str10)) {
                                                                            kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                            if (kjVarG != null) {
                                                                                jVar.a(kjVarG);
                                                                            }
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        } else {
                                                                            if (jSONObject4.has("optimize")) {
                                                                                jVar.a(wkVarI);
                                                                            }
                                                                            if (jSONObject4.has(str15)) {
                                                                                jVar.a(nhVarE);
                                                                            }
                                                                            str32 = str32;
                                                                            if (jSONObject4.has(str32)) {
                                                                                gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                                if (gpVarM != null) {
                                                                                    jVar.a(gpVarM);
                                                                                }
                                                                            }
                                                                            str31 = str31;
                                                                            if (jSONObject4.has(str31)) {
                                                                                jVar.a(x4VarA);
                                                                            }
                                                                            if (jSONObject4.has("nativeOptimize")) {
                                                                                jVar.a(npVarN);
                                                                            }
                                                                            if (jSONObject4.has("clickOptimize")) {
                                                                                jVar.a(f5VarC);
                                                                            }
                                                                            if (jSONObject4.has("switchFiveVersion")) {
                                                                                jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                arrayList = arrayList6;
                                                                arrayList.add(jVar);
                                                                str32 = str32;
                                                                str26 = str10;
                                                                str31 = str31;
                                                                str34 = str12;
                                                                str23 = str13;
                                                                str33 = str6;
                                                                str22 = str7;
                                                                str28 = str11;
                                                                str27 = str3;
                                                                str25 = str9;
                                                                str24 = str8;
                                                                iVar = iVar2;
                                                                str29 = str4;
                                                                str30 = str5;
                                                                arrayList4 = arrayList;
                                                                i2++;
                                                                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                                str21 = str2;
                                                            }
                                                        } else {
                                                            str3 = str27;
                                                            if (jSONObjectOptJSONObject.has(str3)) {
                                                                gVar.a(jSONObjectOptJSONObject.optInt(str3));
                                                                str9 = str25;
                                                                if (jSONObjectOptJSONObject.has(str9)) {
                                                                    gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                                }
                                                                str8 = str39;
                                                                str5 = str5;
                                                                if (jSONObjectOptJSONObject.has(str8)) {
                                                                    gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                                    str13 = str38;
                                                                    str4 = str4;
                                                                    if (jSONObjectOptJSONObject.has(str13)) {
                                                                        gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                    }
                                                                    str7 = str37;
                                                                    if (jSONObjectOptJSONObject.has(str7)) {
                                                                        gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                    }
                                                                    jVar.a(gVar);
                                                                } else {
                                                                    str13 = str38;
                                                                    str4 = str4;
                                                                    if (jSONObjectOptJSONObject.has(str13)) {
                                                                        gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                    }
                                                                    str7 = str37;
                                                                    if (jSONObjectOptJSONObject.has(str7)) {
                                                                        gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                    }
                                                                    jVar.a(gVar);
                                                                }
                                                            } else {
                                                                str9 = str25;
                                                                if (jSONObjectOptJSONObject.has(str9)) {
                                                                    gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                                }
                                                                str8 = str39;
                                                                str5 = str5;
                                                                if (jSONObjectOptJSONObject.has(str8)) {
                                                                    gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                                    str13 = str38;
                                                                    str4 = str4;
                                                                    if (jSONObjectOptJSONObject.has(str13)) {
                                                                        gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                    }
                                                                    str7 = str37;
                                                                    if (jSONObjectOptJSONObject.has(str7)) {
                                                                        gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                    }
                                                                    jVar.a(gVar);
                                                                } else {
                                                                    str13 = str38;
                                                                    str4 = str4;
                                                                    if (jSONObjectOptJSONObject.has(str13)) {
                                                                        gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                                    }
                                                                    str7 = str37;
                                                                    if (jSONObjectOptJSONObject.has(str7)) {
                                                                        gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                                    }
                                                                    jVar.a(gVar);
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e25) {
                                                        e = e25;
                                                        str5 = str5;
                                                        str4 = str4;
                                                        str9 = str25;
                                                        str7 = str37;
                                                        str13 = str38;
                                                        str8 = str39;
                                                        str3 = str27;
                                                    }
                                                } catch (Exception e26) {
                                                    exc = e26;
                                                    str5 = str5;
                                                    str4 = str4;
                                                    str9 = str25;
                                                    str7 = str37;
                                                    str13 = str38;
                                                    str8 = str39;
                                                    str3 = str27;
                                                    str11 = str14;
                                                    exc.printStackTrace();
                                                    if (jSONObject4.has("rewardedVideo")) {
                                                        imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                        if (imVarK != null) {
                                                            jVar.a(imVarK);
                                                        }
                                                        str12 = str34;
                                                        if (jSONObject4.has(str12)) {
                                                            jVar.e(jSONObject4.optInt(str12));
                                                            str6 = str33;
                                                            if (jSONObject4.has(str6)) {
                                                                jVar.f(jSONObject4.optInt(str6));
                                                            }
                                                            if (jSONObject4.has("complianceSensor")) {
                                                                jVar.a(w5VarD);
                                                            }
                                                            if (jSONObject4.has("notification")) {
                                                                jVar.b(kjVarG2);
                                                            }
                                                            str10 = str36;
                                                            if (jSONObject4.has(str10)) {
                                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                if (kjVarG != null) {
                                                                    jVar.a(kjVarG);
                                                                }
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            } else {
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            }
                                                        } else {
                                                            str6 = str33;
                                                            if (jSONObject4.has(str6)) {
                                                                jVar.f(jSONObject4.optInt(str6));
                                                            }
                                                            if (jSONObject4.has("complianceSensor")) {
                                                                jVar.a(w5VarD);
                                                            }
                                                            if (jSONObject4.has("notification")) {
                                                                jVar.b(kjVarG2);
                                                            }
                                                            str10 = str36;
                                                            if (jSONObject4.has(str10)) {
                                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                if (kjVarG != null) {
                                                                    jVar.a(kjVarG);
                                                                }
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            } else {
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        str12 = str34;
                                                        if (jSONObject4.has(str12)) {
                                                            jVar.e(jSONObject4.optInt(str12));
                                                            str6 = str33;
                                                            if (jSONObject4.has(str6)) {
                                                                jVar.f(jSONObject4.optInt(str6));
                                                            }
                                                            if (jSONObject4.has("complianceSensor")) {
                                                                jVar.a(w5VarD);
                                                            }
                                                            if (jSONObject4.has("notification")) {
                                                                jVar.b(kjVarG2);
                                                            }
                                                            str10 = str36;
                                                            if (jSONObject4.has(str10)) {
                                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                if (kjVarG != null) {
                                                                    jVar.a(kjVarG);
                                                                }
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            } else {
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            }
                                                        } else {
                                                            str6 = str33;
                                                            if (jSONObject4.has(str6)) {
                                                                jVar.f(jSONObject4.optInt(str6));
                                                            }
                                                            if (jSONObject4.has("complianceSensor")) {
                                                                jVar.a(w5VarD);
                                                            }
                                                            if (jSONObject4.has("notification")) {
                                                                jVar.b(kjVarG2);
                                                            }
                                                            str10 = str36;
                                                            if (jSONObject4.has(str10)) {
                                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                                if (kjVarG != null) {
                                                                    jVar.a(kjVarG);
                                                                }
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            } else {
                                                                if (jSONObject4.has("optimize")) {
                                                                    jVar.a(wkVarI);
                                                                }
                                                                if (jSONObject4.has(str15)) {
                                                                    jVar.a(nhVarE);
                                                                }
                                                                str32 = str32;
                                                                if (jSONObject4.has(str32)) {
                                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                                    if (gpVarM != null) {
                                                                        jVar.a(gpVarM);
                                                                    }
                                                                }
                                                                str31 = str31;
                                                                if (jSONObject4.has(str31)) {
                                                                    jVar.a(x4VarA);
                                                                }
                                                                if (jSONObject4.has("nativeOptimize")) {
                                                                    jVar.a(npVarN);
                                                                }
                                                                if (jSONObject4.has("clickOptimize")) {
                                                                    jVar.a(f5VarC);
                                                                }
                                                                if (jSONObject4.has("switchFiveVersion")) {
                                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                                }
                                                            }
                                                        }
                                                    }
                                                    arrayList = arrayList6;
                                                    arrayList.add(jVar);
                                                    str32 = str32;
                                                    str26 = str10;
                                                    str31 = str31;
                                                    str34 = str12;
                                                    str23 = str13;
                                                    str33 = str6;
                                                    str22 = str7;
                                                    str28 = str11;
                                                    str27 = str3;
                                                    str25 = str9;
                                                    str24 = str8;
                                                    iVar = iVar2;
                                                    str29 = str4;
                                                    str30 = str5;
                                                    arrayList4 = arrayList;
                                                    i2++;
                                                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                    str21 = str2;
                                                }
                                            } else {
                                                str11 = str14;
                                                if (jSONObjectOptJSONObject.has(str11)) {
                                                    gVar.b(jSONObjectOptJSONObject.optInt(str11));
                                                    str3 = str27;
                                                    if (jSONObjectOptJSONObject.has(str3)) {
                                                        gVar.a(jSONObjectOptJSONObject.optInt(str3));
                                                        str9 = str25;
                                                        if (jSONObjectOptJSONObject.has(str9)) {
                                                            gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                        }
                                                        str8 = str39;
                                                        str5 = str5;
                                                        if (jSONObjectOptJSONObject.has(str8)) {
                                                            gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        } else {
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        }
                                                    } else {
                                                        str9 = str25;
                                                        if (jSONObjectOptJSONObject.has(str9)) {
                                                            gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                        }
                                                        str8 = str39;
                                                        str5 = str5;
                                                        if (jSONObjectOptJSONObject.has(str8)) {
                                                            gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        } else {
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        }
                                                    }
                                                } else {
                                                    str3 = str27;
                                                    if (jSONObjectOptJSONObject.has(str3)) {
                                                        gVar.a(jSONObjectOptJSONObject.optInt(str3));
                                                        str9 = str25;
                                                        if (jSONObjectOptJSONObject.has(str9)) {
                                                            gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                        }
                                                        str8 = str39;
                                                        str5 = str5;
                                                        if (jSONObjectOptJSONObject.has(str8)) {
                                                            gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        } else {
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        }
                                                    } else {
                                                        str9 = str25;
                                                        if (jSONObjectOptJSONObject.has(str9)) {
                                                            gVar.c(jSONObjectOptJSONObject.optInt(str9));
                                                        }
                                                        str8 = str39;
                                                        str5 = str5;
                                                        if (jSONObjectOptJSONObject.has(str8)) {
                                                            gVar.c(jSONObjectOptJSONObject.optString(str8));
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        } else {
                                                            str13 = str38;
                                                            str4 = str4;
                                                            if (jSONObjectOptJSONObject.has(str13)) {
                                                                gVar.b(jSONObjectOptJSONObject.optString(str13));
                                                            }
                                                            str7 = str37;
                                                            if (jSONObjectOptJSONObject.has(str7)) {
                                                                gVar.a(jSONObjectOptJSONObject.optString(str7));
                                                            }
                                                            jVar.a(gVar);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e27) {
                                            e = e27;
                                            str4 = str4;
                                            str9 = str25;
                                            str7 = str37;
                                            str13 = str38;
                                            str8 = str39;
                                            str3 = str27;
                                            str11 = str14;
                                            exc = e;
                                            exc.printStackTrace();
                                            if (jSONObject4.has("rewardedVideo")) {
                                                imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                                if (imVarK != null) {
                                                    jVar.a(imVarK);
                                                }
                                                str12 = str34;
                                                if (jSONObject4.has(str12)) {
                                                    jVar.e(jSONObject4.optInt(str12));
                                                    str6 = str33;
                                                    if (jSONObject4.has(str6)) {
                                                        jVar.f(jSONObject4.optInt(str6));
                                                    }
                                                    if (jSONObject4.has("complianceSensor")) {
                                                        jVar.a(w5VarD);
                                                    }
                                                    if (jSONObject4.has("notification")) {
                                                        jVar.b(kjVarG2);
                                                    }
                                                    str10 = str36;
                                                    if (jSONObject4.has(str10)) {
                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                        if (kjVarG != null) {
                                                            jVar.a(kjVarG);
                                                        }
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    } else {
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    }
                                                } else {
                                                    str6 = str33;
                                                    if (jSONObject4.has(str6)) {
                                                        jVar.f(jSONObject4.optInt(str6));
                                                    }
                                                    if (jSONObject4.has("complianceSensor")) {
                                                        jVar.a(w5VarD);
                                                    }
                                                    if (jSONObject4.has("notification")) {
                                                        jVar.b(kjVarG2);
                                                    }
                                                    str10 = str36;
                                                    if (jSONObject4.has(str10)) {
                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                        if (kjVarG != null) {
                                                            jVar.a(kjVarG);
                                                        }
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    } else {
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    }
                                                }
                                            } else {
                                                str12 = str34;
                                                if (jSONObject4.has(str12)) {
                                                    jVar.e(jSONObject4.optInt(str12));
                                                    str6 = str33;
                                                    if (jSONObject4.has(str6)) {
                                                        jVar.f(jSONObject4.optInt(str6));
                                                    }
                                                    if (jSONObject4.has("complianceSensor")) {
                                                        jVar.a(w5VarD);
                                                    }
                                                    if (jSONObject4.has("notification")) {
                                                        jVar.b(kjVarG2);
                                                    }
                                                    str10 = str36;
                                                    if (jSONObject4.has(str10)) {
                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                        if (kjVarG != null) {
                                                            jVar.a(kjVarG);
                                                        }
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    } else {
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    }
                                                } else {
                                                    str6 = str33;
                                                    if (jSONObject4.has(str6)) {
                                                        jVar.f(jSONObject4.optInt(str6));
                                                    }
                                                    if (jSONObject4.has("complianceSensor")) {
                                                        jVar.a(w5VarD);
                                                    }
                                                    if (jSONObject4.has("notification")) {
                                                        jVar.b(kjVarG2);
                                                    }
                                                    str10 = str36;
                                                    if (jSONObject4.has(str10)) {
                                                        kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                        if (kjVarG != null) {
                                                            jVar.a(kjVarG);
                                                        }
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    } else {
                                                        if (jSONObject4.has("optimize")) {
                                                            jVar.a(wkVarI);
                                                        }
                                                        if (jSONObject4.has(str15)) {
                                                            jVar.a(nhVarE);
                                                        }
                                                        str32 = str32;
                                                        if (jSONObject4.has(str32)) {
                                                            gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                            if (gpVarM != null) {
                                                                jVar.a(gpVarM);
                                                            }
                                                        }
                                                        str31 = str31;
                                                        if (jSONObject4.has(str31)) {
                                                            jVar.a(x4VarA);
                                                        }
                                                        if (jSONObject4.has("nativeOptimize")) {
                                                            jVar.a(npVarN);
                                                        }
                                                        if (jSONObject4.has("clickOptimize")) {
                                                            jVar.a(f5VarC);
                                                        }
                                                        if (jSONObject4.has("switchFiveVersion")) {
                                                            jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                        }
                                                    }
                                                }
                                            }
                                            arrayList = arrayList6;
                                            arrayList.add(jVar);
                                            str32 = str32;
                                            str26 = str10;
                                            str31 = str31;
                                            str34 = str12;
                                            str23 = str13;
                                            str33 = str6;
                                            str22 = str7;
                                            str28 = str11;
                                            str27 = str3;
                                            str25 = str9;
                                            str24 = str8;
                                            iVar = iVar2;
                                            str29 = str4;
                                            str30 = str5;
                                            arrayList4 = arrayList;
                                            i2++;
                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                            str21 = str2;
                                        }
                                    }
                                } catch (Exception e28) {
                                    e = e28;
                                }
                                try {
                                    if (jSONObject4.has("rewardedVideo")) {
                                        imVarK = x1.k(jSONObject4.optJSONObject("rewardedVideo"));
                                        if (imVarK != null) {
                                            jVar.a(imVarK);
                                        }
                                        str12 = str34;
                                        if (jSONObject4.has(str12)) {
                                            jVar.e(jSONObject4.optInt(str12));
                                            str6 = str33;
                                            if (jSONObject4.has(str6)) {
                                                jVar.f(jSONObject4.optInt(str6));
                                            }
                                            if (jSONObject4.has("complianceSensor") && (w5VarD = x1.d(jSONObject4.optJSONObject("complianceSensor"))) != null) {
                                                jVar.a(w5VarD);
                                            }
                                            if (jSONObject4.has("notification") && (kjVarG2 = x1.g(jSONObject4.optJSONObject("notification"))) != null) {
                                                jVar.b(kjVarG2);
                                            }
                                            str10 = str36;
                                            if (jSONObject4.has(str10)) {
                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                if (kjVarG != null) {
                                                    jVar.a(kjVarG);
                                                }
                                                if (jSONObject4.has("optimize") && (wkVarI = x1.i(jSONObject4.optJSONObject("optimize"))) != null) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15) && (nhVarE = x1.e(jSONObject4.optJSONObject(str15))) != null) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31) && (x4VarA = x1.a(jSONObject4.optJSONObject(str31))) != null) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize") && (npVarN = x1.n(jSONObject4.optJSONObject("nativeOptimize"))) != null) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize") && (f5VarC = x1.c(jSONObject4.optJSONObject("clickOptimize"))) != null) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            } else {
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            }
                                        } else {
                                            str6 = str33;
                                            if (jSONObject4.has(str6)) {
                                                jVar.f(jSONObject4.optInt(str6));
                                            }
                                            if (jSONObject4.has("complianceSensor")) {
                                                jVar.a(w5VarD);
                                            }
                                            if (jSONObject4.has("notification")) {
                                                jVar.b(kjVarG2);
                                            }
                                            str10 = str36;
                                            if (jSONObject4.has(str10)) {
                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                if (kjVarG != null) {
                                                    jVar.a(kjVarG);
                                                }
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            } else {
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            }
                                        }
                                    } else {
                                        str12 = str34;
                                        if (jSONObject4.has(str12)) {
                                            jVar.e(jSONObject4.optInt(str12));
                                            str6 = str33;
                                            if (jSONObject4.has(str6)) {
                                                jVar.f(jSONObject4.optInt(str6));
                                            }
                                            if (jSONObject4.has("complianceSensor")) {
                                                jVar.a(w5VarD);
                                            }
                                            if (jSONObject4.has("notification")) {
                                                jVar.b(kjVarG2);
                                            }
                                            str10 = str36;
                                            if (jSONObject4.has(str10)) {
                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                if (kjVarG != null) {
                                                    jVar.a(kjVarG);
                                                }
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            } else {
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            }
                                        } else {
                                            str6 = str33;
                                            if (jSONObject4.has(str6)) {
                                                jVar.f(jSONObject4.optInt(str6));
                                            }
                                            if (jSONObject4.has("complianceSensor")) {
                                                jVar.a(w5VarD);
                                            }
                                            if (jSONObject4.has("notification")) {
                                                jVar.b(kjVarG2);
                                            }
                                            str10 = str36;
                                            if (jSONObject4.has(str10)) {
                                                kjVarG = x1.g(jSONObject4.optJSONObject(str10));
                                                if (kjVarG != null) {
                                                    jVar.a(kjVarG);
                                                }
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            } else {
                                                if (jSONObject4.has("optimize")) {
                                                    jVar.a(wkVarI);
                                                }
                                                if (jSONObject4.has(str15)) {
                                                    jVar.a(nhVarE);
                                                }
                                                str32 = str32;
                                                if (jSONObject4.has(str32)) {
                                                    gpVarM = x1.m(jSONObject4.optJSONObject(str32));
                                                    if (gpVarM != null) {
                                                        jVar.a(gpVarM);
                                                    }
                                                }
                                                str31 = str31;
                                                if (jSONObject4.has(str31)) {
                                                    jVar.a(x4VarA);
                                                }
                                                if (jSONObject4.has("nativeOptimize")) {
                                                    jVar.a(npVarN);
                                                }
                                                if (jSONObject4.has("clickOptimize")) {
                                                    jVar.a(f5VarC);
                                                }
                                                if (jSONObject4.has("switchFiveVersion")) {
                                                    jVar.d(jSONObject4.optInt("switchFiveVersion"));
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e29) {
                                    e = e29;
                                    str6 = str33;
                                    str12 = str34;
                                }
                                arrayList = arrayList6;
                                arrayList.add(jVar);
                            } else {
                                str2 = str21;
                                str3 = str27;
                                str4 = str29;
                                arrayList = arrayList4;
                                str5 = str30;
                                str32 = str32;
                                str6 = str33;
                                str7 = str22;
                                str8 = str24;
                                str9 = str25;
                                str10 = str26;
                                str11 = str28;
                                str12 = str34;
                                str13 = str23;
                                str31 = str31;
                            }
                            str32 = str32;
                            str26 = str10;
                            str31 = str31;
                            str34 = str12;
                            str23 = str13;
                            str33 = str6;
                            str22 = str7;
                            str28 = str11;
                            str27 = str3;
                            str25 = str9;
                            str24 = str8;
                            iVar = iVar2;
                            str29 = str4;
                            str30 = str5;
                            arrayList4 = arrayList;
                            i2++;
                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                            str21 = str2;
                        } catch (JSONException e30) {
                            jSONException = e30;
                            iVar = iVar2;
                            kh.c("ServerResponse", "JSONException e = " + jSONException.getMessage());
                            return iVar;
                        }
                    }
                    iVar.a(arrayList4);
                }
            } catch (JSONException e31) {
                jSONException = e31;
            }
            return iVar;
        }

        private static boolean a(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f28016a;
        private i7 b;
        private int c;
        private boolean d;
        private int e;
        private int f;
        private boolean g;
        private boolean h;
        private List i;
        private g j;
        private im k;
        private int l;
        private int m;
        private w5 n;
        private kj o;
        private kj p;
        private wk q;
        private nh r;
        private gp s;
        private x4 t;
        private np u;
        private f5 v;
        private int w;

        public void a(String str) {
            this.f28016a = str;
        }

        public void b(int i) {
            this.f = i;
        }

        public i7 c() {
            return this.b;
        }

        public g d() {
            return this.j;
        }

        public boolean e() {
            return this.d;
        }

        public boolean f() {
            return this.h;
        }

        public x4 g() {
            return this.t;
        }

        public f5 h() {
            return this.v;
        }

        public w5 i() {
            return this.n;
        }

        public kj j() {
            return this.p;
        }

        public nh k() {
            return this.r;
        }

        public int l() {
            return this.e;
        }

        public int m() {
            return this.f;
        }

        public boolean n() {
            return this.g;
        }

        public np o() {
            return this.u;
        }

        public kj p() {
            return this.o;
        }

        public wk q() {
            return this.q;
        }

        public int r() {
            return this.c;
        }

        public im s() {
            return this.k;
        }

        public int t() {
            return this.w;
        }

        public int u() {
            return this.l;
        }

        public int v() {
            return this.m;
        }

        public gp w() {
            return this.s;
        }

        public void a(i7 i7Var) {
            this.b = i7Var;
        }

        public void b(boolean z) {
            this.h = z;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.w = i;
        }

        public void e(int i) {
            this.l = i;
        }

        public void f(int i) {
            this.m = i;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public List b() {
            return this.i;
        }

        public void c(boolean z) {
            this.g = z;
        }

        public void a(int i) {
            this.e = i;
        }

        public void b(kj kjVar) {
            this.o = kjVar;
        }

        public void a(List list) {
            this.i = list;
        }

        public int a() {
            List list = this.i;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(g gVar) {
            this.j = gVar;
        }

        public void a(im imVar) {
            this.k = imVar;
        }

        public void a(w5 w5Var) {
            this.n = w5Var;
        }

        public void a(kj kjVar) {
            this.p = kjVar;
        }

        public void a(wk wkVar) {
            this.q = wkVar;
        }

        public void a(nh nhVar) {
            this.r = nhVar;
        }

        public void a(gp gpVar) {
            this.s = gpVar;
        }

        public void a(x4 x4Var) {
            this.t = x4Var;
        }

        public void a(np npVar) {
            this.u = npVar;
        }

        public void a(f5 f5Var) {
            this.v = f5Var;
        }
    }

    private static xo a(JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!jSONObject.has(str) || (jSONObject2 = jSONObject.getJSONObject(str)) == null) {
                return null;
            }
            xo xoVar = new xo();
            if (jSONObject2.has("normal")) {
                xoVar.b(jSONObject2.optString("normal"));
            }
            if (jSONObject2.has("select")) {
                xoVar.c(jSONObject2.optString("select"));
            }
            if (jSONObject2.has("finals")) {
                xoVar.a(jSONObject2.optString("finals"));
            }
            return xoVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c5 b(JSONObject jSONObject) {
        cl clVarJ;
        if (jSONObject == null) {
            return null;
        }
        try {
            c5 c5Var = new c5();
            c5Var.a(jSONObject.optString("bgColor"));
            c5Var.b(jSONObject.optString("imageUrl"));
            if (jSONObject.has("position") && (clVarJ = j(jSONObject.optJSONObject("position"))) != null) {
                c5Var.a(clVarJ);
            }
            return c5Var;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f5 c(JSONObject jSONObject) {
        oh ohVarF;
        if (jSONObject == null) {
            return null;
        }
        try {
            f5 f5Var = new f5();
            f5Var.a(jSONObject.optInt("closeCfg"));
            f5Var.b(jSONObject.optInt("ncb"));
            f5Var.b(jSONObject.optDouble("angle"));
            f5Var.a(jSONObject.optDouble("acc"));
            if (jSONObject.has("lpStrategy") && (ohVarF = f(jSONObject.optJSONObject("lpStrategy"))) != null) {
                f5Var.a(ohVarF);
            }
            return f5Var;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w5 d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            w5 w5Var = new w5();
            if (jSONObject.has("maxAcc")) {
                w5Var.c(jSONObject.optDouble("maxAcc"));
            }
            if (jSONObject.has("angle")) {
                w5Var.a(jSONObject.optDouble("angle"));
            }
            if (jSONObject.has("duration")) {
                w5Var.b(jSONObject.optDouble("duration"));
            }
            if (jSONObject.has(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
                w5Var.a(jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION));
            }
            return w5Var;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static nh e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            nh nhVar = new nh();
            nhVar.e(jSONObject.optInt("random"));
            nhVar.a(jSONObject.optString("url"));
            nhVar.h(jSONObject.optInt("showMask"));
            nhVar.c(jSONObject.optInt("autoOpen"));
            nhVar.d(jSONObject.optInt("autoOpenType"));
            nhVar.f(jSONObject.optInt("repeatOpen"));
            nhVar.g(jSONObject.optInt("repeatOpenCount"));
            nhVar.a(jSONObject.optInt("againOpen"));
            nhVar.b(jSONObject.optInt("againOpenTime"));
            return nhVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static oh f(JSONObject jSONObject) {
        cl clVarJ;
        if (jSONObject == null) {
            return null;
        }
        try {
            oh ohVar = new oh();
            ohVar.a(jSONObject.optInt("autoTime"));
            ohVar.c(jSONObject.optInt("removeTime"));
            ohVar.b(jSONObject.optInt("layer"));
            ohVar.d(jSONObject.optInt("type"));
            if (jSONObject.has("position") && (clVarJ = j(jSONObject.optJSONObject("position"))) != null) {
                ohVar.a(clVarJ);
            }
            return ohVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static kj g(JSONObject jSONObject) {
        cl clVarJ;
        if (jSONObject == null) {
            return null;
        }
        try {
            kj kjVar = new kj();
            kjVar.f(jSONObject.optInt("showTime"));
            kjVar.d(jSONObject.optInt("duration"));
            kjVar.g(jSONObject.optInt("slide"));
            kjVar.a(jSONObject.optInt(com.ipd.dsp.internal.l.a.l));
            kjVar.c(jSONObject.optString("image"));
            kjVar.d(jSONObject.optString("title"));
            kjVar.b(jSONObject.optString("desc"));
            kjVar.a(jSONObject.optString("btn"));
            kjVar.c(jSONObject.optInt("btnClick"));
            kjVar.b(jSONObject.optInt("autoTime"));
            kjVar.e(jSONObject.optInt("layer"));
            if (jSONObject.has("position") && (clVarJ = j(jSONObject.optJSONObject("position"))) != null) {
                kjVar.a(clVarJ);
            }
            return kjVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static uk h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strOptString = jSONObject.optString(LoginConstants.TOKEN_INFO);
            String strOptString2 = jSONObject.optString("reqId");
            int iOptInt = jSONObject.optInt("failRetry");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                uk ukVar = new uk();
                ukVar.b(strOptString);
                ukVar.a(strOptString2);
                ukVar.a(iOptInt);
                return ukVar;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static wk i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            wk wkVar = new wk();
            wkVar.a(jSONObject.optInt("autoTime"));
            wkVar.d(jSONObject.optInt("multiDirection"));
            wkVar.b(jSONObject.optInt("isOpenSensor"));
            wkVar.c(jSONObject.optInt("isShowShakeView"));
            return wkVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cl j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            cl clVar = new cl();
            if (jSONObject.has(LayoutModel.MODEL_KEY_CENTER_X)) {
                clVar.a(jSONObject.optString(LayoutModel.MODEL_KEY_CENTER_X));
            }
            if (jSONObject.has(LayoutModel.MODEL_KEY_CENTER_Y)) {
                clVar.b(jSONObject.optString(LayoutModel.MODEL_KEY_CENTER_Y));
            }
            if (jSONObject.has(com.ipd.dsp.internal.e1.f.l)) {
                clVar.d(jSONObject.optString(com.ipd.dsp.internal.e1.f.l));
            }
            if (jSONObject.has("width")) {
                clVar.e(jSONObject.optString("width"));
            }
            if (jSONObject.has("height")) {
                clVar.c(jSONObject.optString("height"));
            }
            if (jSONObject.has("x")) {
                clVar.f(jSONObject.optString("x"));
            }
            if (jSONObject.has("y")) {
                clVar.g(jSONObject.optString("y"));
            }
            return clVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static im k(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        if (jSONObject == null) {
            return null;
        }
        try {
            im imVar = new im();
            imVar.e(jSONObject.optInt("optimizeType"));
            imVar.d(jSONObject.optInt("optimizeTime"));
            imVar.h(jSONObject.optInt("showTime"));
            imVar.a(jSONObject.optInt("awardTime"));
            imVar.f(jSONObject.optInt(MediationConstant.KEY_REWARD_TYPE));
            imVar.c(jSONObject.optInt("minTime"));
            if (jSONObject.has("closeModule") && (jSONObject6 = jSONObject.getJSONObject("closeModule")) != null) {
                j5 j5Var = new j5();
                j5Var.d(jSONObject6.optInt("isHiddenClose"));
                j5Var.f(jSONObject6.optInt("showTime"));
                xo xoVarA = a(jSONObject6, "detail");
                if (xoVarA != null) {
                    j5Var.b(xoVarA);
                }
                xo xoVarA2 = a(jSONObject6, "closeTitle");
                if (xoVarA2 != null) {
                    j5Var.a(xoVarA2);
                }
                j5Var.b(jSONObject6.optInt("eventProbity"));
                j5Var.a(jSONObject6.optInt("event"));
                j5Var.c(jSONObject6.optInt("forbidClose"));
                j5Var.e(jSONObject6.optInt("isJumpEndCard"));
                imVar.b(j5Var);
            }
            if (jSONObject.has("cardCloseModule") && (jSONObject5 = jSONObject.getJSONObject("cardCloseModule")) != null) {
                j5 j5Var2 = new j5();
                j5Var2.d(jSONObject5.optInt("isHiddenClose"));
                j5Var2.f(jSONObject5.optInt("showTime"));
                xo xoVarA3 = a(jSONObject5, "detail");
                if (xoVarA3 != null) {
                    j5Var2.b(xoVarA3);
                }
                xo xoVarA4 = a(jSONObject5, "closeTitle");
                if (xoVarA4 != null) {
                    j5Var2.a(xoVarA4);
                }
                j5Var2.b(jSONObject5.optInt("eventProbity"));
                j5Var2.a(jSONObject5.optInt("event"));
                imVar.a(j5Var2);
            }
            if (jSONObject.has("privilegeModule") && (jSONObject4 = jSONObject.getJSONObject("privilegeModule")) != null) {
                il ilVar = new il();
                ilVar.a(jSONObject4.optInt("adType"));
                ilVar.h(jSONObject4.optInt("optimizeType"));
                xo xoVarA5 = a(jSONObject4, "title");
                if (xoVarA5 != null) {
                    ilVar.f(xoVarA5);
                }
                xo xoVarA6 = a(jSONObject4, "sub");
                if (xoVarA6 != null) {
                    ilVar.e(xoVarA6);
                }
                xo xoVarA7 = a(jSONObject4, "detail");
                if (xoVarA7 != null) {
                    ilVar.d(xoVarA7);
                }
                xo xoVarA8 = a(jSONObject4, "awardTitle");
                if (xoVarA8 != null) {
                    ilVar.a(xoVarA8);
                }
                xo xoVarA9 = a(jSONObject4, "clickTitle");
                if (xoVarA9 != null) {
                    ilVar.b(xoVarA9);
                }
                xo xoVarA10 = a(jSONObject4, "closeTitle");
                if (xoVarA10 != null) {
                    ilVar.c(xoVarA10);
                }
                ilVar.d(jSONObject4.optInt("awardTime"));
                ilVar.i(jSONObject4.optInt("showTime"));
                ilVar.b(jSONObject4.optInt("autoCloseTime"));
                ilVar.g(jSONObject4.optInt("isHiddenClose"));
                ilVar.f(jSONObject4.optInt("eventProbity"));
                ilVar.e(jSONObject4.optInt("event"));
                ilVar.c(jSONObject4.optInt("awardClickCount"));
                imVar.a(ilVar);
            }
            if (jSONObject.has("detainmentModule") && (jSONObject3 = jSONObject.getJSONObject("detainmentModule")) != null) {
                o6 o6Var = new o6();
                xo xoVarA11 = a(jSONObject3, "title");
                if (xoVarA11 != null) {
                    o6Var.d(xoVarA11);
                }
                xo xoVarA12 = a(jSONObject3, "detail");
                if (xoVarA12 != null) {
                    o6Var.c(xoVarA12);
                }
                xo xoVarA13 = a(jSONObject3, "clickTitle");
                if (xoVarA13 != null) {
                    o6Var.a(xoVarA13);
                }
                xo xoVarA14 = a(jSONObject3, "closeTitle");
                if (xoVarA14 != null) {
                    o6Var.b(xoVarA14);
                }
                o6Var.b(jSONObject3.optInt("eventProbity"));
                o6Var.a(jSONObject3.optInt("event"));
                imVar.a(o6Var);
            }
            if (jSONObject.has("cardModule") && (jSONObject2 = jSONObject.getJSONObject("cardModule")) != null) {
                a5 a5Var = new a5();
                a5Var.a(jSONObject2.optInt("cardType"));
                imVar.a(a5Var);
            }
            if (jSONObject.has("loopClick")) {
                imVar.b(jSONObject.optInt("loopClick"));
            }
            if (jSONObject.has("scrollInterval")) {
                imVar.g(jSONObject.optInt("scrollInterval"));
            }
            if (jSONObject.has("rewardedUrl")) {
                imVar.a(jSONObject.optString("rewardedUrl"));
            }
            return imVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static rn l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            rn rnVar = new rn();
            rnVar.e(jSONObject.optInt("isShow"));
            rnVar.d(jSONObject.optDouble("normalStart"));
            rnVar.c(jSONObject.optDouble("normalEnd"));
            rnVar.g(jSONObject.optInt("normalCount"));
            rnVar.f(jSONObject.optInt("normalAngle"));
            rnVar.d(jSONObject.optInt("isClickRemove"));
            rnVar.c(jSONObject.optInt("isClickCool"));
            rnVar.b(jSONObject.optDouble("coolStart"));
            rnVar.a(jSONObject.optDouble("coolEnd"));
            rnVar.b(jSONObject.optInt("coolCount"));
            rnVar.a(jSONObject.optInt("coolAngle"));
            return rnVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static gp m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            gp gpVar = new gp();
            gpVar.b(jSONObject.optInt("interval"));
            gpVar.a(jSONObject.optInt("closeType"));
            gpVar.d(jSONObject.optInt("privilegeClick"));
            gpVar.c(jSONObject.optInt("isScrollClick"));
            return gpVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static np n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            np npVar = new np();
            npVar.b(jSONObject.optInt("slideClick"));
            npVar.a(jSONObject.optInt("clickState"));
            return npVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static x4 a(JSONObject jSONObject) {
        try {
            x4 x4Var = new x4();
            if (jSONObject.has(GoodsSpecificationPreviewActivity.z)) {
                x4Var.a(a(jSONObject.optJSONArray(GoodsSpecificationPreviewActivity.z)));
            }
            if (jSONObject.has("version")) {
                x4Var.a(jSONObject.optString("version"));
            }
            return x4Var;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static ArrayList a(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
