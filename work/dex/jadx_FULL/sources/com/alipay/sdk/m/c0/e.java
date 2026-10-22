package com.alipay.sdk.m.c0;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.y.n;
import com.alipay.sdk.m.y.q;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends LinearLayout {
    public static Handler m = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f25413a;
    public TextView b;
    public ImageView c;
    public ProgressBar d;
    public WebView e;
    public final C0194e f;
    public f g;
    public g h;
    public h i;
    public final com.alipay.sdk.m.w.a j;
    public View.OnClickListener k;
    public final float l;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: com.alipay.sdk.m.c0.e$a$a, reason: collision with other inner class name */
        public class RunnableC0193a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f25415a;

            public RunnableC0193a(View view) {
                this.f25415a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f25415a.setEnabled(true);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = e.this.i;
            if (hVar != null) {
                view.setEnabled(false);
                e.m.postDelayed(new RunnableC0193a(view), 256L);
                if (view == e.this.f25413a) {
                    hVar.a(e.this);
                } else if (view == e.this.c) {
                    hVar.b(e.this);
                }
            }
        }
    }

    public class b implements DownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25416a;

        public b(Context context) {
            this.f25416a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.f25416a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.g.a(e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (!e.this.f.b) {
                e.this.d.setVisibility(8);
            } else {
                if (i > 90) {
                    e.this.d.setVisibility(4);
                    return;
                }
                if (e.this.d.getVisibility() == 4) {
                    e.this.d.setVisibility(0);
                }
                e.this.d.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            e.this.g.a(e.this, str);
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (e.this.h.b(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (e.this.h.c(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (e.this.h.a(e.this, i, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (e.this.h.a(e.this, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return e.this.h.a(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (e.this.h.d(e.this, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.c0.e$e, reason: collision with other inner class name */
    public static final class C0194e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f25419a;
        public boolean b;

        public C0194e(boolean z, boolean z2) {
            this.f25419a = z;
            this.b = z2;
        }
    }

    public interface f {
        void a(e eVar, String str);

        boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    public interface g {
        WebResourceResponse a(WebView webView, String str);

        boolean a(e eVar, int i, String str, String str2);

        boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean b(e eVar, String str);

        boolean c(e eVar, String str);

        boolean d(e eVar, String str);
    }

    public interface h {
        void a(e eVar);

        void b(e eVar);
    }

    public e(Context context, com.alipay.sdk.m.w.a aVar, C0194e c0194e) {
        this(context, null, aVar, c0194e);
    }

    public ImageView getBackButton() {
        return this.f25413a;
    }

    public ProgressBar getProgressbar() {
        return this.d;
    }

    public ImageView getRefreshButton() {
        return this.c;
    }

    public TextView getTitle() {
        return this.b;
    }

    public String getUrl() {
        return this.e.getUrl();
    }

    public WebView getWebView() {
        return this.e;
    }

    public void setChromeProxy(f fVar) {
        this.g = fVar;
        if (fVar == null) {
            this.e.setWebChromeClient(null);
        } else {
            this.e.setWebChromeClient(new c());
        }
    }

    public void setWebClientProxy(g gVar) {
        this.h = gVar;
        if (gVar == null) {
            this.e.setWebViewClient(null);
        } else {
            this.e.setWebViewClient(new d());
        }
    }

    public void setWebEventProxy(h hVar) {
        this.i = hVar;
    }

    public e(Context context, AttributeSet attributeSet, com.alipay.sdk.m.w.a aVar, C0194e c0194e) {
        super(context, attributeSet);
        this.k = new a();
        this.f = c0194e == null ? new C0194e(false, false) : c0194e;
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    public final void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        this.d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_horizontal));
        this.d.setMax(100);
        this.d.setBackgroundColor(-218103809);
        addView(this.d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public final void c(Context context) {
        WebView webView = new WebView(context);
        this.e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.e, context);
        WebSettings settings = this.e.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.e.setVerticalScrollbarOverlay(true);
        if (com.alipay.sdk.m.o.b.i().g(this.j)) {
            WebView webView2 = this.e;
            webView2.addJavascriptInterface(new com.alipay.sdk.m.b0.a(context, webView2, this.j), "AlipayChinaMobileBridge");
        }
        this.e.setDownloadListener(new b(context));
        try {
            try {
                this.e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.e.removeJavascriptInterface("accessibility");
                this.e.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        } catch (Exception unused2) {
            Method method = this.e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method != null) {
                method.invoke(this.e, "searchBoxJavaBridge_");
                method.invoke(this.e, "accessibility");
                method.invoke(this.e, "accessibilityTraversal");
            }
        }
        com.alipay.sdk.m.c0.c.a(this.e);
        addView(this.e, new LinearLayout.LayoutParams(-1, -1));
    }

    public final void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f.f25419a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.f25413a = imageView;
        imageView.setOnClickListener(this.k);
        this.f25413a.setScaleType(ImageView.ScaleType.CENTER);
        this.f25413a.setImageDrawable(n.a(n.f25541a, context));
        this.f25413a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f25413a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextColor(-15658735);
        this.b.setTextSize(17.0f);
        this.b.setMaxLines(1);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        this.c.setImageDrawable(n.a(n.b, context));
        this.c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    public void b() {
        removeAllViews();
        this.e.removeAllViews();
        this.e.setWebViewClient(null);
        this.e.setWebChromeClient(null);
        this.e.destroy();
    }

    public void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.getSettings().setUserAgentString(userAgentString + q.g(context));
    }

    public void a(String str) {
        this.e.loadUrl(str);
        com.alipay.sdk.m.c0.c.a(this.e);
    }

    public void a(String str, byte[] bArr) {
        this.e.postUrl(str, bArr);
    }

    public final int a(int i) {
        return (int) (i * this.l);
    }
}
