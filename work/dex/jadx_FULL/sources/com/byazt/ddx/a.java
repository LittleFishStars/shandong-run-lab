package com.byazt.ddx;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alibaba.ariver.remotedebug.b;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.aw;
import com.byazt.bv.BaseConstants;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.nr.yp;
import com.byazt.omf.gt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic f28384a;
    public String d;
    public com.byazt.nl.uj gt;
    public com.byazt.rbg.c gu;
    public Runnable md;
    public String n;
    public long p;
    public JSONObject qy;
    public String uj;
    public WeakReference<tt> zb;
    public int c = 0;
    public volatile boolean tt = false;
    public int ve = -1;
    public String sp = "landingpage";
    public long x = 0;
    public long i = 0;
    public long da = 0;
    public long sl = 0;
    public long t = 0;
    public boolean u = false;
    public long yp = 0;
    public long z = 0;
    public long m = 0;
    public long nu = -1;
    public boolean rh = false;
    public AtomicInteger my = new AtomicInteger(0);
    public boolean rl = false;
    public AtomicBoolean gr = new AtomicBoolean(false);
    public boolean zm = false;
    public boolean yv = true;
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final Map<String, aw.c> eo = new ConcurrentHashMap();

    @com.byazt.zqa.c(c = {0, 1, 483, 464})
    public static class c {
        public final AtomicInteger c;
        public final WeakReference<tt> tt;

        public c(AtomicInteger atomicInteger, WeakReference<tt> weakReference) {
            this.c = atomicInteger;
            this.tt = weakReference;
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i = 100;
                } else if (iIntValue >= 0) {
                    i = iIntValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.c;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<tt> weakReference = this.tt;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.tt.get().c(str);
        }
    }

    public interface tt {
        void c(String str);
    }

    public a(ic icVar, com.byazt.nl.uj ujVar) {
        this.f28384a = icVar;
        this.gt = ujVar;
        if (ujVar != null) {
            ujVar.addJavascriptInterface(new c(this.my, this.zb), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.p = System.currentTimeMillis();
        this.d = String.valueOf(SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (!TextUtils.isEmpty(com.byazt.hq.c.c) && this.f28384a != null) {
                StringBuilder sb = new StringBuilder(com.byazt.hq.c.c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.f28384a.uj());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.f28384a.gu());
                jSONObject.put("log_extra", this.f28384a.w_());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.m);
                jSONObject2.put("click_time", this.z);
                jSONObject2.put("web_url", this.f28384a.x());
                jSONObject.put("client_info", jSONObject2);
                com.byazt.hq.c.c(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                String strConcat = b.k.concat(String.valueOf(string));
                com.byazt.nl.uj ujVar = this.gt;
                if (ujVar != null) {
                    yp.c(ujVar, strConcat);
                }
            }
        } catch (Throwable th) {
            m.ve(th.getMessage());
        }
    }

    public void a() {
        com.byazt.nl.uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.gt = null;
        if (!this.gr.get() && this.tt) {
            uj.ve(this.f28384a, this.sp, System.currentTimeMillis() - this.yp);
        }
        if ("landingpage".equals(this.sp) || "landingpage_endcard".equals(this.sp)) {
            com.byazt.qw.ve.ve().c("landingFinish", this.f28384a, this.d);
        }
        this.md = null;
        if (this.eo.isEmpty()) {
            return;
        }
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ddx.a.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("web_cache_hit_report");
                if (a.this.f28384a != null) {
                    ttVarC.a(a.this.f28384a.qy());
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (aw.c cVar : a.this.eo.values()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", cVar.ve());
                        jSONObject2.put("hit", cVar.uj());
                        jSONObject2.put("miss", cVar.n());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                ttVarC.tt(jSONObject.toString());
                return ttVarC;
            }
        }, "web_cache_hit_report");
    }

    public void n() {
        if (this.yv) {
            this.yv = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.p);
                jSONObject.put("end", System.currentTimeMillis());
                com.byazt.ic.c.c(jSONObject, this.f28384a);
            } catch (JSONException e) {
                m.c(e);
            }
            uj.c(this.f28384a, "landingpage", "agg_stay_page", new com.byazt.ya.c() { // from class: com.byazt.ddx.a.1
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            });
        }
        if (this.c == 2) {
            if (this.da > 0 || !tt()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.i = jCurrentTimeMillis;
                long jMax = jCurrentTimeMillis - Math.max(this.x, this.da);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.c);
                    jSONObject2.put("max_scroll_percent", this.my.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                c("stay_page", jSONObject2, Math.min(jMax, 600000L));
                com.byazt.qw.ve.ve().c("landingPause", this.f28384a, this.d);
            }
        }
    }

    public void sp() {
        com.byazt.mw.c cVarMa;
        com.byazt.nl.uj ujVar;
        if (!(this.c == 2 && this.u) || (cVarMa = gt.tt().ma()) == null || (ujVar = this.gt) == null) {
            return;
        }
        cVarMa.c(ujVar.getWebView(), this.f28384a);
    }

    public a uj(long j) {
        this.nu = j;
        return this;
    }

    public Map<String, aw.c> x() {
        return this.eo;
    }

    public void c(tt ttVar) {
        this.zb = new WeakReference<>(ttVar);
    }

    public boolean tt() {
        return this.zm;
    }

    public void uj() {
        this.x = System.currentTimeMillis();
        if (this.yp == 0) {
            this.yp = System.currentTimeMillis();
        }
        if ("landingpage".equals(this.sp) || "landingpage_endcard".equals(this.sp)) {
            if (this.h.compareAndSet(false, true)) {
                com.byazt.qw.ve.ve().c("landingStart", this.f28384a, this.d);
            } else {
                com.byazt.qw.ve.ve().c("landingContinue", this.f28384a, this.d);
            }
        }
    }

    public com.byazt.rbg.c ve() {
        return this.gu;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.sp = str;
    }

    public a tt(boolean z) {
        this.rl = z;
        return this;
    }

    public a ve(long j) {
        this.m = j;
        return this;
    }

    public a tt(long j) {
        this.z = j;
        return this;
    }

    public String c() {
        return this.sp;
    }

    public void tt(String str) {
        if (this.rl) {
            if ("load_finish".equals(str) && "landingpage".equals(this.sp)) {
                Runnable runnable = new Runnable() { // from class: com.byazt.ddx.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.i();
                    }
                };
                this.md = runnable;
                com.byazt.hq.c.c(new com.byazt.hq.c.RunnableC0426c(runnable));
            }
            long j = this.t - this.sl;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.ve);
                jSONObject.put("error_msg", this.uj);
                jSONObject.put("error_url", this.n);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j2 = this.z;
                if (j2 > 0) {
                    jSONObject.put("exp_duration", this.t - j2);
                }
                long j3 = this.m;
                if (j3 > 0) {
                    jSONObject.put("web_duration", this.t - j3);
                }
                long j4 = this.nu;
                if (j4 >= 0) {
                    jSONObject.put("webview_duration", j4);
                }
            } catch (Exception unused) {
            }
            c(str, jSONObject, Math.min(j, 600000L));
        }
    }

    public void c(long j) {
        this.da = j;
    }

    public void c(boolean z) {
        this.zm = z;
    }

    public void c(com.byazt.rbg.c cVar) {
        this.gu = cVar;
    }

    public void c(JSONObject jSONObject) {
        this.qy = jSONObject;
    }

    public void c(WebView webView, int i) {
        if (this.sl == 0 && i > 0) {
            this.c = 1;
            this.sl = System.currentTimeMillis();
        } else {
            if (i != 100 || this.u) {
                return;
            }
            this.u = true;
            this.t = System.currentTimeMillis();
            if (!"landingpage".equals(this.sp) || this.c == 3) {
                return;
            }
            tt("landingpage_load_hundred");
        }
    }

    public void c(WebView webView, String str, Bitmap bitmap) {
        com.byazt.rbg.c cVar = this.gu;
        if (cVar != null) {
            cVar.a();
        }
        if (this.tt) {
            return;
        }
        this.yp = System.currentTimeMillis();
        this.tt = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        c("load_start", jSONObject);
    }

    public void c(WebView webView) {
        com.byazt.rbg.c cVar = this.gu;
        if (cVar != null) {
            cVar.sp();
        }
        if (this.t <= 0) {
            this.t = System.currentTimeMillis();
        }
        if (webView != null && !this.rh && this.rl) {
            this.rh = true;
            yp.c(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.gr.get()) {
            return;
        }
        if (this.c != 3) {
            this.c = 2;
        }
        this.gr.set(true);
        this.x = System.currentTimeMillis();
        if (this.c == 2) {
            tt("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, this.ve);
            jSONObject.put("error_msg", this.uj);
            jSONObject.put("error_url", this.n);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        c("load_fail", jSONObject);
    }

    public void c(int i, String str, String str2, String str3) {
        com.byazt.rbg.c cVar = this.gu;
        if (cVar != null) {
            cVar.x();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.c != 2) {
            this.c = 3;
        }
        this.ve = i;
        this.uj = str;
        this.n = str2;
    }

    private void c(String str, JSONObject jSONObject) {
        c(str, jSONObject, -1L);
    }

    private void c(String str, JSONObject jSONObject, long j) {
        if (!this.rl || this.f28384a == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        uj.ve(this.f28384a, this.sp, str, jSONObject2);
    }
}
