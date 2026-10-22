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
import com.alibaba.ariver.remotedebug.b.a;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StorageBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24745a = "未找到该数据";
    private static final String b = "Key不能为空";
    private static final long c = 5242880;

    @Nullable
    private static SharedPreferences a(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("rv_local_storage_" + str, 0);
    }

    @Nullable
    private static JSONObject b(Context context, String str) {
        SharedPreferences sharedPreferencesA = a(context, str);
        if (sharedPreferencesA == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Map<String, ?> all = sharedPreferencesA.getAll();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            int length = 0;
            try {
                length = 0 + ((String) entry.getValue()).getBytes("utf-8").length;
                length += entry.getKey().getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
            d += (double) length;
        }
        jSONObject.put("keys", (Object) all.keySet());
        jSONObject.put("currentSize", (Object) Double.valueOf(d / 1024.0d));
        jSONObject.put("limitSize", (Object) 5120L);
        return jSONObject;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void clearTinyLocalStorage(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str) {
        SharedPreferences sharedPreferencesA = a(app.getAppContext().getContext().getApplicationContext(), a(str, app));
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
        } else {
            sharedPreferencesA.edit().clear().commit();
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getSharedData(@BindingNode(Page.class) Page page, @BindingParam(name = {"keys"}) JSONArray jSONArray, @BindingCallback BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("data", (Object) jSONObject2);
        SharedPreferences sharedPreferencesA = a(page.getApp().getAppContext().getContext().getApplicationContext(), "global");
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string) && sharedPreferencesA.contains(string)) {
                jSONObject2.put(string, (Object) sharedPreferencesA.getString(string, ""));
            }
        }
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getTinyLocalStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {CachedContentIndex.a.e}) String str, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        JSONObject jSONObject = new JSONObject();
        SharedPreferences sharedPreferencesA = a(page.getApp().getAppContext().getContext().getApplicationContext(), a(str2, page.getApp()));
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
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
    public void getTinyLocalStorageInfo(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str) {
        JSONObject jSONObjectB = b(app.getAppContext().getContext().getApplicationContext(), a(str, app));
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
    public void removeTinyLocalStorage(@BindingNode(App.class) App app, @BindingParam(name = {CachedContentIndex.a.e}) String str, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        SharedPreferences sharedPreferencesA = a(app.getAppContext().getContext().getApplicationContext(), a(str2, app));
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
        } else if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
        } else {
            sharedPreferencesA.edit().remove(str).commit();
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void setSharedData(@BindingNode(Page.class) Page page, @BindingParam(name = {"data"}) JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        SharedPreferences sharedPreferencesA = a(page.getApp().getAppContext().getContext().getApplicationContext(), "global");
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
            return;
        }
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String string = entry.getKey().toString();
            String string2 = entry.getValue().toString();
            if (TextUtils.isEmpty(string)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, b));
                return;
            } else if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
            } else {
                sharedPreferencesA.edit().putString(string, string2).commit();
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void setTinyLocalStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {CachedContentIndex.a.e}) String str, @BindingParam(name = {"data"}) Object obj, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"__appxDomain"}) String str2) {
        String jSONString;
        SharedPreferences sharedPreferencesA = a(page.getApp().getAppContext().getContext().getApplicationContext(), a(str2, page.getApp()));
        if (sharedPreferencesA == null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
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
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, f24745a));
            return;
        }
        sharedPreferencesA.edit().putString(str, jSONString).commit();
        if (CommonUtils.isMiniAppDebug(page.getApp())) {
            a.a(page, sharedPreferencesA.getAll());
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    private String a(String str, App app) {
        if (!TROrangeController.enablePluginAppStorageIsolation()) {
            return app.getAppId();
        }
        if (!TRiverUtils.isPluginInvokeThisApi(str)) {
            return app.getAppId();
        }
        return app.getAppId() + "_plugin_" + str;
    }
}
