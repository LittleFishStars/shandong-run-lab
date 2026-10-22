package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.zj.adlib.d5c;
import com.zj.adlib.fm1;
import com.zj.adlib.i76;
import com.zj.adlib.n5c;
import com.zj.adlib.o5c;
import com.zj.adlib.qv3;
import com.zj.adlib.r5c;
import com.zj.adlib.u15;
import com.zj.adlib.u5c;
import com.zj.adlib.yw6;
import com.zj.adlib.z5c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements zaca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Bundle f5542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Looper f5543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Api.Client f5545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p f5546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final r f5547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Lock f5550a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final r f5552b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f5549a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ConnectionResult f5544a = null;

    @Nullable
    public ConnectionResult b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5551a = false;

    @GuardedBy("mLock")
    public int K = 0;

    public d(Context context, p pVar, Lock lock, Looper looper, qv3 qv3Var, Map map, Map map2, fm1 fm1Var, Api.AbstractClientBuilder abstractClientBuilder, @Nullable Api.Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f31238a = context;
        this.f5546a = pVar;
        this.f5550a = lock;
        this.f5543a = looper;
        this.f5545a = client;
        this.f5547a = new r(context, pVar, lock, looper, qv3Var, map2, null, map4, null, arrayList2, new u5c(this, null));
        this.f5552b = new r(context, pVar, lock, looper, qv3Var, map, fm1Var, map3, abstractClientBuilder, arrayList, new z5c(this, null));
        ArrayMap arrayMap = new ArrayMap();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((Api.a) it.next(), this.f5547a);
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put((Api.a) it2.next(), this.f5552b);
        }
        this.f5548a = Collections.unmodifiableMap(arrayMap);
    }

    public static /* bridge */ /* synthetic */ void A(d dVar, int i, boolean z) {
        dVar.f5546a.a(i, z);
        dVar.b = null;
        dVar.f5544a = null;
    }

    public static /* bridge */ /* synthetic */ void B(d dVar, Bundle bundle) {
        Bundle bundle2 = dVar.f5542a;
        if (bundle2 == null) {
            dVar.f5542a = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public static /* bridge */ /* synthetic */ void C(d dVar) {
        ConnectionResult connectionResult;
        if (!r(dVar.f5544a)) {
            if (dVar.f5544a != null && r(dVar.b)) {
                dVar.f5552b.k();
                dVar.i((ConnectionResult) yw6.l(dVar.f5544a));
                return;
            }
            ConnectionResult connectionResult2 = dVar.f5544a;
            if (connectionResult2 == null || (connectionResult = dVar.b) == null) {
                return;
            }
            if (dVar.f5552b.K < dVar.f5547a.K) {
                connectionResult2 = connectionResult;
            }
            dVar.i(connectionResult2);
            return;
        }
        if (r(dVar.b) || dVar.p()) {
            int i = dVar.K;
            if (i == 1) {
                dVar.o();
            } else if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                ((p) yw6.l(dVar.f5546a)).b(dVar.f5542a);
                dVar.o();
            }
            dVar.K = 0;
            return;
        }
        ConnectionResult connectionResult3 = dVar.b;
        if (connectionResult3 != null) {
            if (dVar.K == 1) {
                dVar.o();
            } else {
                dVar.i(connectionResult3);
                dVar.f5547a.k();
            }
        }
    }

    public static boolean r(@Nullable ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    public static d t(Context context, p pVar, Lock lock, Looper looper, qv3 qv3Var, Map map, fm1 fm1Var, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.k()) {
                client = client2;
            }
            if (client2.q()) {
                arrayMap.put((Api.a) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.a) entry.getKey(), client2);
            }
        }
        yw6.s(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.a aVarB = api.b();
            if (arrayMap.containsKey(aVarB)) {
                arrayMap3.put(api, (Boolean) map2.get(api));
            } else {
                if (!arrayMap2.containsKey(aVarB)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, (Boolean) map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            n5c n5cVar = (n5c) arrayList.get(i);
            if (arrayMap3.containsKey(n5cVar.f43454a)) {
                arrayList2.add(n5cVar);
            } else {
                if (!arrayMap4.containsKey(n5cVar.f43454a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(n5cVar);
            }
        }
        return new d(context, pVar, lock, looper, qv3Var, arrayMap, arrayMap2, fm1Var, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    @Nullable
    public final PendingIntent E() {
        if (this.f5545a == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f31238a, System.identityHashCode(this.f5546a), this.f5545a.t(), d5c.f41112a | 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult a(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean b() {
        this.f5550a.lock();
        try {
            boolean z = false;
            if (this.f5547a.b() && (this.f5552b.b() || p() || this.K == 1)) {
                z = true;
            }
            return z;
        } finally {
            this.f5550a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean c() {
        this.f5550a.lock();
        try {
            return this.K == 2;
        } finally {
            this.f5550a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void d(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(u15.f19942b);
        this.f5552b.d(String.valueOf(str).concat(com.ipd.dsp.internal.i.q.a.i), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(u15.f19942b);
        this.f5547a.d(String.valueOf(str).concat(com.ipd.dsp.internal.i.q.a.i), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult e(@NonNull Api api) {
        if (i76.b(this.f5548a.get(api.b()), this.f5552b)) {
            return p() ? new ConnectionResult(4, E()) : this.f5552b.e(api);
        }
        return this.f5547a.e(api);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl f(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!q(apiMethodImpl)) {
            this.f5547a.f(apiMethodImpl);
            return apiMethodImpl;
        }
        if (p()) {
            apiMethodImpl.a(new Status(4, (String) null, E()));
            return apiMethodImpl;
        }
        this.f5552b.f(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final BaseImplementation.ApiMethodImpl g(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!q(apiMethodImpl)) {
            return this.f5547a.g(apiMethodImpl);
        }
        if (!p()) {
            return this.f5552b.g(apiMethodImpl);
        }
        apiMethodImpl.a(new Status(4, (String) null, E()));
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean h(SignInConnectionListener signInConnectionListener) {
        this.f5550a.lock();
        try {
            if ((!c() && !b()) || this.f5552b.b()) {
                return false;
            }
            this.f5549a.add(signInConnectionListener);
            if (this.K == 0) {
                this.K = 1;
            }
            this.b = null;
            this.f5552b.j();
            return true;
        } finally {
            this.f5550a.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void i(ConnectionResult connectionResult) {
        int i = this.K;
        if (i == 1) {
            o();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.f5546a.c(connectionResult);
            o();
        }
        this.K = 0;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void j() {
        this.K = 2;
        this.f5551a = false;
        this.b = null;
        this.f5544a = null;
        this.f5547a.j();
        this.f5552b.j();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void k() {
        this.b = null;
        this.f5544a = null;
        this.K = 0;
        this.f5547a.k();
        this.f5552b.k();
        o();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void l() {
        this.f5550a.lock();
        try {
            boolean zC = c();
            this.f5552b.k();
            this.b = new ConnectionResult(4);
            if (zC) {
                new o5c(this.f5543a).post(new r5c(this));
            } else {
                o();
            }
        } finally {
            this.f5550a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final ConnectionResult m() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    @GuardedBy("mLock")
    public final void n() {
        this.f5547a.n();
        this.f5552b.n();
    }

    @GuardedBy("mLock")
    public final void o() {
        Iterator it = this.f5549a.iterator();
        while (it.hasNext()) {
            ((SignInConnectionListener) it.next()).onComplete();
        }
        this.f5549a.clear();
    }

    @GuardedBy("mLock")
    public final boolean p() {
        ConnectionResult connectionResult = this.b;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    public final boolean q(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        r rVar = (r) this.f5548a.get(apiMethodImpl.t());
        yw6.m(rVar, "GoogleApiClient is not configured to use the API required for this call.");
        return rVar.equals(this.f5552b);
    }
}
