package com.ipd.dsp.internal.z0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.q;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.c2.u;
import com.ipd.dsp.internal.c2.v;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends com.ipd.dsp.internal.z0.b {
    public static Pair<String, Boolean> p;
    public View h;
    public WebView i;
    public Object k;
    public com.ipd.dsp.internal.w1.c l;
    public c m;
    public com.ipd.dsp.internal.e1.d o;
    public boolean j = false;
    public String n = null;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f38618a;

        @JavascriptInterface
        public void exit() {
            a aVar = this.f38618a.get();
            if (aVar != null) {
                try {
                    aVar.b();
                } catch (Throwable th) {
                    k.b(com.ipd.dsp.internal.l1.a.j, "WebView.exit error", th);
                }
            }
        }

        @JavascriptInterface
        public boolean isWXOpenSdkExist() {
            return true;
        }

        @JavascriptInterface
        public boolean launchWXMiniProgram(String str, String str2, String str3) {
            try {
                IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.f38618a.get().j(), str);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str2;
                req.path = str3;
                req.miniprogramType = 0;
                iwxapiCreateWXAPI.sendReq(req);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public b(a aVar) {
            this.f38618a = new WeakReference<>(aVar);
        }
    }

    public static class c implements com.ipd.dsp.internal.w1.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f38619a;

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(int i, int i2) {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(int i, JSONObject jSONObject) {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(com.ipd.dsp.internal.h1.a.c cVar, JSONObject jSONObject) {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(@Nullable JSONObject jSONObject) {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.setData(Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                if (com.ipd.dsp.internal.w1.d.a(getContext(), intent)) {
                    getContext().startActivity(intent);
                    return true;
                }
            } catch (Throwable th) {
                r.a(th);
            }
            return false;
        }

        public final void c() {
            this.f38619a = null;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void c(String str) {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void d() {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void d(String str) {
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        @Nullable
        public Context getContext() {
            Activity activityJ;
            a aVar = this.f38619a;
            if (aVar != null && (activityJ = aVar.j()) != null) {
                try {
                    return activityJ.getApplicationContext();
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public JSONObject getCustomData() {
            JSONObject jSONObject = new JSONObject();
            a aVar = this.f38619a;
            if (aVar != null && aVar.o != null) {
                try {
                    jSONObject.put("download_confirm", this.f38619a.o.w.f ? 1 : 0);
                    jSONObject.put("is_enable_slide_anim", this.f38619a.o.w.i ? 1 : 0);
                    jSONObject.put("is_disable_falling_anim", this.f38619a.o.w.j);
                    jSONObject.put("falling_rate", this.f38619a.o.w.k);
                    return jSONObject;
                } catch (JSONException e) {
                    r.a(e);
                }
            }
            return jSONObject;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public String getOriginalUrl() {
            a aVar = this.f38619a;
            if (aVar != null) {
                return aVar.n;
            }
            return null;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void setTitle(int i) {
        }

        public c(a aVar) {
            this.f38619a = aVar;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(final String str) {
            a aVar = this.f38619a;
            if (aVar != null) {
                try {
                    final Activity activityJ = aVar.j();
                    if (activityJ != null && !activityJ.isFinishing() && !activityJ.isDestroyed()) {
                        activityJ.runOnUiThread(new Runnable() { // from class: com.zj.adlib.wga
                            @Override // java.lang.Runnable
                            public final void run() {
                                activityJ.setTitle(str);
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public JSONObject a() {
            a aVar = this.f38619a;
            if (aVar != null && aVar.o != null) {
                String str = this.f38619a.o.C;
                if (o.c(str)) {
                    try {
                        return new JSONObject(str);
                    } catch (JSONException e) {
                        r.a(e);
                    }
                }
            }
            return null;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void b() {
            a aVar = this.f38619a;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        b(4);
    }

    public final boolean d(final String str) {
        com.tencent.smtt.sdk.WebView webView;
        com.ipd.dsp.internal.w1.c cVar = this.l;
        if (cVar == null) {
            return false;
        }
        String strA = cVar.a(str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        try {
            if (this.j && (webView = this.h) != null) {
                webView.evaluateJavascript(strA, new ValueCallback() { // from class: com.zj.adlib.uea
                    public final void a(Object obj) {
                        this.f45132a.a(str, (String) obj);
                    }
                });
                return true;
            }
            WebView webView2 = this.i;
            if (webView2 == null) {
                return true;
            }
            webView2.evaluateJavascript(strA, new android.webkit.ValueCallback() { // from class: com.zj.adlib.efa
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    this.f41428a.b(str, (String) obj);
                }
            });
            return true;
        } catch (Throwable th) {
            r.a(th);
            return false;
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void k() {
        Activity activityJ;
        com.tencent.smtt.sdk.WebView webView = this.h;
        if (webView != null) {
            webView.removeJavascriptInterface(com.ipd.dsp.internal.w1.e.h);
            v.a(this.h);
            this.h = null;
        }
        WebView webView2 = this.i;
        if (webView2 != null) {
            webView2.removeJavascriptInterface(com.ipd.dsp.internal.w1.e.h);
            u.a(this.i);
            this.i = null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                if (this.k != null && (activityJ = j()) != null) {
                    activityJ.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback((OnBackInvokedCallback) this.k);
                }
            } catch (Throwable th) {
                r.a(th);
            }
        }
        c cVar = this.m;
        if (cVar != null) {
            cVar.c();
            this.m = null;
        }
        com.ipd.dsp.internal.w1.c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a();
            this.l = null;
        }
        super.k();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void l() {
        d("onPause");
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void n() {
        d("onResume");
    }

    public final boolean r() {
        com.tencent.smtt.sdk.WebView webView;
        if (this.j && (webView = this.h) != null) {
            return webView.canGoBack();
        }
        WebView webView2 = this.i;
        return webView2 != null && webView2.canGoBack();
    }

    public final void s() {
        com.tencent.smtt.sdk.WebView webView;
        if (this.j && (webView = this.h) != null) {
            webView.goBack();
            return;
        }
        WebView webView2 = this.i;
        if (webView2 != null) {
            webView2.goBack();
        }
    }

    public final /* synthetic */ void t() {
        Activity activityJ = j();
        if (activityJ == null || activityJ.isFinishing() || activityJ.isDestroyed()) {
            return;
        }
        try {
            activityJ.finish();
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public final boolean v() {
        return d("beforeClose");
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(@Nullable Bundle bundle) {
        Object obj;
        com.tencent.smtt.sdk.WebView webView;
        Activity activityJ = j();
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                this.k = new OnBackInvokedCallback() { // from class: com.zj.adlib.jda
                    @Override // android.window.OnBackInvokedCallback
                    public final void onBackInvoked() {
                        this.f42564a.u();
                    }
                };
                activityJ.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, (OnBackInvokedCallback) this.k);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        Intent intent = activityJ.getIntent();
        this.j = q.a();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.m = new c();
        if (this.j) {
            com.tencent.smtt.sdk.WebView webView2 = new com.tencent.smtt.sdk.WebView(activityJ);
            this.h = webView2;
            webView2.setLayoutParams(layoutParams);
            activityJ.setContentView(this.h);
            this.h.removeJavascriptInterface("searchBoxJavaBridge_");
            this.h.removeJavascriptInterface("accessibilityTraversal");
            this.h.removeJavascriptInterface("accessibility");
            String strA = v.a(this.h, activityJ);
            this.h.addJavascriptInterface(new b(), "ActivityHelper");
            com.ipd.dsp.internal.w1.c cVar = new com.ipd.dsp.internal.w1.c(strA, this.m);
            this.l = cVar;
            this.h.addJavascriptInterface(cVar, com.ipd.dsp.internal.w1.e.h);
        } else {
            WebView webView3 = new WebView(activityJ);
            this.i = webView3;
            webView3.setLayoutParams(layoutParams);
            activityJ.setContentView(this.i);
            this.i.removeJavascriptInterface("searchBoxJavaBridge_");
            this.i.removeJavascriptInterface("accessibilityTraversal");
            this.i.removeJavascriptInterface("accessibility");
            String strA2 = u.a(this.i, activityJ);
            this.i.addJavascriptInterface(new b(), "ActivityHelper");
            com.ipd.dsp.internal.w1.c cVar2 = new com.ipd.dsp.internal.w1.c(strA2, this.m);
            this.l = cVar2;
            this.i.addJavascriptInterface(cVar2, com.ipd.dsp.internal.w1.e.h);
        }
        q();
        activityJ.setTitle("");
        try {
            com.ipd.dsp.internal.e1.d dVar = (com.ipd.dsp.internal.e1.d) intent.getSerializableExtra("data");
            this.o = dVar;
            if (dVar != null) {
                HashMap map = new HashMap();
                String str = this.o.r.j;
                this.n = str;
                map.put("Referer", str);
                map.put("X-Request-With", g.a().O());
                if (!this.j || (webView = this.h) == null) {
                    WebView webView4 = this.i;
                    if (webView4 != null) {
                        webView4.loadUrl(this.n, map);
                    }
                } else {
                    webView.loadUrl(this.n, map);
                }
                Pair<String, Boolean> pair = p;
                if (pair == null || (obj = pair.first) == null || !((String) obj).equals(this.o.i) || p.second != null) {
                    com.ipd.dsp.internal.e1.d dVar2 = this.o;
                    p = new Pair<>(dVar2.i, Boolean.valueOf(dVar2.r.w));
                }
            }
        } catch (Throwable th2) {
            r.a(th2);
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void b(String str, String str2) {
        com.ipd.dsp.internal.w1.c cVar;
        if ("beforeClose".equals(str)) {
            if ((str2 == null || str2.equals("null")) && (cVar = this.l) != null) {
                cVar.exit();
            }
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public boolean a(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332) {
            if (v()) {
                return true;
            }
            if (r()) {
                s();
            } else {
                b();
            }
            return true;
        }
        return super.a(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (j() != null) {
            j().runOnUiThread(new Runnable() { // from class: com.zj.adlib.fea
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41659a.t();
                }
            });
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public boolean b(int i) {
        if (i == 4) {
            if (v()) {
                return true;
            }
            if (r()) {
                s();
            } else {
                b();
            }
            return true;
        }
        return super.b(i);
    }
}
