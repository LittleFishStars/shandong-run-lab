package com.zj.adlib;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.a;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r0c extends zap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArraySet f44338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f19211a;

    @VisibleForTesting
    public r0c(LifecycleFragment lifecycleFragment, a aVar, pv3 pv3Var) {
        super(lifecycleFragment, pv3Var);
        this.f44338a = new ArraySet();
        this.f19211a = aVar;
        ((LifecycleCallback) this).f31226a.addCallback("ConnectionlessLifecycleHelper", this);
    }

    @MainThread
    public static void r(Activity activity, a aVar, c90 c90Var) {
        LifecycleFragment lifecycleFragmentB = LifecycleCallback.b(activity);
        r0c r0cVar = (r0c) lifecycleFragmentB.getCallbackOrNull("ConnectionlessLifecycleHelper", r0c.class);
        if (r0cVar == null) {
            r0cVar = new r0c(lifecycleFragmentB, aVar, pv3.x());
        }
        yw6.m(c90Var, "ApiKey cannot be null");
        r0cVar.f44338a.add(c90Var);
        aVar.d(r0cVar);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void g() {
        super.g();
        s();
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i() {
        super.i();
        s();
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        this.f19211a.e(this);
    }

    public final ArraySet q() {
        return this.f44338a;
    }

    public final void s() {
        if (this.f44338a.isEmpty()) {
            return;
        }
        this.f19211a.d(this);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        this.f19211a.M(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        this.f19211a.b();
    }
}
