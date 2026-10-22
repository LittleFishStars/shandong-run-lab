package com.ali.auth.third.core;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface WebViewProxy {
    void flush();

    String getCookie(String str);

    void removeAllCookie();

    void removeExpiredCookie();

    void removeSessionCookie();

    void setAcceptCookie(boolean z);

    void setCookie(String str, String str2);
}
