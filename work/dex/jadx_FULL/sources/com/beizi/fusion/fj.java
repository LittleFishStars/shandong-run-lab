package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.splash.SplashUnifiedActionData;
import com.beizi.ad.internal.splash.SplashUnifiedAdResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fj extends k3 {
    private go P;
    private View Q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27301a;

        public a(View view) {
            this.f27301a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f27301a == null) {
                    return;
                }
                fj fjVar = fj.this;
                if (fjVar.P != null && fjVar.c != null) {
                    fj.this.c.f(this.f27301a, fj.this.l);
                    if (fj.this.t) {
                        fj.this.u = true;
                        u3.b().a(fj.this.r);
                    }
                    if (po.c(this.f27301a)) {
                        Log.e("BeiZisAd", "enter BeiZi ad show");
                        fj.this.P.onAdShown();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27302a;

        public b(int i) {
            this.f27302a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            fj.this.P.onAdFailed(this.f27302a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SplashUnifiedAdResponse f27303a;

        public c(SplashUnifiedAdResponse splashUnifiedAdResponse) {
            this.f27303a = splashUnifiedAdResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (fj.this.P != null) {
                Log.e("BeiZisAd", "enter BeiZi ad load");
                fj.this.P.a(this.f27303a);
            }
        }
    }

    public fj(Context context, String str) {
        super(context, str, th.SPLASHUNIFIED);
    }

    public void a(go goVar) {
        this.P = goVar;
    }

    public void a(View view) {
        if (view == null) {
            return;
        }
        try {
            this.Q = view;
            view.post(new a(view));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(SplashUnifiedActionData splashUnifiedActionData) {
        Context context;
        try {
            if (this.P != null && splashUnifiedActionData != null && this.Q != null) {
                int clickType = splashUnifiedActionData.getClickType();
                if (clickType == 10) {
                    if (this.c != null && this.d && (context = this.Q.getContext()) != null) {
                        Intent intent = new Intent(context, (Class<?>) DownloadAppInfoActivity.class);
                        String strJ = this.c.j();
                        String strO = this.c.o();
                        String strN = this.c.n();
                        if (TextUtils.isEmpty(strO)) {
                            strO = strN;
                        }
                        String strP = this.c.p();
                        String strR = this.c.r();
                        intent.putExtra("title_content_key", strJ);
                        intent.putExtra("privacy_content_key", strP);
                        intent.putExtra("permission_content_key", strO);
                        intent.putExtra("intro_content_key", strR);
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        return;
                    }
                    return;
                }
                if (clickType == 20) {
                    this.P.onAdClosed();
                    return;
                }
                on onVar = this.c;
                if (onVar == null) {
                    return;
                }
                onVar.c(true);
                g5 g5Var = new g5();
                if (!TextUtils.isEmpty(splashUnifiedActionData.getDownX())) {
                    g5Var.g(splashUnifiedActionData.getDownX());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getDownY())) {
                    g5Var.h(splashUnifiedActionData.getDownY());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getDownRawX())) {
                    g5Var.e(splashUnifiedActionData.getDownRawX());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getDownRawY())) {
                    g5Var.f(splashUnifiedActionData.getDownRawY());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getUpX())) {
                    g5Var.c(splashUnifiedActionData.getUpX());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getUpY())) {
                    g5Var.d(splashUnifiedActionData.getUpY());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getUpRawX())) {
                    g5Var.a(splashUnifiedActionData.getUpRawX());
                }
                if (!TextUtils.isEmpty(splashUnifiedActionData.getUpRawY())) {
                    g5Var.b(splashUnifiedActionData.getUpRawY());
                }
                this.c.a(this.Q, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.i, this.l, clickType);
                this.i = true;
                this.P.onAdClick();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        if (TextUtils.isEmpty(onVar.c0())) {
            a(3);
            return;
        }
        e(onVar.U());
        a(onVar.c());
        b(onVar.i0());
        SplashUnifiedAdResponse splashUnifiedAdResponse = new SplashUnifiedAdResponse();
        splashUnifiedAdResponse.setImageUrl(onVar.c0());
        on.e eVarH = onVar.H();
        if (eVarH != null) {
            splashUnifiedAdResponse.setIconUrl(eVarH.a());
        }
        on.e eVarH2 = onVar.h();
        if (eVarH2 != null) {
            splashUnifiedAdResponse.setTextUrl(eVarH2.a());
        }
        splashUnifiedAdResponse.setPrice(onVar.U());
        if (onVar.i0()) {
            splashUnifiedAdResponse.setElements("应用名称：" + onVar.j() + " | 开发者：" + onVar.k() + " | 应用版本：" + onVar.q() + " | 权限详情 | 隐私协议 | 功能介绍");
        }
        splashUnifiedAdResponse.setDownloadApp(onVar.i0());
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new c(splashUnifiedAdResponse));
        }
    }
}
