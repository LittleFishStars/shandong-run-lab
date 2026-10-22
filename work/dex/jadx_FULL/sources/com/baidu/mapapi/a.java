package com.baidu.mapapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.platform.comapi.util.SysOSUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public class a extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26492a;

    public a(Context context) {
        this.f26492a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        if (network == null) {
            return;
        }
        super.onAvailable(network);
    }

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
            } else {
                str = zHasTransport6 ? "WifiAware" : "mobile";
            }
            String strF = f.f();
            if (strF == null || strF.equals(str)) {
                return;
            }
            f.a(str);
            Context context = this.f26492a;
            if (context != null) {
                NetworkUtil.updateNetworkProxy(context);
            }
        }
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
