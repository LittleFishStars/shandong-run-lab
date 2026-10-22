package com.google.android.gms.tasks;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.zj.adlib.b19;
import com.zj.adlib.gvd;
import com.zj.adlib.iud;
import com.zj.adlib.l6c;
import com.zj.adlib.obc;
import com.zj.adlib.p7c;
import com.zj.adlib.v7c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    public static <TResult> TResult a(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        yw6.j();
        yw6.m(task, "Task must not be null");
        if (task.u()) {
            return (TResult) m(task);
        }
        b bVar = new b(null);
        n(task, bVar);
        bVar.a();
        return (TResult) m(task);
    }

    public static <TResult> TResult b(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        yw6.j();
        yw6.m(task, "Task must not be null");
        yw6.m(timeUnit, "TimeUnit must not be null");
        if (task.u()) {
            return (TResult) m(task);
        }
        b bVar = new b(null);
        n(task, bVar);
        if (bVar.b(j, timeUnit)) {
            return (TResult) m(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static <TResult> Task<TResult> c() {
        iud iudVar = new iud();
        iudVar.A();
        return iudVar;
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(b19.f40656a, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> d(@NonNull Exception exc) {
        iud iudVar = new iud();
        iudVar.y(exc);
        return iudVar;
    }

    @NonNull
    public static <TResult> Task<TResult> e(TResult tresult) {
        iud iudVar = new iud();
        iudVar.z(tresult);
        return iudVar;
    }

    @NonNull
    public static Task<Void> f(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return e(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        iud iudVar = new iud();
        c cVar = new c(collection.size(), iudVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            n(it2.next(), cVar);
        }
        return iudVar;
    }

    @NonNull
    public static Task<Void> g(@Nullable Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? e(null) : f(Arrays.asList(taskArr));
    }

    @NonNull
    public static Task<List<Task<?>>> h(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return e(Collections.emptyList());
        }
        return f(collection).p(b19.f40656a, new v7c(collection));
    }

    @NonNull
    public static Task<List<Task<?>>> i(@Nullable Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? e(Collections.emptyList()) : h(Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> j(@Nullable Collection<? extends Task> collection) {
        if (collection == null || collection.isEmpty()) {
            return e(Collections.emptyList());
        }
        return (Task<List<TResult>>) f(collection).n(b19.f40656a, new p7c(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> k(@Nullable Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? e(Collections.emptyList()) : j(Arrays.asList(taskArr));
    }

    @NonNull
    public static <T> Task<T> l(@NonNull Task<T> task, long j, @NonNull TimeUnit timeUnit) {
        yw6.m(task, "Task must not be null");
        yw6.b(j > 0, "Timeout must be positive");
        yw6.m(timeUnit, "TimeUnit must not be null");
        final obc obcVar = new obc();
        final z09 z09Var = new z09(obcVar);
        final l6c l6cVar = new l6c(Looper.getMainLooper());
        l6cVar.postDelayed(new Runnable() { // from class: com.zj.adlib.tud
            @Override // java.lang.Runnable
            public final void run() {
                z09Var.c(new TimeoutException());
            }
        }, timeUnit.toMillis(j));
        task.e(new OnCompleteListener() { // from class: com.zj.adlib.avd
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                l6c l6cVar2 = l6cVar;
                z09 z09Var2 = z09Var;
                obc obcVar2 = obcVar;
                l6cVar2.removeCallbacksAndMessages(null);
                if (task2.v()) {
                    z09Var2.d(task2.r());
                } else {
                    if (task2.t()) {
                        obcVar2.c();
                        return;
                    }
                    Exception excQ = task2.q();
                    excQ.getClass();
                    z09Var2.c(excQ);
                }
            }
        });
        return z09Var.a();
    }

    public static Object m(@NonNull Task task) throws ExecutionException {
        if (task.v()) {
            return task.r();
        }
        if (task.t()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.q());
    }

    public static void n(Task task, zzae zzaeVar) {
        Executor executor = b19.b;
        task.l(executor, zzaeVar);
        task.i(executor, zzaeVar);
        task.c(executor, zzaeVar);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        yw6.m(executor, "Executor must not be null");
        yw6.m(callable, "Callback must not be null");
        iud iudVar = new iud();
        executor.execute(new gvd(iudVar, callable));
        return iudVar;
    }
}
