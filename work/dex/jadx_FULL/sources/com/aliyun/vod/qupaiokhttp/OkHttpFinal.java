package com.aliyun.vod.qupaiokhttp;

import android.text.TextUtils;
import com.aliyun.vod.qupaiokhttp.https.HttpsCerManager;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OkHttpFinal {
    private static OkHttpFinal okHttpFinal;
    private OkHttpFinalConfiguration configuration;
    private OkHttpClient okHttpClient;

    private OkHttpFinal() {
    }

    public static OkHttpFinal getInstance() {
        if (okHttpFinal == null) {
            okHttpFinal = new OkHttpFinal();
        }
        return okHttpFinal;
    }

    public List<InputStream> getCertificateList() {
        return this.configuration.getCertificateList();
    }

    public Headers getCommonHeaders() {
        return this.configuration.getCommonHeaders();
    }

    public List<Part> getCommonParams() {
        return this.configuration.getCommonParams();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.configuration.getHostnameVerifier();
    }

    @Deprecated
    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public OkHttpClient.Builder getOkHttpClientBuilder() {
        return this.okHttpClient.newBuilder();
    }

    public long getTimeout() {
        return this.configuration.getTimeout();
    }

    public synchronized void init(OkHttpFinalConfiguration okHttpFinalConfiguration) {
        this.configuration = okHttpFinalConfiguration;
        long timeout = okHttpFinalConfiguration.getTimeout();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder timeout2 = builder.connectTimeout(timeout, timeUnit).writeTimeout(timeout, timeUnit).readTimeout(timeout, timeUnit);
        if (okHttpFinalConfiguration.getHostnameVerifier() != null) {
            timeout2.hostnameVerifier(okHttpFinalConfiguration.getHostnameVerifier());
        }
        List<InputStream> certificateList = okHttpFinalConfiguration.getCertificateList();
        if (certificateList != null && certificateList.size() > 0) {
            new HttpsCerManager(timeout2).setCertificates(certificateList);
        }
        CookieJar cookieJar = okHttpFinalConfiguration.getCookieJar();
        if (cookieJar != null) {
            timeout2.cookieJar(cookieJar);
        }
        if (okHttpFinalConfiguration.getCache() != null) {
            timeout2.cache(okHttpFinalConfiguration.getCache());
        }
        if (okHttpFinalConfiguration.getAuthenticator() != null) {
            timeout2.authenticator(okHttpFinalConfiguration.getAuthenticator());
        }
        if (okHttpFinalConfiguration.getCertificatePinner() != null) {
            timeout2.certificatePinner(okHttpFinalConfiguration.getCertificatePinner());
        }
        timeout2.followRedirects(okHttpFinalConfiguration.isFollowRedirects());
        timeout2.followSslRedirects(okHttpFinalConfiguration.isFollowSslRedirects());
        if (okHttpFinalConfiguration.getSslSocketFactory() != null && okHttpFinalConfiguration.getX509TrustManager() != null) {
            timeout2.sslSocketFactory(okHttpFinalConfiguration.getSslSocketFactory(), okHttpFinalConfiguration.getX509TrustManager());
        }
        if (okHttpFinalConfiguration.getDispatcher() != null) {
            timeout2.dispatcher(okHttpFinalConfiguration.getDispatcher());
        }
        timeout2.retryOnConnectionFailure(okHttpFinalConfiguration.isRetryOnConnectionFailure());
        if (okHttpFinalConfiguration.getNetworkInterceptorList() != null) {
            timeout2.networkInterceptors().addAll(okHttpFinalConfiguration.getNetworkInterceptorList());
        }
        if (okHttpFinalConfiguration.getInterceptorList() != null) {
            timeout2.interceptors().addAll(okHttpFinalConfiguration.getInterceptorList());
        }
        if (okHttpFinalConfiguration.getProxy() != null) {
            timeout2.proxy(okHttpFinalConfiguration.getProxy());
        }
        ILogger.DEBUG = okHttpFinalConfiguration.isDebug();
        ILogger.d("OkHttpFinal init...", new Object[0]);
        Constants.DEBUG = okHttpFinalConfiguration.isDebug();
        this.okHttpClient = timeout2.build();
    }

    public void updateCommonHeader(String str, String str2) {
        Headers commonHeaders = this.configuration.getCommonHeaders();
        if (commonHeaders == null) {
            commonHeaders = new Headers.Builder().build();
        }
        this.configuration.commonHeaders = commonHeaders.newBuilder().set(str, str2).build();
    }

    public void updateCommonParams(String str, String str2) {
        boolean z;
        List<Part> commonParams = this.configuration.getCommonParams();
        if (commonParams == null) {
            z = false;
            break;
        }
        Iterator<Part> it = commonParams.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Part next = it.next();
            if (next != null && TextUtils.equals(next.getKey(), str)) {
                next.setValue(str2);
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        commonParams.add(new Part(str, str2));
    }
}
