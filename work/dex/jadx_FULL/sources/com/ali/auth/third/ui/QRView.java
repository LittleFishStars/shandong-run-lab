package com.ali.auth.third.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.ui.webview.AuthWebView;
import com.ali.auth.third.ui.webview.BridgeWebChromeClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QRView extends LinearLayout {
    public static LoginCallback mLoginCallback;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AuthWebView f23516a;
    private int b;

    public class a extends WebViewClient {
        public a(QRView qRView) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(16)
        public void onGlobalLayout() {
            QRView.this.f23516a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            QRView qRView = QRView.this;
            qRView.b = qRView.f23516a.getWidth();
        }
    }

    public QRView(Context context) {
        super(context);
    }

    public QRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.ali_auth_qrview, (ViewGroup) this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        mLoginCallback = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        AuthWebView authWebView = (AuthWebView) findViewById(R.id.ali_auth_webview);
        this.f23516a = authWebView;
        authWebView.setPadding(0, 0, 0, 0);
        this.f23516a.addBridgeObject("loginBridge", new LoginBridge());
        this.f23516a.setWebChromeClient(new BridgeWebChromeClient());
        this.f23516a.setWebViewClient(new a(this));
        this.f23516a.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public void showQR(LoginCallback loginCallback) {
        mLoginCallback = loginCallback;
        AuthWebView authWebView = this.f23516a;
        if (authWebView != null) {
            if (this.b == 0) {
                this.b = authWebView.getWidth();
            }
            float f = getResources().getDisplayMetrics().density;
            String str = String.format(ConfigManager.qrCodeLoginUrl, KernelContext.getAppKey()) + "&qrwidth=" + ((int) (((double) (this.b / f)) * 0.8d));
            SDKLogger.d("QRView", "qr width = " + this.f23516a.getPaddingLeft() + "   " + this.f23516a.getPaddingTop());
            this.f23516a.loadUrl(str);
            requestLayout();
        }
    }
}
