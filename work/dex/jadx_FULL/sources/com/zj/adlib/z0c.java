package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.p;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z0c implements GoogleApiClient.ConnectionCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f46156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ dr8 f20950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AtomicReference f20951a;

    public z0c(p pVar, AtomicReference atomicReference, dr8 dr8Var) {
        this.f46156a = pVar;
        this.f20951a = atomicReference;
        this.f20950a = dr8Var;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        this.f46156a.Q((GoogleApiClient) yw6.l((GoogleApiClient) this.f20951a.get()), this.f20950a, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
