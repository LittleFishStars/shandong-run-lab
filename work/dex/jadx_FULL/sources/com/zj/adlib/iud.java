package com.zj.adlib;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.d;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.h;
import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class iud<TResult> extends Task<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLock")
    public Exception f17282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLock")
    public boolean f17284a;

    @Nullable
    @GuardedBy("mLock")
    public Object b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile boolean f17285b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f17283a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f42449a = new k();

    public final boolean A() {
        synchronized (this.f17283a) {
            if (this.f17284a) {
                return false;
            }
            this.f17284a = true;
            this.f17285b = true;
            this.f42449a.b(this);
            return true;
        }
    }

    public final boolean B(@NonNull Exception exc) {
        yw6.m(exc, "Exception must not be null");
        synchronized (this.f17283a) {
            if (this.f17284a) {
                return false;
            }
            this.f17284a = true;
            this.f17282a = exc;
            this.f42449a.b(this);
            return true;
        }
    }

    public final boolean C(@Nullable Object obj) {
        synchronized (this.f17283a) {
            if (this.f17284a) {
                return false;
            }
            this.f17284a = true;
            this.b = obj;
            this.f42449a.b(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    public final void D() {
        yw6.s(this.f17284a, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    public final void E() {
        if (this.f17285b) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    @GuardedBy("mLock")
    public final void F() {
        if (this.f17284a) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    public final void G() {
        synchronized (this.f17283a) {
            if (this.f17284a) {
                this.f42449a.b(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> a(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        f fVar = new f(b19.f40656a, onCanceledListener);
        this.f42449a.a(fVar);
        l.k(activity).l(fVar);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> b(@NonNull OnCanceledListener onCanceledListener) {
        c(b19.f40656a, onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> c(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f42449a.a(new f(executor, onCanceledListener));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> d(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        g gVar = new g(b19.f40656a, onCompleteListener);
        this.f42449a.a(gVar);
        l.k(activity).l(gVar);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> e(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f42449a.a(new g(b19.f40656a, onCompleteListener));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> f(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f42449a.a(new g(executor, onCompleteListener));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> g(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        h hVar = new h(b19.f40656a, onFailureListener);
        this.f42449a.a(hVar);
        l.k(activity).l(hVar);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> h(@NonNull OnFailureListener onFailureListener) {
        i(b19.f40656a, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> i(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f42449a.a(new h(executor, onFailureListener));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> j(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        i iVar = new i(b19.f40656a, onSuccessListener);
        this.f42449a.a(iVar);
        l.k(activity).l(iVar);
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> k(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        l(b19.f40656a, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final Task<TResult> l(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.f42449a.a(new i(executor, onSuccessListener));
        G();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> m(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return n(b19.f40656a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> n(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        iud iudVar = new iud();
        this.f42449a.a(new d(executor, continuation, iudVar));
        G();
        return iudVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> o(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return p(b19.f40656a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> p(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        iud iudVar = new iud();
        this.f42449a.a(new e(executor, continuation, iudVar));
        G();
        return iudVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public final Exception q() {
        Exception exc;
        synchronized (this.f17283a) {
            exc = this.f17282a;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult r() {
        TResult tresult;
        synchronized (this.f17283a) {
            D();
            E();
            Exception exc = this.f17282a;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = (TResult) this.b;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult s(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f17283a) {
            D();
            E();
            if (cls.isInstance(this.f17282a)) {
                throw cls.cast(this.f17282a);
            }
            Exception exc = this.f17282a;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            tresult = (TResult) this.b;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean t() {
        return this.f17285b;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean u() {
        boolean z;
        synchronized (this.f17283a) {
            z = this.f17284a;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean v() {
        boolean z;
        synchronized (this.f17283a) {
            z = false;
            if (this.f17284a && !this.f17285b && this.f17282a == null) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> w(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        Executor executor = b19.f40656a;
        iud iudVar = new iud();
        this.f42449a.a(new j(executor, successContinuation, iudVar));
        G();
        return iudVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> x(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        iud iudVar = new iud();
        this.f42449a.a(new j(executor, successContinuation, iudVar));
        G();
        return iudVar;
    }

    public final void y(@NonNull Exception exc) {
        yw6.m(exc, "Exception must not be null");
        synchronized (this.f17283a) {
            F();
            this.f17284a = true;
            this.f17282a = exc;
        }
        this.f42449a.b(this);
    }

    public final void z(@Nullable Object obj) {
        synchronized (this.f17283a) {
            F();
            this.f17284a = true;
            this.b = obj;
        }
        this.f42449a.b(this);
    }
}
