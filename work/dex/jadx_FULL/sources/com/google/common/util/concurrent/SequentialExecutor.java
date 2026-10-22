package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.RetainedWith;
import com.zj.adlib.bv9;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class SequentialExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32382a = Logger.getLogger(SequentialExecutor.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f6553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("queue")
    public final Deque<Runnable> f6552a = new ArrayDeque();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("queue")
    public WorkerRunningState f6550a = WorkerRunningState.IDLE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("queue")
    public long f6549a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @RetainedWith
    public final b f6551a = new b(this, null);

    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f32383a;

        public a(SequentialExecutor sequentialExecutor, Runnable runnable) {
            this.f32383a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f32383a.run();
        }

        public String toString() {
            return this.f32383a.toString();
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Runnable f6554a;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        
            if (r1 == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        
            r9.f6554a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        
            r4 = com.google.common.util.concurrent.SequentialExecutor.f32382a;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r9.f6554a);
            r8 = new java.lang.StringBuilder(r6.length() + 35);
            r8.append("Exception while executing runnable ");
            r8.append(r6);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
        
            r9.f6554a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b() {
            boolean z = false;
            boolean zInterrupted = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.this.f6552a) {
                        if (!z) {
                            WorkerRunningState workerRunningState = SequentialExecutor.this.f6550a;
                            WorkerRunningState workerRunningState2 = WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                SequentialExecutor.d(SequentialExecutor.this);
                                SequentialExecutor.this.f6550a = workerRunningState2;
                                z = true;
                            }
                        }
                        Runnable runnable = (Runnable) SequentialExecutor.this.f6552a.poll();
                        this.f6554a = runnable;
                        if (runnable == null) {
                            SequentialExecutor.this.f6550a = WorkerRunningState.IDLE;
                        }
                    }
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                    this.f6554a = null;
                } catch (Throwable th) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.f6552a) {
                    SequentialExecutor.this.f6550a = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f6554a;
            if (runnable != null) {
                String strValueOf = String.valueOf(runnable);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
                sb.append("SequentialExecutorWorker{running=");
                sb.append(strValueOf);
                sb.append("}");
                return sb.toString();
            }
            String strValueOf2 = String.valueOf(SequentialExecutor.this.f6550a);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 32);
            sb2.append("SequentialExecutorWorker{state=");
            sb2.append(strValueOf2);
            sb2.append("}");
            return sb2.toString();
        }

        public /* synthetic */ b(SequentialExecutor sequentialExecutor, a aVar) {
            this();
        }
    }

    public SequentialExecutor(Executor executor) {
        this.f6553a = (Executor) com.google.common.base.i.E(executor);
    }

    public static /* synthetic */ long d(SequentialExecutor sequentialExecutor) {
        long j = sequentialExecutor.f6549a;
        sequentialExecutor.f6549a = 1 + j;
        return j;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        WorkerRunningState workerRunningState;
        com.google.common.base.i.E(runnable);
        synchronized (this.f6552a) {
            WorkerRunningState workerRunningState2 = this.f6550a;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j = this.f6549a;
                a aVar = new a(this, runnable);
                this.f6552a.add(aVar);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.f6550a = workerRunningState3;
                boolean z = true;
                try {
                    this.f6553a.execute(this.f6551a);
                    if (this.f6550a != workerRunningState3) {
                        return;
                    }
                    synchronized (this.f6552a) {
                        if (this.f6549a == j && this.f6550a == workerRunningState3) {
                            this.f6550a = workerRunningState;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.f6552a) {
                        WorkerRunningState workerRunningState4 = this.f6550a;
                        if ((workerRunningState4 != WorkerRunningState.IDLE && workerRunningState4 != WorkerRunningState.QUEUING) || !this.f6552a.removeLastOccurrence(aVar)) {
                            z = false;
                        }
                        if (!(e instanceof RejectedExecutionException) || z) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.f6552a.add(runnable);
        }
    }

    public String toString() {
        int iIdentityHashCode = System.identityHashCode(this);
        String strValueOf = String.valueOf(this.f6553a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
        sb.append("SequentialExecutor@");
        sb.append(iIdentityHashCode);
        sb.append(bv9.b);
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
