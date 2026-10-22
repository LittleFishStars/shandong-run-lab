package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.fm1;
import com.zj.adlib.pv3;
import com.zj.adlib.yw6;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, zaj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static volatile Executor f31288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Account f5673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fm1 f5674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f5675a;

    @VisibleForTesting
    @KeepForSdk
    public GmsClient(@NonNull Context context, @NonNull Handler handler, int i, @NonNull fm1 fm1Var) {
        super(context, handler, GmsClientSupervisor.b(context), pv3.x(), i, null, null);
        this.f5674a = (fm1) yw6.l(fm1Var);
        this.f5673a = fm1Var.b();
        this.f5675a = U(fm1Var.e());
    }

    public final Set U(@NonNull Set set) {
        Set<Scope> setValidateScopes = validateScopes(set);
        Iterator<Scope> it = setValidateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setValidateScopes;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    @KeepForSdk
    public Feature[] c() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    @KeepForSdk
    public Set<Scope> f() {
        return q() ? this.f5675a : Collections.emptySet();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    public final Executor getBindServiceExecutor() {
        return null;
    }

    @NonNull
    @KeepForSdk
    public final fm1 getClientSettings() {
        return this.f5674a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    @KeepForSdk
    public final Set<Scope> getScopes() {
        return this.f5675a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    public final Account v() {
        return this.f5673a;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> validateScopes(@NonNull Set<Scope> set) {
        return set;
    }

    @KeepForSdk
    public GmsClient(@NonNull Context context, @NonNull Looper looper, int i, @NonNull fm1 fm1Var) {
        this(context, looper, GmsClientSupervisor.b(context), pv3.x(), i, fm1Var, null, null);
    }

    @KeepForSdk
    @Deprecated
    public GmsClient(@NonNull Context context, @NonNull Looper looper, int i, @NonNull fm1 fm1Var, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i, fm1Var, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    @KeepForSdk
    public GmsClient(@NonNull Context context, @NonNull Looper looper, int i, @NonNull fm1 fm1Var, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.b(context), pv3.x(), i, fm1Var, (ConnectionCallbacks) yw6.l(connectionCallbacks), (OnConnectionFailedListener) yw6.l(onConnectionFailedListener));
    }

    @VisibleForTesting
    public GmsClient(@NonNull Context context, @NonNull Looper looper, @NonNull GmsClientSupervisor gmsClientSupervisor, @NonNull pv3 pv3Var, int i, @NonNull fm1 fm1Var, @Nullable ConnectionCallbacks connectionCallbacks, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, pv3Var, i, connectionCallbacks == null ? null : new a(connectionCallbacks), onConnectionFailedListener == null ? null : new b(onConnectionFailedListener), fm1Var.m());
        this.f5674a = fm1Var;
        this.f5673a = fm1Var.b();
        this.f5675a = U(fm1Var.e());
    }
}
