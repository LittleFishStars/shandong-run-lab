package com.fl.saas.s2s.videocache;

import android.text.TextUtils;
import com.fl.saas.s2s.videocache.file.FileCache;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class HttpProxyCache extends ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final FileCache cache;
    private CacheListener listener;
    private final HttpUrlSource source;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.cache = fileCache;
        this.source = httpUrlSource;
    }

    private String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean isUseCache(GetRequest getRequest) {
        long length = this.source.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && getRequest.partial && ((float) getRequest.rangeOffset) > ((float) this.cache.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String newResponseHeaders(GetRequest getRequest) {
        String mime = this.source.getMime();
        boolean z = !TextUtils.isEmpty(mime);
        long jAvailable = this.cache.isCompleted() ? this.cache.available() : this.source.length();
        boolean z2 = jAvailable >= 0;
        boolean z3 = getRequest.partial;
        long j = z3 ? jAvailable - getRequest.rangeOffset : jAvailable;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(getRequest.partial ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? format("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(getRequest.rangeOffset), Long.valueOf(jAvailable - 1), Long.valueOf(jAvailable)) : "");
        sb.append(z ? format("Content-Type: %s\n", mime) : "");
        sb.append("\n");
        return sb.toString();
    }

    private void responseWithCache(OutputStream outputStream, long j) throws IOException, ProxyCacheException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = read(bArr, j, 8192);
            if (i == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, i);
                j += (long) i;
            }
        }
    }

    private void responseWithoutCache(OutputStream outputStream, long j) {
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.source);
        try {
            httpUrlSource.open((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = httpUrlSource.read(bArr);
                if (i == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, i);
            }
        } finally {
            httpUrlSource.close();
        }
    }

    @Override // com.fl.saas.s2s.videocache.ProxyCache
    public void onCachePercentsAvailableChanged(int i) {
        CacheListener cacheListener = this.listener;
        if (cacheListener != null) {
            cacheListener.onCacheAvailable(this.cache.file, this.source.getUrl(), i);
        }
    }

    public void processRequest(GetRequest getRequest, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(newResponseHeaders(getRequest).getBytes("UTF-8"));
        long j = getRequest.rangeOffset;
        if (isUseCache(getRequest)) {
            responseWithCache(bufferedOutputStream, j);
        } else {
            responseWithoutCache(bufferedOutputStream, j);
        }
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listener = cacheListener;
    }
}
