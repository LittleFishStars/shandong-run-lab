package com.alibaba.ariver.jsapi.multimedia.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class VideoBaseView extends View {
    public VideoBaseView(Context context) {
        super(context);
    }

    public abstract void a(BridgeCallback bridgeCallback);

    public abstract void a(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void a(String str, JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void b(BridgeCallback bridgeCallback);

    public abstract void b(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void c(BridgeCallback bridgeCallback);

    public abstract void c(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void d(BridgeCallback bridgeCallback);

    public abstract void d(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void e(BridgeCallback bridgeCallback);

    public abstract void e(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void f(BridgeCallback bridgeCallback);

    public abstract void f(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void g(BridgeCallback bridgeCallback);

    public abstract void g(JSONObject jSONObject, BridgeCallback bridgeCallback);

    public abstract void setConfig(Map<String, String> map);

    public VideoBaseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoBaseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public VideoBaseView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
