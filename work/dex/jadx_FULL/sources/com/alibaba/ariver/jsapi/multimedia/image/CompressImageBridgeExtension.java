package com.alibaba.ariver.jsapi.multimedia.image;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class CompressImageBridgeExtension implements BridgeExtension {
    @ActionFilter
    public abstract void compressImage(@BindingParam({"apFilePaths"}) String[] strArr, @BindingParam({"maxWidth"}) int i, @BindingParam({"maxHeight"}) int i2, @BindingParam({"compress"}) int i3, @BindingParam({"compressLevel"}) int i4, @BindingParam({"business"}) String str, @BindingParam({"data"}) String str2, @BindingParam({"dataType"}) String str3, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback);

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
