package com.alibaba.triver.support.ui;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageCreateRenderPoint;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageCreateExtension implements PageCreateRenderPoint {
    @Override // com.alibaba.ariver.app.api.point.page.PageCreateRenderPoint
    public Render createRender(Activity activity, Page page, CreateParams createParams) {
        if (page == null || page.getOriginalURI() == null || !TRiverUtils.isAuthPage(page.getOriginalURI())) {
            return null;
        }
        RVEngine engineProxy = page.getApp() != null ? page.getApp().getEngineProxy() : null;
        return "true".equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_SUBSCRIBE_SWITCH, "true")) ? new com.alibaba.triver.support.ui.auth.settings.b(engineProxy, activity, page, createParams) : new com.alibaba.triver.support.ui.auth.settings.a(engineProxy, activity, page, createParams);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
