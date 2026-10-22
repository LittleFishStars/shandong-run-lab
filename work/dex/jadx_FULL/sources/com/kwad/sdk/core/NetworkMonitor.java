package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.igexin.sdk.PushConsts;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class NetworkMonitor {
    private static volatile boolean aKO = false;
    private final List<a> aKP;
    private final WeakHashMap<a, AdTemplate> aKQ;
    private final Map<a, AdTemplate> aKR;
    private boolean aKS;
    private final BroadcastReceiver aKT;

    public enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        Holder() {
        }

        public final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public interface a {
        void a(NetworkState networkState);
    }

    public /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> it = this.aKP.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    private synchronized void bK(Context context) {
        if (aKO || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(this.aKT, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
            aKO = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private NetworkMonitor() {
        this.aKP = new CopyOnWriteArrayList();
        WeakHashMap<a, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aKQ = weakHashMap;
        this.aKR = Collections.synchronizedMap(weakHashMap);
        this.aKS = false;
        this.aKT = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public final void a(Context context, @NonNull a aVar) {
        bK(context);
        if (this.aKP.contains(aVar)) {
            return;
        }
        this.aKP.add(aVar);
    }

    public final void a(Context context, @NonNull a aVar, AdTemplate adTemplate) {
        bK(context);
        this.aKR.put(aVar, adTemplate);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.aKP.remove(aVar);
    }
}
