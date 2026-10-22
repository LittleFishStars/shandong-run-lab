package com.alibaba.ariver.resource.api.content;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkStream extends InputStream {
    public static final String TAG = "AriverRes:NetworkStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24424a;
    private InputStream b;
    private HttpURLConnection c;

    @Nullable
    private Listener d;
    private int e;
    private boolean f;
    private Map<String, String> g;

    public interface Listener {
        void onInputClose(NetworkStream networkStream);

        void onInputException();

        void onInputOpen(NetworkStream networkStream);

        void onResourceError(NetworkStream networkStream, int i);
    }

    public NetworkStream(String str, @Nullable Listener listener) {
        this(str, false, listener);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f  */
    private InputStream a() {
        InputStream bufferedInputStream;
        InputStream resStream;
        InputStream inputStream = null;
        try {
            RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
            if (rVTransportService != null) {
                RVHttpRequest.Builder builderUseCache = RVHttpRequest.newBuilder().url(this.f24424a).setPackageRequest(this.f).useCache(true);
                Map<String, String> map = this.g;
                if (map != null) {
                    builderUseCache.headers(map);
                }
                RVHttpResponse rVHttpResponseHttpRequest = rVTransportService.httpRequest(builderUseCache.build());
                if (rVHttpResponseHttpRequest != null) {
                    resStream = rVHttpResponseHttpRequest.getResStream();
                    this.e = rVHttpResponseHttpRequest.getStatusCode();
                    bufferedInputStream = resStream;
                } else {
                    bufferedInputStream = null;
                    resStream = null;
                }
            } else {
                bufferedInputStream = null;
                resStream = null;
            }
            if (resStream == null) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f24424a).openConnection();
                    this.c = httpURLConnection;
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    this.e = this.c.getResponseCode();
                    bufferedInputStream = new BufferedInputStream(inputStream2);
                } catch (Exception e) {
                    InputStream inputStream3 = bufferedInputStream;
                    e = e;
                    inputStream = inputStream3;
                    RVLogger.e(TAG, this.f24424a + " failed to init stream ", e);
                    Listener listener = this.d;
                    if (listener != null) {
                        listener.onInputException();
                    }
                    return inputStream;
                }
            }
            RVLogger.d(TAG, "initStream " + this.f24424a + " get statusCode: " + this.e);
            int i = this.e;
            if (i >= 400) {
                Listener listener2 = this.d;
                if (listener2 != null) {
                    listener2.onResourceError(this, i);
                }
                return null;
            }
            Listener listener3 = this.d;
            if (listener3 == null) {
                return bufferedInputStream;
            }
            listener3.onInputOpen(this);
            return bufferedInputStream;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream inputStream = this.b;
        return inputStream != null ? inputStream.available() : super.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        } else {
            super.close();
        }
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.c = null;
        Listener listener = this.d;
        if (listener != null) {
            listener.onInputClose(this);
        }
    }

    public InputStream getRealStream() {
        return this.b;
    }

    public int getStatusCode() {
        return this.e;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.mark(i);
        } else {
            super.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.b;
        return inputStream != null ? inputStream.markSupported() : super.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            try {
                return inputStream.read();
            } catch (Throwable th) {
                RVLogger.e(TAG, "read stream in " + this.f24424a + " exception!", th);
            }
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.reset();
        } else {
            super.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        InputStream inputStream = this.b;
        return inputStream != null ? inputStream.skip(j) : super.skip(j);
    }

    public NetworkStream(String str, boolean z, @Nullable Listener listener) {
        this.f24424a = str;
        this.d = listener;
        this.f = z;
        this.b = a();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            InputStream inputStream = this.b;
            if (inputStream != null) {
                return inputStream.read(bArr, i, i2);
            }
            return super.read(bArr, i, i2);
        } catch (Throwable unused) {
            RVLogger.e(TAG, "read stream error!");
            return -1;
        }
    }

    public NetworkStream(String str, boolean z, @Nullable Listener listener, Map map) {
        this.f24424a = str;
        this.d = listener;
        this.f = z;
        this.g = map;
        this.b = a();
    }
}
