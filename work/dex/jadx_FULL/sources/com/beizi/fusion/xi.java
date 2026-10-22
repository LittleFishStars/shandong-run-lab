package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.ad.v2.activity.BeiZiNewInterstitialActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xi extends k3 {
    public static xi Q;
    private p1 P;

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28033a;

        public b(int i) {
            this.f28033a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            xi.this.P.a(this.f28033a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xi.this.M();
        }
    }

    public xi(Context context) {
        super(context, th.INTERSTITIAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        String strD;
        boolean zO0;
        String strE0;
        try {
            on onVar = this.c;
            if (onVar != null) {
                zO0 = onVar.o0();
                strD = this.c.D();
                strE0 = this.c.e0();
            } else {
                strD = null;
                zO0 = false;
                strE0 = null;
            }
            if (zO0) {
                if (!TextUtils.isEmpty(strE0)) {
                    vp.c().a(this.f27459a, strE0, false, new a());
                    return;
                }
                p1 p1Var = this.P;
                if (p1Var != null) {
                    p1Var.a(3);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(strD)) {
                p1 p1Var2 = this.P;
                if (p1Var2 != null) {
                    p1Var2.a(3);
                    return;
                }
                return;
            }
            if (this.P != null) {
                this.g = true;
                Log.e("BeiZisAd", "enter BeiZi ad load");
                this.P.c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void N() {
        p1 p1Var = this.P;
        if (p1Var != null) {
            p1Var.a();
        }
    }

    public void O() {
        on onVar = this.c;
        if (onVar != null) {
            onVar.a(false);
        }
        p1 p1Var = this.P;
        if (p1Var != null) {
            p1Var.b();
        }
    }

    public void P() {
        if (this.t) {
            this.u = true;
            u3.b().a(this.r);
        }
        if (this.P != null) {
            Log.e("BeiZisAd", "enter BeiZi ad show");
            this.P.d();
        }
    }

    @Override // com.beizi.fusion.k3
    public void d() {
        super.d();
        Q = null;
    }

    public void g(String str) {
        p1 p1Var = this.P;
        if (p1Var != null) {
            p1Var.a(str);
        }
    }

    public void a(p1 p1Var) {
        this.P = p1Var;
    }

    public void a(Context context) {
        kh.c("BeiZisAd", "showInterstitial");
        Q = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiNewInterstitialActivity.class));
    }

    public class a implements vp.e {
        public a() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a(String str) {
            kh.a("BeiZisAd", "onVideoLoaded: 加载成功");
            xi xiVar = xi.this;
            if (xiVar.P != null) {
                xiVar.g = true;
                Log.e("BeiZisAd", "enter BeiZi ad load");
                xi.this.P.c();
            }
        }

        @Override // com.beizi.fusion.vp.e
        public void a() {
            p1 p1Var = xi.this.P;
            if (p1Var != null) {
                p1Var.a(6);
            }
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(int i) {
        if (this.P == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new b(i));
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(on onVar) {
        e(onVar.U());
        a(onVar.c());
        b(onVar.i0());
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new c());
        }
    }
}
