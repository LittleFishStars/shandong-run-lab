package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.ad.v2.activity.BeiZiNewRewardVideoActivity;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class aj extends k3 {
    public static aj S;
    private bj P;
    private boolean Q;
    private String R;

    public class a implements vp.e {
        public a() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a(String str) {
            kh.a("BeiZisAd", "onVideoLoaded: 加载成功");
            aj ajVar = aj.this;
            ajVar.R = str;
            bj bjVar = ajVar.P;
            if (bjVar != null) {
                ajVar.Q = true;
                bjVar.a();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27008a;

        public b(int i) {
            this.f27008a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            aj.this.P.onAdFailedToLoad(this.f27008a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aj.this.N();
        }
    }

    public aj(Context context) {
        super(context, th.REWARDEDVIDEO);
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String strG;
        boolean zO0;
        String strE0;
        try {
            on onVar = this.c;
            if (onVar != null) {
                zO0 = onVar.o0();
                strG = this.c.G();
                strE0 = this.c.e0();
            } else {
                strG = null;
                zO0 = false;
                strE0 = null;
            }
            if (zO0) {
                if (TextUtils.isEmpty(strE0)) {
                    bj bjVar = this.P;
                    if (bjVar != null) {
                        bjVar.onAdFailedToLoad(3);
                        return;
                    }
                    return;
                }
                if (this.P != null) {
                    Log.e("BeiZisAd", "enter BeiZi ad load");
                    this.g = true;
                    this.P.onAdLoaded();
                }
                vp.c().a(this.f27459a, strE0, false, new a());
                return;
            }
            if (TextUtils.isEmpty(strG)) {
                bj bjVar2 = this.P;
                if (bjVar2 != null) {
                    bjVar2.onAdFailedToLoad(3);
                    return;
                }
                return;
            }
            if (this.P != null) {
                this.g = true;
                Log.e("BeiZisAd", "enter BeiZi ad load");
                this.P.onAdLoaded();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String M() {
        return this.R;
    }

    public boolean O() {
        return this.Q;
    }

    public void P() {
        bj bjVar = this.P;
        if (bjVar != null) {
            bjVar.onAdClicked();
        }
    }

    public void Q() {
        on onVar = this.c;
        if (onVar != null) {
            onVar.a(false);
        }
        bj bjVar = this.P;
        if (bjVar != null) {
            bjVar.onAdClosed();
        }
    }

    public void R() {
        bj bjVar = this.P;
        if (bjVar != null) {
            bjVar.b();
        }
    }

    public void S() {
        bj bjVar = this.P;
        if (bjVar != null) {
            bjVar.d();
        }
    }

    public void T() {
        if (this.t) {
            this.u = true;
            u3.b().a(this.r);
        }
        if (this.P != null) {
            Log.e("BeiZisAd", "enter BeiZi ad show");
            this.P.onAdShown();
        }
    }

    public void a(bj bjVar) {
        this.P = bjVar;
    }

    @Override // com.beizi.fusion.k3
    public void d() {
        super.d();
        S = null;
    }

    public void g(String str) {
        bj bjVar = this.P;
        if (bjVar != null) {
            bjVar.a(str);
        }
    }

    public void a(Context context) {
        kh.c("BeiZisAd", "showRewardVideo");
        S = this;
        context.startActivity(new Intent(context, (Class<?>) BeiZiNewRewardVideoActivity.class));
    }

    public void a(String str, int i) {
        bj bjVar = this.P;
        if (bjVar != null) {
            bjVar.a((Map) null);
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
        if (onVar == null) {
            bj bjVar = this.P;
            if (bjVar != null) {
                bjVar.onAdFailedToLoad(3);
                return;
            }
            return;
        }
        e(onVar.U());
        a(onVar.c());
        b(onVar.i0());
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new c());
        }
    }
}
