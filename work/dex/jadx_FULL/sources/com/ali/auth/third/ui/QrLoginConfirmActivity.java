package com.ali.auth.third.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.login.LoginService;
import com.ali.auth.third.login.bridge.LoginBridge;
import com.ali.auth.third.ui.webview.BaseWebViewActivity;
import com.ali.auth.third.ui.webview.BaseWebViewClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QrLoginConfirmActivity extends BaseWebViewActivity {

    public class a extends BaseWebViewClient {

        /* JADX INFO: renamed from: com.ali.auth.third.ui.QrLoginConfirmActivity$a$a, reason: collision with other inner class name */
        public class C0124a implements LoginCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ WebView f23520a;

            public C0124a(a aVar, WebView webView) {
                this.f23520a = webView;
            }

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
            }

            @Override // com.ali.auth.third.core.callback.LoginCallback
            public void onSuccess(Session session) {
                this.f23520a.reload();
            }
        }

        public a(QrLoginConfirmActivity qrLoginConfirmActivity, Activity activity) {
            super(activity);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!((LoginService) MemberSDK.getService(LoginService.class)).isLoginUrl(str)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            ((LoginService) MemberSDK.getService(LoginService.class)).auth(new C0124a(this, webView));
            return true;
        }
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity
    public WebViewClient createWebViewClient() {
        return new a(this, this);
    }

    @Override // com.ali.auth.third.ui.webview.BaseWebViewActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.authWebView.addBridgeObject("accountBridge", new LoginBridge());
    }
}
