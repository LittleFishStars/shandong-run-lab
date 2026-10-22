package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.dm1;
import com.zj.adlib.dr8;
import com.zj.adlib.ex4;
import com.zj.adlib.fm1;
import com.zj.adlib.i3c;
import com.zj.adlib.k1c;
import com.zj.adlib.k3c;
import com.zj.adlib.l1c;
import com.zj.adlib.l4c;
import com.zj.adlib.m1c;
import com.zj.adlib.n1c;
import com.zj.adlib.o4c;
import com.zj.adlib.pv3;
import com.zj.adlib.up1;
import com.zj.adlib.y0c;
import com.zj.adlib.yw6;
import com.zj.adlib.z0c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p extends GoogleApiClient implements zabz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Looper f5573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Api.AbstractClientBuilder f5574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f5575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @VisibleForTesting
    public zabx f5576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zaj f5578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fm1 f5579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k3c f5580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l4c f5581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m1c f5582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pv3 f5583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f5584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f5585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Lock f5588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f5589a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map f5590b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Set f5591b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public Set f5592c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public zaca f5577a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Queue f5587a = new LinkedList();

    public p(Context context, Lock lock, Looper looper, fm1 fm1Var, pv3 pv3Var, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        this.f31250a = true != dm1.c() ? com.igexin.push.config.c.l : 10000L;
        this.b = 5000L;
        this.f5591b = new HashSet();
        this.f5575a = new b();
        this.f5584a = null;
        this.f5592c = null;
        y0c y0cVar = new y0c(this);
        this.f5578a = y0cVar;
        this.f5572a = context;
        this.f5588a = lock;
        this.f5581a = new l4c(looper, y0cVar);
        this.f5573a = looper;
        this.f5582a = new m1c(this, looper);
        this.f5583a = pv3Var;
        this.c = i;
        if (i >= 0) {
            this.f5584a = Integer.valueOf(i2);
        }
        this.f5590b = map;
        this.f5586a = map2;
        this.f5585a = arrayList;
        this.f5580a = new k3c();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f5581a.f((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f5581a.zag((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.f5579a = fm1Var;
        this.f5574a = abstractClientBuilder;
    }

    public static int H(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean zQ = false;
        boolean zK = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            zQ |= client.q();
            zK |= client.k();
        }
        if (zQ) {
            return (zK && z) ? 2 : 1;
        }
        return 3;
    }

    public static String K(int i) {
        if (i == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE";
        }
        return "SIGN_IN_MODE_OPTIONAL";
    }

    public static /* bridge */ /* synthetic */ void M(p pVar) {
        pVar.f5588a.lock();
        try {
            if (pVar.f5589a) {
                pVar.R();
            }
        } finally {
            pVar.f5588a.unlock();
        }
    }

    public static /* bridge */ /* synthetic */ void N(p pVar) {
        pVar.f5588a.lock();
        try {
            if (pVar.O()) {
                pVar.R();
            }
        } finally {
            pVar.f5588a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void A(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f5581a.f(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> B(@NonNull L l) {
        this.f5588a.lock();
        try {
            return this.f5575a.d(l, this.f5573a, "NO_TYPE");
        } finally {
            this.f5588a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void C(@NonNull FragmentActivity fragmentActivity) {
        ex4 ex4Var = new ex4((Activity) fragmentActivity);
        if (this.c < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        o4c.q(ex4Var).s(this.c);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void D(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f5581a.g(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void E(i3c i3cVar) {
        this.f5588a.lock();
        try {
            if (this.f5592c == null) {
                this.f5592c = new HashSet();
            }
            this.f5592c.add(i3cVar);
        } finally {
            this.f5588a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void F(i3c i3cVar) {
        this.f5588a.lock();
        try {
            Set set = this.f5592c;
            if (set == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (set.remove(i3cVar)) {
                this.f5588a.lock();
                try {
                    Set set2 = this.f5592c;
                    if (set2 == null) {
                        this.f5588a.unlock();
                    } else {
                        boolean z = !set2.isEmpty();
                        this.f5588a.unlock();
                        if (!z) {
                        }
                    }
                    zaca zacaVar = this.f5577a;
                    if (zacaVar != null) {
                        zacaVar.n();
                    }
                } finally {
                    this.f5588a.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            }
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    public final String J() {
        StringWriter stringWriter = new StringWriter();
        j("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @GuardedBy("mLock")
    public final boolean O() {
        if (!this.f5589a) {
            return false;
        }
        this.f5589a = false;
        this.f5582a.removeMessages(2);
        this.f5582a.removeMessages(1);
        zabx zabxVar = this.f5576a;
        if (zabxVar != null) {
            zabxVar.b();
            this.f5576a = null;
        }
        return true;
    }

    public final void P(int i) {
        Integer num = this.f5584a;
        if (num == null) {
            this.f5584a = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + K(i) + ". Mode was already set to " + K(this.f5584a.intValue()));
        }
        if (this.f5577a != null) {
            return;
        }
        boolean zQ = false;
        boolean zK = false;
        for (Api.Client client : this.f5586a.values()) {
            zQ |= client.q();
            zK |= client.k();
        }
        int iIntValue = this.f5584a.intValue();
        if (iIntValue == 1) {
            if (!zQ) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (zK) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (iIntValue == 2 && zQ) {
            this.f5577a = d.t(this.f5572a, this, this.f5588a, this.f5573a, this.f5583a, this.f5586a, this.f5579a, this.f5590b, this.f5574a, this.f5585a);
            return;
        }
        this.f5577a = new r(this.f5572a, this, this.f5588a, this.f5573a, this.f5583a, this.f5586a, this.f5579a, this.f5590b, this.f5574a, this.f5585a, this);
    }

    public final void Q(GoogleApiClient googleApiClient, dr8 dr8Var, boolean z) {
        up1.f20119a.a(googleApiClient).g(new l1c(this, dr8Var, z, googleApiClient));
    }

    @GuardedBy("mLock")
    public final void R() {
        this.f5581a.b();
        ((zaca) yw6.l(this.f5577a)).j();
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("mLock")
    public final void a(int i, boolean z) {
        if (i == 1) {
            if (!z && !this.f5589a) {
                this.f5589a = true;
                if (this.f5576a == null && !dm1.c()) {
                    try {
                        this.f5576a = this.f5583a.G(this.f5572a.getApplicationContext(), new n1c(this));
                    } catch (SecurityException unused) {
                    }
                }
                m1c m1cVar = this.f5582a;
                m1cVar.sendMessageDelayed(m1cVar.obtainMessage(1), this.f31250a);
                m1c m1cVar2 = this.f5582a;
                m1cVar2.sendMessageDelayed(m1cVar2.obtainMessage(2), this.b);
            }
            i = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f5580a.f17579a.toArray(new BasePendingResult[0])) {
            basePendingResult.j(k3c.f42738a);
        }
        this.f5581a.e(i);
        this.f5581a.a();
        if (i == 2) {
            R();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("mLock")
    public final void b(@Nullable Bundle bundle) {
        while (!this.f5587a.isEmpty()) {
            m((BaseImplementation.ApiMethodImpl) this.f5587a.remove());
        }
        this.f5581a.d(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    @GuardedBy("mLock")
    public final void c(ConnectionResult connectionResult) {
        if (!this.f5583a.l(this.f5572a, connectionResult.getErrorCode())) {
            O();
        }
        if (this.f5589a) {
            return;
        }
        this.f5581a.c(connectionResult);
        this.f5581a.a();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult d() {
        boolean z = true;
        yw6.s(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f5588a.lock();
        try {
            if (this.c >= 0) {
                if (this.f5584a == null) {
                    z = false;
                }
                yw6.s(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f5584a;
                if (num == null) {
                    this.f5584a = Integer.valueOf(H(this.f5586a.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            P(((Integer) yw6.l(this.f5584a)).intValue());
            this.f5581a.b();
            ConnectionResult connectionResultM = ((zaca) yw6.l(this.f5577a)).m();
            this.f5588a.unlock();
            return connectionResultM;
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult e(long j, @NonNull TimeUnit timeUnit) {
        yw6.s(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        yw6.m(timeUnit, "TimeUnit must not be null");
        this.f5588a.lock();
        try {
            Integer num = this.f5584a;
            if (num == null) {
                this.f5584a = Integer.valueOf(H(this.f5586a.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            P(((Integer) yw6.l(this.f5584a)).intValue());
            this.f5581a.b();
            ConnectionResult connectionResultA = ((zaca) yw6.l(this.f5577a)).a(j, timeUnit);
            this.f5588a.unlock();
            return connectionResultA;
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> f() {
        yw6.s(t(), "GoogleApiClient is not connected yet.");
        Integer num = this.f5584a;
        boolean z = true;
        if (num != null && num.intValue() == 2) {
            z = false;
        }
        yw6.s(z, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        dr8 dr8Var = new dr8(this);
        if (this.f5586a.containsKey(up1.f20117a)) {
            Q(this, dr8Var, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            z0c z0cVar = new z0c(this, atomicReference, dr8Var);
            k1c k1cVar = new k1c(this, dr8Var);
            GoogleApiClient.a aVar = new GoogleApiClient.a(this.f5572a);
            aVar.a(up1.f20118a);
            aVar.e(z0cVar);
            aVar.f(k1cVar);
            aVar.m(this.f5582a);
            GoogleApiClient googleApiClientH = aVar.h();
            atomicReference.set(googleApiClientH);
            googleApiClientH.g();
        }
        return dr8Var;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void g() {
        this.f5588a.lock();
        try {
            int i = 2;
            boolean z = false;
            if (this.c >= 0) {
                yw6.s(this.f5584a != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f5584a;
                if (num == null) {
                    this.f5584a = Integer.valueOf(H(this.f5586a.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int iIntValue = ((Integer) yw6.l(this.f5584a)).intValue();
            this.f5588a.lock();
            try {
                if (iIntValue != 3 && iIntValue != 1) {
                    if (iIntValue != 2) {
                        i = iIntValue;
                    }
                    yw6.b(z, "Illegal sign-in mode: " + i);
                    P(i);
                    R();
                    this.f5588a.unlock();
                    return;
                }
                i = iIntValue;
                yw6.b(z, "Illegal sign-in mode: " + i);
                P(i);
                R();
                this.f5588a.unlock();
                return;
            } finally {
                this.f5588a.unlock();
            }
            z = true;
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.f5572a;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void h(int i) {
        this.f5588a.lock();
        boolean z = true;
        if (i != 3 && i != 1) {
            if (i == 2) {
                i = 2;
            } else {
                z = false;
            }
        }
        try {
            yw6.b(z, "Illegal sign-in mode: " + i);
            P(i);
            R();
        } finally {
            this.f5588a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void i() {
        Lock lock;
        this.f5588a.lock();
        try {
            this.f5580a.b();
            zaca zacaVar = this.f5577a;
            if (zacaVar != null) {
                zacaVar.k();
            }
            this.f5575a.e();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.f5587a) {
                apiMethodImpl.r(null);
                apiMethodImpl.e();
            }
            this.f5587a.clear();
            if (this.f5577a == null) {
                lock = this.f5588a;
            } else {
                O();
                this.f5581a.a();
                lock = this.f5588a;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void j(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f5572a);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f5589a);
        printWriter.append(" mWorkQueue.size()=").print(this.f5587a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f5580a.f17579a.size());
        zaca zacaVar = this.f5577a;
        if (zacaVar != null) {
            zacaVar.d(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T l(@NonNull T t) {
        Lock lock;
        Api<?> apiS = t.s();
        yw6.b(this.f5586a.containsKey(t.t()), "GoogleApiClient is not configured to use " + (apiS != null ? apiS.d() : "the API") + " required for this call.");
        this.f5588a.lock();
        try {
            zaca zacaVar = this.f5577a;
            if (zacaVar == null) {
                this.f5587a.add(t);
                lock = this.f5588a;
            } else {
                t = (T) zacaVar.f(t);
                lock = this.f5588a;
            }
            lock.unlock();
            return t;
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T m(@NonNull T t) {
        Lock lock;
        Api<?> apiS = t.s();
        yw6.b(this.f5586a.containsKey(t.t()), "GoogleApiClient is not configured to use " + (apiS != null ? apiS.d() : "the API") + " required for this call.");
        this.f5588a.lock();
        try {
            zaca zacaVar = this.f5577a;
            if (zacaVar == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f5589a) {
                this.f5587a.add(t);
                while (!this.f5587a.isEmpty()) {
                    BaseImplementation.ApiMethodImpl apiMethodImpl = (BaseImplementation.ApiMethodImpl) this.f5587a.remove();
                    this.f5580a.a(apiMethodImpl);
                    apiMethodImpl.a(Status.RESULT_INTERNAL_ERROR);
                }
                lock = this.f5588a;
            } else {
                t = (T) zacaVar.g(t);
                lock = this.f5588a;
            }
            lock.unlock();
            return t;
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final <C extends Api.Client> C o(@NonNull Api.a<C> aVar) {
        C c = (C) this.f5586a.get(aVar);
        yw6.m(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final ConnectionResult p(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        Lock lock;
        this.f5588a.lock();
        try {
            if (!t() && !this.f5589a) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.f5586a.containsKey(api.b())) {
                throw new IllegalArgumentException(api.d() + " was never registered with GoogleApiClient");
            }
            ConnectionResult connectionResultE = ((zaca) yw6.l(this.f5577a)).e(api);
            if (connectionResultE != null) {
                this.f5588a.unlock();
                return connectionResultE;
            }
            if (this.f5589a) {
                connectionResult = ConnectionResult.RESULT_SUCCESS;
                lock = this.f5588a;
            } else {
                Log.w("GoogleApiClientImpl", J());
                Log.wtf("GoogleApiClientImpl", api.d() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                connectionResult = new ConnectionResult(8, null);
                lock = this.f5588a;
            }
            lock.unlock();
            return connectionResult;
        } catch (Throwable th) {
            this.f5588a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper q() {
        return this.f5573a;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean r(@NonNull Api<?> api) {
        return this.f5586a.containsKey(api.b());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f5581a.zag(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean s(@NonNull Api<?> api) {
        Api.Client client;
        return t() && (client = (Api.Client) this.f5586a.get(api.b())) != null && client.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean t() {
        zaca zacaVar = this.f5577a;
        return zacaVar != null && zacaVar.b();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean u() {
        zaca zacaVar = this.f5577a;
        return zacaVar != null && zacaVar.c();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f5581a.zai(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean v(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f5581a.h(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean w(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f5581a.i(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean x(SignInConnectionListener signInConnectionListener) {
        zaca zacaVar = this.f5577a;
        return zacaVar != null && zacaVar.h(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void y() {
        zaca zacaVar = this.f5577a;
        if (zacaVar != null) {
            zacaVar.l();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void z() {
        i();
        g();
    }
}
