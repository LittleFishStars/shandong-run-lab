package com.alibaba.ariver.jsapi.multimedia.video;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.embedview.IEmbedCallback;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a implements IEmbedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24159a = "play";
    public static final String b = "pause";
    public static final String c = "resume";
    public static final String d = "seek";
    public static final String e = "stop";
    public static final String f = "mute";
    public static final String g = "sendDanmu";
    public static final String h = "playbackRate";
    public static final String i = "requestFullScreen";
    public static final String j = "exitFullScreen";
    private static final String l = "VideoBaseEmbedView";
    protected VideoBaseView k;

    public abstract VideoBaseView a(Map<String, String> map);

    public abstract void a(VideoBaseView videoBaseView);

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return "video";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i2, int i3, String str, String str2, Map<String, String> map) {
        RVLogger.d(l, "getView, width=" + i2 + ", height=" + i3 + ", viewId=" + str + ", type=" + str2 + ", params=" + map);
        if (this.k == null) {
            this.k = a(map);
        }
        VideoBaseView videoBaseView = this.k;
        if (videoBaseView == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
            return null;
        }
        videoBaseView.setConfig(map);
        return this.k;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        RVLogger.d(l, "onAttachedToWebView");
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onCreate(Map<String, String> map) {
        RVLogger.d(l, "onCreate, params=" + map);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        RVLogger.d(l, "onDestroy");
        VideoBaseView videoBaseView = this.k;
        if (videoBaseView == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        } else {
            a(videoBaseView);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
        RVLogger.d(l, "onDetachedToWebView");
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i2) {
        RVLogger.d(l, "onEmbedViewVisibilityChanged, reason=" + i2);
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onParamChanged(String[] strArr, String[] strArr2) {
        RVLogger.d(l, "onParamChanged, names=" + strArr + ", values=" + strArr2);
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.d(l, "onReceivedMessage, actionType=" + str + ", data=" + jSONObject);
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "baseview not initialized"));
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(l, "Error: actionType invalid");
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "action invalid"));
                return;
            }
            return;
        }
        str.hashCode();
        switch (str) {
            case "exitFullScreen":
                this.k.g(bridgeCallback);
                break;
            case "sendDanmu":
                this.k.d(jSONObject, bridgeCallback);
                break;
            case "mute":
                this.k.e(jSONObject, bridgeCallback);
                break;
            case "play":
                this.k.b(jSONObject, bridgeCallback);
                break;
            case "seek":
                this.k.f(jSONObject, bridgeCallback);
                break;
            case "stop":
                this.k.c(bridgeCallback);
                break;
            case "pause":
                this.k.a(bridgeCallback);
                break;
            case "requestFullScreen":
                this.k.g(jSONObject, bridgeCallback);
                break;
            case "playbackRate":
                this.k.c(jSONObject, bridgeCallback);
                break;
            default:
                this.k.a(str, jSONObject, bridgeCallback);
                break;
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        RVLogger.d(l, "onReceivedRender, data=" + jSONObject);
        VideoBaseView videoBaseView = this.k;
        if (videoBaseView != null) {
            videoBaseView.a(jSONObject, bridgeCallback);
            return;
        }
        RVLogger.e(l, "Error: BaseView not initialized");
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, "baseview not initialized"));
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i2, String[] strArr, int[] iArr) {
        RVLogger.d(l, "onRequestPermissionResult, resultCode=" + i2 + ", permissions=" + strArr + ", grantResult=" + iArr);
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        RVLogger.d(l, "onWebViewPause");
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        RVLogger.d(l, "onWebViewResume");
        if (this.k == null) {
            RVLogger.e(l, "Error: BaseView not initialized");
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void sendEvent(String str, JSONObject jSONObject, @Nullable IEmbedCallback iEmbedCallback) {
        RVLogger.d(l, "sendEvent, eventName=" + str + ", data=" + jSONObject);
    }
}
