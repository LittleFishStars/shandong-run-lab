package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.zj.adlib.fm1;
import com.zj.adlib.n5c;
import com.zj.adlib.qv3;
import com.zj.adlib.u15;
import com.zj.adlib.yw6;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r implements zaca, zau {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Api.AbstractClientBuilder f5594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p f5595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final q f5596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotOnlyInitialized
    public volatile zabf f5597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zabz f5598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final fm1 f5599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qv3 f5600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Condition f5602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Lock f5603a;
    public final Map c;
    public final Map b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ConnectionResult f5593a = null;

    public r(Context context, p pVar, Lock lock, Looper looper, qv3 qv3Var, Map map, @Nullable fm1 fm1Var, Map map2, @Nullable Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList, zabz zabzVar) {
        this.f31252a = context;
        this.f5603a = lock;
        this.f5600a = qv3Var;
        this.f5601a = map;
        this.f5599a = fm1Var;
        this.c = map2;
        this.f5594a = abstractClientBuilder;
        this.f5595a = pVar;
        this.f5598a = zabzVar;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((n5c) arrayList.get(i)).a(this);
        }
        this.f5596a = new q(this, looper);
        this.f5602a = lock.newCondition();
        this.f5597a = new o(this);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult a(long j, TimeUnit timeUnit) {
        j();
        long nanos = timeUnit.toNanos(j);
        while (this.f5597a instanceof n) {
            if (nanos <= 0) {
                k();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f5602a.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (this.f5597a instanceof g) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f5593a;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean b() {
        return this.f5597a instanceof g;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean c() {
        return this.f5597a instanceof n;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void d(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        String strConcat = String.valueOf(str).concat(com.ipd.dsp.internal.i.q.a.i);
        printWriter.append((CharSequence) str).append("mState=").println(this.f5597a);
        for (Api api : this.c.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.d()).println(u15.f19942b);
            ((Api.Client) yw6.l((Api.Client) this.f5601a.get(api.b()))).dump(strConcat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult e(@NonNull Api api) {
        Api.a aVarB = api.b();
        if (!this.f5601a.containsKey(aVarB)) {
            return null;
        }
        if (((Api.Client) this.f5601a.get(aVarB)).isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.b.containsKey(aVarB)) {
            return (ConnectionResult) this.b.get(aVarB);
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl f(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.o();
        this.f5597a.d(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl g(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.o();
        return this.f5597a.e(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean h(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void i(@NonNull ConnectionResult connectionResult, @NonNull Api api, boolean z) {
        this.f5603a.lock();
        try {
            this.f5597a.a(connectionResult, api, z);
        } finally {
            this.f5603a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void j() {
        this.f5597a.g();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void k() {
        if (this.f5597a.h()) {
            this.b.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void l() {
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult m() {
        j();
        while (this.f5597a instanceof n) {
            try {
                this.f5602a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.f5597a instanceof g) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f5593a;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void n() {
        if (this.f5597a instanceof g) {
            ((g) this.f5597a).j();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        this.f5603a.lock();
        try {
            this.f5597a.b(bundle);
        } finally {
            this.f5603a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.f5603a.lock();
        try {
            this.f5597a.c(i);
        } finally {
            this.f5603a.unlock();
        }
    }

    public final void q() {
        this.f5603a.lock();
        try {
            this.f5595a.O();
            this.f5597a = new g(this);
            this.f5597a.f();
            this.f5602a.signalAll();
        } finally {
            this.f5603a.unlock();
        }
    }

    public final void r() {
        this.f5603a.lock();
        try {
            this.f5597a = new n(this, this.f5599a, this.c, this.f5600a, this.f5594a, this.f5603a, this.f31252a);
            this.f5597a.f();
            this.f5602a.signalAll();
        } finally {
            this.f5603a.unlock();
        }
    }

    public final void s(@Nullable ConnectionResult connectionResult) {
        this.f5603a.lock();
        try {
            this.f5593a = connectionResult;
            this.f5597a = new o(this);
            this.f5597a.f();
            this.f5602a.signalAll();
        } finally {
            this.f5603a.unlock();
        }
    }

    public final void t(zabg zabgVar) {
        this.f5596a.sendMessage(this.f5596a.obtainMessage(1, zabgVar));
    }

    public final void u(RuntimeException runtimeException) {
        this.f5596a.sendMessage(this.f5596a.obtainMessage(2, runtimeException));
    }
}
