package com.byazt.sy;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.m;
import com.byazt.ete.p;
import com.byazt.omf.d;
import com.byazt.omf.gt;
import com.byazt.xl.yp;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 906})
public class PlayableFeedWebView extends SSWebView implements com.byazt.nl.ve.c, com.byazt.kyz.tt, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f29039a;
    public final ViewGroup da;
    public m gt;
    public m i;
    public final Runnable m;
    public m my;
    public final Context n;
    public com.byazt.zb.x nu;
    public com.byazt.xl.sl rh;
    public double rl;
    public boolean sl;
    public final ic sp;
    public com.byazt.sy.c t;
    public boolean u;
    public com.byazt.kyz.c x;
    public int yp;
    public final Runnable z;

    public PlayableFeedWebView(com.byazt.kyz.c cVar, ViewGroup viewGroup) {
        super(cVar.getContext());
        this.sl = false;
        this.u = false;
        this.yp = 8;
        this.z = new Runnable() { // from class: com.byazt.sy.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.tt(0);
            }
        };
        this.m = new Runnable() { // from class: com.byazt.sy.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.tt(8);
            }
        };
        this.rh = new com.byazt.xl.sl() { // from class: com.byazt.sy.PlayableFeedWebView.3
            @Override // com.byazt.xl.sl
            public void c(View view, int i, com.byazt.sr.ve veVar, int i2) {
                com.byazt.rgb.a.uj(com.byazt.ip.sp.c(PlayableFeedWebView.this.sp));
                PlayableFeedWebView.this.t.c(view, i, veVar, i2);
            }

            @Override // com.byazt.xl.sl
            public void c(yp ypVar) {
            }

            @Override // com.byazt.xl.sl
            public void tt(View view, int i, com.byazt.sr.ve veVar, int i2) {
            }
        };
        this.x = cVar;
        this.n = cVar.getContext();
        this.sp = cVar.c();
        this.da = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    private void da() {
        d dVar = new d(this.n);
        this.f29039a = dVar;
        dVar.tt(this).c(this.sp).tt(this.sp.uj()).uj(this.sp.w_()).c(nb.tt(this.sp)).n(nb.my(this.sp)).c((i) this).uj(com.byazt.jlk.tt.c(0.0f, 0.0f, false, this.sp, true)).c(this.rh).c((SSWebView) this);
    }

    private void i() {
        com.byazt.vgp.ve veVar = new com.byazt.vgp.ve();
        com.byazt.vgp.n nVar = new com.byazt.vgp.n(this.f29039a);
        com.byazt.vgp.uj ujVar = new com.byazt.vgp.uj();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.byazt.zb.x xVarVe = veVar.c(gt.getContext(), this, nVar, ujVar, hashSet, com.byazt.zb.x.c.OTHER).n(getUrl()).uj(com.byazt.fh.c.x()).c(com.byazt.fh.c.c()).c("sdkEdition", com.byazt.fh.c.ve()).tt(com.byazt.fh.c.a()).ve(com.byazt.fh.c.n()).ve(false);
        this.nu = xVarVe;
        Set<String> setDa = xVarVe.da();
        if (this.f29039a == null || setDa == null || setDa.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.nu);
        Iterator<String> it = setDa.iterator();
        while (it.hasNext()) {
            this.f29039a.a().c(it.next(), (com.byazt.pct.n<?, ?>) new com.byazt.pct.n<JSONObject, JSONObject>() { // from class: com.byazt.sy.PlayableFeedWebView.4
                @Override // com.byazt.pct.n
                public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
                    try {
                        com.byazt.zb.x xVar = (com.byazt.zb.x) weakReference.get();
                        if (xVar == null) {
                            return null;
                        }
                        return xVar.uj(c(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    private void sl() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        c((SSWebView) this);
        if (this.sp != null) {
            Context context = this.n;
            d dVar = this.f29039a;
            ic icVar = this.sp;
            setWebViewClient(new c(context, dVar, icVar, icVar.uj()));
        }
        com.byazt.ol.n.c().c(this, this.f29039a);
        setWebChromeClient(new com.byazt.jwd.ve(this.f29039a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        c(Integer.MIN_VALUE, Integer.MIN_VALUE, this.da.getWidth(), this.da.getHeight());
        da();
        i();
        sl();
        loadUrl(p.sp(this.sp).c(this.da.getWidth() <= this.da.getHeight()));
        setExpressVideoListener(this.t);
    }

    @Override // com.byazt.sy.i
    public boolean K_() {
        return this.u;
    }

    @Override // com.byazt.sy.i
    public void L_() {
        if (this.f29039a == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new com.byazt.ouz.p(this, this.f29039a, this.sp));
        if (this.x != null) {
            this.x.c(true, getMaxRectJson());
        }
        tt(getVisibility());
    }

    public void a() {
        this.u = true;
        d dVar = this.f29039a;
        if (dVar != null) {
            dVar.cu();
        }
    }

    @Override // com.byazt.el.SSWebView, com.byazt.qg.BizWebView, com.byazt.qg.MultiWebview, com.byazt.nl.uj
    public void destroy() {
        this.t = null;
        O_();
        setOnShakeListener(null);
        d dVar = this.f29039a;
        if (dVar != null) {
            dVar.n();
            this.f29039a.c((SSWebView.tt) null);
        }
        this.f29039a = null;
        super.destroy();
    }

    @Override // com.byazt.el.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.a.uj(com.byazt.ip.sp.c(this.sp), 2);
    }

    @Override // com.byazt.kyz.tt
    public JSONObject getActualRectJson() {
        return m.c(this.gt);
    }

    @Override // com.byazt.sy.i
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.da.getLeft();
            int top = this.da.getTop();
            jSONArray.put(0, pf.uj(getContext(), left));
            jSONArray.put(1, pf.uj(getContext(), top));
            jSONObject.put(SQLiteMTAHelper.TABLE_POINT, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.da.getMeasuredWidth();
            int measuredHeight = this.da.getMeasuredHeight();
            jSONArray2.put(0, pf.uj(getContext(), measuredWidth));
            jSONArray2.put(1, pf.uj(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.byazt.nr.m.uj("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.byazt.sy.i
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.byazt.sy.i
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.byazt.kyz.c cVar = this.x;
        if (cVar != null) {
            return cVar.tt();
        }
        return null;
    }

    @Override // com.byazt.kyz.tt
    public double getExceedAreaRate() {
        return this.rl;
    }

    public d getJsObject() {
        return this.f29039a;
    }

    @Override // com.byazt.kyz.tt
    public JSONObject getMaxRectJson() {
        return m.c(this.my);
    }

    @Override // com.byazt.qg.BizWebView, com.byazt.nl.uj
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.byazt.el.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        c(i == 0);
    }

    @Override // com.byazt.el.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c(z);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.m);
        removeCallbacks(this.z);
        if (i == 0) {
            postDelayed(this.z, 50L);
        } else {
            postDelayed(this.m, 50L);
        }
    }

    @Override // com.byazt.sy.i
    public void setEasyPlayInteractionAreaInfo(m mVar) {
        this.gt = mVar;
    }

    public void setEasyPlayableListener(com.byazt.sy.c cVar) {
        this.t = cVar;
    }

    public void setExpressVideoListener(com.byazt.ouz.sl slVar) {
        d dVar = this.f29039a;
        if (dVar != null) {
            dVar.c(slVar);
        }
    }

    public void sp() {
        if (this.sl) {
            return;
        }
        this.sl = true;
        postDelayed(new Runnable() { // from class: com.byazt.sy.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    @Override // com.byazt.sy.i
    public void uj() {
        com.byazt.rgb.a.uj(com.byazt.ip.sp.c(this.sp));
        com.byazt.sy.c cVar = this.t;
        if (cVar != null) {
            cVar.c((View) this);
        }
    }

    public void x() {
        c(false);
    }

    @Override // com.byazt.sy.i
    public void c(m mVar, double d) {
        this.my = mVar;
        this.rl = d;
        this.i = mVar;
    }

    @Override // com.byazt.sy.i
    public void tt() {
        com.byazt.rgb.a.uj(com.byazt.ip.sp.c(this.sp), 1);
        com.byazt.kyz.c cVar = this.x;
        if (cVar != null) {
            cVar.ve();
        }
    }

    @Override // com.byazt.sy.i
    public void ve() {
        if (this.x != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, 1);
            } catch (JSONException e) {
                com.byazt.nr.m.tt("xeasy", e.getMessage());
            }
            this.x.c(false, jSONObject);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 528, 548})
    public static class c extends com.byazt.jwd.uj {
        public ic c;

        public c(Context context, d dVar, ic icVar, String str) {
            super(context, dVar, str);
            this.c = icVar;
        }

        @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.byazt.six.c cVarC = com.byazt.jlk.c.c(webView, this.c, str, new com.byazt.jlk.c.InterfaceC0443c() { // from class: com.byazt.sy.PlayableFeedWebView.c.1
                    @Override // com.byazt.jlk.c.InterfaceC0443c
                    public com.byazt.six.c c(String str2, com.byazt.or.da.c cVar, String str3) {
                        com.byazt.six.c cVar2 = new com.byazt.six.c();
                        cVar2.c(5);
                        cVar2.c(com.byazt.tlc.tt.tt().c(webView, cVar, str2));
                        return cVar2;
                    }

                    @Override // com.byazt.jlk.c.InterfaceC0443c
                    public boolean c() {
                        return false;
                    }
                });
                if (cVarC != null && cVarC.c() != null) {
                    return cVarC.c();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.byazt.nr.m.ve("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    @Override // com.byazt.sy.i
    public void c(final int i, final int i2, final int i3, final int i4) {
        com.byazt.bzd.x.c((Runnable) new com.byazt.bwm.sp("changeFrame") { // from class: com.byazt.sy.PlayableFeedWebView.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
                int i5 = i;
                if (i5 == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
                    layoutParams.gravity = 17;
                }
                if (i5 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationX(i5);
                }
                int i6 = i2;
                if (i6 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationY(i6);
                }
                PlayableFeedWebView.this.setLayoutParams(layoutParams);
            }
        });
    }

    public void tt(int i) {
        if (i == this.yp) {
            return;
        }
        this.yp = i;
        if (this.f29039a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adVisible", i == 0);
                this.f29039a.tt("expressAdShow", jSONObject);
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
        com.byazt.kp.c.c(this.f29039a, i == 0, true, true);
    }

    private void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.jwd.tt.c(this.n).c(false).c(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            com.byazt.aas.gt.c(sSWebView, com.byazt.omf.p.uj, ic.n(this.sp));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.byazt.nr.m.uj("xeasy", e.toString());
        }
    }

    public void c(boolean z) {
        d dVar = this.f29039a;
        if (dVar != null) {
            dVar.sl(z);
        }
    }

    @Override // com.byazt.nl.ve.c
    public Pair<Boolean, Boolean> c(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int iUj = pf.uj(getContext(), x);
        int iUj2 = pf.uj(getContext(), y);
        m mVar = this.i;
        if (mVar == null || mVar.c(iUj, iUj2)) {
            return null;
        }
        com.byazt.kyz.c cVar = this.x;
        if (cVar != null) {
            cVar.c(this.sp, iUj, iUj2, 2);
        }
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }
}
