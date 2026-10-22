package com.byazt.ty;

import android.os.Process;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.w.a;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TTVideoEngine.PLAYER_OPTION_OUTPUT_LOG, 20})
public class c implements tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.h.c f29080a;
    public final InputStream c;
    public com.byazt.h.c da;
    public com.byazt.h.c i;
    public int m;
    public com.byazt.h.c sl;
    public com.byazt.h.c sp;
    public volatile boolean t;
    public final int tt;
    public volatile boolean u;
    public final int ve;
    public com.byazt.h.c x;
    public volatile Throwable yp;
    public volatile Future z;
    public final Object uj = new Object();
    public final Object n = new Object();
    public final Runnable nu = new Runnable() { // from class: com.byazt.ty.c.1
        @Override // java.lang.Runnable
        public void run() {
            com.byazt.h.c cVarUj;
            Process.setThreadPriority(10);
            do {
                try {
                    cVarUj = c.this.uj();
                    cVarUj.ve = c.this.c.read(cVarUj.c);
                    c.this.ve(cVarUj);
                } catch (Throwable th) {
                    try {
                        c.this.yp = th;
                        m.c(th);
                        synchronized (c.this.n) {
                            c.this.u = true;
                            c.this.n.notify();
                            a.c(c.this.c);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (c.this.n) {
                            c.this.u = true;
                            c.this.n.notify();
                            a.c(c.this.c);
                            throw th2;
                        }
                    }
                }
            } while (cVarUj.ve != -1);
            synchronized (c.this.n) {
                c.this.u = true;
                c.this.n.notify();
            }
            a.c(c.this.c);
        }
    };

    public c(InputStream inputStream, int i, int i2) throws Throwable {
        this.c = inputStream;
        this.tt = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.ve = i2;
        ve();
    }

    private void a() throws BaseException {
        Throwable th = this.yp;
        if (th != null) {
            if (th instanceof com.byazt.h.m) {
                throw new BaseException(1068, "async reader closed!");
            }
            a.c(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private com.byazt.h.c n() throws BaseException, InterruptedException {
        com.byazt.h.c cVar;
        com.byazt.h.c cVar2 = this.sl;
        if (cVar2 != null) {
            this.sl = cVar2.uj;
            cVar2.uj = null;
            return cVar2;
        }
        synchronized (this.n) {
            cVar = this.i;
            if (cVar == null) {
                do {
                    if (this.u) {
                        a();
                    }
                    this.n.wait();
                    cVar = this.i;
                } while (cVar == null);
            }
            this.sl = cVar.uj;
            this.da = null;
            this.i = null;
            cVar.uj = null;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.h.c uj() throws InterruptedException, com.byazt.h.m {
        int i;
        com.byazt.h.c cVar = this.x;
        if (cVar != null) {
            if (this.t) {
                throw new com.byazt.h.m("");
            }
            this.x = cVar.uj;
            cVar.uj = null;
            return cVar;
        }
        synchronized (this.uj) {
            if (this.t) {
                throw new com.byazt.h.m("");
            }
            com.byazt.h.c cVar2 = this.f29080a;
            if (cVar2 == null && (i = this.m) < this.ve) {
                this.m = i + 1;
                return new com.byazt.h.c(this.tt);
            }
            while (cVar2 == null) {
                this.uj.wait();
                if (this.t) {
                    throw new com.byazt.h.m("");
                }
                cVar2 = this.f29080a;
            }
            this.x = cVar2.uj;
            this.sp = null;
            this.f29080a = null;
            cVar2.uj = null;
            return cVar2;
        }
    }

    private void ve() throws Throwable {
        this.z = com.byazt.zz.ve.nu().submit(this.nu);
    }

    @Override // com.byazt.ty.tt
    public void tt() {
        synchronized (this.uj) {
            this.t = true;
            this.uj.notify();
        }
        Future future = this.z;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(com.byazt.h.c cVar) {
        synchronized (this.n) {
            com.byazt.h.c cVar2 = this.da;
            if (cVar2 == null) {
                this.da = cVar;
                this.i = cVar;
                this.n.notify();
            } else {
                cVar2.uj = cVar;
                this.da = cVar;
            }
        }
    }

    @Override // com.byazt.ty.tt
    public com.byazt.h.c c() throws BaseException, InterruptedException {
        return n();
    }

    @Override // com.byazt.ty.tt
    public void c(com.byazt.h.c cVar) {
        tt(cVar);
    }

    private void tt(com.byazt.h.c cVar) {
        synchronized (this.uj) {
            com.byazt.h.c cVar2 = this.sp;
            if (cVar2 == null) {
                this.sp = cVar;
                this.f29080a = cVar;
                this.uj.notify();
            } else {
                cVar2.uj = cVar;
                this.sp = cVar;
            }
        }
    }
}
