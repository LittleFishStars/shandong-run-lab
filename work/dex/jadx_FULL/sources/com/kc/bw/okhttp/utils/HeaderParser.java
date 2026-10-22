package com.kc.bw.okhttp.utils;

import android.text.TextUtils;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.cache.CacheEntity;
import com.kc.bw.okhttp.cache.CacheMode;
import com.kc.bw.okhttp.model.HttpHeaders;
import com.kc.bw.okhttp.request.base.Request;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HeaderParser {
    public static <T> void addCacheHeaders(Request request, CacheEntity<T> cacheEntity, CacheMode cacheMode) {
        HttpHeaders responseHeaders;
        if (cacheEntity == null || cacheMode != CacheMode.DEFAULT || (responseHeaders = cacheEntity.getResponseHeaders()) == null) {
            return;
        }
        String str = responseHeaders.get(dexg.dexa("FUbh"));
        if (str != null) {
            request.headers(dexg.dexa("Jg.Opof.Nbudi"), str);
        }
        long lastModified = HttpHeaders.getLastModified(responseHeaders.get(dexg.dexa("Mbtu.Npejgjfe")));
        if (lastModified > 0) {
            request.headers(dexg.dexa("Jg.Npejgjfe.Tjodf"), HttpHeaders.formatMillisToGMT(lastModified));
        }
    }

    public static <T> CacheEntity<T> createCacheEntity(Headers headers, T t, CacheMode cacheMode, String str) {
        long jCurrentTimeMillis;
        long j;
        if (cacheMode == CacheMode.DEFAULT) {
            long date = HttpHeaders.getDate(headers.get(dexg.dexa("Ebuf")));
            jCurrentTimeMillis = HttpHeaders.getExpiration(headers.get(dexg.dexa("Fyqjsft")));
            String cacheControl = HttpHeaders.getCacheControl(headers.get(dexg.dexa("Dbdif.Dpouspm")), headers.get(dexg.dexa("Qsbhnb")));
            if (TextUtils.isEmpty(cacheControl) && jCurrentTimeMillis <= 0) {
                return null;
            }
            if (TextUtils.isEmpty(cacheControl)) {
                j = 0;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(cacheControl, dexg.dexa(c49.f40900a));
                j = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.equals(dexg.dexa("op.dbdif")) || lowerCase.equals(dexg.dexa("op.tupsf"))) {
                        return null;
                    }
                    if (lowerCase.startsWith(dexg.dexa("nby.bhf>"))) {
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
