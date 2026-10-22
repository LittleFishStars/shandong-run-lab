package com.zj.adlib;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class c06 implements Api.Client, ServiceConnection {
    public static final String j = "c06";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final ComponentName f40873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f15663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f15664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IBinder f15665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConnectionCallbacks f15666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnConnectionFailedListener f15667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15668a;

    @Nullable
    public final String f;

    @Nullable
    public final String g;

    @Nullable
    public String h;

    @Nullable
    public String i;

    @KeepForSdk
    public c06(@NonNull Context context, @NonNull Looper looper, @NonNull ComponentName componentName, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, null, null, componentName, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @Nullable
    public final IBinder a() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Feature[] c() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final void d(@NonNull String str) {
        x();
        this.h = str;
        disconnect();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final void disconnect() {
        x();
        String.valueOf(this.f15665a);
        try {
            this.f15663a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f15668a = false;
        this.f15665a = null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void dump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void e(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Set<Scope> f() {
        return Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void g(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean i() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final boolean isConnected() {
        x();
        return this.f15665a != null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final boolean isConnecting() {
        x();
        return this.f15668a;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @WorkerThread
    public final void j(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        x();
        String.valueOf(this.f15665a);
        if (isConnected()) {
            try {
                d("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f40873a;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f).setAction(this.g);
            }
            boolean zBindService = this.f15663a.bindService(intent, this, GmsClientSupervisor.a());
            this.f15668a = zBindService;
            if (!zBindService) {
                this.f15665a = null;
                this.f15667a.onConnectionFailed(new ConnectionResult(16));
            }
            String.valueOf(this.f15665a);
        } catch (SecurityException e) {
            this.f15668a = false;
            this.f15665a = null;
            throw e;
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean k() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final int l() {
        return 0;
    }

    public final /* synthetic */ void m() {
        this.f15668a = false;
        this.f15665a = null;
        this.f15666a.onConnectionSuspended(1);
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Feature[] n() {
        return new Feature[0];
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull final IBinder iBinder) {
        this.f15664a.post(new Runnable() { // from class: com.zj.adlib.m2c
            @Override // java.lang.Runnable
            public final void run() {
                this.f18118a.v(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.f15664a.post(new Runnable() { // from class: com.zj.adlib.l2c
            @Override // java.lang.Runnable
            public final void run() {
                this.f42982a.m();
            }
        });
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final String p() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        yw6.l(this.f40873a);
        return this.f40873a.getPackageName();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean q() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @Nullable
    public final String r() {
        return this.h;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @NonNull
    public final Intent t() {
        return new Intent();
    }

    @Nullable
    @KeepForSdk
    @WorkerThread
    public IBinder u() {
        x();
        return this.f15665a;
    }

    public final /* synthetic */ void v(IBinder iBinder) {
        this.f15668a = false;
        this.f15665a = iBinder;
        String.valueOf(iBinder);
        this.f15666a.onConnected(new Bundle());
    }

    public final void w(@Nullable String str) {
        this.i = str;
    }

    @WorkerThread
    public final void x() {
        if (Thread.currentThread() != this.f15664a.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r6 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c06(Context context, Looper looper, @Nullable String str, @Nullable String str2, @Nullable ComponentName componentName, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.f15668a = false;
        this.h = null;
        this.f15663a = context;
        this.f15664a = new o5c(looper);
        this.f15666a = connectionCallbacks;
        this.f15667a = onConnectionFailedListener;
        if (str != null && str2 != null) {
            if (componentName == null) {
                componentName = null;
                this.f = str;
                this.g = str2;
                this.f40873a = componentName;
                return;
            }
            throw new AssertionError("Must specify either package or component, but not both");
        }
    }

    @KeepForSdk
    public c06(@NonNull Context context, @NonNull Looper looper, @NonNull String str, @NonNull String str2, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, str, str2, null, connectionCallbacks, onConnectionFailedListener);
    }
}
