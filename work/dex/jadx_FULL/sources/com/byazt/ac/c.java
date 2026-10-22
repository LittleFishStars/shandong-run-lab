package com.byazt.ac;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.at.sp;
import com.byazt.ddx.a;
import com.byazt.ddx.da;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.fcd.x;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.omf.cu;
import com.byazt.omf.d;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 89, 20})
public abstract class c {
    public TTBaseVideoActivity c;
    public String da;
    public int gt;
    public da i;
    public int my;
    public AtomicInteger rh;
    public int rl;
    public com.byazt.jwd.uj sl;
    public SSWebView sp;
    public a t;
    public ic tt;
    public boolean uj;
    public String ve;
    public d x;
    public int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28283a = 0;
    public int u = 0;
    public String yp = "";
    public boolean z = false;
    public boolean m = false;
    public final AtomicBoolean nu = new AtomicBoolean(true);
    public AtomicBoolean qy = new AtomicBoolean(false);
    public com.byazt.at.c gu = new com.byazt.at.c() { // from class: com.byazt.ac.c.1
        @Override // com.byazt.at.c
        public int c() {
            SSWebView sSWebView = c.this.sp;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            m.c("TTAndroidObject", "mWebView>>>>height=".concat(String.valueOf(measuredHeight)));
            return measuredHeight <= 0 ? pf.n((Context) c.this.c) : measuredHeight;
        }

        @Override // com.byazt.at.c
        public int tt() {
            SSWebView sSWebView = c.this.sp;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            m.c("TTAndroidObject", "mWebView>>>>width=".concat(String.valueOf(measuredWidth)));
            return measuredWidth <= 0 ? pf.uj((Context) c.this.c) : measuredWidth;
        }
    };
    public sp gr = new sp() { // from class: com.byazt.ac.c.2
        @Override // com.byazt.at.sp
        public void c() {
            SSWebView sSWebView = c.this.sp;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.byazt.at.sp
        public void tt() {
            SSWebView sSWebView = c.this.sp;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };

    public c(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, String str, int i, int i2, boolean z) {
        this.c = tTBaseVideoActivity;
        this.tt = icVar;
        this.ve = str;
        this.my = icVar.by();
        if (gt.tt().qe()) {
            float f = this.c.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.gt = pf.tt(f2, pf.c(f, i));
            this.rl = pf.tt(f2, pf.c(f, i2));
        } else {
            this.gt = i;
            this.rl = i2;
        }
        this.uj = z;
    }

    private void md() {
        if (this.qy.getAndSet(true)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.sp, "translationY", 0.0f, pf.n((Context) this.c));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.ac.c.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                pf.c((View) c.this.sp, 8);
                c.this.qy.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void p() {
        if (this.qy.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.sp, "translationY", pf.n((Context) this.c), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.ac.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    c.this.qy.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
            m.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i, int i2) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.x.tt("resize", jSONObject);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void a() {
        if (this.c.to() instanceof x) {
            md();
        } else {
            pf.c((View) this.sp, 8);
        }
    }

    public abstract void c(DownloadListener downloadListener, com.byazt.hkv.tt ttVar);

    public abstract void c(boolean z, Map<String, Object> map, View view);

    public int da() {
        return this.u;
    }

    public abstract String gr();

    public void gt() {
        da daVar = this.i;
        if (daVar != null) {
            daVar.ve();
            this.i.uj();
        }
    }

    public void gu() {
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            sSWebView.loadUrl("about:blank");
        }
    }

    public void i() {
        this.i = null;
    }

    public void m() {
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.sp.resumeTimers();
            pf.c((View) this.sp, 1.0f);
            yv();
        }
    }

    public void my() {
        da daVar = this.i;
        if (daVar != null) {
            daVar.t();
        }
    }

    public void n() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.c(System.currentTimeMillis());
        }
    }

    public void nu() {
        da daVar = this.i;
        if (daVar != null) {
            daVar.i();
        }
    }

    public boolean qy() {
        return c(this.da);
    }

    public void rh() {
        da daVar = this.i;
        if (daVar != null) {
            daVar.sl();
        }
    }

    public boolean rl() {
        d dVar = this.x;
        if (dVar == null) {
            return false;
        }
        return dVar.gu();
    }

    public String sl() {
        return this.yp;
    }

    public boolean sp() {
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void t() {
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        d dVar = this.x;
        if (dVar != null) {
            dVar.h();
            SSWebView sSWebView2 = this.sp;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.x.a(true);
                    c(true);
                    c(false, true);
                } else {
                    this.x.a(false);
                    c(false);
                    c(true, false);
                }
            }
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.uj();
        }
        com.byazt.jwd.uj ujVar = this.sl;
        if (ujVar != null) {
            ujVar.tt(false);
        }
    }

    public void u() {
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        d dVar = this.x;
        if (dVar != null) {
            dVar.d();
            this.x.a(false);
            c(false);
            c(true, false);
        }
        com.byazt.jwd.uj ujVar = this.sl;
        if (ujVar != null) {
            ujVar.ve();
        }
    }

    public void uj(boolean z) {
    }

    public boolean uj() {
        return this.z;
    }

    public void ve(boolean z) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        try {
            this.x.a(z);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void x() {
        SSWebView sSWebView = this.sp;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.sp.goBack();
    }

    public void yp() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.n();
        }
    }

    public void yv() {
        d dVar = this.x;
        if (dVar == null) {
            return;
        }
        dVar.c(new SSWebView.tt() { // from class: com.byazt.ac.c.6
            @Override // com.byazt.el.SSWebView.tt
            public void c(int i) {
                d dVar2 = c.this.x;
                if (dVar2 != null) {
                    dVar2.c(i);
                }
            }
        });
    }

    public void z() {
        d dVar = this.x;
        if (dVar != null) {
            dVar.eo();
        }
        da daVar = this.i;
        if (daVar != null) {
            daVar.c(true);
            this.i.m();
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.a();
        }
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            cu.c(this.c, sSWebView);
            cu.c(this.sp);
            this.sp.destroy();
        }
        this.sp = null;
    }

    public void zm() {
    }

    public void c() {
        SSWebView sSWebView = this.sp;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ac.c.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SSWebView sSWebView2 = c.this.sp;
                    if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                        return;
                    }
                    c.this.sp.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = c.this.sp.getMeasuredWidth();
                    int measuredHeight = c.this.sp.getMeasuredHeight();
                    if (c.this.sp.getVisibility() == 0) {
                        c.this.tt(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    public boolean ve() {
        if (!qy()) {
            return false;
        }
        AtomicInteger atomicInteger = this.rh;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.nu.get();
        }
        return true;
    }

    public void c(boolean z) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.x.tt("viewableChange", jSONObject);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void tt(boolean z) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.x.tt("volumeChange", jSONObject);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void c(boolean z, boolean z2) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.x.tt("endcard_control_event", jSONObject);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public boolean tt() {
        return this.m;
    }

    public void c(int i, int i2) {
        if (this.x == null || this.c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.x.ve("showDownloadStatus", jSONObject);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void c(long j, long j2, int i) {
        if (j2 > 0) {
            c(i, (int) ((j * 100) / j2));
        }
    }

    public void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.byazt.jwd.tt.c(this.c).c(false).tt(false).c(sSWebView);
        com.byazt.aas.gt.c(sSWebView, p.uj, ic.n(this.tt));
        pf.c((com.byazt.nl.uj) sSWebView);
        sSWebView.setMixedContentMode(0);
        com.byazt.nl.c.c(this.tt.rl(), this.sp.getInnerIWebView());
    }

    public void c(int i) {
        pf.c((View) this.sp, 0);
        if (i == 1) {
            pf.c((View) this.sp, 0.0f);
        }
        if (i == 2) {
            p();
        }
        d dVar = this.x;
        if (dVar != null) {
            dVar.c(this.c.my());
            this.x.c(nb.my(this.tt), false);
        }
    }

    public void c(Map<String, Object> map) {
        da daVar = this.i;
        if (daVar != null) {
            daVar.da();
        }
    }

    public void c(boolean z, int i, String str) {
        da daVar = this.i;
        if (daVar == null) {
            return;
        }
        if (z) {
            daVar.tt();
        } else {
            daVar.c(i, str);
        }
    }

    private boolean c(String str) {
        try {
            new URL(str);
            return URLUtil.isValidUrl(str) && Patterns.WEB_URL.matcher(str).matches();
        } catch (Exception unused) {
        }
    }

    public void c(JSONObject jSONObject) {
        d dVar = this.x;
        if (dVar == null) {
            m.uj("BaseEndCard", "mJsObject is null!");
        } else {
            dVar.tt("showPlayAgainEntrance", jSONObject);
        }
    }

    public void c(ic icVar) {
        this.tt = icVar;
        this.z = false;
    }
}
