package com.kc.bw.okhttp.cookie;

import com.kc.bw.dexg;
import com.kc.bw.okhttp.cookie.store.CookieStore;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CookieJarImpl implements CookieJar {
    public CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore) {
        if (cookieStore == null) {
            throw new IllegalArgumentException(dexg.dexa("dppljfTupsf!dbo!opu!cf!ovmm\""));
        }
        this.cookieStore = cookieStore;
    }

    public CookieStore getCookieStore() {
        return this.cookieStore;
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        List<Cookie> listLoadCookie;
        synchronized (this) {
            listLoadCookie = this.cookieStore.loadCookie(httpUrl);
        }
        return listLoadCookie;
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        synchronized (this) {
            this.cookieStore.saveCookie(httpUrl, list);
        }
    }
}
