package com.alipay.sdk.m.s;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.l;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25500a = "msp";
    public static final String b = "application/octet-stream;binary/octet-stream";
    public static final CookieManager c = new CookieManager();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25501a;
        public final byte[] b;
        public final Map<String, String> c;

        public a(String str, Map<String, String> map, byte[] bArr) {
            this.f25501a = str;
            this.b = bArr;
            this.c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f25501a, this.c);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.s.b$b, reason: collision with other inner class name */
    public static final class C0207b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f25502a;
        public final String b;
        public final byte[] c;

        public C0207b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f25502a = map;
            this.b = str;
            this.c = bArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01a6 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x01ab A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x01b0 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static C0207b a(Context context, a aVar) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        if (context == null) {
            return null;
        }
        try {
            g.d(com.alipay.sdk.m.n.a.B, "conn config: " + aVar);
            URL url = new URL(aVar.f25501a);
            Proxy proxyB = b(context);
            g.d(com.alipay.sdk.m.n.a.B, "conn proxy: " + proxyB);
            HttpURLConnection httpURLConnection2 = proxyB != null ? (HttpURLConnection) url.openConnection(proxyB) : (HttpURLConnection) url.openConnection();
            try {
                System.setProperty("http.keepAlive", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                }
                CookieManager cookieManager = c;
                if (cookieManager.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection2.setRequestProperty(com.google.common.net.b.p, TextUtils.join(l.b, cookieManager.getCookieStore().getCookies()));
                }
                httpURLConnection2.setConnectTimeout(20000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty("User-Agent", f25500a);
                byte[] bArr = aVar.b;
                if (bArr == null || bArr.length <= 0) {
                    httpURLConnection2.setRequestMethod("GET");
                } else {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Type", b);
                    httpURLConnection2.setRequestProperty(com.google.common.net.b.i, "UTF-8");
                    httpURLConnection2.setRequestProperty("Connection", com.google.common.net.b.t0);
                    httpURLConnection2.setRequestProperty(com.google.common.net.b.t0, "timeout=180, max=100");
                }
                Map<String, String> map = aVar.c;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection2.setDoInput(true);
                if ("POST".equals(httpURLConnection2.getRequestMethod())) {
                    httpURLConnection2.setDoOutput(true);
                }
                if ("POST".equals(httpURLConnection2.getRequestMethod())) {
                    bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        bufferedOutputStream2.write(aVar.b);
                        bufferedOutputStream2.flush();
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream = null;
                        Throwable th2 = th;
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        try {
                            g.a(th);
                            return null;
                        } finally {
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                } else {
                    bufferedOutputStream2 = null;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    byte[] bArrA = a(bufferedInputStream2);
                    Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                    String strJoin = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                    List<String> list = headerFields.get(com.google.common.net.b.D0);
                    if (list != null) {
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            List<HttpCookie> list2 = HttpCookie.parse(it.next());
                            if (list2 != null && !list2.isEmpty()) {
                                c.getCookieStore().add(url.toURI(), list2.get(0));
                            }
                        }
                    }
                    C0207b c0207b = new C0207b(headerFields, strJoin, bArrA);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable unused4) {
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Throwable unused5) {
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    return c0207b;
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    g.a(th);
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
    }

    public static Proxy b(Context context) {
        String strA = a(context);
        if (strA != null && !strA.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            NetworkInfo networkInfoA = com.alipay.sdk.m.a0.b.a(null, context);
            if (networkInfoA != null && networkInfoA.isAvailable()) {
                return networkInfoA.getType() == 1 ? "wifi" : networkInfoA.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
