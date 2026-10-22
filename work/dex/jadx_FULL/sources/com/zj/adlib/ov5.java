package com.zj.adlib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huachenjie.common.callback.VoidCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ov5 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f43840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18733a = true;

    public ov5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f18733a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f18733a = true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        if (url == null || !url.startsWith("carfree://closewindow")) {
            super.onLoadResource(view, url);
            return;
        }
        view.stopLoading();
        Activity activity = this.f43840a;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"WebViewClientOnReceivedSslError"})
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return shouldOverrideUrlLoading(view, request.getUrl().toString());
    }

    public ov5(Activity activity) {
        this.f43840a = activity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url == null || !this.f18733a) {
            return true;
        }
        if (url.toLowerCase().startsWith("http")) {
            return super.shouldOverrideUrlLoading(view, url);
        }
        if (!url.toLowerCase().startsWith(WVUCWebViewClient.SCHEME_TEL) && !url.toLowerCase().startsWith(WVUCWebViewClient.SCHEME_SMS)) {
            if (url.toLowerCase().startsWith("shandong-open://")) {
                try {
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(tm0.b(url.replace("shandong-open://", "")))));
                } catch (Exception unused) {
                }
                return true;
            }
            try {
                this.f18733a = false;
                qa6.a().b().a(view.getContext(), url, new VoidCallback() { // from class: com.zj.adlib.mv5
                    @Override // com.huachenjie.common.callback.VoidCallback
                    public final void a() {
                        this.f43393a.c();
                    }
                }, new VoidCallback() { // from class: com.zj.adlib.nv5
                    @Override // com.huachenjie.common.callback.VoidCallback
                    public final void a() {
                        this.f43615a.d();
                    }
                });
                return true;
            } catch (Exception unused2) {
                this.f18733a = true;
                return true;
            }
        }
        try {
            view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception unused3) {
        }
        return true;
    }
}
