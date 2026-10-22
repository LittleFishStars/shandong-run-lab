package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.h5c;
import com.zj.adlib.i3c;
import com.zj.adlib.j3c;
import com.zj.adlib.j5c;
import com.zj.adlib.l5c;
import com.zj.adlib.o5c;
import com.zj.adlib.yw6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f31223a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadLocal f5492a = new h5c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Result f5493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ResultCallback f5494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Status f5495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final a f5496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ICancelToken f5497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile i3c f5498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WeakReference f5500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f5501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CountDownLatch f5502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReference f5503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f5504a;
    public boolean b;
    public boolean c;
    public boolean d;

    @KeepName
    private l5c mResultGuardian;

    @Deprecated
    public BasePendingResult() {
        this.f5499a = new Object();
        this.f5502a = new CountDownLatch(1);
        this.f5501a = new ArrayList();
        this.f5503a = new AtomicReference();
        this.d = false;
        this.f5496a = new a(Looper.getMainLooper());
        this.f5500a = new WeakReference(null);
    }

    public static void p(@Nullable Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void b(@NonNull PendingResult.StatusListener statusListener) {
        yw6.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.f5499a) {
            if (k()) {
                statusListener.a(this.f5495a);
            } else {
                this.f5501a.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final R c() {
        yw6.k("await must not be called on the UI thread");
        yw6.s(!this.f5504a, "Result has already been consumed");
        yw6.s(this.f5498a == null, "Cannot await if then() has been called.");
        try {
            this.f5502a.await();
        } catch (InterruptedException unused) {
            j(Status.RESULT_INTERRUPTED);
        }
        yw6.s(k(), "Result is not ready.");
        return (R) l();
    }

    @NonNull
    @KeepForSdk
    public abstract R createFailedResult(@NonNull Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final R d(long j, @NonNull TimeUnit timeUnit) {
        if (j > 0) {
            yw6.k("await must not be called on the UI thread when time is greater than zero.");
        }
        yw6.s(!this.f5504a, "Result has already been consumed.");
        yw6.s(this.f5498a == null, "Cannot await if then() has been called.");
        try {
            if (!this.f5502a.await(j, timeUnit)) {
                j(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            j(Status.RESULT_INTERRUPTED);
        }
        yw6.s(k(), "Result is not ready.");
        return (R) l();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void e() {
        synchronized (this.f5499a) {
            if (!this.b && !this.f5504a) {
                ICancelToken iCancelToken = this.f5497a;
                if (iCancelToken != null) {
                    try {
                        iCancelToken.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                p(this.f5493a);
                this.b = true;
                m(createFailedResult(Status.RESULT_CANCELED));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean f() {
        boolean z;
        synchronized (this.f5499a) {
            z = this.b;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void g(@Nullable ResultCallback<? super R> resultCallback) {
        synchronized (this.f5499a) {
            try {
                if (resultCallback == null) {
                    this.f5494a = null;
                    return;
                }
                boolean z = true;
                yw6.s(!this.f5504a, "Result has already been consumed.");
                if (this.f5498a != null) {
                    z = false;
                }
                yw6.s(z, "Cannot set callbacks if then() has been called.");
                if (f()) {
                    return;
                }
                if (k()) {
                    this.f5496a.a(resultCallback, l());
                } else {
                    this.f5494a = resultCallback;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void h(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        synchronized (this.f5499a) {
            try {
                if (resultCallback == null) {
                    this.f5494a = null;
                    return;
                }
                boolean z = true;
                yw6.s(!this.f5504a, "Result has already been consumed.");
                if (this.f5498a != null) {
                    z = false;
                }
                yw6.s(z, "Cannot set callbacks if then() has been called.");
                if (f()) {
                    return;
                }
                if (k()) {
                    this.f5496a.a(resultCallback, l());
                } else {
                    this.f5494a = resultCallback;
                    a aVar = this.f5496a;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final <S extends Result> TransformedResult<S> i(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> transformedResultC;
        yw6.s(!this.f5504a, "Result has already been consumed.");
        synchronized (this.f5499a) {
            yw6.s(this.f5498a == null, "Cannot call then() twice.");
            yw6.s(this.f5494a == null, "Cannot call then() if callbacks are set.");
            yw6.s(!this.b, "Cannot call then() if result was canceled.");
            this.d = true;
            this.f5498a = new i3c(this.f5500a);
            transformedResultC = this.f5498a.c(resultTransform);
            if (k()) {
                this.f5496a.a(this.f5498a, l());
            } else {
                this.f5494a = this.f5498a;
            }
        }
        return transformedResultC;
    }

    @KeepForSdk
    @Deprecated
    public final void j(@NonNull Status status) {
        synchronized (this.f5499a) {
            if (!k()) {
                setResult(createFailedResult(status));
                this.c = true;
            }
        }
    }

    @KeepForSdk
    public final boolean k() {
        return this.f5502a.getCount() == 0;
    }

    public final Result l() {
        Result result;
        synchronized (this.f5499a) {
            yw6.s(!this.f5504a, "Result has already been consumed.");
            yw6.s(k(), "Result is not ready.");
            result = this.f5493a;
            this.f5493a = null;
            this.f5494a = null;
            this.f5504a = true;
        }
        j3c j3cVar = (j3c) this.f5503a.getAndSet(null);
        if (j3cVar != null) {
            j3cVar.f42501a.f17579a.remove(this);
        }
        return (Result) yw6.l(result);
    }

    public final void m(Result result) {
        this.f5493a = result;
        this.f5495a = result.getStatus();
        j5c j5cVar = null;
        this.f5497a = null;
        this.f5502a.countDown();
        if (this.b) {
            this.f5494a = null;
        } else {
            ResultCallback resultCallback = this.f5494a;
            if (resultCallback != null) {
                this.f5496a.removeMessages(2);
                this.f5496a.a(resultCallback, l());
            } else if (this.f5493a instanceof Releasable) {
                this.mResultGuardian = new l5c(this, j5cVar);
            }
        }
        ArrayList arrayList = this.f5501a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((PendingResult.StatusListener) arrayList.get(i)).a(this.f5495a);
        }
        this.f5501a.clear();
    }

    public final void o() {
        boolean z = true;
        if (!this.d && !((Boolean) f5492a.get()).booleanValue()) {
            z = false;
        }
        this.d = z;
    }

    public final boolean q() {
        boolean zF;
        synchronized (this.f5499a) {
            if (((GoogleApiClient) this.f5500a.get()) == null || !this.d) {
                e();
            }
            zF = f();
        }
        return zF;
    }

    public final void r(@Nullable j3c j3cVar) {
        this.f5503a.set(j3cVar);
    }

    @KeepForSdk
    public final void setCancelToken(@NonNull ICancelToken iCancelToken) {
        synchronized (this.f5499a) {
            this.f5497a = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(@NonNull R r) {
        synchronized (this.f5499a) {
            if (this.c || this.b) {
                p(r);
                return;
            }
            k();
            yw6.s(!k(), "Results have already been set");
            yw6.s(!this.f5504a, "Result has already been consumed");
            m(r);
        }
    }

    @VisibleForTesting
    public static class a<R extends Result> extends o5c {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a(@NonNull ResultCallback resultCallback, @NonNull Result result) {
            int i = BasePendingResult.f31223a;
            sendMessage(obtainMessage(1, new Pair((ResultCallback) yw6.l(resultCallback), result)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.a(result);
                    return;
                } catch (RuntimeException e) {
                    BasePendingResult.p(result);
                    throw e;
                }
            }
            if (i == 2) {
                ((BasePendingResult) message.obj).j(Status.RESULT_TIMEOUT);
                return;
            }
            Log.wtf("BasePendingResult", "Don't know how to handle message: " + i, new Exception());
        }

        public a(@NonNull Looper looper) {
            super(looper);
        }
    }

    @KeepForSdk
    @Deprecated
    public BasePendingResult(@NonNull Looper looper) {
        this.f5499a = new Object();
        this.f5502a = new CountDownLatch(1);
        this.f5501a = new ArrayList();
        this.f5503a = new AtomicReference();
        this.d = false;
        this.f5496a = new a(looper);
        this.f5500a = new WeakReference(null);
    }

    @KeepForSdk
    public BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.f5499a = new Object();
        this.f5502a = new CountDownLatch(1);
        this.f5501a = new ArrayList();
        this.f5503a = new AtomicReference();
        this.d = false;
        this.f5496a = new a(googleApiClient != null ? googleApiClient.q() : Looper.getMainLooper());
        this.f5500a = new WeakReference(googleApiClient);
    }

    @VisibleForTesting
    @KeepForSdk
    public BasePendingResult(@NonNull a<R> aVar) {
        this.f5499a = new Object();
        this.f5502a = new CountDownLatch(1);
        this.f5501a = new ArrayList();
        this.f5503a = new AtomicReference();
        this.d = false;
        this.f5496a = (a) yw6.m(aVar, "CallbackHandler must not be null");
        this.f5500a = new WeakReference(null);
    }
}
