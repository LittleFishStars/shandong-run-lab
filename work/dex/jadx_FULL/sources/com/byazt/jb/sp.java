package com.byazt.jb;

import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 91})
public final class sp implements Closeable {
    public static final ExecutorService c = new com.byazt.jtc.uj(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.kh.ve.c("OkHttp Http2Connection", true));
    public static final /* synthetic */ boolean my = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28687a;
    public final ExecutorService gt;
    public final u i;
    public final da m;
    public final String n;
    public final ve nu;
    public int qy;
    public final Set<Integer> rh;
    public Map<Integer, t> rl;
    public long sl;
    public int sp;
    public final boolean tt;
    public final yp u;
    public final tt ve;
    public boolean x;
    public boolean yp;
    public final Socket z;
    public final Map<Integer, i> uj = new LinkedHashMap();
    public long da = 0;
    public yp t = new yp();

    @com.byazt.zqa.c(c = {0, 1, 63, 904})
    public static abstract class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final tt f28691a = new tt() { // from class: com.byazt.jb.sp.tt.1
            @Override // com.byazt.jb.sp.tt
            public void c(i iVar) throws IOException {
                iVar.c(com.byazt.jb.tt.REFUSED_STREAM);
            }
        };

        public abstract void c(i iVar) throws IOException;

        public void c(sp spVar) {
        }
    }

    public sp(c cVar) {
        yp ypVar = new yp();
        this.u = ypVar;
        this.yp = false;
        this.rh = new LinkedHashSet();
        this.i = cVar.f28690a;
        boolean z = cVar.sp;
        this.tt = z;
        this.ve = cVar.n;
        int i = z ? 1 : 2;
        this.sp = i;
        if (z) {
            this.sp = i + 2;
        }
        this.qy = z ? 1 : 2;
        if (z) {
            this.t.c(7, 16777216);
        }
        String str = cVar.tt;
        this.n = str;
        this.gt = new com.byazt.jtc.uj(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.byazt.kh.ve.c(com.byazt.kh.ve.c("OkHttp %s Push Observer", str), true));
        ypVar.c(7, 65535);
        ypVar.c(5, 16384);
        this.sl = ypVar.uj();
        this.z = cVar.c;
        this.m = new da(cVar.uj, z);
        this.nu = new ve(new x(cVar.ve, z));
    }

    public synchronized i c(int i) {
        return this.uj.get(Integer.valueOf(i));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        c(com.byazt.jb.tt.NO_ERROR, com.byazt.jb.tt.CANCEL);
    }

    public synchronized i tt(int i) {
        i iVarRemove;
        iVarRemove = this.uj.remove(Integer.valueOf(i));
        notifyAll();
        return iVarRemove;
    }

    public synchronized boolean uj() {
        return this.x;
    }

    public boolean uj(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public synchronized t ve(int i) {
        Map<Integer, t> map = this.rl;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public synchronized int c() {
        return this.u.ve(Integer.MAX_VALUE);
    }

    public void ve() throws IOException {
        c(true);
    }

    public i c(List<com.byazt.jb.ve> list, boolean z) throws IOException {
        return tt(0, list, z);
    }

    public void ve(final int i, final com.byazt.jb.tt ttVar) {
        this.gt.execute(new com.byazt.kh.tt("OkHttp %s Push Reset[%s]", new Object[]{this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.7
            @Override // com.byazt.kh.tt
            public void ve() {
                synchronized (sp.this) {
                    sp.this.rh.remove(Integer.valueOf(i));
                }
            }
        });
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 180})
    public static class c {
        public Socket c;
        public boolean sp;
        public String tt;
        public com.byazt.mk.uj uj;
        public com.byazt.mk.n ve;
        public tt n = tt.f28691a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u f28690a = u.c;

        public c(boolean z) {
            this.sp = z;
        }

        public c c(Socket socket, String str, com.byazt.mk.n nVar, com.byazt.mk.uj ujVar) {
            this.c = socket;
            this.tt = str;
            this.ve = nVar;
            this.uj = ujVar;
            return this;
        }

        public c c(tt ttVar) {
            this.n = ttVar;
            return this;
        }

        public sp c() {
            return new sp(this);
        }
    }

    private i tt(int i, List<com.byazt.jb.ve> list, boolean z) throws IOException {
        int i2;
        i iVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.m) {
            synchronized (this) {
                if (!this.x) {
                    i2 = this.sp;
                    this.sp = i2 + 2;
                    iVar = new i(i2, this, z3, false, list);
                    z2 = !z || this.sl == 0 || iVar.tt == 0;
                    if (iVar.tt()) {
                        this.uj.put(Integer.valueOf(i2), iVar);
                    }
                } else {
                    throw new com.byazt.jb.c();
                }
            }
            if (i == 0) {
                this.m.c(z3, i2, i, list);
            } else if (!this.tt) {
                this.m.c(i, i2, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z2) {
            this.m.tt();
        }
        return iVar;
    }

    public void c(int i, boolean z, com.byazt.mk.ve veVar, long j) throws IOException {
        long j2;
        int iMin;
        long j3;
        if (j == 0) {
            this.m.c(z, i, veVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.sl;
                        if (j2 <= 0) {
                            if (this.uj.containsKey(Integer.valueOf(i))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, j2), this.m.ve());
                j3 = iMin;
                this.sl -= j3;
            }
            j -= j3;
            this.m.c(z && j == 0, i, veVar, iMin);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 1280})
    public class ve extends com.byazt.kh.tt implements x.tt {
        public final x c;

        public ve(x xVar) {
            super("OkHttp %s", sp.this.n);
            this.c = xVar;
        }

        @Override // com.byazt.jb.x.tt
        public void c(boolean z, int i, com.byazt.mk.n nVar, int i2) throws IOException {
            if (sp.this.uj(i)) {
                sp.this.c(i, nVar, i2, z);
                return;
            }
            i iVarC = sp.this.c(i);
            if (iVarC == null) {
                sp.this.c(i, com.byazt.jb.tt.PROTOCOL_ERROR);
                nVar.x(i2);
            } else {
                iVarC.c(nVar, i2);
                if (z) {
                    iVarC.i();
                }
            }
        }

        @Override // com.byazt.kh.tt
        public void ve() throws Throwable {
            com.byazt.jb.tt ttVar;
            sp spVar;
            com.byazt.jb.tt ttVar2 = com.byazt.jb.tt.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.c.c(this);
                        while (this.c.c(false, (x.tt) this)) {
                        }
                        try {
                            sp.this.c(com.byazt.jb.tt.NO_ERROR, com.byazt.jb.tt.CANCEL);
                        } catch (IOException unused) {
                            ttVar = com.byazt.jb.tt.PROTOCOL_ERROR;
                            spVar = sp.this;
                            spVar.c(ttVar, ttVar);
                        } catch (NullPointerException unused2) {
                            ttVar = com.byazt.jb.tt.PROTOCOL_ERROR;
                            spVar = sp.this;
                            spVar.c(ttVar, ttVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            sp.this.c(ttVar2, ttVar2);
                        } catch (Exception unused3) {
                        }
                        com.byazt.kh.ve.c(this.c);
                        throw th;
                    }
                } catch (IOException unused4) {
                } catch (NullPointerException unused5) {
                } catch (Throwable th2) {
                    th = th2;
                    sp.this.c(ttVar2, ttVar2);
                    com.byazt.kh.ve.c(this.c);
                    throw th;
                }
            } catch (Exception unused6) {
            }
            com.byazt.kh.ve.c(this.c);
        }

        @Override // com.byazt.jb.x.tt
        public void c(boolean z, int i, int i2, List<com.byazt.jb.ve> list) {
            if (sp.this.uj(i)) {
                sp.this.c(i, list, z);
                return;
            }
            synchronized (sp.this) {
                i iVarC = sp.this.c(i);
                if (iVarC == null) {
                    sp spVar = sp.this;
                    if (spVar.x) {
                        return;
                    }
                    if (i <= spVar.f28687a) {
                        return;
                    }
                    if (i % 2 == spVar.sp % 2) {
                        return;
                    }
                    final i iVar = new i(i, sp.this, false, z, list);
                    sp spVar2 = sp.this;
                    spVar2.f28687a = i;
                    spVar2.uj.put(Integer.valueOf(i), iVar);
                    try {
                        sp.c.execute(new com.byazt.kh.tt("OkHttp %s stream %d", new Object[]{sp.this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.ve.1
                            @Override // com.byazt.kh.tt
                            public void ve() {
                                try {
                                    sp.this.ve.c(iVar);
                                } catch (IOException e) {
                                    com.byazt.xb.n.tt().c(4, "Http2Connection.Listener failure for " + sp.this.n, e);
                                    try {
                                        iVar.c(com.byazt.jb.tt.PROTOCOL_ERROR);
                                    } catch (IOException unused) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                    return;
                }
                iVarC.c(list);
                if (z) {
                    iVarC.i();
                }
            }
        }

        @Override // com.byazt.jb.x.tt
        public void c(int i, com.byazt.jb.tt ttVar) {
            if (sp.this.uj(i)) {
                sp.this.ve(i, ttVar);
                return;
            }
            i iVarTt = sp.this.tt(i);
            if (iVarTt != null) {
                iVarTt.ve(ttVar);
            }
        }

        @Override // com.byazt.jb.x.tt
        public void c(boolean z, yp ypVar) {
            i[] iVarArr;
            long j;
            int i;
            synchronized (sp.this) {
                int iUj = sp.this.u.uj();
                if (z) {
                    sp.this.u.c();
                }
                sp.this.u.c(ypVar);
                c(ypVar);
                int iUj2 = sp.this.u.uj();
                iVarArr = null;
                if (iUj2 == -1 || iUj2 == iUj) {
                    j = 0;
                } else {
                    j = iUj2 - iUj;
                    sp spVar = sp.this;
                    if (!spVar.yp) {
                        spVar.c(j);
                        sp.this.yp = true;
                    }
                    if (!sp.this.uj.isEmpty()) {
                        iVarArr = (i[]) sp.this.uj.values().toArray(new i[sp.this.uj.size()]);
                    }
                }
                try {
                    sp.c.execute(new com.byazt.kh.tt("OkHttp %s settings", sp.this.n) { // from class: com.byazt.jb.sp.ve.2
                        @Override // com.byazt.kh.tt
                        public void ve() {
                            sp spVar2 = sp.this;
                            spVar2.ve.c(spVar2);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
            if (iVarArr == null || j == 0) {
                return;
            }
            for (i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.c(j);
                }
            }
        }

        private void c(final yp ypVar) {
            try {
                sp.c.execute(new com.byazt.kh.tt("OkHttp %s ACK Settings", new Object[]{sp.this.n}) { // from class: com.byazt.jb.sp.ve.3
                    @Override // com.byazt.kh.tt
                    public void ve() {
                        try {
                            sp.this.m.c(ypVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.byazt.jb.x.tt
        public void c(boolean z, int i, int i2) {
            if (z) {
                t tVarVe = sp.this.ve(i);
                if (tVarVe != null) {
                    tVarVe.tt();
                    return;
                }
                return;
            }
            sp.this.c(true, i, i2, (t) null);
        }

        @Override // com.byazt.jb.x.tt
        public void c(int i, com.byazt.jb.tt ttVar, com.byazt.mk.a aVar) {
            i[] iVarArr;
            synchronized (sp.this) {
                iVarArr = (i[]) sp.this.uj.values().toArray(new i[sp.this.uj.size()]);
                sp.this.x = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.c() > i && iVar.ve()) {
                    iVar.ve(com.byazt.jb.tt.REFUSED_STREAM);
                    sp.this.tt(iVar.c());
                }
            }
        }

        @Override // com.byazt.jb.x.tt
        public void c(int i, long j) {
            if (i == 0) {
                synchronized (sp.this) {
                    sp spVar = sp.this;
                    spVar.sl += j;
                    spVar.notifyAll();
                }
                return;
            }
            i iVarC = sp.this.c(i);
            if (iVarC != null) {
                synchronized (iVarC) {
                    iVarC.c(j);
                }
            }
        }

        @Override // com.byazt.jb.x.tt
        public void c(int i, int i2, List<com.byazt.jb.ve> list) {
            sp.this.c(i2, list);
        }
    }

    public void c(long j) {
        this.sl += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void c(final int i, final com.byazt.jb.tt ttVar) {
        try {
            c.execute(new com.byazt.kh.tt("OkHttp %s stream %d", new Object[]{this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.1
                @Override // com.byazt.kh.tt
                public void ve() {
                    try {
                        sp.this.tt(i, ttVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void c(final int i, final long j) {
        try {
            c.execute(new com.byazt.kh.tt("OkHttp Window Update %s stream %d", new Object[]{this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.2
                @Override // com.byazt.kh.tt
                public void ve() {
                    try {
                        sp.this.m.c(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void c(final boolean z, final int i, final int i2, final t tVar) {
        try {
            c.execute(new com.byazt.kh.tt("OkHttp %s ping %08x%08x", new Object[]{this.n, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.byazt.jb.sp.3
                @Override // com.byazt.kh.tt
                public void ve() {
                    try {
                        sp.this.tt(z, i, i2, tVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void tt(int i, com.byazt.jb.tt ttVar) throws IOException {
        this.m.c(i, ttVar);
    }

    public void c(com.byazt.jb.tt ttVar) throws IOException {
        synchronized (this.m) {
            synchronized (this) {
                if (this.x) {
                    return;
                }
                this.x = true;
                this.m.c(this.f28687a, ttVar, com.byazt.kh.ve.c);
            }
        }
    }

    public void tt(boolean z, int i, int i2, t tVar) throws IOException {
        synchronized (this.m) {
            if (tVar != null) {
                tVar.c();
                this.m.c(z, i, i2);
            } else {
                this.m.c(z, i, i2);
            }
            throw th;
        }
    }

    public void tt() throws IOException {
        this.m.tt();
    }

    public void c(com.byazt.jb.tt ttVar, com.byazt.jb.tt ttVar2) throws IOException {
        i[] iVarArr;
        if (!my && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        t[] tVarArr = null;
        try {
            c(ttVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.uj.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (i[]) this.uj.values().toArray(new i[this.uj.size()]);
                this.uj.clear();
            }
            Map<Integer, t> map = this.rl;
            if (map != null) {
                t[] tVarArr2 = (t[]) map.values().toArray(new t[this.rl.size()]);
                this.rl = null;
                tVarArr = tVarArr2;
            }
        }
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                try {
                    iVar.c(ttVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (tVarArr != null) {
            for (t tVar : tVarArr) {
                tVar.ve();
            }
        }
        try {
            this.m.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.z.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void c(boolean z) throws IOException {
        if (z) {
            this.m.c();
            this.m.tt(this.t);
            int iUj = this.t.uj();
            if (iUj != 65535) {
                this.m.c(0, iUj - 65535);
            }
        }
        com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(this.nu, "Http2Connection");
        veVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        veVar.start();
    }

    public void c(final int i, final List<com.byazt.jb.ve> list) {
        synchronized (this) {
            if (this.rh.contains(Integer.valueOf(i))) {
                c(i, com.byazt.jb.tt.PROTOCOL_ERROR);
            } else {
                this.rh.add(Integer.valueOf(i));
                this.gt.execute(new com.byazt.kh.tt("OkHttp %s Push Request[%s]", new Object[]{this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.4
                    @Override // com.byazt.kh.tt
                    public void ve() {
                        if (sp.this.i.c(i, list)) {
                            try {
                                sp.this.m.c(i, com.byazt.jb.tt.CANCEL);
                                synchronized (sp.this) {
                                    try {
                                        sp.this.rh.remove(Integer.valueOf(i));
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void c(final int i, final List<com.byazt.jb.ve> list, final boolean z) {
        this.gt.execute(new com.byazt.kh.tt("OkHttp %s Push Headers[%s]", new Object[]{this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.5
            @Override // com.byazt.kh.tt
            public void ve() {
                boolean zC = sp.this.i.c(i, list, z);
                if (zC) {
                    try {
                        sp.this.m.c(i, com.byazt.jb.tt.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!zC && !z) {
                    return;
                }
                synchronized (sp.this) {
                    sp.this.rh.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public void c(final int i, com.byazt.mk.n nVar, final int i2, final boolean z) throws IOException {
        final com.byazt.mk.ve veVar = new com.byazt.mk.ve();
        long j = i2;
        nVar.c(j);
        nVar.c(veVar, j);
        if (veVar.tt() == j) {
            this.gt.execute(new com.byazt.kh.tt("OkHttp %s Push Data[%s]", new Object[]{this.n, Integer.valueOf(i)}) { // from class: com.byazt.jb.sp.6
                @Override // com.byazt.kh.tt
                public void ve() {
                    try {
                        boolean zC = sp.this.i.c(i, veVar, i2, z);
                        if (zC) {
                            sp.this.m.c(i, com.byazt.jb.tt.CANCEL);
                        }
                        if (!zC && !z) {
                            return;
                        }
                        synchronized (sp.this) {
                            sp.this.rh.remove(Integer.valueOf(i));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(veVar.tt() + " != " + i2);
    }
}
