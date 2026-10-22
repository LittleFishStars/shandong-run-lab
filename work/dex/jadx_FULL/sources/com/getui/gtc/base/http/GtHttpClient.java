package com.getui.gtc.base.http;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GtHttpClient {
    private final int connectTimeout;
    private final Dispatcher dispatcher;
    private final boolean followRedirects;
    private final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    private final int readTimeout;
    private final boolean retryOnConnectionFailure;
    private final SSLSocketFactory sslSocketFactory;
    private final boolean useCache;

    public static final class Builder {
        int connectTimeout;
        Dispatcher dispatcher;
        boolean followRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SSLSocketFactory sslSocketFactory;
        boolean useCache;

        public Builder() {
            this.interceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.useCache = false;
            this.connectTimeout = 7000;
            this.readTimeout = 7000;
        }

        public Builder(GtHttpClient gtHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.interceptors = arrayList;
            this.dispatcher = gtHttpClient.dispatcher;
            arrayList.addAll(gtHttpClient.interceptors);
            this.sslSocketFactory = gtHttpClient.sslSocketFactory;
            this.hostnameVerifier = gtHttpClient.hostnameVerifier;
            this.followRedirects = gtHttpClient.followRedirects;
            this.retryOnConnectionFailure = gtHttpClient.retryOnConnectionFailure;
            this.useCache = gtHttpClient.useCache;
            this.connectTimeout = gtHttpClient.connectTimeout;
            this.readTimeout = gtHttpClient.readTimeout;
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.interceptors.add(interceptor);
            return this;
        }

        public final GtHttpClient build() {
            return new GtHttpClient(this);
        }

        public final Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("connectTimeout", j, timeUnit);
            return this;
        }

        public final Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public final Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("readTimeout", j, timeUnit);
            return this;
        }

        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public final Builder useCache(boolean z) {
            this.useCache = z;
            return this;
        }
    }

    public GtHttpClient() {
        this(new Builder());
    }

    public GtHttpClient(Builder builder) {
        this.dispatcher = builder.dispatcher;
        List<Interceptor> listImmutableList = Util.immutableList(builder.interceptors);
        this.interceptors = listImmutableList;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.useCache = builder.useCache;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        if (listImmutableList.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + listImmutableList);
        }
    }

    @Deprecated
    public static GtHttpClient getDefaultInstance() {
        return new Builder().build();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public boolean isUseCache() {
        return this.useCache;
    }

    public Call newCall(Request request) {
        return RealCall.newCall(this, request);
    }
}
