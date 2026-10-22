package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements a {
    private volatile Thread aAD;
    private Handler handler;
    private volatile List<Integer> aAB = new CopyOnWriteArrayList();
    private AtomicInteger aAC = new AtomicInteger();
    private final b aAy = new b();
    private final d aAz = new d();
    private final long aAA = com.kwad.framework.filedownloader.f.e.Dz().aDt;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.cp("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.aAD != null) {
                        LockSupport.unpark(c.this.aAD);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.aAC.set(i);
                    c.this.cH(i);
                    c.this.aAB.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.aAC.set(0);
                    if (c.this.aAD != null) {
                        LockSupport.unpark(c.this.aAD);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(int i) {
        this.aAz.b(this.aAy.cC(i));
        List<com.kwad.framework.filedownloader.d.a> listCD = this.aAy.cD(i);
        this.aAz.cE(i);
        Iterator<com.kwad.framework.filedownloader.d.a> it = listCD.iterator();
        while (it.hasNext()) {
            this.aAz.a(it.next());
        }
    }

    private boolean cI(int i) {
        return !this.aAB.contains(Integer.valueOf(i));
    }

    private void cJ(int i) {
        this.handler.removeMessages(i);
        if (this.aAC.get() != i) {
            cH(i);
            return;
        }
        this.aAD = Thread.currentThread();
        this.handler.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC1253a BR() {
        d dVar = this.aAz;
        b bVar = this.aAy;
        return dVar.a(bVar.aAv, bVar.aAw);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cB(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.aAA);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c cC(int i) {
        return this.aAy.cC(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> cD(int i) {
        return this.aAy.cD(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cE(int i) {
        this.aAy.cE(i);
        if (cI(i)) {
            return;
        }
        this.aAz.cE(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean cF(int i) {
        this.aAz.cF(i);
        return this.aAy.cF(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void cG(int i) {
        this.aAy.cG(i);
        if (cI(i)) {
            return;
        }
        this.aAz.cG(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.aAy.clear();
        this.aAz.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        this.aAy.d(i, j);
        if (cI(i)) {
            cJ(i);
        }
        this.aAz.d(i, j);
        this.aAB.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void w(int i, int i2) {
        this.aAy.w(i, i2);
        if (cI(i)) {
            return;
        }
        this.aAz.w(i, i2);
    }

    public static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.aAD = null;
        return null;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        this.aAy.b(i, j);
        if (cI(i)) {
            return;
        }
        this.aAz.b(i, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        this.aAy.c(i, j);
        if (cI(i)) {
            this.handler.removeMessages(i);
            if (this.aAC.get() == i) {
                this.aAD = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
                this.aAz.c(i, j);
            }
        } else {
            this.aAz.c(i, j);
        }
        this.aAB.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.aAy.a(aVar);
        if (cI(aVar.getId())) {
            return;
        }
        this.aAz.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.aAy.b(cVar);
        if (cI(cVar.getId())) {
            return;
        }
        this.aAz.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        this.aAy.a(i, i2, j);
        if (cI(i)) {
            return;
        }
        this.aAz.a(i, i2, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        this.aAy.a(i, str, j, j2, i2);
        if (cI(i)) {
            return;
        }
        this.aAz.a(i, str, j, j2, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        this.aAy.a(i, j, str, str2);
        if (cI(i)) {
            return;
        }
        this.aAz.a(i, j, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        this.aAy.a(i, th);
        if (cI(i)) {
            return;
        }
        this.aAz.a(i, th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        this.aAy.a(i, th, j);
        if (cI(i)) {
            cJ(i);
        }
        this.aAz.a(i, th, j);
        this.aAB.remove(Integer.valueOf(i));
    }
}
