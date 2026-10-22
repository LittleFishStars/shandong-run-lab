package com.alibaba.triver.triver_render.view.input;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.triver.triver_render.render.WVEmbedViewProvider;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InputInitPoint implements AppStartPoint, Serializable {
    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        WVEmbedViewProvider.registerEmebedView(a.f25238a, a.class.getCanonicalName());
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
