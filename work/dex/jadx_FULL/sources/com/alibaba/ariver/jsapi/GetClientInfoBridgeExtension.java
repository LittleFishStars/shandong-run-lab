package com.alibaba.ariver.jsapi;

import android.os.Build;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.fastjson.JSONObject;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetClientInfoBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24113a = "client.version";
    private static final String b = "os.name";
    private static final String c = "os.version";

    @ActionFilter
    @AutoCallback
    public JSONObject getClientInfo() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f24113a, (Object) RVKernelUtils.getClientVersion());
        jSONObject.put(b, (Object) "Android");
        jSONObject.put(c, (Object) Build.VERSION.RELEASE);
        jSONObject.put(ze1.k, (Object) Build.MODEL);
        jSONObject.put("device", (Object) Build.DEVICE);
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
}
