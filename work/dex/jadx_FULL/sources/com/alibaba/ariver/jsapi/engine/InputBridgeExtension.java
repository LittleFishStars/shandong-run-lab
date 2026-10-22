package com.alibaba.ariver.jsapi.engine;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InputBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24144a = "AriverAPI:InputBridgeExtension";

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse inputFocus4Android(@BindingApiContext ApiContext apiContext, @BindingParam({"coordinateX"}) String str, @BindingParam({"coordinateY"}) String str2) {
        View internalView = apiContext.getInternalView();
        if (internalView == null) {
            RVLogger.d(f24144a, "inputFocus4Android realWebView == null");
            return BridgeResponse.SUCCESS;
        }
        RVLogger.d(f24144a, "x " + str + ", y " + str2);
        try {
            float fFloatValue = Float.valueOf(str).floatValue();
            float fFloatValue2 = Float.valueOf(str2).floatValue();
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fFloatValue, fFloatValue2, 0);
            long j = jUptimeMillis + 300;
            MotionEvent motionEventObtain2 = MotionEvent.obtain(j, j, 1, fFloatValue, fFloatValue2, 0);
            internalView.dispatchTouchEvent(motionEventObtain);
            internalView.dispatchTouchEvent(motionEventObtain2);
            motionEventObtain.recycle();
            motionEventObtain2.recycle();
            return BridgeResponse.SUCCESS;
        } catch (Throwable th) {
            RVLogger.e(f24144a, "inputFocus4Android exception ", th);
            return BridgeResponse.INVALID_PARAM;
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

    @ThreadType(ExecutorType.SYNC)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showSoftInput(@BindingParam({"show"}) boolean z, @BindingParam({"show"}) String str, @BindingApiContext ApiContext apiContext) {
        Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View internalView = apiContext.getInternalView();
        if (internalView == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24144a, "you should specify whether to or not to show soft input");
            return new BridgeResponse.Error(2, "error not set \"show\" key  ");
        }
        if (z) {
            inputMethodManager.showSoftInput(internalView, 2);
            RVLogger.d(f24144a, "showSoftInput  show ");
        } else {
            inputMethodManager.hideSoftInputFromWindow(internalView.getWindowToken(), 0);
            RVLogger.d(f24144a, "showSoftInput  hide ");
        }
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse toggleSoftInput(@BindingApiContext ApiContext apiContext) {
        Activity activity = apiContext.getActivity();
        if (activity == null || activity.isFinishing()) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(0, 2);
        RVLogger.d(f24144a, "toggleSoftInput success ");
        return BridgeResponse.SUCCESS;
    }
}
