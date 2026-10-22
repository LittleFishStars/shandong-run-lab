package com.byazt.ol;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.el.SSWebView;
import com.byazt.nr.yp;
import com.byazt.xl.sl;
import com.byazt.xl.sp;
import com.byazt.xl.u;
import com.byazt.xl.x;
import com.byazt.xv.ThemeStatusBroadcastReceiver;
import com.bytedance.component.sdk.annotation.UiThread;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 41, 20})
public abstract class c implements com.byazt.sr.c, com.byazt.xv.c, sl, com.byazt.xl.uj<SSWebView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f28872a;
    public JSONObject c;
    public boolean da;
    public volatile sp i;
    public x sl;
    public String sp;
    public u t;
    public boolean tt;
    public boolean u;
    public SSWebView ve;
    public String x;
    public int yp;
    public int uj = 8;
    public AtomicBoolean n = new AtomicBoolean(false);
    public boolean z = false;

    public c(Context context, u uVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.da = false;
        this.f28872a = context;
        this.t = uVar;
        this.sp = uVar.a();
        themeStatusBroadcastReceiver.c(this);
        if (com.byazt.sr.uj.c()) {
            t();
            return;
        }
        SSWebView sSWebViewU = u();
        this.ve = sSWebViewU;
        if (sSWebViewU != null) {
            this.da = true;
        } else if (com.byazt.sr.uj.getContext() != null) {
            this.ve = new SSWebView(com.byazt.sr.uj.getContext());
        }
    }

    private void t() {
        if (this.f28872a == null && com.byazt.sr.uj.getContext() != null) {
            this.f28872a = com.byazt.sr.uj.getContext();
        }
        if (this.f28872a != null) {
            SSWebView sSWebViewU = u();
            this.ve = sSWebViewU;
            if (sSWebViewU == null) {
                this.ve = new SSWebView(new MutableContextWrapper(this.f28872a.getApplicationContext()));
            } else {
                this.da = true;
            }
        }
    }

    private SSWebView u() {
        return this.t.zm() ? n.c().c(this.f28872a, this.sp) : n.c().tt(this.f28872a, this.sp);
    }

    private void yp() {
        if (this.t.zm()) {
            n.c().tt(this.ve);
        } else {
            n.c().ve(this.ve);
        }
    }

    public abstract void a();

    public void c(String str) {
        this.x = str;
    }

    public void c(boolean z, int i) {
    }

    public void da() {
    }

    public void i() {
    }

    public void n() {
        if (c() == null) {
            return;
        }
        try {
            c().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public u sl() {
        return this.t;
    }

    @Override // com.byazt.xl.uj
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public SSWebView sp() {
        return c();
    }

    public abstract void tt(int i);

    public void uj() {
        if (this.n.get()) {
            return;
        }
        this.n.set(true);
        a();
        if (this.ve.getParent() != null) {
            ((ViewGroup) this.ve.getParent()).removeView(this.ve);
        }
        if (this.tt) {
            yp();
        } else {
            n.c().n(this.ve);
        }
    }

    @Override // com.byazt.xl.uj
    public int ve() {
        return 0;
    }

    public void x() {
        i();
        Activity activityC = com.byazt.nr.tt.c(this.ve);
        if (activityC != null) {
            this.yp = tt(activityC);
        }
    }

    public SSWebView c() {
        return this.ve;
    }

    @Override // com.byazt.xl.sl
    public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
        x xVar = this.sl;
        if (xVar != null) {
            xVar.tt(view, i, veVar, i2);
        }
    }

    public void c(x xVar) {
        this.sl = xVar;
    }

    private int tt(Activity activity) {
        return activity.hashCode();
    }

    @Override // com.byazt.xl.uj
    public void c(sp spVar) {
        this.i = spVar;
        if (c() != null && c().getWebView() != null) {
            if (TextUtils.isEmpty(this.x)) {
                this.i.c(102, "url is empty");
                return;
            }
            if (!this.t.zm()) {
                if (!this.z && !com.byazt.six.tt.c(this.c)) {
                    sp spVar2 = this.i;
                    StringBuilder sb = new StringBuilder("data null is ");
                    sb.append(this.c == null);
                    spVar2.c(103, sb.toString());
                    return;
                }
                if (this.z && !com.byazt.six.tt.ve(this.c)) {
                    sp spVar3 = this.i;
                    StringBuilder sb2 = new StringBuilder("choice ad data null is ");
                    sb2.append(this.c == null);
                    spVar3.c(103, sb2.toString());
                    return;
                }
            } else if (ve() == 9 && !com.byazt.six.tt.tt(this.c)) {
                sp spVar4 = this.i;
                StringBuilder sb3 = new StringBuilder("data null is ");
                sb3.append(this.c == null);
                spVar4.c(103, sb3.toString());
                return;
            }
            this.t.sp().tt(this.da);
            if (this.da) {
                try {
                    this.ve.clearView();
                    this.t.sp().sp();
                    yp.c(this.ve.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception e) {
                    n.c().n(this.ve);
                    this.i.c(102, "load exception is " + e.getMessage());
                    return;
                }
            }
            SSWebView sSWebViewC = c();
            sSWebViewC.clearView();
            this.t.sp().sp();
            sSWebViewC.loadUrl(this.x);
            return;
        }
        sp spVar5 = this.i;
        StringBuilder sb4 = new StringBuilder("SSWebview null is ");
        sb4.append(c() == null);
        sb4.append(" or Webview is null");
        spVar5.c(102, sb4.toString());
    }

    public void c(boolean z) {
        this.u = z;
    }

    @Override // com.byazt.xl.sl
    public void c(final com.byazt.xl.yp ypVar) {
        if (ypVar == null) {
            if (this.i != null) {
                this.i.c(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zVe = ypVar.ve();
        final float fUj = (float) ypVar.uj();
        final float fN = (float) ypVar.n();
        if (ve() == 0 && (fUj <= 0.0f || fN <= 0.0f)) {
            if (this.i != null) {
                this.i.c(105, "width is " + fUj + "height is " + fN);
                return;
            }
            return;
        }
        this.tt = zVe;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(ypVar, fUj, fN);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.ol.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(ypVar, fUj, fN);
                }
            });
        }
    }

    public void c(com.byazt.xl.yp ypVar, float f, float f2) {
        c(this.tt, ypVar.sl());
        boolean z = this.tt;
        if (z && !this.u) {
            c(f, f2);
            tt(this.uj);
            if (this.i != null) {
                this.i.c(c(), ypVar);
                return;
            }
            return;
        }
        if (!z) {
            n.c().n(this.ve);
        }
        c(ypVar.sl(), ypVar.da());
    }

    @Override // com.byazt.xl.sl
    public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
        x xVar = this.sl;
        if (xVar != null) {
            xVar.c(view, i, veVar, i2);
        }
    }

    @UiThread
    public void c(float f, float f2) {
        this.t.sp().x();
        if (com.byazt.sr.uj.c() && ve() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            c().setLayoutParams(layoutParams);
            return;
        }
        int iC = (int) com.byazt.or.x.c(this.f28872a, f);
        int iC2 = (int) com.byazt.or.x.c(this.f28872a, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) c().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iC, iC2);
        }
        layoutParams2.width = iC;
        layoutParams2.height = iC2;
        c().setLayoutParams(layoutParams2);
    }

    private void c(int i, String str) {
        if (this.i != null) {
            this.i.c(i, str);
        }
    }

    @Override // com.byazt.sr.c
    public void c(Activity activity) {
        if (this.yp == 0 || activity == null || activity.hashCode() != this.yp) {
            return;
        }
        uj();
        da();
    }
}
