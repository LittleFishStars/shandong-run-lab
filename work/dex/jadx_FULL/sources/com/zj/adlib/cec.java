package com.zj.adlib;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cec implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f40958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d f15807a;

    public cec(d dVar, Task task) {
        this.f15807a = dVar;
        this.f40958a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f40958a.t()) {
            this.f15807a.f5845a.A();
            return;
        }
        try {
            this.f15807a.f5845a.z(this.f15807a.f31411a.a(this.f40958a));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f15807a.f5845a.y((Exception) e.getCause());
            } else {
                this.f15807a.f5845a.y(e);
            }
        } catch (Exception e2) {
            this.f15807a.f5845a.y(e2);
        }
    }
}
