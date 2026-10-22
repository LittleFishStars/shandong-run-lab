package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.v;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class ListenerCallQueue<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32376a = Logger.getLogger(ListenerCallQueue.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<a<L>> f6539a = Collections.synchronizedList(new ArrayList());

    public interface Event<L> {
        void call(L l);
    }

    public static final class a<L> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final L f32377a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Executor f6541a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("this")
        public boolean f6542a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("this")
        public final Queue<Event<L>> f6540a = v.d();

        @GuardedBy("this")
        public final Queue<Object> b = v.d();

        public a(L l, Executor executor) {
            this.f32377a = (L) com.google.common.base.i.E(l);
            this.f6541a = (Executor) com.google.common.base.i.E(executor);
        }

        public synchronized void a(Event<L> event, Object obj) {
            this.f6540a.add(event);
            this.b.add(obj);
        }

        public void b() {
            boolean z;
            synchronized (this) {
                if (this.f6542a) {
                    z = false;
                } else {
                    z = true;
                    this.f6542a = true;
                }
            }
            if (z) {
                try {
                    this.f6541a.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.f6542a = false;
                        Logger logger = ListenerCallQueue.f32376a;
                        Level level = Level.SEVERE;
                        String strValueOf = String.valueOf(this.f32377a);
                        String strValueOf2 = String.valueOf(this.f6541a);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 42 + strValueOf2.length());
                        sb.append("Exception while running callbacks for ");
                        sb.append(strValueOf);
                        sb.append(" on ");
                        sb.append(strValueOf2);
                        logger.log(level, sb.toString(), (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x006a */
        /* JADX WARN: Code duplicated, block: B:27:0x006f  */
        /* JADX WARN: Code duplicated, block: B:37:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        
            r2.call(r10.f32377a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r4 = com.google.common.util.concurrent.ListenerCallQueue.f32376a;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r10.f32377a);
            r3 = java.lang.String.valueOf(r3);
            r8 = new java.lang.StringBuilder((r6.length() + 37) + r3.length());
            r8.append("Exception while executing callback: ");
            r8.append(r6);
            r8.append(" ");
            r8.append(r3);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            boolean z;
            Throwable th;
            while (true) {
                boolean z2 = true;
                try {
                    synchronized (this) {
                        try {
                            com.google.common.base.i.g0(this.f6542a);
                            Event<L> eventPoll = this.f6540a.poll();
                            Object objPoll = this.b.poll();
                            if (eventPoll == null) {
                                this.f6542a = false;
                                try {
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                }
                            }
                        } catch (Throwable th3) {
                            z = true;
                            th = th3;
                        }
                        while (true) {
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        boolean z3 = z;
                        th = th4;
                        z2 = z3;
                        if (z2) {
                            synchronized (this) {
                                this.f6542a = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (z2) {
                        synchronized (this) {
                            this.f6542a = false;
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public void b(L l, Executor executor) {
        com.google.common.base.i.F(l, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        com.google.common.base.i.F(executor, "executor");
        this.f6539a.add(new a<>(l, executor));
    }

    public void c() {
        for (int i = 0; i < this.f6539a.size(); i++) {
            this.f6539a.get(i).b();
        }
    }

    public void d(Event<L> event) {
        f(event, event);
    }

    public void e(Event<L> event, String str) {
        f(event, str);
    }

    public final void f(Event<L> event, Object obj) {
        com.google.common.base.i.F(event, "event");
        com.google.common.base.i.F(obj, "label");
        synchronized (this.f6539a) {
            Iterator<a<L>> it = this.f6539a.iterator();
            while (it.hasNext()) {
                it.next().a(event, obj);
            }
        }
    }
}
