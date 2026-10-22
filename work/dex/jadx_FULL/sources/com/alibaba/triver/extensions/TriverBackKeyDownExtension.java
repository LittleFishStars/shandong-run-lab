package com.alibaba.triver.extensions;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.triver.app.b;
import com.alibaba.triver.kit.api.utils.TRiverUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverBackKeyDownExtension implements BackKeyDownPoint {
    @Override // com.alibaba.ariver.app.api.point.app.BackKeyDownPoint
    public Boolean intercept(final App app) {
        if (app == null) {
            return Boolean.FALSE;
        }
        if (!app.isFirstPage() || (app.getActivePage() != null && TRiverUtils.isAuthPage(app.getActivePage().getPageURI()))) {
            return Boolean.FALSE;
        }
        new b(app) { // from class: com.alibaba.triver.extensions.TriverBackKeyDownExtension.1
            @Override // com.alibaba.triver.app.b
            public void b(GoBackCallback goBackCallback) {
                if (goBackCallback != null) {
                    goBackCallback.afterProcess(true);
                }
                app.exit();
            }
        }.a((GoBackCallback) null);
        return Boolean.TRUE;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
