package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.zj.adlib.c90;
import com.zj.adlib.e5c;
import com.zj.adlib.gb0;
import com.zj.adlib.i76;
import com.zj.adlib.o2c;
import com.zj.adlib.q0c;
import com.zj.adlib.q1c;
import com.zj.adlib.r1c;
import com.zj.adlib.r4c;
import com.zj.adlib.t1c;
import com.zj.adlib.v1c;
import com.zj.adlib.x1c;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotOnlyInitialized
    public final Api.Client f5604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ a f5605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final zact f5606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c90 f5607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final q0c f5608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Queue f5611a = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f5612a = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5610a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f5609a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public ConnectionResult f31254a = null;
    public int L = 0;

    @WorkerThread
    public t(a aVar, GoogleApi googleApi) {
        this.f5605a = aVar;
        Api.Client clientY = googleApi.y(aVar.f5521a.getLooper(), this);
        this.f5604a = clientY;
        this.f5607a = googleApi.d();
        this.f5608a = new q0c();
        this.K = googleApi.x();
        if (clientY.q()) {
            this.f5606a = googleApi.z(aVar.f5520a, aVar.f5521a);
        } else {
            this.f5606a = null;
        }
    }

    public static /* bridge */ /* synthetic */ void A(t tVar, v1c v1cVar) {
        Feature[] featureArrG;
        if (tVar.f5609a.remove(v1cVar)) {
            tVar.f5605a.f5521a.removeMessages(15, v1cVar);
            tVar.f5605a.f5521a.removeMessages(16, v1cVar);
            Feature feature = v1cVar.f45272a;
            ArrayList arrayList = new ArrayList(tVar.f5611a.size());
            for (zai zaiVar : tVar.f5611a) {
                if ((zaiVar instanceof zac) && (featureArrG = ((zac) zaiVar).g(tVar)) != null && gb0.d(featureArrG, feature)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zai zaiVar2 = (zai) arrayList.get(i);
                tVar.f5611a.remove(zaiVar2);
                zaiVar2.b(new UnsupportedApiCallException(feature));
            }
        }
    }

    public static /* bridge */ /* synthetic */ void z(t tVar, v1c v1cVar) {
        if (tVar.f5609a.contains(v1cVar) && !tVar.f5613a) {
            if (tVar.f5604a.isConnected()) {
                tVar.f();
            } else {
                tVar.C();
            }
        }
    }

    @WorkerThread
    public final void B() {
        yw6.d(this.f5605a.f5521a);
        this.f31254a = null;
    }

    @WorkerThread
    public final void C() {
        yw6.d(this.f5605a.f5521a);
        if (this.f5604a.isConnected() || this.f5604a.isConnecting()) {
            return;
        }
        try {
            a aVar = this.f5605a;
            int iB = aVar.f5524a.b(aVar.f5520a, this.f5604a);
            if (iB == 0) {
                a aVar2 = this.f5605a;
                Api.Client client = this.f5604a;
                x1c x1cVar = new x1c(aVar2, client, this.f5607a);
                if (client.q()) {
                    ((zact) yw6.l(this.f5606a)).zae(x1cVar);
                }
                try {
                    this.f5604a.j(x1cVar);
                    return;
                } catch (SecurityException e) {
                    F(new ConnectionResult(10), e);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f5604a.getClass().getName() + " is not available: " + connectionResult.toString());
            F(connectionResult, null);
        } catch (IllegalStateException e2) {
            F(new ConnectionResult(10), e2);
        }
    }

    @WorkerThread
    public final void D(zai zaiVar) {
        yw6.d(this.f5605a.f5521a);
        if (this.f5604a.isConnected()) {
            if (m(zaiVar)) {
                j();
                return;
            } else {
                this.f5611a.add(zaiVar);
                return;
            }
        }
        this.f5611a.add(zaiVar);
        ConnectionResult connectionResult = this.f31254a;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            C();
        } else {
            F(this.f31254a, null);
        }
    }

    @WorkerThread
    public final void E() {
        this.L++;
    }

    @WorkerThread
    public final void F(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        yw6.d(this.f5605a.f5521a);
        zact zactVar = this.f5606a;
        if (zactVar != null) {
            zactVar.zaf();
        }
        B();
        this.f5605a.f5524a.c();
        c(connectionResult);
        if ((this.f5604a instanceof e5c) && connectionResult.getErrorCode() != 24) {
            this.f5605a.f5530a = true;
            a aVar = this.f5605a;
            aVar.f5521a.sendMessageDelayed(aVar.f5521a.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            d(a.b);
            return;
        }
        if (this.f5611a.isEmpty()) {
            this.f31254a = connectionResult;
            return;
        }
        if (exc != null) {
            yw6.d(this.f5605a.f5521a);
            e(null, exc, false);
            return;
        }
        if (!this.f5605a.f5534b) {
            d(a.i(this.f5607a, connectionResult));
            return;
        }
        e(a.i(this.f5607a, connectionResult), null, true);
        if (this.f5611a.isEmpty() || n(connectionResult) || this.f5605a.h(connectionResult, this.K)) {
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            this.f5613a = true;
        }
        if (!this.f5613a) {
            d(a.i(this.f5607a, connectionResult));
        } else {
            a aVar2 = this.f5605a;
            aVar2.f5521a.sendMessageDelayed(Message.obtain(aVar2.f5521a, 9, this.f5607a), this.f5605a.f5519a);
        }
    }

    @WorkerThread
    public final void G(@NonNull ConnectionResult connectionResult) {
        yw6.d(this.f5605a.f5521a);
        Api.Client client = this.f5604a;
        client.d("onSignInFailed for " + client.getClass().getName() + " with " + String.valueOf(connectionResult));
        F(connectionResult, null);
    }

    @WorkerThread
    public final void H(r4c r4cVar) {
        yw6.d(this.f5605a.f5521a);
        this.f5612a.add(r4cVar);
    }

    @WorkerThread
    public final void I() {
        yw6.d(this.f5605a.f5521a);
        if (this.f5613a) {
            C();
        }
    }

    @WorkerThread
    public final void J() {
        yw6.d(this.f5605a.f5521a);
        d(a.f31233a);
        this.f5608a.f();
        for (ListenerHolder.a aVar : (ListenerHolder.a[]) this.f5610a.keySet().toArray(new ListenerHolder.a[0])) {
            D(new a0(aVar, new z09()));
        }
        c(new ConnectionResult(4));
        if (this.f5604a.isConnected()) {
            this.f5604a.g(new t1c(this));
        }
    }

    @WorkerThread
    public final void K() {
        yw6.d(this.f5605a.f5521a);
        if (this.f5613a) {
            l();
            a aVar = this.f5605a;
            d(aVar.f5525a.j(aVar.f5520a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f5604a.d("Timing out connection while resuming.");
        }
    }

    public final boolean M() {
        return this.f5604a.isConnected();
    }

    public final boolean N() {
        return this.f5604a.q();
    }

    @WorkerThread
    public final boolean a() {
        return o(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @WorkerThread
    public final Feature b(@Nullable Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] featureArrN = this.f5604a.n();
            if (featureArrN == null) {
                featureArrN = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(featureArrN.length);
            for (Feature feature : featureArrN) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.getName());
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @WorkerThread
    public final void c(ConnectionResult connectionResult) {
        Iterator it = this.f5612a.iterator();
        while (it.hasNext()) {
            ((r4c) it.next()).c(this.f5607a, connectionResult, i76.b(connectionResult, ConnectionResult.RESULT_SUCCESS) ? this.f5604a.p() : null);
        }
        this.f5612a.clear();
    }

    @WorkerThread
    public final void d(Status status) {
        yw6.d(this.f5605a.f5521a);
        e(status, null, false);
    }

    @WorkerThread
    public final void e(@Nullable Status status, @Nullable Exception exc, boolean z) {
        yw6.d(this.f5605a.f5521a);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f5611a.iterator();
        while (it.hasNext()) {
            zai zaiVar = (zai) it.next();
            if (!z || zaiVar.f31265a == 2) {
                if (status != null) {
                    zaiVar.a(status);
                } else {
                    zaiVar.b(exc);
                }
                it.remove();
            }
        }
    }

    @WorkerThread
    public final void f() {
        ArrayList arrayList = new ArrayList(this.f5611a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zai zaiVar = (zai) arrayList.get(i);
            if (!this.f5604a.isConnected()) {
                return;
            }
            if (m(zaiVar)) {
                this.f5611a.remove(zaiVar);
            }
        }
    }

    @WorkerThread
    public final void g() {
        B();
        c(ConnectionResult.RESULT_SUCCESS);
        l();
        Iterator it = this.f5610a.values().iterator();
        while (it.hasNext()) {
            o2c o2cVar = (o2c) it.next();
            if (b(o2cVar.f43653a.c()) != null) {
                it.remove();
            } else {
                try {
                    o2cVar.f43653a.registerListener(this.f5604a, new z09<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.f5604a.d("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        f();
        j();
    }

    @WorkerThread
    public final void h(int i) {
        B();
        this.f5613a = true;
        this.f5608a.e(i, this.f5604a.r());
        a aVar = this.f5605a;
        aVar.f5521a.sendMessageDelayed(Message.obtain(aVar.f5521a, 9, this.f5607a), this.f5605a.f5519a);
        a aVar2 = this.f5605a;
        aVar2.f5521a.sendMessageDelayed(Message.obtain(aVar2.f5521a, 11, this.f5607a), this.f5605a.f5531b);
        this.f5605a.f5524a.c();
        Iterator it = this.f5610a.values().iterator();
        while (it.hasNext()) {
            ((o2c) it.next()).f18545a.run();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void i(ConnectionResult connectionResult, Api api, boolean z) {
        throw null;
    }

    public final void j() {
        this.f5605a.f5521a.removeMessages(12, this.f5607a);
        a aVar = this.f5605a;
        aVar.f5521a.sendMessageDelayed(aVar.f5521a.obtainMessage(12, this.f5607a), this.f5605a.c);
    }

    @WorkerThread
    public final void k(zai zaiVar) {
        zaiVar.d(this.f5608a, N());
        try {
            zaiVar.c(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f5604a.d("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @WorkerThread
    public final void l() {
        if (this.f5613a) {
            this.f5605a.f5521a.removeMessages(11, this.f5607a);
            this.f5605a.f5521a.removeMessages(9, this.f5607a);
            this.f5613a = false;
        }
    }

    @WorkerThread
    public final boolean m(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            k(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature featureB = b(zacVar.g(this));
        if (featureB == null) {
            k(zaiVar);
            return true;
        }
        Log.w("GoogleApiManager", this.f5604a.getClass().getName() + " could not execute call because it requires feature (" + featureB.getName() + ", " + featureB.getVersion() + ").");
        if (!this.f5605a.f5534b || !zacVar.f(this)) {
            zacVar.b(new UnsupportedApiCallException(featureB));
            return true;
        }
        v1c v1cVar = new v1c(this.f5607a, featureB, null);
        int iIndexOf = this.f5609a.indexOf(v1cVar);
        if (iIndexOf >= 0) {
            v1c v1cVar2 = (v1c) this.f5609a.get(iIndexOf);
            this.f5605a.f5521a.removeMessages(15, v1cVar2);
            a aVar = this.f5605a;
            aVar.f5521a.sendMessageDelayed(Message.obtain(aVar.f5521a, 15, v1cVar2), this.f5605a.f5519a);
            return false;
        }
        this.f5609a.add(v1cVar);
        a aVar2 = this.f5605a;
        aVar2.f5521a.sendMessageDelayed(Message.obtain(aVar2.f5521a, 15, v1cVar), this.f5605a.f5519a);
        a aVar3 = this.f5605a;
        aVar3.f5521a.sendMessageDelayed(Message.obtain(aVar3.f5521a, 16, v1cVar), this.f5605a.f5531b);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (n(connectionResult)) {
            return false;
        }
        this.f5605a.h(connectionResult, this.K);
        return false;
    }

    @WorkerThread
    public final boolean n(@NonNull ConnectionResult connectionResult) {
        synchronized (a.f5518a) {
            a aVar = this.f5605a;
            if (aVar.f5526a == null || !aVar.f5528a.contains(this.f5607a)) {
                return false;
            }
            this.f5605a.f5526a.p(connectionResult, this.K);
            return true;
        }
    }

    @WorkerThread
    public final boolean o(boolean z) {
        yw6.d(this.f5605a.f5521a);
        if (!this.f5604a.isConnected() || this.f5610a.size() != 0) {
            return false;
        }
        if (!this.f5608a.g()) {
            this.f5604a.d("Timing out service connection.");
            return true;
        }
        if (z) {
            j();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.f5605a.f5521a.getLooper()) {
            g();
        } else {
            this.f5605a.f5521a.post(new q1c(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        F(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.f5605a.f5521a.getLooper()) {
            h(i);
        } else {
            this.f5605a.f5521a.post(new r1c(this, i));
        }
    }

    public final int p() {
        return this.K;
    }

    @WorkerThread
    public final int q() {
        return this.L;
    }

    @Nullable
    @WorkerThread
    public final ConnectionResult r() {
        yw6.d(this.f5605a.f5521a);
        return this.f31254a;
    }

    public final Api.Client t() {
        return this.f5604a;
    }

    public final Map v() {
        return this.f5610a;
    }
}
