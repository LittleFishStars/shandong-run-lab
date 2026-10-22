package com.alibaba.ariver.commonability.device.jsapi.screen;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.credentials.utils.AuthConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ScreenBrightnessBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23973a = "brightness";
    private static final String b = "ScreenBrightnessBridgeExtension";
    private static final int c = -1;
    private static Integer d = -1;
    private float e = -1.0f;

    private boolean a(float f, ApiContext apiContext) {
        Activity activity = apiContext.getActivity();
        if (activity == null) {
            return false;
        }
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
        if (!Settings.System.canWrite(activity)) {
            return true;
        }
        Settings.System.putInt(activity.getContentResolver(), "screen_brightness", (int) (f * a(activity)));
        return true;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getScreenBrightness(@BindingApiContext ApiContext apiContext) {
        JSONObject jSONObject = new JSONObject();
        float fA = a(apiContext);
        RVLogger.d(b, "currentBrightness: " + fA);
        jSONObject.put(f23973a, (Object) Float.valueOf(fA));
        jSONObject.put("success", (Object) Boolean.TRUE);
        return new BridgeResponse(jSONObject);
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

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setScreenAutolock(@BindingApiContext ApiContext apiContext, @BindingParam(name = {"actionType"}) String str) {
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        if (apiContext.getActivity() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        Activity activity = apiContext.getActivity();
        if (TextUtils.equals(str, "disable")) {
            activity.getWindow().setFlags(128, 128);
        } else if (TextUtils.equals(str, AuthConstant.INI_ENABLE)) {
            activity.getWindow().clearFlags(128);
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setScreenBrightness(@BindingParam(floatDefault = -1.0f, value = {f23973a}) float f, @BindingApiContext ApiContext apiContext) {
        boolean zA;
        if (f < 0.0f || f > 1.0f) {
            return BridgeResponse.INVALID_PARAM;
        }
        try {
            zA = a(f, apiContext);
            this.e = f;
        } catch (Exception e) {
            RVLogger.e(b, "setScreenBrightness", e);
            zA = false;
        }
        return zA ? BridgeResponse.SUCCESS : BridgeResponse.UNKNOWN_ERROR;
    }

    private float a(ApiContext apiContext) {
        float f = this.e;
        if (f != -1.0f) {
            return f;
        }
        float f2 = 0.0f;
        if (apiContext == null || apiContext.getActivity() == null) {
            return 0.0f;
        }
        Activity activity = apiContext.getActivity();
        try {
            f2 = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
            return f2 / a(activity);
        } catch (Exception e) {
            RVLogger.e(b, "getScreenBrightness", e);
            return f2;
        }
    }

    private synchronized int a(Context context) {
        if (d.intValue() != -1) {
            return d.intValue();
        }
        int integer = context.getResources().getInteger(context.getResources().getIdentifier("config_screenBrightnessSettingMaximum", TypedValues.Custom.S_INT, "android"));
        if (integer <= 0) {
            Integer num = 255;
            d = num;
            return num.intValue();
        }
        d = Integer.valueOf(integer);
        RVLogger.d(b, "getMaximumScreenBrightnessSetting: " + d);
        return d.intValue();
    }
}
