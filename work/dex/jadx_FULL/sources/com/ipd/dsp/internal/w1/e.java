package com.ipd.dsp.internal.w1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.huachenjie.mall.page.pay.PayResultActivity;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.q;
import com.ipd.dsp.internal.c2.r;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {
    public static final String h = "ZJSdk";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f38600a;
    public String b = null;
    public com.ipd.dsp.internal.p1.e c;
    public WebView d;
    public View e;
    public c f;
    public b g;

    public static class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f38601a;

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f38601a = null;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public boolean b(String str) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return false;
            }
            return this.f38601a.c.e(str);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void d() {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.q();
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        @Nullable
        public Context getContext() {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return null;
            }
            return this.f38601a.c.getContext();
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public JSONObject getCustomData() {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return null;
            }
            return this.f38601a.c.getCustomData();
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public String getOriginalUrl() {
            e eVar = this.f38601a;
            if (eVar != null) {
                return eVar.b;
            }
            return null;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void setTitle(int i) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.d(i);
        }

        public b(e eVar) {
            this.f38601a = eVar;
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(String str) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.h(str);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void c(String str) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.f(str);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void b() {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.j();
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void d(String str) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.g(str);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(@Nullable JSONObject jSONObject) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.b(jSONObject);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public JSONObject a() {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return null;
            }
            return this.f38601a.c.getAdData();
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(com.ipd.dsp.internal.h1.a.c cVar, JSONObject jSONObject) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.a(cVar, jSONObject);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(int i, int i2) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.a(i, i2);
        }

        @Override // com.ipd.dsp.internal.w1.c.a
        public void a(int i, JSONObject jSONObject) {
            e eVar = this.f38601a;
            if (eVar == null || eVar.c == null) {
                return;
            }
            this.f38601a.c.a(i, jSONObject);
        }
    }

    public e(Context context, com.ipd.dsp.internal.p1.e eVar) {
        boolean zA = q.a();
        this.f38600a = zA;
        this.c = eVar;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.g = new b();
        if (zA) {
            com.tencent.smtt.sdk.WebView webView = new com.tencent.smtt.sdk.WebView(context);
            this.e = webView;
            webView.setBackgroundColor(-1);
            this.e.setLayoutParams(layoutParams);
            this.e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.e.removeJavascriptInterface("accessibilityTraversal");
            this.e.removeJavascriptInterface("accessibility");
            c cVar = new c(f.a(context, this.e), this.g);
            this.f = cVar;
            this.e.addJavascriptInterface(cVar, h);
            return;
        }
        WebView webView2 = new WebView(context);
        this.d = webView2;
        webView2.setBackgroundColor(-1);
        this.d.setLayoutParams(layoutParams);
        this.d.removeJavascriptInterface("searchBoxJavaBridge_");
        this.d.removeJavascriptInterface("accessibilityTraversal");
        this.d.removeJavascriptInterface("accessibility");
        c cVar2 = new c(com.ipd.dsp.internal.w1.b.a(context, this.d), this.g);
        this.f = cVar2;
        this.d.addJavascriptInterface(cVar2, h);
    }

    public View d() {
        return this.f38600a ? this.e : this.d;
    }

    public final void e() {
        com.tencent.smtt.sdk.WebView webView;
        if (this.f38600a && (webView = this.e) != null) {
            webView.goBack();
            return;
        }
        WebView webView2 = this.d;
        if (webView2 != null) {
            webView2.goBack();
        }
    }

    public boolean f() {
        if (!a()) {
            return false;
        }
        e();
        return true;
    }

    public void g() {
        a("beforeClose", null);
    }

    public void h() {
        a("onPause", null);
    }

    public void i() {
        a("onResume", null);
    }

    public void a(String str) {
        com.tencent.smtt.sdk.WebView webView;
        this.b = str;
        HashMap map = new HashMap();
        map.put("Referer", str);
        if (this.f38600a && (webView = this.e) != null) {
            webView.loadUrl(str, map);
            return;
        }
        WebView webView2 = this.d;
        if (webView2 != null) {
            webView2.loadUrl(str, map);
        }
    }

    public String c() {
        com.tencent.smtt.sdk.WebView webView;
        if (this.f38600a && (webView = this.e) != null) {
            return webView.getUrl();
        }
        WebView webView2 = this.d;
        if (webView2 != null) {
            return webView2.getUrl();
        }
        return null;
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void c(String str, String str2) {
        c cVar;
        if ("beforeClose".equals(str)) {
            if ((str2 == null || str2.equals("null")) && (cVar = this.f) != null) {
                cVar.exit();
            }
        }
    }

    public void b() {
        com.tencent.smtt.sdk.WebView webView;
        this.c = null;
        b bVar = this.g;
        if (bVar != null) {
            bVar.c();
            this.g = null;
        }
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
            this.f = null;
        }
        if (this.f38600a && (webView = this.e) != null) {
            webView.removeJavascriptInterface(h);
            f.a(this.e);
            this.e = null;
        } else {
            WebView webView2 = this.d;
            if (webView2 != null) {
                webView2.removeJavascriptInterface(h);
                com.ipd.dsp.internal.w1.b.a(this.d);
                this.d = null;
            }
        }
    }

    public void a(int i, boolean z, int i2, String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", i);
            jSONObject.put(PayResultActivity.t, z);
            jSONObject.put("code", i2);
            jSONObject.put("message", str);
        } catch (JSONException unused) {
        }
        d().post(new Runnable() { // from class: com.zj.adlib.xya
            @Override // java.lang.Runnable
            public final void run() {
                this.f45922a.a(jSONObject);
            }
        });
    }

    public final /* synthetic */ void a(JSONObject jSONObject) {
        a("clickCallback", jSONObject.toString());
    }

    public final void a(final String str, String str2) {
        com.tencent.smtt.sdk.WebView webView;
        c cVar = this.f;
        if (cVar != null) {
            String strA = cVar.a(str);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            if (o.c(str2)) {
                strA = strA.replace("ZJ_PARAMS", str2);
            }
            try {
                if (this.f38600a && (webView = this.e) != null) {
                    webView.evaluateJavascript(strA, new ValueCallback() { // from class: com.zj.adlib.xxa
                        public final void a(Object obj) {
                            this.f45916a.b(str, (String) obj);
                        }
                    });
                    return;
                }
                WebView webView2 = this.d;
                if (webView2 != null) {
                    webView2.evaluateJavascript(strA, new android.webkit.ValueCallback() { // from class: com.zj.adlib.rya
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            this.f44567a.c(str, (String) obj);
                        }
                    });
                }
            } catch (Throwable th) {
                r.a(th);
            }
        }
    }

    public final boolean a() {
        com.tencent.smtt.sdk.WebView webView;
        try {
            if (this.f38600a && (webView = this.e) != null) {
                return webView.canGoBack();
            }
            WebView webView2 = this.d;
            return webView2 != null && webView2.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }
}
