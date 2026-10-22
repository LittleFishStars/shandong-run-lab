package com.fl.saas.common.widget.h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.common.util.YdImmersiveUtils;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdH5Activity extends Activity {
    private boolean enableQuickApp;
    private String html;
    private ImageView ivBack;
    private ImageView ivRefresh;
    private RelativeLayout rl_empty;
    private TextView titleView;
    private String url;
    private SignUrlWebView webView;

    public class MyWebViewDownLoadListener implements DownloadListener {
        public MyWebViewDownLoadListener() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            YdH5Activity.this.downloadByBrowser(str);
        }
    }

    private void bindDownloaderListener() {
        this.webView.setDownloadListener(new MyWebViewDownLoadListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadByBrowser(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    public static void launch(Context context, String str) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra("url", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, String str, boolean z) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra(z ? "htmlSnippet" : "url", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launchWithEnableQuickApp(Context context, String str, boolean z) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) YdH5Activity.class);
        intent.putExtra("url", str);
        intent.putExtra("enableQuickApp", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void operateClick() {
        this.ivRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.common.widget.h5.YdH5Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YdH5Activity.this.webView != null) {
                    YdH5Activity.this.webView.reload();
                }
            }
        });
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.common.widget.h5.YdH5Activity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (YdH5Activity.this.webView == null || !YdH5Activity.this.webView.canGoBack() || YdH5Activity.this.webView.getUrl().equals(YdH5Activity.this.url)) {
                    YdH5Activity.this.onBackPressed();
                } else {
                    YdH5Activity.this.webView.goBack();
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        YdImmersiveUtils.setImmersiveStatusBar(this);
        YdImmersiveUtils.setStatusBarLightMode(this, true);
        super.onCreate(bundle);
        setContentView(R.layout.yd_activity_h5);
        this.ivBack = (ImageView) findViewById(R.id.iv_back);
        this.ivRefresh = (ImageView) findViewById(R.id.iv_refresh);
        this.titleView = (TextView) findViewById(R.id.tv_title);
        this.webView = (SignUrlWebView) findViewById(R.id.sign_webview);
        this.rl_empty = (RelativeLayout) findViewById(R.id.rl_empty);
        try {
            this.url = getIntent().getStringExtra("url");
            this.html = getIntent().getStringExtra("htmlSnippet");
            this.enableQuickApp = getIntent().getBooleanExtra("enableQuickApp", false);
            String stringExtra = getIntent().getStringExtra("title");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.titleView.setText(stringExtra);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.webView.setEnableQuickApp(this.enableQuickApp);
        this.webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (LogcatUtil.isDebug) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.webView.setStatusListener(new SignUrlWebView.WebViewStatus() { // from class: com.fl.saas.common.widget.h5.YdH5Activity.1
            @Override // com.fl.saas.common.widget.h5.SignUrlWebView.WebViewStatus
            public void onTitle(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = YdH5Activity.this.getIntent().getStringExtra("title");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                }
                YdH5Activity.this.titleView.setText(str);
            }

            @Override // com.fl.saas.common.widget.h5.SignUrlWebView.WebViewStatus
            public void stopLoadWebview() {
                if (YdH5Activity.this.titleView != null) {
                    YdH5Activity.this.titleView.setText("已拦截");
                }
                if (YdH5Activity.this.webView != null) {
                    YdH5Activity.this.webView.setVisibility(8);
                    YdH5Activity.this.webView.destroy();
                    YdH5Activity.this.webView = null;
                }
                if (YdH5Activity.this.rl_empty != null) {
                    YdH5Activity.this.rl_empty.setVisibility(0);
                }
            }
        });
        operateClick();
        LogcatUtil.d("YdSDK-YdH5Activity", "url: " + this.url);
        if (!TextUtils.isEmpty(this.url)) {
            this.webView.loadUrl(this.url);
        } else if (!TextUtils.isEmpty(this.html)) {
            this.webView.loadDataWithBaseURL(null, this.html, "text/html", "UTF-8", null);
        }
        bindDownloaderListener();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SignUrlWebView signUrlWebView = this.webView;
        if (signUrlWebView != null) {
            signUrlWebView.stopLoading();
            this.webView.removeAllViews();
            this.webView.destroy();
            this.webView = null;
        }
        this.rl_empty = null;
        QuickAppHelper.getInstance().clearHistory();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        SignUrlWebView signUrlWebView = this.webView;
        if (signUrlWebView != null) {
            signUrlWebView.onPause();
            this.webView.pauseTimers();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        SignUrlWebView signUrlWebView = this.webView;
        if (signUrlWebView != null) {
            signUrlWebView.onResume();
            this.webView.resumeTimers();
        }
    }
}
