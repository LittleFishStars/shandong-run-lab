package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Picture;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.androidquery.util.Constants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ou9 extends WebViewClient {
    public static String b = null;
    public static final String c = "WebViewSettings";
    public static final String d = "double_tap_toast_count";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WebView f18726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f18727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18729a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18730b;

    public class a implements WebView.PictureListener {
        public a() {
        }

        @Override // android.webkit.WebView.PictureListener
        public void onNewPicture(WebView webView, Picture picture) {
            ou9.this.f18726a.setPictureListener(null);
            ou9.this.i();
        }
    }

    public ou9(WebView webView, String str, Object obj, boolean z, boolean z2, int i) {
        this.f18726a = webView;
        this.f18728a = str;
        this.f18727a = obj;
        this.f18729a = z;
        this.f18730b = z2;
        this.f43835a = i;
    }

    public static void d(WebView webView) {
        gq.B(webView.getSettings(), "setDisplayZoomControls", false, false, new Class[]{Boolean.TYPE}, Boolean.FALSE);
    }

    public static void f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(c, 0);
        if (sharedPreferences.getInt(d, 1) > 0) {
            sharedPreferences.edit().putInt(d, 0).commit();
        }
    }

    public static String g(Context context) {
        if (b == null) {
            try {
                b = new String(gq.b0(context.getClassLoader().getResourceAsStream("com/androidquery/util/web_image.html")));
            } catch (Exception e) {
                gq.k(e);
            }
        }
        return b;
    }

    public final void c() {
        this.f18726a.setPictureListener(new a());
        this.f18726a.loadData("<html></html>", "text/html", "utf-8");
        this.f18726a.setBackgroundColor(this.f43835a);
    }

    public final void e(WebView webView) {
        if (this.f18727a != null) {
            webView.setVisibility(0);
            vp1.n(this.f18727a, this.f18728a, false);
        }
        webView.setWebViewClient(null);
    }

    public void h() {
        if (this.f18728a.equals(this.f18726a.getTag(Constants.u))) {
            return;
        }
        this.f18726a.setTag(Constants.u, this.f18728a);
        f(this.f18726a.getContext());
        WebSettings settings = this.f18726a.getSettings();
        settings.setSupportZoom(this.f18729a);
        settings.setBuiltInZoomControls(this.f18729a);
        if (!this.f18730b) {
            d(this.f18726a);
        }
        settings.setJavaScriptEnabled(true);
        this.f18726a.setBackgroundColor(this.f43835a);
        Object obj = this.f18727a;
        if (obj != null) {
            vp1.n(obj, this.f18728a, true);
        }
        if (this.f18726a.getWidth() > 0) {
            i();
        } else {
            c();
        }
    }

    public final void i() {
        String strReplace = g(this.f18726a.getContext()).replace("@src", this.f18728a).replace("@color", Integer.toHexString(this.f43835a));
        this.f18726a.setWebViewClient(this);
        this.f18726a.loadDataWithBaseURL(null, strReplace, "text/html", "utf-8", null);
        this.f18726a.setBackgroundColor(this.f43835a);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        e(webView);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        e(webView);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
    }
}
