package com.aliyun.vod.qupaiokhttp;

import com.aliyun.vod.common.utils.StringUtils;
import com.google.common.net.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;
import okio.Buffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OkHttpFinalConfiguration {
    private Authenticator authenticator;
    private Cache cache;
    private List<InputStream> certificateList;
    private CertificatePinner certificatePinner;
    protected Headers commonHeaders;
    private List<Part> commonParams;
    private CookieJar cookieJar;
    private boolean debug;
    private Dispatcher dispatcher;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private HostnameVerifier hostnameVerifier;
    private List<Interceptor> interceptorList;
    private List<Interceptor> networkInterceptorList;
    private Proxy proxy;
    private boolean retryOnConnectionFailure;
    private SSLSocketFactory sslSocketFactory;
    private long timeout;
    private X509TrustManager x509TrustManager;

    public static class Builder {
        private Authenticator authenticator;
        private Cache cache;
        private CertificatePinner certificatePinner;
        private Headers commonHeaders;
        private List<Part> commonParams;
        private boolean debug;
        private Dispatcher dispatcher;
        private HostnameVerifier hostnameVerifier;
        private List<Interceptor> interceptorList;
        private Proxy proxy;
        private SSLSocketFactory sslSocketFactory;
        private long timeout;
        private X509TrustManager x509TrustManager;
        private CookieJar cookieJar = CookieJar.NO_COOKIES;
        private List<InputStream> certificateList = new ArrayList();
        private boolean followSslRedirects = true;
        private boolean followRedirects = true;
        private boolean retryOnConnectionFailure = true;
        private List<Interceptor> networkInterceptorList = new ArrayList();

        public OkHttpFinalConfiguration build() {
            return new OkHttpFinalConfiguration(this);
        }

        public Builder setAuthenticator(Authenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        public Builder setCache(Cache cache) {
            this.cache = cache;
            return this;
        }

        public Builder setCacheAge(Cache cache, int i) {
            setCache(cache, String.format("max-age=%d", Integer.valueOf(i)));
            return this;
        }

        public Builder setCacheStale(Cache cache, int i) {
            setCache(cache, String.format("max-stale=%d", Integer.valueOf(i)));
            return this;
        }

        public Builder setCertificatePinner(CertificatePinner certificatePinner) {
            this.certificatePinner = certificatePinner;
            return this;
        }

        public Builder setCertificates(InputStream... inputStreamArr) {
            for (InputStream inputStream : inputStreamArr) {
                if (inputStream != null) {
                    this.certificateList.add(inputStream);
                }
            }
            return this;
        }

        public Builder setCommenHeaders(Headers headers) {
            this.commonHeaders = headers;
            return this;
        }

        public Builder setCommenParams(List<Part> list) {
            this.commonParams = list;
            return this;
        }

        public Builder setCookieJar(CookieJar cookieJar) {
            this.cookieJar = cookieJar;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setDispatcher(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public Builder setFollowRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder setFollowSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder setInterceptors(List<Interceptor> list) {
            this.interceptorList = list;
            return this;
        }

        public Builder setNetworkInterceptors(List<Interceptor> list) {
            if (list != null) {
                this.networkInterceptorList.addAll(list);
            }
            return this;
        }

        public Builder setProxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder setRetryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            this.sslSocketFactory = sSLSocketFactory;
            this.x509TrustManager = x509TrustManager;
            return this;
        }

        public Builder setTimeout(long j) {
            this.timeout = j;
            return this;
        }

        public Builder setCache(Cache cache, final String str) {
            this.networkInterceptorList.add(new Interceptor() { // from class: com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration.Builder.1
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    return chain.proceed(chain.request()).newBuilder().removeHeader(b.e).header("Cache-Control", str).build();
                }
            });
            this.cache = cache;
            return this;
        }

        public Builder setCertificates(String... strArr) {
            for (String str : strArr) {
                if (!StringUtils.isEmpty(str)) {
                    this.certificateList.add(new Buffer().writeUtf8(str).inputStream());
                }
            }
            return this;
        }
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public Cache getCache() {
        return this.cache;
    }

    public List<InputStream> getCertificateList() {
        return this.certificateList;
    }

    public CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public Headers getCommonHeaders() {
        return this.commonHeaders;
    }

    public List<Part> getCommonParams() {
        return this.commonParams;
    }

    public CookieJar getCookieJar() {
        return this.cookieJar;
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> getInterceptorList() {
        return this.interceptorList;
    }

    public List<Interceptor> getNetworkInterceptorList() {
        return this.networkInterceptorList;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public boolean isRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    private OkHttpFinalConfiguration(Builder builder) {
        this.timeout = 30000L;
        this.commonParams = builder.commonParams;
        this.commonHeaders = builder.commonHeaders;
        this.certificateList = builder.certificateList;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.timeout = builder.timeout;
        this.debug = builder.debug;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.authenticator = builder.authenticator;
        this.certificatePinner = builder.certificatePinner;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.proxy = builder.proxy;
        this.networkInterceptorList = builder.networkInterceptorList;
        this.interceptorList = builder.interceptorList;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.x509TrustManager = builder.x509TrustManager;
        this.dispatcher = builder.dispatcher;
    }
}
