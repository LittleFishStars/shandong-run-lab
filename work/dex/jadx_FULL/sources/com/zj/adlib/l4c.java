package com.zj.adlib;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l4c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f42998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotOnlyInitialized
    public final zaj f17875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f17877a = new ArrayList();

    @VisibleForTesting
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f17879a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicInteger f17878a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17880b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f17876a = new Object();

    public l4c(Looper looper, zaj zajVar) {
        this.f17875a = zajVar;
        this.f42998a = new o5c(looper, this);
    }

    public final void a() {
        this.f17879a = false;
        this.f17878a.incrementAndGet();
    }

    public final void b() {
        this.f17879a = true;
    }

    @VisibleForTesting
    public final void c(ConnectionResult connectionResult) {
        yw6.e(this.f42998a, "onConnectionFailure must only be called on the Handler thread");
        this.f42998a.removeMessages(1);
        synchronized (this.f17876a) {
            ArrayList<GoogleApiClient.OnConnectionFailedListener> arrayList = new ArrayList(this.c);
            int i = this.f17878a.get();
            for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : arrayList) {
                if (this.f17879a && this.f17878a.get() == i) {
                    if (this.c.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
                return;
            }
        }
    }

    @VisibleForTesting
    public final void d(@Nullable Bundle bundle) {
        yw6.e(this.f42998a, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f17876a) {
            yw6.r(!this.f17880b);
            this.f42998a.removeMessages(1);
            this.f17880b = true;
            yw6.r(this.b.isEmpty());
            ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(this.f17877a);
            int i = this.f17878a.get();
            for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                if (!this.f17879a || !this.f17875a.isConnected() || this.f17878a.get() != i) {
                    break;
                    break;
                    break;
                } else if (!this.b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.b.clear();
            this.f17880b = false;
        }
    }

    @VisibleForTesting
    public final void e(int i) {
        yw6.e(this.f42998a, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f42998a.removeMessages(1);
        synchronized (this.f17876a) {
            this.f17880b = true;
            ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(this.f17877a);
            int i2 = this.f17878a.get();
            for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                if (!this.f17879a || this.f17878a.get() != i2) {
                    break;
                    break;
                } else if (this.f17877a.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.b.clear();
            this.f17880b = false;
        }
    }

    public final void f(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        yw6.l(connectionCallbacks);
        synchronized (this.f17876a) {
            if (this.f17877a.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " is already registered");
            } else {
                this.f17877a.add(connectionCallbacks);
            }
        }
        if (this.f17875a.isConnected()) {
            Handler handler = this.f42998a;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void g(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        yw6.l(connectionCallbacks);
        synchronized (this.f17876a) {
            if (!this.f17877a.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " not found");
            } else if (this.f17880b) {
                this.b.add(connectionCallbacks);
            }
        }
    }

    public final boolean h(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean zContains;
        yw6.l(connectionCallbacks);
        synchronized (this.f17876a) {
            zContains = this.f17877a.contains(connectionCallbacks);
        }
        return zContains;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i, new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.f17876a) {
            if (this.f17879a && this.f17875a.isConnected() && this.f17877a.contains(connectionCallbacks)) {
                connectionCallbacks.onConnected(null);
            }
        }
        return true;
    }

    public final boolean i(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean zContains;
        yw6.l(onConnectionFailedListener);
        synchronized (this.f17876a) {
            zContains = this.c.contains(onConnectionFailedListener);
        }
        return zContains;
    }

    public final void zag(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        yw6.l(onConnectionFailedListener);
        synchronized (this.f17876a) {
            if (this.c.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " is already registered");
            } else {
                this.c.add(onConnectionFailedListener);
            }
        }
    }

    public final void zai(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        yw6.l(onConnectionFailedListener);
        synchronized (this.f17876a) {
            if (!this.c.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " not found");
            }
        }
    }
}
