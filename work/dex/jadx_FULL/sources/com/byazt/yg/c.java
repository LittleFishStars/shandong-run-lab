package com.byazt.yg;

import android.os.SystemClock;
import com.byazt.ia.n;
import com.byazt.mg.da;
import com.byazt.mg.yp;
import com.byazt.nr.m;
import com.byazt.uy.a;
import com.byazt.uy.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 192, 20})
public class c implements Thread.UncaughtExceptionHandler {
    public static c c;
    public Thread.UncaughtExceptionHandler tt;
    public tt uj;
    public HashSet<Thread.UncaughtExceptionHandler> ve = new HashSet<>();
    public long n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f29204a = true;

    private c() {
        ve();
    }

    public static c c() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    public static void tt() {
        try {
            c cVar = c;
            if (cVar == null) {
                da.c("CrashCatchDispatcher id not init.");
                return;
            }
            cVar.f29204a = false;
            tt veVar = c.uj;
            c = new c();
            if (veVar == null) {
                veVar = new ve(x.uj());
            }
            c.c(veVar);
        } catch (Throwable th) {
            da.c("CrashCatchDispatcher reRegister", th);
        }
    }

    private void ve() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.tt == null) {
                this.tt = defaultUncaughtExceptionHandler;
            } else {
                this.ve.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        tt ttVar;
        if (SystemClock.uptimeMillis() - this.n < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.n = SystemClock.uptimeMillis();
            if (!this.f29204a) {
                da.c("This CrashCatchDispatcher is disable");
                ve(thread, th);
                return;
            }
            boolean zC = c(thread, th);
            if (!zC) {
                ve(thread, th);
                return;
            }
            com.byazt.uy.ve veVar = com.byazt.uy.ve.JAVA;
            tt(thread, th);
            if (zC && (ttVar = this.uj) != null && ttVar.c(th)) {
                this.uj.c(jCurrentTimeMillis, thread, th);
                m.c("crash_dispatcher", "end dispose ".concat(String.valueOf(th)));
            }
            ve(thread, th);
        } catch (Throwable th2) {
            try {
                da.c(th2);
            } finally {
                ve(thread, th);
            }
        }
    }

    public void c(tt ttVar) {
        this.uj = ttVar;
    }

    private boolean c(Thread thread, Throwable th) {
        a aVarUj = x.tt().uj();
        if (aVarUj != null) {
            try {
                if (!aVarUj.c(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void ve(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.ve.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.tt.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public static void c(final String str) {
        if (str == null) {
            return;
        }
        com.byazt.gv.c.c().c(new com.byazt.gv.ve() { // from class: com.byazt.yg.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.xz.c cVar = new com.byazt.xz.c();
                    cVar.c("data", str);
                    cVar.c("userdefine", (Object) 1);
                    com.byazt.xz.c cVarC = n.c().c(com.byazt.uy.ve.CUSTOM_JAVA, cVar);
                    if (cVarC != null) {
                        com.byazt.jz.c.c().ve(cVarC.c());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void tt(Thread thread, Throwable th) {
        List<Object> listTt = x.tt().tt();
        com.byazt.uy.ve veVar = com.byazt.uy.ve.JAVA;
        Iterator<Object> it = listTt.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                yp.c(th);
            } catch (Throwable th2) {
                da.tt(th2);
            }
        }
    }
}
