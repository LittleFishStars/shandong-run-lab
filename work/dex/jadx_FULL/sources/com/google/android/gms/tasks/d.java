package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.zj.adlib.cec;
import com.zj.adlib.iud;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Continuation f31411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final iud f5845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f5846a;

    public d(@NonNull Executor executor, @NonNull Continuation continuation, @NonNull iud iudVar) {
        this.f5846a = executor;
        this.f31411a = continuation;
        this.f5845a = iudVar;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void a(@NonNull Task task) {
        this.f5846a.execute(new cec(this, task));
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
