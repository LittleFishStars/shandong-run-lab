package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        if (network == null) {
            return;
        }
        super.onAvailable(network);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        if (network == null || networkCapabilities == null) {
            return;
        }
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasCapability(16)) {
            boolean zHasTransport = networkCapabilities.hasTransport(1);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(3);
            boolean zHasTransport4 = networkCapabilities.hasTransport(6);
            boolean zHasTransport5 = networkCapabilities.hasTransport(4);
            boolean zHasTransport6 = networkCapabilities.hasTransport(5);
            if (zHasTransport) {
                str = com.alibaba.ariver.kernel.common.network.NetworkUtil.NETWORK_TYPE_WIFI;
            } else if (zHasTransport2) {
                str = "CELLULAR";
            } else if (zHasTransport3) {
                str = "ETHERNET";
            } else if (zHasTransport4) {
                str = "LoWPAN";
            } else if (zHasTransport5) {
                str = "VPN";
            } else if (zHasTransport6) {
                str = "WifiAware";
            } else {
                str = "mobile";
            }
        } else {
            str = "mobile";
        }
        SysOSUtil.getInstance().updateNetType(str);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        if (network == null) {
            return;
        }
        super.onLost(network);
        SysOSUtil.getInstance().updateNetType("mobile");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        super.onUnavailable();
        SysOSUtil.getInstance().updateNetType("mobile");
    }
}
