package com.alibaba.ariver.commonability.device.jsapi.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.commonability.device.jsapi.wifi.core.WifiConnector;
import com.alibaba.ariver.commonability.device.jsapi.wifi.core.WifiSecurityMode;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.king.zxing.e;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WifiManagerBridgeExtension implements AppPausePoint, AppResumePoint, BridgeExtension {
    public static final int ERROR_12000 = 12000;
    public static final int ERROR_12001 = 12001;
    public static final int ERROR_12002 = 12002;
    public static final int ERROR_12003 = 12003;
    public static final int ERROR_12004 = 12004;
    public static final int ERROR_12005 = 12005;
    public static final int ERROR_12006 = 12006;
    public static final int ERROR_12007 = 12007;
    public static final int ERROR_12010 = 12010;
    public static final int ERROR_12011 = 12011;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24001a = "WifiManagerBridgeExtension";
    private WifiManager b;
    private Page f;
    private BridgeCallback g;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private BroadcastReceiver h = new BroadcastReceiver() { // from class: com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            RVLogger.d(WifiManagerBridgeExtension.f24001a, "onReceiveWifiBroadcast... action = " + action);
            action.hashCode();
            switch (action) {
                case "android.net.wifi.WIFI_STATE_CHANGED":
                    WifiManagerBridgeExtension.this.b(intent);
                    break;
                case "android.net.wifi.STATE_CHANGE":
                    WifiManagerBridgeExtension.this.a(intent);
                    break;
                case "android.net.wifi.SCAN_RESULTS":
                    WifiManagerBridgeExtension.this.d();
                    break;
            }
        }
    };

    private void a(Page page, BridgeResponse bridgeResponse) {
        if (!(bridgeResponse instanceof BridgeResponse.Error)) {
            a.a(page, 0, "");
        } else {
            BridgeResponse.Error error = (BridgeResponse.Error) bridgeResponse;
            a.a(page, error.getErrorCode(), error.getErrorMessage());
        }
    }

    private BridgeResponse b() {
        try {
            boolean zIsWifiEnabled = i().isWifiEnabled();
            String str = f24001a;
            RVLogger.d(str, "startWifi... isWifiEnable = " + zIsWifiEnabled);
            if (!zIsWifiEnabled) {
                return new BridgeResponse.Error(ERROR_12005, "未打开 Wi-Fi 开关");
            }
            boolean z = true;
            if (!zIsWifiEnabled && !i().setWifiEnabled(true)) {
                z = false;
            }
            JSONObject jSONObject = new JSONObject();
            this.d = z;
            jSONObject.put(z ? "success" : "fail", (Object) Boolean.TRUE);
            RVLogger.d(str, "startWifi... flag isWifiStarted = " + z);
            return new BridgeResponse(jSONObject);
        } catch (Exception e) {
            RVLogger.e(f24001a, "startWifi... fail with exception", e);
            return new BridgeResponse.Error(ERROR_12001, "当前系统不支持相关能力");
        }
    }

    private BridgeResponse c() {
        if (!this.d) {
            return new BridgeResponse.Error(ERROR_12000, "未先调用startWifi接口");
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(ERROR_12005, "未打开 Wi-Fi 开关");
        }
        try {
            g();
            this.d = false;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", (Object) Boolean.TRUE);
            return new BridgeResponse(jSONObject);
        } catch (Exception e) {
            RVLogger.e(f24001a, "stopWifi... fail with exception", e);
            this.d = false;
            return new BridgeResponse.Error(ERROR_12001, "当前系统不支持相关能力");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int size;
        Exception e;
        try {
            List<ScanResult> scanResults = i().getScanResults();
            if (scanResults != null && scanResults.size() > 0) {
                size = scanResults.size();
                try {
                    RVLogger.d(f24001a, "processScanResult... getWifiList success, unregisterWifiReceiver");
                    g();
                    JSONArray jSONArray = new JSONArray(scanResults.size() * 2);
                    for (ScanResult scanResult : scanResults) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("frequency", (Object) Integer.valueOf(scanResult.frequency));
                        jSONObject.put(e.f.b, (Object) scanResult.SSID);
                        jSONObject.put("BSSID", (Object) scanResult.BSSID);
                        jSONObject.put("secure", (Object) Boolean.valueOf(a(scanResult.capabilities) > 0));
                        jSONObject.put("signalStrength", (Object) Integer.valueOf(WifiManager.calculateSignalLevel(scanResult.level, 100)));
                        jSONArray.add(jSONObject);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("wifiList", (Object) jSONArray);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    RVLogger.d(f24001a, "processScanResult... onGetWifiList, wifiList = " + jSONArray.toJSONString());
                    Page page = this.f;
                    if (page != null) {
                        EngineUtils.sendToRender(page.getRender(), "getWifiList", jSONObject3, null);
                    }
                    a(this.f, null, size);
                    return;
                } catch (Exception e2) {
                    e = e2;
                    RVLogger.e(f24001a, "processScanResult... fail with exception", e);
                    BridgeResponse.Error error = new BridgeResponse.Error(ERROR_12010, "系统其他错误: " + e.getClass().getName());
                    BridgeCallback bridgeCallback = this.g;
                    if (bridgeCallback != null) {
                        bridgeCallback.sendBridgeResponse(error);
                    }
                    a(this.f, error, size);
                    return;
                }
            }
            BridgeResponse.Error error2 = new BridgeResponse.Error(ERROR_12010, "系统其他错误: 扫描wifi失败");
            a(this.f, error2, 0);
            BridgeCallback bridgeCallback2 = this.g;
            if (bridgeCallback2 != null) {
                bridgeCallback2.sendBridgeResponse(error2);
            }
        } catch (Exception e3) {
            size = 0;
            e = e3;
        }
    }

    private boolean e() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return false;
        }
        Application applicationContext = rVEnvironmentService.getApplicationContext();
        RVLogger.d(f24001a, "Build.VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
        try {
            return Settings.Secure.getInt(applicationContext.getContentResolver(), "location_mode", 0) != 0;
        } catch (Throwable th) {
            RVLogger.e(f24001a, "isGpsSwitchOPen, error,msg=" + th);
            return true;
        }
    }

    private void f() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return;
        }
        Application applicationContext = rVEnvironmentService.getApplicationContext();
        if (this.c || applicationContext == null) {
            return;
        }
        RVLogger.d(f24001a, "registerWifiReceiver... is not Registered , register receiver!!");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        applicationContext.registerReceiver(this.h, intentFilter);
        this.c = true;
    }

    private void g() {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return;
        }
        Application applicationContext = rVEnvironmentService.getApplicationContext();
        if (!this.c || applicationContext == null) {
            return;
        }
        RVLogger.d(f24001a, "unregisterWifiReceiver... isRegistered = true, unregister receiver");
        applicationContext.unregisterReceiver(this.h);
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        i();
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.f.b, (Object) connectionInfo.getSSID());
            jSONObject.put("BSSID", (Object) connectionInfo.getBSSID());
            jSONObject.put("secure", (Object) Boolean.valueOf(a(connectionInfo)));
            jSONObject.put("signalStrength", (Object) Integer.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100)));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wifi", (Object) jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", (Object) jSONObject2);
            RVLogger.d(f24001a, "processWifiConnectedCallBack... onWifiConnected, JsonParams = " + jSONObject.toJSONString());
            Page page = this.f;
            if (page != null) {
                EngineUtils.sendToRender(page.getRender(), "wifiConnected", jSONObject3, null);
            }
        }
    }

    private WifiManager i() {
        RVEnvironmentService rVEnvironmentService;
        if (this.b == null && (rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)) != null) {
            this.b = (WifiManager) rVEnvironmentService.getApplicationContext().getSystemService("wifi");
        }
        return this.b;
    }

    public static boolean isInWifiConnectCompatWhiteList(String str) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return false;
        }
        String config = rVConfigService.getConfig("ta_wifi_connect_compat_white_list", "");
        if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(str)) {
            if (TextUtils.equals(config, "all")) {
                return true;
            }
            if (TextUtils.equals(config, "none")) {
                return false;
            }
            try {
                for (String str2 : config.split(",")) {
                    if (str.equals(str2.trim())) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e("ConfigCenter", th);
            }
        }
        return false;
    }

    public void analyseConnectWifi(BridgeResponse bridgeResponse, boolean z, Page page, String str) {
        if (!(bridgeResponse instanceof BridgeResponse.Error)) {
            a.a(this.f, str, z ? 1 : 0, 0, "");
            return;
        }
        BridgeResponse.Error error = (BridgeResponse.Error) bridgeResponse;
        a.a(page, str, z ? 1 : 0, error.getErrorCode(), error.getErrorMessage());
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void connectWifi(@BindingApiContext ApiContext apiContext, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback, @BindingParam(stringDefault = "", value = {e.f.b}) String str, @BindingParam(stringDefault = "", value = {"BSSID"}) String str2, @BindingParam(booleanDefault = false, value = {"maunal"}) boolean z, @BindingParam(stringDefault = "", value = {"password"}) String str3, @BindingParam({"isWEP"}) boolean z2) {
        BridgeResponse bridgeResponseA;
        this.g = bridgeCallback;
        this.f = page;
        if (z && apiContext.getActivity() != null) {
            apiContext.getActivity().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            analyseConnectWifi(BridgeResponse.SUCCESS, true, page, str);
            return;
        }
        boolean zIsInWifiConnectCompatWhiteList = isInWifiConnectCompatWhiteList(apiContext.getAppId());
        if (zIsInWifiConnectCompatWhiteList) {
            bridgeResponseA = a(apiContext, bridgeCallback, str, str2, str3, z2);
            analyseConnectWifi(bridgeResponseA, zIsInWifiConnectCompatWhiteList, page, str);
        } else {
            bridgeResponseA = a(str, str2, str3, z2);
        }
        if (bridgeResponseA != null) {
            bridgeCallback.sendBridgeResponse(bridgeResponseA);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getConnectedWifi() {
        return a();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getWifiList(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        this.g = bridgeCallback;
        this.f = page;
        BridgeResponse bridgeResponseA = a(page);
        a(page, bridgeResponseA);
        return bridgeResponseA;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
    public void onAppPause(App app) {
        this.e = true;
        g();
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppResumePoint
    public void onAppResume(App app) {
        if (this.e) {
            f();
        }
        this.e = false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse startWifi() {
        return b();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse stopWifi() {
        return c();
    }

    private BridgeResponse a() {
        i();
        if (!this.d) {
            return new BridgeResponse.Error(ERROR_12000, "未先调用startWifi接口");
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(ERROR_12005, "未打开 Wi-Fi 开关");
        }
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.f.b, (Object) connectionInfo.getSSID());
            jSONObject.put("BSSID", (Object) connectionInfo.getBSSID());
            jSONObject.put("secure", (Object) Boolean.valueOf(a(connectionInfo)));
            jSONObject.put("signalStrength", (Object) Integer.valueOf(WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 100)));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wifi", (Object) jSONObject);
            RVLogger.d(f24001a, "getConnectedWifi... wifiInfo = " + jSONObject.toJSONString());
            return new BridgeResponse(jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("fail", (Object) Boolean.TRUE);
        return new BridgeResponse(jSONObject3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Intent intent) {
        if (intent.getIntExtra("wifi_state", 1) == 0) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifi DISABLING");
            return;
        }
        if (i().getWifiState() == 1) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifi DISABLED");
            return;
        }
        if (i().getWifiState() == 2) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifi ENABLING");
        } else if (i().getWifiState() == 3) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifi ENABLED");
        } else if (i().getWifiState() == 4) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifi UNKNOWN");
        }
    }

    private BridgeResponse a(String str, String str2, String str3, boolean z) {
        if (!this.d) {
            return new BridgeResponse.Error(ERROR_12000, "未先调用startWifi接口");
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(ERROR_12000, "未打开 Wi-Fi 开关");
        }
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            String ssid = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            String str4 = f24001a;
            RVLogger.d(str4, "connectWifi... now connecting SSID = " + ssid + " BSSID = " + bssid);
            if (TextUtils.equals(str, ssid) && (TextUtils.isEmpty(str2) || str2.equals(bssid))) {
                RVLogger.d(str4, "connectWifi... 重复连接 Wi-Fi ");
                return new BridgeResponse.Error(ERROR_12004, "重复连接 Wi-Fi");
            }
        }
        int iA = a(str, str2);
        if (iA < 0) {
            RVLogger.d(f24001a, "connectWifi... no config found, create new WifiConfig, ssid = " + str + " bssid = " + str2 + " pw = " + str3 + " isWep = " + z);
            try {
                iA = a(str, str2, str3, Boolean.valueOf(z));
            } catch (Exception e) {
                RVLogger.e(f24001a, "connectWifi... addWifiConfig fail, ", e);
                new BridgeResponse.Error(ERROR_12011, "应用在后台无法配置 Wi-Fi");
            }
        }
        if (iA >= 0) {
            RVLogger.d(f24001a, "connectWifi... create success, and connect");
            boolean zEnableNetwork = i().enableNetwork(iA, true);
            i().saveConfiguration();
            i().reconnect();
            f();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(zEnableNetwork ? "success" : "fail", (Object) Boolean.TRUE);
            return new BridgeResponse(jSONObject);
        }
        RVLogger.d(f24001a, "connectWifi... create config fail");
        return new BridgeResponse.Error(ERROR_12011, "应用在后台无法配置 Wi-Fi");
    }

    private BridgeResponse a(ApiContext apiContext, final BridgeCallback bridgeCallback, String str, String str2, String str3, boolean z) {
        WifiSecurityMode wifiSecurityMode;
        if (!this.d) {
            return new BridgeResponse.Error(ERROR_12000, "未先调用startWifi接口");
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(ERROR_12000, "未打开 Wi-Fi 开关");
        }
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        WifiInfo connectionInfo = i().getConnectionInfo();
        if (connectionInfo != null) {
            String strReplace = connectionInfo.getSSID().replace("\"", "");
            String bssid = connectionInfo.getBSSID();
            String str4 = f24001a;
            RVLogger.d(str4, "connectWifi... now connecting SSID = " + strReplace + " BSSID = " + bssid);
            if (TextUtils.equals(str, strReplace) && (TextUtils.isEmpty(str2) || str2.equals(bssid))) {
                RVLogger.d(str4, "connectWifi... 重复连接 Wi-Fi");
                return new BridgeResponse.Error(ERROR_12004, "重复连接 Wi-Fi");
            }
        }
        WifiConnector wifiConnectorA = WifiConnector.a(apiContext.getAppContext(), i());
        if (TextUtils.isEmpty(str3)) {
            wifiSecurityMode = WifiSecurityMode.OPEN;
        } else {
            wifiSecurityMode = z ? WifiSecurityMode.WEP : null;
        }
        wifiConnectorA.a(wifiConnectorA.a(str, str2, str3, wifiSecurityMode)).a(new com.alibaba.ariver.commonability.device.jsapi.wifi.core.b() { // from class: com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension.1
            @Override // com.alibaba.ariver.commonability.device.jsapi.wifi.core.b
            public void a(String str5, String str6) {
                RVLogger.d(WifiManagerBridgeExtension.f24001a, "onWifiConnectStart... ssid:" + str5 + ",bssid:" + str6);
            }

            @Override // com.alibaba.ariver.commonability.device.jsapi.wifi.core.b
            public void b(String str5, String str6) {
                RVLogger.d(WifiManagerBridgeExtension.f24001a, "onWifiConnectSuccess... ssid:" + str5 + ",bssid:" + str6);
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                WifiManagerBridgeExtension.this.h();
                a.a(WifiManagerBridgeExtension.this.f, str5, 0, "");
            }

            @Override // com.alibaba.ariver.commonability.device.jsapi.wifi.core.b
            public void a(String str5, String str6, int i) {
                BridgeResponse error;
                RVLogger.d(WifiManagerBridgeExtension.f24001a, "onWifiConnectFail... ssid:" + str5 + ",bssid:" + str6 + "，reason：" + i);
                if (i == 12002) {
                    error = new BridgeResponse.Error(WifiManagerBridgeExtension.ERROR_12002, "Wifi密码错误");
                } else if (i == 12003) {
                    error = new BridgeResponse.Error(WifiManagerBridgeExtension.ERROR_12003, "Wifi连接超时");
                } else if (i == 12001 || i == 12010) {
                    error = new BridgeResponse.Error(WifiManagerBridgeExtension.ERROR_12001, "system not support");
                } else {
                    error = i == 12007 ? new BridgeResponse.Error(WifiManagerBridgeExtension.ERROR_12001, "user denied") : BridgeResponse.UNKNOWN_ERROR;
                }
                if (error != null) {
                    bridgeCallback.sendBridgeResponse(error);
                }
                if (error instanceof BridgeResponse.Error) {
                    BridgeResponse.Error error2 = (BridgeResponse.Error) error;
                    a.a(WifiManagerBridgeExtension.this.f, str5, error2.getErrorCode(), error2.getErrorMessage());
                }
            }
        });
        return null;
    }

    private int a(String str, String str2) {
        List<WifiConfiguration> configuredNetworks = i().getConfiguredNetworks();
        if (configuredNetworks != null && configuredNetworks.size() > 0) {
            String str3 = "\"" + str + "\"";
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                if (TextUtils.equals(wifiConfiguration.SSID, str3) && (TextUtils.isEmpty(str2) || str2.equals(wifiConfiguration.BSSID))) {
                    return wifiConfiguration.networkId;
                }
            }
        }
        return -1;
    }

    private int a(String str, String str2, String str3, Boolean bool) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.BSSID = str2;
        wifiConfiguration.hiddenSSID = false;
        wifiConfiguration.status = 2;
        if (TextUtils.isEmpty(str3)) {
            wifiConfiguration.wepKeys[0] = "\"" + str3 + "\"";
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else if (bool != null && bool.booleanValue()) {
            wifiConfiguration.wepKeys[0] = "\"" + str3 + "\"";
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else {
            wifiConfiguration.preSharedKey = "\"" + str3 + "\"";
        }
        return i().addNetwork(wifiConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.DISCONNECTED)) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifiDisconnect");
            return;
        }
        if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTING)) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifiConnecting");
            return;
        }
        if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifiConnected");
            h();
        } else if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.OBTAINING_IPADDR)) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifiGettingIP");
        } else if (networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.FAILED)) {
            RVLogger.d(f24001a, "onReceiveWifiBroadcast... onWifiConnecting");
        }
    }

    private void a(Page page, BridgeResponse bridgeResponse, int i) {
        if (bridgeResponse instanceof BridgeResponse.Error) {
            BridgeResponse.Error error = (BridgeResponse.Error) bridgeResponse;
            a.a(page, i, error.getErrorCode(), error.getErrorMessage());
        } else {
            a.a(page, i, 0, "");
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains("WPA") || str.contains("wpa")) {
            return 2;
        }
        if (str.contains("WEP") || str.contains("wep")) {
            return 1;
        }
        return (str.contains("EAP") || str.contains("eap")) ? 3 : 0;
    }

    private BridgeResponse a(Page page) {
        i();
        if (!this.d) {
            return new BridgeResponse.Error(ERROR_12000, "未先调用startWifi接口");
        }
        if (!i().isWifiEnabled()) {
            return new BridgeResponse.Error(ERROR_12005, "未打开 Wi-Fi 开关");
        }
        boolean zIsAppPermissionOPen = CommonUtils.isAppPermissionOPen(page.getPageContext().getActivity());
        boolean zE = e();
        RVLogger.e(f24001a, "getWifiList... isAppPermissionOPen = " + zIsAppPermissionOPen + " & isGpsSwitchOPen = " + zE);
        if (!zIsAppPermissionOPen) {
            return new BridgeResponse.Error(ERROR_12010, "系统其他错误: 未获得定位权限");
        }
        if (!zE) {
            return new BridgeResponse.Error(ERROR_12006, "未打开 GPS 定位开关");
        }
        f();
        boolean zStartScan = i().startScan();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(zStartScan ? "success" : "fail", (Object) Boolean.TRUE);
        return new BridgeResponse(jSONObject);
    }

    private boolean a(WifiInfo wifiInfo) {
        List<WifiConfiguration> configuredNetworks = i().getConfiguredNetworks();
        if (configuredNetworks == null) {
            return false;
        }
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            String strReplace = wifiConfiguration.SSID.replace("\"", "");
            String strReplace2 = wifiInfo.getSSID().replace("\"", "");
            String str = f24001a;
            RVLogger.d(str, "checkWifiSecurity... currentSSid = " + strReplace2 + " configSSid = " + strReplace + " networkId = " + wifiConfiguration.networkId);
            if (TextUtils.equals(strReplace2, strReplace) && wifiInfo.getNetworkId() == wifiConfiguration.networkId) {
                int iA = a(wifiConfiguration);
                RVLogger.d(str, "checkWifiSecurity... 当前网络安全性：" + iA);
                return iA > 0;
            }
        }
        return false;
    }

    private static int a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            return 2;
        }
        if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            return 3;
        }
        return wifiConfiguration.wepKeys[0] != null ? 1 : 0;
    }
}
