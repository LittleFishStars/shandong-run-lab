package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class t0c extends GoogleApiClient {
    public final String b = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public t0c(String str) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void A(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void C(@NonNull FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void D(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult d() {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult e(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> f() {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void g() {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void i() {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final ConnectionResult p(@NonNull Api<?> api) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean s(@NonNull Api<?> api) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean t() {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean u() {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean v(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean w(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void z() {
        throw new UnsupportedOperationException(this.b);
    }
}
