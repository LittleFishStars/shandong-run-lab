package cj.mobile.wm;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o9 {
    public Context dexa;
    public List<dexc> dexb;
    public ConnectivityManager dexc;
    public int dexd;
    public int dexe;
    public final BroadcastReceiver dexf;

    @TargetApi(21)
    public ConnectivityManager.NetworkCallback dexg;

    public class dexa extends BroadcastReceiver {
        public dexa() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            f1.dexa("NetworkStateObserver", "onReceive: action = " + action);
            if (TextUtils.equals(action, PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                o9.this.dexb();
                if (o9.this.dexd != o9.this.dexe) {
                    o9.this.dexd();
                    o9 o9Var = o9.this;
                    o9Var.dexd = o9Var.dexe;
                }
            }
        }
    }

    public class dexb extends ConnectivityManager.NetworkCallback {
        public dexb() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(1)) {
                    o9.this.dexe = 1;
                } else if (networkCapabilities.hasTransport(0)) {
                    o9.this.dexb();
                } else if (networkCapabilities.hasTransport(3)) {
                    o9.this.dexe = 9;
                }
            }
            f1.dexa("NetworkStateObserver", "onCapabilitiesChanged: cap = " + networkCapabilities + ", network = " + network + ", currentType = " + o9.this.dexe + ", prevType = " + o9.this.dexd);
            if (o9.this.dexd != o9.this.dexe) {
                o9.this.dexd();
                o9 o9Var = o9.this;
                o9Var.dexd = o9Var.dexe;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            f1.dexa("NetworkStateObserver", "onLost: currentType = " + o9.this.dexe + ", prev = " + o9.this.dexd + ", network = " + network);
            o9.this.dexb();
            if (o9.this.dexd != o9.this.dexe) {
                o9.this.dexd();
                o9 o9Var = o9.this;
                o9Var.dexd = o9Var.dexe;
            }
        }
    }

    public interface dexc {
        void a(int i);
    }

    public static class dexd {
        public static final o9 dexa = new o9(null);
    }

    public o9() {
        this.dexd = -1;
        this.dexe = -1;
        this.dexf = new dexa();
        this.dexa = InsightProxy.getApplication();
        this.dexb = new LinkedList();
        try {
            this.dexc = (ConnectivityManager) this.dexa.getSystemService("connectivity");
        } catch (Exception e) {
            f1.dexb("NetworkStateObserver", "get ConnectivityManager exception", e);
        }
        dexe();
        dexb();
    }

    public /* synthetic */ o9(dexa dexaVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x0028 A[PHI: r4
      0x0028: PHI (r4v2 int) = (r4v1 int), (r4v0 int) binds: [B:24:0x0045, B:14:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    public void dexb() {
        NetworkInfo activeNetworkInfo;
        String str;
        try {
            activeNetworkInfo = this.dexc.getActiveNetworkInfo();
        } catch (Exception e) {
            f1.dexa("NetworkStateObserver", "getActiveNetworkType exception.", e);
            activeNetworkInfo = null;
        }
        int i = -1;
        if (activeNetworkInfo == null) {
            this.dexe = -1;
            str = "getActiveNetworkType with null network info.";
        } else {
            int i2 = 1;
            if (activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected()) {
                this.dexe = i2;
            } else {
                if (activeNetworkInfo.getType() == 0 && activeNetworkInfo.isConnected()) {
                    i = 0;
                } else {
                    i2 = 9;
                    if (activeNetworkInfo.getType() == 9 && activeNetworkInfo.isConnected()) {
                        this.dexe = i2;
                    }
                }
                this.dexe = i;
            }
            str = "getActiveNetworkType: mPrevNetworkType = " + this.dexd + ", mCurrentNetworkType = " + this.dexe + ", networkInfo = " + activeNetworkInfo;
        }
        f1.dexa("NetworkStateObserver", str);
    }

    public static o9 dexc() {
        return dexd.dexa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dexd() {
        f1.dexa("NetworkStateObserver", "notifyNetworkStateChanged: mPrevNetworkType = " + this.dexd + ", mCurrentNetworkType = " + this.dexe);
        Iterator<dexc> it = this.dexb.iterator();
        while (it.hasNext()) {
            it.next().a(this.dexe);
        }
    }

    private void dexe() {
        try {
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            if (this.dexg == null) {
                this.dexg = new dexb();
            }
            this.dexc.registerNetworkCallback(networkRequestBuild, this.dexg);
        } catch (Throwable th) {
            f1.dexb("NetworkStateObserver", "registerNetworkState exception.", th);
        }
    }

    public synchronized void dexa(dexc dexcVar) {
        f1.dexa("NetworkStateObserver", "addNetworkChangeListener: listener = " + dexcVar);
        this.dexb.add(dexcVar);
        dexcVar.a(this.dexe);
    }

    public boolean dexa() {
        return this.dexe != -1;
    }
}
