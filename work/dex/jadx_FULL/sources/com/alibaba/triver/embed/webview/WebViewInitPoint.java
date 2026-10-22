package com.alibaba.triver.embed.webview;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.triver.triver_render.render.WVEmbedViewProvider;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WebViewInitPoint implements AppStartPoint, Serializable {
    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        WVEmbedViewProvider.registerEmebedView("web-view", b.class.getCanonicalName());
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
