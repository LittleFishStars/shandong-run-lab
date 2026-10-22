package com.baidu.mshield.b.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.Handler;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.b.f.e;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, SSLSocketFactory> f26704a = new HashMap();
    public Context b;
    public HttpURLConnection d;
    public String e;
    public String f;
    public String g;
    public byte[] c = new byte[1024];
    public int h = 120000;
    public int i = 120000;
    public boolean j = false;
    public boolean k = false;
    public String l = "";

    public class a implements HostnameVerifier {
        public a(b bVar) {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return "mshield.baidu.com".equals(str);
        }
    }

    /* JADX INFO: renamed from: com.baidu.mshield.b.d.b$b, reason: collision with other inner class name */
    public class C0277b implements X509TrustManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public X509TrustManager f26705a;
        public X509TrustManagerExtensions b = null;
        public String c;

        public C0277b(b bVar, X509TrustManager x509TrustManager, String str) {
            this.f26705a = x509TrustManager;
            this.c = str;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.f26705a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.mshield.b.c.a.b("... checkServerTrusted ...");
            try {
                com.baidu.mshield.b.c.a.b("checkServerTrusted host=" + this.c);
                if (this.b == null) {
                    this.b = new X509TrustManagerExtensions(this.f26705a);
                }
                this.b.checkServerTrusted(x509CertificateArr, str, this.c);
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.b("... checkServerTrusted .error ...");
                com.baidu.mshield.b.c.a.a(th);
                for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                    if ((cause instanceof CertificateExpiredException) || (cause instanceof CertificateNotYetValidException)) {
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    com.baidu.mshield.b.c.a.b("  throw e;");
                    throw th;
                }
                com.baidu.mshield.b.c.a.b("  throw new CertificateException();...");
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f26705a.getAcceptedIssuers();
        }
    }

    public b(Context context, Handler handler) {
        this.b = context.getApplicationContext();
    }

    public final void a(String str, String str2) {
        this.e = str;
        this.f = str2;
        try {
            this.l = new URL(str2).getHost();
        } catch (MalformedURLException e) {
            com.baidu.mshield.b.c.a.a(e);
        }
    }

    public final String b() {
        try {
            Method declaredMethod = F.class.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = F.class.getDeclaredMethod("gzd", Context.class);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(objInvoke, this.b);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public final InputStream c(String str, String str2) throws Throwable {
        if (!com.baidu.mshield.b.a.d.b(this.b)) {
            throw new NetworkErrorException("requestFromServerStream no network");
        }
        HttpURLConnection httpURLConnectionA = a((Map<String, String>) null, str2);
        this.d = httpURLConnectionA;
        if (httpURLConnectionA == null || httpURLConnectionA.getResponseCode() != 200) {
            return null;
        }
        if (str == null) {
            if ("gzip".equalsIgnoreCase(this.d.getContentEncoding())) {
                this.j = true;
            } else {
                this.j = false;
            }
            return this.d.getInputStream();
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.d.getOutputStream());
        bufferedOutputStream.write(com.baidu.mshield.b.a.c.a(str.getBytes()));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        if ("gzip".equalsIgnoreCase(this.d.getContentEncoding())) {
            this.j = true;
        } else {
            this.j = false;
        }
        return this.d.getInputStream();
    }

    public final void a(HttpsURLConnection httpsURLConnection, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.l = str;
            }
            Map<String, SSLSocketFactory> map = f26704a;
            SSLSocketFactory sSLSocketFactory = map.get(this.l);
            if (sSLSocketFactory != null) {
                httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                return;
            }
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length >= 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    sSLContext.init(null, new TrustManager[]{new C0277b(this, (X509TrustManager) trustManager, this.l)}, new SecureRandom());
                    SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                    if (!TextUtils.isEmpty(this.l)) {
                        map.put(this.l, socketFactory);
                        httpsURLConnection.setHostnameVerifier(new a(this));
                    } else {
                        httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    }
                    httpsURLConnection.setSSLSocketFactory(socketFactory);
                    return;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    public final String b(InputStream inputStream) throws Throwable {
        byte[] bArrA;
        if (inputStream == null || (bArrA = a(inputStream)) == null) {
            return null;
        }
        if (this.j) {
            bArrA = com.baidu.mshield.b.a.c.b(bArrA);
        }
        if (bArrA == null) {
            return null;
        }
        return new String(bArrA);
    }

    public String b(String str, String str2) throws Throwable {
        InputStream inputStreamC;
        d.b();
        try {
            try {
                try {
                    a("GET", str);
                    inputStreamC = c(null, str2);
                    if (inputStreamC == null) {
                        if (inputStreamC != null) {
                            try {
                                inputStreamC.close();
                            } catch (Throwable th) {
                                com.baidu.mshield.b.c.a.a(th);
                            }
                        }
                        HttpURLConnection httpURLConnection = this.d;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            this.d = null;
                        }
                        d.a();
                        return null;
                    }
                    try {
                        String strB = b(inputStreamC);
                        try {
                            inputStreamC.close();
                            HttpURLConnection httpURLConnection2 = this.d;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                this.d = null;
                            }
                        } catch (Throwable th2) {
                            com.baidu.mshield.b.c.a.a(th2);
                        }
                        d.a();
                        return strB;
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStreamC != null) {
                            try {
                                inputStreamC.close();
                            } catch (Throwable th4) {
                                com.baidu.mshield.b.c.a.a(th4);
                                throw th;
                            }
                        }
                        HttpURLConnection httpURLConnection3 = this.d;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                            this.d = null;
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamC = null;
                }
            } catch (Throwable th6) {
                com.baidu.mshield.b.c.a.a(th6);
                return "";
            }
            com.baidu.mshield.b.c.a.a(th6);
            return "";
        } finally {
            d.a();
        }
    }

    public final HttpURLConnection a(Map<String, String> map, String str) throws Throwable {
        int i;
        HttpURLConnection httpURLConnection = null;
        String property = null;
        httpURLConnection = null;
        if (this.k) {
            return null;
        }
        if (!TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.f)) {
            if (!this.e.equals("POST") && !this.e.equals("GET")) {
                this.e = "POST";
            }
            URL url = new URL(this.f);
            if (com.baidu.mshield.b.a.d.c(this.b)) {
                i = 80;
            } else {
                property = System.getProperties().getProperty("http.proxyHost");
                String property2 = System.getProperties().getProperty("http.proxyPort");
                if (TextUtils.isEmpty(property2)) {
                    i = -1;
                } else {
                    try {
                        i = Integer.parseInt(property2);
                    } catch (Throwable unused) {
                        i = -1;
                    }
                }
            }
            if (property != null && i > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(property, i)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if ("https".equals(url.getProtocol())) {
                a((HttpsURLConnection) httpURLConnection, str);
            }
            httpURLConnection.setRequestMethod(this.e);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.e)) {
                httpURLConnection.setDoOutput(true);
            }
            this.g = e.a(b());
            com.baidu.mshield.b.c.a.a("sdkhttputilcuid====" + this.g);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.h);
            httpURLConnection.setReadTimeout(this.i);
            httpURLConnection.setRequestProperty("x-device-id", this.g);
            String str2 = com.baidu.mshield.b.a.a.f26699a;
            String strA = com.baidu.mshield.b.a.d.a(this.b);
            if (!TextUtils.isEmpty(str)) {
                httpURLConnection.setRequestProperty("Host", str);
            }
            String str3 = "mshield/" + str2 + WVNativeCallbackUtil.SEPERATER + strA + WVNativeCallbackUtil.SEPERATER + "4.2.6";
            com.baidu.mshield.b.c.a.a("useragent==" + str3);
            httpURLConnection.setRequestProperty("User-Agent", str3);
            httpURLConnection.setRequestProperty(com.google.common.net.b.e, "no-cache");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty(com.google.common.net.b.k, Locale.getDefault().getLanguage());
            httpURLConnection.setRequestProperty("x-sdk-ver", "mshield/4.2.6");
            httpURLConnection.setRequestProperty("x-plu-ver", "x0/4.2.6");
            httpURLConnection.setRequestProperty("x-app-ver", this.b.getPackageName() + WVNativeCallbackUtil.SEPERATER + strA);
            StringBuilder sb = new StringBuilder();
            sb.append("android/");
            sb.append(g.b());
            httpURLConnection.setRequestProperty("x-sys-ver", sb.toString());
            httpURLConnection.setRequestProperty("x-sys-dev", g.a(this.b) + WVNativeCallbackUtil.SEPERATER + g.a());
            httpURLConnection.setRequestProperty("x-api-ver", String.valueOf(Build.VERSION.SDK_INT));
            if (map != null) {
                for (String str4 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str4, map.get(str4));
                }
            }
        }
        return httpURLConnection;
    }

    public String a(String str) throws Throwable {
        return b(str, "");
    }

    public String a(String str, byte[] bArr) throws Throwable {
        return a(str, "", bArr);
    }

    public String a(String str, String str2, byte[] bArr) throws Throwable {
        InputStream inputStreamA;
        d.b();
        try {
            a("POST", str);
            try {
                inputStreamA = a(bArr, str2);
                if (inputStreamA == null) {
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                    HttpURLConnection httpURLConnection = this.d;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        this.d = null;
                    }
                    d.a();
                    return null;
                }
                try {
                    String strB = b(inputStreamA);
                    inputStreamA.close();
                    HttpURLConnection httpURLConnection2 = this.d;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        this.d = null;
                    }
                    d.a();
                    return strB;
                } catch (Throwable th) {
                    th = th;
                    if (inputStreamA != null) {
                        inputStreamA.close();
                    }
                    HttpURLConnection httpURLConnection3 = this.d;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                        this.d = null;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamA = null;
            }
        } catch (Throwable th3) {
            d.a();
            throw th3;
        }
    }

    public final InputStream a(byte[] bArr, String str) throws Throwable {
        if (com.baidu.mshield.b.a.d.b(this.b)) {
            HttpURLConnection httpURLConnectionA = a((Map<String, String>) null, str);
            this.d = httpURLConnectionA;
            if (httpURLConnectionA == null) {
                return null;
            }
            if (bArr == null) {
                if ("gzip".equalsIgnoreCase(httpURLConnectionA.getContentEncoding())) {
                    this.j = true;
                } else {
                    this.j = false;
                }
                return this.d.getInputStream();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.d.getOutputStream());
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            int responseCode = this.d.getResponseCode();
            try {
                com.baidu.mshield.b.c.a.b("httpcode:" + responseCode);
                com.baidu.mshield.b.c.a.b("httpcontent:" + this.d.getContent());
                com.baidu.mshield.b.c.a.b("httpresponse:" + this.d.getResponseMessage());
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
            if ("gzip".equalsIgnoreCase(this.d.getContentEncoding())) {
                this.j = true;
            } else {
                this.j = false;
            }
            if (responseCode == 200) {
                return this.d.getInputStream();
            }
            throw new c(responseCode);
        }
        throw new NetworkErrorException("requestFromServerStreamByte no network");
    }

    public final byte[] a(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(this.c);
            if (i != -1) {
                byteArrayOutputStream.write(this.c, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public String a() {
        return this.g;
    }
}
