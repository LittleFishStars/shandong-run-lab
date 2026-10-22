package com.beizi.ad.internal.download;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.beizi.fusion.a4;
import com.beizi.fusion.po;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f26870a;
    private boolean b;
    private boolean c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BeiZiWebView.this.g = true;
            return false;
        }
    }

    public BeiZiWebView(Context context) {
        super(context);
        a();
    }

    private void a() {
        try {
            c();
        } catch (Throwable unused) {
        }
    }

    private boolean b(String str) {
        List listI = a4.j().i();
        if (listI == null || listI.size() <= 0) {
            return false;
        }
        Iterator it = listI.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setEnableSmoothTransition(true);
        settings.setLightTouchEnabled(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadsImagesAutomatically(true);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        WebView.setWebContentsDebuggingEnabled(false);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setGeolocationEnabled(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
        setWebViewClient(new a());
        Map map = this.f26870a;
        if (map != null) {
            if (map.containsKey("isRedirectionCanJump") && (obj5 = this.f26870a.get("isRedirectionCanJump")) != null && (obj5 instanceof Boolean)) {
                this.b = ((Boolean) obj5).booleanValue();
            }
            if (this.f26870a.containsKey("isDownload") && (obj4 = this.f26870a.get("isDownload")) != null && (obj4 instanceof Boolean)) {
                this.c = ((Boolean) obj4).booleanValue();
            }
            if (this.f26870a.containsKey("landingPageUrl") && (obj3 = this.f26870a.get("landingPageUrl")) != null && (obj3 instanceof String)) {
                this.e = (String) obj3;
            }
            if (this.f26870a.containsKey("deeplinkUrl") && (obj2 = this.f26870a.get("deeplinkUrl")) != null && (obj2 instanceof String)) {
                this.d = (String) obj2;
            }
            if (this.f26870a.containsKey("webDeepLink") && (obj = this.f26870a.get("webDeepLink")) != null && (obj instanceof Boolean)) {
                this.h = ((Boolean) obj).booleanValue();
            }
        }
        if (this.h) {
            setOnTouchListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return !b(str) || this.b;
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (this.h && !this.f && !TextUtils.isEmpty(this.d)) {
                this.f = true;
                Uri uri = Uri.parse(this.d);
                if (uri.getScheme() != null && uri.getScheme().equals("bzopen") && !TextUtils.isEmpty(uri.getHost()) && uri.getPathSegments().size() > 0) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.MAIN");
                    intent.setFlags(268435456);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    String queryParameter = uri.getQueryParameter("flags");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        try {
                            if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                                intent.setFlags(Integer.parseInt(queryParameter));
                            } else {
                                intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    intent.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
                    String queryParameter2 = uri.getQueryParameter("rect");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        try {
                            String[] strArrSplit = queryParameter2.split(u15.f19942b);
                            if (strArrSplit.length == 4) {
                                Rect rect = new Rect();
                                rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                                intent.setSourceBounds(rect);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    getContext().startActivity(intent);
                    return;
                }
                if (this.d.startsWith("hwpps://landingpage")) {
                    Intent intent2 = new Intent();
                    intent2.setData(uri);
                    intent2.addFlags(268435456);
                    getContext().startActivity(intent2);
                    return;
                }
                if (this.d.startsWith("intent")) {
                    Intent uri2 = Intent.parseUri(this.d, 1);
                    uri2.addFlags(268435456);
                    getContext().startActivity(uri2);
                } else {
                    Intent intent3 = new Intent("android.intent.action.VIEW", uri);
                    intent3.addFlags(805339136);
                    getContext().startActivity(intent3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public BeiZiWebView(Context context, Map<String, Object> map) {
        super(context);
        this.f26870a = map;
        a();
    }

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            BeiZiWebView beiZiWebView = BeiZiWebView.this;
            if (beiZiWebView.f26870a != null) {
                beiZiWebView.b();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                Uri url = webResourceRequest.getUrl();
                if (url == null) {
                    return false;
                }
                String string = url.toString();
                if (string.startsWith("http")) {
                    BeiZiWebView beiZiWebView = BeiZiWebView.this;
                    if (beiZiWebView.f26870a != null && beiZiWebView.a(string)) {
                        BeiZiWebView.this.c(string);
                    }
                    return false;
                }
                if (BeiZiWebView.this.f26870a == null) {
                    return true;
                }
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                if (requestHeaders == null || requestHeaders.size() == 0) {
                    requestHeaders = new HashMap<>();
                }
                requestHeaders.put(com.google.common.net.b.c1, "");
                webView.loadUrl(string, requestHeaders);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http")) {
                return false;
            }
            BeiZiWebView beiZiWebView = BeiZiWebView.this;
            if (beiZiWebView.f26870a == null || !beiZiWebView.a(str)) {
                return true;
            }
            BeiZiWebView.this.c(str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.h) {
            if (this.f && !this.g) {
                return;
            } else {
                this.f = true;
            }
        }
        Uri uri = po.b(str) ? null : Uri.parse(str);
        if (uri == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        try {
            getContext().startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
