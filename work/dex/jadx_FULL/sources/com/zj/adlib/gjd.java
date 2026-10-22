package com.zj.adlib;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gjd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f41924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ j f16799a;

    public gjd(j jVar, Task task) {
        this.f16799a = jVar;
        this.f41924a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task taskA = this.f16799a.f31417a.a(this.f41924a.r());
            if (taskA == null) {
                this.f16799a.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = b19.b;
            taskA.l(executor, this.f16799a);
            taskA.i(executor, this.f16799a);
            taskA.c(executor, this.f16799a);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f16799a.onFailure((Exception) e.getCause());
            } else {
                this.f16799a.onFailure(e);
            }
        } catch (CancellationException unused) {
            this.f16799a.onCanceled();
        } catch (Exception e2) {
            this.f16799a.onFailure(e2);
        }
    }
}
