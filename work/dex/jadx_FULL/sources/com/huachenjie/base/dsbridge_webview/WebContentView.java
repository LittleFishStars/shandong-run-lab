package com.huachenjie.base.dsbridge_webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huachenjie.base.dsbridge_webview.interceptor.JavascriptBridge;
import com.huachenjie.common.R;
import com.huachenjie.common.cache_webview.WebViewCacheManager;
import com.huachenjie.common.callback.VoidCallback;
import com.zj.adlib.i4a;
import com.zj.adlib.qa6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class WebContentView extends FrameLayout {
    public static final int L = 0;
    public static final int M = 404;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebViewClient f32928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DWebView f7207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public JavascriptApi f7208a;
    public final WebViewClient b;
    public final String f;
    public final String g;
    public FrameLayout mCustomViewContent;
    public View mErrorView;

    public class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f7209a = true;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f7209a = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            this.f7209a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            if (WebContentView.this.f32928a != null) {
                WebContentView.this.f32928a.onPageFinished(view, url);
            } else {
                super.onPageFinished(view, url);
            }
            if (WebContentView.this.K == 0) {
                WebContentView.this.mErrorView.setVisibility(8);
                WebContentView.this.f7207a.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
            if (WebContentView.this.f32928a != null) {
                WebContentView.this.f32928a.onPageStarted(webView, s, bitmap);
            } else {
                super.onPageStarted(webView, s, bitmap);
            }
            WebContentView.this.K = 0;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String s, String s1) {
            if (WebContentView.this.f32928a != null) {
                WebContentView.this.f32928a.onReceivedError(webView, i, s, s1);
            } else {
                super.onReceivedError(webView, i, s, s1);
            }
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            return WebViewCacheManager.INSTANCE.a().c(url);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if (url == null || !this.f7209a) {
                return true;
            }
            if (url.toLowerCase().startsWith("http")) {
                WebViewCacheManager.INSTANCE.a().b(webView, url);
                return true;
            }
            if (url.toLowerCase().startsWith(WVUCWebViewClient.SCHEME_TEL) || url.toLowerCase().startsWith(WVUCWebViewClient.SCHEME_SMS)) {
                try {
                    WebContentView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                } catch (Exception unused) {
                }
                return true;
            }
            try {
                this.f7209a = false;
                qa6.a().b().a(webView.getContext(), url, new VoidCallback() { // from class: com.zj.adlib.mu9
                    @Override // com.huachenjie.common.callback.VoidCallback
                    public final void a() {
                        this.f43388a.c();
                    }
                }, new VoidCallback() { // from class: com.zj.adlib.nu9
                    @Override // com.huachenjie.common.callback.VoidCallback
                    public final void a() {
                        this.f43611a.d();
                    }
                });
            } catch (Exception unused2) {
                this.f7209a = true;
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            return WebViewCacheManager.INSTANCE.a().d(request);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (WebContentView.this.f32928a != null) {
                WebContentView.this.f32928a.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
            if (webResourceRequest.isForMainFrame()) {
                WebContentView.this.mErrorView.setVisibility(0);
                WebContentView.this.f7207a.setVisibility(8);
            }
            WebContentView.this.K = 404;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return shouldOverrideUrlLoading(view, request.getUrl().toString());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            WebContentView.this.f7207a.reload();
        }
    }

    public WebContentView(@NonNull Context context) {
        this(context, null);
    }

    public final void e(String jsClassName, String jsName) {
        try {
            this.f7207a.addJavascriptObject((JavascriptBridge) Class.forName(jsClassName).getConstructor(DWebView.class).newInstance(this.f7207a), jsName);
            i4a.a("add extraApi success");
        } catch (Exception e) {
            i4a.a("add extraApi fail");
            i4a.a(e.getMessage());
        }
    }

    public final void f(Context context) {
        if (isInEditMode()) {
            initError(context);
            return;
        }
        initWebView(context);
        initError(context);
        initCustomViewContent(context);
        this.mErrorView.setVisibility(8);
    }

    public FrameLayout.LayoutParams getChildLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public FrameLayout getCustomViewContent() {
        return this.mCustomViewContent;
    }

    public DWebView getWebView() {
        return this.f7207a;
    }

    public void initCustomViewContent(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mCustomViewContent = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mCustomViewContent);
        this.mCustomViewContent.setVisibility(8);
    }

    public void initError(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_web_network_error, (ViewGroup) null);
        this.mErrorView = viewInflate;
        viewInflate.setLayoutParams(getChildLayoutParams());
        this.mErrorView.findViewById(R.id.web_net_error_bt).setOnClickListener(new b());
        addView(this.mErrorView);
    }

    public void initWebView(Context context) {
        DWebView dWebView = new DWebView(context, null);
        this.f7207a = dWebView;
        dWebView.setLayoutParams(getChildLayoutParams());
        this.f7207a.setWebViewClient(this.b);
        String userAgentString = this.f7207a.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            userAgentString = "";
        }
        this.f7207a.getSettings().setUserAgentString(userAgentString + " shandong/" + com.blankj.utilcode.util.b.C());
        JavascriptApi javascriptApi = new JavascriptApi(this.f7207a);
        this.f7208a = javascriptApi;
        this.f7207a.addJavascriptObject(javascriptApi, null);
        e("com.huachenjie.social_contact.web.UniverseJavascriptApi", "universe");
        initWebViewConfig(this.f7207a);
        addView(this.f7207a);
    }

    public void initWebViewConfig(DWebView webView) {
    }

    public boolean loadFail() {
        return this.K == 404;
    }

    public void onDestroy() {
        Object javascriptObject;
        JavascriptApi javascriptApi = this.f7208a;
        if (javascriptApi != null) {
            javascriptApi.P0();
        }
        DWebView dWebView = this.f7207a;
        if (dWebView == null || (javascriptObject = dWebView.getJavascriptObject("universe")) == null || !(javascriptObject instanceof JavascriptBridge)) {
            return;
        }
        ((JavascriptBridge) javascriptObject).release();
    }

    public void setCustomWebViewClient(WebViewClient webViewClient) {
        this.f32928a = webViewClient;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener listener) {
        getWebView().setOnClickListener(listener);
    }

    public WebContentView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WebContentView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f = "universe";
        this.g = "timeFilm";
        this.K = 0;
        this.f32928a = new WebViewClient();
        this.b = new a();
        f(context);
    }
}
