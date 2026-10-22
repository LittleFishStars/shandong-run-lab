package com.alibaba.ariver.jsapi.multimedia.camera;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.embedview.IEmbedCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.video.video.h;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a implements IEmbedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24158a = "takePhoto";
    public static final String b = "startRecord";
    public static final String c = "stopRecord";
    private static final String e = "CameraBaseEmbedView";
    private static final String f = "hasHeadSet";
    protected CameraBaseView d;

    public abstract CameraBaseView a(Map<String, String> map);

    public abstract void a(CameraBaseView cameraBaseView);

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return h.d;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        RVLogger.d(e, "getView, width=" + i + ", height=" + i2 + ", viewId=" + str + ", type=" + str2 + ", params=" + map);
        if (this.d == null) {
            this.d = a(map);
        }
        CameraBaseView cameraBaseView = this.d;
        if (cameraBaseView == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
            return null;
        }
        cameraBaseView.setConfig(map);
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        RVLogger.d(e, "onAttachedToWebView");
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        RVLogger.d(e, "onCreate, params=" + map);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        RVLogger.d(e, "onDestroy");
        CameraBaseView cameraBaseView = this.d;
        if (cameraBaseView == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        } else {
            a(cameraBaseView);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        RVLogger.d(e, "onDetachedToWebView");
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
        RVLogger.d(e, "onEmbedViewVisibilityChanged, reason=" + i);
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onParamChanged(String[] strArr, String[] strArr2) {
        RVLogger.d(e, "onParamChanged, names=" + strArr + ", values=" + strArr2);
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.d(e, "onReceivedMessage, actionType=" + str + ", data=" + jSONObject);
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "baseview not initialized"));
                return;
            }
            return;
        }
        if (f24158a.equalsIgnoreCase(str)) {
            this.d.b(jSONObject, bridgeCallback);
            return;
        }
        if (b.equalsIgnoreCase(str)) {
            this.d.c(jSONObject, bridgeCallback);
            return;
        }
        if (c.equalsIgnoreCase(str)) {
            this.d.a(bridgeCallback);
        } else if (f.equalsIgnoreCase(str)) {
            this.d.c(bridgeCallback);
        } else {
            this.d.a(str, jSONObject, bridgeCallback);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.d(e, "onReceivedRender, data=" + jSONObject);
        CameraBaseView cameraBaseView = this.d;
        if (cameraBaseView != null) {
            cameraBaseView.a(jSONObject, bridgeCallback);
            return;
        }
        RVLogger.e(e, "Error: BaseView");
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "baseview not initialized"));
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        RVLogger.d(e, "onRequestPermissionResult, resultCode=" + i + ", permissions=" + strArr + ", grantResult=" + iArr);
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        RVLogger.d(e, "onWebViewPause");
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        RVLogger.d(e, "onWebViewResume");
        if (this.d == null) {
            RVLogger.e(e, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void sendEvent(String str, JSONObject jSONObject, @Nullable IEmbedCallback iEmbedCallback) {
        RVLogger.d(e, "sendEvent, eventName=" + str + ", data=" + jSONObject);
    }
}
