package com.byazt.jwd;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byakv.z.SoftDecTool;
import com.byazt.aas.aw;
import com.byazt.aas.gr;
import com.byazt.aas.nb;
import com.byazt.aas.zb;
import com.byazt.ddx.a;
import com.byazt.el.SSWebView;
import com.byazt.ete.cu;
import com.byazt.ete.ic;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nr.sp;
import com.byazt.nr.yp;
import com.byazt.ol.n;
import com.byazt.omf.d;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 769, 15})
public class uj extends WebViewClient implements SSWebView.ve {
    public static final HashSet<String> sl;
    public com.byazt.tjs.uj c;
    public a n;
    public final d tt;
    public final String uj;
    public final Context ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28702a = true;
    public boolean sp = true;
    public volatile AtomicInteger x = new AtomicInteger(0);
    public long i = -1;
    public boolean da = false;

    static {
        HashSet<String> hashSet = new HashSet<>();
        sl = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add(FileTypeUtils.FILE_TYPE_GIF);
        hashSet.add("svg");
        hashSet.add(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG);
    }

    public uj(Context context, d dVar, String str) {
        this.ve = context;
        this.tt = dVar;
        this.uj = str;
    }

    private boolean c(Uri uri) {
        File fileTt = sp.tt(gt.getContext(), false, null);
        if (uri != null) {
            try {
                String lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment != null) {
                    File canonicalFile = new File(fileTt, lastPathSegment).getCanonicalFile();
                    if (canonicalFile.exists() && !canonicalFile.getPath().startsWith(fileTt.toString())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        return false;
    }

    private static String tt(String str) {
        int iLastIndexOf;
        String strSubstring;
        if (str == null || (iLastIndexOf = str.lastIndexOf(46)) < 0 || iLastIndexOf == str.length() - 1 || (strSubstring = str.substring(iLastIndexOf)) == null || !sl.contains(strSubstring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + strSubstring;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.c(webView);
        }
        if (webView != null && this.f28702a) {
            try {
                String strC = tt.c(gt.tt().kp(), this.uj);
                if (!TextUtils.isEmpty(strC)) {
                    yp.c(webView, strC);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        a aVar = this.n;
        if (aVar != null) {
            aVar.c(webView, str, bitmap);
        }
        if (this.sp) {
            tt.c(this.ve).c(true).c(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        a aVar = this.n;
        if (aVar != null) {
            aVar.c(i, str, str2, tt(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.n == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey(SubscribeResouceItemModel.ACCEPT)) {
            str = requestHeaders.get(SubscribeResouceItemModel.ACCEPT);
        }
        this.n.c(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), string, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.n != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            String url = null;
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    url = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.n.c(primaryError, str, url, tt(url));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (renderProcessGoneDetail.didCrash()) {
            m.uj("WebChromeClient", "The WebView rendering process crashed!");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                n.c().tt();
            }
            return true;
        }
        m.uj("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            n.c().tt();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null && c(webResourceRequest.getUrl())) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.c != null) {
            webResourceResponseShouldInterceptRequest = this.c.c(webView, new com.byazt.tjs.tt(webResourceRequest, null), webResourceResponseShouldInterceptRequest);
        }
        if (c(webView, webResourceRequest)) {
            return new WebResourceResponse("", "", null);
        }
        Set<com.byazt.ete.d.ve> setC = aw.c().c(webResourceRequest.getUrl().toString());
        if (setC == null || setC.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        aw awVarC = aw.c();
        String string = webResourceRequest.getUrl().toString();
        a aVar = this.n;
        return awVarC.c(webResourceResponseShouldInterceptRequest, string, setC, aVar != null ? aVar.x() : null);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        d dVar;
        c(str);
        try {
            if (c(webView, str)) {
                return true;
            }
            com.byazt.tjs.uj ujVar = this.c;
            if (ujVar != null) {
                ujVar.c(webView, str);
            }
            Uri uri = Uri.parse(str);
            String lowerCase = uri.getScheme().toLowerCase();
            if ("bytedance".equals(lowerCase)) {
                com.byazt.aas.gt.c(uri, this.tt);
                return true;
            }
            if (x.m().nb() != null && ((Boolean) x.m().nb().apply(com.byazt.yxi.uj.c().c(15).c(Boolean.class).c(0, new zb().c("uri", uri)).tt())).booleanValue()) {
                d dVar2 = this.tt;
                boolean zC = (dVar2 == null || dVar2.x() == null) ? false : com.byazt.qt.ve.c(uri, this.tt.x(), this.ve, this.tt.md(), hashCode());
                com.byazt.omf.tt.c().put("is_landing_page_open_market", true);
                if (zC) {
                    return true;
                }
            }
            if (!rh.c(str) && (dVar = this.tt) != null && dVar.x() != null) {
                String strMd = this.tt.md();
                ic icVarX = this.tt.x();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(268435456);
                HashMap map = new HashMap();
                map.put("source", "TTWebViewClient");
                map.put(NativeModel.JSON_KEY_SCHEME, lowerCase);
                com.byazt.ddx.uj.c(icVarX, strMd, (Map<String, Object>) map, true);
                if (!nb.yv()) {
                    try {
                        ComponentName componentNameResolveActivity = intent.resolveActivity(this.ve.getPackageManager());
                        if (componentNameResolveActivity == null || !componentNameResolveActivity.getPackageName().equals(this.ve.getPackageName())) {
                            if ((intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                                c(this.ve, intent, icVarX, strMd);
                            } else {
                                com.byazt.ddx.uj.c(icVarX, strMd, (Throwable) new RuntimeException("webview client intent flag error"), true, false);
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.ddx.uj.c(icVarX, strMd, th, true, false);
                    }
                } else if (nb.c(intent)) {
                    c(this.ve, intent, icVarX, strMd);
                } else {
                    com.byazt.ddx.uj.c(icVarX, strMd, (Throwable) new RuntimeException("query is true,install is false"), true, false);
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Exception e) {
            m.tt("WebChromeClient", "shouldOverrideUrlLoading", e);
            com.byazt.ukr.yp.c().c("wb_loading", e);
            d dVar3 = this.tt;
            if (dVar3 != null && dVar3.i()) {
                return true;
            }
        }
    }

    public void ve() {
        this.da = true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.n == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String string = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey(SubscribeResouceItemModel.ACCEPT)) {
            str = requestHeaders.get(SubscribeResouceItemModel.ACCEPT);
        }
        this.n.c(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), string, str);
    }

    public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
        return cu.c(webView, this.x, this.tt, webResourceRequest, false, tt()) && !(this instanceof com.byazt.ouz.sp);
    }

    public boolean c(WebView webView, String str) {
        return cu.c(webView, this.x, this.tt, str, false, tt()) && !(this instanceof com.byazt.ouz.sp);
    }

    public boolean tt() {
        return System.currentTimeMillis() - this.i < ((long) gt.tt().xr());
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) {
            com.byazt.ddx.uj.ve(this.tt.x(), "landingpage", "lp_pay");
        }
    }

    public void tt(boolean z) {
        if (!z || this.da) {
            this.i = System.currentTimeMillis();
        }
    }

    public uj(Context context, d dVar, String str, a aVar) {
        this.ve = context;
        this.tt = dVar;
        this.uj = str;
        this.n = aVar;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (str != null && c(Uri.parse(str))) {
            return null;
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        if (this.c != null) {
            webResourceResponseShouldInterceptRequest = this.c.c(webView, new com.byazt.tjs.tt(null, str), webResourceResponseShouldInterceptRequest);
        }
        if (c(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        Set<com.byazt.ete.d.ve> setC = aw.c().c(str);
        if (setC == null || setC.isEmpty()) {
            return webResourceResponseShouldInterceptRequest;
        }
        aw awVarC = aw.c();
        a aVar = this.n;
        return awVarC.c(webResourceResponseShouldInterceptRequest, str, setC, aVar != null ? aVar.x() : null);
    }

    private void c(Context context, Intent intent, final ic icVar, final String str) {
        com.byazt.nr.tt.c(context, intent, new com.byazt.nr.tt.c() { // from class: com.byazt.jwd.uj.1
            @Override // com.byazt.nr.tt.c
            public void c() {
                com.byazt.ddx.uj.c(icVar, str, (Throwable) null, true, true);
                com.byazt.ddx.x.c().c(icVar, str, true, false, null);
            }

            @Override // com.byazt.nr.tt.c
            public void c(Throwable th) {
                com.byazt.ddx.uj.c(icVar, str, th, true, false);
            }
        }, TextUtils.equals(p.x, "internal"));
    }

    @Override // com.byazt.el.SSWebView.ve
    public void c(boolean z) {
        d dVar = this.tt;
        if (dVar != null) {
            dVar.ve(z);
        }
    }

    @Override // com.byazt.el.SSWebView.ve
    public void c(MotionEvent motionEvent) {
        ic icVarX;
        JSONObject jSONObjectQ_;
        d dVar = this.tt;
        if (dVar == null || (icVarX = dVar.x()) == null || (jSONObjectQ_ = icVarX.q_()) == null) {
            return;
        }
        final int iOptInt = jSONObjectQ_.optInt("rit", 0);
        int toolType = motionEvent.getToolType(0);
        if (motionEvent.getActionMasked() == 0) {
            gr.c(motionEvent);
            if (toolType == 0) {
                da.c().post(new Runnable() { // from class: com.byazt.jwd.uj.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SoftDecTool.codeIdCountMap.put(Integer.valueOf(iOptInt), Integer.valueOf(SoftDecTool.codeIdCountMap.getOrDefault(Integer.valueOf(iOptInt), 0).intValue() + 1));
                    }
                });
            }
        }
    }

    public uj(Context context, d dVar, String str, a aVar, com.byazt.tjs.uj ujVar) {
        this.ve = context;
        this.tt = dVar;
        this.uj = str;
        this.n = aVar;
        this.c = ujVar;
    }
}
