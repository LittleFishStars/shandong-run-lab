package android.taobao.windvane.extra.uc;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.b.f;
import android.taobao.windvane.b.g;
import android.taobao.windvane.base.b;
import android.taobao.windvane.base.e;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.extra.service.c;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.extension.RenderProcessGoneDetail;
import com.uc.webview.export.extension.UCExtension;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVUCWebViewClient extends WebViewClient {
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_SMS = "sms:";
    public static final String SCHEME_TEL = "tel:";
    private static final String TAG = "WVUCWebViewClient";
    boolean isError;
    protected WeakReference<Context> mContext;
    private int crashCount = 0;
    private long lastCrashTime = 0;
    private e prefetchDelegateService = (e) m.a().b(e.class);
    private j monitorService = (j) m.a().b(j.class);
    private b configService = (b) m.a().b(b.class);
    private b.InterfaceC0007b urlService = (b.InterfaceC0007b) m.a().b(b.InterfaceC0007b.class);
    private c preCacheService = (c) m.a().b(c.class);

    public WVUCWebViewClient(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    private WebResourceResponse shouldInterceptRequestInternal(WebView webView, String str, f fVar) {
        if (fVar.f21196a) {
            TaoLog.i("ZCache", "预加载命中 : " + str);
            return android.taobao.windvane.extra.c.b.a(str, fVar.f, fVar.c, fVar.d, fVar.e);
        }
        android.taobao.windvane.extra.service.b bVar = (android.taobao.windvane.extra.service.b) m.a().b(android.taobao.windvane.extra.service.b.class);
        j jVar = this.monitorService;
        if (jVar != null && jVar.d() != null) {
            this.monitorService.d().a(str, 0, bVar == null ? -1 : bVar.b(), (Map<String, String>) null, (android.taobao.windvane.a.f.a) null);
        }
        TaoLog.i(TAG, "shouldInterceptRequest : " + str);
        return super.shouldInterceptRequest(webView, str);
    }

    public int getCrashCount() {
        return this.crashCount;
    }

    public void onPageFinished(WebView webView, final String str) {
        int iB;
        TaoLog.i(TAG, "onPageFinished : " + str);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.isError && webView.getVisibility() == 4) {
            this.isError = false;
            webView.setVisibility(0);
        }
        super.onPageFinished(webView, str);
        if (webView instanceof WVUCWebView) {
            WVUCWebView wVUCWebView = (WVUCWebView) webView;
            wVUCWebView.setCurrentUrl(str, "onPageFinished");
            wVUCWebView.onMessage(401, null);
        }
        if (webView instanceof android.taobao.windvane.d.b) {
            android.taobao.windvane.d.b bVar = (android.taobao.windvane.d.b) webView;
            g.a().a(1002, bVar, str, new Object[0]);
            bVar.fireEvent("WindVaneReady", String.format("{'version':'%s'}", "8.5.0"));
        }
        j jVar = this.monitorService;
        if (jVar != null && jVar.d() != null) {
            UCExtension uCExtension = webView.getUCExtension();
            boolean zIsLoadFromCachedPage = uCExtension != null ? uCExtension.isLoadFromCachedPage() : false;
            android.taobao.windvane.extra.service.b bVar2 = (android.taobao.windvane.extra.service.b) m.a().b(android.taobao.windvane.extra.service.b.class);
            android.taobao.windvane.a.f fVarD = this.monitorService.d();
            if (zIsLoadFromCachedPage) {
                iB = 72;
            } else {
                iB = bVar2 == null ? -1 : bVar2.b();
            }
            fVarD.a(str, -1, iB, null, null, null, null, null);
        }
        webView.evaluateJavascript("(function(p){if(!p||!p.timing)return;var t=p.timing,s=t.navigationStart,sc=t.secureConnectionStart,dc=t.domComplete,lee=t.loadEventEnd;return JSON.stringify({dns:t.domainLookupEnd-t.domainLookupStart,c:t.connectEnd-t.connectStart,scs:sc>0?sc-s:0,req:t.requestStart-s,rps:t.responseStart-s,rpe:t.responseEnd-s,dl:t.domLoading-s,dcl:t.domContentLoadedEventEnd-s,dc:dc>0?dc-s:0,lee:lee>0?lee-s:0})})(window.performance)", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                if (WVUCWebViewClient.this.monitorService == null || WVUCWebViewClient.this.monitorService.d() == null) {
                    return;
                }
                WVUCWebViewClient.this.monitorService.d().a(str, str2);
                WVUCWebViewClient.this.monitorService.d().b(str, jCurrentTimeMillis);
            }
        });
        TaoLog.i(TAG, str + " LayerType : " + webView.getLayerType());
        if (this.monitorService != null) {
            if (WebView.getCoreType() == 1 || WebView.getCoreType() == 3) {
                TaoLog.d(TAG, "onPageFinished.  core type = " + WebView.getCoreType());
                if (this.monitorService.b() != null) {
                    this.monitorService.b().a("WebViewCoreTypeByPV", null);
                }
                if (this.monitorService.f() != null) {
                    this.monitorService.f().a(String.valueOf(this.configService.c().initUCCorePolicy), "U4");
                }
            } else {
                if (this.monitorService.b() != null) {
                    this.monitorService.b().a("WebViewCoreTypeByPV", WebView.getCoreType(), "", "");
                }
                if (this.monitorService.f() != null) {
                    this.monitorService.f().a(String.valueOf(this.configService.c().initUCCorePolicy), "Android");
                }
            }
        }
        if (WebView.getCoreType() == 3) {
            if (webView.getContext() != null) {
                WVUCStaticWebView.createStaticWebViewIfNeeded(webView.getContext());
            }
            c cVar = this.preCacheService;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.isError = false;
        j jVar = this.monitorService;
        if (jVar != null && jVar.d() != null) {
            this.monitorService.d().a(str, System.currentTimeMillis());
        }
        if (webView instanceof WVUCWebView) {
            g.a().a(1001, (android.taobao.windvane.d.b) webView, str, bitmap);
            WVUCWebView wVUCWebView = (WVUCWebView) webView;
            wVUCWebView.onMessage(400, null);
            wVUCWebView.mPageStart = System.currentTimeMillis();
        }
        TaoLog.e(TAG, "onPageStarted : " + str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        if ((webView instanceof android.taobao.windvane.d.b) && g.a().a(1005, (android.taobao.windvane.d.b) webView, str2, Integer.valueOf(i), str, str2).f21196a) {
            return;
        }
        String url = webView.getUrl();
        if (((i > -16 && i < 0) || i == -80 || i == -50) && (webView instanceof WVUCWebView) && (url == null || url.equals(str2))) {
            HashMap map = new HashMap(2);
            map.put("cause", str + " [" + i + "]");
            map.put("url", str2);
            this.isError = true;
            webView.setVisibility(4);
            ((WVUCWebView) webView).onMessage(402, map);
        }
        j jVar = this.monitorService;
        if (jVar == null || jVar.e() == null) {
            return;
        }
        android.taobao.windvane.a.c cVarE = this.monitorService.e();
        if (url != null) {
            str2 = url;
        }
        cVarE.a(str2, i, str);
    }

    @SuppressLint({"NewApi"})
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String string = sslError.toString();
        if (TaoLog.getLogStatus()) {
            TaoLog.e(TAG, "onReceivedSslError  url: " + sslError.getUrl() + "errorMsg:" + string);
        }
        String url = webView.getUrl();
        if (webView instanceof WVUCWebView) {
            HashMap map = new HashMap(2);
            map.put("cause", "SSL_ERROR");
            map.put("url", url);
            ((WVUCWebView) webView).onMessage(402, map);
        }
        if (webView instanceof android.taobao.windvane.d.b) {
            g.a().a(1006, (android.taobao.windvane.d.b) webView, url, string);
        }
        j jVar = this.monitorService;
        if (jVar != null && jVar.e() != null) {
            this.monitorService.e().a(url, 1006, string);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        TaoLog.e("sandbox", "onRenderProcessGone webview:" + webView + ", crash:" + renderProcessGoneDetail.didCrash() + ", priority:" + renderProcessGoneDetail.rendererPriorityAtExit());
        if (this.crashCount == 3) {
            j jVar = this.monitorService;
            if (jVar != null && jVar.f() != null) {
                b bVar = (b) m.a().b(b.class);
                this.monitorService.f().a(webView.getUrl(), "R_Fail", bVar == null ? -1 : bVar.c().ucMultiPolicy);
            }
            this.crashCount = 0;
            return false;
        }
        if (webView == null) {
            return false;
        }
        if (this.lastCrashTime == 0 || System.currentTimeMillis() - this.lastCrashTime < 1000) {
            this.crashCount++;
        }
        this.lastCrashTime = System.currentTimeMillis();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebViewClient.2
            @Override // java.lang.Runnable
            public void run() {
                if (webView.isDestroied()) {
                    return;
                }
                webView.reload();
            }
        }, 200L);
        return true;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (WebView.getCoreType() != 3) {
            TaoLog.w(TAG, "Only U4 WebView will use shouldInterceptRequest(API Level 21), return null.");
            return null;
        }
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            TaoLog.e(TAG, "shouldInterceptRequest, invalid request.");
            return null;
        }
        String string = webResourceRequest.getUrl().toString();
        c cVar = this.preCacheService;
        if (cVar != null && cVar.b(string)) {
            this.preCacheService.c(string);
            return null;
        }
        if (webView instanceof android.taobao.windvane.d.b) {
            return shouldInterceptRequestInternal(webView, string, g.a().a(1008, (android.taobao.windvane.d.b) webView, string, webResourceRequest.getRequestHeaders()));
        }
        return null;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        android.taobao.windvane.base.g gVar;
        b.InterfaceC0007b interfaceC0007b;
        if (WVUrlUtil.isCommonUrl(str) && (interfaceC0007b = this.urlService) != null && interfaceC0007b.c(str)) {
            String strA = this.urlService.a();
            if (TextUtils.isEmpty(strA)) {
                HashMap map = new HashMap(2);
                map.put("cause", "ACCESS_FORBIDDEN");
                map.put("url", str);
                ((WVUCWebView) webView).onMessage(402, map);
            } else {
                webView.loadUrl(strA);
            }
            return true;
        }
        boolean z = webView instanceof android.taobao.windvane.d.b;
        if (z && g.a().a(1003, (android.taobao.windvane.d.b) webView, str, new Object[0]).f21196a) {
            return true;
        }
        Context context = this.mContext.get();
        if (str.startsWith("mailto:") || str.startsWith(SCHEME_TEL) || str.startsWith(SCHEME_SMS)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                TaoLog.e(TAG, "shouldOverrideUrlLoading: ActivityNotFoundException, url=" + str);
            }
            return true;
        }
        if (z && (gVar = (android.taobao.windvane.base.g) m.a().b(android.taobao.windvane.base.g.class)) != null) {
            gVar.b();
            if (gVar.a(false)) {
                gVar.a();
            }
            if (gVar.a(context, (android.taobao.windvane.d.b) webView, str)) {
                TaoLog.i(TAG, "intercept url : " + str);
                return true;
            }
        }
        TaoLog.i(TAG, "shouldOverrideUrlLoading : " + str);
        if (this.prefetchDelegateService != null) {
            HashMap map2 = new HashMap();
            map2.put(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, webView.getSettings().getUserAgentString());
            this.prefetchDelegateService.a(str, map2);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (WebView.getCoreType() == 3) {
            TaoLog.w(TAG, "U4 WebView will not use shouldInterceptRequest(API Level 11), return null.");
            return null;
        }
        if (webView instanceof android.taobao.windvane.d.b) {
            return shouldInterceptRequestInternal(webView, str, g.a().a(1004, (android.taobao.windvane.d.b) webView, str, new Object[0]));
        }
        return null;
    }
}
