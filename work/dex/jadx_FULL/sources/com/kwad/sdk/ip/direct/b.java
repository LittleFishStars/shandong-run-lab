package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.by;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private static Handler bgW = new Handler(Looper.getMainLooper());
    static int bhg = 80;
    static int port = 80;

    public static class a extends Thread {
        LinkedList bhi = new LinkedList();
        volatile boolean bhj = false;
        Selector bhh = Selector.open();

        public a() {
            setName("Connector");
        }

        private void Rw() {
            synchronized (this.bhi) {
                while (this.bhi.size() > 0) {
                    C1298b c1298b = (C1298b) this.bhi.removeFirst();
                    try {
                        c1298b.bhn.register(this.bhh, 8, c1298b);
                    } catch (Throwable th) {
                        c1298b.bhn.close();
                        c1298b.bho = th;
                    }
                }
            }
        }

        private void Rx() {
            Iterator<SelectionKey> it = this.bhh.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C1298b c1298b = (C1298b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c1298b.bhs = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    by.c(socketChannel);
                    c1298b.bho = th;
                }
            }
        }

        public final void a(C1298b c1298b) {
            final SocketChannel socketChannelOpen;
            try {
                socketChannelOpen = SocketChannel.open();
                try {
                    socketChannelOpen.configureBlocking(false);
                    boolean zConnect = socketChannelOpen.connect(c1298b.bhm);
                    c1298b.bhn = socketChannelOpen;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    c1298b.bhr = jElapsedRealtime;
                    if (zConnect) {
                        c1298b.bhs = jElapsedRealtime;
                        by.c(socketChannelOpen);
                    } else {
                        synchronized (this.bhi) {
                            this.bhi.add(c1298b);
                        }
                        Selector selector = this.bhh;
                        if (selector != null) {
                            try {
                                selector.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    try {
                        b.bgW.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                by.c(socketChannelOpen);
                            }
                        }, c1298b.bhq);
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        by.c(socketChannelOpen);
                        c1298b.bho = th;
                    } finally {
                        try {
                            b.bgW.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    by.c(socketChannelOpen);
                                }
                            }, c1298b.bhq);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                socketChannelOpen = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.bhh.select() > 0) {
                        Rx();
                    }
                    Rw();
                    if (this.bhj) {
                        Selector selector = this.bhh;
                        if (selector != null) {
                            try {
                                selector.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    continue;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public final void shutdown() {
            this.bhj = true;
            Selector selector = this.bhh;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    public static class C1298b {
        InetSocketAddress bhm;
        SocketChannel bhn;
        Throwable bho;
        private float bhp;
        long bhq;
        long bhr;
        long bhs = 0;
        boolean bht = false;
        private boolean success;

        public C1298b(String str) {
            try {
                this.bhm = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.bho = th;
            }
        }

        public final void Ry() {
            String string;
            if (this.bhs != 0) {
                string = Long.toString(this.bhs - this.bhr) + "ms";
                this.bhp = this.bhs - this.bhr;
                this.success = true;
            } else {
                Throwable th = this.bho;
                if (th != null) {
                    string = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    string = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.bhm + " : " + string);
            this.bht = true;
        }
    }

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList<C1298b> linkedList = new LinkedList();
            for (int i = 0; i < cVar.Rz(); i++) {
                C1298b c1298b = new C1298b(str);
                c1298b.bhq = j + j2;
                linkedList.add(c1298b);
                try {
                    aVar.a(c1298b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    boolean z = true;
                    float f = 0.0f;
                    for (C1298b c1298b2 : linkedList) {
                        c1298b2.Ry();
                        z &= c1298b2.success;
                        cVar.cb(z);
                        f += c1298b2.bhp;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.r(f / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
