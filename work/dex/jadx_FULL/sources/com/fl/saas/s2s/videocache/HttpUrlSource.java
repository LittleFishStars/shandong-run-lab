package com.fl.saas.s2s.videocache;

import android.text.TextUtils;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.videocache.headers.EmptyHeadersInjector;
import com.fl.saas.s2s.videocache.headers.HeaderInjector;
import com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage;
import com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorageFactory;
import com.zj.adlib.c49;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class HttpUrlSource implements Source {
    private static final int MAX_REDIRECTS = 5;
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this(str, sourceInfoStorage, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
        SourceInfo sourceInfo = sourceInfoStorage.get(str);
        this.sourceInfo = sourceInfo == null ? new SourceInfo(str, -2147483648L, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x009d  */
    private void fetchContentInfo() throws Throwable {
        InputStream inputStream;
        LogcatUtil.d("Read content info from " + this.sourceInfo.url);
        HttpURLConnection httpURLConnection = null;
        inputStream = null;
        InputStream inputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnectionOpenConnection = openConnection(0L, 10000);
            try {
                long contentLength = getContentLength(httpURLConnectionOpenConnection);
                String contentType = httpURLConnectionOpenConnection.getContentType();
                inputStream2 = httpURLConnectionOpenConnection.getInputStream();
                SourceInfo sourceInfo = new SourceInfo(this.sourceInfo.url, contentLength, contentType);
                this.sourceInfo = sourceInfo;
                this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
                LogcatUtil.d("Source info fetched: " + this.sourceInfo.toString());
                ProxyCacheUtils.close(inputStream2);
                httpURLConnectionOpenConnection.disconnect();
            } catch (IOException e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                httpURLConnection = httpURLConnectionOpenConnection;
                inputStream = inputStream3;
                try {
                    LogcatUtil.e("Error fetching info from " + this.sourceInfo.url + e.toString());
                    ProxyCacheUtils.close(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    ProxyCacheUtils.close(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                InputStream inputStream4 = inputStream2;
                httpURLConnection = httpURLConnectionOpenConnection;
                inputStream = inputStream4;
                ProxyCacheUtils.close(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection openConnection(long j, int i) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.sourceInfo.url;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(headerField);
            LogcatUtil.d(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            injectCustomHeaders(httpURLConnection, headerField);
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + c49.f40900a);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private long readSourceAvailableBytes(HttpURLConnection httpURLConnection, long j, int i) {
        long contentLength = getContentLength(httpURLConnection);
        if (i == 200) {
            return contentLength;
        }
        return i == 206 ? contentLength + j : this.sourceInfo.length;
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public void close() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                LogcatUtil.e("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e.toString());
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String getMime() {
        if (TextUtils.isEmpty(this.sourceInfo.mime)) {
            fetchContentInfo();
        }
        return this.sourceInfo.mime;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public synchronized long length() {
        if (this.sourceInfo.length == -2147483648L) {
            fetchContentInfo();
        }
        return this.sourceInfo.length;
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public void open(long j) throws ProxyCacheException {
        try {
            HttpURLConnection httpURLConnectionOpenConnection = openConnection(j, -1);
            this.connection = httpURLConnectionOpenConnection;
            String contentType = httpURLConnectionOpenConnection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.connection;
            SourceInfo sourceInfo = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo;
            this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j, e);
        }
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.inputStream;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e2);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + "}";
    }
}
