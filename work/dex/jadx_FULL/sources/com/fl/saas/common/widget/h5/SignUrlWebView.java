package com.fl.saas.common.widget.h5;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import com.fl.saas.base.widget.YdCommonDialog;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SignUrlWebView extends WebView {
    private boolean enableQuickApp;
    private boolean hasFastAppJump;
    public LinearLayout layout;
    private WebViewStatus mStatus;
    private ProgressBar progressbar;
    private YdCommonDialog ydCommonDialog;

    public class HsWebChromeClient extends WebChromeClient {
        public HsWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new AlertDialog.Builder(SignUrlWebView.this.getContext()).setMessage(str2).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.fl.saas.common.widget.h5.SignUrlWebView.HsWebChromeClient.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(false).create().show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            new AlertDialog.Builder(SignUrlWebView.this.getContext()).setMessage(str2).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.fl.saas.common.widget.h5.SignUrlWebView.HsWebChromeClient.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.fl.saas.common.widget.h5.SignUrlWebView.HsWebChromeClient.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            }).create().show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ProgressBar progressBar;
            int i2;
            if (i != 100) {
                if (SignUrlWebView.this.progressbar.getVisibility() != 0) {
                    progressBar = SignUrlWebView.this.progressbar;
                    i2 = 0;
                }
                super.onProgressChanged(webView, i);
            }
            progressBar = SignUrlWebView.this.progressbar;
            i2 = 8;
            progressBar.setVisibility(i2);
            super.onProgressChanged(webView, i);
        }
    }

    public class HsWebViewClient extends WebViewClient {
        public HsWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            SignUrlWebView.this.progressbar.setVisibility(8);
            if (SignUrlWebView.this.mStatus != null) {
                String title = webView.getTitle();
                if (title == null || (webView.getUrl() != null && webView.getUrl().contains(title))) {
                    title = "";
                }
                SignUrlWebView.this.mStatus.onTitle(title);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SignUrlWebView.this.progressbar.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (SignUrlWebView.this.urlCanLoad(webResourceRequest.getUrl().toString().toLowerCase())) {
                return false;
            }
            boolean zStartThirdPartyApp = SignUrlWebView.this.startThirdPartyApp(webResourceRequest.getUrl());
            if (!zStartThirdPartyApp && SignUrlWebView.this.mStatus != null) {
                SignUrlWebView.this.mStatus.stopLoadWebview();
            }
            return zStartThirdPartyApp;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (SignUrlWebView.this.urlCanLoad(str.toLowerCase())) {
                return false;
            }
            boolean zStartThirdPartyApp = SignUrlWebView.this.startThirdPartyApp(Uri.parse(str));
            if (!zStartThirdPartyApp && SignUrlWebView.this.mStatus != null) {
                SignUrlWebView.this.mStatus.stopLoadWebview();
            }
            return zStartThirdPartyApp;
        }
    }

    public interface WebViewStatus {
        void onTitle(String str);

        void stopLoadWebview();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public SignUrlWebView(Context context) {
        super(context);
        this.hasFastAppJump = false;
        initConfig(context);
    }

    public SignUrlWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasFastAppJump = false;
        initConfig(context);
    }

    private boolean isInstall(Intent intent) {
        return getContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startThirdPartyApp$0(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        if (!isInstall(intent) || DeviceUtil.getContext() == null) {
            return;
        }
        DeviceUtil.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startThirdPartyApp(final Uri uri) {
        if (uri != null) {
            try {
                String string = uri.toString();
                QuickAppHelper.getInstance().reportUrl(string);
                if (this.hasFastAppJump) {
                    return false;
                }
                if (!(!this.enableQuickApp ? QuickAppHelper.getInstance().urlIntercept(string) : false)) {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.setFlags(268435456);
                    if (isInstall(intent)) {
                        getContext().startActivity(intent);
                    }
                    return true;
                }
                this.hasFastAppJump = true;
                if (QuickAppHelper.getInstance().getQuickAppInterceptionType() == 1) {
                    if (this.ydCommonDialog == null) {
                        this.ydCommonDialog = new YdCommonDialog(getContext()).setTitle("跳转提示").setContent("想要打开“快应用”\n是否允许").setCanDismiss(false).setCancelName("拒绝").setSubmitName("允许");
                    }
                    if (!this.ydCommonDialog.isShowing()) {
                        this.ydCommonDialog.setOnSubmitListener(new YdCommonDialog.OnSubmitListener() { // from class: com.zj.adlib.zb8
                            @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
                            public final void onClick() {
                                this.f21014a.lambda$startThirdPartyApp$0(uri);
                            }
                        }).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean urlCanLoad(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://") || str.startsWith("file://");
    }

    public ProgressBar getProgressbar() {
        return this.progressbar;
    }

    public void initConfig(Context context) {
        WebView.setWebContentsDebuggingEnabled(false);
        setLayerType(0, null);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setUseWideViewPort(true);
        getSettings().setMixedContentMode(0);
        this.layout = new LinearLayout(context);
        this.layout.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        this.layout.setGravity(17);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyle);
        this.progressbar = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.layout.addView(this.progressbar);
        addView(this.layout);
        setWebChromeClient(new HsWebChromeClient());
        setWebViewClient(new HsWebViewClient());
    }

    public void setEnableQuickApp(boolean z) {
        this.enableQuickApp = z;
    }

    public void setProgressbar(ProgressBar progressBar) {
        this.progressbar = progressBar;
    }

    public void setStatusListener(WebViewStatus webViewStatus) {
        this.mStatus = webViewStatus;
    }
}
