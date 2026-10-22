package com.fl.saas;

import android.accounts.NetworkErrorException;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.zj.adlib.c49;
import com.zj.adlib.ze1;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class Y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f30097a;
    private List b;

    public class a implements X509TrustManager {
        public a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #1 {all -> 0x00b2, blocks: (B:3:0x000b, B:5:0x0011, B:8:0x0019, B:10:0x0030, B:12:0x003b, B:13:0x0047, B:15:0x004d, B:16:0x0051, B:17:0x0057, B:18:0x0064, B:20:0x006c, B:21:0x007b, B:22:0x009a, B:24:0x00a0, B:32:0x00b7, B:39:0x00d0), top: B:47:0x000b, inners: #4, #3 }] */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void c(String str, T t) {
        F0 f0;
        Exception httpRetryException;
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(10);
        HttpURLConnection httpURLConnectionA = null;
        try {
            try {
                if (!TextUtils.isEmpty(str) && !a(str)) {
                    httpURLConnectionA = a(Uri.parse(str), 0L, atomicInteger);
                    httpURLConnectionA.setRequestMethod("GET");
                    if (httpURLConnectionA.getResponseCode() == 200) {
                        StringBuffer stringBuffer = new StringBuffer();
                        InputStream inputStream = httpURLConnectionA.getInputStream();
                        if (inputStream != null) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    stringBuffer.append(line);
                                }
                            }
                            bufferedReader.close();
                            inputStream.close();
                        }
                        new F0(t).b(stringBuffer.toString());
                    } else if (httpURLConnectionA.getResponseCode() == 302) {
                        new F0(t).a(httpURLConnectionA.getHeaderField("Location"));
                    } else {
                        f0 = new F0(t);
                        httpRetryException = new NetworkErrorException("response err code:" + httpURLConnectionA.getResponseCode());
                        f0.a(httpRetryException);
                    }
                } else if (t != null) {
                    f0 = new F0(t);
                    httpRetryException = new HttpRetryException("url is fail", 20408);
                    f0.a(httpRetryException);
                }
                if (httpURLConnectionA == null) {
                    return;
                }
            } catch (IOException e) {
                e = e;
                if (t != null) {
                    new F0(t).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                if (t != null) {
                    new F0(t).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e3) {
                if (t != null) {
                    new F0(t).a(new Exception(e3.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnectionA.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    public boolean a(String str) {
        if (this.f30097a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.f30097a) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map b();

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            List list = this.b;
            if (list != null && !list.isEmpty()) {
                for (String str2 : this.b) {
                    if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                        return false;
                    }
                }
                return true;
            }
            List list2 = this.f30097a;
            if (list2 != null && !list2.isEmpty()) {
                for (String str3 : this.f30097a) {
                    if (!TextUtils.isEmpty(str3) && str.contains(str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x00f5 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x001b, B:9:0x0022, B:11:0x002c, B:12:0x0038, B:14:0x003e, B:15:0x0054, B:17:0x0069, B:19:0x0074, B:20:0x0080, B:22:0x0086, B:23:0x008a, B:24:0x0090, B:25:0x009d, B:27:0x00a5, B:28:0x00b4, B:6:0x0015, B:34:0x00dc, B:41:0x00f5), top: B:49:0x0001, inners: #4, #3 }] */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void b(String str, T t) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (b() != null && !b().isEmpty()) {
                    for (Map.Entry entry : b().entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.setReadTimeout(2500);
                if (httpURLConnection.getResponseCode() == 200) {
                    StringBuffer stringBuffer = new StringBuffer();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                stringBuffer.append(line);
                            }
                        }
                        bufferedReader.close();
                        inputStream.close();
                    }
                    new F0(t).b(stringBuffer.toString());
                } else if (httpURLConnection.getResponseCode() == 302) {
                    new F0(t).a(httpURLConnection.getHeaderField("Location"));
                } else {
                    new F0(t).a((Exception) new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                }
            } catch (IOException e) {
                e = e;
                if (t != null) {
                    new F0(t).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                if (t != null) {
                    new F0(t).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e3) {
                if (t != null) {
                    new F0(t).a(new Exception(e3.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public SSLContext a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{new a()}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, S s) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (b() != null && !b().isEmpty()) {
                    for (Map.Entry entry : b().entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.setReadTimeout(2500);
                if (httpURLConnection.getResponseCode() != 200) {
                    new F0(s).a((Exception) new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                        }
                        bufferedInputStream.close();
                        inputStream.close();
                    }
                    new F0(s).b(byteArrayOutputStream.toByteArray());
                }
            } catch (Exception e) {
                if (s != null) {
                    new F0(s).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e2) {
                if (s != null) {
                    new F0(s).a(new Exception(e2.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public void a(final String str, final S s) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.d7a
            @Override // java.lang.Runnable
            public final void run() {
                this.f15933a.b(str, s);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x0146 A[Catch: all -> 0x0125, TRY_LEAVE, TryCatch #1 {all -> 0x0125, blocks: (B:3:0x0008, B:5:0x0015, B:9:0x0025, B:11:0x002b, B:12:0x0033, B:14:0x0039, B:15:0x004f, B:17:0x006a, B:19:0x0074, B:20:0x0080, B:22:0x0086, B:23:0x009c, B:25:0x00d0, B:27:0x00db, B:28:0x00e5, B:30:0x00eb, B:31:0x00ef, B:32:0x00f5, B:33:0x0102, B:6:0x001c, B:39:0x012a, B:45:0x0141, B:47:0x0146), top: B:54:0x0008, inners: #4, #3 }] */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void b(String str, Map map, String str2, T t) {
        LogcatUtil.d("requestAdx:doPost");
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection.setRequestProperty(SubscribeResouceItemModel.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("Connection", "close");
                httpURLConnection.setRequestProperty("Content-Type", ze1.g);
                if (b() != null && !b().isEmpty()) {
                    for (Map.Entry entry2 : b().entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.setReadTimeout(2500);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str2);
                bufferedWriter.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    StringBuffer stringBuffer = new StringBuffer();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                stringBuffer.append(line);
                            }
                        }
                        bufferedReader.close();
                        inputStream.close();
                    }
                    new F0(t).b(stringBuffer.toString());
                } else {
                    new F0(t).a((Exception) new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                if (t != null) {
                    new F0(t).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                e.printStackTrace();
                if (t != null) {
                    new F0(t).a(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e3) {
                if (t != null) {
                    new F0(t).a(new Exception(e3.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public void a(final String str, final T t) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.g7a
            @Override // java.lang.Runnable
            public final void run() {
                this.f16716a.c(str, t);
            }
        });
    }

    public void a(boolean z, final String str, final T t) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.f7a
            @Override // java.lang.Runnable
            public final void run() {
                this.f16484a.b(str, t);
            }
        });
    }

    public void b(List list) {
        this.b = list;
    }

    public void a(String str, String str2, T t) {
        a(str, null, str2, t);
    }

    public void a(final String str, final Map map, final String str2, final T t) {
        c1.a().b(new Runnable() { // from class: com.zj.adlib.e7a
            @Override // java.lang.Runnable
            public final void run() {
                this.f16225a.b(str, map, str2, t);
            }
        });
    }

    public HttpURLConnection a(Uri uri, long j, AtomicInteger atomicInteger) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        URL url = new URL(uri.toString());
        if ("https".equals(uri.getScheme())) {
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SSLContext sSLContextA = a();
            if (sSLContextA != null) {
                httpURLConnection = httpsURLConnection;
                httpsURLConnection.setSSLSocketFactory(sSLContextA.getSocketFactory());
                httpURLConnection = httpsURLConnection;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection = httpsURLConnection;
        if (b() != null && !b().isEmpty()) {
            for (Map.Entry entry : b().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!TextUtils.isEmpty(DeviceUtil.getUserAgent())) {
            httpURLConnection.setRequestProperty("User-Agent", DeviceUtil.getUserAgent());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Accept-Encoding", HlsPlaylistParser.V);
        httpURLConnection.setConnectTimeout(2500);
        httpURLConnection.setReadTimeout(2500);
        if (j > 0) {
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + c49.f40900a);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 307) {
            switch (responseCode) {
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return httpURLConnection;
            }
        }
        if (atomicInteger.decrementAndGet() < 0) {
            throw new HttpRetryException("redirects too many times", responseCode);
        }
        LogcatUtil.d("FLSDK-HttpUtils", "statusCode 302 :" + atomicInteger.get());
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        if (TextUtils.isEmpty(headerField) || b(headerField)) {
            throw new HttpRetryException("redirectUrl is null", responseCode);
        }
        return a(Uri.parse(headerField), j, atomicInteger);
    }

    public void a(List list) {
        this.f30097a = list;
    }
}
