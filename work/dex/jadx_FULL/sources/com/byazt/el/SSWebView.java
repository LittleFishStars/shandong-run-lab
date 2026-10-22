package com.byazt.el;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.byazt.nl.uj;
import com.byazt.nr.m;
import com.byazt.nr.zm;
import com.byazt.qg.BizWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 2466})
public class SSWebView extends BizWebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28474a;
    public float da;
    public AtomicBoolean gr;
    public tt gt;
    public AtomicBoolean gu;
    public ve h;
    public float i;
    public float m;
    public JSONObject md;
    public int my;
    public com.byazt.nzi.c n;
    public float nu;
    public JSONObject p;
    public AtomicBoolean qy;
    public int rh;
    public zm rl;
    public long sl;
    public JSONObject sp;
    public long t;
    public long u;
    public boolean x;
    public boolean yp;
    public JSONObject yv;
    public float z;
    public AtomicInteger zm;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 1264})
    public static class c extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }

    public interface tt {
        void c(int i);
    }

    public interface ve {
        void c(MotionEvent motionEvent);

        void c(boolean z);
    }

    public SSWebView(Context context) {
        super(context);
        this.i = 0.0f;
        this.da = 0.0f;
        this.sl = 0L;
        this.t = 0L;
        this.u = 0L;
        this.yp = false;
        this.z = 20.0f;
        this.nu = 50.0f;
        this.qy = new AtomicBoolean();
        this.gu = new AtomicBoolean();
        this.gr = new AtomicBoolean(true);
        this.zm = new AtomicInteger();
    }

    private void a() {
        this.rl = null;
        this.gt = null;
        setTouchStateListener(null);
        O_();
        this.n = null;
        this.sp = null;
        this.x = false;
    }

    private static boolean tt(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            m.c(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable th2) {
            m.c(th2);
            return false;
        }
    }

    private boolean ve(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable th) {
            m.c(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable th2) {
            m.c(th2);
            return false;
        }
    }

    @Override // com.byazt.qg.BizWebView, com.byazt.qg.MultiWebview
    public void M_() {
        a();
        super.M_();
    }

    public boolean N_() {
        zm zmVar = this.rl;
        if (zmVar == null) {
            return false;
        }
        return zmVar.c();
    }

    public void O_() {
        this.gu.set(false);
        zm zmVar = this.rl;
        if (zmVar != null) {
            com.byazt.nzi.c cVar = this.n;
            zmVar.uj(cVar != null ? cVar.c() : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent c(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (tt(view2) || ve(view2)) ? parent : c(view2);
    }

    @Override // com.byazt.qg.BizWebView, com.byazt.qg.MultiWebview, com.byazt.nl.uj
    public void destroy() {
        super.destroy();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ve veVar = this.h;
        if (veVar != null) {
            veVar.c(true);
            this.h.c(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public uj getInnerIWebView() {
        return this.tt;
    }

    public com.byazt.nzi.c getMaterialMeta() {
        return this.n;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.qy.set(true);
        if (this.gu.get()) {
            tt(this.zm.get(), this.gr.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qy.set(false);
        zm zmVar = this.rl;
        if (zmVar != null) {
            com.byazt.nzi.c cVar = this.n;
            zmVar.tt(cVar != null ? cVar.c() : 0);
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentC;
        try {
            c(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.yp && (viewParentC = c((View) this)) != null) {
                viewParentC.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // com.byazt.qg.BizWebView, com.byazt.nl.uj
    public void onPause() {
        super.onPause();
        ve veVar = this.h;
        if (veVar != null) {
            veVar.c(false);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        zm zmVar = this.rl;
        if (zmVar != null) {
            if (z) {
                com.byazt.nzi.c cVar = this.n;
                zmVar.c(cVar != null ? cVar.c() : 0);
            } else {
                com.byazt.nzi.c cVar2 = this.n;
                zmVar.tt(cVar2 != null ? cVar2.c() : 0);
            }
        }
    }

    public void setCalculationMethod(int i) {
        this.rh = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.my = i;
    }

    public void setDeepShakeValue(float f) {
        this.m = f;
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.yp = z;
    }

    public void setLandingPage(boolean z) {
        this.x = z;
    }

    public void setMaterialMeta(com.byazt.nzi.c cVar) {
        this.n = cVar;
    }

    public void setOnShakeListener(tt ttVar) {
        this.gt = ttVar;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.p = jSONObject;
    }

    public void setShakeValue(float f) {
        this.z = f;
    }

    public void setTag(String str) {
        this.f28474a = str;
    }

    public void setTouchStateListener(ve veVar) {
        this.h = veVar;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.yv = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.md = jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.qg.BizWebView, com.byazt.nl.uj
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof ve) {
            setTouchStateListener((ve) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new c();
        }
        super.setWebViewClient(webViewClient);
    }

    public void setWriggleValue(float f) {
        this.nu = f;
    }

    @Override // android.view.View
    public String getTag() {
        return this.f28474a;
    }

    public void c(int i, boolean z) {
        this.gr.set(z);
        this.zm.set(i);
        this.gu.set(true);
        if (this.qy.get()) {
            tt(i, z);
        }
    }

    private void tt(int i, boolean z) {
        zm zmVar = this.rl;
        if (zmVar == null) {
            this.rl = new zm(getContext(), i, z);
        } else {
            zmVar.c(z);
        }
        this.rl.c(this.z);
        this.rl.ve(this.m);
        this.rl.tt(this.nu);
        this.rl.c(this.yv);
        this.rl.ve(this.p);
        this.rl.tt(this.md);
        this.rl.n(this.rh);
        this.rl.a(this.my);
        this.rl.c(new zm.c() { // from class: com.byazt.el.SSWebView.1
            @Override // com.byazt.nr.zm.c
            public void c(int i2) {
                if (i2 == 1) {
                    SSWebView.this.c(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.c(2);
                }
            }
        });
        zm zmVar2 = this.rl;
        com.byazt.nzi.c cVar = this.n;
        zmVar2.ve(cVar != null ? cVar.c() : 0);
    }

    public void c(int i) {
        tt ttVar = this.gt;
        if (ttVar != null) {
            ttVar.c(i);
        }
    }

    private void c(MotionEvent motionEvent) {
        if (!this.x || this.n == null) {
            return;
        }
        if ((this.f28474a == null && this.sp == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.i = motionEvent.getRawX();
                this.da = motionEvent.getRawY();
                this.sl = System.currentTimeMillis();
                this.sp = new JSONObject();
                if (this.tt != null) {
                    this.tt.setTag(2064056319, Long.valueOf(this.sl));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.sp.put("start_x", String.valueOf(this.i));
                this.sp.put("start_y", String.valueOf(this.da));
                this.sp.put("offset_x", String.valueOf(motionEvent.getRawX() - this.i));
                this.sp.put("offset_y", String.valueOf(motionEvent.getRawY() - this.da));
                this.sp.put("url", String.valueOf(getUrl()));
                this.sp.put("tag", "");
                this.t = System.currentTimeMillis();
                if (this.tt != null) {
                    this.tt.setTag(2064056318, Long.valueOf(this.t));
                }
                this.sp.put("down_time", this.sl);
                this.sp.put("up_time", this.t);
                if (com.byazt.vj.c.c().tt() != null) {
                    long j = this.u;
                    long j2 = this.sl;
                    if (j != j2) {
                        this.u = j2;
                        com.byazt.vj.c.c();
                    }
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
