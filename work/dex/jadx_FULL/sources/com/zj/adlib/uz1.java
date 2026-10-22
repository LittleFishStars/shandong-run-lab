package com.zj.adlib;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class uz1 extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        i4a.a("WebViewClient : onLoadResource");
        super.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        i4a.a("WebViewClient : onPageFinished");
        super.onPageFinished(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        i4a.a("WebViewClient : onPageStarted");
        super.onPageStarted(view, url, favicon);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        i4a.a("WebViewClient : onReceivedError");
        super.onReceivedError(view, request, error);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        i4a.a("WebViewClient : onReceivedHttpError");
        super.onReceivedHttpError(view, request, errorResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        i4a.a("WebViewClient : onReceivedSslError");
        super.onReceivedSslError(view, handler, error);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        i4a.a("WebViewClient : shouldInterceptRequest");
        return super.shouldInterceptRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        i4a.a("WebViewClient : shouldOverrideKeyEvent");
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        i4a.a("WebViewClient : shouldOverrideUrlLoading");
        return super.shouldOverrideUrlLoading(view, request);
    }
}
