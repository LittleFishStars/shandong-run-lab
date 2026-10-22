package com.igexin.c.a.b.a.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    static final Object j = new Object();
    private static final String n = "GS-M";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Socket f37814a;
    e b;
    g c;
    b d;
    final Handler e;
    boolean f;
    protected Lock g;
    protected Condition h;
    final List<f> i;
    protected ConcurrentLinkedQueue<f> k;
    long l;
    final Comparator<f> m;
    private com.igexin.c.a.b.d o;
    private final AtomicBoolean p;

    /* JADX INFO: renamed from: com.igexin.c.a.b.a.a.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.igexin.c.a.b.a.a.a.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            com.igexin.c.a.c.a.a(d.n, "connect hand INTERRUPT_SUCCESS");
            d.this.e.sendEmptyMessage(j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void a(Exception exc) {
            com.igexin.c.a.c.a.a(d.n, "connect exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|c ex = " + exc.toString(), new Object[0]);
            d.this.c();
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void a(Socket socket) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = socket;
            messageObtain.what = j.c - 1;
            d.this.e.sendMessage(messageObtain);
        }

        @Override // com.igexin.c.a.b.a.a.a.d
        public final void b() {
            d.this.e.sendEmptyMessage(j.e - 1);
        }
    }

    /* JADX INFO: renamed from: com.igexin.c.a.b.a.a.d$2, reason: invalid class name */
    public class AnonymousClass2 implements com.igexin.c.a.b.a.a.a.b {
        public AnonymousClass2() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            d.this.e.sendEmptyMessage(j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.b
        public final void a(Exception exc) {
            com.igexin.c.a.c.a.a(d.n, "readTask exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|r ex = " + exc.toString(), new Object[0]);
            if (exc.getMessage() == null || !exc.getMessage().equals("end of stream")) {
                d.this.c();
            } else {
                com.igexin.push.d.c.b.f38095a.c();
            }
        }

        @Override // com.igexin.c.a.b.a.a.a.b
        public final void b() {
        }
    }

    /* JADX INFO: renamed from: com.igexin.c.a.b.a.a.d$3, reason: invalid class name */
    public class AnonymousClass3 implements com.igexin.c.a.b.a.a.a.c {
        public AnonymousClass3() {
        }

        @Override // com.igexin.c.a.b.a.a.a.a
        public final void a() {
            d.this.e.sendEmptyMessage(j.f - 1);
        }

        @Override // com.igexin.c.a.b.a.a.a.c
        public final void a(f fVar) {
            d dVar = d.this;
            if (fVar.B <= 0 || fVar.G == null) {
                fVar.l();
                return;
            }
            fVar.z = System.currentTimeMillis();
            synchronized (d.j) {
                dVar.i.add(fVar);
                Collections.sort(dVar.i, dVar.m);
                fVar.d.getClass();
                long millis = TimeUnit.SECONDS.toMillis(dVar.i.get(0).B);
                dVar.l = millis;
                if (millis > 0 && dVar.i.size() == 1) {
                    fVar.d.getClass();
                    com.igexin.c.a.c.a.a("GS-M|add : " + fVar.toString() + " --- " + fVar.d.getClass().getName() + " set response timeout delay = " + dVar.l, new Object[0]);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = j.h - 1;
                    messageObtain.obj = fVar.d.getClass().getSimpleName();
                    dVar.e.sendMessageDelayed(messageObtain, dVar.l);
                }
                dVar.i.size();
            }
        }

        @Override // com.igexin.c.a.b.a.a.a.c
        public final void a(Exception exc) {
            com.igexin.c.a.c.a.a(d.n, "writeTask exception = " + exc.toString());
            com.igexin.c.a.c.a.a("GS-M|w ex = " + exc.toString(), new Object[0]);
            d.this.c();
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f37819a = new d(0);

        private a() {
        }
    }

    private d() {
        this.p = new AtomicBoolean(false);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.g = reentrantLock;
        this.h = reentrantLock.newCondition();
        this.i = new ArrayList();
        this.k = new ConcurrentLinkedQueue<>();
        this.m = new Comparator<f>() { // from class: com.igexin.c.a.b.a.a.d.4
            private static int a(f fVar, f fVar2) {
                if (fVar == null) {
                    return 1;
                }
                if (fVar2 == null) {
                    return -1;
                }
                return Long.compare(((long) fVar.B) + fVar.z, ((long) fVar2.B) + fVar2.z);
            }

            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(f fVar, f fVar2) {
                f fVar3 = fVar;
                f fVar4 = fVar2;
                if (fVar3 == null) {
                    return 1;
                }
                if (fVar4 == null) {
                    return -1;
                }
                return Long.compare(((long) fVar3.B) + fVar3.z, ((long) fVar4.B) + fVar4.z);
            }
        };
        this.e = com.igexin.push.core.d.a.f37984a.e;
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        return a.f37819a;
    }

    private void a(Object obj) {
        com.igexin.c.a.c.a.b(n, ((String) obj) + " write task response timeout");
        c();
    }

    private void b(f fVar) {
        if (fVar.B <= 0 || fVar.G == null) {
            fVar.l();
            return;
        }
        fVar.z = System.currentTimeMillis();
        synchronized (j) {
            this.i.add(fVar);
            Collections.sort(this.i, this.m);
            fVar.d.getClass();
            long millis = TimeUnit.SECONDS.toMillis(this.i.get(0).B);
            this.l = millis;
            if (millis > 0 && this.i.size() == 1) {
                fVar.d.getClass();
                com.igexin.c.a.c.a.a("GS-M|add : " + fVar.toString() + " --- " + fVar.d.getClass().getName() + " set response timeout delay = " + this.l, new Object[0]);
                Message messageObtain = Message.obtain();
                messageObtain.what = j.h - 1;
                messageObtain.obj = fVar.d.getClass().getSimpleName();
                this.e.sendMessageDelayed(messageObtain, this.l);
            }
            this.i.size();
        }
    }

    private void b(Socket socket) throws Exception {
        e eVar = new e(new h(socket.getInputStream()), this.o);
        this.b = eVar;
        eVar.k = new AnonymousClass2();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.b, true);
    }

    private void c(Socket socket) throws Exception {
        g gVar = new g(new i(socket.getOutputStream()), this.o);
        this.c = gVar;
        gVar.j = new AnonymousClass3();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.c, true);
    }

    private static void k() {
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
        com.igexin.push.e.a.a(j.f37825a);
    }

    private void l() {
        j();
        if ((this.d == null && this.c == null && this.b == null) || i()) {
            b();
        } else {
            h();
        }
    }

    private void m() {
        Socket socket = this.f37814a;
        boolean z = (socket == null || socket.isClosed()) ? false : true;
        if (!z && this.d == null) {
            com.igexin.c.a.c.a.a("GS-M|disconnect = true, reconnect", new Object[0]);
            this.d = new b(new AnonymousClass1());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.d, true);
        } else {
            com.igexin.c.a.c.a.a("GS-Mstart connect, isConnected = " + z + ", ctask = " + this.d, new Object[0]);
        }
    }

    private void n() {
        g gVar = this.c;
        if (gVar != null) {
            gVar.l = null;
            this.c = null;
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.j = null;
            this.b = null;
        }
        this.d = null;
        this.f37814a = null;
    }

    private void o() {
        if (!i() || this.f) {
            return;
        }
        b();
        this.f = true;
    }

    private boolean p() {
        Socket socket = this.f37814a;
        return (socket == null || socket.isClosed()) ? false : true;
    }

    public final void a(f fVar) {
        try {
            this.g.lock();
            this.k.offer(fVar);
            this.h.signalAll();
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        } finally {
            try {
                this.g.unlock();
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
    }

    public final void a(com.igexin.c.a.b.d dVar) {
        this.o = dVar;
        e eVar = this.b;
        if (eVar != null) {
            eVar.l = dVar;
        }
        g gVar = this.c;
        if (gVar != null) {
            gVar.k = dVar;
        }
    }

    public final void a(String str) {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (j) {
            com.igexin.c.a.c.a.a("GS-M|" + str + " -- resp,no timeout", new Object[0]);
            this.l = 0L;
            Iterator<f> it = this.i.iterator();
            String simpleName = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                f next = it.next();
                if (next.G.a(jCurrentTimeMillis, next)) {
                    next.l();
                    next.G.c();
                    it.remove();
                    z = true;
                    break;
                }
                long jB = next.G.b(jCurrentTimeMillis, next);
                long j2 = this.l;
                if (j2 < 0 || j2 > jB) {
                    this.l = jB;
                    simpleName = next.d.getClass().getSimpleName();
                }
            }
            Handler handler = this.e;
            int i = j.h;
            handler.removeMessages(i - 1);
            if (z) {
                com.igexin.c.a.c.a.a("GS-M|timeout", new Object[0]);
                f();
                return;
            }
            if (this.i.size() > 0) {
                f fVar = this.i.get(0);
                fVar.l();
                com.igexin.c.a.b.e.a().a((Object) fVar);
                this.i.remove(fVar);
                fVar.d.getClass();
                com.igexin.c.a.c.a.a("GS-M|remove : " + fVar.toString() + " -- " + fVar.d.getClass().getSimpleName(), new Object[0]);
            }
            int size = this.i.size();
            com.igexin.c.a.c.a.a("GS-M|r, size = ".concat(String.valueOf(size)), new Object[0]);
            if (size > 0 && this.l > 0 && !TextUtils.isEmpty(simpleName)) {
                com.igexin.c.a.c.a.a("GS-M|" + simpleName + " , set  response timeout = " + this.l, new Object[0]);
                Message messageObtain = Message.obtain();
                messageObtain.what = i - 1;
                messageObtain.obj = simpleName;
                this.e.sendMessageDelayed(messageObtain, this.l);
            }
        }
    }

    public final void a(Socket socket) {
        try {
            if (this.d.g()) {
                return;
            }
            this.f37814a = socket;
            e eVar = new e(new h(socket.getInputStream()), this.o);
            this.b = eVar;
            eVar.k = new AnonymousClass2();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.b, true);
            g gVar = new g(new i(socket.getOutputStream()), this.o);
            this.c = gVar;
            gVar.j = new AnonymousClass3();
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this.c, true);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a("GS-M|" + e.toString(), new Object[0]);
            com.igexin.c.a.c.a.a(n, "tcpConnect exception =" + e.toString());
            c();
        }
    }

    public final void b() {
        this.p.set(false);
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
        com.igexin.push.e.a.a(j.b);
    }

    public final void c() {
        if (this.p.getAndSet(true)) {
            return;
        }
        this.e.sendEmptyMessage(j.f37825a - 1);
    }

    public final synchronized void d() {
        com.igexin.c.a.c.a.a(n, "disConnect, hand TCP_DISCONNECT");
        this.e.sendEmptyMessage(j.g - 1);
    }

    public final synchronized void e() {
        this.e.sendEmptyMessage(j.d - 1);
        this.f = false;
    }

    public final synchronized void f() {
        com.igexin.c.a.c.a.a(n, "alarm timeout disconnect");
        com.igexin.c.a.c.a.a("GS-M|alarm timeout disconnect", new Object[0]);
        c();
    }

    public final synchronized void g() {
        com.igexin.c.a.c.a.a(n, "redirect disconnect");
        com.igexin.c.a.c.a.a("GS-M|redirect disconnect", new Object[0]);
        c();
    }

    public final void h() {
        com.igexin.c.a.c.a.a(n, "disconnect");
        com.igexin.c.a.c.a.a("GS-M|disconnect", new Object[0]);
        b bVar = this.d;
        if (bVar != null) {
            bVar.c_();
        }
        g gVar = this.c;
        if (gVar != null) {
            gVar.c_();
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.c_();
        }
        Socket socket = this.f37814a;
        if (socket != null) {
            try {
                if (socket.isClosed()) {
                    return;
                }
                this.f37814a.close();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    public final boolean i() {
        b bVar = this.d;
        if (bVar != null && !bVar.f) {
            return false;
        }
        e eVar = this.b;
        if (eVar != null && !eVar.f) {
            return false;
        }
        g gVar = this.c;
        if (gVar != null && !gVar.f) {
            return false;
        }
        n();
        return true;
    }

    public final void j() {
        this.e.removeMessages(j.h - 1);
        com.igexin.c.a.b.e.a().d();
        com.igexin.c.a.c.a.a("GS-M|cancel alarm", new Object[0]);
        synchronized (j) {
            if (!this.i.isEmpty()) {
                Iterator<f> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().l();
                }
                this.i.clear();
            }
        }
        if (this.k.isEmpty()) {
            return;
        }
        Iterator<f> it2 = this.k.iterator();
        while (it2.hasNext()) {
            it2.next().l();
        }
        this.k.clear();
    }
}
