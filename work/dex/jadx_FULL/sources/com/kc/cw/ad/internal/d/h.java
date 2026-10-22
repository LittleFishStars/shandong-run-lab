package com.kc.cw.ad.internal.d;

import android.content.Context;
import android.net.Uri;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f38963a;
    private final ExecutorService b;
    private final Map<String, i> c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final com.kc.cw.ad.internal.d.c g;
    private final m h;

    @Keep
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f38964a;
        private com.kc.cw.ad.internal.d.b.c d;
        private com.kc.cw.ad.internal.d.a.a c = new com.kc.cw.ad.internal.d.a.g(536870912);
        private com.kc.cw.ad.internal.d.a.c b = new com.kc.cw.ad.internal.d.a.f();
        private f e = new d();

        public a(Context context) {
            this.d = com.kc.cw.ad.internal.d.b.d.a(context);
            this.f38964a = t.a(context);
        }

        private com.kc.cw.ad.internal.d.c b() {
            return new com.kc.cw.ad.internal.d.c(this.f38964a, this.b, this.c, this.d, this.e);
        }

        public a a(long j) {
            this.c = new com.kc.cw.ad.internal.d.a.g(j);
            return this;
        }

        public h a() {
            return new h(b());
        }
    }

    @Keep
    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f38965a;
        private final Socket b;

        public b(h hVar, Socket socket) {
            this.f38965a = hVar;
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f38965a.a(this.b);
        }
    }

    @Keep
    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f38966a;
        private final CountDownLatch b;

        public c(h hVar, CountDownLatch countDownLatch) {
            this.f38966a = hVar;
            this.b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.countDown();
            this.f38966a.b();
        }
    }

    private h(com.kc.cw.ad.internal.d.c cVar) {
        this.f38963a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.g = (com.kc.cw.ad.internal.d.c) n.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(com.ipd.dsp.internal.v0.q.i));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            k.a(com.ipd.dsp.internal.v0.q.i, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(this, countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new m(com.ipd.dsp.internal.v0.q.i, localPort);
            com.kc.cw.ad.internal.c.f.c(com.kc.cw.ad.internal.c.f.q, "Proxy cache server started. Is it alive? " + a());
        } catch (Exception e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (Exception e) {
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.q, "Error touching file " + file, e);
        }
    }

    private void a(Throwable th) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.q, "HttpProxyCacheServer error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) {
        String str;
        StringBuilder sb;
        try {
            try {
                e eVarA = e.a(socket.getInputStream());
                com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.q, "Request to cache proxy:" + eVarA);
                String strC = q.c(eVarA.f38961a);
                if (this.h.a(strC)) {
                    this.h.a(socket);
                } else {
                    e(strC).a(eVarA, socket);
                }
                b(socket);
                str = com.kc.cw.ad.internal.c.f.q;
                sb = new StringBuilder();
            } catch (p e) {
                e = e;
                a(new p("Error processing request", e));
                b(socket);
                str = com.kc.cw.ad.internal.c.f.q;
                sb = new StringBuilder();
            } catch (SocketException unused) {
                com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.q, "Closing socket… Socket is closed by client.");
                b(socket);
                str = com.kc.cw.ad.internal.c.f.q;
                sb = new StringBuilder();
            } catch (IOException e2) {
                e = e2;
                a(new p("Error processing request", e));
                b(socket);
                str = com.kc.cw.ad.internal.c.f.q;
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(c());
            com.kc.cw.ad.internal.c.f.b(str, sb.toString());
        } catch (Throwable th) {
            b(socket);
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.q, "Opened connections: " + c());
            throw th;
        }
    }

    private boolean a() {
        return this.h.a(3, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.d.accept();
                com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.q, "Accept new socket " + socketAccept);
                this.b.submit(new b(this, socketAccept));
            } catch (Exception e) {
                a(new p("Error during waiting connection", e));
                return;
            }
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private int c() {
        int iA;
        synchronized (this.f38963a) {
            Iterator<i> it = this.c.values().iterator();
            iA = 0;
            while (it.hasNext()) {
                iA += it.next().a();
            }
        }
        return iA;
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", com.ipd.dsp.internal.v0.q.i, Integer.valueOf(this.e), q.b(str));
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.q, "Releasing input stream… Socket is closed by client.");
        } catch (Exception e) {
            a(new p("Error closing socket input stream", e));
        }
    }

    private File d(String str) {
        com.kc.cw.ad.internal.d.c cVar = this.g;
        return new File(cVar.f38960a, cVar.b.a(str));
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (Exception e) {
            com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.q, "Failed to close socket on proxy side: {}. It seems client have already closed connection.", e);
        }
    }

    private i e(String str) throws p {
        i iVar;
        synchronized (this.f38963a) {
            iVar = this.c.get(str);
            if (iVar == null) {
                iVar = new i(str, this.g);
                this.c.put(str, iVar);
            }
        }
        return iVar;
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (Exception e) {
            a(new p("Error closing socket", e));
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z) {
        if (!z || !b(str)) {
            return a() ? c(str) : str;
        }
        File fileD = d(str);
        a(fileD);
        return Uri.fromFile(fileD).toString();
    }

    public void a(com.kc.cw.ad.internal.d.b bVar, String str) {
        n.a(bVar, str);
        synchronized (this.f38963a) {
            try {
                e(str).a(bVar);
            } catch (p e) {
                com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.q, "Error registering cache listener", e);
            }
        }
    }

    public void b(com.kc.cw.ad.internal.d.b bVar, String str) {
        n.a(bVar, str);
        synchronized (this.f38963a) {
            try {
                e(str).b(bVar);
            } catch (p e) {
                com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.q, "Error registering cache listener", e);
            }
        }
    }

    public boolean b(String str) {
        n.a(str, "Url can't be null!");
        return d(str).exists();
    }
}
