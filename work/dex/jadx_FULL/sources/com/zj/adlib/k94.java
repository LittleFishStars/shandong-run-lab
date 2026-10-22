package com.zj.adlib;

import android.app.Activity;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class k94 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f42768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xo4 f17609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17610a = "InjectedChromeClient";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17611a;

    public k94(Activity activity, String injectedName, Class injectedCls) {
        this.f42768a = activity;
        this.f17609a = new xo4(injectedName, injectedCls);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView window) {
        super.onCloseWindow(window);
        Activity activity = this.f42768a;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        result.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        result.confirm(this.f17609a.call(view, message));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView view, int newProgress) {
        if (newProgress <= 25) {
            this.f17611a = false;
        } else if (!this.f17611a) {
            view.loadUrl(this.f17609a.b());
            this.f17611a = true;
            Log.d("InjectedChromeClient", " inject js interface completely on progress " + newProgress);
        }
        super.onProgressChanged(view, newProgress);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
    }

    public k94(xo4 jsCallJava) {
        this.f17609a = jsCallJava;
    }
}
