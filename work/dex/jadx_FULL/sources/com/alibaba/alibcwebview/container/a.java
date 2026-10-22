package com.alibaba.alibcwebview.container;

import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23715a = "a";
    private WeakReference<WebChromeClient> b;
    private WeakReference<WebView> c;

    public a(WebView webView) {
        this.c = new WeakReference<>(webView);
    }

    private boolean a() {
        WeakReference<WebChromeClient> weakReference = this.b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AlibcLogger.i(f23715a, consoleMessage.message() + "-- from line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
        boolean zA = false;
        boolean zOnConsoleMessage = a() ? this.b.get().onConsoleMessage(consoleMessage) : false;
        WebView webView = this.c.get();
        if (!zOnConsoleMessage) {
            com.alibaba.alibcwebview.jsbridge.a.a();
            zA = com.alibaba.alibcwebview.jsbridge.a.a(webView, consoleMessage);
        }
        if (zOnConsoleMessage || zA) {
            return true;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a() ? this.b.get().onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a() ? this.b.get().onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        boolean zA = false;
        boolean zOnJsPrompt = a() ? this.b.get().onJsPrompt(webView, str, str2, str3, jsPromptResult) : false;
        if (!zOnJsPrompt) {
            com.alibaba.alibcwebview.jsbridge.a.a();
            zA = com.alibaba.alibcwebview.jsbridge.a.a(webView, str2, str3, jsPromptResult);
        }
        if (zOnJsPrompt || zA) {
            return true;
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (a()) {
            this.b.get().onProgressChanged(webView, i);
        }
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (a()) {
            this.b.get().onReceivedTitle(webView, str);
        }
        com.alibaba.alibcwebview.messagebus.a.a().a(str);
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (a()) {
            this.b.get().onShowCustomView(view, customViewCallback);
        }
        super.onShowCustomView(view, customViewCallback);
    }
}
