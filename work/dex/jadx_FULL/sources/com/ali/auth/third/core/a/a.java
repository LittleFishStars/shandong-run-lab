package com.ali.auth.third.core.a;

import android.webkit.CookieManager;
import com.ali.auth.third.core.WebViewProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements WebViewProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f23409a;

    private a() {
    }

    public static a a() {
        if (f23409a == null) {
            synchronized (a.class) {
                if (f23409a == null) {
                    f23409a = new a();
                }
            }
        }
        return f23409a;
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void flush() {
        try {
            CookieManager.getInstance().flush();
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public String getCookie(String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        return cookieManager.getCookie(".taobao.com");
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void removeAllCookie() {
        CookieManager.getInstance().removeAllCookie();
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void removeExpiredCookie() {
        CookieManager.getInstance().removeExpiredCookie();
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void removeSessionCookie() {
        CookieManager.getInstance().removeSessionCookie();
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void setAcceptCookie(boolean z) {
        CookieManager.getInstance().setAcceptCookie(z);
    }

    @Override // com.ali.auth.third.core.WebViewProxy
    public void setCookie(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
    }
}
