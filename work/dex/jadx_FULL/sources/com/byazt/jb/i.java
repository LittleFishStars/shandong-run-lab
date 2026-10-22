package com.byazt.jb;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.o.b;
import com.byazt.mk.gt;
import com.byazt.mk.my;
import com.byazt.mk.rh;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 42})
public final class i {
    public static final /* synthetic */ boolean i = true;
    public final List<com.byazt.jb.ve> da;
    public final c n;
    public List<com.byazt.jb.ve> sl;
    public boolean t;
    public long tt;
    public final tt u;
    public final sp uj;
    public final int ve;
    public long c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve f28685a = new ve();
    public final ve sp = new ve();
    public com.byazt.jb.tt x = null;

    @com.byazt.zqa.c(c = {0, 1, 63, 1943})
    public class ve extends com.byazt.mk.c {
        public ve() {
        }

        @Override // com.byazt.mk.c
        public void m_() {
            i.this.tt(com.byazt.jb.tt.CANCEL);
        }

        @Override // com.byazt.mk.c
        public IOException tt(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(b.r0);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void x() throws IOException {
            if (tt()) {
                throw tt((IOException) null);
            }
        }
    }

    public i(int i2, sp spVar, boolean z, boolean z2, List<com.byazt.jb.ve> list) {
        if (spVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.ve = i2;
        this.uj = spVar;
        this.tt = spVar.u.uj();
        tt ttVar = new tt(spVar.t.uj());
        this.u = ttVar;
        c cVar = new c();
        this.n = cVar;
        ttVar.tt = z2;
        cVar.tt = z;
        this.da = list;
    }

    public gt a() {
        return this.sp;
    }

    public int c() {
        return this.ve;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0028  */
    public void da() throws IOException {
        boolean z;
        boolean zTt;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            tt ttVar = this.u;
            if (ttVar.tt || !ttVar.c) {
                z = false;
            } else {
                c cVar = this.n;
                if (cVar.tt || cVar.c) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zTt = tt();
        }
        if (z) {
            c(com.byazt.jb.tt.CANCEL);
        } else {
            if (zTt) {
                return;
            }
            this.uj.tt(this.ve);
        }
    }

    public void i() {
        boolean zTt;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.u.tt = true;
            zTt = tt();
            notifyAll();
        }
        if (zTt) {
            return;
        }
        this.uj.tt(this.ve);
    }

    public gt n() {
        return this.f28685a;
    }

    public void sl() throws IOException {
        c cVar = this.n;
        if (cVar.c) {
            throw new IOException("stream closed");
        }
        if (cVar.tt) {
            throw new IOException("stream finished");
        }
        if (this.x != null) {
            throw new z(this.x);
        }
    }

    public my sp() {
        return this.u;
    }

    public void t() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public synchronized boolean tt() {
        if (this.x != null) {
            return false;
        }
        tt ttVar = this.u;
        if (ttVar.tt || ttVar.c) {
            c cVar = this.n;
            if ((cVar.tt || cVar.c) && this.t) {
                return false;
            }
        }
        return true;
    }

    public synchronized List<com.byazt.jb.ve> uj() throws IOException {
        List<com.byazt.jb.ve> list;
        if (!ve()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.f28685a.c();
        while (this.sl == null && this.x == null) {
            try {
                t();
            } catch (Throwable th) {
                this.f28685a.x();
                throw th;
            }
        }
        this.f28685a.x();
        list = this.sl;
        if (list == null) {
            throw new z(this.x);
        }
        this.sl = null;
        return list;
    }

    public boolean ve() {
        return this.uj.tt == ((this.ve & 1) == 1);
    }

    public rh x() {
        synchronized (this) {
            if (!this.t && !ve()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.n;
    }

    public void c(com.byazt.jb.tt ttVar) throws IOException {
        if (uj(ttVar)) {
            this.uj.tt(this.ve, ttVar);
        }
    }

    public synchronized void ve(com.byazt.jb.tt ttVar) {
        if (this.x == null) {
            this.x = ttVar;
            notifyAll();
        }
    }

    public void c(List<com.byazt.jb.ve> list) {
        boolean zTt;
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zTt = true;
            this.t = true;
            if (this.sl == null) {
                this.sl = list;
                zTt = tt();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.sl);
                arrayList.add(null);
                arrayList.addAll(list);
                this.sl = arrayList;
            }
        }
        if (zTt) {
            return;
        }
        this.uj.tt(this.ve);
    }

    public void tt(com.byazt.jb.tt ttVar) {
        if (uj(ttVar)) {
            this.uj.c(this.ve, ttVar);
        }
    }

    private boolean uj(com.byazt.jb.tt ttVar) {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.x != null) {
                return false;
            }
            if (this.u.tt && this.n.tt) {
                return false;
            }
            this.x = ttVar;
            notifyAll();
            this.uj.tt(this.ve);
            return true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 64})
    public final class c implements rh {
        public static final /* synthetic */ boolean ve = true;
        public boolean c;
        public final com.byazt.mk.ve n = new com.byazt.mk.ve();
        public boolean tt;

        public c() {
        }

        private void c(boolean z) throws IOException {
            i iVar;
            long jMin;
            i iVar2;
            synchronized (i.this) {
                i.this.sp.c();
                while (true) {
                    try {
                        iVar = i.this;
                        if (iVar.tt > 0 || this.tt || this.c || iVar.x != null) {
                            break;
                        } else {
                            iVar.t();
                        }
                    } catch (Throwable th) {
                        i.this.sp.x();
                        throw th;
                    }
                }
                iVar.sp.x();
                i.this.sl();
                jMin = Math.min(i.this.tt, this.n.tt());
                iVar2 = i.this;
                iVar2.tt -= jMin;
            }
            iVar2.sp.c();
            try {
                i iVar3 = i.this;
                iVar3.uj.c(iVar3.ve, z && jMin == this.n.tt(), this.n, jMin);
            } finally {
                i.this.sp.x();
            }
        }

        @Override // com.byazt.mk.rh
        public void a_(com.byazt.mk.ve veVar, long j) throws IOException {
            if (!ve && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.n.a_(veVar, j);
            while (this.n.tt() >= PlaybackStateCompat.ACTION_PREPARE) {
                c(false);
            }
        }

        @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!ve && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.c) {
                    return;
                }
                if (!i.this.n.tt) {
                    if (this.n.tt() > 0) {
                        while (this.n.tt() > 0) {
                            c(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.uj.c(iVar.ve, true, (com.byazt.mk.ve) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.c = true;
                }
                i.this.uj.tt();
                i.this.da();
            }
        }

        @Override // com.byazt.mk.rh, java.io.Flushable
        public void flush() throws IOException {
            if (!ve && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.sl();
            }
            while (this.n.tt() > 0) {
                c(false);
                i.this.uj.tt();
            }
        }

        @Override // com.byazt.mk.rh
        public gt c() {
            return i.this.sp;
        }
    }

    public void c(com.byazt.mk.n nVar, int i2) throws IOException {
        if (!i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.u.c(nVar, i2);
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 1937})
    public final class tt implements my {
        public static final /* synthetic */ boolean ve = true;
        public boolean c;
        public final long sp;
        public boolean tt;
        public final com.byazt.mk.ve n = new com.byazt.mk.ve();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.byazt.mk.ve f28686a = new com.byazt.mk.ve();

        public tt(long j) {
            this.sp = j;
        }

        private void tt() throws IOException {
            i.this.f28685a.c();
            while (this.f28686a.tt() == 0 && !this.tt && !this.c) {
                try {
                    i iVar = i.this;
                    if (iVar.x != null) {
                        break;
                    } else {
                        iVar.t();
                    }
                } catch (Throwable th) {
                    i.this.f28685a.x();
                    throw th;
                }
            }
            i.this.f28685a.x();
        }

        private void ve() throws IOException {
            if (this.c) {
                throw new IOException("stream closed");
            }
            if (i.this.x != null) {
                throw new z(i.this.x);
            }
        }

        @Override // com.byazt.mk.my
        public long c(com.byazt.mk.ve veVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (i.this) {
                tt();
                ve();
                if (this.f28686a.tt() == 0) {
                    return -1L;
                }
                com.byazt.mk.ve veVar2 = this.f28686a;
                long jC = veVar2.c(veVar, Math.min(j, veVar2.tt()));
                i iVar = i.this;
                long j2 = iVar.c + jC;
                iVar.c = j2;
                if (j2 >= iVar.uj.t.uj() / 2) {
                    i iVar2 = i.this;
                    iVar2.uj.c(iVar2.ve, iVar2.c);
                    i.this.c = 0L;
                }
                synchronized (i.this.uj) {
                    sp spVar = i.this.uj;
                    long j3 = spVar.da + jC;
                    spVar.da = j3;
                    if (j3 >= spVar.t.uj() / 2) {
                        sp spVar2 = i.this.uj;
                        spVar2.c(0, spVar2.da);
                        i.this.uj.da = 0L;
                    }
                }
                return jC;
            }
        }

        @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.c = true;
                this.f28686a.rh();
                i.this.notifyAll();
            }
            i.this.da();
        }

        public void c(com.byazt.mk.n nVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!ve && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (i.this) {
                    z = this.tt;
                    z2 = true;
                    z3 = this.f28686a.tt() + j > this.sp;
                }
                if (z3) {
                    nVar.x(j);
                    i.this.tt(com.byazt.jb.tt.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    nVar.x(j);
                    return;
                }
                long jC = nVar.c(this.n, j);
                if (jC != -1) {
                    j -= jC;
                    synchronized (i.this) {
                        if (this.f28686a.tt() != 0) {
                            z2 = false;
                        }
                        this.f28686a.c(this.n);
                        if (z2) {
                            i.this.notifyAll();
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        @Override // com.byazt.mk.my
        public gt c() {
            return i.this.f28685a;
        }
    }

    public void c(long j) {
        this.tt += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
