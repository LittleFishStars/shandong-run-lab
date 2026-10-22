package com.ipd.dsp.internal.c2;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HostnameVerifier f38226a = new a();

    public class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public static SSLSocketFactory a(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr) throws Exception {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerArr, trustManagerArr, new SecureRandom());
        return sSLContext.getSocketFactory();
    }

    public static SSLSocketFactory a() throws Exception {
        return a(null, null);
    }
}
