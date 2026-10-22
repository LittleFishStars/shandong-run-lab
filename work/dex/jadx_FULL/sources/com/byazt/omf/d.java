package com.byazt.omf;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.dna.qp;
import com.byazt.el.SSWebView;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.qx.aw;
import com.byazt.qx.bm;
import com.byazt.qx.bx;
import com.byazt.qx.hd;
import com.byazt.qx.l;
import com.byazt.qx.lr;
import com.byazt.qx.sv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.y6b;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 512})
public class d implements com.byazt.ol.tt, qp.c, com.byazt.nt.ve {
    public static volatile boolean kp;
    public static final Map<String, Boolean> ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f28877a;
    public boolean aw;
    public boolean bx;
    public Map<String, Object> c;
    public com.byazt.pct.nu cu;
    public HashMap<String, i> d;
    public String da;
    public WeakReference<com.byazt.bd.c> gr;
    public JSONObject gt;
    public WeakReference<com.byazt.at.n> gu;
    public List<ic> h;
    public WeakReference<View> i;
    public com.byazt.xs.tt l;
    public JSONObject lo;
    public com.byazt.sgn.sp.c lr;
    public WeakReference<com.byazt.ux.tt> lt;
    public WeakReference<com.byazt.at.sp> md;
    public com.byazt.jwd.c nb;
    public com.byazt.rbg.c or;
    public WeakReference<com.byazt.at.ve> p;
    public List<JSONObject> pu;
    public AtomicBoolean q;
    public String qp;
    public WeakReference<com.byazt.at.c> qy;
    public SoftReference<com.byazt.xl.sl> rh;
    public WeakReference<com.byazt.nt.n> rl;
    public int sl;
    public com.byazt.nt.uj sp;
    public String t;
    public WeakReference<com.byazt.sy.i> tk;
    public WeakReference<com.byazt.ouz.m> to;
    public ic u;
    public WeakReference<SSWebView> uj;
    public WeakReference<com.byazt.at.a> v;
    public String x;
    public String yp;
    public WeakReference<com.byazt.at.tt> yv;
    public JSONObject zm;
    public boolean tt = false;
    public boolean z = false;
    public boolean m = true;
    public boolean nu = true;
    public final com.byazt.ouz.t my = new com.byazt.ouz.t();
    public boolean eo = false;
    public boolean zb = false;
    public boolean pf = false;
    public boolean sv = false;
    public boolean ic = false;
    public boolean hd = false;
    public boolean bm = false;
    public byte b = -1;
    public final AtomicBoolean kk = new AtomicBoolean(false);
    public final Map<String, com.byazt.pop.ve> tx = new ConcurrentHashMap();
    public com.byazt.nr.d n = new com.byazt.nr.d(Looper.getMainLooper(), this);

    @com.byazt.zqa.c(c = {0, 1, 31, 114})
    public static class c {
        public String c;
        public int n;
        public String tt;
        public JSONObject uj;
        public String ve;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ve = concurrentHashMap;
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put("log_event", bool);
        concurrentHashMap.put("private", bool);
        concurrentHashMap.put("dispatch_message", bool);
        concurrentHashMap.put("custom_event", bool);
        concurrentHashMap.put("log_event_v3", bool);
        kp = false;
    }

    public d(Context context) {
        this.f28877a = new WeakReference<>(context);
        nb.a();
    }

    private JSONObject aw() {
        try {
            View view = this.i.get();
            SSWebView sSWebView = this.uj.get();
            if (view == null || sSWebView == null) {
                com.byazt.nr.m.uj("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            }
            int[] iArrTt = pf.tt(view);
            int[] iArrTt2 = pf.tt(sSWebView);
            if (iArrTt != null && iArrTt2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", pf.uj(gt.getContext(), iArrTt[0] - iArrTt2[0]));
                jSONObject.put("y", pf.uj(gt.getContext(), iArrTt[1] - iArrTt2[1]));
                jSONObject.put("w", pf.uj(gt.getContext(), view.getWidth()));
                jSONObject.put(y6b.g, pf.uj(gt.getContext(), view.getHeight()));
                jSONObject.put("isExist", true);
                return jSONObject;
            }
            com.byazt.nr.m.uj("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
            return null;
        } catch (Throwable unused) {
        }
    }

    private void bm() {
        WeakReference<com.byazt.at.sp> weakReference = this.md;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.md.get().tt();
    }

    private void bx() {
        ic icVar;
        WeakReference<SSWebView> weakReference = this.uj;
        if (weakReference == null || weakReference.get() == null || (icVar = this.u) == null) {
            return;
        }
        int iGe = icVar.ge();
        int iTw = this.u.tw();
        int iBr = this.u.br();
        int iE = this.u.e();
        int iPe = this.u.pe();
        JSONObject jSONObjectLv = this.u.lv();
        JSONObject jSONObjectCy = this.u.cy();
        JSONObject jSONObjectYx = this.u.yx();
        this.uj.get().setShakeValue(iGe);
        this.uj.get().setDeepShakeValue(iTw);
        this.uj.get().setWriggleValue(iBr);
        this.uj.get().setTwistConfig(jSONObjectLv);
        this.uj.get().setShakeInteractConf(jSONObjectCy);
        this.uj.get().setTwistInteractConf(jSONObjectYx);
        this.uj.get().setCalculationMethod(iE);
        this.uj.get().setCalculationTwistMethod(iPe);
    }

    private void hd() {
        WeakReference<com.byazt.at.sp> weakReference = this.md;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.md.get().c();
    }

    private static List<String> ic() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void l() {
        hq hqVarA_;
        Context context;
        ic icVar = this.u;
        if (icVar != null && (hqVarA_ = icVar.A_()) != null && hqVarA_.tt() == 1 && hqVarA_.a() == 1) {
            lt();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.f28877a;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.sp.c(context, jSONObject, this.da, this.sl, this.z, true);
            c(jSONObject, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo() {
        Context context;
        List<ic> list = this.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.uj;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.f28877a;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (ic icVar : this.h) {
            this.d.put(icVar.uj(), new i(context, icVar, sSWebView, this.qp));
        }
    }

    private JSONObject lr() {
        return c(this.u, this.q);
    }

    private void lt() {
        if (this.sp == null) {
            this.sp = com.byazt.nt.tt.c(this, this.u, this.ic);
        }
    }

    private boolean pf() {
        return x.m().hd();
    }

    private boolean pu() {
        ic icVar = this.u;
        if (icVar == null || icVar.jm() == null || com.byazt.aas.rl.tt(this.u) || this.eo || this.u.jm().optInt("parent_type") != 2) {
            return false;
        }
        int iSl = nb.sl(this.u);
        if (iSl != 8 && iSl != 7) {
            return false;
        }
        this.eo = true;
        return true;
    }

    private com.byazt.nl.uj sv() {
        WeakReference<SSWebView> weakReference = this.uj;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean to() {
        return this.tk != null;
    }

    private void z(JSONObject jSONObject) {
        WeakReference<com.byazt.at.tt> weakReference = this.yv;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.yv.get().c(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    public com.byazt.pct.nu a() {
        return this.cu;
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = u();
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject, nb.sl(this.u));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.d.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.a(new JSONObject(str));
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        });
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.d.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.i(new JSONObject(str));
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        });
    }

    public void cu() {
        WeakReference<com.byazt.at.a> weakReference = this.v;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.v.get().c();
    }

    public void d() {
        com.byazt.nt.uj ujVar = this.sp;
        if (ujVar != null) {
            ujVar.tt();
        }
        this.sv = false;
    }

    public WeakReference<com.byazt.at.n> da() {
        return this.gu;
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            sl(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    public void eo() {
        n();
        com.byazt.nt.uj ujVar = this.sp;
        if (ujVar != null) {
            ujVar.ve();
        }
        for (com.byazt.pop.ve veVar : this.tx.values()) {
            if (veVar != null) {
                veVar.ve();
            }
        }
        this.tx.clear();
        WeakReference<SSWebView> weakReference = this.uj;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.i;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.f28877a;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.nb = null;
        this.l = null;
    }

    public Context getContext() {
        return this.f28877a.get();
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        m(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.gt.toString();
        }
        try {
            JSONObject jSONObjectC = com.byazt.jlk.tt.c(this.gt, new JSONObject(str));
            return jSONObjectC == null ? this.gt.toString() : jSONObjectC.toString();
        } catch (Exception unused) {
            return this.gt.toString();
        }
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public String getTemplateInfo() {
        tt("getTemplateInfo", true);
        try {
            z();
            tt("getTemplateInfo", false);
            return this.gt.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean gr() {
        ic icVar = this.u;
        return icVar != null && com.byazt.ete.gt.sl(icVar) == 1;
    }

    public void gt() {
        WeakReference<com.byazt.bd.c> weakReference = this.gr;
        if (weakReference == null || weakReference.get() == null) {
            this.my.da();
        } else {
            this.gr.get().c();
        }
    }

    public boolean gu() {
        return this.pf;
    }

    public void h() {
        com.byazt.nt.uj ujVar = this.sp;
        if (ujVar != null) {
            ujVar.c();
        }
        if (pu()) {
            rl();
        }
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof c) {
                try {
                    c((c) obj, 1);
                } catch (Exception unused) {
                }
            }
        }
    }

    public boolean i() {
        ic icVar = this.u;
        return icVar != null && icVar.nt();
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.omf.d.10
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.nb != null) {
                    com.byazt.jwd.c unused = d.this.nb;
                }
            }
        });
    }

    public void m() {
        com.byazt.ukr.yp.c().uj(this.u, "stats_reward_full_deal_skip_video");
        this.my.a();
    }

    public String md() {
        return nb.c(this.sl);
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.d.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.n(new JSONObject(str));
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                }
            }
        });
    }

    public void my() {
        this.my.n();
    }

    public byte nb() {
        return this.b;
    }

    public void nu() {
        this.my.sp();
    }

    public int or() {
        if (this.my.sl() == null) {
            return 0;
        }
        return this.my.sl().ve();
    }

    public JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        ic icVar = this.u;
        if (icVar == null) {
            return jSONObject;
        }
        String strFv = icVar.fv();
        if (TextUtils.isEmpty(strFv)) {
            return jSONObject;
        }
        try {
            return new JSONObject(strFv);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return jSONObject;
        }
    }

    public void qp() {
        if (this.my.sl() != null) {
            this.my.sl().x();
        }
    }

    public void qy() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", c(this.h));
            tt("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            da(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void reportJsbBridgeMissing(String str) {
        if (this.kk.compareAndSet(false, true)) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt(MediationConstant.KEY_REASON, jSONObject2.optString(MediationConstant.KEY_REASON));
                    jSONObject.putOpt("msg_type", jSONObject2.optString("msg_type"));
                    jSONObject.putOpt("event_id", jSONObject2.optString("event_id"));
                }
                jSONObject.putOpt("tag", this.qp);
                com.byazt.nl.uj ujVarSv = sv();
                if (ujVarSv != null) {
                    jSONObject.putOpt("url", ujVarSv.getUrl());
                }
            } catch (Throwable unused) {
            }
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.omf.d.11
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() {
                    com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("jsb_bridge_missing");
                    ttVarC.tt(jSONObject.toString());
                    if (d.this.u != null) {
                        ttVarC.a(d.this.u.qy());
                    }
                    return ttVarC;
                }
            }, "jsb_bridge_missing");
        }
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.my.c(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.byazt.ukr.yp.c().c(this.u, jSONObject2);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public void rh() {
        this.my.uj();
    }

    public void rl() {
        c((JSONObject) null, new com.byazt.at.uj() { // from class: com.byazt.omf.d.2
            @Override // com.byazt.at.uj
            public void c(boolean z, List<ic> list, boolean z2) {
                d.this.h = list;
                d.this.lo();
                d.this.qy();
            }
        });
    }

    @Override // com.byazt.ol.tt
    @JavascriptInterface
    public void skipVideo() {
        com.byazt.ukr.yp.c().uj(this.u, "stats_reward_full_call_skip_video");
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.d.9
            @Override // java.lang.Runnable
            public void run() {
                d.this.m();
            }
        });
    }

    public boolean sl() {
        return this.tt;
    }

    public boolean sp() {
        return this.hd;
    }

    public JSONObject t() {
        return this.lo;
    }

    public JSONObject u() throws Exception {
        return com.byazt.jlk.tt.c(this.u, this.yp);
    }

    public void x(boolean z) {
        this.bm = z;
    }

    public void yp() {
        WeakReference<com.byazt.at.ve> weakReference = this.p;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.p.get().c();
    }

    public void yv() {
        ic icVar = this.u;
        if (icVar == null) {
            return;
        }
        com.byazt.aas.n.ve(icVar, this.f28877a.get(), md());
    }

    public void zb() {
        WeakReference<com.byazt.at.n> weakReference = this.gu;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.gu.get().c();
    }

    public void zm() {
        ic icVar = this.u;
        if (icVar == null) {
            return;
        }
        com.byazt.aas.n.tt(icVar, this.f28877a.get(), md());
    }

    private void my(JSONObject jSONObject) {
        WeakReference<com.byazt.nt.n> weakReference;
        com.byazt.nt.n nVar;
        if (jSONObject == null || (weakReference = this.rl) == null || (nVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                nVar.c(false, null);
            } else {
                nVar.c(true, jSONArrayOptJSONArray);
            }
        } catch (Exception unused) {
            nVar.c(false, null);
        }
    }

    private int nu(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("forceShowDownloadDialog", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rh(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(JSONObject jSONObject) {
        com.byazt.nl.uj ujVarSv = sv();
        if (ujVarSv != null) {
            com.byazt.nr.yp.c(ujVarSv, "javascript:(function(){var __msg=" + jSONObject.toString() + ";var b=window.ToutiaoJSBridge;if(b&&typeof b._handleMessageFromToutiao==='function'){b._handleMessageFromToutiao(__msg);}else{var r=b?'handle_not_function':'bridge_null';var g=window.SDK_INJECT_GLOBAL;if(g&&typeof g.reportJsbBridgeMissing==='function'){g.reportJsbBridgeMissing(JSON.stringify({reason:r,msg_type:__msg.__msg_type,event_id:__msg.__event_id}));}}})();");
        }
    }

    public d a(boolean z) {
        this.zb = z;
        return this;
    }

    public void da(final JSONObject jSONObject) {
        com.byazt.rbg.c cVar = this.or;
        if (cVar != null) {
            cVar.ve(jSONObject);
        }
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("renderDidFinish") { // from class: com.byazt.omf.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i;
                double dOptDouble;
                double dOptDouble2;
                boolean z;
                double d;
                double d2;
                double d3;
                double d4;
                double d5;
                if (d.this.rh == null || d.this.rh.get() == null || jSONObject == null || d.this.f28877a == null) {
                    return;
                }
                com.byazt.xl.yp ypVar = new com.byazt.xl.yp();
                ypVar.c(1);
                try {
                    boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
                    if (jSONObjectOptJSONObject != null) {
                        dOptDouble = jSONObjectOptJSONObject.optDouble("width");
                        dOptDouble2 = jSONObjectOptJSONObject.optDouble("height");
                    } else {
                        dOptDouble = AudioStats.AUDIO_AMPLITUDE_NONE;
                        dOptDouble2 = 0.0d;
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (jSONObjectOptJSONObject2 != null) {
                        float f = ((Context) d.this.f28877a.get()).getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                        z = zOptBoolean;
                        double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                        d2 = dOptDouble2;
                        double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                        double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                        if (d.this.rh(jSONObjectOptJSONObject2)) {
                            d = dOptDouble;
                            double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft");
                            d4 = dOptDouble6;
                            double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight");
                            d5 = dOptDouble5;
                            double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft");
                            d3 = dOptDouble4;
                            double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight");
                            if (gt.tt().qe()) {
                                ypVar.c(pf.tt(f, pf.c(f2, (float) dOptDouble7)));
                                ypVar.tt(pf.tt(f, pf.c(f2, (float) dOptDouble8)));
                                ypVar.ve(pf.tt(f, pf.c(f2, (float) dOptDouble9)));
                                ypVar.uj(pf.tt(f, pf.c(f2, (float) dOptDouble10)));
                            } else {
                                ypVar.c((float) dOptDouble7);
                                ypVar.tt((float) dOptDouble8);
                                ypVar.ve((float) dOptDouble9);
                                ypVar.uj((float) dOptDouble10);
                            }
                        } else {
                            d3 = dOptDouble4;
                            d4 = dOptDouble6;
                            d = dOptDouble;
                            d5 = dOptDouble5;
                        }
                        if (gt.tt().qe()) {
                            ypVar.ve(pf.tt(f, pf.c(f2, (float) dOptDouble3)));
                            ypVar.uj(pf.tt(f, pf.c(f2, (float) d3)));
                            ypVar.n(pf.tt(f, pf.c(f2, (float) d5)));
                            ypVar.a(pf.tt(f, pf.c(f2, (float) d4)));
                        } else {
                            ypVar.ve(dOptDouble3);
                            ypVar.uj(d3);
                            ypVar.n(d5);
                            ypVar.a(d4);
                        }
                    } else {
                        z = zOptBoolean;
                        d = dOptDouble;
                        d2 = dOptDouble2;
                    }
                    try {
                        String strOptString = jSONObject.optString("msg", sp.c(101));
                        int iOptInt = jSONObject.optInt("code", 101);
                        ypVar.c(z);
                        ypVar.c(d);
                        ypVar.tt(d2);
                        ypVar.c(strOptString);
                        ypVar.tt(iOptInt);
                        ((com.byazt.xl.sl) d.this.rh.get()).c(ypVar);
                    } catch (Exception unused) {
                        i = 101;
                        ypVar.tt(i);
                        ypVar.c(sp.c(i));
                        ((com.byazt.xl.sl) d.this.rh.get()).c(ypVar);
                    }
                } catch (Exception unused2) {
                    i = 101;
                }
            }
        });
    }

    public void i(boolean z) {
        this.tt = z;
    }

    public int n(boolean z) {
        if (!this.sv && com.byazt.ete.cu.c(this.u) != 0 && z) {
            return 2;
        }
        if (this.bx) {
            return 1;
        }
        if (this.aw) {
            return com.byazt.ete.cu.c(this.u) == 2 ? 2 : 1;
        }
        return com.byazt.ete.cu.c(this.u) == 0 ? 1 : 2;
    }

    public void sl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.byazt.aas.gt.c(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    public void sp(boolean z) {
        this.hd = z;
    }

    public boolean t(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", c(this.h));
        } catch (Exception unused) {
        }
        return true;
    }

    public JSONObject u(JSONObject jSONObject) {
        com.byazt.dj.tt ttVarIj;
        if (this.c != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                if (p.x()) {
                    try {
                        ic icVar = this.u;
                        if (icVar != null && (ttVarIj = icVar.ij()) != null) {
                            String strU = ttVarIj.u();
                            if (!TextUtils.isEmpty(strU)) {
                                jSONObject2.putOpt("media_extra", strU);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            } catch (Exception e) {
                com.byazt.nr.m.ve(e.toString());
            }
        }
        return jSONObject;
    }

    public boolean uj() {
        WeakReference<SSWebView> weakReference = this.uj;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.uj.get().N_();
    }

    public com.byazt.sy.i ve() {
        WeakReference<com.byazt.sy.i> weakReference = this.tk;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public ic x() {
        return this.u;
    }

    private boolean m(JSONObject jSONObject) {
        if (this.my.sl() != null && jSONObject != null) {
            double dC = this.my.sl().c();
            int iTt = this.my.sl().tt();
            try {
                jSONObject.put("currentTime", dC / 1000.0d);
                jSONObject.put("state", iTt);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void a(JSONObject jSONObject) {
        if (this.my.sl() == null || jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("stateType", -1);
            this.my.sl().c(iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", iOptInt);
            com.byazt.ukr.yp.c().c(this.u, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void i(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        double d7;
        double d8;
        SoftReference<com.byazt.xl.sl> softReference;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            String strOptString3 = jSONObject.optString("clickAreaId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            String strOptString4 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject2 = new JSONObject();
            com.byazt.ete.nu.c(jSONObject.optString("clickScene"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject2.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                d9 = dOptDouble2;
                d = dOptDouble3;
                d2 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble8;
                d5 = dOptDouble9;
                d6 = dOptDouble10;
                d7 = dOptDouble4;
                d8 = dOptDouble5;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                dOptDouble = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            com.byazt.ete.gr grVarC = new com.byazt.ete.gr.c().uj((float) d9).ve((float) d).tt((float) d7).c((float) d8).tt((long) d2).c((long) d3).c((int) d4).tt((int) d5).ve((int) d6).uj((int) dOptDouble).c(strOptString2).tt(strOptString3).c(true).c((SparseArray<com.byazt.hkv.uj.c>) null).c(jSONObject2).n(strOptString4).n(iOptInt2).c();
            if (!c(strOptString, iOptInt, grVarC) && (softReference = this.rh) != null && softReference.get() != null) {
                this.rh.get().c(null, iOptInt, grVarC, nu(jSONObject));
            } else {
                l();
            }
        } catch (Exception unused) {
            SoftReference<com.byazt.xl.sl> softReference2 = this.rh;
            if (softReference2 != null && softReference2.get() != null) {
                this.rh.get().c(null, -1, null, -1);
            } else {
                l();
            }
        }
    }

    public int sp(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.u.ve(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.u.u_().c() == 2) {
            this.u.ve(true);
        }
        return 1;
    }

    public JSONObject tt() {
        WeakReference<com.byazt.sy.i> weakReference = this.tk;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.tk.get().getCreativeVideoViewInfo();
    }

    public void x(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        double d7;
        double d8;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            String strOptString3 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                d9 = dOptDouble2;
                d = dOptDouble3;
                d7 = dOptDouble4;
                d2 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble8;
                d5 = dOptDouble9;
                d6 = dOptDouble10;
                d8 = dOptDouble5;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                dOptDouble = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            com.byazt.ete.gr grVarC = new com.byazt.ete.gr.c().uj((int) d9).ve((int) d).tt((int) d7).c((int) d8).tt((long) d2).c((long) d3).c((int) d4).tt((int) d5).ve((int) d6).uj((int) dOptDouble).c(strOptString3).c(true).c(jSONObject2).c((SparseArray<com.byazt.hkv.uj.c>) null).n(strOptString2).n(iOptInt2).c();
            SoftReference<com.byazt.xl.sl> softReference = this.rh;
            if (softReference != null && softReference.get() != null) {
                this.rh.get().tt(null, iOptInt, grVarC, sp(jSONObject));
            }
            c(strOptString, iOptInt, grVarC);
        } catch (Exception unused) {
            SoftReference<com.byazt.xl.sl> softReference2 = this.rh;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.rh.get().tt(null, -1, null, 0);
        }
    }

    public void yp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.x = jSONObject.optString("cid");
        this.da = jSONObject.optString("log_extra");
    }

    private void gt(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            rl(jSONObject);
        } else {
            rh.a().post(new Runnable() { // from class: com.byazt.omf.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.rl(jSONObject);
                }
            });
        }
    }

    public void t(boolean z) {
        this.q = new AtomicBoolean(z);
    }

    public void uj(boolean z) {
        this.aw = z;
    }

    public void ve(boolean z) {
        this.bx = z;
        this.sv = z;
    }

    public static void tt(boolean z) {
        kp = z;
    }

    public void da(boolean z) {
        this.pf = z;
    }

    public d uj(String str) {
        this.da = str;
        return this;
    }

    public static JSONArray c(List<ic> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).yg());
        }
        return jSONArray;
    }

    public d tt(SSWebView sSWebView) {
        this.uj = new WeakReference<>(sSWebView);
        return this;
    }

    public d uj(JSONObject jSONObject) {
        this.gt = jSONObject;
        return this;
    }

    public d ve(String str) {
        this.yp = str;
        return this;
    }

    public void n() {
        com.byazt.pct.nu nuVar = this.cu;
        if (nuVar == null) {
            return;
        }
        nuVar.c();
        this.cu = null;
    }

    public void sl(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z ? 0 : 1);
        } catch (Exception e) {
            com.byazt.nr.m.uj("TTAndroidObject", e.getMessage());
        }
        n("visibleStateChange", jSONObject);
    }

    public d tt(String str) {
        this.x = str;
        return this;
    }

    public void uj(int i) {
        this.my.tt(i);
    }

    public d ve(int i) {
        this.sl = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", RenderCallContext.TYPE_CALLBACK);
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            gt(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public com.byazt.pop.ve sp(String str) {
        return this.tx.get(str);
    }

    public d tt(List<JSONObject> list) {
        this.pu = list;
        return this;
    }

    public d ve(List<ic> list) {
        this.h = list;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e A[Catch: Exception -> 0x0022, TRY_LEAVE, TryCatch #0 {Exception -> 0x0022, blocks: (B:4:0x0004, B:5:0x000a, B:7:0x000e), top: B:11:0x0004 }] */
    public JSONObject z() {
        JSONObject jSONObject = this.gt;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                if (this.u != null) {
                    jSONObject.put(com.alipay.sdk.m.w.a.x, lr());
                    jSONObject.put("extension", this.u.ts());
                }
            } catch (Exception unused) {
            }
        } else if (this.u != null) {
            jSONObject.put(com.alipay.sdk.m.w.a.x, lr());
            jSONObject.put("extension", this.u.ts());
        }
        this.gt = jSONObject;
        return jSONObject;
    }

    public d tt(int i) {
        this.z = true;
        return this;
    }

    public void ve(JSONObject jSONObject) {
        com.byazt.rbg.c cVar;
        if (jSONObject == null || (cVar = this.or) == null) {
            return;
        }
        cVar.uj(jSONObject);
    }

    public boolean a(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || gr();
    }

    public d c(String str) {
        this.qp = str;
        return this;
    }

    public d n(String str) {
        this.t = str;
        return this;
    }

    public void tt(JSONObject jSONObject) {
        this.lo = jSONObject;
    }

    public d c(boolean z) {
        this.ic = z;
        return this;
    }

    public void n(JSONObject jSONObject) {
        if (this.my.sl() == null || jSONObject == null) {
            return;
        }
        try {
            this.my.sl().c(jSONObject.optBoolean(com.alibaba.ariver.jsapi.multimedia.video.a.f, false));
        } catch (Exception unused) {
        }
    }

    public boolean tt(ic icVar) {
        WeakReference<com.byazt.ouz.m> weakReference;
        com.byazt.ouz.m mVar;
        if (icVar != null && (weakReference = this.to) != null && (mVar = weakReference.get()) != null) {
            mVar.tt(icVar);
        }
        return false;
    }

    public void ve(ic icVar) {
        this.my.c(icVar);
    }

    public d c(SSWebView sSWebView) {
        com.byazt.nr.m.uj("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        com.byazt.pct.nu nuVarTt = com.byazt.pct.nu.c(sSWebView).c(new com.byazt.ay.c()).c("ToutiaoJSBridge").c(new com.byazt.pct.t() { // from class: com.byazt.omf.d.1
            @Override // com.byazt.pct.t
            public <T> T c(String str, Type type) {
                return null;
            }

            @Override // com.byazt.pct.t
            public <T> String c(T t) {
                return null;
            }
        }).c(pf()).tt(true).c().tt();
        this.cu = nuVarTt;
        com.byazt.qx.zm.c(nuVarTt, this);
        com.byazt.qx.a.c(this.cu, this);
        com.byazt.qx.x.c(this.cu, this, this.u);
        com.byazt.qx.m.c(this.cu);
        com.byazt.qx.d.c(this.cu, sSWebView);
        com.byazt.qx.i.c(this.cu, this);
        com.byazt.qx.u.c(this.cu, this);
        hd.c(this.cu, this);
        com.byazt.ja.uj.c(this.cu, this);
        com.byazt.qx.gu.c(this.cu, this);
        com.byazt.qx.gt.c(this.cu, this);
        com.byazt.ja.ve.c(this.cu, this);
        com.byazt.ja.c.c(this.cu, this);
        com.byazt.ja.n.c(this.cu, this);
        com.byazt.ja.a.c(this.cu, this);
        com.byazt.ja.tt.c(this.cu, this);
        bx();
        com.byazt.qx.ve.c(this.cu, this.uj.get(), this.x);
        com.byazt.qx.zb.c(this.cu, this.uj.get(), this.x);
        com.byazt.qx.tt.c(this.cu, this.uj.get(), this.x);
        com.byazt.qx.eo.c(this.cu, this.uj.get(), this.x);
        com.byazt.qx.sp.c(this.cu, this);
        com.byazt.qx.gr.c(this.cu, this);
        com.byazt.qx.ic.c(this.cu, this);
        com.byazt.qx.rh.c(this.cu, this);
        com.byazt.qx.nu.c(this.cu, this.u);
        com.byazt.qx.p.c(this.cu, this.f28877a.get(), this.u);
        com.byazt.qx.t.c(this.cu, this.u, this.pu);
        aw.c(this.cu, this);
        com.byazt.qx.h.c(this.cu, this, this.lt);
        com.byazt.qx.qp.c(this.cu, this, this.lt);
        l.c(this.cu, sSWebView, this);
        com.byazt.qx.sl.c(this.cu, this.u, this);
        com.byazt.qx.z.c(this.cu, this.u, this);
        lr.c(this.cu, this.lr);
        bm.c(this.cu, this);
        com.byazt.qx.or.c(this.cu, this.l);
        com.byazt.qx.cu.c(this.cu, this, this.u);
        com.byazt.qx.yp.c(this.cu, this.gt);
        com.byazt.qx.da.c(this.cu, this.u, this);
        com.byazt.qx.c.c(this.cu, this.f28877a.get());
        bx.c(this.cu, this.u);
        com.byazt.qx.uj.c(this.cu, this);
        com.byazt.qx.md.c(this.cu, this);
        com.byazt.qx.qy.c(this.cu, this, this.f28877a.get(), this.u);
        com.byazt.qx.n.c(this.cu);
        com.byazt.qx.rl.c(this.cu);
        com.byazt.qx.yv.c(this.cu, this, this.u);
        sv.c(this.cu, this);
        com.byazt.qx.my.c(this.cu, this.u);
        com.byazt.qx.nb.c(this.cu, this.u);
        com.byazt.qx.pf.c(this.cu, this.u);
        return this;
    }

    public void ve(String str, JSONObject jSONObject) {
        try {
            com.byazt.pct.nu nuVar = this.cu;
            if (nuVar != null) {
                nuVar.c(str, jSONObject);
            }
        } catch (Throwable th) {
            com.byazt.nr.m.ve("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void a(int i) {
        this.my.ve(i);
    }

    private void tt(String str, boolean z) {
        if (this.or == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.or.a(str);
        } else {
            this.or.sp(str);
        }
    }

    public void n(int i) {
        this.my.n(i);
    }

    private void n(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            gt(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void tt(final Uri uri) {
        long j;
        JSONObject jSONObjectU;
        ic icVar;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.byazt.nr.m.tt("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                com.byazt.nr.da.tt().post(new Runnable() { // from class: com.byazt.omf.d.4
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.i(uri.toString());
                    }
                });
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (a(queryParameter3)) {
                if (com.byazt.ete.qp.tt(this.u) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j = 0;
                }
                if (j == 0 && (icVar = this.u) != null) {
                    try {
                        j = Long.parseLong(icVar.uj());
                    } catch (Exception unused2) {
                    }
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused3) {
                }
                long j3 = j2;
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused4) {
                    }
                }
                c(queryParameter3, jSONObject);
                if ("click".equals(queryParameter3)) {
                    jSONObjectU = u(jSONObject);
                    WeakReference<com.byazt.at.n> weakReference = this.gu;
                    if (weakReference != null && weakReference.get() != null) {
                        this.gu.get().tt();
                    }
                } else {
                    jSONObjectU = jSONObject;
                }
                String strC = c(queryParameter2, queryParameter3);
                if (TextUtils.isEmpty(strC)) {
                    strC = queryParameter2;
                }
                String strOptString = jSONObjectU.optString("log_extra");
                if (this.u != null && queryParameter3.contains("sanfang") && TextUtils.isEmpty(strOptString)) {
                    jSONObjectU.putOpt("log_extra", this.u.w_());
                }
                com.byazt.ddx.uj.c(queryParameter, strC, queryParameter3, j, j3, jSONObjectU, this.b);
            }
        } catch (Exception e) {
            com.byazt.nr.m.tt("TTAndroidObject", "handleUri exception: ", e);
        }
    }

    private void x(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                c cVar = new c();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        cVar.c = jSONObjectOptJSONObject.optString("__msg_type", null);
                        cVar.tt = jSONObjectOptJSONObject.optString("__callback_id", null);
                        cVar.ve = jSONObjectOptJSONObject.optString("func");
                        cVar.uj = jSONObjectOptJSONObject.optJSONObject("params");
                        cVar.n = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(cVar.c) && !TextUtils.isEmpty(cVar.ve)) {
                    Message messageObtainMessage = this.n.obtainMessage(11);
                    messageObtainMessage.obj = cVar;
                    this.n.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.byazt.nr.m.c()) {
                com.byazt.nr.m.tt("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.byazt.nr.m.tt("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    @Override // com.byazt.nt.ve
    public void tt(String str, JSONObject jSONObject) {
        pf();
        n(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.byazt.nl.uj ujVarSv = sv();
                    if (ujVarSv != null) {
                        com.byazt.nr.yp.c(ujVarSv, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String strSubstring = str.substring(30, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                x(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject c() {
        WeakReference<com.byazt.sy.i> weakReference = this.tk;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.tk.get().getContainerInfo();
    }

    public void c(SSWebView.tt ttVar) {
        WeakReference<SSWebView> weakReference = this.uj;
        if (weakReference == null || weakReference.get() == null || ttVar == null) {
            return;
        }
        this.uj.get().setOnShakeListener(ttVar);
    }

    public d c(com.byazt.ouz.m mVar) {
        this.to = new WeakReference<>(mVar);
        return this;
    }

    public d c(com.byazt.ux.tt ttVar) {
        this.lt = new WeakReference<>(ttVar);
        return this;
    }

    public d c(com.byazt.sy.i iVar) {
        this.tk = new WeakReference<>(iVar);
        return this;
    }

    public void c(int i) {
        if (kp) {
            com.byazt.nr.m.tt("TTAndroidObject", "blocked Twist");
            return;
        }
        if (i != 1) {
            if (i == 2) {
                tt("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.u != null && uj()) {
                com.byazt.yzg.a.uj = true;
            }
            tt("wobble_callback", (JSONObject) null);
        }
    }

    public d c(com.byazt.rbg.c cVar) {
        this.or = cVar;
        return this;
    }

    public d c(View view) {
        this.i = new WeakReference<>(view);
        return this;
    }

    public d c(com.byazt.at.tt ttVar) {
        this.yv = new WeakReference<>(ttVar);
        return this;
    }

    public d c(com.byazt.at.ve veVar) {
        this.p = new WeakReference<>(veVar);
        return this;
    }

    public d c(com.byazt.at.sp spVar) {
        this.md = new WeakReference<>(spVar);
        return this;
    }

    public d c(ic icVar) {
        this.u = icVar;
        return this;
    }

    public d c(com.byazt.xl.sl slVar) {
        this.rh = new SoftReference<>(slVar);
        return this;
    }

    public d c(com.byazt.ouz.sl slVar) {
        this.my.c(slVar);
        return this;
    }

    public d c(com.byazt.nt.n nVar) {
        this.rl = new WeakReference<>(nVar);
        return this;
    }

    public d c(JSONObject jSONObject) {
        this.zm = jSONObject;
        return this;
    }

    public d c(Map<String, Object> map) {
        this.c = map;
        return this;
    }

    public d c(com.byazt.at.c cVar) {
        this.qy = new WeakReference<>(cVar);
        return this;
    }

    public d c(com.byazt.at.n nVar) {
        this.gu = new WeakReference<>(nVar);
        return this;
    }

    public d c(com.byazt.bd.c cVar) {
        this.gr = new WeakReference<>(cVar);
        return this;
    }

    public void c(com.byazt.sgn.sp.c cVar) {
        this.lr = cVar;
    }

    public void c(com.byazt.xs.tt ttVar) {
        this.l = ttVar;
    }

    public static void c(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = ic().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.byazt.fh.c.c());
        jSONObject.put("innerAppName", com.byazt.fh.c.a());
        jSONObject.put("aid", com.byazt.fh.c.tt());
        jSONObject.put("sdkEdition", com.byazt.fh.c.ve());
        jSONObject.put("sdkApiVersion", com.byazt.fh.c.uj());
        jSONObject.put("appVersion", com.byazt.fh.c.n());
        jSONObject.put("netType", com.byazt.fh.c.sp());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.byazt.fh.c.x());
        jSONObject.put("osVersion", Build.VERSION.SDK_INT);
        jSONObject.put("appId", x.m().rl());
        if (pu.c(i)) {
            jSONObject.put("themeStatus", x.m().pu());
        }
    }

    /* JADX WARN: Code duplicated, block: B:167:0x026d A[PHI: r3
      0x026d: PHI (r3v23 org.json.JSONObject) = (r3v19 org.json.JSONObject), (r3v24 org.json.JSONObject) binds: [B:166:0x026b, B:155:0x023f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject c(c cVar, int i) throws Exception {
        byte b;
        Context context;
        JSONObject jSONObjectAw;
        if (!"call".equals(cVar.c)) {
            return null;
        }
        pf();
        JSONObject jSONObject = new JSONObject();
        String str = cVar.ve;
        str.hashCode();
        switch (str.hashCode()) {
            case -2036781162:
                b = !str.equals("subscribe_app_ad") ? (byte) -1 : (byte) 0;
                break;
            case -1752549500:
                b = !str.equals("adInfoStash") ? (byte) -1 : (byte) 1;
                break;
            case -1423303823:
                b = !str.equals("adInfo") ? (byte) -1 : (byte) 2;
                break;
            case -1330994877:
                b = !str.equals("pauseWebView") ? (byte) -1 : (byte) 3;
                break;
            case -1169135450:
                b = !str.equals("changeVideoState") ? (byte) -1 : (byte) 4;
                break;
            case -844321441:
                b = !str.equals("webview_time_track") ? (byte) -1 : (byte) 5;
                break;
            case -800853518:
                b = !str.equals("clickEvent") ? (byte) -1 : (byte) 6;
                break;
            case -794273169:
                b = !str.equals("appInfo") ? (byte) -1 : (byte) 7;
                break;
            case -715147645:
                b = !str.equals("getScreenSize") ? (byte) -1 : (byte) 8;
                break;
            case -489318846:
                b = !str.equals("getMaterialMeta") ? (byte) -1 : (byte) 9;
                break;
            case -278382602:
                b = !str.equals("send_temai_product_ids") ? (byte) -1 : (byte) 10;
                break;
            case -173752734:
                b = !str.equals("getTeMaiAds") ? (byte) -1 : (byte) 11;
                break;
            case 27837080:
                b = !str.equals("download_app_ad") ? (byte) -1 : (byte) 12;
                break;
            case 105049135:
                b = !str.equals("unsubscribe_app_ad") ? (byte) -1 : (byte) 13;
                break;
            case 352242576:
                b = !str.equals("getDownloadStatus") ? (byte) -1 : com.google.common.base.a.p;
                break;
            case 399543522:
                b = !str.equals("getCloseButtonInfo") ? (byte) -1 : com.google.common.base.a.q;
                break;
            case 402955465:
                b = !str.equals("isViewable") ? (byte) -1 : com.google.common.base.a.r;
                break;
            case 442647767:
                b = !str.equals("sendReward") ? (byte) -1 : (byte) 17;
                break;
            case 571273292:
                b = !str.equals("dynamicTrack") ? (byte) -1 : com.google.common.base.a.u;
                break;
            case 650209982:
                b = !str.equals("getTemplateInfo") ? (byte) -1 : (byte) 19;
                break;
            case 672928467:
                b = !str.equals("cancel_download_app_ad") ? (byte) -1 : com.google.common.base.a.x;
                break;
            case 711635577:
                b = !str.equals("getCurrentVideoState") ? (byte) -1 : com.google.common.base.a.y;
                break;
            case 885131792:
                b = !str.equals("getVolume") ? (byte) -1 : com.google.common.base.a.z;
                break;
            case 1107374321:
                b = !str.equals("pauseWebViewTimers") ? (byte) -1 : com.google.common.base.a.A;
                break;
            case 1151744482:
                b = !str.equals("muteVideo") ? (byte) -1 : com.google.common.base.a.B;
                break;
            case 1237100796:
                b = !str.equals("renderDidFinish") ? (byte) -1 : com.google.common.base.a.C;
                break;
            case 1634511418:
                b = !str.equals("endcard_load") ? (byte) -1 : com.google.common.base.a.D;
                break;
            case 1713585602:
                b = !str.equals("getNetworkData") ? (byte) -1 : com.google.common.base.a.E;
                break;
            case 2086000188:
                b = !str.equals("skipVideo") ? (byte) -1 : com.google.common.base.a.F;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                lt();
                WeakReference<Context> weakReference = this.f28877a;
                if (weakReference != null && (context = weakReference.get()) != null) {
                    this.sp.c(context, cVar.uj, this.da, this.sl, this.z, this.bm);
                }
                break;
            case 1:
                yp(cVar.uj);
                break;
            case 2:
                jSONObject = u();
                break;
            case 3:
                hd();
                break;
            case 4:
                a(cVar.uj);
                break;
            case 5:
                ve(cVar.uj);
                break;
            case 6:
                i(cVar.uj);
                break;
            case 7:
                c(jSONObject, nb.sl(this.u));
                break;
            case 8:
                WeakReference<com.byazt.at.c> weakReference2 = this.qy;
                com.byazt.at.c cVar2 = weakReference2 != null ? weakReference2.get() : null;
                if (cVar2 != null) {
                    int iTt = cVar2.tt();
                    int iC = cVar2.c();
                    jSONObject.put("width", iTt);
                    jSONObject.put("height", iC);
                }
                break;
            case 9:
                t(jSONObject);
                break;
            case 10:
                my(cVar.uj);
                break;
            case 11:
                jSONObjectAw = this.zm;
                if (jSONObjectAw != null) {
                    jSONObject = jSONObjectAw;
                }
                break;
            case 12:
                da(true);
                JSONObject jSONObject2 = cVar.uj;
                c(cVar.uj, jSONObject2 != null ? jSONObject2.optBoolean("is_compliant_download") : false);
                break;
            case 13:
                com.byazt.nt.uj ujVar = this.sp;
                if (ujVar != null) {
                    ujVar.c(cVar.uj);
                }
                break;
            case 14:
                jSONObject = com.byazt.qx.m.c(cVar.uj);
                break;
            case 15:
                jSONObjectAw = aw();
                if (jSONObjectAw != null) {
                    jSONObject = jSONObjectAw;
                }
                break;
            case 16:
                jSONObject.put("viewStatus", this.zb ? 1 : 0);
                break;
            case 17:
                this.tt = true;
                JSONObject jSONObject3 = cVar.uj;
                int iOptInt = jSONObject3 != null ? jSONObject3.optInt(MediationConstant.KEY_REWARD_TYPE) : 0;
                WeakReference<com.byazt.at.n> weakReference3 = this.gu;
                if (weakReference3 != null && weakReference3.get() != null) {
                    this.gu.get().c(iOptInt);
                }
                this.my.uj(iOptInt);
                break;
            case 18:
                sl(cVar.uj);
                break;
            case 19:
                z();
                jSONObject = this.gt;
                break;
            case 20:
                com.byazt.nt.uj ujVar2 = this.sp;
                if (ujVar2 != null) {
                    ujVar2.tt(cVar.uj);
                }
                break;
            case 21:
                m(jSONObject);
                break;
            case 22:
                AudioManager audioManager = (AudioManager) gt.getContext().getSystemService("audio");
                jSONObject.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case 23:
                bm();
                break;
            case 24:
                n(cVar.uj);
                break;
            case 25:
                da(cVar.uj);
                break;
            case 26:
                z(cVar.uj);
                break;
            case 27:
                c(cVar, jSONObject);
                break;
            case 28:
                m();
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(cVar.tt)) {
            uj(cVar.tt, jSONObject);
            pf();
        }
        return jSONObject;
    }

    public void c(float f) {
        if (this.my.sl() == null) {
            return;
        }
        try {
            this.my.sl().c(f);
        } catch (Exception unused) {
        }
    }

    public void c(float f, float f2, float f3, float f4, int i) {
        this.my.c(f, f2, f3, f4, i);
    }

    public static JSONObject c(ic icVar, AtomicBoolean atomicBoolean) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (gt.tt() == null) {
            return jSONObject;
        }
        try {
            int iT = nb.t(icVar);
            int iSl = nb.sl(icVar);
            boolean z2 = true;
            int iUj = com.byazt.ete.or.tt(true, icVar, true) ? 0 : gt.tt().uj(iT);
            int iN = (com.byazt.ete.or.tt(false, icVar, true) || (com.byazt.ete.h.c(icVar) && com.byazt.ete.h.tt(icVar) > 0)) ? 0 : gt.tt().n(iT);
            boolean zN = gt.tt().n(String.valueOf(iT));
            if (atomicBoolean != null) {
                z = atomicBoolean.get();
            } else {
                z = icVar.ab() == 1;
            }
            jSONObject.put("ad_slot_type", iSl);
            jSONObject.put("voice_control", z);
            jSONObject.put("rv_skip_time", iUj);
            jSONObject.put("fv_skip_show", zN);
            jSONObject.put("iv_skip_time", iN);
            if (icVar == null || !icVar.fe()) {
                z2 = false;
            }
            jSONObject.put("show_dislike", z2);
            jSONObject.put("video_adaptation", icVar != null ? icVar.vi() : 0);
            jSONObject.put("h5_cache_resources_enable", com.byazt.ete.d.c);
            jSONObject.put("dark_mode_config", pu.c());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void c(final c cVar, final JSONObject jSONObject) {
        if (cVar == null) {
            return;
        }
        try {
            c(cVar.uj, new com.byazt.at.uj() { // from class: com.byazt.omf.d.13
                @Override // com.byazt.at.uj
                public void c(boolean z, List<ic> list, boolean z2) {
                    if (!z) {
                        d.this.uj(cVar.tt, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", d.c(list));
                        d.this.uj(cVar.tt, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean c(String str, int i, com.byazt.ete.gr grVar) {
        HashMap<String, i> map;
        i iVar;
        if (TextUtils.isEmpty(str) || (map = this.d) == null || (iVar = map.get(str)) == null) {
            return false;
        }
        iVar.c(i, grVar);
        return true;
    }

    public void c(JSONObject jSONObject, com.byazt.at.uj ujVar) {
        com.byazt.hy.tt.c(this.u, jSONObject, ujVar, (com.byazt.dj.tt) null);
    }

    public boolean c(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (ve.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(int i, ic icVar, int i2, int i3) {
        WeakReference<Context> weakReference = this.f28877a;
        if (weakReference == null || icVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.f28877a.get();
        com.byazt.hkv.c cVar = new com.byazt.hkv.c(context, icVar, this.qp, this.sl);
        com.byazt.rv.c.c().c(icVar.hashCode() + icVar.qy()).put("live_saas_interaction_type", Integer.valueOf(i2));
        if (i == 0) {
            ((com.byazt.vis.c) cVar.c(com.byazt.vis.c.class)).tt(true);
        }
        final String strUj = icVar.uj();
        com.byazt.pop.ve veVarTt = this.tx.get(strUj);
        if (veVarTt == null) {
            if (i3 == 1) {
                if (icVar.i() == 4) {
                    veVarTt = com.byazt.yih.x.c(context, icVar, this.qp);
                }
            } else {
                veVarTt = com.byazt.yih.x.tt(context, icVar, this.qp);
            }
            if (veVarTt != null) {
                veVarTt.c(new com.byazt.pop.c() { // from class: com.byazt.omf.d.5
                    @Override // com.byazt.pop.c
                    public void c() {
                        com.byazt.nt.c.c(strUj);
                    }

                    @Override // com.byazt.pop.c
                    public void tt(long j, long j2, String str, String str2) {
                        com.byazt.nt.c.tt(strUj, j, j2);
                    }

                    @Override // com.byazt.pop.c
                    public void ve(long j, long j2, String str, String str2) {
                        com.byazt.nt.c.ve(strUj, j, j2);
                    }

                    @Override // com.byazt.pop.c
                    public void c(long j, long j2, String str, String str2) {
                        com.byazt.nt.c.c(strUj, j, j2);
                    }

                    @Override // com.byazt.pop.c
                    public void c(long j, String str, String str2) {
                        com.byazt.nt.c.tt(strUj);
                    }

                    @Override // com.byazt.pop.c
                    public void c(String str, String str2) {
                        com.byazt.nt.c.ve(strUj);
                    }
                });
                c(strUj, veVarTt);
            }
        }
        if (veVarTt != null) {
            ((com.byazt.nat.c) cVar.c(com.byazt.nat.c.class)).c(veVarTt);
        }
        cVar.c(null, new com.byazt.ete.da());
        if (to()) {
            WeakReference<com.byazt.sy.i> weakReference2 = this.tk;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.tk.get().uj();
            return;
        }
        if (context instanceof com.byazt.fh.tt) {
            ((com.byazt.fh.tt) context).c(1);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String str2 = "click";
        String strTt = "";
        try {
            if ("show".equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str2 = "show";
            } else if ("click".equals(str)) {
                jSONArray = jSONObject.getJSONArray("click_url");
            } else {
                str2 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String strC = com.byazt.aas.z.c();
                if (TextUtils.isEmpty(strC)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                String strOptString5 = jSONObject.optString("log_extra");
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString5);
                    strOptString = jSONObject2.optString(MediationConstant.EXTRA_ADID);
                    try {
                        strOptString2 = jSONObject2.optString("creative_id");
                        try {
                            strOptString3 = jSONObject2.optString("req_id");
                            try {
                                strOptString4 = jSONObject2.optString("customer_id");
                                try {
                                    strTt = nb.tt(jSONObject2.optInt("ad_slot_type"));
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable unused2) {
                                strOptString4 = "";
                            }
                        } catch (Throwable unused3) {
                            strOptString3 = "";
                            strOptString4 = strOptString3;
                        }
                    } catch (Throwable unused4) {
                        strOptString2 = "";
                        strOptString3 = strOptString2;
                        strOptString4 = strOptString3;
                        HashMap map = new HashMap();
                        map.put("aid", strOptString);
                        map.put("cid", strOptString2);
                        map.put("req_id", strOptString3);
                        map.put("customer_id", strOptString4);
                        com.byazt.ukr.tt.c(strC, arrayList, true, map, com.byazt.ddx.uj.c(strOptString5, strOptString, strOptString3, strTt, str2));
                    }
                } catch (Throwable unused5) {
                    strOptString = "";
                    strOptString2 = strOptString;
                }
                HashMap map2 = new HashMap();
                map2.put("aid", strOptString);
                map2.put("cid", strOptString2);
                map2.put("req_id", strOptString3);
                map2.put("customer_id", strOptString4);
                com.byazt.ukr.tt.c(strC, arrayList, true, map2, com.byazt.ddx.uj.c(strOptString5, strOptString, strOptString3, strTt, str2));
            }
        } catch (Throwable unused6) {
        }
    }

    public String c(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && "landingpage".equals(str)) || this.rh != null || to()) ? str : nb.c(this.sl);
    }

    public void c(String str, boolean z) {
        com.byazt.nt.uj ujVar = this.sp;
        if (ujVar != null) {
            ujVar.c(str, z);
        }
    }

    public void c(String str, com.byazt.pop.ve veVar) {
        this.tx.put(str, veVar);
    }

    public void c(JSONObject jSONObject, boolean z) {
        WeakReference<Context> weakReference;
        if (this.sp == null || (weakReference = this.f28877a) == null || weakReference.get() == null) {
            return;
        }
        this.sp.c(this.nu && this.m);
        this.sp.tt(z);
        this.sp.ve(this.b == 3);
        this.sp.c(this.f28877a.get(), jSONObject, this.qp, this.da);
    }

    public void c(com.byazt.at.a aVar) {
        this.v = new WeakReference<>(aVar);
    }

    public void c(int i, int i2) {
        int iVe = pf.ve(gt.getContext(), i);
        int iVe2 = pf.ve(gt.getContext(), i2);
        WeakReference<com.byazt.sy.i> weakReference = this.tk;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tk.get().c(Integer.MIN_VALUE, Integer.MIN_VALUE, iVe, iVe2);
    }

    public void c(int i, int i2, int i3, int i4) {
        int iVe;
        int iVe2;
        int iVe3;
        int iVe4 = Integer.MIN_VALUE;
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            iVe = Integer.MIN_VALUE;
            iVe2 = Integer.MIN_VALUE;
        } else {
            iVe = pf.ve(gt.getContext(), i);
            iVe2 = pf.ve(gt.getContext(), i2);
        }
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            iVe3 = Integer.MIN_VALUE;
        } else {
            iVe4 = pf.ve(gt.getContext(), i3);
            iVe3 = pf.ve(gt.getContext(), i4);
        }
        WeakReference<com.byazt.sy.i> weakReference = this.tk;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.tk.get().c(iVe, iVe2, iVe4, iVe3);
    }

    public void c(byte b) {
        this.b = b;
    }
}
