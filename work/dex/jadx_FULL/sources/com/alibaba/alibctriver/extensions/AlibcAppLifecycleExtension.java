package com.alibaba.alibctriver.extensions;

import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcAppLifecycleExtension implements AppDestroyPoint {
    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        TRiverConstant.BC_LINK_CODE = Integer.parseInt("00000000", 2);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
