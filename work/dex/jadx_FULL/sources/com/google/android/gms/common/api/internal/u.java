package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.zj.adlib.i3c;
import com.zj.adlib.t0c;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u extends t0c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotOnlyInitialized
    public final GoogleApi f31255a;

    public u(GoogleApi googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f31255a = googleApi;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void E(i3c i3cVar) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void F(i3c i3cVar) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.f31255a.u();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T l(@NonNull T t) {
        return (T) this.f31255a.l(t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T m(@NonNull T t) {
        return (T) this.f31255a.r(t);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper q() {
        return this.f31255a.v();
    }
}
