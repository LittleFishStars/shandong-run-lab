package com.alibaba.triver.basic.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PluginStorageBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24744a = "未找到该数据";
    private static final String b = "Key不能为空";
    private static final String c = "不支持非插件调用";
    private static final long d = 5242880;

    @Nullable
    private static SharedPreferences a(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("rv_local_storage_plugin_space_" + str, 0);
    }

    @Nullable
    private static JSONObject b(Context context, String str) {
        SharedPreferences sharedPreferencesA = a(context, str);
        if (sharedPreferencesA == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Map<String, ?> all = sharedPreferencesA.getAll();
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            int length = 0;
            try {
                length = 0 + ((String) entry.getValue()).getBytes("utf-8").length;
                length += entry.getKey().getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
            d2 += (double) length;
        }
        jSONObject.put("keys", (Object) all.keySet());
        jSONObject.put("currentSize", (Object) Double.valueOf(d2 / 1024.0d));
        jSONObject.put("limitSize", (Object) 5120L);
        return jSONObject;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void clearPluginStorage(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str) {
        Context applicationContext = app.getAppContext().getContext().getApplicationContext();
        String strA = a(str);
        if (strA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, c));
            return;
        }
        SharedPreferences sharedPreferencesA = a(applicationContext, strA);
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
        } else {
            sharedPreferencesA.edit().clear().apply();
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getPluginStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {CachedContentIndex.a.e}) String str, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        JSONObject jSONObject = new JSONObject();
        Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
        String strA = a(str2);
        if (strA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, c));
            return;
        }
        SharedPreferences sharedPreferencesA = a(applicationContext, strA);
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
        } else if (sharedPreferencesA.contains(str)) {
            jSONObject.put("data", (Object) sharedPreferencesA.getString(str, ""));
            bridgeCallback.sendJSONResponse(jSONObject);
        } else {
            jSONObject.put("data", "");
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getPluginStorageInfo(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str) {
        Context applicationContext = app.getAppContext().getContext().getApplicationContext();
        String strA = a(str);
        if (strA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, c));
            return;
        }
        JSONObject jSONObjectB = b(applicationContext, strA);
        if (jSONObjectB != null) {
            bridgeCallback.sendJSONResponse(jSONObjectB);
        } else {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(1, "get sharedPreferences info error."));
        }
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

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void removePluginStorage(@BindingNode(App.class) App app, @BindingParam(name = {CachedContentIndex.a.e}) String str, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        Context applicationContext = app.getAppContext().getContext().getApplicationContext();
        String strA = a(str2);
        if (strA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, c));
            return;
        }
        SharedPreferences sharedPreferencesA = a(applicationContext, strA);
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
        } else if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
        } else {
            sharedPreferencesA.edit().remove(str).apply();
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void setPluginStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {CachedContentIndex.a.e}) String str, @BindingParam(name = {"data"}) Object obj, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        String jSONString;
        Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
        String strA = a(str2);
        if (strA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, c));
            return;
        }
        SharedPreferences sharedPreferencesA = a(applicationContext, strA);
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, b));
            return;
        }
        if (obj instanceof String) {
            jSONString = (String) obj;
        } else {
            jSONString = obj instanceof JSONObject ? ((JSONObject) obj).toJSONString() : null;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(jSONString)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24744a));
        } else {
            sharedPreferencesA.edit().putString(str, jSONString).apply();
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    private String a(String str) {
        if (TRiverUtils.isPluginInvokeThisApi(str)) {
            return str;
        }
        return null;
    }
}
