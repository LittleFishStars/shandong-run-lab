package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.zrc;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    public OnCanceledListener f31413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5849a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5850a;

    public f(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f5850a = executor;
        this.f31413a = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        if (task.t()) {
            synchronized (this.f5849a) {
                if (this.f31413a == null) {
                    return;
                }
                this.f5850a.execute(new zrc(this));
            }
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.f5849a) {
            this.f31413a = null;
        }
    }
}
