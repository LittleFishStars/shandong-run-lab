package com.beizi.fusion;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.beizi.ad.AdActivity;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class y4 implements AdActivity.b {
    public static LinkedList j = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f28053a;
    private WebView b;
    private ImageView c;
    private boolean d;
    private boolean e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            y4.this.h = true;
            return false;
        }
    }

    public class b implements DownloadListener {
        public b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }
    }

    public class d extends wp {
        final /* synthetic */ ProgressBar d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, ProgressBar progressBar) {
            super(activity);
            this.d = progressBar;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (callback != null) {
                try {
                    callback.invoke(str, false, false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i < 100 && this.d.getVisibility() == 8) {
                this.d.setVisibility(0);
            }
            this.d.setProgress(i);
            if (i == 100) {
                this.d.setVisibility(8);
            }
        }

        @Override // com.beizi.fusion.wp, android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            if (view instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) view;
                if (frameLayout.getFocusedChild() instanceof VideoView) {
                    VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                    frameLayout.removeView(videoView);
                    if (y4.this.b.getContext() instanceof Activity) {
                        ((Activity) y4.this.b.getContext()).setContentView(videoView);
                    }
                    videoView.start();
                }
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y4.this.d();
        }
    }

    public y4(Activity activity, boolean z, boolean z2, String str, int i) {
        this.f28053a = activity;
        this.d = z;
        this.e = z2;
        this.f = str;
        this.i = i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.i) {
            if (this.g && !this.h) {
                return;
            } else {
                this.g = true;
            }
        }
        Uri uri = po.b(str) ? null : Uri.parse(str);
        if (uri == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        try {
            this.f28053a.startActivity(intent);
            destroy();
            d();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Activity activity = this.f28053a;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.i && !this.g && !TextUtils.isEmpty(this.f)) {
                this.g = true;
                Uri uri = Uri.parse(this.f);
                if (uri.getScheme() == null || !uri.getScheme().equals("bzopen") || TextUtils.isEmpty(uri.getHost()) || uri.getPathSegments().size() <= 0) {
                    if (this.f.startsWith("hwpps://landingpage")) {
                        Intent intent = new Intent();
                        intent.setData(uri);
                        intent.addFlags(268435456);
                        this.f28053a.startActivity(intent);
                        return;
                    }
                    if (this.f.startsWith("intent")) {
                        Intent uri2 = Intent.parseUri(this.f, 1);
                        uri2.addFlags(268435456);
                        this.f28053a.startActivity(uri2);
                        return;
                    } else {
                        Intent intent2 = new Intent("android.intent.action.VIEW", uri);
                        intent2.addFlags(805339136);
                        this.f28053a.startActivity(intent2);
                        return;
                    }
                }
                Intent intent3 = new Intent();
                intent3.setAction("android.intent.action.MAIN");
                intent3.setFlags(268435456);
                intent3.addCategory("android.intent.category.LAUNCHER");
                String queryParameter = uri.getQueryParameter("flags");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        if (queryParameter.startsWith("0x") || queryParameter.startsWith("0X")) {
                            intent3.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                        } else {
                            intent3.setFlags(Integer.parseInt(queryParameter));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                intent3.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
                String queryParameter2 = uri.getQueryParameter("rect");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        String[] strArrSplit = queryParameter2.split(u15.f19942b);
                        if (strArrSplit.length == 4) {
                            Rect rect = new Rect();
                            rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                            intent3.setSourceBounds(rect);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                this.f28053a.startActivity(intent3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.ad.AdActivity.b
    public WebView a() {
        return this.b;
    }

    @Override // com.beizi.ad.AdActivity.b
    public void b() {
        this.f28053a.setTheme(R.style.BeiZiTheme);
        this.f28053a.setContentView(R.layout.activity_in_app_browser);
        WebView webView = (WebView) j.poll();
        this.b = webView;
        if (webView == null || webView.getSettings() == null) {
            d();
            return;
        }
        if (this.b.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.b.getContext()).setBaseContext(this.f28053a);
        }
        WebView webView2 = (WebView) this.f28053a.findViewById(R.id.web_view);
        webView2.getSettings().setSavePassword(false);
        ViewGroup.LayoutParams layoutParams = webView2.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) webView2.getParent();
        int iIndexOfChild = viewGroup.indexOfChild(webView2);
        viewGroup.removeView(webView2);
        bq.a(this.b);
        this.b.setLayoutParams(layoutParams);
        this.b.getSettings().setUseWideViewPort(true);
        this.b.getSettings().setLoadWithOverviewMode(true);
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.getSettings().setGeolocationEnabled(false);
        WebView.setWebContentsDebuggingEnabled(false);
        viewGroup.addView(this.b, iIndexOfChild);
        ProgressBar progressBar = (ProgressBar) this.f28053a.findViewById(R.id.progress_bar);
        try {
            if (this.i) {
                this.b.setOnTouchListener(new a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.b.setDownloadListener(new b());
        this.b.setWebViewClient(new c());
        this.b.setWebChromeClient(new d(this.f28053a, progressBar));
        ImageView imageView = (ImageView) this.f28053a.findViewById(R.id.close_iv);
        this.c = imageView;
        imageView.setOnClickListener(new e());
    }

    @Override // com.beizi.ad.AdActivity.b
    public void destroy() {
        WebView webView = this.b;
        if (webView == null) {
            return;
        }
        bq.a(webView);
        this.b.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return !b(str) || this.d;
    }

    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
            if (cookieSyncManager != null) {
                cookieSyncManager.sync();
            }
            y4.this.e();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                Uri url = webResourceRequest.getUrl();
                if (url == null) {
                    return false;
                }
                String string = url.toString();
                if (!string.startsWith("http")) {
                    if (y4.this.a(string)) {
                        y4.this.c(string);
                    }
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
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http")) {
                return false;
            }
            if (!y4.this.a(str)) {
                return true;
            }
            y4.this.c(str);
            return true;
        }
    }

    @Override // com.beizi.ad.AdActivity.b
    public void c() {
        kh.a("lance", "...........................backPressed...........................");
        if (this.b.canGoBack()) {
            this.b.goBack();
            kh.a("lance", " mWebView.goBack()");
        } else {
            d();
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
}
