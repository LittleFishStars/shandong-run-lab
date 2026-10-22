package com.kc.cw.ad.internal.d;

import com.qihoo.SdkProtected.OSETSDK.Keep;
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
@Keep
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f38971a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    @Keep
    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m f38972a;

        private a(m mVar) {
            this.f38972a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(this.f38972a.b());
        }
    }

    public m(String str, int i) {
        this.b = (String) n.a(str);
        this.c = i;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() throws p {
        j jVar = new j(c());
        try {
            byte[] bytes = com.ipd.dsp.internal.v0.h.f.getBytes();
            jVar.a(0L);
            byte[] bArr = new byte[bytes.length];
            jVar.a(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            com.kc.cw.ad.internal.c.f.c(com.kc.cw.ad.internal.c.f.o, "Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (p e) {
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.o, "Error reading ping response", e);
            return false;
        } finally {
            jVar.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.b, Integer.valueOf(this.c), com.ipd.dsp.internal.v0.h.e);
    }

    public void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(com.ipd.dsp.internal.v0.h.f.getBytes());
    }

    public boolean a(int i, int i2) {
        n.a(i >= 1);
        n.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
                if (((Boolean) this.f38971a.submit(new a()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                    return true;
                }
                i3++;
                i2 *= 2;
            } catch (InterruptedException e) {
                e = e;
                com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.o, "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.o, "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.o, "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
        }
        String str = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a());
        com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.o, str + new p(str));
        return false;
    }

    public boolean a(String str) {
        return com.ipd.dsp.internal.v0.h.e.equals(str);
    }
}
