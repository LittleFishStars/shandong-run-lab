package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.ipd.dsp.internal.v0.q;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.az;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f {
    private final Object aZY;
    private final ExecutorService aZZ;
    private final Map<String, g> baa;
    private final ServerSocket bab;
    private final Thread bac;
    private final com.kwad.sdk.core.videocache.c bad;
    private final int port;

    public static final class a {
        private File aZK;
        private com.kwad.sdk.core.videocache.d.c aZN;
        private int aZP;
        private Context context;
        private int aZQ = 0;
        private com.kwad.sdk.core.videocache.a.a aZM = new com.kwad.sdk.core.videocache.a.g(536870912);
        private com.kwad.sdk.core.videocache.a.c aZL = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aZO = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aZK = o.cl(context);
        }

        private com.kwad.sdk.core.videocache.c OZ() {
            return new com.kwad.sdk.core.videocache.c(this.aZK, this.aZL, this.aZM, this.aZN, this.aZO, this.aZP, this.aZQ);
        }

        public final f OY() {
            this.aZN = com.kwad.sdk.core.videocache.d.d.k(this.context, this.aZQ);
            return new f(OZ(), (byte) 0);
        }

        public final a aO(long j) {
            this.aZM = new com.kwad.sdk.core.videocache.a.g(536870912L);
            return this;
        }

        public final a eN(int i) {
            this.aZP = i;
            return this;
        }

        public final a eO(int i) {
            this.aZQ = i;
            return this;
        }
    }

    public final class b implements Runnable {
        private final Socket bae;

        public b(Socket socket) {
            this.bae = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.bae);
        }
    }

    public final class c implements Runnable {
        private final CountDownLatch bag;

        public c(CountDownLatch countDownLatch) {
            this.bag = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.bag.countDown();
                f.this.OW();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OW() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.bab.accept();
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Accept new socket " + socketAccept);
                this.aZZ.submit(new b(socketAccept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private int OX() {
        int iOX;
        synchronized (this.aZY) {
            Iterator<g> it = this.baa.values().iterator();
            iOX = 0;
            while (it.hasNext()) {
                iOX += it.next().OX();
            }
        }
        return iOX;
    }

    private File ae(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.bad;
        return new File(cVar.aZK, cVar.aZL.generate(str));
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private String fB(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", q.i, Integer.valueOf(this.port), l.encode(str));
    }

    private File fC(String str) {
        return new File(this.bad.aZK, this.bad.aZL.generate(str) + ".download");
    }

    private g fD(String str) {
        g gVar;
        synchronized (this.aZY) {
            gVar = this.baa.get(str);
            if (gVar == null) {
                gVar = new g(str, this.bad);
                this.baa.put(str, gVar);
            }
        }
        return gVar;
    }

    private String g(String str, boolean z) {
        if (!ae(str).exists()) {
            return fB(str);
        }
        File fileAe = ae(str);
        r(fileAe);
        return Uri.fromFile(fileAe).toString();
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
    }

    private void r(File file) {
        try {
            this.bad.aZM.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final boolean fA(String str) {
        g gVar = this.baa.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.baa.remove(str);
        return true;
    }

    public final String fx(String str) {
        return str == null ? "" : g(str, true);
    }

    public final boolean fy(String str) {
        az.aC(str, "Url can't be null!");
        return ae(str).exists();
    }

    public final boolean fz(String str) {
        az.aC(str, "Url can't be null!");
        return fC(str).exists() || ae(str).exists();
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aZY = new Object();
        this.aZZ = GlobalThreadPools.Og();
        this.baa = new ConcurrentHashMap();
        this.bad = (com.kwad.sdk.core.videocache.c) az.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(q.i));
            this.bab = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install(q.i, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.bac = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aZZ.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public final boolean a(String str, long j, com.kwad.sdk.core.network.a.a.C1286a c1286a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (fy(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(fB(str), null, c1286a, j, false, adHttpResponseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(Socket socket) {
        ?? sb;
        ?? OX = "Opened connections: ";
        try {
            try {
                d dVarB = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Request to cache proxy:" + dVarB);
                fD(l.decode(dVarB.uri)).a(dVarB, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            OX = OX();
            sb.append(OX);
            socket = sb.toString();
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", (String) socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", ((String) OX) + OX());
            throw th;
        }
    }
}
