package com.zj.adlib;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zap;
import com.ipd.dsp.internal.i.q;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o4c extends zap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f43671a;

    public o4c(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, pv3.x());
        this.f43671a = new SparseArray();
        ((LifecycleCallback) this).f31226a.addCallback("AutoManageHelper", this);
    }

    public static o4c q(ex4 ex4Var) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(ex4Var);
        o4c o4cVar = (o4c) fragment.getCallbackOrNull("AutoManageHelper", o4c.class);
        return o4cVar != null ? o4cVar : new o4c(fragment);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f43671a.size(); i++) {
            k4c k4cVarT = t(i);
            if (k4cVarT != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(k4cVarT.K);
                printWriter.println(u15.f19942b);
                k4cVarT.f17581a.j(String.valueOf(str).concat(q.a.i), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i() {
        super.i();
        Log.d("AutoManageHelper", "onStart " + ((zap) this).f5617a + " " + String.valueOf(this.f43671a));
        if (((zap) this).f5616a.get() == null) {
            for (int i = 0; i < this.f43671a.size(); i++) {
                k4c k4cVarT = t(i);
                if (k4cVarT != null) {
                    k4cVarT.f17581a.g();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        for (int i = 0; i < this.f43671a.size(); i++) {
            k4c k4cVarT = t(i);
            if (k4cVarT != null) {
                k4cVarT.f17581a.i();
            }
        }
    }

    public final void r(int i, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        yw6.m(googleApiClient, "GoogleApiClient instance cannot be null");
        yw6.s(this.f43671a.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        t4c t4cVar = (t4c) ((zap) this).f5616a.get();
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + ((zap) this).f5617a + " " + String.valueOf(t4cVar));
        k4c k4cVar = new k4c(this, i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(k4cVar);
        this.f43671a.put(i, k4cVar);
        if (((zap) this).f5617a && t4cVar == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.g();
        }
    }

    public final void s(int i) {
        k4c k4cVar = (k4c) this.f43671a.get(i);
        this.f43671a.remove(i);
        if (k4cVar != null) {
            k4cVar.f17581a.unregisterConnectionFailedListener(k4cVar);
            k4cVar.f17581a.i();
        }
    }

    @Nullable
    public final k4c t(int i) {
        if (this.f43671a.size() <= i) {
            return null;
        }
        SparseArray sparseArray = this.f43671a;
        return (k4c) sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zab(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        k4c k4cVar = (k4c) this.f43671a.get(i);
        if (k4cVar != null) {
            s(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = k4cVar.f42743a;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    public final void zac() {
        for (int i = 0; i < this.f43671a.size(); i++) {
            k4c k4cVarT = t(i);
            if (k4cVarT != null) {
                k4cVarT.f17581a.g();
            }
        }
    }
}
