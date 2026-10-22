package com.bwt.top.h5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.bwt.top.R;
import com.bwt.top.custom_ad.AdapterCustomSplashAdLoader;
import com.bwt.top.util.ALog;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdSdkH5Activity extends Activity {
    public static final String ISDOWNLOAD = "isDownload";
    public static final String URL = "url_str";
    private boolean isShowingDialog;
    private ImageView mBackIv;
    private boolean mIsWebDownload;
    private TextView mTitleTv;
    private WebView mWebView;
    private MWebChromeClient webChromeClient;
    private MWebViewClient webViewClient;
    private String TAG = "AdSdkH5Activity";
    private final Handler mWebDownloadHandler = new Handler(Looper.getMainLooper()) { // from class: com.bwt.top.h5.AdSdkH5Activity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                AdSdkH5Activity.this.showDownloadDialog(message.obj.toString());
            } catch (Exception unused) {
            }
        }
    };

    public class MWebChromeClient extends WebChromeClient {
        private MWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            AdSdkH5Activity.this.updateTitle(str);
        }
    }

    public class MWebViewClient extends WebViewClient {
        private MWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            AdSdkH5Activity.this.showWebView();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            ALog.i(AdSdkH5Activity.this.TAG, "onReceivedError errorCode:" + i + ",description:" + str);
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ALog.i(AdSdkH5Activity.this.TAG, "shouldOverrideUrlLoading url:" + str);
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (str.startsWith("http")) {
                    if (!str.endsWith(".apk") || !AdSdkH5Activity.this.mIsWebDownload) {
                        return false;
                    }
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = str;
                    AdSdkH5Activity.this.mWebDownloadHandler.sendMessage(messageObtain);
                    return true;
                }
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                if (intent.resolveActivity(AdSdkH5Activity.this.getPackageManager()) != null) {
                    AdSdkH5Activity.this.startActivity(intent);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adClose() {
        AdapterCustomSplashAdLoader.AdCloseListener splashAdListener = AdSdkH5Helper.getSplashAdListener();
        if (splashAdListener != null) {
            splashAdListener.onAdClose();
        }
    }

    private void initWebView() {
        this.mWebView.setVisibility(8);
        this.mWebView.getSettings().setSaveFormData(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.getSettings().setDatabaseEnabled(true);
        this.mWebView.getSettings().setAppCacheEnabled(true);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setCacheMode(-1);
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.mWebView.getSettings().setMixedContentMode(0);
        this.mWebView.setScrollBarStyle(0);
        this.mWebView.setFocusable(true);
        this.mWebView.setFocusableInTouchMode(true);
        this.mWebView.requestFocusFromTouch();
        this.mWebView.requestFocus();
        this.webViewClient = new MWebViewClient();
        this.webChromeClient = new MWebChromeClient();
        this.mWebView.setDownloadListener(null);
        this.mWebView.setWebViewClient(this.webViewClient);
        this.mWebView.setWebChromeClient(this.webChromeClient);
    }

    private void loadUrl(String str) {
        WebView webView = this.mWebView;
        if (webView == null || str == null) {
            return;
        }
        webView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadDialog(final String str) {
        if (this.isShowingDialog) {
            return;
        }
        this.isShowingDialog = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.BwtDownloadAlertDialogStyle);
        builder.setTitle("是否下载应用");
        builder.setCancelable(true);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bwt.top.h5.AdSdkH5Activity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AdSdkH5Activity.this.skipBrowserDownload(str);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(OptionsPickerHelper.e, new DialogInterface.OnClickListener() { // from class: com.bwt.top.h5.AdSdkH5Activity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bwt.top.h5.AdSdkH5Activity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AdSdkH5Activity.this.isShowingDialog = false;
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipBrowserDownload(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitle(String str) {
        if (str != null) {
            this.mTitleTv.setText(str);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView = this.mWebView;
        if (webView != null && webView.canGoBack()) {
            this.mWebView.goBack();
        } else {
            adClose();
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ad_sdk_h5);
        if (getIntent() == null) {
            adClose();
            finish();
            return;
        }
        this.mBackIv = (ImageView) findViewById(R.id.ad_sdk_h5_back_iv);
        this.mTitleTv = (TextView) findViewById(R.id.ad_sdk_h5_title_tv);
        this.mWebView = (WebView) findViewById(R.id.ad_sdk_h5_wv);
        this.mBackIv.setOnClickListener(new View.OnClickListener() { // from class: com.bwt.top.h5.AdSdkH5Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdSdkH5Activity.this.adClose();
                AdSdkH5Activity.this.finish();
            }
        });
        initWebView();
        String stringExtra = getIntent().getStringExtra("url_str");
        this.mIsWebDownload = getIntent().getBooleanExtra("isDownload", false);
        loadUrl(stringExtra);
        ALog.d(this.TAG, "loadUrl:" + stringExtra);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.destroy();
            this.mWebView = null;
        }
        this.mWebDownloadHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
