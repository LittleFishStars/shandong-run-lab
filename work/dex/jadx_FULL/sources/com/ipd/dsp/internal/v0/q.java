package com.ipd.dsp.internal.v0;

import android.content.Context;
import android.net.Uri;
import com.ipd.dsp.Dsp;
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
public class q {
    public static final String h = "VCacheServer";
    public static final String i = "127.0.0.1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f38573a;
    public final ExecutorService b;
    public final Map<String, p> c;
    public final ServerSocket d;
    public final int e;
    public final Thread f;
    public final h g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f38574a = new q();
    }

    public final class c implements Runnable {
        public final Socket f;

        public c(Socket socket) {
            this.f = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.d(this.f);
        }
    }

    public final class d implements Runnable {
        public final CountDownLatch f;

        public d(CountDownLatch countDownLatch) {
            this.f = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.countDown();
            q.this.f();
        }
    }

    public static q b() {
        return b.f38574a;
    }

    public final boolean c() {
        return this.g.a(3, 70);
    }

    public String d(String str) {
        if (!e(str)) {
            return c() ? a(str) : str;
        }
        File fileB = b(str);
        a(fileB);
        return Uri.fromFile(fileB).toString();
    }

    public boolean e(String str) {
        i.a(str, "Url can't be null!");
        return b(str).exists();
    }

    public final void f() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.d.accept();
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(h, "Accept new socket " + socketAccept);
                }
                this.b.submit(new c(socketAccept));
            } catch (IOException e) {
                a(new k("Error during waiting connection", e));
                return;
            }
        }
    }

    public q() {
        this.f38573a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        Context context = Dsp.getContext();
        if (context == null) {
            throw new IllegalStateException("Init video server error, context == null");
        }
        com.ipd.dsp.internal.v0.c.a(context);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(i));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            f.a(i, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new d(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.g = new h(i, localPort);
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.d(h, "Proxy cache server started. Is it alive? " + c());
            }
        } catch (IOException | InterruptedException e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public void b(com.ipd.dsp.internal.v0.b bVar, String str) {
        i.a(bVar, str);
        synchronized (this.f38573a) {
            try {
                c(str).b(bVar);
            } catch (k e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(h, "Error registering cache listener", e);
                }
            }
        }
    }

    public final p c(String str) throws k {
        p pVar;
        synchronized (this.f38573a) {
            pVar = this.c.get(str);
            if (pVar == null) {
                pVar = new p(str);
                this.c.put(str, pVar);
            }
        }
        return pVar;
    }

    public void a(com.ipd.dsp.internal.v0.b bVar, String str) {
        i.a(bVar, str);
        synchronized (this.f38573a) {
            try {
                c(str).a(bVar);
            } catch (k e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(h, "Error registering cache listener", e);
                }
            }
        }
    }

    public final void e() {
        synchronized (this.f38573a) {
            Iterator<p> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.c.clear();
        }
    }

    public void d() {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.d(h, "Shutdown proxy server");
        }
        e();
        com.ipd.dsp.internal.v0.c.c().a();
        this.f.interrupt();
        try {
            if (this.d.isClosed()) {
                return;
            }
            this.d.close();
        } catch (IOException e) {
            a(new k("Error shutting down proxy server", e));
        }
    }

    public final File b(String str) {
        return new File(com.ipd.dsp.internal.v0.c.a(), com.ipd.dsp.internal.w0.e.a(str));
    }

    public final void c(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.f(h, String.format(Locale.getDefault(), "Failed to close socket on proxy side: %s. It seems client have already closed connection.", e.getMessage()));
            }
        }
    }

    public final void e(Socket socket) {
        b(socket);
        c(socket);
        a(socket);
    }

    public void a(com.ipd.dsp.internal.v0.b bVar) {
        i.a(bVar);
        synchronized (this.f38573a) {
            Iterator<p> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().b(bVar);
            }
        }
    }

    public final void b(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(h, "Releasing input stream... Socket is closed by client.");
            }
        } catch (IOException e) {
            a(new k("Error closing socket input stream", e));
        }
    }

    public final String a(String str) {
        return String.format(Locale.getDefault(), "http://%s:%d/%s", i, Integer.valueOf(this.e), l.b(str));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x0079, please report this as an issue */
    public final void d(Socket socket) {
        try {
            try {
                com.ipd.dsp.internal.v0.d dVarA = com.ipd.dsp.internal.v0.d.a(socket.getInputStream());
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.b(h, "Request to cache proxy: " + dVarA);
                }
                String strA = l.a(dVarA.f38563a);
                if (this.g.a(strA)) {
                    this.g.a(socket);
                } else {
                    c(strA).a(dVarA, socket);
                }
                e(socket);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(h, "Opened connections: " + a());
                }
            } catch (k e) {
                e = e;
                a(new k("Error processing request", e));
                e(socket);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(h, "Opened connections: " + a());
                }
            } catch (SocketException unused) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(h, "Closing socket... Socket is closed by client.");
                }
                e(socket);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(h, "Opened connections: " + a());
                }
            } catch (IOException e2) {
                e = e2;
                a(new k("Error processing request", e));
                e(socket);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(h, "Opened connections: " + a());
                }
            }
        } catch (Throwable th) {
            e(socket);
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(h, "Opened connections: " + a());
            }
            throw th;
        }
    }

    public final void a(File file) {
        try {
            com.ipd.dsp.internal.v0.c.b().a(file);
        } catch (IOException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.b(h, "Error touching file " + file, e);
            }
        }
    }

    public final int a() {
        int iB;
        synchronized (this.f38573a) {
            Iterator<p> it = this.c.values().iterator();
            iB = 0;
            while (it.hasNext()) {
                iB += it.next().b();
            }
        }
        return iB;
    }

    public final void a(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            a(new k("Error closing socket", e));
        }
    }

    public final void a(Throwable th) {
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.b(h, "VCacheServer error", th);
        }
    }
}
