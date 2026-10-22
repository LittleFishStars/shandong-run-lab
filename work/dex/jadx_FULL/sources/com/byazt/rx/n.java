package com.byazt.rx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.byazt.mg.da;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 46})
public class n implements Handler.Callback {
    public static Printer c;
    public static final Printer da = new Printer() { // from class: com.byazt.rx.n.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                n.c().c(str);
            } else if (str.startsWith("<<<<< Finished")) {
                n.c().tt(str);
            }
            if (n.c == null || n.c == n.da) {
                return;
            }
            n.c.println(str);
        }
    };
    public static n tt;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29001a;
    public long n;
    public boolean t;
    public int uj = 0;
    public final SparseArray<List<Runnable>> sp = new SparseArray<>();
    public final List<Printer> x = new LinkedList();
    public final List<Printer> i = new LinkedList();
    public boolean sl = false;
    public Handler ve = new Handler(sp.c().getLooper(), this);

    private n() {
        tt();
    }

    public static n c() {
        if (tt == null) {
            synchronized (n.class) {
                if (tt == null) {
                    tt = new n();
                }
            }
        }
        return tt;
    }

    private Printer n() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            da.tt(e);
            return null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (this.ve.hasMessages(0)) {
                return true;
            }
            int i = message.what;
            if (i == 0) {
                this.uj = 0;
                if (this.sp.size() != 0 && this.sp.keyAt(0) == 0) {
                    c(this.sp.valueAt(0));
                    this.uj++;
                }
            } else {
                if (i == 1) {
                    this.ve.removeMessages(2);
                    if (this.sp.size() != 0) {
                        SparseArray<List<Runnable>> sparseArray = this.sp;
                        if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                            c(this.sp.get(Integer.MAX_VALUE));
                        }
                    }
                    return true;
                }
                if (i == 2) {
                    c(this.sp.valueAt(this.uj));
                    this.uj++;
                }
            }
            if (this.uj >= this.sp.size()) {
                return true;
            }
            long jKeyAt = this.sp.keyAt(this.uj);
            if (jKeyAt != 2147483647L) {
                this.ve.sendEmptyMessageAtTime(2, this.n + jKeyAt);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public void tt() {
        if (this.sl) {
            return;
        }
        this.sl = true;
        Printer printerN = n();
        c = printerN;
        Printer printer = da;
        if (printerN == printer) {
            c = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    public void c(long j, Runnable runnable) {
        c(j, runnable, 1, 0L);
    }

    public void tt(String str) {
        this.f29001a = SystemClock.uptimeMillis();
        try {
            this.ve.removeMessages(2);
            c(this.i, str);
            this.ve.sendEmptyMessage(1);
        } catch (Exception e) {
            da.tt(e);
        }
    }

    public void c(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.sp.get(i3);
            if (linkedList == null) {
                synchronized (this.sp) {
                    linkedList = this.sp.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.sp.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    public void c(String str) {
        if (!this.t) {
            a.c(32L);
            this.t = true;
        }
        this.n = SystemClock.uptimeMillis();
        try {
            c(this.x, str);
            this.ve.sendEmptyMessage(0);
        } catch (Exception e) {
            da.c(e);
        }
    }

    private static void c(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            da.c(e);
        }
    }

    private synchronized void c(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    da.c(e);
                }
            }
        }
    }
}
