package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.o7d;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h implements zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    public OnFailureListener f31415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5853a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5854a;

    public h(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f5854a = executor;
        this.f31415a = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        if (task.v() || task.t()) {
            return;
        }
        synchronized (this.f5853a) {
            if (this.f31415a == null) {
                return;
            }
            this.f5854a.execute(new o7d(this, task));
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.f5853a) {
            this.f31415a = null;
        }
    }
}
