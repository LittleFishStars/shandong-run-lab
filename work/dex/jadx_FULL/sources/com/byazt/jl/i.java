package com.byazt.jl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.byazt.on.a;
import com.byazt.on.sp;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 42})
public abstract class i<R extends com.byazt.on.a, W extends com.byazt.on.sp> {
    public static final String sp = "i";
    public static final Rect yp = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Rect f28698a;
    public int da;
    public boolean gt;
    public final Handler i;
    public final Set<Bitmap> m;
    public R my;
    public ByteBuffer n;
    public final Object nu;
    public W rh;
    public volatile tt rl;
    public final Set<c> t;
    public final AtomicBoolean u;
    public Map<Bitmap, Canvas> uj;
    public int ve;
    public final com.byazt.zt.tt x;
    public final Runnable z;
    public List<x<R, W>> c = new ArrayList();
    public int tt = -1;
    public Integer sl = null;

    public interface c {
        void c();

        void tt();

        void tt(ByteBuffer byteBuffer);
    }

    public enum tt {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    public i(com.byazt.zt.tt ttVar, c cVar) {
        HashSet hashSet = new HashSet();
        this.t = hashSet;
        this.u = new AtomicBoolean(true);
        this.z = new Runnable() { // from class: com.byazt.jl.i.1
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.u.get()) {
                    return;
                }
                if (!i.this.nu()) {
                    i.this.i();
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                i.this.i.postDelayed(this, Math.max(0L, i.this.rh() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                Iterator it = i.this.t.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).tt(i.this.n);
                }
            }
        };
        this.ve = 1;
        this.m = new HashSet();
        this.nu = new Object();
        this.uj = new WeakHashMap();
        this.rh = (W) uj();
        this.my = null;
        this.gt = false;
        this.rl = tt.IDLE;
        this.x = ttVar;
        if (cVar != null) {
            hashSet.add(cVar);
        }
        this.i = ((qp) com.byazt.ut.uj.getService("thread_service")).getIOHandler();
    }

    private int m() {
        Integer num = this.sl;
        return num != null ? num.intValue() : tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nu() {
        if (!da() || this.c.size() == 0) {
            return false;
        }
        if (m() <= 0 || this.da < m() - 1) {
            return true;
        }
        if (this.da == m() - 1 && this.tt < sp() - 1) {
            return true;
        }
        this.gt = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public long rh() {
        int i = this.tt + 1;
        this.tt = i;
        if (i >= sp()) {
            this.tt = 0;
            this.da++;
        }
        x<R, W> xVarC = c(this.tt);
        if (xVarC == null) {
            return 0L;
        }
        c(xVarC);
        return xVarC.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void yp() {
        this.i.removeCallbacks(this.z);
        this.c.clear();
        synchronized (this.nu) {
            for (Bitmap bitmap : this.m) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.m.clear();
        }
        if (this.n != null) {
            this.n = null;
        }
        this.uj.clear();
        try {
            if (this.my != null) {
                this.my = null;
            }
        } catch (IOException e) {
            m.c(e);
        }
        ve();
        this.rl = tt.IDLE;
        Iterator<c> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().tt();
        }
    }

    private String z() {
        return "";
    }

    public abstract void c(x<R, W> xVar);

    public boolean da() {
        return this.rl == tt.RUNNING || this.rl == tt.INITIALIZING;
    }

    public void sl() {
        this.i.post(new Runnable() { // from class: com.byazt.jl.i.8
            @Override // java.lang.Runnable
            public void run() {
                i.this.da = 0;
                i iVar = i.this;
                iVar.tt = -1;
                iVar.gt = false;
            }
        });
    }

    public int t() {
        return this.ve;
    }

    public abstract int tt();

    public abstract Rect tt(R r) throws IOException;

    public abstract W uj();

    public abstract R ve(com.byazt.on.a aVar);

    public abstract void ve();

    public Rect a() {
        if (this.f28698a == null) {
            if (this.rl == tt.FINISHING) {
                m.uj(sp, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.i.post(new Runnable() { // from class: com.byazt.jl.i.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (i.this.f28698a == null) {
                                if (i.this.my == null) {
                                    i iVar = i.this;
                                    iVar.my = iVar.ve(iVar.x.tt());
                                } else {
                                    i.this.my.d_();
                                }
                                i iVar2 = i.this;
                                iVar2.c(iVar2.tt(iVar2.my));
                            }
                        } catch (Exception e) {
                            m.c(e);
                            i.this.f28698a = i.yp;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.f28698a == null ? yp : this.f28698a;
    }

    public void i() {
        if (this.f28698a == yp) {
            return;
        }
        tt ttVar = this.rl;
        tt ttVar2 = tt.FINISHING;
        if (ttVar == ttVar2 || this.rl == tt.IDLE) {
            m.c(sp, z() + "No need to stop");
            return;
        }
        if (this.rl == tt.INITIALIZING) {
            m.uj(sp, z() + "Processing,wait for finish at " + this.rl);
        }
        this.rl = ttVar2;
        if (Looper.myLooper() == this.i.getLooper()) {
            yp();
        } else {
            this.i.post(new Runnable() { // from class: com.byazt.jl.i.7
                @Override // java.lang.Runnable
                public void run() {
                    i.this.yp();
                }
            });
        }
    }

    public void n() {
        this.i.post(new Runnable() { // from class: com.byazt.jl.i.4
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.t.size() == 0) {
                    i.this.i();
                }
            }
        });
    }

    public int sp() {
        return this.c.size();
    }

    public void tt(final c cVar) {
        this.i.post(new Runnable() { // from class: com.byazt.jl.i.3
            @Override // java.lang.Runnable
            public void run() {
                i.this.t.remove(cVar);
            }
        });
    }

    public int ve(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(a().width() / i, a().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    public void x() {
        if (this.f28698a == yp) {
            return;
        }
        if (this.rl != tt.RUNNING) {
            tt ttVar = this.rl;
            tt ttVar2 = tt.INITIALIZING;
            if (ttVar != ttVar2) {
                if (this.rl == tt.FINISHING) {
                    m.uj(sp, z() + " Processing,wait for finish at " + this.rl);
                }
                this.rl = ttVar2;
                if (Looper.myLooper() == this.i.getLooper()) {
                    c();
                    return;
                } else {
                    this.i.post(new Runnable() { // from class: com.byazt.jl.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.c();
                        }
                    });
                    return;
                }
            }
        }
        m.c(sp, z() + " Already started");
    }

    public boolean tt(int i, int i2) {
        final int iVe = ve(i, i2);
        if (iVe == this.ve) {
            return false;
        }
        final boolean zDa = da();
        this.i.removeCallbacks(this.z);
        this.i.post(new Runnable() { // from class: com.byazt.jl.i.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                i.this.yp();
                try {
                    i iVar = i.this;
                    iVar.ve = iVe;
                    iVar.c(iVar.tt(iVar.ve(iVar.x.tt())));
                    if (zDa) {
                        i.this.c();
                    }
                } catch (IOException e) {
                    m.c(e);
                }
            }
        });
        return true;
    }

    public Bitmap c(int i, int i2) {
        synchronized (this.nu) {
            try {
                Iterator<Bitmap> it = this.m.iterator();
                Bitmap bitmapCreateBitmap = null;
                while (it.hasNext()) {
                    int i3 = i * i2 * 4;
                    Bitmap next = it.next();
                    if (next != null && next.getAllocationByteCount() >= i3) {
                        it.remove();
                        if ((next.getWidth() != i || next.getHeight() != i2) && i > 0 && i2 > 0) {
                            next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                    bitmapCreateBitmap = next;
                }
                if (i <= 0 || i2 <= 0) {
                    return null;
                }
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
                } catch (Exception e) {
                    m.c(e);
                } catch (OutOfMemoryError e2) {
                    m.c(e2);
                }
                return bitmapCreateBitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Bitmap bitmap) {
        synchronized (this.nu) {
            if (bitmap != null) {
                this.m.add(bitmap);
            }
        }
    }

    public void c(final c cVar) {
        this.i.post(new Runnable() { // from class: com.byazt.jl.i.2
            @Override // java.lang.Runnable
            public void run() {
                i.this.t.add(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Rect rect) {
        this.f28698a = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.ve;
        this.n = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.rh == null) {
            this.rh = (W) uj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c() {
        this.u.compareAndSet(true, false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.c.size() == 0) {
                try {
                    R r = this.my;
                    if (r == null) {
                        this.my = (R) ve(this.x.tt());
                    } else {
                        r.d_();
                    }
                    c(tt(this.my));
                } catch (Throwable th) {
                    m.c(th);
                }
            }
            String str = sp;
            m.c(str, z() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.rl = tt.RUNNING;
            if (m() != 0 && this.gt) {
                m.c(str, z() + " No need to started");
                return;
            }
            this.tt = -1;
            this.z.run();
            Iterator<c> it = this.t.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        } catch (Throwable th2) {
            m.c(sp, z() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.rl = tt.RUNNING;
            throw th2;
        }
    }

    public x<R, W> c(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }
}
