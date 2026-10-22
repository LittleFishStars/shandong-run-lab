package com.alipay.sdk.m.c0;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class c extends FrameLayout {
    public static final String c = "v1";
    public static final String d = "v2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f25405a;
    public final String b;

    public c(Activity activity, String str) {
        super(activity);
        this.f25405a = activity;
        this.b = str;
    }

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f25405a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean b();

    public abstract void c();

    public boolean a() {
        return c.equals(this.b);
    }

    public static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }
}
