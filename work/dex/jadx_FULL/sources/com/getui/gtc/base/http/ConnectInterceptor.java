package com.getui.gtc.base.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ConnectInterceptor implements Interceptor {
    public final GtHttpClient client;

    public ConnectInterceptor(GtHttpClient gtHttpClient) {
        this.client = gtHttpClient;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = chain.request();
        HttpURLConnection httpURLConnectionConnection = chain.connection();
        httpURLConnectionConnection.setDoInput(true);
        httpURLConnectionConnection.setDoOutput(request.body() != null);
        httpURLConnectionConnection.setConnectTimeout(this.client.getConnectTimeout());
        httpURLConnectionConnection.setReadTimeout(this.client.getReadTimeout());
        httpURLConnectionConnection.setInstanceFollowRedirects(this.client.isFollowRedirects());
        httpURLConnectionConnection.setUseCaches(this.client.isUseCache());
        if ("https".equalsIgnoreCase(request.url().getProtocol())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnectionConnection;
            if (this.client.getSslSocketFactory() != null) {
                httpsURLConnection.setSSLSocketFactory(this.client.getSslSocketFactory());
            }
            if (this.client.getHostnameVerifier() != null) {
                httpsURLConnection.setHostnameVerifier(this.client.getHostnameVerifier());
            }
        }
        Map<String, String> mapHeaders = request.headers();
        if (mapHeaders != null && mapHeaders.size() > 0) {
            for (String str : mapHeaders.keySet()) {
                httpURLConnectionConnection.setRequestProperty(str, mapHeaders.get(str));
            }
        }
        httpURLConnectionConnection.connect();
        return realInterceptorChain.proceed(request, httpURLConnectionConnection);
    }
}
