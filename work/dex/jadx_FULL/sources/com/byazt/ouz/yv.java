package com.byazt.ouz;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.aas.cu;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.qp;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.omf.d;
import com.byazt.xv.ThemeStatusBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 499})
public class yv extends com.byazt.ol.c implements yp, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.byazt.pop.ve> f28924a;
    public com.byazt.rbg.c da;
    public com.byazt.xl.i gt;
    public ic i;
    public boolean m;
    public sp my;
    public com.byazt.aas.c nu;
    public long qy;
    public com.byazt.zb.x rh;
    public m rl;
    public String sl;
    public Context sp;
    public com.byazt.ddx.a t;
    public d u;
    public String x;
    public int yp;
    public boolean z;

    public yv(Context context, com.byazt.xl.u uVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.byazt.rbg.c cVar, ic icVar, com.byazt.xl.i iVar, m mVar) {
        super(context, uVar, themeStatusBroadcastReceiver);
        this.f28924a = Collections.synchronizedMap(new HashMap());
        this.yp = 8;
        this.z = true;
        this.m = true;
        this.qy = -1L;
        this.sp = context;
        this.x = uVar.a();
        this.i = icVar;
        this.da = cVar;
        this.c = uVar.n();
        String strC = c(icVar);
        this.sl = strC;
        this.gt = iVar;
        this.rl = mVar;
        c(qp.ve(qp.tt(strC)));
        themeStatusBroadcastReceiver.c(this);
        t();
        u();
        yp();
    }

    private void m() {
        if (this.i == null || this.ve == null) {
            return;
        }
        if (TextUtils.equals(this.x, "rewarded_video") || TextUtils.equals(this.x, "fullscreen_interstitial_ad")) {
            String strRl = this.i.rl();
            if (TextUtils.isEmpty(strRl)) {
                return;
            }
            com.byazt.nl.c.c(strRl, this.ve.getInnerIWebView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        com.byazt.kp.c.c(this.u, this.yp == 0, this.z, this.m);
    }

    private boolean nu() {
        return !TextUtils.isEmpty(this.x) && this.x.equals("splash_ad");
    }

    private void rh() {
        if (this.u == null || ((ViewGroup) this.ve.getParent()) == null) {
            return;
        }
        d dVar = this.u;
        dVar.c(new p(this.ve, dVar, this.i));
    }

    @Override // com.byazt.ouz.z
    public d J_() {
        return this.u;
    }

    @Override // com.byazt.xv.c
    public void b_(int i) {
        if (this.u == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        this.u.tt("themeChange", jSONObject);
    }

    @Override // com.byazt.ol.c
    public void da() {
        super.da();
        com.byazt.aas.c cVar = this.nu;
        if (cVar != null) {
            cVar.tt(this);
        }
    }

    @Override // com.byazt.ol.c
    public void i() {
        com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
        this.nu = cVarVe;
        cVarVe.c(this);
    }

    public void t() {
        if (this.ve == null) {
            return;
        }
        m();
        d dVar = new d(this.sp);
        this.u = dVar;
        dVar.tt(this.ve).c(this.i).tt(this.i.uj()).uj(this.i.w_()).c(this.x).ve(nb.uj(this.x)).n(nb.my(this.i)).c(this).uj(this.c).c(this.rl).c(this.ve).c(this.da);
    }

    public void u() {
        SSWebView sSWebView = this.ve;
        if (sSWebView == null) {
            return;
        }
        sSWebView.setMaterialMeta(cu.c(this.i));
        try {
            this.ve.setBackgroundColor(0);
            this.ve.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        c(this.ve);
        if (c() != null) {
            this.t = new com.byazt.ddx.a(this.i, c()).tt(false);
        }
        this.t.c(this.da);
        this.ve.setWebChromeClient(new com.byazt.jwd.ve(this.u, this.t));
        this.ve.setDownloadListener(new DownloadListener() { // from class: com.byazt.ouz.yv.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (!yv.this.f28924a.containsKey(str)) {
                    com.byazt.pop.ve veVarC = com.byazt.yih.x.c(yv.this.sp, str, yv.this.i, yv.this.x);
                    yv.this.f28924a.put(str, veVarC);
                    veVarC.c(nb.qy(yv.this.i), false);
                } else {
                    com.byazt.pop.ve veVar = (com.byazt.pop.ve) yv.this.f28924a.get(str);
                    if (veVar != null) {
                        veVar.c(nb.qy(yv.this.i), false);
                    }
                }
            }
        });
        if ("rewarded_video".equals(this.x) || "fullscreen_interstitial_ad".equals(this.x)) {
            pf.c((com.byazt.nl.uj) this.ve);
        }
        com.byazt.ol.n.c().c(this.ve, this.u);
    }

    @Override // com.byazt.ol.c, com.byazt.ouz.yp
    public void x() {
        super.x();
        if (this.u == null) {
            return;
        }
        rh();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.u.tt("expressShow", jSONObject);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public void yp() {
        if (this.ve == null || this.rh != null) {
            return;
        }
        com.byazt.vgp.ve veVar = new com.byazt.vgp.ve();
        com.byazt.vgp.uj ujVar = new com.byazt.vgp.uj();
        com.byazt.vgp.n nVar = new com.byazt.vgp.n(this.u);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.i.uj());
            jSONObject.put("log_extra", this.i.w_());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        hashSet.add("sendReward");
        this.rh = veVar.c(com.byazt.omf.gt.getContext(), this.ve, nVar, ujVar, hashSet, com.byazt.dyf.tt.AD_TAG_FEED.equals(this.x) ? com.byazt.zb.x.c.FEED : com.byazt.zb.x.c.OTHER).n(this.sl).uj(com.byazt.fh.c.x()).c(com.byazt.fh.c.c()).n(jSONObject).c("sdkEdition", com.byazt.fh.c.ve()).tt(com.byazt.fh.c.a()).ve(com.byazt.fh.c.n()).ve(false);
        sp spVar = new sp(this.sp, this.u, this.i, this.t, nu(), this.rh, sl());
        this.my = spVar;
        this.ve.setWebViewClient(spVar);
        com.byazt.xl.i iVar = this.gt;
        if (iVar instanceof da) {
            ((da) iVar).c(this.rh);
        }
        Set<String> setDa = this.rh.da();
        if (this.u == null || setDa == null || setDa.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.rh);
        Iterator<String> it = setDa.iterator();
        while (it.hasNext()) {
            this.u.a().c(it.next(), (com.byazt.pct.n<?, ?>) new com.byazt.pct.n<JSONObject, JSONObject>() { // from class: com.byazt.ouz.yv.2
                @Override // com.byazt.pct.n
                public JSONObject c(JSONObject jSONObject2, com.byazt.pct.a aVar) throws Exception {
                    try {
                        com.byazt.zb.x xVar = (com.byazt.zb.x) weakReference.get();
                        if (xVar == null) {
                            return null;
                        }
                        return xVar.uj(c(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    public sp z() {
        return this.my;
    }

    @Override // com.byazt.ol.c
    public void a() {
        d dVar = this.u;
        if (dVar == null) {
            return;
        }
        dVar.tt("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.byazt.ol.c
    public void n() {
        if (c() == null) {
            return;
        }
        try {
            c().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.ol.c
    public void uj() {
        if (this.n.get()) {
            return;
        }
        com.byazt.ddx.a aVar = this.t;
        if (aVar != null) {
            aVar.a();
        }
        SSWebView sSWebView = this.ve;
        if (sSWebView != null) {
            sSWebView.O_();
            this.ve.setOnShakeListener(null);
        }
        d dVar = this.u;
        if (dVar != null) {
            dVar.n();
        }
        super.uj();
        this.f28924a.clear();
        this.u = null;
        com.byazt.zb.x xVar = this.rh;
        if (xVar == null) {
            return;
        }
        xVar.or();
    }

    public static String c(ic icVar) {
        return com.byazt.six.tt.tt(pu.x(icVar) ? "v3" : null);
    }

    @Override // com.byazt.ol.c, com.byazt.ouz.yp
    public void tt(final int i) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.ouz.yv.3
            @Override // java.lang.Runnable
            public void run() {
                yv.this.ve(i);
                yv.this.uj(i);
                if (i == yv.this.yp) {
                    return;
                }
                yv.this.yp = i;
                yv.this.uj(i == 0);
                yv.this.my();
            }
        });
    }

    @Override // com.byazt.ol.c, com.byazt.xl.uj
    public int ve() {
        return pu.tt(this.i);
    }

    public void tt(final boolean z) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.ouz.yv.4
            @Override // java.lang.Runnable
            public void run() {
                yv.this.z = z;
                yv.this.my();
            }
        });
    }

    public void ve(final boolean z) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.ouz.yv.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = yv.this.m;
                boolean z3 = z;
                if (z2 != (!z3)) {
                    yv.this.m = !z3;
                    yv.this.my();
                }
            }
        });
    }

    public static void c(Map<String, Object> map, ic icVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            byte showDLFactorsEventParams = nativeExpressView.getShowDLFactorsEventParams();
            if (showDLFactorsEventParams != -1) {
                map.put("biz_type", Byte.valueOf(showDLFactorsEventParams));
            }
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (pu.a(icVar) != null && !TextUtils.isEmpty(pu.a(icVar).sl())) {
                map.put("engine_version", pu.a(icVar).sl());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(int i) {
        com.byazt.zb.x xVar = this.rh;
        if (xVar == null) {
            return;
        }
        if (i == 0) {
            xVar.tt(true);
            this.rh.c(false);
        } else {
            xVar.tt(false);
            this.rh.c(true);
        }
    }

    private void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.jwd.tt.c(this.sp).c(false).c(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            if (com.byazt.omf.gt.tt().xo()) {
                sSWebView.clearCache(true);
            }
            sSWebView.clearHistory();
            com.byazt.aas.gt.c(sSWebView, com.byazt.omf.p.uj, ic.n(this.i));
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
            com.byazt.nr.m.uj("WebViewRender", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(boolean z) {
        if (this.u == null || this.ve == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.u.tt("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(int i) {
        try {
            if (com.byazt.omf.p.c() && i == 0) {
                long jGk = com.byazt.omf.gt.tt().gk();
                if (this.qy != -1 && System.currentTimeMillis() - this.qy > jGk) {
                    SSWebView sSWebViewC = c();
                    WebView webView = sSWebViewC.getWebView();
                    sSWebViewC.removeView(webView);
                    sSWebViewC.addView(webView);
                }
                this.qy = -1L;
                return;
            }
            this.qy = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.ol.c
    public SSWebView c() {
        return this.ve;
    }

    @Override // com.byazt.ol.c
    public void c(boolean z, int i) {
        super.c(z, i);
        com.byazt.rbg.c cVar = this.da;
        if (cVar != null) {
            cVar.c(z, i);
            this.da.tt(false);
        }
    }

    @Override // com.byazt.ol.c
    public void c(float f, float f2) {
        float f3 = this.sp.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.c(pf.tt(f3, pf.c(f4, f)), pf.tt(f3, pf.c(f4, f2)));
    }
}
