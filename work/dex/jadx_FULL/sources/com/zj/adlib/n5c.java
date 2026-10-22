package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zau;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n5c implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Api f43454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public zau f18359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18360a;

    public n5c(Api api, boolean z) {
        this.f43454a = api;
        this.f18360a = z;
    }

    public final void a(zau zauVar) {
        this.f18359a = zauVar;
    }

    public final zau b() {
        yw6.m(this.f18359a, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f18359a;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        b().onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        b().i(connectionResult, this.f43454a, this.f18360a);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        b().onConnectionSuspended(i);
    }
}
