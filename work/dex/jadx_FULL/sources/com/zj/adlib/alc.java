package com.zj.adlib;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.e;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class alc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f40552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e f15291a;

    public alc(e eVar, Task task) {
        this.f15291a = eVar;
        this.f40552a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) this.f15291a.f31412a.a(this.f40552a);
            if (task == null) {
                this.f15291a.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = b19.b;
            task.l(executor, this.f15291a);
            task.i(executor, this.f15291a);
            task.c(executor, this.f15291a);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f15291a.f5847a.y((Exception) e.getCause());
            } else {
                this.f15291a.f5847a.y(e);
            }
        } catch (Exception e2) {
            this.f15291a.f5847a.y(e2);
        }
    }
}
