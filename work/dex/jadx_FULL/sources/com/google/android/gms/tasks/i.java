package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.xdd;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i implements zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    public OnSuccessListener f31416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5855a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5856a;

    public i(@NonNull Executor executor, @NonNull OnSuccessListener onSuccessListener) {
        this.f5856a = executor;
        this.f31416a = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        if (task.v()) {
            synchronized (this.f5855a) {
                if (this.f31416a == null) {
                    return;
                }
                this.f5856a.execute(new xdd(this, task));
            }
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.f5855a) {
            this.f31416a = null;
        }
    }
}
