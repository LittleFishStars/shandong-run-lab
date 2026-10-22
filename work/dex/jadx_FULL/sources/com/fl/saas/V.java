package com.fl.saas;

import android.content.Context;
import android.net.Uri;
import com.fl.saas.adx.util.LogcatUtil;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f30089a;
    private final ExecutorService b;
    private final Map c;
    private final ServerSocket d;
    private final int e;
    private final Thread f;
    private final C1445y g;
    private final C1436t0 h;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f30090a;
        private X0 d;
        private E c = new d1(536870912);
        private N b = new C1414i0();
        private Q e = new I();

        public b(Context context) {
            this.d = Y0.a(context);
            this.f30090a = Z0.b(context);
        }

        private C1445y b() {
            return new C1445y(this.f30090a, this.b, this.c, this.d, this.e);
        }

        public V a() {
            return new V(b());
        }

        public b a(File file) {
            this.f30090a = (File) AbstractC1442w0.a(file);
            return this;
        }

        public b a(Q q) {
            this.e = (Q) AbstractC1442w0.a(q);
            return this;
        }

        public b a(long j) {
            this.c = new d1(j);
            return this;
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Socket f30091a;

        public c(Socket socket) {
            this.f30091a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            V.this.d(this.f30091a);
        }
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f30092a;

        public d(CountDownLatch countDownLatch) {
            this.f30092a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f30092a.countDown();
            V.this.c();
        }
    }

    private V(C1445y c1445y) {
        this.f30089a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.c = new ConcurrentHashMap();
        this.g = (C1445y) AbstractC1442w0.a(c1445y);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(com.ipd.dsp.internal.v0.q.i));
            this.d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.e = localPort;
            Z.a(com.ipd.dsp.internal.v0.q.i, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new d(countDownLatch));
            this.f = thread;
            thread.start();
            countDownLatch.await();
            this.h = new C1436t0(com.ipd.dsp.internal.v0.q.i, localPort);
            LogcatUtil.d("Proxy cache server started. Is it alive? " + b());
        } catch (IOException | InterruptedException e) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void b(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            LogcatUtil.d("Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            a(new C1448z0("Error closing socket input stream", e));
        }
    }

    private void c(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void e(Socket socket) {
        b(socket);
        c(socket);
        a(socket);
    }

    public boolean d(String str) {
        AbstractC1442w0.a(str, "Url can't be null!");
        return b(str).exists();
    }

    private File b(String str) {
        C1445y c1445y = this.g;
        return new File(c1445y.f30211a, c1445y.b.a(str));
    }

    private W c(String str) {
        W w;
        synchronized (this.f30089a) {
            w = (W) this.c.get(str);
            if (w == null) {
                w = new W(str, this.g);
                this.c.put(str, w);
            }
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Socket socket) {
        StringBuilder sb;
        try {
            try {
                P pA = P.a(socket.getInputStream());
                LogcatUtil.d("Request to cache proxy:" + pA);
                String strB = A0.b(pA.f30080a);
                if (this.h.a(strB)) {
                    this.h.a(socket);
                } else {
                    c(strB).a(pA, socket);
                }
                e(socket);
                sb = new StringBuilder();
            } catch (C1448z0 e) {
                e = e;
                a(new C1448z0("Error processing request", e));
                e(socket);
                sb = new StringBuilder();
            } catch (SocketException unused) {
                LogcatUtil.d("Closing socket… Socket is closed by client.");
                e(socket);
                sb = new StringBuilder();
            } catch (IOException e2) {
                e = e2;
                a(new C1448z0("Error processing request", e));
                e(socket);
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(a());
            LogcatUtil.d(sb.toString());
        } catch (Throwable th) {
            e(socket);
            LogcatUtil.d("Opened connections: " + a());
            throw th;
        }
    }

    private String a(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", com.ipd.dsp.internal.v0.q.i, Integer.valueOf(this.e), A0.c(str));
    }

    private boolean b() {
        return this.h.a(3, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.d.accept();
                LogcatUtil.d("Accept new socket " + socketAccept);
                this.b.submit(new c(socketAccept));
            } catch (IOException e) {
                a(new C1448z0("Error during waiting connection", e));
                return;
            }
        }
    }

    private void a(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            a(new C1448z0("Error closing socket", e));
        }
    }

    private int a() {
        int iB;
        synchronized (this.f30089a) {
            Iterator it = this.c.values().iterator();
            iB = 0;
            while (it.hasNext()) {
                iB += ((W) it.next()).b();
            }
        }
        return iB;
    }

    public String a(String str, boolean z) {
        if (!z || !d(str)) {
            return b() ? a(str) : str;
        }
        File fileB = b(str);
        a(fileB);
        return Uri.fromFile(fileB).toString();
    }

    private void a(Throwable th) {
        th.printStackTrace();
    }

    private void a(File file) {
        try {
            this.g.c.a(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
