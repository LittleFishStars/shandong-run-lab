package com.huachenjie.common.run_component;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import com.huachenjie.common.base.BaseSimpleComponent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class NetworkStateComponent extends BaseSimpleComponent {
    public static final int K = -1;
    public static final int L = 1;
    public static final int M = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f33884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f8857a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NetworkChangeListener f8858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8859a;

    public interface NetworkChangeListener {
        void a(int state);
    }

    public static class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<NetworkStateComponent> f33885a;

        public a(NetworkStateComponent networkStateComponent) {
            this.f33885a = new WeakReference<>(networkStateComponent);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            NetworkStateComponent networkStateComponent;
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (!networkCapabilities.hasCapability(16) || (networkStateComponent = this.f33885a.get()) == null) {
                return;
            }
            if (networkCapabilities.hasTransport(1)) {
                networkStateComponent.e(1);
            } else {
                networkStateComponent.e(2);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            NetworkStateComponent networkStateComponent = this.f33885a.get();
            if (networkStateComponent != null) {
                networkStateComponent.e(-1);
            }
        }
    }

    public NetworkStateComponent(Context context) {
        this.f33884a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i) {
        NetworkChangeListener networkChangeListener = this.f8858a;
        if (networkChangeListener != null) {
            networkChangeListener.a(i);
        }
    }

    public final void e(final int networkState) {
        this.f8857a.post(new Runnable() { // from class: com.zj.adlib.ay5
            @Override // java.lang.Runnable
            public final void run() {
                this.f40638a.g(networkState);
            }
        });
    }

    public final boolean f() {
        return this.f8858a != null;
    }

    public void h(NetworkChangeListener networkChangeListener) {
        if (f()) {
            return;
        }
        this.f8859a = new a(this);
        this.f8858a = networkChangeListener;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f33884a.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerDefaultNetworkCallback(this.f8859a);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        a aVar;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f33884a.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (aVar = this.f8859a) != null) {
                connectivityManager.unregisterNetworkCallback(aVar);
            }
        } catch (Exception unused) {
        }
        this.f8859a = null;
        this.f8858a = null;
        super.onDestroy();
    }
}
