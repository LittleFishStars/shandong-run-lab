package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.R;
import com.alipay.sdk.m.l.c;
import com.alipay.sdk.m.w.b;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.k;
import com.alipay.sdk.m.y.o;
import com.alipay.sdk.m.y.q;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthTask {
    public static final Object c = k.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f25366a;
    public com.alipay.sdk.m.c0.a b;

    public class a implements k.f {
        public a() {
        }

        @Override // com.alipay.sdk.m.y.k.f
        public void a() {
            AuthTask.this.a();
        }

        @Override // com.alipay.sdk.m.y.k.f
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.f25366a = activity;
        b.c().a(this.f25366a);
        this.b = new com.alipay.sdk.m.c0.a(activity, this.f25366a.getString(R.string.alipay_standard_sdk_loading_go_auth));
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.w.a(this.f25366a, str, "auth"), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.m.w.a aVar;
        aVar = new com.alipay.sdk.m.w.a(this.f25366a, str, "authV2");
        return o.a(aVar, innerAuth(aVar, str, z));
    }

    public final k.f b() {
        return new a();
    }

    public final void c() {
        com.alipay.sdk.m.c0.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00c3 A[Catch: all -> 0x013a, PHI: r9
      0x00c3: PHI (r9v11 java.lang.String) = (r9v2 java.lang.String), (r9v13 java.lang.String) binds: [B:16:0x00c1, B:9:0x006c] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0006, B:8:0x0020, B:18:0x00cc, B:17:0x00c3, B:21:0x00d8, B:23:0x0126, B:24:0x012f, B:25:0x0139, B:15:0x0075, B:7:0x001a, B:14:0x0072), top: B:29:0x0003, inners: #1, #2 }] */
    public synchronized String innerAuth(com.alipay.sdk.m.w.a aVar, String str, boolean z) {
        String strA;
        if (z) {
            c();
            b.c().a(this.f25366a);
            strA = com.alipay.sdk.m.l.b.a();
            com.alipay.sdk.m.l.a.a("");
            try {
                try {
                    strA = a(this.f25366a, str, aVar);
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                    if (!com.alipay.sdk.m.o.b.i().u()) {
                        com.alipay.sdk.m.o.b.i().a(aVar, this.f25366a, false, 1);
                    }
                } catch (Exception e) {
                    g.a(e);
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                    if (!com.alipay.sdk.m.o.b.i().u()) {
                        com.alipay.sdk.m.o.b.i().a(aVar, this.f25366a, false, 1);
                    }
                }
                a();
                com.alipay.sdk.m.m.a.b(this.f25366a, aVar, str, aVar.d);
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                if (!com.alipay.sdk.m.o.b.i().u()) {
                    com.alipay.sdk.m.o.b.i().a(aVar, this.f25366a, false, 1);
                }
                a();
                com.alipay.sdk.m.m.a.b(this.f25366a, aVar, str, aVar.d);
                throw th;
            }
        } else {
            b.c().a(this.f25366a);
            strA = com.alipay.sdk.m.l.b.a();
            com.alipay.sdk.m.l.a.a("");
            strA = a(this.f25366a, str, aVar);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
            if (!com.alipay.sdk.m.o.b.i().u()) {
                com.alipay.sdk.m.o.b.i().a(aVar, this.f25366a, false, 1);
            }
            a();
            com.alipay.sdk.m.m.a.b(this.f25366a, aVar, str, aVar.d);
        }
        throw th;
        return strA;
    }

    public final void a() {
        com.alipay.sdk.m.c0.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final String b(Activity activity, String str, com.alipay.sdk.m.w.a aVar) {
        c();
        c cVarA = null;
        try {
            try {
                List<com.alipay.sdk.m.v.b> listA = com.alipay.sdk.m.v.b.a(new com.alipay.sdk.m.u.a().a(aVar, activity, str).c().optJSONObject(com.alipay.sdk.m.n.c.c).optJSONObject(com.alipay.sdk.m.n.c.d));
                a();
                for (int i = 0; i < listA.size(); i++) {
                    if (listA.get(i).a() == com.alipay.sdk.m.v.a.WapPay) {
                        String strA = a(aVar, listA.get(i));
                        a();
                        return strA;
                    }
                }
                a();
            } catch (Throwable th) {
                a();
                throw th;
            }
        } catch (IOException e) {
            c cVarA2 = c.a(c.NETWORK_ERROR.c());
            com.alipay.sdk.m.m.a.a(aVar, "net", e);
            cVarA = cVarA2;
            a();
        } catch (Throwable th2) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.C, th2);
            a();
        }
        if (cVarA == null) {
            cVarA = c.a(c.FAILED.c());
        }
        return com.alipay.sdk.m.l.b.a(cVarA.c(), cVarA.b(), "");
    }

    public final String a(Activity activity, String str, com.alipay.sdk.m.w.a aVar) {
        String strA = aVar.a(str);
        List<com.alipay.sdk.m.o.b.C0199b> listM = com.alipay.sdk.m.o.b.i().m();
        if (!com.alipay.sdk.m.o.b.i().g || listM == null) {
            listM = com.alipay.sdk.m.l.a.d;
        }
        if (q.a(aVar, (Context) this.f25366a, listM, true)) {
            k kVar = new k(activity, aVar, b());
            String strA2 = kVar.a(strA, false);
            kVar.a();
            if (!TextUtils.equals(strA2, k.j) && !TextUtils.equals(strA2, k.k)) {
                return TextUtils.isEmpty(strA2) ? com.alipay.sdk.m.l.b.a() : strA2;
            }
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.i0);
            return b(activity, strA, aVar);
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.j0);
        return b(activity, strA, aVar);
    }

    public final String a(com.alipay.sdk.m.w.a aVar, com.alipay.sdk.m.v.b bVar) {
        String[] strArrC = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrC[0]);
        Intent intent = new Intent(this.f25366a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        com.alipay.sdk.m.w.a.C0210a.a(aVar, intent);
        this.f25366a.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return com.alipay.sdk.m.l.b.a();
            }
        }
        String strD = com.alipay.sdk.m.l.b.d();
        return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.l.b.a() : strD;
    }
}
