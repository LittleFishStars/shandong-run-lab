package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.szc;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    public OnCompleteListener f31414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5851a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5852a;

    public g(@NonNull Executor executor, @NonNull OnCompleteListener onCompleteListener) {
        this.f5852a = executor;
        this.f31414a = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        synchronized (this.f5851a) {
            if (this.f31414a == null) {
                return;
            }
            this.f5852a.execute(new szc(this, task));
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.f5851a) {
            this.f31414a = null;
        }
    }
}
