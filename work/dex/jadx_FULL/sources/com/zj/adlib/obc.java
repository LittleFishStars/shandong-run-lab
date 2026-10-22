package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class obc extends CancellationToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iud f43715a = new iud();

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean a() {
        return this.f43715a.u();
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken b(@NonNull OnTokenCanceledListener onTokenCanceledListener) {
        this.f43715a.l(b19.f40656a, new m6c(this, onTokenCanceledListener));
        return this;
    }

    public final void c() {
        this.f43715a.C(null);
    }
}
