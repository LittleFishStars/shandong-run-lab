package com.baichuan.nb_trade;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.alibcprotocol.utils.ResourceUtils;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcDefaultActivity extends Activity {
    public static final String f = "AlibcDefaultActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f26211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WebView f1203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1204a;
    public View b;
    public View c;

    public class a implements DownloadListener {
        public a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                AlibcLogger.i(AlibcDefaultActivity.f, "url=" + str);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                AlibcDefaultActivity.this.startActivity(intent);
            } catch (Exception e) {
                AlibcLogger.e(AlibcDefaultActivity.f, "jump exception: " + e.getMessage());
            }
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AlibcDefaultActivity.this.finish();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AlibcDefaultActivity.this.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f1203a.canGoBack()) {
            this.f1203a.goBack();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_bc_webview_activity"), (ViewGroup) null);
        WebView webView = new WebView(this);
        this.f1203a = webView;
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setMixedContentMode(0);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(this.f1203a.getContext().getApplicationContext().getDir("cache", 0).getPath());
            settings.setAllowFileAccess(false);
            settings.setAppCacheEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            if (NetWorkUtils.isNetWorkAvailable(this.f1203a.getContext())) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(1);
            }
            settings.setBuiltInZoomControls(false);
        }
        this.f1203a.setWebViewClient(new b());
        this.f1203a.setWebChromeClient(new c());
        linearLayout.addView(this.f1203a, new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.f1204a = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_title"));
        this.b = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        this.c = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        this.f26211a = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar"));
        View view = this.b;
        if (view != null) {
            view.setOnClickListener(new d());
        }
        View view2 = this.c;
        if (view2 != null) {
            view2.setOnClickListener(new e());
        }
        this.f1203a.setDownloadListener(new a());
        try {
            String stringExtra = getIntent().getStringExtra("bc_webview_activity_title");
            if (TextUtils.isEmpty(stringExtra)) {
                this.f1204a.setText("随时随地 想淘就淘");
            } else {
                this.f1204a.setText(stringExtra);
            }
        } catch (Exception e2) {
            AlibcLogger.e(f, "拒绝服务漏洞: " + e2.getMessage());
        }
        try {
            String stringExtra2 = getIntent().getStringExtra(PerfId.loadUrl);
            AlibcLogger.i(f, "加载的url: " + stringExtra2);
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            this.f1203a.loadUrl(stringExtra2);
        } catch (Exception e3) {
            AlibcLogger.e(f, "拒绝服务漏洞: " + e3.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        WebView webView = this.f1203a;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f1203a);
            }
            this.f1203a.removeAllViews();
            this.f1203a.destroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1203a.resumeTimers();
    }
}
