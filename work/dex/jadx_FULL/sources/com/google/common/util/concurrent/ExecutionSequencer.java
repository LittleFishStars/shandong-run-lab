package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReference<ListenableFuture<Void>> f6532a = new AtomicReference<>(f.n());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f32367a = new d(null);

    public enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {

        @CheckForNull
        Executor delegate;

        @CheckForNull
        ExecutionSequencer sequencer;

        @CheckForNull
        Thread submitting;

        @CheckForNull
        Runnable task;

        public /* synthetic */ TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer, a aVar) {
            this(executor, executionSequencer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.sequencer;
                Objects.requireNonNull(executionSequencer);
                d dVar = executionSequencer.f32367a;
                if (dVar.f6537a == this.submitting) {
                    this.sequencer = null;
                    com.google.common.base.i.g0(dVar.f32371a == null);
                    dVar.f32371a = runnable;
                    Executor executor = this.delegate;
                    Objects.requireNonNull(executor);
                    dVar.f6538a = executor;
                    this.delegate = null;
                } else {
                    Executor executor2 = this.delegate;
                    Objects.requireNonNull(executor2);
                    this.delegate = null;
                    this.task = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread threadCurrentThread = Thread.currentThread();
            a aVar = null;
            if (threadCurrentThread != this.submitting) {
                Runnable runnable = this.task;
                Objects.requireNonNull(runnable);
                this.task = null;
                runnable.run();
                return;
            }
            d dVar = new d(aVar);
            dVar.f6537a = threadCurrentThread;
            ExecutionSequencer executionSequencer = this.sequencer;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.f32367a = dVar;
            this.sequencer = null;
            try {
                Runnable runnable2 = this.task;
                Objects.requireNonNull(runnable2);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = dVar.f32371a;
                    boolean z = true;
                    boolean z2 = runnable3 != null;
                    Executor executor = dVar.f6538a;
                    if (executor == null) {
                        z = false;
                    }
                    if (!z || !z2) {
                        dVar.f6537a = null;
                        return;
                    } else {
                        dVar.f32371a = null;
                        dVar.f6538a = null;
                        executor.execute(runnable3);
                    }
                }
            } catch (Throwable th) {
                dVar.f6537a = null;
                throw th;
            }
        }

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements AsyncCallable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f32368a;

        public a(ExecutionSequencer executionSequencer, Callable callable) {
            this.f32368a = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            return f.m(this.f32368a.call());
        }

        public String toString() {
            return this.f32368a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements AsyncCallable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncCallable f32369a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TaskNonReentrantExecutor f6533a;

        public b(ExecutionSequencer executionSequencer, TaskNonReentrantExecutor taskNonReentrantExecutor, AsyncCallable asyncCallable) {
            this.f6533a = taskNonReentrantExecutor;
            this.f32369a = asyncCallable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            return !this.f6533a.trySetStarted() ? f.k() : this.f32369a.call();
        }

        public String toString() {
            return this.f32369a.toString();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskNonReentrantExecutor f32370a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ListenableFuture f6534a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TrustedListenableFutureTask f6535a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ o f6536a;
        public final /* synthetic */ ListenableFuture b;

        public c(ExecutionSequencer executionSequencer, TrustedListenableFutureTask trustedListenableFutureTask, o oVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
            this.f6535a = trustedListenableFutureTask;
            this.f6536a = oVar;
            this.f6534a = listenableFuture;
            this.b = listenableFuture2;
            this.f32370a = taskNonReentrantExecutor;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6535a.isDone()) {
                this.f6536a.setFuture(this.f6534a);
            } else if (this.b.isCancelled() && this.f32370a.trySetCancelled()) {
                this.f6535a.cancel(false);
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Runnable f32371a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Thread f6537a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Executor f6538a;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static ExecutionSequencer c() {
        return new ExecutionSequencer();
    }

    public <T> ListenableFuture<T> d(Callable<T> callable, Executor executor) {
        com.google.common.base.i.E(callable);
        com.google.common.base.i.E(executor);
        return e(new a(this, callable), executor);
    }

    public <T> ListenableFuture<T> e(AsyncCallable<T> asyncCallable, Executor executor) {
        com.google.common.base.i.E(asyncCallable);
        com.google.common.base.i.E(executor);
        TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this, null);
        b bVar = new b(this, taskNonReentrantExecutor, asyncCallable);
        o oVarA = o.A();
        ListenableFuture<Void> andSet = this.f6532a.getAndSet(oVarA);
        TrustedListenableFutureTask trustedListenableFutureTaskI = TrustedListenableFutureTask.I(bVar);
        andSet.addListener(trustedListenableFutureTaskI, taskNonReentrantExecutor);
        ListenableFuture<T> listenableFutureQ = f.q(trustedListenableFutureTaskI);
        c cVar = new c(this, trustedListenableFutureTaskI, oVarA, andSet, listenableFutureQ, taskNonReentrantExecutor);
        listenableFutureQ.addListener(cVar, j.c());
        trustedListenableFutureTaskI.addListener(cVar, j.c());
        return listenableFutureQ;
    }
}
