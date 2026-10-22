package com.aliyun.vod.common.httpfinal;

import android.text.TextUtils;
import android.util.Log;
import com.aliyun.vod.qupaiokhttp.OkHttpFinal;
import com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class QupaiHttpFinal implements HttpInterface {
    private static QupaiHttpFinal instance;

    private static void addHttps(OkHttpFinalConfiguration.Builder builder) {
        try {
            X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.aliyun.vod.common.httpfinal.QupaiHttpFinal.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    StringBuilder sb = new StringBuilder();
                    sb.append("X509TrustManager checkClientTrusted: ");
                    sb.append(x509CertificateArr == null ? "null" : Integer.valueOf(x509CertificateArr.length));
                    Log.d("AliYunLog", sb.toString());
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    checkServerTrusted(x509CertificateArr, str, null);
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    Log.d("AliYunLog", "X509TrustManager getAcceptedIssuers:");
                    return new X509Certificate[0];
                }

                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
                    if (x509CertificateArr == null) {
                        Log.e("AliYunLog", "X509TrustManager checkServerTrusted: X509Certificate is null");
                        throw new IllegalArgumentException("X509TrustManager checkServerTrusted: X509Certificate is null");
                    }
                    try {
                        if (x509CertificateArr.length > 0) {
                            x509CertificateArr[0].checkValidity();
                        }
                        Log.d("AliYunLog", "X509TrustManager checkServerTrusted: checkValidity " + x509CertificateArr.length);
                    } catch (Exception e) {
                        Log.e("AliYunLog", "X509TrustManager checkServerTrusted: checkValidity exception " + e.getMessage());
                    }
                }
            };
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            builder.setSSLSocketFactory(sSLContext.getSocketFactory(), x509TrustManager);
            builder.setHostnameVerifier(new HostnameVerifier() { // from class: com.aliyun.vod.common.httpfinal.QupaiHttpFinal.2
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        Log.d("AliYunLog", "HostnameVerifier verify false");
                        return false;
                    }
                    try {
                        Log.d("AliYunLog", "HostnameVerifier verify true, default verify " + HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession));
                        return true;
                    } catch (Exception e) {
                        Log.d("AliYunLog", "HostnameVerifier verify true, default exception " + e.getMessage());
                        return true;
                    }
                }
            });
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    public static QupaiHttpFinal getInstance() {
        if (instance == null) {
            synchronized (QupaiHttpFinal.class) {
                if (instance == null) {
                    instance = new QupaiHttpFinal();
                }
            }
        }
        return instance;
    }

    @Override // com.aliyun.vod.common.httpfinal.HttpInterface
    public void initOkHttpFinal() {
        ArrayList arrayList = new ArrayList();
        Headers headersBuild = new Headers.Builder().build();
        OkHttpFinalConfiguration.Builder debug = new OkHttpFinalConfiguration.Builder().setCommenParams(arrayList).setCommenHeaders(headersBuild).setTimeout(35000L).setInterceptors(new ArrayList()).setDebug(true);
        addHttps(debug);
        OkHttpFinal.getInstance().init(debug.build());
    }
}
