package com.alibaba.ariver.jsapi.resource;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SnapshotBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24166a = "AriverAPI:SnapshotBridgeExtension";

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse deleteSnapshot(@BindingNode(App.class) App app, @BindingParam({"pagePath"}) String str) {
        if (!TextUtils.isEmpty(str)) {
            return RVSnapshotUtils.deleteSnapshot(app, str) ? BridgeResponse.SUCCESS : BridgeResponse.UNKNOWN_ERROR;
        }
        RVLogger.e(f24166a, "saveSnapshot pagePath is null");
        return BridgeResponse.INVALID_PARAM;
    }

    @ActionFilter
    @AutoCallback
    public JSONObject getSnapshotConfig(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (app == null || app.getStartParams() == null) {
            return BridgeResponse.NOT_FOUND.get();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("snapshotEnabled", (Object) Boolean.valueOf(app.getStartParams().getBoolean(RVStartParams.KEY_SNAPSHOT_ENABLED)));
        return jSONObject;
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
    @AutoCallback
    public BridgeResponse saveSnapshot(@BindingNode(App.class) App app, @BindingParam({RVStartParams.KEY_ENABLE_SNAPSHOT}) String str, @BindingParam({"pagePath"}) String str2) {
        if (TextUtils.isEmpty(str2)) {
            RVLogger.e(f24166a, "saveSnapshot pagePath is null");
            return BridgeResponse.INVALID_PARAM;
        }
        RVSnapshotUtils.saveSnapshot(app, str, str2);
        return BridgeResponse.SUCCESS;
    }
}
