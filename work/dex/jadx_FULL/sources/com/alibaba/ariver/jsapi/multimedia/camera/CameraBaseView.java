package com.alibaba.ariver.jsapi.multimedia.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class CameraBaseView extends View {
    public CameraBaseView(Context context) {
        super(context);
    }

    public abstract void a(BridgeCallback bridgeCallback);

    public abstract void a(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void a(String str, JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void b(BridgeCallback bridgeCallback);

    public abstract void b(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void c(BridgeCallback bridgeCallback);

    public abstract void c(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void setConfig(Map<String, String> map);

    public CameraBaseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CameraBaseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public CameraBaseView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
