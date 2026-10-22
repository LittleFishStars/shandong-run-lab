package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j {

    public static class a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f37407a = new CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void onCanceled() {
            this.f37407a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.f37407a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            this.f37407a.countDown();
        }
    }

    public static <TResult> Task<TResult> a(TResult tresult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static Task<List<Task<?>>> a(final Collection<? extends Task<?>> collection) {
        return c(collection).continueWith(new Continuation<Void, List<Task<?>>>() { // from class: com.huawei.hmf.tasks.a.j.2
            @Override // com.huawei.hmf.tasks.Continuation
            public final /* synthetic */ List<Task<?>> then(Task<Void> task) throws Exception {
                ArrayList arrayList = new ArrayList(collection.size());
                arrayList.addAll(collection);
                return arrayList;
            }
        });
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static void a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <TResult> Task<List<TResult>> b(final Collection<? extends Task<?>> collection) {
        return (Task<List<TResult>>) c(collection).continueWith(new Continuation<Void, List<TResult>>() { // from class: com.huawei.hmf.tasks.a.j.3
            @Override // com.huawei.hmf.tasks.Continuation
            public final /* synthetic */ Object then(Task<Void> task) throws Exception {
                ArrayList arrayList = new ArrayList();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Task) it.next()).getResult());
                }
                return arrayList;
            }
        });
    }

    public static Task<Void> c(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return a((Object) null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        i iVar = new i();
        e eVar = new e(collection.size(), iVar);
        for (Task<?> task : collection) {
            task.addOnSuccessListener(TaskExecutors.immediate(), eVar);
            task.addOnFailureListener(TaskExecutors.immediate(), eVar);
            task.addOnCanceledListener(TaskExecutors.immediate(), eVar);
        }
        return iVar;
    }

    public final <TResult> Task<TResult> a(Executor executor, final Callable<TResult> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (Exception e) {
                        taskCompletionSource.setException(e);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
        return taskCompletionSource.getTask();
    }
}
