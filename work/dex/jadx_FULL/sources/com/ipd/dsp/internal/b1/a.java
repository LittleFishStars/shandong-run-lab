package com.ipd.dsp.internal.b1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c1.c;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.e1.d;
import com.ipd.dsp.internal.z0.e;
import com.ipd.dsp.open.BaseProxyActivity;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static final String f = "PClick";
    public static final int g = 9529;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f38206a;
    public com.ipd.dsp.internal.j1.b b;
    public com.ipd.dsp.internal.c1.b c;
    public com.ipd.dsp.internal.c1.b.InterfaceC0865b d;
    public boolean e;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.b1.a$a, reason: collision with other inner class name */
    public class C0861a implements com.ipd.dsp.internal.c1.b.InterfaceC0865b {
        public C0861a() {
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void a(long j, long j2) {
            if (a.this.d != null) {
                a.this.d.a(j, j2);
            }
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onFailure(String str) {
            if (a.this.d != null) {
                a.this.d.onFailure(str);
            }
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onStart() {
            if (a.this.d != null) {
                a.this.d.onStart();
            }
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onSuccess() {
            if (a.this.d != null) {
                a.this.d.onSuccess();
            }
            c.a(a.this.f38206a);
        }
    }

    public interface b {
        void a(int i, boolean z, int i2, String str);
    }

    public a(d dVar, com.ipd.dsp.internal.j1.b bVar) {
        this.f38206a = dVar;
        this.b = bVar;
        this.e = dVar.r.w;
    }

    public final /* synthetic */ void b(b bVar) {
        String string;
        try {
            Context context = Dsp.getContext();
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            Intent intentA = a(context, this.f38206a.r.j);
            if (intentA != null) {
                intentA.addFlags(65537);
                try {
                    context.startActivity(intentA);
                    if (bVar != null) {
                        bVar.a(1, true, 0, null);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    r.a(th);
                    string = th.toString();
                }
            } else {
                string = "not matched";
            }
            if (bVar != null) {
                bVar.a(1, false, -2, string);
            }
        } catch (Throwable th2) {
            r.a(th2);
            string = th2.toString();
        }
    }

    public final /* synthetic */ void c(b bVar) {
        try {
            Context context = Dsp.getContext();
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            e.a(context, this.f38206a);
            if (bVar != null) {
                bVar.a(1, true, 0, null);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(1, false, -2, th.toString());
            }
            r.a(th);
        }
    }

    public final /* synthetic */ void d(b bVar) {
        try {
            Context context = Dsp.getContext();
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, com.ipd.dsp.internal.l1.a.a().getWxOpenId());
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            com.ipd.dsp.internal.e1.b bVar2 = this.f38206a.r;
            req.userName = bVar2.o;
            req.miniprogramType = 0;
            String str = bVar2.p;
            if (!TextUtils.isEmpty(str)) {
                req.path = str;
            }
            iwxapiCreateWXAPI.sendReq(req);
            if (bVar != null) {
                bVar.a(2, true, 0, null);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(2, false, -2, th.toString());
            }
            r.a(th);
        }
    }

    public void e(b bVar) {
        a(4, this.f38206a.r.i, bVar, (Activity) null);
    }

    public void f() {
        this.d = null;
        com.ipd.dsp.internal.c1.b bVar = this.c;
        if (bVar != null) {
            bVar.d();
            this.c = null;
        }
    }

    public void g(final b bVar) {
        try {
            if (!TextUtils.isEmpty(this.f38206a.r.j)) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.ufa
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20058a.c(bVar);
                    }
                });
            } else if (bVar != null) {
                bVar.a(1, false, -1, "empty");
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(1, false, -3, th.toString());
            }
        }
    }

    public void h(final b bVar) {
        try {
            if (!TextUtils.isEmpty(this.f38206a.r.o)) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.mfa
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18188a.d(bVar);
                    }
                });
            } else if (bVar != null) {
                bVar.a(2, false, -1, "empty");
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(2, false, -3, th.toString());
            }
            r.a(th);
        }
    }

    public void i(b bVar) {
        try {
            b().e();
            if (bVar != null) {
                bVar.a(8, true, 0, null);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(8, false, -1, th.toString());
            }
        }
    }

    public void j(b bVar) {
        try {
            b().f();
            if (bVar != null) {
                bVar.a(9, true, 0, null);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(9, false, -1, th.toString());
            }
        }
    }

    public void k(b bVar) {
        try {
            b().g();
            if (bVar != null) {
                bVar.a(7, true, 0, null);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(7, false, -1, th.toString());
            }
        }
    }

    public void a(com.ipd.dsp.internal.c1.b.InterfaceC0865b interfaceC0865b) {
        this.d = interfaceC0865b;
    }

    public boolean e() {
        com.ipd.dsp.internal.c1.b bVarB = b();
        if (bVarB != null) {
            return bVarB.c();
        }
        return true;
    }

    public void a(b bVar, Activity activity) {
        a(3, this.f38206a.r.h, bVar, activity);
    }

    public final void a(final int i, String str, final b bVar, Activity activity) {
        Context contextB;
        if (Dsp.isDebugLogEnable()) {
            k.a(f, "[launch] " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.a(i, false, -1, "empty");
                return;
            }
            return;
        }
        if (!(activity instanceof BaseProxyActivity)) {
            contextB = activity;
            contextB = Dsp.getContext();
        }
        if (contextB == null) {
            contextB = f.a().b();
        }
        if (contextB != null) {
            com.ipd.dsp.internal.h1.a.a(this.b, com.ipd.dsp.internal.h1.a.e.l);
            try {
                final Intent intentA = a(contextB, str);
                if (intentA != null) {
                    final Context context = contextB;
                    Runnable runnable = new Runnable() { // from class: com.zj.adlib.xda
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f20646a.a(context, intentA, bVar, i);
                        }
                    };
                    if (!this.e) {
                        runnable.run();
                        return;
                    } else {
                        new com.ipd.dsp.internal.s1.f(contextB, runnable, new Runnable() { // from class: com.zj.adlib.bfa
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f15510a.a(i, bVar);
                            }
                        }).b();
                        return;
                    }
                }
                a(i, bVar, 2, "not matched");
            } catch (Throwable th) {
                r.a(th);
                a(i, bVar, 3, th.getMessage());
            }
        }
    }

    public void f(final b bVar) {
        try {
            if (!TextUtils.isEmpty(this.f38206a.r.j)) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.ica
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17186a.b(bVar);
                    }
                });
            } else if (bVar != null) {
                bVar.a(1, false, -1, "empty");
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(1, false, -3, th.toString());
            }
        }
    }

    public boolean c() {
        com.ipd.dsp.internal.c1.b bVarB = b();
        if (bVarB != null) {
            return bVarB.b();
        }
        return false;
    }

    public final com.ipd.dsp.internal.c1.b b() {
        if (this.c == null) {
            com.ipd.dsp.internal.c1.b bVarA = c.a(this.f38206a, this.b);
            this.c = bVarA;
            if (bVarA != null) {
                bVarA.a(new C0861a());
            }
        }
        return this.c;
    }

    public boolean d() {
        if (!o.c(this.f38206a.r.h) || a(Dsp.getContext(), this.f38206a.r.h) == null) {
            return o.c(this.f38206a.r.m) && g.a().a(this.f38206a.r.m);
        }
        return true;
    }

    public final /* synthetic */ void a(Context context, Intent intent, b bVar, int i) {
        this.e = false;
        if (context instanceof BaseProxyActivity) {
            ((Activity) context).startActivityForResult(intent, g);
        } else {
            context.startActivity(intent);
        }
        com.ipd.dsp.internal.h1.a.a(this.b, com.ipd.dsp.internal.h1.a.e.m);
        if (bVar != null) {
            bVar.a(i, true, 0, null);
        }
    }

    public final /* synthetic */ void a(int i, b bVar) {
        a(i, bVar, 4, "canceled");
    }

    public final void a(int i, b bVar, int i2, String str) {
        com.ipd.dsp.internal.h1.a.a(this.b, i2, str);
        if (bVar != null) {
            bVar.a(i, false, i2, str);
        }
    }

    public boolean a() {
        d dVar = this.f38206a;
        return dVar != null && o.c(dVar.r.k);
    }

    public void a(b bVar) {
        try {
            b().a((File) null);
            if (bVar != null) {
                bVar.a(15, true, 0, null);
            }
        } catch (Throwable th) {
            if (bVar != null) {
                bVar.a(15, false, -1, th.getMessage());
            }
        }
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            intent.setFlags(268435456);
            if (context.getPackageManager().resolveActivity(intent, 0) == null) {
                return null;
            }
            return intent;
        } catch (Throwable th) {
            r.a(th);
            return null;
        }
    }
}
