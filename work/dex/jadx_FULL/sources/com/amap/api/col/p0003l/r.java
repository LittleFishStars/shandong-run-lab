package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.zj.adlib.bcb;
import com.zj.adlib.k9b;
import com.zj.adlib.m6b;
import com.zj.adlib.p4b;
import com.zj.adlib.p6b;
import com.zj.adlib.q6b;
import com.zj.adlib.r4b;
import com.zj.adlib.r6b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r4b f1081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1083a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1086b = false;
    public boolean c = true;
    public boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f1082a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q6b f1080a = new q6b((byte) 0);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public q6b f1085b = new q6b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public go.a f1078a = new a();
    public go.a b = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f1077a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k9b f1079a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public k9b f1084b = null;

    public class a implements go.a {

        /* JADX INFO: renamed from: com.amap.api.col.3l.r$a$a, reason: collision with other inner class name */
        public class RunnableC0249a implements Runnable {
            public RunnableC0249a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                r.this.s(false);
            }
        }

        public a() {
        }

        @Override // com.amap.api.col.3l.go.a
        public final void a(int i) {
            if (i > 0 && r.b(r.this) != null) {
                ((p6b) r.this.p().f17615a).e(i);
                r.h(r.this, "error", String.valueOf(((p6b) r.this.p().f17615a).g()));
                r.b(r.this).postDelayed(new RunnableC0249a(), 660000L);
            }
        }
    }

    public class b implements go.a {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                r.this.v(false);
            }
        }

        public b() {
        }

        @Override // com.amap.api.col.3l.go.a
        public final void a(int i) {
            if (i <= 0) {
                return;
            }
            ((p6b) r.this.w().f17615a).e(i);
            r.h(r.this, AliyunLogCommon.LogLevel.INFO, String.valueOf(((p6b) r.this.w().f17615a).g()));
            if (r.b(r.this) == null) {
                return;
            }
            r.b(r.this).postDelayed(new a(), 660000L);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, r> f26050a = new HashMap();
    }

    public r(r4b r4bVar) {
        this.f1081a = r4bVar;
    }

    public static /* synthetic */ Handler b(r rVar) {
        Context context = rVar.f26045a;
        if (context == null || context == null) {
            return null;
        }
        if (rVar.f1077a == null) {
            rVar.f1077a = new Handler(rVar.f26045a.getMainLooper());
        }
        return rVar.f1077a;
    }

    public static r c(r4b r4bVar) {
        if (r4bVar == null || TextUtils.isEmpty(r4bVar.a())) {
            return null;
        }
        if (c.f26050a.get(r4bVar.a()) == null) {
            c.f26050a.put(r4bVar.a(), new r(r4bVar));
        }
        return c.f26050a.get(r4bVar.a());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019  */
    public static String d(Context context, String str, r4b r4bVar) {
        String strD;
        if (context == null) {
            return null;
        }
        if (r4bVar != null) {
            try {
                if (TextUtils.isEmpty(r4bVar.a())) {
                    strD = "a";
                } else {
                    strD = p4b.d(r4bVar.a());
                }
            } catch (Throwable unused) {
                return null;
            }
        } else {
            strD = "a";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append(strD);
        return sb.toString();
    }

    public static /* synthetic */ void h(r rVar, String str, String str2) {
        try {
            String str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
            r6b.a(rVar.f1081a).d(rVar.f26045a, "", "", str3 + str, str2);
        } catch (Throwable unused) {
        }
    }

    public final String A() {
        Context context = this.f26045a;
        if (context == null) {
            return null;
        }
        return d(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f1081a);
    }

    public final long a(String str) {
        try {
            String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
            return Long.parseLong(r6b.a(this.f1081a).c(this.f26045a, "", "", str2 + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final void e() {
        if (o()) {
            f(m6b.c);
            f(m6b.b);
        }
    }

    public final void f(int i) {
        Context context;
        q6b q6bVarL = l(i);
        String strD = m6b.d(q6bVarL.a());
        if (TextUtils.isEmpty(strD) || "[]".equals(strD) || (context = this.f26045a) == null) {
            return;
        }
        go.i(context, this.f1081a, m6b.c(i), q(i), strD);
        q6bVarL.d();
    }

    public final void g(Context context) {
        this.f26045a = context.getApplicationContext();
    }

    public final void i(m6b m6bVar) {
        if (o() && this.f1083a && m6b.e(m6bVar)) {
            boolean z = true;
            if (m6bVar != null) {
                List<String> list = this.f1082a;
                if (list != null && list.size() != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= this.f1082a.size()) {
                            z = false;
                            break;
                        } else if (!TextUtils.isEmpty(this.f1082a.get(i)) && m6bVar.g().contains(this.f1082a.get(i))) {
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return;
            }
            if (this.c || m6bVar.a() != m6b.b) {
                q6b q6bVarL = l(m6bVar.a());
                if (q6bVarL.c(m6bVar.g())) {
                    String strD = m6b.d(q6bVarL.a());
                    if (this.f26045a == null || TextUtils.isEmpty(strD) || "[]".equals(strD)) {
                        return;
                    }
                    go.i(this.f26045a, this.f1081a, m6bVar.i(), q(m6bVar.a()), strD);
                    n(false);
                    q6bVarL.d();
                }
                q6bVarL.b(m6bVar);
            }
        }
    }

    public final void j(boolean z) {
        if (o()) {
            n(z);
        }
    }

    public final void k(boolean z, boolean z2, boolean z3, boolean z4, List<String> list) {
        this.f1083a = z;
        this.f1086b = z2;
        this.c = z3;
        this.d = z4;
        this.f1082a = list;
        t();
        y();
    }

    public final q6b l(int i) {
        return i == m6b.c ? this.f1085b : this.f1080a;
    }

    public final void n(boolean z) {
        s(z);
        v(z);
    }

    public final boolean o() {
        return this.f26045a != null;
    }

    public final k9b p() {
        k9b k9bVar = this.f1084b;
        if (k9bVar != null) {
            return k9bVar;
        }
        t();
        return this.f1084b;
    }

    public final k9b q(int i) {
        if (i == m6b.c) {
            if (this.f1084b == null) {
                this.f1084b = p();
            }
            return this.f1084b;
        }
        if (this.f1079a == null) {
            this.f1079a = w();
        }
        return this.f1079a;
    }

    public final void s(boolean z) {
        k9b k9bVarQ = q(m6b.c);
        if (z) {
            ((p6b) k9bVarQ.f17615a).f(z);
        }
        Context context = this.f26045a;
        if (context == null) {
            return;
        }
        go.j(context, k9bVarQ, this.f1078a);
    }

    public final k9b t() {
        if (this.f26045a == null) {
            return null;
        }
        k9b k9bVar = new k9b();
        this.f1084b = k9bVar;
        k9bVar.f17616a = A();
        k9b k9bVar2 = this.f1084b;
        k9bVar2.f17612a = 512000000L;
        k9bVar2.f42769a = 12500;
        k9bVar2.f17617b = "1";
        k9bVar2.b = -1;
        k9bVar2.c = "elkey";
        long jA = a("error");
        this.f1084b.f17615a = new p6b(true, new bcb(this.f26045a, this.f1086b), jA, 10000000);
        k9b k9bVar3 = this.f1084b;
        k9bVar3.f17614a = null;
        return k9bVar3;
    }

    public final void v(boolean z) {
        k9b k9bVarQ = q(m6b.b);
        if (z) {
            ((p6b) k9bVarQ.f17615a).f(z);
        }
        Context context = this.f26045a;
        if (context == null) {
            return;
        }
        go.j(context, k9bVarQ, this.b);
    }

    public final k9b w() {
        k9b k9bVar = this.f1079a;
        if (k9bVar != null) {
            return k9bVar;
        }
        y();
        return this.f1079a;
    }

    public final k9b y() {
        if (this.f26045a == null) {
            return null;
        }
        k9b k9bVar = new k9b();
        this.f1079a = k9bVar;
        k9bVar.f17616a = z();
        k9b k9bVar2 = this.f1079a;
        k9bVar2.f17612a = 512000000L;
        k9bVar2.f42769a = 12500;
        k9bVar2.f17617b = "1";
        k9bVar2.b = -1;
        k9bVar2.c = "inlkey";
        long jA = a(AliyunLogCommon.LogLevel.INFO);
        this.f1079a.f17615a = new p6b(this.d, new bcb(this.f26045a, this.f1086b), jA, 30000000);
        k9b k9bVar3 = this.f1079a;
        k9bVar3.f17614a = null;
        return k9bVar3;
    }

    public final String z() {
        Context context = this.f26045a;
        if (context == null) {
            return null;
        }
        return d(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f1081a);
    }
}
