package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;
import com.zj.adlib.c1c;
import com.zj.adlib.fm1;
import com.zj.adlib.o1c;
import com.zj.adlib.qv3;
import com.zj.adlib.u0c;
import com.zj.adlib.v0c;
import com.zj.adlib.w0c;
import com.zj.adlib.yw6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n implements zabf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ConnectionResult f5558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Api.AbstractClientBuilder f5559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final r f5560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IAccountAccessor f5561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public zae f5562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final fm1 f5563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qv3 f5564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f5566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Lock f5568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5569a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5570b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f5571c;
    public boolean d;
    public boolean e;
    public int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f5557a = new Bundle();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f5567a = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f5565a = new ArrayList();

    public n(r rVar, @Nullable fm1 fm1Var, Map map, qv3 qv3Var, @Nullable Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.f5560a = rVar;
        this.f5563a = fm1Var;
        this.f5566a = map;
        this.f5564a = qv3Var;
        this.f5559a = abstractClientBuilder;
        this.f5568a = lock;
        this.f5556a = context;
    }

    public static /* bridge */ /* synthetic */ void B(n nVar, zak zakVar) {
        if (nVar.o(0)) {
            ConnectionResult connectionResultZaa = zakVar.zaa();
            if (!connectionResultZaa.isSuccess()) {
                if (!nVar.q(connectionResultZaa)) {
                    nVar.l(connectionResultZaa);
                    return;
                } else {
                    nVar.i();
                    nVar.n();
                    return;
                }
            }
            zav zavVar = (zav) yw6.l(zakVar.zab());
            ConnectionResult connectionResultZaa2 = zavVar.zaa();
            if (!connectionResultZaa2.isSuccess()) {
                String strValueOf = String.valueOf(connectionResultZaa2);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                nVar.l(connectionResultZaa2);
                return;
            }
            nVar.f5571c = true;
            nVar.f5561a = (IAccountAccessor) yw6.l(zavVar.zab());
            nVar.d = zavVar.zac();
            nVar.e = zavVar.zad();
            nVar.n();
        }
    }

    public static final String r(int i) {
        return i != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    public static /* bridge */ /* synthetic */ Set y(n nVar) {
        fm1 fm1Var = nVar.f5563a;
        if (fm1Var == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(fm1Var.i());
        Map mapN = nVar.f5563a.n();
        for (Api api : mapN.keySet()) {
            if (!nVar.f5560a.b.containsKey(api.b())) {
                hashSet.addAll(((c1c) mapN.get(api)).f40882a);
            }
        }
        return hashSet;
    }

    public final void J() {
        ArrayList arrayList = this.f5565a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Future) arrayList.get(i)).cancel(true);
        }
        this.f5565a.clear();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void a(ConnectionResult connectionResult, Api api, boolean z) {
        if (o(1)) {
            m(connectionResult, api, z);
            if (p()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void b(@Nullable Bundle bundle) {
        if (o(1)) {
            if (bundle != null) {
                this.f5557a.putAll(bundle);
            }
            if (p()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void c(int i) {
        l(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl d(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f5560a.f5595a.f5587a.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl e(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final void f() {
        this.f5560a.b.clear();
        this.f5570b = false;
        w0c w0cVar = null;
        this.f5558a = null;
        this.b = 0;
        this.f5569a = true;
        this.f5571c = false;
        this.d = false;
        HashMap map = new HashMap();
        boolean z = false;
        for (Api api : this.f5566a.keySet()) {
            Api.Client client = (Api.Client) yw6.l((Api.Client) this.f5560a.f5601a.get(api.b()));
            z |= api.c().b() == 1;
            boolean zBooleanValue = ((Boolean) this.f5566a.get(api)).booleanValue();
            if (client.q()) {
                this.f5570b = true;
                if (zBooleanValue) {
                    this.f5567a.add(api.b());
                } else {
                    this.f5569a = false;
                }
            }
            map.put(client, new v0c(this, api, zBooleanValue));
        }
        if (z) {
            this.f5570b = false;
        }
        if (this.f5570b) {
            yw6.l(this.f5563a);
            yw6.l(this.f5559a);
            this.f5563a.o(Integer.valueOf(System.identityHashCode(this.f5560a.f5595a)));
            m mVar = new m(this, w0cVar);
            Api.AbstractClientBuilder abstractClientBuilder = this.f5559a;
            Context context = this.f5556a;
            Looper looperQ = this.f5560a.f5595a.q();
            fm1 fm1Var = this.f5563a;
            this.f5562a = abstractClientBuilder.c(context, looperQ, fm1Var, fm1Var.k(), mVar, mVar);
        }
        this.c = this.f5560a.f5601a.size();
        this.f5565a.add(o1c.a().submit(new j(this, map)));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void g() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    @GuardedBy("mLock")
    public final boolean h() {
        J();
        j(true);
        this.f5560a.s(null);
        return true;
    }

    @GuardedBy("mLock")
    public final void i() {
        this.f5570b = false;
        this.f5560a.f5595a.f5591b = Collections.emptySet();
        for (Api.a aVar : this.f5567a) {
            if (!this.f5560a.b.containsKey(aVar)) {
                this.f5560a.b.put(aVar, new ConnectionResult(17, null));
            }
        }
    }

    @GuardedBy("mLock")
    public final void j(boolean z) {
        zae zaeVar = this.f5562a;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z) {
                zaeVar.h();
            }
            zaeVar.disconnect();
            this.f5561a = null;
        }
    }

    @GuardedBy("mLock")
    public final void k() {
        this.f5560a.q();
        o1c.a().execute(new u0c(this));
        zae zaeVar = this.f5562a;
        if (zaeVar != null) {
            if (this.d) {
                zaeVar.o((IAccountAccessor) yw6.l(this.f5561a), this.e);
            }
            j(false);
        }
        Iterator it = this.f5560a.b.keySet().iterator();
        while (it.hasNext()) {
            ((Api.Client) yw6.l((Api.Client) this.f5560a.f5601a.get((Api.a) it.next()))).disconnect();
        }
        this.f5560a.f5598a.b(this.f5557a.isEmpty() ? null : this.f5557a);
    }

    @GuardedBy("mLock")
    public final void l(ConnectionResult connectionResult) {
        J();
        j(!connectionResult.hasResolution());
        this.f5560a.s(connectionResult);
        this.f5560a.f5598a.c(connectionResult);
    }

    @GuardedBy("mLock")
    public final void m(ConnectionResult connectionResult, Api api, boolean z) {
        int iB = api.c().b();
        if ((!z || connectionResult.hasResolution() || this.f5564a.d(connectionResult.getErrorCode()) != null) && (this.f5558a == null || iB < this.f31248a)) {
            this.f5558a = connectionResult;
            this.f31248a = iB;
        }
        this.f5560a.b.put(api.b(), connectionResult);
    }

    @GuardedBy("mLock")
    public final void n() {
        if (this.c != 0) {
            return;
        }
        if (!this.f5570b || this.f5571c) {
            ArrayList arrayList = new ArrayList();
            this.b = 1;
            this.c = this.f5560a.f5601a.size();
            for (Api.a aVar : this.f5560a.f5601a.keySet()) {
                if (!this.f5560a.b.containsKey(aVar)) {
                    arrayList.add((Api.Client) this.f5560a.f5601a.get(aVar));
                } else if (p()) {
                    k();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f5565a.add(o1c.a().submit(new k(this, arrayList)));
        }
    }

    @GuardedBy("mLock")
    public final boolean o(int i) {
        if (this.b == i) {
            return true;
        }
        Log.w("GACConnecting", this.f5560a.f5595a.J());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        Log.w("GACConnecting", "mRemainingConnections=" + this.c);
        Log.e("GACConnecting", "GoogleApiClient connecting is in step " + r(this.b) + " but received callback for step " + r(i), new Exception());
        l(new ConnectionResult(8, null));
        return false;
    }

    @GuardedBy("mLock")
    public final boolean p() {
        int i = this.c - 1;
        this.c = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GACConnecting", this.f5560a.f5595a.J());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            l(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f5558a;
        if (connectionResult == null) {
            return true;
        }
        this.f5560a.K = this.f31248a;
        l(connectionResult);
        return false;
    }

    @GuardedBy("mLock")
    public final boolean q(ConnectionResult connectionResult) {
        return this.f5569a && !connectionResult.hasResolution();
    }
}
