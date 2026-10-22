package com.zj.adlib;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.hzjizhun.admin.base.b0;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class tzb extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f45035a;

    public tzb(b0 b0Var) {
        this.f45035a = b0Var;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        try {
            b0.a(this.f45035a);
            b0 b0Var = this.f45035a;
            b0Var.getClass();
            try {
                HashMap map = new HashMap();
                map.put("__TS__", System.currentTimeMillis() + "");
                b0Var.a(40, map);
            } catch (Throwable unused) {
            }
            if (str.equals(this.f45035a.p)) {
                return;
            }
            b0 b0Var2 = this.f45035a;
            b0Var2.getClass();
            HashMap map2 = new HashMap();
            map2.put("__TS_END__", System.currentTimeMillis() + "");
            b0Var2.a(41, map2);
        } catch (Throwable unused2) {
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        pwb pwbVar = this.f45035a.r;
        if (pwbVar != null) {
            pwbVar.post(new iyb(this, webView));
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return hrb.c(str) ? this.f45035a.getEmptyWebResourceResponse() : super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (hrb.c(str)) {
            return true;
        }
        b0 b0Var = this.f45035a;
        b0Var.a(str, b0Var.f22697a);
        if (!str.equals(this.f45035a.p)) {
            this.f45035a.a();
            b0 b0Var2 = this.f45035a;
            b0Var2.getClass();
            HashMap map = new HashMap();
            map.put("__TS_END__", System.currentTimeMillis() + "");
            b0Var2.a(41, map);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            if (hrb.c(webResourceRequest.getUrl().toString())) {
                return this.f45035a.getEmptyWebResourceResponse();
            }
            WebResourceResponse webResourceResponseA = b0.a(this.f45035a, webResourceRequest);
            return webResourceResponseA != null ? webResourceResponseA : this.f45035a.getEmptyWebResourceResponse();
        } catch (Throwable unused) {
            return this.f45035a.getEmptyWebResourceResponse();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) {
            return true;
        }
        try {
            String string = webResourceRequest.getUrl().toString();
            if (hrb.c(string)) {
                return true;
            }
            b0 b0Var = this.f45035a;
            b0Var.a(string, b0Var.f22697a);
            this.f45035a.a();
        } catch (Throwable unused) {
        }
        return true;
    }
}
