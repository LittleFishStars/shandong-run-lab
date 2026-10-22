package com.alibaba.alibctriver.extensions;

import com.alibaba.alibctriver.b.a;
import com.alibaba.triver.triver_worker.v8worker.GetShopPluginResourcePoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DynamicPluginResourcePoint implements GetShopPluginResourcePoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23680a = "DynamicPluginResourcePoint";

    @Override // com.alibaba.triver.triver_worker.v8worker.GetShopPluginResourcePoint
    public String getPluginIndexJs(String str) {
        return null;
    }

    @Override // com.alibaba.triver.triver_worker.v8worker.GetShopPluginResourcePoint
    public String getPluginWorkerIndexJs(String str) {
        return a.b(str, "index.worker.js");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
