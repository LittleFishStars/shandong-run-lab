package com.byazt.qya;

import android.os.Handler;
import android.util.Log;
import com.alipay.sdk.m.o.b;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.omf.x;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 689, 46})
public class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f28991a;
    public final Handler c;
    public volatile boolean da;
    public long i;
    public final long n;
    public volatile boolean sl;
    public final tt<T> sp;
    public final Runnable t;
    public int tt;
    public final int uj;
    public final Callable<T> ve;
    public volatile Thread x;

    @com.byazt.zqa.c(c = {0, 1, 689, 151})
    public static class c<T> {
        public final Callable<T> c;
        public tt<T> tt;
        public int ve = 5;
        public long uj = 0;
        public long n = 1000;

        public c(Callable<T> callable) {
            this.c = callable;
        }

        public c<T> c(int i) {
            this.ve = i;
            return this;
        }

        public c<T> c(long j) {
            this.uj = j;
            return this;
        }

        public n<T> c() {
            return new n<>(this);
        }

        public c(Callable<T> callable, tt<T> ttVar) {
            this.c = callable;
            this.tt = ttVar;
        }
    }

    public interface tt<T> {
        boolean c(Exception exc);

        boolean c(T t);
    }

    public static boolean c(int i) {
        return i >= 500 || i == 429;
    }

    public static /* synthetic */ int n(n nVar) {
        int i = nVar.tt;
        nVar.tt = i + 1;
        return i;
    }

    private n(c<T> cVar) {
        this.c = da.ve();
        this.tt = 0;
        this.f28991a = false;
        this.i = 0L;
        this.da = false;
        this.sl = false;
        this.t = new Runnable() { // from class: com.byazt.qya.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (n.this.tt < n.this.uj && !n.this.sl) {
                        if (x.m().d()) {
                            n.this.ve();
                            return;
                        }
                        long jA = n.this.a();
                        n.n(n.this);
                        n.this.ve.call();
                        n.this.c.postDelayed(n.this.t, jA);
                    }
                } catch (Exception e) {
                    m.c(e);
                }
            }
        };
        this.ve = cVar.c;
        this.sp = cVar.tt;
        this.uj = cVar.ve;
        this.n = cVar.uj;
        this.i = cVar.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a() {
        return (long) ((this.i * Math.pow(2.0d, this.tt)) + this.n);
    }

    private void n() {
        try {
            Thread.sleep(a());
        } catch (InterruptedException unused) {
            this.f28991a = true;
        }
    }

    private void uj() {
        if (this.f28991a) {
            return;
        }
        this.tt++;
        n();
    }

    public T c() throws Exception {
        this.x = Thread.currentThread();
        this.tt = 0;
        T tCall = null;
        while (this.tt < this.uj && !this.f28991a) {
            try {
                if (x.m().d()) {
                    this.f28991a = true;
                    break;
                }
                tCall = this.ve.call();
                tt<T> ttVar = this.sp;
                if (ttVar == null || !ttVar.c(tCall)) {
                    break;
                }
                uj();
            } catch (Exception e) {
                tt<T> ttVar2 = this.sp;
                if (ttVar2 == null || !ttVar2.c(e)) {
                    Log.getStackTraceString(e);
                    throw e;
                }
                uj();
            }
        }
        return tCall;
    }

    public void tt() {
        this.c.removeCallbacks(this.t);
        if (this.tt >= this.uj || this.da) {
            return;
        }
        if (x.m().d()) {
            ve();
            return;
        }
        long jA = a();
        this.da = true;
        this.c.postDelayed(this.t, jA);
    }

    public void ve() {
        this.c.removeCallbacks(this.t);
        this.tt = 0;
        this.da = false;
        this.sl = true;
    }

    public static boolean c(Throwable th) {
        String message;
        if ((th instanceof UnknownHostException) || (th instanceof SSLException) || (th instanceof InterruptedIOException) || (th instanceof EOFException) || (th instanceof SocketException)) {
            return true;
        }
        if (!(th instanceof IOException) || (message = th.getMessage()) == null) {
            return false;
        }
        String lowerCase = message.toLowerCase();
        return lowerCase.contains("canceled") || lowerCase.contains(b.r0) || lowerCase.contains("etimedout") || lowerCase.contains("enetunreach") || lowerCase.contains("econnreset") || lowerCase.contains("connection abort") || lowerCase.contains("software caused connection abort");
    }
}
