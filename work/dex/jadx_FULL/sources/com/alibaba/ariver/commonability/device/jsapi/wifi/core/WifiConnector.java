package com.alibaba.ariver.commonability.device.jsapi.wifi.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.net.wifi.WifiNetworkSuggestion;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WifiConnector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24005a = "WifiConnector";
    private static int b = 15;
    private static WifiConnector c = null;
    private static ConnectivityManager.NetworkCallback n = null;
    private static boolean o = false;
    private static boolean p = false;
    private Context d;
    private WifiManager e;
    private a f;
    private Lock g;
    private Condition h;
    private WifiConfiguration i;
    private boolean j = false;
    private int k = -1;
    private int l = -1;
    private WiFiConnectReceiver m;

    public class WiFiConnectReceiver extends BroadcastReceiver {
        private WiFiConnectReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                WifiConnector.this.g.lock();
                if (intent.getIntExtra("supplicantError", -1) == 1) {
                    WifiConnector.this.k = 1;
                }
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (!networkInfo.getState().equals(NetworkInfo.State.DISCONNECTED) && networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    WifiInfo connectionInfo = WifiConnector.this.e.getConnectionInfo();
                    if (connectionInfo.getNetworkId() == WifiConnector.this.l && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        WifiConnector.this.j = true;
                        WifiConnector.this.h.signalAll();
                    }
                }
                WifiConnector.this.g.unlock();
            }
        }
    }

    public WifiConnector(Context context, WifiManager wifiManager) {
        this.d = context;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.g = reentrantLock;
        this.h = reentrantLock.newCondition();
        this.e = wifiManager;
        this.f = new a(context, wifiManager);
        this.m = new WiFiConnectReceiver();
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_wifi_connect_timeout", "");
        if (TextUtils.isEmpty(config)) {
            return;
        }
        try {
            b = Integer.valueOf(config).intValue();
        } catch (Throwable unused) {
            RVLogger.e(f24005a, "timeout config error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        try {
            WifiConfiguration wifiConfiguration = this.i;
            int i = wifiConfiguration.networkId;
            int iAddNetwork = this.e.addNetwork(wifiConfiguration);
            this.l = iAddNetwork;
            if (iAddNetwork == -1) {
                this.l = i;
            }
            int iB = this.f.b() + 1;
            WifiConfiguration wifiConfiguration2 = this.i;
            wifiConfiguration2.networkId = this.l;
            wifiConfiguration2.priority = iB;
            this.e.updateNetwork(wifiConfiguration2);
            this.j = false;
            this.e.saveConfiguration();
            this.g.lock();
            if (!this.e.enableNetwork(this.l, true)) {
                this.g.unlock();
                return false;
            }
            try {
                this.h.await(b, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                RVLogger.e(f24005a, "time out", e);
                this.k = 2;
            }
            this.g.unlock();
            return this.j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Context context = this.d;
        if (context == null || p) {
            return;
        }
        context.registerReceiver(this.m, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        p = true;
    }

    public static WifiConnector a(Context context, WifiManager wifiManager) {
        WifiConnector wifiConnector = new WifiConnector(context, wifiManager);
        c = wifiConnector;
        return wifiConnector;
    }

    public WifiConnector a(WifiConfiguration wifiConfiguration) {
        this.i = wifiConfiguration;
        return this;
    }

    public boolean a(final b bVar) {
        if (o) {
            return false;
        }
        this.f.a();
        WifiConfiguration wifiConfiguration = this.i;
        bVar.a(wifiConfiguration.SSID, wifiConfiguration.BSSID);
        o = true;
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getScheduledExecutor().execute(new Runnable() { // from class: com.alibaba.ariver.commonability.device.jsapi.wifi.core.WifiConnector.1
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 29 && com.alibaba.ariver.commonability.core.util.b.a("ta_wifi_adapter_q", true)) {
                    WifiConnector wifiConnector = WifiConnector.this;
                    wifiConnector.a(bVar, wifiConnector.i, WifiConnector.this.d);
                    boolean unused = WifiConnector.o = false;
                    return;
                }
                WifiConnector.this.c();
                if (WifiConnector.this.b()) {
                    bVar.b(WifiConnector.this.i.SSID, WifiConnector.this.i.BSSID);
                } else if (WifiConnector.this.k == 1) {
                    bVar.a(WifiConnector.this.i.SSID, WifiConnector.this.i.BSSID, WifiManagerBridgeExtension.ERROR_12002);
                } else if (WifiConnector.this.k == 2) {
                    bVar.a(WifiConnector.this.i.SSID, WifiConnector.this.i.BSSID, WifiManagerBridgeExtension.ERROR_12003);
                } else {
                    bVar.a(WifiConnector.this.i.SSID, WifiConnector.this.i.BSSID, WifiManagerBridgeExtension.ERROR_12010);
                }
                WifiConnector.this.a();
                boolean unused2 = WifiConnector.o = false;
            }
        });
        return true;
    }

    @RequiresApi(api = 29)
    public void a(final b bVar, final WifiConfiguration wifiConfiguration, Context context) {
        if (wifiConfiguration.allowedKeyManagement.length() != 0 && wifiConfiguration.allowedKeyManagement.get(0) && !TextUtils.isEmpty(wifiConfiguration.preSharedKey)) {
            bVar.a(wifiConfiguration.SSID, wifiConfiguration.BSSID, WifiManagerBridgeExtension.ERROR_12001);
            return;
        }
        String strReplace = wifiConfiguration.SSID.replace("\"", "");
        WifiNetworkSuggestion.Builder ssid = new WifiNetworkSuggestion.Builder().setSsid(strReplace);
        WifiNetworkSpecifier.Builder ssid2 = new WifiNetworkSpecifier.Builder().setSsid(strReplace);
        RVLogger.d(f24005a, "SSID:" + strReplace);
        if (!TextUtils.isEmpty(wifiConfiguration.BSSID)) {
            ssid2.setBssid(MacAddress.fromString(wifiConfiguration.BSSID));
            ssid.setBssid(MacAddress.fromString(wifiConfiguration.BSSID));
            RVLogger.d(f24005a, "BSSID:" + wifiConfiguration.BSSID);
        }
        if (wifiConfiguration.allowedKeyManagement.length() != 0 && wifiConfiguration.allowedKeyManagement.get(1) && !TextUtils.isEmpty(wifiConfiguration.preSharedKey)) {
            String strReplace2 = wifiConfiguration.preSharedKey.replace("\"", "");
            ssid2.setWpa2Passphrase(strReplace2);
            ssid.setWpa2Passphrase(strReplace2);
            RVLogger.d(f24005a, "password:" + strReplace2);
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(ssid2.build()).build();
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        ConnectivityManager.NetworkCallback networkCallback = n;
        if (networkCallback != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.alibaba.ariver.commonability.device.jsapi.wifi.core.WifiConnector.2
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                ConnectivityManager connectivityManager2 = connectivityManager;
                if (connectivityManager2 != null) {
                    connectivityManager2.bindProcessToNetwork(network);
                }
                RVLogger.d(WifiConnector.f24005a, "onAvailable");
                b bVar2 = bVar;
                WifiConfiguration wifiConfiguration2 = wifiConfiguration;
                bVar2.b(wifiConfiguration2.SSID, wifiConfiguration2.BSSID);
                if (countDownLatch.getCount() > 0) {
                    countDownLatch.countDown();
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                super.onUnavailable();
                RVLogger.d(WifiConnector.f24005a, "onUnavailable");
                b bVar2 = bVar;
                WifiConfiguration wifiConfiguration2 = wifiConfiguration;
                bVar2.a(wifiConfiguration2.SSID, wifiConfiguration2.BSSID, WifiManagerBridgeExtension.ERROR_12007);
                if (countDownLatch.getCount() > 0) {
                    countDownLatch.countDown();
                }
            }
        };
        n = networkCallback2;
        connectivityManager.requestNetwork(networkRequestBuild, networkCallback2);
        if (countDownLatch.getCount() < 0) {
            return;
        }
        try {
            countDownLatch.await(b * 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            RVLogger.e(f24005a, "time out", e);
        }
        bVar.a(wifiConfiguration.SSID, wifiConfiguration.BSSID, WifiManagerBridgeExtension.ERROR_12003);
    }

    public void a() {
        WiFiConnectReceiver wiFiConnectReceiver;
        try {
            Context context = this.d;
            if (context == null || (wiFiConnectReceiver = this.m) == null || !p) {
                return;
            }
            context.unregisterReceiver(wiFiConnectReceiver);
            p = false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public WifiConfiguration a(String str, String str2, String str3, WifiSecurityMode wifiSecurityMode) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.status = 2;
        wifiConfiguration.SSID = "\"" + str + "\"";
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        wifiConfiguration.BSSID = str2;
        WifiConfiguration wifiConfigurationA = a(str);
        if (wifiConfigurationA != null) {
            this.e.disableNetwork(wifiConfigurationA.networkId);
            this.e.removeNetwork(wifiConfigurationA.networkId);
            this.e.saveConfiguration();
        }
        if (wifiSecurityMode == WifiSecurityMode.OPEN) {
            wifiConfiguration.preSharedKey = null;
            wifiConfiguration.allowedKeyManagement.set(0);
        } else if (wifiSecurityMode == WifiSecurityMode.WEP) {
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.wepKeys[0] = "\"" + str3 + "\"";
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else {
            wifiConfiguration.preSharedKey = "\"" + str3 + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        }
        return wifiConfiguration;
    }

    public WifiConfiguration a(String str) {
        return this.f.a(str);
    }
}
