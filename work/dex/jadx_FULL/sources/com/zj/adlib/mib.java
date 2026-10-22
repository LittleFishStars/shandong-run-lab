package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.l0;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class mib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static mib f43311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ThreadPoolExecutor f18226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f18227a;

    public mib() {
        try {
            this.f18227a = new Handler(Looper.getMainLooper());
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 3) + 1;
            int i = iAvailableProcessors < 15 ? 15 : iAvailableProcessors;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 6L, TimeUnit.SECONDS, new LinkedBlockingDeque());
            f18226a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable unused) {
        }
    }

    public static mib a() {
        if (f43311a == null) {
            synchronized (mib.class) {
                if (f43311a == null) {
                    f43311a = new mib();
                }
            }
        }
        return f43311a;
    }

    public static void e(String str, wtb wtbVar, l0 l0Var) {
        HashMap map = new HashMap();
        if (wtbVar == null || TextUtils.isEmpty(wtb.i)) {
            m3b.c().getClass();
            map.put("User-Agent", m3b.g());
        } else {
            map.put("User-Agent", wtb.i);
        }
        if (wtbVar != null && !TextUtils.isEmpty(wtbVar.f20557e)) {
            map.put("Referer", wtbVar.f20557e);
        }
        try {
            HashMap map2 = wtbVar.f20547a;
            if (map2 != null) {
                map.putAll(map2);
            }
        } catch (Throwable unused) {
        }
        i(str, map, l0Var);
    }

    public static void f(String str, wtb wtbVar, String str2, amb ambVar) {
        HashMap map = new HashMap();
        if (wtbVar == null || TextUtils.isEmpty(wtb.i)) {
            m3b.c().getClass();
            map.put("User-Agent", m3b.g());
        } else {
            map.put("User-Agent", wtb.i);
        }
        if (wtbVar != null && !TextUtils.isEmpty(wtbVar.f20557e)) {
            map.put("Referer", wtbVar.f20557e);
        }
        try {
            HashMap map2 = wtbVar.f20547a;
            if (map2 != null) {
                map.putAll(map2);
            }
        } catch (Throwable unused) {
        }
        a().g("POST", str, map, str2, new ngb(ambVar, str));
    }

    public static void i(String str, HashMap map, l0 l0Var) {
        String strReplaceAll = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                strReplaceAll = str.replaceAll("__TS__", (jCurrentTimeMillis / 1000) + "").replaceAll("__TMS__", jCurrentTimeMillis + "");
            }
        } catch (Throwable unused) {
        }
        a().g("GET", strReplaceAll, map, "", l0Var);
    }

    public final void g(final String str, final String str2, final HashMap map, final String str3, final l0 l0Var) {
        f18226a.submit(new Runnable() { // from class: com.zj.adlib.gib
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f16781a.h(str, str2, map, str3, l0Var);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x01f4 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void h(String str, String str2, Map map, String str3, final l0 l0Var) throws IOException {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str2)) {
            if (l0Var != null) {
                l0Var.a(-1, " url 为空");
                return;
            }
            return;
        }
        if (l0Var != null) {
            l0Var.f22702a = str2;
        }
        if (hrb.c(str2)) {
            return;
        }
        if (str.equals("GET") && !TextUtils.isEmpty(str3)) {
            str2 = str2 + "?" + str3;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            TrustManager[] trustManagerArr = {new abb()};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new beb());
        } catch (Throwable th) {
            th.getMessage();
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setUseCaches(false);
                int i = str.equals("GET") ? 1000 : 5000;
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
                if (str.equals("POST")) {
                    httpURLConnection.setDoOutput(true);
                }
                if (str.equals("POST") && !TextUtils.isEmpty(str3)) {
                    httpURLConnection.setDoOutput(true);
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.writeBytes(str3);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.connect();
                final int responseCode = httpURLConnection.getResponseCode();
                while (responseCode >= 300 && responseCode < 400) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (hrb.c(headerField)) {
                        if (l0Var != null) {
                            l0Var.a(responseCode, "重定向过滤" + headerField);
                        }
                    }
                    httpURLConnection.disconnect();
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                    if (map != null) {
                        try {
                            for (Map.Entry entry2 : map.entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) entry2.getKey()) && !TextUtils.isEmpty((CharSequence) entry2.getValue())) {
                                    httpURLConnection2.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
                                }
                            }
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            if (l0Var != null) {
                                try {
                                    this.f18227a.post(new Runnable() { // from class: com.zj.adlib.lib
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            l0Var.a(-1, th.getMessage());
                                        }
                                    });
                                } finally {
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                }
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                        }
                    }
                    httpURLConnection2.setConnectTimeout(i);
                    httpURLConnection2.setReadTimeout(i);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.connect();
                    httpURLConnection = httpURLConnection2;
                    responseCode = httpURLConnection2.getResponseCode();
                }
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i2 = inputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            } else {
                                byteArrayOutputStream2.write(bArr, 0, i2);
                            }
                        }
                        final String string = byteArrayOutputStream2.toString();
                        if (l0Var != null) {
                            this.f18227a.post(new Runnable() { // from class: com.zj.adlib.jib
                                @Override // java.lang.Runnable
                                public final void run() {
                                    l0Var.b(string);
                                }
                            });
                        }
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (l0Var != null) {
                            this.f18227a.post(new Runnable() { // from class: com.zj.adlib.lib
                                @Override // java.lang.Runnable
                                public final void run() {
                                    l0Var.a(-1, th.getMessage());
                                }
                            });
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                } else if (l0Var != null) {
                    this.f18227a.post(new Runnable() { // from class: com.zj.adlib.kib
                        @Override // java.lang.Runnable
                        public final void run() {
                            l0Var.a(responseCode, "");
                        }
                    });
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
        }
    }
}
