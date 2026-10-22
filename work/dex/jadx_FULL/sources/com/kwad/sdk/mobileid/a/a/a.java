package com.kwad.sdk.mobileid.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class a {
    private ConnectivityManager aoL;
    private ConnectivityManager.NetworkCallback biZ;
    private volatile boolean bja = false;

    /* JADX INFO: renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC1304a {
        void Sl();
    }

    private static ConnectivityManager cF(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public final void Sg() {
        synchronized (this) {
            ConnectivityManager.NetworkCallback networkCallback = this.biZ;
            if (networkCallback == null) {
                return;
            }
            try {
                ConnectivityManager connectivityManager = this.aoL;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
            this.aoL.bindProcessToNetwork(null);
            this.biZ = null;
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.bja = true;
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public final void a(Context context, final InterfaceC1304a interfaceC1304a) {
        synchronized (this) {
            this.aoL = cF(context);
            try {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                if (this.biZ == null) {
                    this.biZ = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            a.this.aoL.bindProcessToNetwork(network);
                            if (interfaceC1304a != null && !a.this.bja) {
                                interfaceC1304a.Sl();
                            }
                            a.a(a.this, true);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            a.this.aoL.bindProcessToNetwork(null);
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                            a.this.Sg();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onUnavailable() {
                            a.this.aoL.bindProcessToNetwork(null);
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                            a.this.Sg();
                        }
                    };
                }
                if (!this.bja) {
                    this.aoL.requestNetwork(networkRequestBuild, this.biZ);
                } else {
                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                    Sg();
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }
}
