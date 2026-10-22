package com.kc.bw.okhttp;

import android.content.Context;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.cache.CacheMode;
import com.kc.bw.okhttp.cookie.CookieJarImpl;
import com.kc.bw.okhttp.interceptor.SameRequestFilterInterceptor;
import com.kc.bw.okhttp.model.HttpHeaders;
import com.kc.bw.okhttp.model.HttpParams;
import com.kc.bw.okhttp.request.GetRequest;
import com.kc.bw.okhttp.request.PostRequest;
import com.kc.bw.okhttp.utils.HttpUtils;
import com.kc.bw.okhttp.utils.WMCommonThreadFactory;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OkHttp {
    public static final long DEFAULT_MILLISECONDS = 10000;
    public static long REFRESH_TIME = 300;
    public static final String TAG = dexg.dexa("XN`PlIuuq");
    public static boolean USE_CUSTOM_CONNECTION_POOL = true;
    public static boolean USE_CUSTOM_THREAD_POOL = true;
    public static String appToken;
    public static boolean enableHttpLog;
    public static boolean enableThreadLog;
    public static String packageName;
    public Context applicationContext;
    public HttpHeaders globalDefaultHeaders;
    public CacheMode mCacheMode;
    public long mCacheTime;
    public HttpParams mCommonParams;
    public int mRetryCount;
    public OkHttpClient okHttpClient;

    @Keep
    public static class OkHttpHolder {
        public static final OkHttp holder = new OkHttp();
    }

    public OkHttp() {
        this.mRetryCount = 3;
        this.mCacheTime = -1L;
        this.mCacheMode = CacheMode.NO_CACHE;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (USE_CUSTOM_THREAD_POOL) {
            builder.dispatcher(new Dispatcher(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new WMCommonThreadFactory(dexg.dexa("PlIuuq")))));
        }
        if (USE_CUSTOM_CONNECTION_POOL) {
            builder.connectionPool(new ConnectionPool(1, 1L, TimeUnit.MINUTES));
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(10000L, timeUnit);
        builder.writeTimeout(10000L, timeUnit);
        builder.connectTimeout(10000L, timeUnit);
        builder.addInterceptor(SameRequestFilterInterceptor.INTERCEPTOR);
        this.okHttpClient = builder.build();
    }

    public static void enableLog(boolean z, boolean z2) {
        enableHttpLog = z;
        enableThreadLog = z2;
    }

    public static <T> GetRequest<T> get(String str) {
        return new GetRequest<>(str);
    }

    public static OkHttp getInstance() {
        return OkHttpHolder.holder;
    }

    public static <T> PostRequest<T> post(String str) {
        return new PostRequest<>(str);
    }

    public OkHttp addCommonParams(HttpParams httpParams) {
        if (this.mCommonParams == null) {
            this.mCommonParams = new HttpParams();
        }
        this.mCommonParams.put(httpParams);
        return this;
    }

    public void cancelAll() {
        Iterator it = getOkHttpClient().dispatcher().queuedCalls().iterator();
        while (it.hasNext()) {
            ((Call) it.next()).cancel();
        }
        Iterator it2 = getOkHttpClient().dispatcher().runningCalls().iterator();
        while (it2.hasNext()) {
            ((Call) it2.next()).cancel();
        }
    }

    public void cancelTag(Object obj) {
        if (obj == null) {
            return;
        }
        for (Call call : getOkHttpClient().dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : getOkHttpClient().dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    public CacheMode getCacheMode() {
        return this.mCacheMode;
    }

    public long getCacheTime() {
        return this.mCacheTime;
    }

    public HttpParams getCommonParams() {
        return this.mCommonParams;
    }

    public Context getContext() {
        HttpUtils.checkNotNull(this.applicationContext, dexg.dexa("qmfbtf!dbmm!PlIuuq/hfuJotubodf)*/joju)*!gjstu!jo!bqqmjdbujpo\""));
        return this.applicationContext;
    }

    public CookieJarImpl getCookieJar() {
        return (CookieJarImpl) this.okHttpClient.cookieJar();
    }

    public HttpHeaders getGlobalDefaultHeaders() {
        return this.globalDefaultHeaders;
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public OkHttp init(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        packageName = applicationContext.getPackageName();
        appToken = str;
        return this;
    }

    public OkHttp setCacheMode(CacheMode cacheMode) {
        this.mCacheMode = cacheMode;
        return this;
    }

    public OkHttp setCacheTime(long j) {
        if (j <= -1) {
            j = -1;
        }
        this.mCacheTime = j;
        return this;
    }

    public OkHttp setGlobalDefaultHeadersV2(HttpHeaders httpHeaders) {
        if (this.globalDefaultHeaders == null) {
            this.globalDefaultHeaders = new HttpHeaders();
        }
        this.globalDefaultHeaders.put(httpHeaders);
        return this;
    }

    public OkHttp setOkHttpClient(OkHttpClient okHttpClient) {
        HttpUtils.checkNotNull(okHttpClient, dexg.dexa("plIuuqDmjfou!>>!ovmm"));
        this.okHttpClient = okHttpClient;
        return this;
    }

    public OkHttp setRetryCount(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(dexg.dexa("sfuszDpvou!nvtu!?>!1"));
        }
        this.mRetryCount = i;
        return this;
    }
}
