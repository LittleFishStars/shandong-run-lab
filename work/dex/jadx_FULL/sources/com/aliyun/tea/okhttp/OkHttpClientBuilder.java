package com.aliyun.tea.okhttp;

import com.aliyun.tea.TeaException;
import com.aliyun.tea.okhttp.interceptors.SocksProxyAuthInterceptor;
import com.aliyun.tea.utils.StringUtils;
import com.aliyun.tea.utils.TrueHostnameVerifier;
import com.aliyun.tea.utils.X509TrustManagerImp;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.common.net.b;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OkHttpClientBuilder {
    private static final String charset = "UTF-8";
    private OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

    public OkHttpClient buildOkHttpClient() {
        return this.builder.build();
    }

    public OkHttpClientBuilder certificate(Map<String, Object> map) {
        KeyManagerFactory keyManagerFactory;
        try {
            if (Boolean.parseBoolean(String.valueOf(map.get("ignoreSSL")))) {
                X509TrustManagerImp x509TrustManagerImp = new X509TrustManagerImp();
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{x509TrustManagerImp}, new SecureRandom());
                this.builder.sslSocketFactory(sSLContext.getSocketFactory(), x509TrustManagerImp).hostnameVerifier(new TrueHostnameVerifier());
            } else if (map.containsKey("ca") && !StringUtils.isEmpty(map.get("ca"))) {
                SSLContext sSLContext2 = SSLContext.getInstance("TLS");
                if (!map.containsKey(CachedContentIndex.a.e) || StringUtils.isEmpty(map.get(CachedContentIndex.a.e)) || !map.containsKey("cert") || StringUtils.isEmpty(map.get("cert"))) {
                    keyManagerFactory = null;
                } else {
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(String.valueOf(map.get("cert")).getBytes("UTF-8"));
                    try {
                        keyStore.load(byteArrayInputStream, String.valueOf(map.get(CachedContentIndex.a.e)).toCharArray());
                        byteArrayInputStream.close();
                        keyManagerFactory = KeyManagerFactory.getInstance("X.509");
                        keyManagerFactory.init(keyStore, String.valueOf(map.get(CachedContentIndex.a.e)).toCharArray());
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                }
                KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore2.load(null);
                String strValueOf = String.valueOf(map.get("ca"));
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(strValueOf.getBytes("UTF-8"));
                try {
                    Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(byteArrayInputStream2);
                    byteArrayInputStream2.close();
                    keyStore2.setCertificateEntry("server-ca", certificateGenerateCertificate);
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init(keyStore2);
                    X509TrustManager x509TrustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
                    sSLContext2.init(keyManagerFactory != null ? keyManagerFactory.getKeyManagers() : null, trustManagerFactory.getTrustManagers(), new SecureRandom());
                    this.builder.sslSocketFactory(sSLContext2.getSocketFactory(), x509TrustManager).hostnameVerifier(new TrueHostnameVerifier());
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            }
            return this;
        } catch (Exception e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public OkHttpClientBuilder connectTimeout(Map<String, Object> map) {
        try {
            this.builder.connectTimeout(Long.parseLong(String.valueOf(map.get("connectTimeout"))), TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        return this;
    }

    public OkHttpClientBuilder connectionPool(Map<String, Object> map) {
        int i;
        try {
            i = Integer.parseInt(String.valueOf(map.get("maxIdleConns")));
        } catch (Exception unused) {
            i = 5;
        }
        this.builder.connectionPool(new ConnectionPool(i, (!map.containsKey("keepAliveDuration") || map.get("keepAliveDuration") == null) ? 10000L : Long.parseLong(String.valueOf(map.get("keepAliveDuration"))), TimeUnit.MILLISECONDS));
        return this;
    }

    public OkHttpClientBuilder proxy(Map<String, Object> map) {
        try {
            if (map.get("httpProxy") != null || map.get("httpsProxy") != null) {
                URL url = new URL(String.valueOf(map.get("httpProxy") == null ? map.get("httpsProxy") : map.get("httpProxy")));
                this.builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort())));
            } else if (map.get("socks5Proxy") != null) {
                URI uri = new URI(String.valueOf(map.get("socks5Proxy")));
                this.builder.proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(uri.getHost(), uri.getPort())));
            }
            return this;
        } catch (Exception e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public OkHttpClientBuilder proxyAuthenticator(Map<String, Object> map) {
        String userInfo;
        try {
            if (map.get("httpProxy") != null || map.get("httpsProxy") != null) {
                String userInfo2 = new URL(String.valueOf(map.get("httpsProxy") != null ? map.get("httpsProxy") : map.get("httpProxy"))).getUserInfo();
                if (userInfo2 != null) {
                    String[] strArrSplit = userInfo2.split(u15.f19942b);
                    final String strBasic = Credentials.basic(strArrSplit[0], strArrSplit[1]);
                    this.builder.proxyAuthenticator(new Authenticator() { // from class: com.aliyun.tea.okhttp.OkHttpClientBuilder.1
                        public Request authenticate(Route route, Response response) throws IOException {
                            return response.request().newBuilder().header(b.H, strBasic).build();
                        }
                    });
                }
            } else if (map.get("socks5Proxy") != null && (userInfo = new URI(String.valueOf(map.get("socks5Proxy"))).getUserInfo()) != null) {
                String[] strArrSplit2 = userInfo.split(u15.f19942b);
                this.builder.addInterceptor(new SocksProxyAuthInterceptor(strArrSplit2[0], strArrSplit2[1]));
            }
            return this;
        } catch (Exception e) {
            throw new TeaException(e.getMessage(), e);
        }
    }

    public OkHttpClientBuilder readTimeout(Map<String, Object> map) {
        try {
            this.builder.readTimeout(Long.parseLong(String.valueOf(map.get("readTimeout"))), TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        return this;
    }
}
