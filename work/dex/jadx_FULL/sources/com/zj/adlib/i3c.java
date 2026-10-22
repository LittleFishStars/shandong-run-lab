package com.zj.adlib;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i3c<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a3c f17131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference f17134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ResultTransform f17129a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public i3c f17132a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile ResultCallbacks f17128a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public PendingResult f42270a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f17133a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Status f17130a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17135a = false;

    public i3c(WeakReference weakReference) {
        yw6.m(weakReference, "GoogleApiClient reference must not be null");
        this.f17134a = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        this.f17131a = new a3c(this, googleApiClient != null ? googleApiClient.q() : Looper.getMainLooper());
    }

    public static final void q(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void a(Result result) {
        synchronized (this.f17133a) {
            if (!result.getStatus().isSuccess()) {
                m(result.getStatus());
                q(result);
            } else if (this.f17129a != null) {
                s2c.a().submit(new z2c(this, result));
            } else if (p()) {
                ((ResultCallbacks) yw6.l(this.f17128a)).c(result);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void b(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.f17133a) {
            boolean z = true;
            yw6.s(this.f17128a == null, "Cannot call andFinally() twice.");
            if (this.f17129a != null) {
                z = false;
            }
            yw6.s(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f17128a = resultCallbacks;
            n();
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public final <S extends Result> TransformedResult<S> c(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        i3c i3cVar;
        synchronized (this.f17133a) {
            boolean z = true;
            yw6.s(this.f17129a == null, "Cannot call then() twice.");
            if (this.f17128a != null) {
                z = false;
            }
            yw6.s(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f17129a = resultTransform;
            i3cVar = new i3c(this.f17134a);
            this.f17132a = i3cVar;
            n();
        }
        return i3cVar;
    }

    public final void k() {
        this.f17128a = null;
    }

    public final void l(PendingResult pendingResult) {
        synchronized (this.f17133a) {
            this.f42270a = pendingResult;
            n();
        }
    }

    public final void m(Status status) {
        synchronized (this.f17133a) {
            this.f17130a = status;
            o(status);
        }
    }

    @GuardedBy("mSyncToken")
    public final void n() {
        if (this.f17129a == null && this.f17128a == null) {
            return;
        }
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f17134a.get();
        if (!this.f17135a && this.f17129a != null && googleApiClient != null) {
            googleApiClient.E(this);
            this.f17135a = true;
        }
        Status status = this.f17130a;
        if (status != null) {
            o(status);
            return;
        }
        PendingResult pendingResult = this.f42270a;
        if (pendingResult != null) {
            pendingResult.g(this);
        }
    }

    public final void o(Status status) {
        synchronized (this.f17133a) {
            ResultTransform resultTransform = this.f17129a;
            if (resultTransform != null) {
                ((i3c) yw6.l(this.f17132a)).m((Status) yw6.m(resultTransform.b(status), "onFailure must not return null"));
            } else if (p()) {
                ((ResultCallbacks) yw6.l(this.f17128a)).b(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    public final boolean p() {
        return (this.f17128a == null || ((GoogleApiClient) this.f17134a.get()) == null) ? false : true;
    }
}
