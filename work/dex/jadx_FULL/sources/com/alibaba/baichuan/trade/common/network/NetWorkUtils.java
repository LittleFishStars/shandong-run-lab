package com.alibaba.baichuan.trade.common.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetWorkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24560a = "NetWorkUtils";

    public static class HttpRequestException extends Exception {
        public int statusCode;

        public HttpRequestException(Throwable th) {
            super(th);
        }
    }

    private static HttpResponse a(String str) throws SocketTimeoutException, UnknownHostException, HttpException {
        int responseCode = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        try {
            HttpURLConnection httpURLConnectionC = c(str);
            responseCode = httpURLConnectionC.getResponseCode();
            a(responseCode);
            return new HttpResponse(responseCode, httpURLConnectionC.getInputStream());
        } catch (SocketTimeoutException e) {
            throw e;
        } catch (UnknownHostException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new HttpException(responseCode, e3.getMessage());
        }
    }

    private static InputStream b(String str) throws HttpRequestException {
        int responseCode = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        try {
            HttpURLConnection httpURLConnectionC = c(str);
            responseCode = httpURLConnectionC.getResponseCode();
            a(responseCode);
            return httpURLConnectionC.getInputStream();
        } catch (Exception e) {
            HttpRequestException httpRequestException = new HttpRequestException(e);
            httpRequestException.statusCode = responseCode;
            throw httpRequestException;
        }
    }

    private static HttpURLConnection c(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(60000);
            return httpURLConnection;
        } catch (Exception e) {
            AlibcLogger.e(f24560a, "open connection exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d5, code lost:
    
        return a("unKnownHost", r5, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00de, code lost:
    
        return a(com.alipay.sdk.m.o.b.r0, r5, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpResponse get(HttpRequest httpRequest) throws Exception {
        do {
        } while (httpRequest == null);
        String url = httpRequest.getUrl();
        Map<String, String> params = httpRequest.getParams();
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        String strA = "";
        sb.append(params == null ? "" : "?");
        if (params != null) {
            strA = a(params);
        }
        sb.append(strA);
        String string = sb.toString();
        new HashMap(16);
        HttpResponse httpResponseA = a(string);
        try {
            InputStream inputStream = httpResponseA.getInputStream();
            int statusCode = httpResponseA.getStatusCode();
            if (statusCode < 200 || statusCode > 299) {
                throw new IOException();
            }
            return new HttpResponse(statusCode, inputStream);
        } catch (IOException e) {
            e = e;
            if (httpResponseA == null) {
                throw new HttpException(AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE, "no connection");
            }
            int statusCode2 = httpResponseA.getStatusCode();
            if (TextUtils.isEmpty(null)) {
                return a("network", httpRequest, e);
            }
            if (statusCode2 == 401 || statusCode2 == 403) {
                return a("auth", httpRequest, new HttpException(statusCode2, e.getMessage(), httpResponseA));
            }
            if (statusCode2 >= 400 && statusCode2 <= 499) {
                throw new HttpException(statusCode2, "client error");
            }
            if (statusCode2 < 500 || statusCode2 > 599) {
                throw new HttpException(statusCode2, "server error");
            }
            if (httpRequest.isShouldRetryServerError()) {
                return a("server", httpRequest, new HttpException(statusCode2, e.getMessage(), httpResponseA));
            }
            throw new HttpException(statusCode2, "server error");
        }
    }

    public static String getNetWorkType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 1) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            if (activeNetworkInfo.getType() == 0 && 13 == activeNetworkInfo.getSubtype()) {
                return NetworkUtil.NETWORK_TYPE_4G;
            }
        }
        return "";
    }

    public static boolean isNetWorkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            AlibcLogger.e(f24560a, "get network info exception: " + th.getMessage());
        }
        return false;
    }

    public static boolean isNetWorkOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasCapability(16);
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    public static String post(String str, Map<String, String> map) throws Exception {
        try {
            return streamToString(b(str), "UTF-8");
        } catch (Exception e) {
            if (e instanceof HttpRequestException) {
                throw e;
            }
            throw new HttpRequestException(e);
        }
    }

    public static String streamToString(InputStream inputStream, String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            String str2 = new String(byteArrayOutputStream.toByteArray(), str);
            try {
                inputStream.close();
            } catch (IOException e) {
                AlibcLogger.e(f24560a, "close input stream exception: " + e.getMessage());
            }
            return str2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    AlibcLogger.e(f24560a, "close input stream exception: " + e2.getMessage());
                }
            }
            throw th;
        }
    }

    private static HttpResponse a(String str, HttpRequest httpRequest, Exception exc) throws HttpException {
        try {
            return httpRequest.getRetryPolicy().retry(str, httpRequest, exc);
        } catch (HttpException e) {
            AlibcLogger.e(f24560a, "type=" + str + ", statusCode=" + e.getStatusCode() + ", msg=" + e.getMessage());
            throw e;
        }
    }

    private static void a(int i) {
        if (i == 200) {
            return;
        }
        throw new RuntimeException("http request exception, response code: " + i);
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(30);
        if (map != null) {
            boolean z = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    try {
                        sb.append("&");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    z = true;
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static String get(String str, Map<String, String> map) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String strA = "";
            sb.append(map == null ? "" : "?");
            if (map != null) {
                strA = a(map);
            }
            sb.append(strA);
            String string = sb.toString();
            new HashMap(16);
            return streamToString(b(string), "UTF-8");
        } catch (Exception e) {
            if (e instanceof HttpRequestException) {
                throw e;
            }
            throw new HttpRequestException(e);
        }
    }
}
