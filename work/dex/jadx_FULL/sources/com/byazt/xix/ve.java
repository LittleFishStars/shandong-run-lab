package com.byazt.xix;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 664, 54})
public class ve {
    public static volatile ve c;
    public boolean n;
    public ConnectivityManager tt;
    public tt uj;
    public Network ve;

    public interface c {
        void c(Network network);
    }

    @com.byazt.zqa.c(c = {0, 1, 664, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt extends ConnectivityManager.NetworkCallback {
        public c c;
        public final ve tt;
        public AtomicBoolean ve = new AtomicBoolean(false);

        public tt(c cVar, ve veVar) {
            this.c = cVar;
            this.tt = veVar;
        }

        public void c(c cVar) {
            this.c = cVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.ve.compareAndSet(false, true)) {
                try {
                    this.tt.ve = network;
                    this.c.c(network);
                    this.tt.n = false;
                } catch (Exception unused) {
                    this.tt.ve = null;
                    this.c.c(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.tt.n = true;
        }
    }

    private ve(Context context) {
        try {
            this.tt = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            m.c(e);
        }
    }

    public synchronized void tt() {
        ConnectivityManager connectivityManager = this.tt;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                tt ttVar = this.uj;
                if (ttVar == null) {
                    this.uj = null;
                    this.ve = null;
                } else {
                    connectivityManager.unregisterNetworkCallback(ttVar);
                    this.uj = null;
                    this.ve = null;
                }
            } catch (Throwable th) {
                this.uj = null;
                this.ve = null;
                throw th;
            }
        } catch (Exception unused) {
            this.uj = null;
            this.ve = null;
        }
    }

    public static ve c(Context context) {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve(context);
                }
            }
        }
        return c;
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int c() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.tt;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.tt.getActiveNetwork()) == null || (networkCapabilities = this.tt.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(4);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(1);
            if (zHasTransport) {
                return 4;
            }
            if (c(this.tt) && zHasTransport3) {
                return 3;
            }
            if (zHasTransport3) {
                return 1;
            }
            return zHasTransport2 ? 2 : 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void c(c cVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.tt;
        if (connectivityManager == null) {
            cVar.c(null);
            return;
        }
        Network network = this.ve;
        if (network != null && !this.n && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            cVar.c(this.ve);
            return;
        }
        tt ttVar = this.uj;
        if (ttVar != null) {
            ttVar.c(cVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        tt ttVar2 = new tt(cVar, c);
        this.uj = ttVar2;
        try {
            this.tt.requestNetwork(networkRequestBuild, ttVar2);
        } catch (Exception unused) {
            cVar.c(null);
        }
    }
}
