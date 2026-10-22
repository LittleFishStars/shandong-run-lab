package com.alibaba.alibcwebview.container;

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
import com.alibaba.alibcwebview.messagebus.AlibcMessageListener;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ThirdWebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23708a = "ThirdWebViewActivity";
    private WebView b;
    private a c;
    private TextView d;
    private View e;
    private View f;
    private View g;

    public class a extends AlibcMessageListener {
        public a() {
        }

        @Override // com.alibaba.alibcwebview.messagebus.AlibcMessageListener
        public final void a(Object obj) {
            if (obj instanceof String) {
                ThirdWebViewActivity.this.d.setText(String.valueOf(obj));
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.b.canGoBack()) {
            this.b.goBack();
        } else {
            finish();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0116 -> B:30:0x012b). Please report as a decompilation issue!!! */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(ResourceUtils.getRLayout(this, "com_taobao_bc_webview_activity"), (ViewGroup) null);
        WebView webView = new WebView(this);
        this.b = webView;
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            settings.setMixedContentMode(0);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(this.b.getContext().getApplicationContext().getDir("cache", 0).getPath());
            settings.setAllowFileAccess(false);
            settings.setAppCacheEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            if (NetWorkUtils.isNetWorkAvailable(this.b.getContext())) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(1);
            }
            settings.setBuiltInZoomControls(false);
        }
        this.b.setWebViewClient(new WebViewClient() { // from class: com.alibaba.alibcwebview.container.ThirdWebViewActivity.2
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
            }
        });
        this.b.setWebChromeClient(new WebChromeClient() { // from class: com.alibaba.alibcwebview.container.ThirdWebViewActivity.3
            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView2, String str) {
                com.alibaba.alibcwebview.messagebus.a.a().a(str);
                super.onReceivedTitle(webView2, str);
            }
        });
        linearLayout.addView(this.b, new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.d = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_title"));
        this.f = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_close_button"));
        this.g = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_nb_sdk_web_view_title_bar_back_button"));
        this.e = findViewById(ResourceUtils.getIdentifier(this, "id", "com_taobao_tae_sdk_web_view_title_bar"));
        View view = this.f;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.alibcwebview.container.ThirdWebViewActivity.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ThirdWebViewActivity.this.finish();
                }
            });
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.alibcwebview.container.ThirdWebViewActivity.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ThirdWebViewActivity.this.onBackPressed();
                }
            });
        }
        this.b.setDownloadListener(new DownloadListener() { // from class: com.alibaba.alibcwebview.container.ThirdWebViewActivity.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    AlibcLogger.i(ThirdWebViewActivity.f23708a, "url=" + str);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    ThirdWebViewActivity.this.startActivity(intent);
                } catch (Exception e) {
                    AlibcLogger.e(ThirdWebViewActivity.f23708a, "jump exception: " + e.getMessage());
                }
            }
        });
        try {
            String stringExtra = getIntent().getStringExtra("bc_webview_activity_title");
            if (TextUtils.isEmpty(stringExtra)) {
                this.c = new a();
                com.alibaba.alibcwebview.messagebus.a.a().a((AlibcMessageListener) this.c);
            } else {
                this.d.setText(stringExtra);
            }
        } catch (Exception e) {
            AlibcLogger.e(f23708a, "拒绝服务漏洞: " + e.getMessage());
        }
        try {
            String stringExtra2 = getIntent().getStringExtra(PerfId.loadUrl);
            AlibcLogger.i(f23708a, "加载的url: " + stringExtra2);
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            this.b.loadUrl(stringExtra2);
        } catch (Exception e2) {
            AlibcLogger.e(f23708a, "拒绝服务漏洞: " + e2.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        WebView webView = this.b;
        if (webView != null) {
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.b);
            }
            this.b.removeAllViews();
            this.b.destroy();
        }
        if (this.c != null) {
            com.alibaba.alibcwebview.messagebus.a.a().a((AlibcMessageListener) this.c);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.b.resumeTimers();
    }
}
