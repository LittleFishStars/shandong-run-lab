package com.desgemini.mini_media_common;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.taobao.windmill.module.base.Status;
import com.taobao.windmill.module.base.b;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JSContextAdapter {
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private Context context;
    private b jsInvokeContext;

    public JSContextAdapter(BridgeCallback bridgeCallback, Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        this.bridgeCallback = bridgeCallback;
    }

    private JSONObject getFailedJsonObject(JSONObject jSONObject) {
        jSONObject.put("error", (Object) 1);
        return jSONObject;
    }

    private JSONObject getSuccessJsonObject(JSONObject jSONObject) {
        jSONObject.put("success", "true");
        return jSONObject;
    }

    public void failed() {
        failed(new HashMap());
    }

    @Nullable
    public Activity getActivity() {
        return this.activity;
    }

    @Nullable
    public Context getContext() {
        return this.context;
    }

    public boolean isAriverMode() {
        return this.bridgeCallback != null;
    }

    public void success(JSONObject jSONObject) {
        b bVar = this.jsInvokeContext;
        if (bVar != null) {
            bVar.a(jSONObject);
            return;
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(getSuccessJsonObject(jSONObject));
        }
    }

    public void failed(Map<String, Object> map) {
        b bVar = this.jsInvokeContext;
        if (bVar != null) {
            bVar.b(map);
            return;
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(getFailedJsonObject(new JSONObject(map)));
        }
    }

    public JSContextAdapter(BridgeCallback bridgeCallback, Activity activity) {
        this.activity = activity;
        this.context = activity;
        this.bridgeCallback = bridgeCallback;
    }

    public void success() {
        success(new JSONObject());
    }

    public void failed(Status status, JSONObject jSONObject) {
        b bVar = this.jsInvokeContext;
        if (bVar != null) {
            bVar.a(status, jSONObject);
            return;
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback != null) {
            bridgeCallback.sendJSONResponse(getFailedJsonObject(jSONObject));
        }
    }

    public void success(Map<String, Object> map) {
        success(new JSONObject(map));
    }

    public JSContextAdapter(b bVar) {
        this.jsInvokeContext = bVar;
        this.activity = (Activity) bVar.b();
        this.context = bVar.b();
    }

    public void failed(Status status, Map<String, Object> map) {
        if (map == null) {
            failed(status, new JSONObject());
        } else {
            failed(status, new JSONObject(map));
        }
    }
}
