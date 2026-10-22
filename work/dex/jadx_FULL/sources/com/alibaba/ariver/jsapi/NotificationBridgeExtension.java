package com.alibaba.ariver.jsapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.biz.PostNotificationPoint;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Remote
@Keep
public class NotificationBridgeExtension implements PageStartedPoint, BridgeExtension {
    private static final String FIRE_NOTIFY = "fireNotify";
    public static final String NOTIFY_PREFIX = "NEBULANOTIFY_";
    public static final String TAG = "AriverAPI:NotificationBridgeExtension";
    private ApiContext mApiContext;
    private LocalBroadcastManager mBroadcastManager = null;
    private Map<String, Boolean> mBroadcastNameRemMap = null;
    private Map<String, BroadcastReceiver> mReceiverMap = null;

    public class NotifyBroadcastReceiver extends BroadcastReceiver {
        private String b;
        private BridgeCallback c;

        public NotifyBroadcastReceiver(String str, BridgeCallback bridgeCallback) {
            this.b = str;
            this.c = bridgeCallback;
        }

        private void a(Bundle bundle) {
            if (NotificationBridgeExtension.this.mApiContext == null) {
                RVLogger.d(NotificationBridgeExtension.TAG, "sendToWeb mApiContext is null.");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = BundleUtils.toJSONObject(bundle);
            jSONObject.put("data", (Object) jSONObject2);
            jSONObject2.put("notificationName", (Object) this.b);
            NotificationBridgeExtension.this.mApiContext.sendEvent(NotificationBridgeExtension.FIRE_NOTIFY, jSONObject, null);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || NotificationBridgeExtension.this.mBroadcastNameRemMap == null || NotificationBridgeExtension.this.mBroadcastNameRemMap.get(this.b) == null || NotificationBridgeExtension.this.mBroadcastManager == null || TextUtils.isEmpty(this.b)) {
                return;
            }
            Bundle bundle = new Bundle();
            try {
                bundle = intent.getExtras();
            } catch (Exception e) {
                RVLogger.e(NotificationBridgeExtension.TAG, "getExtras Exception", e);
            }
            if (((Boolean) NotificationBridgeExtension.this.mBroadcastNameRemMap.get(this.b)).booleanValue()) {
                this.c.sendJSONResponse(BundleUtils.toJSONObject(bundle), true);
            } else {
                this.c.sendJSONResponse(BundleUtils.toJSONObject(bundle));
                NotificationBridgeExtension.this.mBroadcastManager.unregisterReceiver(this);
                NotificationBridgeExtension.this.mBroadcastNameRemMap.remove(this.b);
            }
            a(bundle);
        }
    }

    private void ensureBroadcastManager() {
        if (this.mBroadcastManager != null) {
            return;
        }
        this.mBroadcastManager = LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
        this.mBroadcastNameRemMap = new ConcurrentHashMap();
        this.mReceiverMap = new ConcurrentHashMap();
    }

    @ActionFilter
    public void addNotifyListener(@BindingParam(required = true, value = {"name"}) String str, @BindingParam(booleanDefault = true, value = {"keep"}) boolean z, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        ensureBroadcastManager();
        this.mApiContext = apiContext;
        if (this.mBroadcastNameRemMap.containsKey(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "repeat event"));
            return;
        }
        this.mBroadcastNameRemMap.put(str, Boolean.valueOf(z));
        NotifyBroadcastReceiver notifyBroadcastReceiver = new NotifyBroadcastReceiver(str, bridgeCallback);
        this.mBroadcastManager.registerReceiver(notifyBroadcastReceiver, new IntentFilter(str));
        this.mReceiverMap.put(str, notifyBroadcastReceiver);
        RVLogger.d(TAG, "addNotifyListener action: " + str);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        Map<String, BroadcastReceiver> map = this.mReceiverMap;
        if (map != null) {
            for (Map.Entry<String, BroadcastReceiver> entry : map.entrySet()) {
                this.mBroadcastManager.unregisterReceiver(entry.getValue());
                this.mBroadcastNameRemMap.remove(entry.getKey());
            }
            this.mReceiverMap.clear();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageStartedPoint
    public void onStarted(String str) {
        if (this.mBroadcastManager != null) {
            Iterator<BroadcastReceiver> it = this.mReceiverMap.values().iterator();
            while (it.hasNext()) {
                this.mBroadcastManager.unregisterReceiver(it.next());
            }
        }
        Map<String, Boolean> map = this.mBroadcastNameRemMap;
        if (map != null) {
            map.clear();
        }
        Map<String, BroadcastReceiver> map2 = this.mReceiverMap;
        if (map2 != null) {
            map2.clear();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse postNotification(@BindingParam(required = true, value = {"name"}) String str, @BindingParam({"data"}) JSONObject jSONObject, @BindingNode(Page.class) Page page) {
        ensureBroadcastManager();
        Intent intent = new Intent();
        String str2 = NOTIFY_PREFIX + str;
        intent.setAction(str2);
        if (jSONObject != null) {
            for (String str3 : jSONObject.keySet()) {
                intent.putExtra(str3, String.valueOf(JSONUtils.getValue(jSONObject, str3, new Object())));
            }
        }
        RVLogger.d(TAG, "postNotify action:" + str2 + " intent data " + jSONObject);
        this.mBroadcastManager.sendBroadcast(intent);
        ((PostNotificationPoint) ExtensionPoint.as(PostNotificationPoint.class).node(page).create()).handlePostNotification(str, jSONObject, page);
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse removeNotifyListener(@BindingParam(required = true, value = {"name"}) String str) {
        ensureBroadcastManager();
        if (this.mReceiverMap.containsKey(str)) {
            this.mBroadcastManager.unregisterReceiver(this.mReceiverMap.get(str));
            this.mBroadcastNameRemMap.remove(str);
        }
        return BridgeResponse.SUCCESS;
    }
}
