package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.kernel.common.bytebuffer.RVByteBufferManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CommonAppExitExtension implements AppExitPoint {
    @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
    public void onAppExit(App app) {
        RVByteBufferManager.releaseAllBuffer();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
