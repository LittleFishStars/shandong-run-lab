package com.zj.adlib;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zap;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i2c extends zap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z09 f42263a;

    public i2c(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, pv3.x());
        this.f42263a = new z09();
        ((LifecycleCallback) this).f31226a.addCallback("GmsAvailabilityHelper", this);
    }

    public static i2c q(@NonNull Activity activity) {
        LifecycleFragment lifecycleFragmentB = LifecycleCallback.b(activity);
        i2c i2cVar = (i2c) lifecycleFragmentB.getCallbackOrNull("GmsAvailabilityHelper", i2c.class);
        if (i2cVar == null) {
            return new i2c(lifecycleFragmentB);
        }
        if (i2cVar.f42263a.a().u()) {
            i2cVar.f42263a = new z09();
        }
        return i2cVar;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f() {
        super.f();
        this.f42263a.c(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    public final Task r() {
        return this.f42263a.a();
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        String errorMessage = connectionResult.getErrorMessage();
        if (errorMessage == null) {
            errorMessage = "Error connecting to Google Play services";
        }
        this.f42263a.b(new ApiException(new Status(connectionResult, errorMessage, connectionResult.getErrorCode())));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        Activity lifecycleActivity = ((LifecycleCallback) this).f31226a.getLifecycleActivity();
        if (lifecycleActivity == null) {
            this.f42263a.c(new ApiException(new Status(8)));
            return;
        }
        int iJ = ((zap) this).f5615a.j(lifecycleActivity);
        if (iJ == 0) {
            this.f42263a.d(null);
        } else {
            if (this.f42263a.a().u()) {
                return;
            }
            p(new ConnectionResult(iJ, null), 0);
        }
    }
}
