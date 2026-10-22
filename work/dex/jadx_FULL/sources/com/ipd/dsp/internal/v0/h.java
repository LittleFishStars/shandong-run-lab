package com.ipd.dsp.internal.v0;

import com.ipd.dsp.Dsp;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h {
    public static final String d = "PingUtil";
    public static final String e = "ping";
    public static final String f = "ping ok";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f38566a = Executors.newSingleThreadExecutor();
    public final String b;
    public final int c;

    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(h.this.c());
        }
    }

    public h(String str, int i) {
        this.b = (String) i.a(str);
        this.c = i;
    }

    public final String b() {
        return String.format(Locale.getDefault(), "http://%s:%d/%s", this.b, Integer.valueOf(this.c), e);
    }

    public final boolean c() throws k {
        e eVar = new e(b());
        try {
            byte[] bytes = f.getBytes();
            eVar.a(0L);
            byte[] bArr = new byte[bytes.length];
            eVar.read(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.d(d, "Ping response: '" + new String(bArr) + "', pinged? " + zEquals);
            }
            return zEquals;
        } catch (k e2) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.b(d, "Error reading ping response", e2);
            }
            return false;
        } finally {
            eVar.close();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069 A[SYNTHETIC] */
    public boolean a(int i, int i2) {
        i.a(i >= 1);
        i.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f38566a.submit(new b()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e2) {
                e = e2;
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.b(d, "Error pinging server due to unexpected error", e);
                }
            } catch (ExecutionException e3) {
                e = e3;
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.b(d, "Error pinging server due to unexpected error", e);
                }
            } catch (TimeoutException unused) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.f(d, "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
                }
            }
        }
        String str = String.format(Locale.getDefault(), "Error pinging server (attempts: %d, max timeout: %d). Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a());
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.b(d, "ping error", new k(str));
        }
        return false;
    }

    public final List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(b()));
        } catch (URISyntaxException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public boolean a(String str) {
        return e.equals(str);
    }

    public void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(f.getBytes());
    }
}
