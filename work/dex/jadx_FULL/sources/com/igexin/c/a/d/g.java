package com.igexin.c.a.d;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.o;
import com.igexin.push.g.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g extends BroadcastReceiver implements Comparator<f> {
    public static final long E = TimeUnit.SECONDS.toMillis(2);
    protected static final String F = "AlarmTaskSchedule.";
    protected static final String G = "AlarmTaskScheduleBak.";
    protected static final String H = "AlarmNioTaskSchedule.";
    public static final String h = "TaskService";
    public static final String i = "com.igexin.c.a.d.g";
    static final byte j = -1;
    static final byte k = 0;
    static final byte l = 1;
    static final byte m = 2;
    static final byte n = -128;
    static final byte o = 7;
    public PendingIntent A;
    public String B;
    volatile long C;
    public volatile boolean D;
    public boolean t;
    public PowerManager v;
    public AlarmManager w;
    public Intent x;
    public PendingIntent y;
    public Intent z;
    final ReentrantLock u = new ReentrantLock();
    public boolean I = false;
    final HashMap<Long, com.igexin.c.a.d.a.c> q = new HashMap<>(7);
    public final e<f> s = new e<>(this, this);
    final d r = new d();
    public final b p = new b();

    /* JADX INFO: renamed from: com.igexin.c.a.d.g$1, reason: invalid class name */
    public class AnonymousClass1 extends IntentFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f37844a;

        public AnonymousClass1(Context context) {
            this.f37844a = context;
            addAction(g.F + context.getPackageName());
            addAction(g.G + context.getPackageName());
            addAction("android.intent.action.SCREEN_OFF");
            addAction("android.intent.action.SCREEN_ON");
        }
    }

    public final class a {
        volatile int g;
        final ReentrantLock c = new ReentrantLock();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BlockingQueue<f> f37845a = new SynchronousQueue();
        final HashMap<Integer, RunnableC0849a> b = new HashMap<>();
        volatile long e = TimeUnit.SECONDS.toNanos(60);
        volatile int f = 0;
        ThreadFactory d = new b();
        volatile int h = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: com.igexin.c.a.d.g$a$a, reason: collision with other inner class name */
        public final class RunnableC0849a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BlockingQueue<f> f37846a = new LinkedBlockingQueue();
            f b;
            f c;
            volatile int d;
            volatile boolean e;

            public RunnableC0849a(f fVar) {
                this.b = fVar;
            }

            private void a() {
                this.f37846a.clear();
                this.c = null;
            }

            private void a(f fVar) {
                if (this.d == 0) {
                    this.d = fVar.C;
                }
                boolean z = true;
                while (z) {
                    try {
                        try {
                            fVar.b_();
                            fVar.o();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            if (fVar.m || !fVar.p || fVar.w == 0) {
                                fVar = null;
                                z = false;
                            }
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a(g.h + e.toString(), new Object[0]);
                            fVar.v = true;
                            fVar.E = e;
                            fVar.p();
                            fVar.l();
                            g.this.a((Object) fVar);
                            g.this.e();
                            if (!fVar.v) {
                                fVar.d_();
                            }
                            if (fVar.m || !fVar.p || fVar.w == 0) {
                            }
                        }
                    } catch (Throwable th) {
                        if (!fVar.v) {
                            fVar.d_();
                        }
                        if (fVar.m || !fVar.p || fVar.w == 0) {
                            throw th;
                        }
                    }
                }
            }

            private f b() {
                while (this.d != 0) {
                    try {
                        f fVarPoll = this.f37846a.poll(a.this.e, TimeUnit.NANOSECONDS);
                        if (fVarPoll != null) {
                            return fVarPoll;
                        }
                        if (this.f37846a.isEmpty()) {
                            ReentrantLock reentrantLock = a.this.c;
                            reentrantLock.lock();
                            try {
                                if (this.f37846a.isEmpty()) {
                                    a.this.b.remove(Integer.valueOf(this.d));
                                    this.d = 0;
                                    reentrantLock.unlock();
                                    return null;
                                }
                                reentrantLock.unlock();
                            } catch (Throwable th) {
                                reentrantLock.unlock();
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    } catch (InterruptedException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
                return null;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean zA = true;
                while (zA) {
                    try {
                        try {
                            f fVarB = this.b;
                            this.b = null;
                            while (true) {
                                if (fVarB == null) {
                                    fVarB = b();
                                    if (fVarB == null && (fVarB = a.this.b()) == null) {
                                        zA = a.this.a(this);
                                        if (!zA) {
                                            a();
                                            break;
                                        }
                                        break;
                                    }
                                }
                                this.c = null;
                                if (this.d == 0) {
                                    this.d = fVarB.C;
                                }
                                boolean z = true;
                                f fVar = fVarB;
                                while (z) {
                                    try {
                                        try {
                                            fVar.b_();
                                            fVar.o();
                                            if (!fVar.v) {
                                                fVar.d_();
                                            }
                                            if (fVar.m || !fVar.p || fVar.w == 0) {
                                                z = false;
                                                fVar = null;
                                            }
                                        } catch (Exception e) {
                                            com.igexin.c.a.c.a.a(e);
                                            com.igexin.c.a.c.a.a(g.h + e.toString(), new Object[0]);
                                            fVar.v = true;
                                            fVar.E = e;
                                            fVar.p();
                                            fVar.l();
                                            g.this.a((Object) fVar);
                                            g.this.e();
                                            if (!fVar.v) {
                                                fVar.d_();
                                            }
                                            if (fVar.m || !fVar.p || fVar.w == 0) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                        if (!fVar.v) {
                                            fVar.d_();
                                        }
                                        if (fVar.m || !fVar.p || fVar.w == 0) {
                                            throw th;
                                        }
                                    }
                                }
                                this.c = fVarB;
                                fVarB = null;
                            }
                        } catch (Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            com.igexin.c.a.c.a.a("TaskService|Worker|run()|error" + e2.toString(), new Object[0]);
                            zA = a.this.a(this);
                            if (!zA) {
                            }
                        }
                    } catch (Throwable th2) {
                        if (!a.this.a(this)) {
                            a();
                        }
                        throw th2;
                    }
                }
            }
        }

        public final class b implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final AtomicInteger f37847a = new AtomicInteger(0);

            public b() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "TS-pool-" + this.f37847a.incrementAndGet());
            }
        }

        public a() {
        }

        private void c(f fVar) {
            fVar.getClass();
            if (fVar.C != 0) {
                ReentrantLock reentrantLock = this.c;
                reentrantLock.lock();
                try {
                    RunnableC0849a runnableC0849a = this.b.get(Integer.valueOf(fVar.C));
                    if (runnableC0849a != null) {
                        runnableC0849a.f37846a.offer(fVar);
                        reentrantLock.unlock();
                        return;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            if (this.g >= this.f || !a(fVar)) {
                if (!this.f37845a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private void d(f fVar) {
            if (this.g >= this.f || !a(fVar)) {
                if (!this.f37845a.offer(fVar)) {
                    b(fVar);
                } else if (this.g == 0) {
                    a();
                }
            }
        }

        private Thread e(f fVar) {
            int i;
            RunnableC0849a runnableC0849a = new RunnableC0849a(fVar);
            if (fVar != null && (i = fVar.C) != 0) {
                this.b.put(Integer.valueOf(i), runnableC0849a);
            }
            Thread threadNewThread = this.d.newThread(runnableC0849a);
            if (threadNewThread != null) {
                this.g++;
            }
            return threadNewThread;
        }

        public final void a() {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Thread threadE = null;
                if (this.g < Math.max(this.f, 1) && !this.f37845a.isEmpty()) {
                    threadE = e(null);
                }
                reentrantLock.unlock();
                if (threadE != null) {
                    threadE.start();
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final boolean a(f fVar) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Thread threadE = this.g < this.f ? e(fVar) : null;
                reentrantLock.unlock();
                if (threadE == null) {
                    return false;
                }
                threadE.start();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final boolean a(RunnableC0849a runnableC0849a) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                int i = this.g - 1;
                this.g = i;
                if (i == 0 && !this.f37845a.isEmpty()) {
                    Thread threadE = e(null);
                    if (threadE != null) {
                        threadE.start();
                    }
                } else if (!runnableC0849a.f37846a.isEmpty()) {
                    return true;
                }
                this.b.remove(Integer.valueOf(runnableC0849a.d));
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final f b() {
            while (true) {
                try {
                    f fVarPoll = this.g > this.f ? this.f37845a.poll(this.e, TimeUnit.NANOSECONDS) : this.f37845a.take();
                    if (fVarPoll != null) {
                        return fVarPoll;
                    }
                    if (this.f37845a.isEmpty()) {
                        return null;
                    }
                } catch (InterruptedException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        }

        public final boolean b(f fVar) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                Thread threadE = this.g < this.h ? e(fVar) : null;
                reentrantLock.unlock();
                if (threadE == null) {
                    return false;
                }
                threadE.start();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f37848a = true;
        long b;
        long c;
        a d;

        public b() {
            setName("TS-processor");
        }

        private static void a() {
        }

        /* JADX WARN: Code duplicated, block: B:102:0x0067 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:103:0x005e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:106:0x0073 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:108:0x0083 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:109:0x007f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:10:0x001b A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:110:0x007b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:115:0x000d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:117:0x002d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:119:0x0141 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:120:0x0141 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:125:0x013e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:127:0x001d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:132:0x000f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:18:0x0031 A[Catch: Exception -> 0x0162, TryCatch #2 {Exception -> 0x0162, blocks: (B:14:0x0021, B:16:0x002d, B:18:0x0031, B:19:0x003a, B:21:0x0040, B:25:0x005a, B:26:0x005e, B:28:0x0063, B:29:0x0066, B:30:0x0067, B:32:0x006d, B:34:0x0073, B:36:0x007b, B:38:0x007f, B:39:0x0083, B:40:0x0087, B:42:0x008b, B:44:0x0093, B:22:0x0045, B:24:0x0055), top: B:96:0x0021, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x0040 A[Catch: Exception -> 0x0162, TRY_LEAVE, TryCatch #2 {Exception -> 0x0162, blocks: (B:14:0x0021, B:16:0x002d, B:18:0x0031, B:19:0x003a, B:21:0x0040, B:25:0x005a, B:26:0x005e, B:28:0x0063, B:29:0x0066, B:30:0x0067, B:32:0x006d, B:34:0x0073, B:36:0x007b, B:38:0x007f, B:39:0x0083, B:40:0x0087, B:42:0x008b, B:44:0x0093, B:22:0x0045, B:24:0x0055), top: B:96:0x0021, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0055 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #1 {all -> 0x0062, blocks: (B:22:0x0045, B:24:0x0055), top: B:94:0x0045, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x006d A[Catch: Exception -> 0x0162, TryCatch #2 {Exception -> 0x0162, blocks: (B:14:0x0021, B:16:0x002d, B:18:0x0031, B:19:0x003a, B:21:0x0040, B:25:0x005a, B:26:0x005e, B:28:0x0063, B:29:0x0066, B:30:0x0067, B:32:0x006d, B:34:0x0073, B:36:0x007b, B:38:0x007f, B:39:0x0083, B:40:0x0087, B:42:0x008b, B:44:0x0093, B:22:0x0045, B:24:0x0055), top: B:96:0x0021, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x0087 A[Catch: Exception -> 0x0162, TryCatch #2 {Exception -> 0x0162, blocks: (B:14:0x0021, B:16:0x002d, B:18:0x0031, B:19:0x003a, B:21:0x0040, B:25:0x005a, B:26:0x005e, B:28:0x0063, B:29:0x0066, B:30:0x0067, B:32:0x006d, B:34:0x0073, B:36:0x007b, B:38:0x007f, B:39:0x0083, B:40:0x0087, B:42:0x008b, B:44:0x0093, B:22:0x0045, B:24:0x0055), top: B:96:0x0021, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x008b A[Catch: Exception -> 0x0162, TryCatch #2 {Exception -> 0x0162, blocks: (B:14:0x0021, B:16:0x002d, B:18:0x0031, B:19:0x003a, B:21:0x0040, B:25:0x005a, B:26:0x005e, B:28:0x0063, B:29:0x0066, B:30:0x0067, B:32:0x006d, B:34:0x0073, B:36:0x007b, B:38:0x007f, B:39:0x0083, B:40:0x0087, B:42:0x008b, B:44:0x0093, B:22:0x0045, B:24:0x0055), top: B:96:0x0021, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:70:0x0132  */
        /* JADX WARN: Code duplicated, block: B:72:0x0136  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code duplicated, block: B:96:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:9:0x0019 A[DONT_INVERT] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            /*
                Method dump skipped, instruction units count: 389
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igexin.c.a.d.g.b.run():void");
        }
    }

    public g() {
        f.H = this;
    }

    private static int a(f fVar, f fVar2) {
        if (fVar.w < fVar2.w) {
            return -1;
        }
        if (fVar.w > fVar2.w) {
            return 1;
        }
        int i2 = fVar.D;
        int i3 = fVar2.D;
        if (i2 > i3) {
            return -1;
        }
        if (i2 < i3) {
            return 1;
        }
        if (fVar.x < fVar2.x) {
            return -1;
        }
        if (fVar.x > fVar2.x) {
            return 1;
        }
        return fVar.hashCode() - fVar2.hashCode();
    }

    private void a() {
        try {
            PendingIntent pendingIntent = this.y;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private void a(int i2, TimeUnit timeUnit) {
        this.p.b = TimeUnit.MILLISECONDS.convert(i2, timeUnit);
    }

    private void a(Context context) {
        if (this.I) {
            return;
        }
        if (!n.l()) {
            this.v = (PowerManager) context.getSystemService("power");
            this.D = true;
            this.w = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    this.t = ((Boolean) AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", new Class[0]).invoke(this.w, new Object[0])).booleanValue();
                } else {
                    this.t = true;
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(context);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 33) {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, anonymousClass1, com.igexin.push.core.e.ac, null);
            }
            this.B = H + context.getPackageName();
            if (i2 > 33) {
                context.registerReceiver(this, new IntentFilter(this.B), com.igexin.push.core.e.ac, null, 4);
            } else {
                context.registerReceiver(this, new IntentFilter(this.B), com.igexin.push.core.e.ac, null);
            }
            int i3 = (n.a(context) < 31 || i2 < 30) ? 134217728 : 201326592;
            this.x = new Intent(F + context.getPackageName());
            this.y = PendingIntent.getBroadcast(context, hashCode(), this.x, i3);
            hashCode();
            this.z = new Intent(this.B);
            this.A = PendingIntent.getBroadcast(context, hashCode() + 2, this.z, i3);
            hashCode();
        }
        this.p.start();
        try {
            Thread.yield();
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        this.I = true;
    }

    private static boolean a(com.igexin.c.a.d.a.e eVar, com.igexin.c.a.d.a.c cVar) {
        int iC = eVar.c();
        if (iC <= Integer.MIN_VALUE || iC >= 0) {
            if (iC < 0 || iC >= Integer.MAX_VALUE) {
                return false;
            }
            return cVar.a(eVar);
        }
        f fVar = (f) eVar;
        boolean zA = fVar.v ? false : cVar.a(eVar);
        if (zA) {
            fVar.d_();
        }
        return zA;
    }

    private boolean a(f fVar) {
        e<f> eVar = this.s;
        return eVar != null && eVar.c(fVar);
    }

    private boolean a(f fVar, boolean z, int i2, long j2, byte b2, Object obj, com.igexin.c.a.d.a.d dVar, int i3, com.igexin.c.a.d.a.g gVar) {
        fVar.getClass();
        fVar.A = i2;
        fVar.a((int) b2);
        fVar.F = obj;
        fVar.O = dVar;
        fVar.a(j2, TimeUnit.MILLISECONDS);
        fVar.a(i3, gVar);
        return a(fVar, z);
    }

    private boolean a(Class cls) {
        e<f> eVar = this.s;
        return eVar != null && eVar.a(cls);
    }

    @TargetApi(19)
    private void b(long j2) {
        if (n.l()) {
            return;
        }
        com.igexin.c.a.c.a.a("setnioalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)), new Object[0]);
        if (j2 < 0) {
            j2 = System.currentTimeMillis() + E;
        }
        try {
            try {
                if (this.t) {
                    this.w.setExact(0, j2, this.A);
                } else {
                    this.w.setAndAllowWhileIdle(0, j2, this.y);
                }
            } catch (Exception unused) {
                this.w.set(0, j2, this.A);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    private boolean b() {
        e<f> eVar = this.s;
        if (eVar == null) {
            return false;
        }
        eVar.c.clear();
        return true;
    }

    @TargetApi(19)
    public final void a(long j2) {
        if (this.D) {
            com.igexin.c.a.c.a.a("setalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2)), new Object[0]);
            if (j2 < 0) {
                j2 = System.currentTimeMillis() + E;
            }
            try {
                PendingIntent pendingIntent = this.y;
                if (pendingIntent != null) {
                    try {
                        if (this.t) {
                            this.w.setExact(0, j2, pendingIntent);
                        } else {
                            this.w.setAndAllowWhileIdle(0, j2, pendingIntent);
                        }
                    } catch (Throwable unused) {
                        this.w.set(0, j2, this.y);
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(h, th.toString());
                com.igexin.c.a.c.a.a(h + th.toString(), new Object[0]);
            }
        }
    }

    public final boolean a(com.igexin.c.a.d.a.c cVar) {
        ReentrantLock reentrantLock = this.u;
        if (reentrantLock.tryLock()) {
            try {
                if (this.q.containsKey(Long.valueOf(cVar.g()))) {
                    reentrantLock.unlock();
                    return false;
                }
                this.q.put(Long.valueOf(cVar.g()), cVar);
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new Object[0]);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        return false;
    }

    public final boolean a(f fVar, boolean z) {
        fVar.getClass();
        int iIncrementAndGet = 0;
        if (fVar.q || fVar.m) {
            return false;
        }
        e<f> eVar = this.s;
        if ((fVar instanceof com.igexin.c.a.b.f) && (((com.igexin.c.a.b.f) fVar).d instanceof o)) {
            if (z) {
                iIncrementAndGet = Integer.MAX_VALUE;
            }
        } else if (z) {
            iIncrementAndGet = eVar.d.incrementAndGet();
        }
        fVar.D = iIncrementAndGet;
        return eVar.a(fVar);
    }

    public final boolean a(f fVar, boolean z, boolean z2) {
        fVar.getClass();
        boolean z3 = false;
        if (fVar.n) {
            return false;
        }
        if (!z || z2) {
            if (z2 && z) {
                z3 = true;
            }
            return a(fVar, z3);
        }
        fVar.d();
        try {
            fVar.b_();
            fVar.o();
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            fVar.v = true;
            fVar.E = e;
            fVar.l();
            fVar.p();
            a((Object) fVar);
            e();
            return false;
        } finally {
            if (!fVar.v) {
                fVar.d_();
            }
        }
    }

    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        obj.hashCode();
        try {
            if (obj instanceof com.igexin.push.d.c.n) {
                obj.hashCode();
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        obj.hashCode();
        com.igexin.c.a.c.a.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new Object[0]);
        if (!(obj instanceof com.igexin.c.a.d.a.e)) {
            throw new ClassCastException("response Obj is not a TaskResult ");
        }
        com.igexin.c.a.d.a.e eVar = (com.igexin.c.a.d.a.e) obj;
        if (eVar.j()) {
            return false;
        }
        eVar.a(false);
        if ((obj instanceof com.igexin.push.d.b.a) || (obj instanceof com.igexin.push.d.b.b)) {
            this.r.a();
            com.igexin.c.a.c.a.a("TaskService|change to primaryQueue", new Object[0]);
        }
        this.r.a(eVar);
        return true;
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(f fVar, f fVar2) {
        f fVar3 = fVar;
        f fVar4 = fVar2;
        if (fVar3.w < fVar4.w) {
            return -1;
        }
        if (fVar3.w > fVar4.w) {
            return 1;
        }
        int i2 = fVar3.D;
        int i3 = fVar4.D;
        if (i2 > i3) {
            return -1;
        }
        if (i2 < i3) {
            return 1;
        }
        if (fVar3.x < fVar4.x) {
            return -1;
        }
        if (fVar3.x > fVar4.x) {
            return 1;
        }
        return fVar3.hashCode() - fVar4.hashCode();
    }

    public final void d() {
        try {
            PendingIntent pendingIntent = this.A;
            if (pendingIntent != null) {
                this.w.cancel(pendingIntent);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(h, th.toString());
        }
    }

    public final void e() {
        b bVar = this.p;
        if (bVar == null || bVar.isInterrupted()) {
            return;
        }
        this.p.interrupt();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0000 A[SYNTHETIC] */
    public final void f() {
        com.igexin.c.a.d.a.e eVarD;
        boolean zA;
        int iC;
        int iC2;
        boolean zA2;
        int iC3;
        while (!this.r.c() && (eVarD = this.r.d()) != null) {
            eVarD.a(true);
            ReentrantLock reentrantLock = this.u;
            reentrantLock.lock();
            try {
                if (this.q.isEmpty()) {
                    zA2 = false;
                } else {
                    long jK = eVarD.k();
                    if (jK != 0) {
                        com.igexin.c.a.d.a.c cVar = this.q.get(Long.valueOf(jK));
                        if (cVar != null) {
                            zA2 = a(eVarD, cVar);
                        } else {
                            zA2 = false;
                        }
                    } else {
                        Iterator<com.igexin.c.a.d.a.c> it = this.q.values().iterator();
                        zA = false;
                        while (it.hasNext() && !(zA = a(eVarD, it.next()))) {
                            try {
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.igexin.c.a.c.a.a(th);
                                    com.igexin.c.a.c.a.a(h, th.toString());
                                    com.igexin.c.a.c.a.a("TaskService|" + th.toString(), new Object[0]);
                                    if (!zA && (iC2 = eVarD.c()) > Integer.MIN_VALUE && iC2 < 0) {
                                    }
                                    reentrantLock.unlock();
                                    if (eVarD instanceof k) {
                                        this.r.b();
                                        com.igexin.c.a.c.a.a("TaskService|queue -> secondRespQueue", new Object[0]);
                                    }
                                } catch (Throwable th2) {
                                    if (!zA && (iC = eVarD.c()) > Integer.MIN_VALUE && iC < 0) {
                                        ((f) eVarD).d_();
                                    }
                                    reentrantLock.unlock();
                                    throw th2;
                                }
                            }
                        }
                        zA2 = zA;
                    }
                }
                if (!zA2 && (iC3 = eVarD.c()) > Integer.MIN_VALUE && iC3 < 0) {
                    ((f) eVarD).d_();
                }
            } catch (Throwable th3) {
                th = th3;
                zA = false;
            }
            reentrantLock.unlock();
            if (eVarD instanceof k) {
                this.r.b();
                com.igexin.c.a.c.a.a("TaskService|queue -> secondRespQueue", new Object[0]);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.D = true;
            com.igexin.c.a.c.a.a("screenoff", new Object[0]);
            if (this.s.g.get() > 0) {
                a(this.s.g.get());
                return;
            }
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.D = false;
            com.igexin.c.a.c.a.a("screenon", new Object[0]);
            return;
        }
        if (intent.getAction().startsWith(F) || intent.getAction().startsWith(G)) {
            Calendar.getInstance().getTime().toLocaleString();
            com.igexin.c.a.c.a.a("receivealarm|" + this.D, new Object[0]);
            e();
            return;
        }
        if (this.B.equals(intent.getAction())) {
            Calendar calendar = Calendar.getInstance();
            com.igexin.c.a.c.a.b(i, "CPU ON + NioAlarmReceiver:-> cTime; " + calendar.getTime().toLocaleString());
            try {
                com.igexin.c.a.c.a.a(h, " alarm time out #######");
                com.igexin.c.a.c.a.a("TaskService|alarm time out #######", new Object[0]);
                com.igexin.c.a.b.a.a.d.a().f();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }
}
