package com.alibaba.ariver.jsapi.engine;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OrientationBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24145a = "AriverAPI:OrientationBridgeExtension";
    private static final String b = "orientation";

    private String a(Activity activity) {
        int i = activity.getResources().getConfiguration().orientation;
        if (i == 1) {
            return RVParams.LONG_PORTRAIT;
        }
        if (i != 2) {
            return null;
        }
        return "landscape";
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getScreenOrientation(@BindingNode(Page.class) Page page) {
        if (page == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        Activity activity = page.getRender().getActivity();
        if (activity == null || activity.isFinishing()) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        String strA = a(activity);
        if (TextUtils.isEmpty(strA)) {
            return BridgeResponse.newError(3, "get screen orientation return null");
        }
        RVLogger.d(f24145a, "getScreenOrientation success ");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put(b, (Object) strA);
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
    public BridgeResponse setScreenOrientation(@BindingParam({b}) String str, @BindingParam({"beta"}) boolean z, @BindingNode(Page.class) Page page) {
        if (!z || TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        Activity activity = page.getRender().getActivity();
        if (activity == null || activity.isFinishing()) {
            return BridgeResponse.newError(2, "activity is null");
        }
        boolean screenOrientation = ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).setScreenOrientation(activity, str, page);
        RVLogger.d(f24145a, "setScreenOrientation result " + screenOrientation);
        return screenOrientation ? BridgeResponse.SUCCESS : BridgeResponse.INVALID_PARAM;
    }
}
