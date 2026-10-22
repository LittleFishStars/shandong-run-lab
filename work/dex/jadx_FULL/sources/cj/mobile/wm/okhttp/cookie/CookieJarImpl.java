package cj.mobile.wm.okhttp.cookie;

import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.cookie.store.CookieStore;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CookieJarImpl implements CookieJar {
    public CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore) {
        if (cookieStore == null) {
            throw new IllegalArgumentException(dexc.dexa("dppljfTupsf!dbo!opu!cf!ovmm\""));
        }
        this.cookieStore = cookieStore;
    }

    public CookieStore getCookieStore() {
        return this.cookieStore;
    }

    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return this.cookieStore.loadCookie(httpUrl);
    }

    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        this.cookieStore.saveCookie(httpUrl, list);
    }
}
