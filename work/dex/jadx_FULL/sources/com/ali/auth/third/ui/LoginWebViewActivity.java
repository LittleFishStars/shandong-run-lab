package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.login.task.LoginByIVTokenTask;
import com.ali.auth.third.login.task.RefreshSidTask;
import com.ali.auth.third.login.util.LoginStatus;
import com.ali.auth.third.ui.webview.AuthWebView;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import com.ali.auth.third.ui.webview.BaseWebViewClient;
import com.ali.auth.third.ui.webview.BridgeWebChromeClient;
import com.beizi.fusion.BeiZiBiddingConstant;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginWebViewActivity extends BaseWebViewActivity {
    public static final String CALLBACK = "https://www.alipay.com/webviewbridge";
    public static final String TAG = BaseWebViewActivity.class.getSimpleName();
    public static LoginCallback mLoginCallback;
    public static String scene;
    public static String token;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoginService f23501a;

    public class a extends BaseWebViewClient {
        public a(Activity activity) {
            super(activity);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            SDKLogger.d(LoginWebViewActivity.TAG, "onLoadResource url=" + str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SDKLogger.d(LoginWebViewActivity.TAG, "onPageFinished url=" + str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SDKLogger.d(LoginWebViewActivity.TAG, "onPageStarted url=" + str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SDKLogger.d(LoginWebViewActivity.TAG, "shouldOverrideUrlLoading url=" + str);
            Uri uri = Uri.parse(str);
            if (LoginWebViewActivity.this.f23501a.isLoginUrl(str)) {
                RefreshSidTask refreshSidTask = new RefreshSidTask(((BaseWebViewActivity) LoginWebViewActivity.this).authWebView);
                Executor executor = ExecutorServiceImpl.mExecutor;
                if (executor == null) {
                    executor = AsyncTask.THREAD_POOL_EXECUTOR;
                }
                refreshSidTask.executeOnExecutor(executor, new String[0]);
                return true;
            }
            if (LoginWebViewActivity.this.checkWebviewBridge(str)) {
                return LoginWebViewActivity.this.a(uri);
            }
            if (webView instanceof AuthWebView) {
                webView = (AuthWebView) webView;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    public class b extends BridgeWebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (LoginWebViewActivity.this.canReceiveTitle) {
                if ((str == null || !str.contains("我喜欢")) && str != null) {
                    ((BaseWebViewActivity) LoginWebViewActivity.this).titleText.setText(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Uri uri) {
        Bundle bundleSerialBundle = serialBundle(uri.getQuery());
        if (bundleSerialBundle == null) {
            bundleSerialBundle = new Bundle();
        }
        bundleSerialBundle.getString("havana_mobile_reg_otherWebView");
        String string = bundleSerialBundle.getString("action");
        bundleSerialBundle.getString("loginId");
        if (TextUtils.isEmpty(string) || Constants.ACTION_QUIT.equals(string)) {
            setResult(ResultCode.SUCCESS.code, getIntent().putExtra(Constants.PARAM_IV_TOKEN, bundleSerialBundle.getString(Constants.PARAM_HAVANA_IV_TOKEN)));
            finish();
            return true;
        }
        if (Constants.ACTION_RELOGIN.equals(string)) {
            finish();
            return true;
        }
        if (Constants.ACTION_CONFIRMLOGIN.equals(string) || Constants.ACTION_TRUSTLOGIN.equals(string)) {
            return true;
        }
        if (Constants.ACTION_CONTINUELOGIN.equals(string)) {
            return a(uri, bundleSerialBundle);
        }
        if (!"loginAfterRegister".equals(string)) {
            return false;
        }
        String string2 = bundleSerialBundle.getString("token");
        LoginByIVTokenTask loginByIVTokenTask = new LoginByIVTokenTask(this, mLoginCallback, true);
        Executor executor = ExecutorServiceImpl.mExecutor;
        if (executor == null) {
            executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        loginByIVTokenTask.executeOnExecutor(executor, string2, BeiZiBiddingConstant.Adn.ADN_GDT, "");
        return true;
    }

    public static Bundle serialBundle(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] strArrSplit = str.split("&");
        Bundle bundle = new Bundle();
        for (String str2 : strArrSplit) {
            int iIndexOf = str2.indexOf("=");
            if (iIndexOf > 0 && iIndexOf < str2.length() - 1) {
                bundle.putString(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
            }
        }
        return bundle;
    }

    public boolean a(Uri uri, Bundle bundle) {
        bundle.putString(Constants.QUERY_STRING, uri.getQuery());
        bundle.putString("token", token);
        bundle.putString("scene", scene);
        setResult(ResultCode.CHECK.code, getIntent().putExtras(bundle));
        finish();
        return true;
    }

    public boolean checkWebviewBridge(String str) {
        Uri uri = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getAuthority());
        sb.append(uri.getPath());
        return CALLBACK.contains(sb.toString());
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    public WebChromeClient createWebChromeClient() {
        return new b();
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    public WebViewClient createWebViewClient() {
        return new a(this);
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    public void onBackHistory() {
        if (this.authWebView.canGoBack() && (this.authWebView.getUrl().contains("authorization-notice") || this.authWebView.getUrl().contains("agreement"))) {
            this.authWebView.goBack();
            return;
        }
        setResult(ResultCode.USER_CANCEL.code, new Intent());
        LoginStatus.resetLoginFlag();
        finish();
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AuthWebView authWebView = this.authWebView;
        if (authWebView == null) {
            finish();
            return;
        }
        authWebView.addBridgeObject("accountBridge", new LoginBridge());
        this.authWebView.addBridgeObject("loginBridge", new LoginBridge());
        this.authWebView.addBridgeObject("ivBridge", new com.ali.auth.third.login.bridge.a());
        this.f23501a = (LoginService) MemberSDK.getService(LoginService.class);
        if (KernelContext.context == null) {
            KernelContext.context = getApplicationContext();
        }
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LoginStatus.resetLoginFlag();
    }
}
