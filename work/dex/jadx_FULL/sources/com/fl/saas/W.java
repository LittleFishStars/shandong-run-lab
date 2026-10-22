package com.fl.saas;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f30093a = new AtomicInteger(0);
    private final String b;
    private volatile U c;
    private final List d;
    private final InterfaceC1429q e;
    private final C1445y f;

    public static final class a extends Handler implements InterfaceC1429q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30094a;
        private final List b;

        public a(String str, List list) {
            super(Looper.getMainLooper());
            this.f30094a = str;
            this.b = list;
        }

        @Override // com.fl.saas.InterfaceC1429q
        public void a(File file, String str, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((InterfaceC1429q) it.next()).a((File) message.obj, this.f30094a, message.arg1);
            }
        }
    }

    public W(String str, C1445y c1445y) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.b = (String) AbstractC1442w0.a(str);
        this.f = (C1445y) AbstractC1442w0.a(c1445y);
        this.e = new a(str, copyOnWriteArrayList);
    }

    private synchronized void a() {
        if (this.f30093a.decrementAndGet() <= 0) {
            this.c.g();
            this.c = null;
        }
    }

    private U c() {
        String str = this.b;
        C1445y c1445y = this.f;
        U u = new U(new X(str, c1445y.d, c1445y.e), new L(this.f.a(this.b), this.f.c));
        u.a(this.e);
        return u;
    }

    private synchronized void d() {
        this.c = this.c == null ? c() : this.c;
    }

    public int b() {
        return this.f30093a.get();
    }

    public void a(P p, Socket socket) {
        d();
        try {
            this.f30093a.incrementAndGet();
            this.c.a(p, socket);
        } finally {
            a();
        }
    }
}
