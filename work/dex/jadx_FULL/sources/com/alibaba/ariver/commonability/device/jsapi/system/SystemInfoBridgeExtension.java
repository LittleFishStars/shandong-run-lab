package com.alibaba.ariver.commonability.device.jsapi.system;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.ViewUtils;
import com.alibaba.ariver.commonability.core.b.a;
import com.alibaba.ariver.commonability.core.d;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.commonability.device.jsapi.system.field.SystemInfoManager;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.b;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemInfoBridgeExtension implements BridgeExtension {
    public static final String TAG = "CommonAbility#systemInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23982a = "time";
    private static final String b = "getSystemInfo";
    private static boolean c = false;
    private static int d;
    private static final BroadcastReceiver h = new BroadcastReceiver() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int unused = SystemInfoBridgeExtension.d = (intent.getIntExtra(b.b, 0) * 100) / intent.getIntExtra("scale", 100);
            }
        }
    };
    private a e;
    private Map<String, JSONObject> f = new ConcurrentHashMap();
    private final BroadcastReceiver g = new BroadcastReceiver() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (SystemInfoBridgeExtension.this.f.isEmpty()) {
                return;
            }
            SystemInfoBridgeExtension.this.f.clear();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(ApiContext apiContext, Page page) {
        if (this.e == null) {
            return null;
        }
        a.C0141a c0141aA = a.C0141a.a();
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (TextUtils.equals(rVConfigService != null ? rVConfigService.getConfig("ta_getDefaultHeight", "YES") : null, "YES")) {
            Bundle startParams = page.getStartParams();
            String string = startParams.getString("enableTabBar");
            String string2 = startParams.getString(RVStartParams.KEY_FRAGMENT_TYPE);
            if (TextUtils.equals(string, "YES") || TextUtils.equals(string2, RVStartParams.FRAGMENT_TYPE_SUB_TAB)) {
                c0141aA.l = true;
            }
            c0141aA.b = startParams.getBoolean("fullscreen", false);
        }
        c0141aA.m = apiContext.getAppId();
        c0141aA.h = page.getApp().getAppContext().getViewSpecProvider().getTitleBarRawHeight();
        c0141aA.i = View.MeasureSpec.getSize(page.getApp().getAppContext().getViewSpecProvider().getTabBarHeightSpec());
        if (page.getRender() == null || page.getRender().getView() == null) {
            RVLogger.d(TAG, "page render :" + page.getRender());
        } else {
            c0141aA.j = page.getRender().getView().getHeight();
        }
        c0141aA.g = b();
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService != null) {
            c0141aA.f = rVEnvironmentService.getProductVersion();
        }
        a(c0141aA);
        String string3 = page.getStartParams().getString("transparentTitle");
        if (TextUtils.equals(string3, "auto") || TextUtils.equals(string3, RVStartParams.TRANSPARENT_TITLE_ALWAYS) || TextUtils.equals(string3, "custom")) {
            c0141aA.k = true;
        } else {
            c0141aA.k = false;
        }
        c0141aA.o = page.getInstanceType();
        JSONObject jSONObjectA = this.e.a(apiContext.getActivity(), c0141aA);
        RVSystemInfoProcessor rVSystemInfoProcessor = (RVSystemInfoProcessor) RVProxy.get(RVSystemInfoProcessor.class, true);
        return rVSystemInfoProcessor != null ? rVSystemInfoProcessor.process(jSONObjectA) : jSONObjectA;
    }

    private boolean b(String str) {
        boolean zEquals = TextUtils.equals(com.alibaba.ariver.commonability.core.util.b.a(str, "ta_system_switch_new_impl", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE), "true");
        RVLogger.d(TAG, "switchNewImpl：" + zEquals);
        return zEquals;
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getSystemInfo(@BindingApiContext ApiContext apiContext, @BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam(booleanDefault = true, value = {"needCache"}) boolean z, @BindingParam({"options"}) String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("getSystemInfo#");
        sb.append(this.e == null ? "first" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append(app.isFirstPage() ? "index0" : "index1");
        String string2 = sb2.toString();
        if (this.e == null) {
            this.e = new a();
        }
        if (b(app.getAppId())) {
            String str = string2 + "#new";
            d.a().a(str);
            bridgeCallback.sendJSONResponse(SystemInfoManager.getInstance().getValues(app, strArr));
            d.a().a(str, 3);
            return;
        }
        if (z) {
            JSONObject jSONObject = this.f.get("getSystemInfo");
            long j = CommonUtils.getLong(jSONObject, "time");
            if (jSONObject != null && j > 0 && System.currentTimeMillis() - j < 60000) {
                bridgeCallback.sendJSONResponse(a(apiContext.getActivity()));
                RVLogger.d(TAG, "use cache");
                return;
            }
        }
        if (this.e == null) {
            this.e = new a();
        }
        try {
            d.a().a(string2 + "#old");
            a(apiContext, app, z, bridgeCallback);
        } catch (Exception e) {
            RVLogger.e(TAG, e.getMessage());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this.g);
        a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this.g, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED_NEBULA"));
        SystemInfoManager.init(applicationContext);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private int b() {
        if (c) {
            return d;
        }
        try {
            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = applicationContext.registerReceiver(h, intentFilter);
            c = true;
            if ("android.intent.action.BATTERY_CHANGED".equals(intentRegisterReceiver.getAction())) {
                int intExtra = (intentRegisterReceiver.getIntExtra(b.b, 0) * 100) / intentRegisterReceiver.getIntExtra("scale", 100);
                d = intExtra;
                return intExtra;
            }
        } catch (Exception e) {
            RVLogger.e("getCurrentBatteryPercentage...e=" + e);
        }
        return d;
    }

    private void a(a.C0141a c0141a) {
        RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
        if (rVCommonAbilityProxy == null) {
            return;
        }
        c0141a.f23934a = rVCommonAbilityProxy.getAppAlias();
        c0141a.c = rVCommonAbilityProxy.getDevicePerformance();
        c0141a.d = rVCommonAbilityProxy.getLocalLanguage();
        c0141a.e = rVCommonAbilityProxy.getFontSizeSetting();
    }

    private void a(final ApiContext apiContext, final App app, final boolean z, final BridgeCallback bridgeCallback) {
        Bundle startParams;
        if (a(apiContext.getAppId()) && RVProxy.get(RVExecutorService.class) != null) {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension.3
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObjectA;
                    try {
                        jSONObjectA = SystemInfoBridgeExtension.this.a(apiContext, app.getActivePage());
                    } catch (Exception e) {
                        RVLogger.e(SystemInfoBridgeExtension.TAG, e.getMessage());
                        jSONObjectA = null;
                    }
                    if (z && jSONObjectA != null) {
                        SystemInfoBridgeExtension.this.a(jSONObjectA);
                    }
                    bridgeCallback.sendJSONResponse(jSONObjectA);
                    d.a().a("getSystemInfo#" + app.isFirstPage() + "#old", 3);
                }
            });
            return;
        }
        a.C0141a c0141aA = a.C0141a.a();
        if (app.getActivePage() != null && app.getActivePage().getStartParams() != null) {
            startParams = app.getActivePage().getStartParams();
        } else {
            startParams = app.getStartParams();
        }
        c0141aA.n = startParams.getInt(RVStartParams.KEY_NAVIGATION_BAR_STATUS);
        c0141aA.o = app.getInstanceType();
        c0141aA.l = a(app);
        c0141aA.b = startParams.getBoolean("fullscreen", false);
        c0141aA.g = b();
        c0141aA.k = ViewUtils.isTransparentTitle(startParams, startParams.getString("transparentTitle"));
        if (app.getAppContext() != null && app.getAppContext().getViewSpecProvider() != null) {
            ViewSpecProvider viewSpecProvider = app.getAppContext().getViewSpecProvider();
            c0141aA.h = viewSpecProvider.getTitleBarRawHeight();
            c0141aA.i = View.MeasureSpec.getSize(viewSpecProvider.getTabBarHeightSpec());
        }
        Page activePage = app.getActivePage();
        if (activePage != null && activePage.getRender() != null && activePage.getRender().getView() != null) {
            c0141aA.j = activePage.getRender().getView().getHeight();
        }
        if (RVProxy.get(RVEnvironmentService.class) != null) {
            c0141aA.f = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getProductVersion();
        }
        if (RVProxy.get(RVCommonAbilityProxy.class) != null) {
            RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
            c0141aA.f23934a = rVCommonAbilityProxy.getAppAlias();
            c0141aA.c = rVCommonAbilityProxy.getDevicePerformance();
            c0141aA.d = rVCommonAbilityProxy.getLocalLanguage();
            c0141aA.e = rVCommonAbilityProxy.getFontSizeSetting();
        }
        c0141aA.m = apiContext.getAppId();
        JSONObject jSONObjectA = this.e.a(apiContext.getActivity(), c0141aA);
        if (z && jSONObjectA != null) {
            a(jSONObjectA);
        }
        bridgeCallback.sendJSONResponse(jSONObjectA);
    }

    private boolean a(App app) {
        Bundle startParams;
        return app != null && (startParams = app.getStartParams()) != null && TextUtils.equals(startParams.getString("enableTabBar"), "YES") && app.isFirstPage();
    }

    private boolean a(String str) {
        boolean zEquals = TextUtils.equals(com.alibaba.ariver.commonability.core.util.b.a(str, "ta_system_switch_ui", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE), AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        RVLogger.d(TAG, "switchUIThread：" + zEquals);
        return zEquals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("time", (Object) Long.valueOf(System.currentTimeMillis()));
        jSONObject2.put("data", (Object) jSONObject);
        this.f.put("getSystemInfo", jSONObject2);
    }

    private void a() {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SystemInfoBridgeExtension.c) {
                        ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().unregisterReceiver(SystemInfoBridgeExtension.h);
                        boolean unused = SystemInfoBridgeExtension.c = false;
                    }
                } catch (Throwable th) {
                    RVLogger.e(SystemInfoBridgeExtension.TAG, "unregisterBroadcastReceiver...e=" + th);
                }
            }
        });
    }

    private JSONObject a(Activity activity) {
        JSONObject jSONObject = this.f.get("getSystemInfo").getJSONObject("data");
        a aVar = this.e;
        if (aVar != null && activity != null) {
            aVar.a(activity, jSONObject);
        }
        if (!com.alibaba.ariver.commonability.core.util.b.a("ta_systeminfo_cache_copy", false)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putAll(jSONObject);
        return jSONObject2;
    }
}
