package com.alibaba.triver.basic.canvas;

import android.text.TextPaint;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CanvasBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24689a = "CanvasBridgeExtension";

    @ActionFilter
    public void measureText(@BindingParam(intDefault = 10, value = {"fontSize"}) int i, @BindingParam({"fontWeight"}) String str, @BindingParam({"text"}) String str2, @BindingCallback BridgeCallback bridgeCallback) {
        try {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(i);
            textPaint.setFakeBoldText(!TextUtils.isEmpty(str) && "bold".equals(str));
            Float fValueOf = Float.valueOf(textPaint.measureText(str2, 0, str2.length()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", (Object) fValueOf);
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Throwable th) {
            RVLogger.e(f24689a, "measureText...e=" + th);
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
}
