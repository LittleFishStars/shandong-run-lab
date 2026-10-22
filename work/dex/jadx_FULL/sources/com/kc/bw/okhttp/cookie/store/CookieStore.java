package com.kc.bw.okhttp.cookie.store;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface CookieStore {
    List<Cookie> getAllCookie();

    List<Cookie> getCookie(HttpUrl httpUrl);

    List<Cookie> loadCookie(HttpUrl httpUrl);

    boolean removeAllCookie();

    boolean removeCookie(HttpUrl httpUrl);

    boolean removeCookie(HttpUrl httpUrl, Cookie cookie);

    void saveCookie(HttpUrl httpUrl, List<Cookie> list);

    void saveCookie(HttpUrl httpUrl, Cookie cookie);
}
