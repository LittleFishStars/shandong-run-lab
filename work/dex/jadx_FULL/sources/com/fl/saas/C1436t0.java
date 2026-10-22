package com.fl.saas;

import com.fl.saas.adx.util.LogcatUtil;
import java.io.IOException;
import java.io.OutputStream;
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

/* JADX INFO: renamed from: com.fl.saas.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class C1436t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f30194a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    /* JADX INFO: renamed from: com.fl.saas.t0$b */
    public class b implements Callable {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(C1436t0.this.c());
        }
    }

    public C1436t0(String str, int i) {
        this.b = (String) AbstractC1442w0.a(str);
        this.c = i;
    }

    private String b() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.c), com.ipd.dsp.internal.v0.h.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        X x = new X(b());
        try {
            byte[] bytes = com.ipd.dsp.internal.v0.h.f.getBytes();
            x.a(0L);
            byte[] bArr = new byte[bytes.length];
            x.a(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            LogcatUtil.d("Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (C1448z0 e) {
            LogcatUtil.d("Error reading ping response" + e.getMessage());
            return false;
        } finally {
            x.close();
        }
    }

    private List a() {
        try {
            return ProxySelector.getDefault().select(new URI(b()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean a(String str) {
        return com.ipd.dsp.internal.v0.h.e.equals(str);
    }

    public boolean a(int i, int i2) {
        String str;
        AbstractC1442w0.a(i >= 1);
        AbstractC1442w0.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f30194a.submit(new b()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
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
        LogcatUtil.d(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a()));
        return false;
    }

    public void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(com.ipd.dsp.internal.v0.h.f.getBytes());
    }
}
