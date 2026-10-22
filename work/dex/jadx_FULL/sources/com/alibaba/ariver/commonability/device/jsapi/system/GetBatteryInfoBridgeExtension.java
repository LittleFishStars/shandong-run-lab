package com.alibaba.ariver.commonability.device.jsapi.system;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.b;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBatteryInfoBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23980a = "com.alibaba.ariver.commonability.device.jsapi.system.GetBatteryInfoBridgeExtension";
    private BridgeCallback d;
    private IntentFilter b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private volatile boolean c = false;
    private BroadcastReceiver e = new BroadcastReceiver() { // from class: com.alibaba.ariver.commonability.device.jsapi.system.GetBatteryInfoBridgeExtension.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int intExtra = intent.getIntExtra(b.b, 0);
                boolean z = intent.getIntExtra("plugged", 0) != 0;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(b.b, (Object) Integer.valueOf(intExtra));
                jSONObject.put("isCharging", (Object) Boolean.valueOf(z));
                GetBatteryInfoBridgeExtension.this.d.sendBridgeResponse(new BridgeResponse(jSONObject));
            } catch (Throwable unused) {
            }
            GetBatteryInfoBridgeExtension.this.b();
        }
    };

    private void a() {
        Application applicationContext;
        try {
            if (!this.c) {
                this.c = true;
                RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
                if (rVEnvironmentService == null || (applicationContext = rVEnvironmentService.getApplicationContext()) == null) {
                    RVLogger.d(f23980a, "register battery receiver failed");
                } else {
                    applicationContext.registerReceiver(this.e, this.b);
                }
            }
        } catch (Throwable th) {
            RVLogger.e(f23980a, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Application applicationContext;
        try {
            if (this.c) {
                this.c = false;
                RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
                if (rVEnvironmentService == null || (applicationContext = rVEnvironmentService.getApplicationContext()) == null) {
                    return;
                }
                applicationContext.unregisterReceiver(this.e);
            }
        } catch (Throwable th) {
            RVLogger.e(f23980a, th);
        }
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    public void getBatteryInfo(@BindingCallback BridgeCallback bridgeCallback) {
        this.d = bridgeCallback;
        a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.d = null;
        b();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
