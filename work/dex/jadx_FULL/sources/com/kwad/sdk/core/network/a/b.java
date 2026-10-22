package com.kwad.sdk.core.network.a;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.by;
import com.zj.adlib.ze1;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z, boolean z2) throws Throwable {
        InputStream inputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        inputStream = null;
        inputStream = null;
        InputStream inputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection2);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setRequestProperty("Accept", ze1.g);
                if (z2) {
                    p.b(httpURLConnection2);
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.code = responseCode;
                cVar.aSW = responseCode;
                StringBuilder sb = new StringBuilder();
                if (z) {
                    inputStream2 = httpURLConnection2.getInputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i));
                    }
                }
                cVar.aSY = sb.toString();
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            } catch (Exception e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                InputStream inputStream4 = inputStream2;
                httpURLConnection = httpURLConnection2;
                inputStream = inputStream4;
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        return cVar;
    }

    private static long c(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null && "content-length".equals(key.toLowerCase())) {
                try {
                    return Long.parseLong(entry.getValue().get(0));
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return -1L;
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String strSubstring;
        if (map2 != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String strEncode = encode(entry.getValue());
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(strEncode);
                sb.append("&");
            }
            strSubstring = sb.substring(0, sb.length() - 1);
        } else {
            strSubstring = null;
        }
        return a(str, map, strSubstring, false);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, boolean z, AdHttpResponseListener adHttpResponseListener) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection);
                AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
                httpURLConnection.setRequestProperty(com.google.common.net.b.k, "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(120000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                if (z) {
                    httpURLConnection.setRequestProperty("Connection", "keep-alive");
                } else {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                p.b(httpURLConnection);
                long jC = c(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[1024];
                    long j2 = 0;
                    if (j > 0) {
                        do {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            j2 += (long) i;
                            AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, jC);
                        } while (j2 <= j);
                    } else if (j < 0) {
                        bufferedOutputStream = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                        do {
                            int i2 = bufferedInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.write(bArr, 0, i2);
                            }
                            j2 += (long) i2;
                        } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, jC));
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.flush();
                        }
                    }
                    AdHttpResponseHelper.notifyResponseEnd(adHttpResponseListener);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    httpURLConnection.disconnect();
                    return true;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return "";
        }
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            return h.c(inputStream);
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z) throws Throwable {
        OutputStream outputStream;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection = null;
        outputStream = null;
        outputStream = null;
        OutputStream outputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection2);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                if (z) {
                    httpURLConnection2.setRequestProperty("Content-Type", ze1.g);
                } else {
                    httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                p.b(httpURLConnection2);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream2 = httpURLConnection2.getOutputStream();
                    outputStream2.write(str2.getBytes());
                    outputStream2.flush();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                cVar.code = responseCode;
                cVar.aSW = responseCode;
                if (responseCode == 200) {
                    cVar.aSY = inputStream2String(httpURLConnection2.getInputStream());
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
            } catch (Exception e) {
                e = e;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection = httpURLConnection2;
                outputStream = outputStream4;
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        return cVar;
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i = cVar.code;
        if (i == 0) {
            i = -1;
        }
        cVar.aSW = i;
        cVar.aSX = exc;
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.aSZ;
            cVar.code = eVar.errorCode;
            cVar.aSY = eVar.msg;
        } else {
            cVar.code = e.aTa.errorCode;
            cVar.aSY = e.aTa.msg + WVNativeCallbackUtil.SEPERATER + by.y(exc);
        }
        if (com.kwad.framework.a.a.pe.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(exc);
        }
    }
}
