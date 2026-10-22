package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class z09<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iud f46154a = new iud();

    public z09() {
    }

    public z09(@NonNull CancellationToken cancellationToken) {
        cancellationToken.b(new iqd(this));
    }

    @NonNull
    public Task<TResult> a() {
        return this.f46154a;
    }

    public void b(@NonNull Exception exc) {
        this.f46154a.y(exc);
    }

    public boolean c(@NonNull Exception exc) {
        return this.f46154a.B(exc);
    }

    public boolean d(@Nullable TResult tresult) {
        return this.f46154a.C(tresult);
    }

    public void setResult(@Nullable TResult tresult) {
        this.f46154a.z(tresult);
    }
}
