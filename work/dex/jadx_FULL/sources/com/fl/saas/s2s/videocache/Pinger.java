package com.fl.saas.s2s.videocache;

import com.fl.saas.config.utils.LogcatUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class Pinger {
    private static final String PING_REQUEST = "ping";
    private static final String PING_RESPONSE = "ping ok";
    private final String host;
    private final ExecutorService pingExecutor = Executors.newSingleThreadExecutor();
    private final int port;

    public class PingCallable implements Callable<Boolean> {
        private PingCallable() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(Pinger.this.pingServer());
        }
    }

    public Pinger(String str, int i) {
        this.host = (String) Preconditions.checkNotNull(str);
        this.port = i;
    }

    private List<Proxy> getDefaultProxies() {
        try {
            return ProxySelector.getDefault().select(new URI(getPingUrl()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    private String getPingUrl() {
        return String.format(Locale.US, "http://%s:%d/%s", this.host, Integer.valueOf(this.port), "ping");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pingServer() {
        HttpUrlSource httpUrlSource = new HttpUrlSource(getPingUrl());
        try {
            byte[] bytes = "ping ok".getBytes();
            httpUrlSource.open(0L);
            byte[] bArr = new byte[bytes.length];
            httpUrlSource.read(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            LogcatUtil.d("Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (ProxyCacheException e) {
            LogcatUtil.d("Error reading ping response" + e.getMessage());
            return false;
        } finally {
            httpUrlSource.close();
        }
    }

    public boolean isPingRequest(String str) {
        return "ping".equals(str);
    }

    public boolean ping(int i, int i2) {
        String str;
        Preconditions.checkArgument(i >= 1);
        Preconditions.checkArgument(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.pingExecutor.submit(new PingCallable()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e) {
                e = e;
                str = "Error pinging server due to unexpected error" + e.getMessage();
                LogcatUtil.d(str);
            } catch (ExecutionException e2) {
                e = e2;
                str = "Error pinging server due to unexpected error" + e.getMessage();
                LogcatUtil.d(str);
            } catch (TimeoutException unused) {
                str = "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ";
                LogcatUtil.d(str);
            }
        }
        LogcatUtil.d(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), getDefaultProxies()));
        return false;
    }

    public void responseToPing(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
