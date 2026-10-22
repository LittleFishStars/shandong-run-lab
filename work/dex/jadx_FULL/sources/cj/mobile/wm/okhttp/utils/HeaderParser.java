package cj.mobile.wm.okhttp.utils;

import android.text.TextUtils;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.cache.CacheEntity;
import cj.mobile.wm.okhttp.cache.CacheMode;
import cj.mobile.wm.okhttp.model.HttpHeaders;
import cj.mobile.wm.okhttp.request.base.Request;
import com.zj.adlib.c49;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HeaderParser {
    public static <T> void addCacheHeaders(Request request, CacheEntity<T> cacheEntity, CacheMode cacheMode) {
        HttpHeaders responseHeaders;
        if (cacheEntity == null || cacheMode != CacheMode.DEFAULT || (responseHeaders = cacheEntity.getResponseHeaders()) == null) {
            return;
        }
        String str = responseHeaders.get(dexc.dexa("FUbh"));
        if (str != null) {
            request.headers(dexc.dexa("Jg.Opof.Nbudi"), str);
        }
        long lastModified = HttpHeaders.getLastModified(responseHeaders.get(dexc.dexa("Mbtu.Npejgjfe")));
        if (lastModified > 0) {
            request.headers(dexc.dexa("Jg.Npejgjfe.Tjodf"), HttpHeaders.formatMillisToGMT(lastModified));
        }
    }

    public static <T> CacheEntity<T> createCacheEntity(Headers headers, T t, CacheMode cacheMode, String str) {
        long jCurrentTimeMillis;
        long j;
        if (cacheMode == CacheMode.DEFAULT) {
            long date = HttpHeaders.getDate(headers.get(dexc.dexa("Ebuf")));
            jCurrentTimeMillis = HttpHeaders.getExpiration(headers.get(dexc.dexa("Fyqjsft")));
            String cacheControl = HttpHeaders.getCacheControl(headers.get(dexc.dexa("Dbdif.Dpouspm")), headers.get(dexc.dexa("Qsbhnb")));
            if (TextUtils.isEmpty(cacheControl) && jCurrentTimeMillis <= 0) {
                return null;
            }
            if (TextUtils.isEmpty(cacheControl)) {
                j = 0;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(cacheControl, dexc.dexa(c49.f40900a));
                j = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.equals(dexc.dexa("op.dbdif")) || lowerCase.equals(dexc.dexa("op.tupsf"))) {
                        return null;
                    }
                    if (lowerCase.startsWith(dexc.dexa("nby.bhf>"))) {
                        try {
                            j = Long.parseLong(lowerCase.substring(8));
                            if (j <= 0) {
                                return null;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (date <= 0) {
                date = jCurrentTimeMillis2;
            }
            if (j > 0) {
                jCurrentTimeMillis = date + (j * 1000);
            } else if (jCurrentTimeMillis < 0) {
                jCurrentTimeMillis = 0;
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        for (String str2 : headers.names()) {
            httpHeaders.put(str2, headers.get(str2));
        }
        CacheEntity<T> cacheEntity = new CacheEntity<>();
        cacheEntity.setKey(str);
        cacheEntity.setData(t);
        cacheEntity.setLocalExpire(jCurrentTimeMillis);
        cacheEntity.setResponseHeaders(httpHeaders);
        return cacheEntity;
    }
}
