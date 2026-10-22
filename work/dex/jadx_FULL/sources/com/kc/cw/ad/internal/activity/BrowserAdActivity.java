package com.kc.cw.ad.internal.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.c.p;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BrowserAdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LinkedList<WebView> f38841a = new LinkedList<>();
    private int b;
    private WebView c;
    private TextView d;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != 100) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Uri uri = p.a(str) ? null : Uri.parse(str);
        if (uri == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        try {
            startActivity(intent);
            if (this.b == 0) {
                a();
            }
            this.b--;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        f.a("OctopusAd", "...........................backPressed...........................");
        WebView webView = this.c;
        if (webView == null || !webView.canGoBack()) {
            a();
        } else {
            this.c.goBack();
            f.a("OctopusAd", " mWebView.goBack()");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ss_activity_in_app_browser);
        WebView webViewPoll = f38841a.poll();
        this.c = webViewPoll;
        if (webViewPoll == null) {
            a();
            return;
        }
        webViewPoll.getSettings();
        this.b = getIntent().getIntExtra("REPEAT_NUM", 0);
        this.d = (TextView) findViewById(R.id.tv_title);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setSavePassword(false);
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup) webView.getParent();
        int iIndexOfChild = viewGroup.indexOfChild(webView);
        viewGroup.removeView(webView);
        ViewUtil.removeChildFromParent(this.c);
        this.c.setLayoutParams(layoutParams);
        this.c.getSettings().setUseWideViewPort(true);
        this.c.getSettings().setLoadWithOverviewMode(true);
        WebView.setWebContentsDebuggingEnabled(false);
        viewGroup.addView(this.c, iIndexOfChild);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.c.setDownloadListener(new DownloadListener(this) { // from class: com.kc.cw.ad.internal.activity.BrowserAdActivity.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BrowserAdActivity f38842a;

            {
                this.f38842a = this;
            }

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    this.f38842a.c.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    this.f38842a.a();
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        });
        this.c.setWebViewClient(new WebViewClient(this) { // from class: com.kc.cw.ad.internal.activity.BrowserAdActivity.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BrowserAdActivity f38843a;

            {
                this.f38843a = this;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                if (str.startsWith("http")) {
                    return false;
                }
                this.f38843a.a(str);
                return true;
            }
        });
        this.c.setWebChromeClient(new WebChromeClient(this, progressBar) { // from class: com.kc.cw.ad.internal.activity.BrowserAdActivity.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ProgressBar f38844a;
            final BrowserAdActivity b;

            {
                this.b = this;
                this.f38844a = progressBar;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                if (i < 100 && this.f38844a.getVisibility() == 8) {
                    this.f38844a.setVisibility(0);
                }
                this.f38844a.setProgress(i);
                if (i == 100) {
                    this.f38844a.setVisibility(8);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
                if (this.b.d == null || TextUtils.isEmpty(str) || str.startsWith("http")) {
                    return;
                }
                this.b.d.setText(str);
            }
        });
        ((ImageView) findViewById(R.id.close_iv)).setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.BrowserAdActivity.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BrowserAdActivity f38845a;

            {
                this.f38845a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f38845a.a();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        q.a().l.remove("dpForbid");
        WebView webView = this.c;
        if (webView != null) {
            webView.setDownloadListener(null);
            this.c.setWebChromeClient(null);
            this.c.setWebViewClient(null);
            ViewUtil.removeChildFromParent(this.c);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
