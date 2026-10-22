package com.byazt.iq;

import com.byazt.eg.da;
import com.byazt.eg.eo;
import com.byazt.eg.gt;
import com.byazt.eg.gu;
import com.byazt.eg.m;
import com.byazt.jb.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 91})
public final class sp {
    public static final /* synthetic */ boolean uj = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public eo f28663a;
    public final com.byazt.eg.c c;
    public int da;
    public final a i;
    public a.c n;
    public ve sl;
    public final da sp;
    public boolean t;
    public final com.byazt.eg.n tt;
    public boolean u;
    public final m ve;
    public final Object x;
    public boolean yp;
    public com.byazt.yx.ve z;

    @com.byazt.zqa.c(c = {0, 1, 179, 180})
    public static final class c extends WeakReference<sp> {
        public final Object c;

        public c(sp spVar, Object obj) {
            super(spVar);
            this.c = obj;
        }
    }

    public sp(da daVar, com.byazt.eg.c cVar, com.byazt.eg.n nVar, m mVar, Object obj) throws IOException {
        this.sp = daVar;
        this.c = cVar;
        this.tt = nVar;
        this.ve = mVar;
        this.i = new a(cVar, x(), nVar, mVar);
        this.x = obj;
    }

    private Socket sp() {
        if (!uj && !Thread.holdsLock(this.sp)) {
            throw new AssertionError();
        }
        ve veVar = this.sl;
        if (veVar == null || !veVar.c) {
            return null;
        }
        return c(false, false, true);
    }

    private uj x() {
        return com.byazt.kh.c.c.c(this.sp);
    }

    public boolean a() {
        if (this.f28663a != null) {
            return true;
        }
        a.c cVar = this.n;
        return (cVar != null && cVar.c()) || this.i.c();
    }

    public com.byazt.yx.ve c(gu guVar, gt.c cVar, boolean z) {
        try {
            com.byazt.yx.ve veVarC = c(cVar.tt(), cVar.ve(), cVar.uj(), guVar.rh(), z).c(guVar, cVar, this);
            synchronized (this.sp) {
                this.z = veVarC;
            }
            return veVarC;
        } catch (IOException e) {
            throw new n(e);
        }
    }

    public void n() {
        com.byazt.yx.ve veVar;
        ve veVar2;
        synchronized (this.sp) {
            this.yp = true;
            veVar = this.z;
            veVar2 = this.sl;
        }
        if (veVar != null) {
            veVar.ve();
        } else if (veVar2 != null) {
            veVar2.tt();
        }
    }

    public String toString() {
        ve veVarTt = tt();
        return veVarTt != null ? veVarTt.toString() : this.c.toString();
    }

    public synchronized ve tt() {
        return this.sl;
    }

    public void uj() {
        Socket socketC;
        synchronized (this.sp) {
            socketC = c(true, false, false);
        }
        com.byazt.kh.ve.c(socketC);
    }

    public void ve() {
        Socket socketC;
        synchronized (this.sp) {
            socketC = c(false, true, false);
        }
        com.byazt.kh.ve.c(socketC);
    }

    private void tt(ve veVar) {
        int size = veVar.uj.size();
        for (int i = 0; i < size; i++) {
            if (veVar.uj.get(i).get() == this) {
                veVar.uj.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private ve c(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        while (true) {
            ve veVarC = c(i, i2, i3, z);
            synchronized (this.sp) {
                if (veVarC.tt == 0) {
                    return veVarC;
                }
                if (veVarC.c(z2)) {
                    return veVarC;
                }
                uj();
            }
        }
    }

    private ve c(int i, int i2, int i3, boolean z) throws IOException {
        Socket socketSp;
        ve veVar;
        Socket socketC;
        eo eoVarTt;
        boolean z2;
        boolean z3;
        a.c cVar;
        synchronized (this.sp) {
            if (!this.u) {
                if (this.z == null) {
                    if (!this.yp) {
                        socketSp = sp();
                        veVar = this.sl;
                        socketC = null;
                        if (veVar == null) {
                            veVar = null;
                        }
                        if (veVar == null) {
                            com.byazt.kh.c.c.c(this.sp, this.c, this, null);
                            ve veVar2 = this.sl;
                            if (veVar2 != null) {
                                z2 = true;
                                veVar = veVar2;
                                eoVarTt = null;
                            } else {
                                eoVarTt = this.f28663a;
                            }
                        } else {
                            eoVarTt = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        com.byazt.kh.ve.c(socketSp);
        if (veVar != null) {
            return veVar;
        }
        if (eoVarTt != null || ((cVar = this.n) != null && cVar.c())) {
            z3 = false;
        } else {
            this.n = this.i.tt();
            z3 = true;
        }
        synchronized (this.sp) {
            if (this.yp) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<eo> listVe = this.n.ve();
                int size = listVe.size();
                for (int i4 = 0; i4 < size; i4++) {
                    eo eoVar = listVe.get(i4);
                    com.byazt.kh.c.c.c(this.sp, this.c, this, eoVar);
                    ve veVar3 = this.sl;
                    if (veVar3 != null) {
                        this.f28663a = eoVar;
                        z2 = true;
                        veVar = veVar3;
                        break;
                    }
                }
            }
            if (!z2) {
                if (eoVarTt == null) {
                    eoVarTt = this.n.tt();
                }
                this.f28663a = eoVarTt;
                this.da = 0;
                veVar = new ve(this.sp, eoVarTt);
                c(veVar, false);
            }
        }
        if (z2) {
            return veVar;
        }
        veVar.c(i, i2, i3, z, this.tt, this.ve);
        x().tt(veVar.c());
        synchronized (this.sp) {
            this.t = true;
            com.byazt.kh.c.c.tt(this.sp, veVar);
            if (veVar.n()) {
                socketC = com.byazt.kh.c.c.c(this.sp, this.c, this);
                veVar = this.sl;
            }
        }
        com.byazt.kh.ve.c(socketC);
        return veVar;
    }

    public void c(boolean z, com.byazt.yx.ve veVar, long j, IOException iOException) {
        Socket socketC;
        synchronized (this.sp) {
            if (veVar != null) {
                if (veVar == this.z) {
                    if (!z) {
                        this.sl.tt++;
                    }
                    socketC = c(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.z + " but was " + veVar);
        }
        com.byazt.kh.ve.c(socketC);
        if (iOException != null) {
            this.ve.c(this.tt, iOException);
        }
    }

    public com.byazt.yx.ve c() {
        com.byazt.yx.ve veVar;
        synchronized (this.sp) {
            veVar = this.z;
        }
        return veVar;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    private Socket c(boolean z, boolean z2, boolean z3) {
        Socket socketVe;
        if (!uj && !Thread.holdsLock(this.sp)) {
            throw new AssertionError();
        }
        if (z3) {
            this.z = null;
        }
        if (z2) {
            this.u = true;
        }
        ve veVar = this.sl;
        if (veVar == null) {
            return null;
        }
        if (z) {
            veVar.c = true;
        }
        if (this.z != null) {
            return null;
        }
        if (!this.u && !veVar.c) {
            return null;
        }
        tt(veVar);
        if (this.sl.uj.isEmpty()) {
            this.sl.n = System.nanoTime();
            if (com.byazt.kh.c.c.c(this.sp, this.sl)) {
                socketVe = this.sl.ve();
            } else {
                socketVe = null;
            }
        } else {
            socketVe = null;
        }
        this.sl = null;
        return socketVe;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    public void c(IOException iOException) {
        boolean z;
        Socket socketC;
        synchronized (this.sp) {
            if (iOException instanceof z) {
                com.byazt.jb.tt ttVar = ((z) iOException).c;
                com.byazt.jb.tt ttVar2 = com.byazt.jb.tt.REFUSED_STREAM;
                if (ttVar == ttVar2) {
                    this.da++;
                }
                if (ttVar != ttVar2 || this.da > 1) {
                    this.f28663a = null;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                ve veVar = this.sl;
                if (veVar == null || (veVar.n() && !(iOException instanceof com.byazt.jb.c))) {
                    z = false;
                } else {
                    if (this.sl.tt == 0) {
                        eo eoVar = this.f28663a;
                        if (eoVar != null && iOException != null) {
                            this.i.c(eoVar, iOException);
                        }
                        this.f28663a = null;
                    }
                    z = true;
                }
            }
            socketC = c(z, false, true);
        }
        com.byazt.kh.ve.c(socketC);
    }

    public void c(ve veVar, boolean z) {
        if (!uj && !Thread.holdsLock(this.sp)) {
            throw new AssertionError();
        }
        if (this.sl == null) {
            this.sl = veVar;
            this.t = z;
            veVar.uj.add(new c(this, this.x));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket c(ve veVar) {
        if (!uj && !Thread.holdsLock(this.sp)) {
            throw new AssertionError();
        }
        if (this.z == null && this.sl.uj.size() == 1) {
            Reference<sp> reference = this.sl.uj.get(0);
            Socket socketC = c(true, false, false);
            this.sl = veVar;
            veVar.uj.add(reference);
            return socketC;
        }
        throw new IllegalStateException();
    }
}
