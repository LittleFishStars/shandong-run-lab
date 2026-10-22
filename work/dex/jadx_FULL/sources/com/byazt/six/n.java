package com.byazt.six;

import android.text.TextUtils;
import com.byazt.nr.gt;
import com.byazt.nr.m;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 502, 46})
public class n extends ve {
    public static File c;
    public static volatile n tt;
    public AtomicBoolean ve = new AtomicBoolean(true);
    public AtomicBoolean uj = new AtomicBoolean(false);
    public boolean n = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f29023a = new AtomicBoolean(false);
    public AtomicInteger sp = new AtomicInteger(0);
    public AtomicLong x = new AtomicLong();

    private n() {
        x();
    }

    private void i() {
        if (this.sp.getAndSet(0) <= 0 || System.currentTimeMillis() - this.x.get() <= 600000) {
            return;
        }
        a();
    }

    public static File sp() {
        if (c == null) {
            try {
                File file = new File(new File(uj.c(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                c = file;
            } catch (Throwable th) {
                m.ve("TemplateManager", "getTemplateDir error", th);
            }
        }
        return c;
    }

    public static n tt() {
        if (tt == null) {
            synchronized (n.class) {
                if (tt == null) {
                    tt = new n();
                }
            }
        }
        return tt;
    }

    private void x() {
        com.byazt.or.n.tt(new com.byazt.bwm.sp("init") { // from class: com.byazt.six.n.1
            @Override // java.lang.Runnable
            public void run() {
                x.c();
                n.this.ve.set(false);
                n.this.ve();
                n.this.a();
                if (com.byazt.mf.c.c().ve() == null || !gt.c(com.byazt.mf.c.c().ve().getContext())) {
                    return;
                }
                com.byazt.mf.c.c().ve().tt().post(new Runnable() { // from class: com.byazt.six.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.byazt.mf.c.c().ve() != null) {
                            com.byazt.mf.c.c();
                        }
                    }
                });
            }
        }, 10);
    }

    public void a() {
        c(false);
    }

    public com.byazt.ku.c n() {
        return x.tt();
    }

    public boolean uj() {
        return this.n;
    }

    public void ve() {
        com.byazt.ku.c cVarTt = x.tt();
        if (cVarTt == null || !cVarTt.a()) {
            return;
        }
        boolean zC = c(cVarTt);
        if (!zC) {
            x.uj();
        }
        this.n = zC;
    }

    public boolean c(com.byazt.ku.c cVar) {
        if (cVar == null) {
            return false;
        }
        return c(cVar.c()) || c(cVar.n()) || c(cVar.getResources());
    }

    @Override // com.byazt.six.ve
    public File c() {
        return sp();
    }

    public void c(boolean z) {
        List<com.byazt.ku.c.C0458c> listC;
        boolean z2;
        if (this.ve.get()) {
            return;
        }
        try {
            if (this.uj.get()) {
                if (z) {
                    this.sp.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.uj.set(true);
            com.byazt.ku.c cVarVe = com.byazt.mf.c.c().ve().ve();
            com.byazt.ku.c cVarTt = x.tt();
            if (cVarVe != null && cVarVe.a()) {
                if (!x.tt(cVarVe)) {
                    this.uj.set(false);
                    this.x.set(System.currentTimeMillis());
                    return;
                }
                if (com.byazt.mf.c.c().ve() != null) {
                    com.byazt.mf.c.c().ve().tt().post(new Runnable() { // from class: com.byazt.six.n.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.ol.n.c().tt();
                        }
                    });
                }
                x.c(cVarVe);
                boolean zC = (cVarVe.n() == null || TextUtils.isEmpty(cVarVe.n().c())) ? false : c(cVarVe.n().c());
                if (cVarVe.c().size() != 0) {
                    listC = c(cVarVe, cVarTt);
                    z2 = listC != null;
                } else {
                    listC = null;
                    z2 = zC;
                }
                if (!zC) {
                    List<com.byazt.ku.c.C0458c> listTt = tt(cVarVe, cVarTt);
                    if (listC == null || listTt == null) {
                        listC = listTt;
                    } else {
                        listC.addAll(listTt);
                    }
                    if (listTt == null) {
                        z3 = false;
                    }
                    if (listTt == null) {
                        this.uj.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && c(cVarVe)) {
                    x.c(cVarVe);
                    x.ve();
                    tt(listC);
                }
                ve();
                this.uj.set(false);
                this.x.set(System.currentTimeMillis());
                i();
                return;
            }
            this.uj.set(false);
            c(109);
        } catch (Throwable unused) {
        }
    }
}
