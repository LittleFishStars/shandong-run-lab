package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f31418a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLock")
    public Queue f5859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("mLock")
    public boolean f5860a;

    public final void a(@NonNull zzq zzqVar) {
        synchronized (this.f31418a) {
            if (this.f5859a == null) {
                this.f5859a = new ArrayDeque();
            }
            this.f5859a.add(zzqVar);
        }
    }

    public final void b(@NonNull Task task) {
        zzq zzqVar;
        synchronized (this.f31418a) {
            if (this.f5859a != null && !this.f5860a) {
                this.f5860a = true;
                while (true) {
                    synchronized (this.f31418a) {
                        zzqVar = (zzq) this.f5859a.poll();
                        if (zzqVar == null) {
                            this.f5860a = false;
                            return;
                        }
                    }
                    zzqVar.a(task);
                }
            }
        }
    }
}
