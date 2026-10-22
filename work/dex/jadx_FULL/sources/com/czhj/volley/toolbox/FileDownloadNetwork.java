package com.czhj.volley.toolbox;

import android.os.SystemClock;
import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Cache;
import com.czhj.volley.Header;
import com.czhj.volley.Network;
import com.czhj.volley.NetworkError;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.NoConnectionError;
import com.czhj.volley.Request;
import com.czhj.volley.RetryPolicy;
import com.czhj.volley.ServerError;
import com.czhj.volley.TimeoutError;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FileDownloadNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29479a = 3000;
    private static final int b = 4096;
    private final BaseHttpStack c;
    protected final ByteArrayPool mPool;

    public FileDownloadNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public FileDownloadNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.c = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    private static List<Header> a(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<Header> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = entry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header : entry.allResponseHeaders) {
                    if (!treeSet.contains(header.getName())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    private Map<String, String> a(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = entry.etag;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = entry.lastModified;
        if (j > 0) {
            map.put("If-Modified-Since", HttpHeaderParser.a(j));
        }
        return map;
    }

    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (DEBUG || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private byte[] a(InputStream inputStream, int i) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i);
        try {
            if (inputStream == null) {
                throw new ServerError();
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int i2 = inputStream.read(buf);
                if (i2 == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, i2);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    public static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [RetryCount %s]  [timeout=%s]", str, Integer.valueOf(retryPolicy.getCurrentRetryCount()), Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [RetryCount %s] [timeout=%s]", str, Integer.valueOf(retryPolicy.getCurrentRetryCount()), Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    public static Map<String, String> convertHeaders(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < list.size(); i++) {
            Header header = list.get(i);
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0182 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:50:0x0111  */
    @Override // com.czhj.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        List<Header> list;
        int statusCode;
        VolleyError networkError;
        String str;
        NetworkResponse networkResponse;
        AuthFailureError authFailureError;
        List<Header> list2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            VolleyLog.d("download start %s", request.getUrl());
            List<Header> listEmptyList = Collections.emptyList();
            HttpResponse httpResponseExecuteRequest = null;
            byte[] bArr = null;
            byte[] bArrHandleRawResponse = null;
            try {
                try {
                    httpResponseExecuteRequest = this.c.executeRequest(request, a(request.getCacheEntry()));
                    try {
                        int statusCode2 = httpResponseExecuteRequest.getStatusCode();
                        VolleyLog.d("download getStatus %s StatusCode: %s", request.getUrl(), Integer.valueOf(statusCode2));
                        List<Header> headers = httpResponseExecuteRequest.getHeaders();
                        if (statusCode2 == 304) {
                            Cache.Entry cacheEntry = request.getCacheEntry();
                            return cacheEntry == null ? new NetworkResponse(304, (byte[]) null, true, SystemClock.elapsedRealtime() - jElapsedRealtime, headers) : new NetworkResponse(304, cacheEntry.data, true, SystemClock.elapsedRealtime() - jElapsedRealtime, a(headers, cacheEntry));
                        }
                        try {
                            if (httpResponseExecuteRequest.getContent() != null) {
                                try {
                                    if (request instanceof FileDownloadRequest) {
                                        bArrHandleRawResponse = ((FileDownloadRequest) request).handleRawResponse(httpResponseExecuteRequest);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    list = headers;
                                    httpResponseExecuteRequest = httpResponseExecuteRequest;
                                    if (httpResponseExecuteRequest != null) {
                                        throw new NoConnectionError(e);
                                    }
                                    statusCode = httpResponseExecuteRequest.getStatusCode();
                                    VolleyLog.e("%s Unexpected response code %d for %s", e.getMessage(), Integer.valueOf(statusCode), request.getUrl());
                                    if (bArr != null) {
                                        networkResponse = new NetworkResponse(statusCode, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, list);
                                        if (statusCode != 401) {
                                        }
                                        authFailureError = new AuthFailureError(networkResponse);
                                        attemptRetryOnException("auth", request, authFailureError);
                                    } else {
                                        networkError = new NetworkError(e);
                                        str = "network";
                                    }
                                    attemptRetryOnException(str, request, networkError);
                                }
                            } else {
                                bArrHandleRawResponse = new byte[0];
                            }
                            byte[] bArr2 = bArrHandleRawResponse;
                            try {
                                list2 = headers;
                                try {
                                    a(SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArr2, statusCode2);
                                    if (statusCode2 < 200 || statusCode2 > 299) {
                                        throw new IOException();
                                    }
                                    return new NetworkResponse(statusCode2, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, list2);
                                } catch (IOException e2) {
                                    e = e2;
                                    bArr = bArr2;
                                    list = list2;
                                    if (httpResponseExecuteRequest != null) {
                                        throw new NoConnectionError(e);
                                    }
                                    statusCode = httpResponseExecuteRequest.getStatusCode();
                                    VolleyLog.e("%s Unexpected response code %d for %s", e.getMessage(), Integer.valueOf(statusCode), request.getUrl());
                                    if (bArr != null) {
                                        networkResponse = new NetworkResponse(statusCode, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, list);
                                        if (statusCode != 401 || statusCode == 403) {
                                            authFailureError = new AuthFailureError(networkResponse);
                                        } else if (statusCode == 301 || statusCode == 302) {
                                            authFailureError = new AuthFailureError(networkResponse);
                                        } else {
                                            if (statusCode >= 400 && statusCode <= 499) {
                                                throw new ServerError(networkResponse);
                                            }
                                            if (statusCode < 500 || statusCode > 599) {
                                                throw new ServerError(networkResponse);
                                            }
                                            if (!request.shouldRetryServerErrors()) {
                                                throw new ServerError(networkResponse);
                                            }
                                            networkError = new ServerError(networkResponse);
                                            str = "server";
                                        }
                                        attemptRetryOnException("auth", request, authFailureError);
                                    } else {
                                        networkError = new NetworkError(e);
                                        str = "network";
                                    }
                                    attemptRetryOnException(str, request, networkError);
                                }
                            } catch (IOException e3) {
                                e = e3;
                                list2 = headers;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            list2 = headers;
                            bArr = null;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        list = listEmptyList;
                    }
                } catch (IOException e6) {
                    e = e6;
                    list = listEmptyList;
                    bArr = null;
                }
            } catch (MalformedURLException e7) {
                throw new RuntimeException("Bad URL " + request.getUrl(), e7);
            } catch (SocketTimeoutException unused) {
                attemptRetryOnException("socket", request, new TimeoutError());
            }
        }
    }
}
