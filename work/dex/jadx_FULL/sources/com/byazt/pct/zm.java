package com.byazt.pct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alibaba.ariver.remotedebug.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 482})
public class zm extends c {
    public static final /* synthetic */ boolean i = true;
    public String sp;
    public com.byazt.nl.uj x;

    @Override // com.byazt.pct.c
    public String c() {
        return this.x.getUrl();
    }

    @Override // com.byazt.pct.c
    public Context getContext(da daVar) {
        Context context = daVar.n;
        if (context != null) {
            return context;
        }
        com.byazt.nl.uj ujVar = daVar.c;
        if (ujVar != null) {
            View view = ujVar.getView();
            if (view != null) {
                return view.getContext();
            }
            WebView webView = daVar.c.getWebView();
            if (webView != null) {
                return webView.getContext();
            }
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.byazt.pct.c
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    public void n() {
        com.byazt.nl.uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.removeJavascriptInterface(this.sp);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void uj() {
        if (!i && this.x == null) {
            throw new AssertionError();
        }
        com.byazt.nl.uj ujVar = this.x;
        if (ujVar != null) {
            ujVar.addJavascriptInterface(this, this.sp);
        }
    }

    @Override // com.byazt.pct.c
    public void ve() {
        super.ve();
        n();
    }

    @Override // com.byazt.pct.c
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void c(da daVar) {
        this.x = daVar.c;
        this.sp = daVar.ve;
        if (daVar.yp) {
            return;
        }
        uj();
    }

    @Override // com.byazt.pct.c
    public void c(String str, m mVar) {
        if (mVar != null && !TextUtils.isEmpty(mVar.x)) {
            String str2 = mVar.x;
            c(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.c(str, mVar);
    }

    @Override // com.byazt.pct.c
    public void c(String str) {
        c(str, b.k + this.sp + "._handleMessageFromToutiao(" + str + ")");
    }

    private void c(String str, String str2) {
        if (this.n || TextUtils.isEmpty(str2) || this.n) {
            return;
        }
        try {
            this.x.evaluateJavascript(str2, null);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
