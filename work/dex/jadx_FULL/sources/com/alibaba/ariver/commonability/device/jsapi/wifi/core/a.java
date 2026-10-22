package com.alibaba.ariver.commonability.device.jsapi.wifi.core;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.kuaishou.weapon.p0.g;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24009a = "Wifi#WifiAdmin";
    private WifiManager b;
    private Context c;

    public a(Context context, WifiManager wifiManager) {
        try {
            this.b = wifiManager;
            this.c = context;
        } catch (Exception e) {
            e.printStackTrace();
            RVLogger.e(this.f24009a, "权限异常", e);
        }
    }

    public WifiConfiguration a(String str) {
        List<WifiConfiguration> configuredNetworks = this.b.getConfiguredNetworks();
        if (configuredNetworks == null) {
            return null;
        }
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                return wifiConfiguration;
            }
        }
        return null;
    }

    public void b(String str) {
        Context context;
        try {
            WifiConfiguration wifiConfigurationA = a(str);
            if (wifiConfigurationA == null || (context = this.c) == null || context.checkSelfPermission(g.d) != 0) {
                return;
            }
            this.b.removeNetwork(wifiConfigurationA.networkId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        try {
            Context context = this.c;
            if (context == null || context.checkSelfPermission(g.d) == 0) {
                this.b.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int b() {
        int i;
        Exception e;
        try {
            List<WifiConfiguration> configuredNetworks = this.b.getConfiguredNetworks();
            i = 0;
            try {
                if (configuredNetworks.size() > 0) {
                    Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                    while (it.hasNext()) {
                        int i2 = it.next().priority;
                        if (i2 > i) {
                            i = i2;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            i = 40;
            e = e3;
        }
        return i;
    }
}
