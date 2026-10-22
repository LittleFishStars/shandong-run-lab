package com.fl.saas.adx.base.activity.h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fl.saas.K;
import com.fl.saas.R;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLH5Activity extends Activity {
    private boolean enableQuickApp;
    private String html;
    private ImageView ivBack;
    private ImageView ivRefresh;
    private TextView titleView;
    private String url;
    private SignUrlWebView webView;

    public class MyWebViewDownLoadListener implements DownloadListener {
        public MyWebViewDownLoadListener() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            FLH5Activity.this.downloadByBrowser(str);
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

    private void initChildView(RelativeLayout relativeLayout) {
        this.ivBack = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DeviceUtil.dip2px(30.0f), DeviceUtil.dip2px(20.0f));
        layoutParams.addRule(15);
        layoutParams.setMargins(DeviceUtil.dip2px(10.0f), 0, 0, 0);
        this.ivBack.setLayoutParams(layoutParams);
        this.ivRefresh = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DeviceUtil.dip2px(20.0f), DeviceUtil.dip2px(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, DeviceUtil.dip2px(20.0f), 0);
        this.ivRefresh.setLayoutParams(layoutParams2);
        this.ivBack.setImageResource(R.mipmap.fl_adx_icon_back);
        this.ivRefresh.setImageResource(R.mipmap.fl_adx_icon_refresh);
        TextView textView = new TextView(this);
        this.titleView = textView;
        textView.setTextColor(-12303292);
        this.titleView.setSingleLine();
        this.titleView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.titleView.setTextSize(18.0f);
        this.titleView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DeviceUtil.getMobileWidth() - DeviceUtil.dip2px(100.0f), -2);
        layoutParams3.addRule(13);
        relativeLayout.addView(this.titleView, layoutParams3);
        relativeLayout.addView(this.ivBack);
        relativeLayout.addView(this.ivRefresh);
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FLH5Activity.class);
        intent.putExtra("url", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launchWithEnableQuickApp(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) FLH5Activity.class);
        intent.putExtra("url", str);
        intent.putExtra("enableQuickApp", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void operateClick() {
        this.ivRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.activity.h5.FLH5Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FLH5Activity.this.webView != null) {
                    FLH5Activity.this.webView.reload();
                }
            }
        });
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: com.fl.saas.adx.base.activity.h5.FLH5Activity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!FLH5Activity.this.webView.canGoBack() || FLH5Activity.this.webView.getUrl().equals(FLH5Activity.this.url)) {
                    FLH5Activity.this.onBackPressed();
                } else {
                    FLH5Activity.this.webView.goBack();
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        K.a(this);
        K.a(this, true);
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DeviceUtil.dip2px(48.0f));
        layoutParams.setMargins(0, DeviceUtil.dip2px(30.0f), 0, 0);
        relativeLayout.setLayoutParams(layoutParams);
        initChildView(relativeLayout);
        operateClick();
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
        SignUrlWebView signUrlWebView = new SignUrlWebView(this);
        this.webView = signUrlWebView;
        signUrlWebView.setEnableQuickApp(this.enableQuickApp);
        this.webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (LogcatUtil.isDebug) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.webView.setStatusListener(new SignUrlWebView.WebViewStatus() { // from class: com.fl.saas.adx.base.activity.h5.FLH5Activity.1
            @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
            public void onEndScroll() {
            }

            @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
            public void onLoadFailed() {
            }

            @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
            public void onLoadSuccess() {
            }

            @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
            public void onStartScroll() {
            }

            @Override // com.fl.saas.adx.base.activity.h5.SignUrlWebView.WebViewStatus
            public void onTitle(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = FLH5Activity.this.getIntent().getStringExtra("title");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                }
                FLH5Activity.this.titleView.setText(str);
            }
        });
        linearLayout.removeAllViews();
        linearLayout.addView(relativeLayout);
        linearLayout.addView(this.webView);
        setContentView(linearLayout);
        LogcatUtil.d("FLSDK-FLH5Activity", "url: " + this.url);
        if (!TextUtils.isEmpty(this.url)) {
            this.webView.loadUrl(this.url);
        } else if (TextUtils.isEmpty(this.html)) {
            this.webView.getProgressbar().setVisibility(8);
        } else {
            this.webView.loadDataWithBaseURL(null, this.html, "text/html", "UTF-8", null);
        }
        bindDownloaderListener();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QuickAppHelper.getInstance().clearHistory();
    }

    public static void launch(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) FLH5Activity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) FLH5Activity.class);
        intent.putExtra(z ? "htmlSnippet" : "url", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
