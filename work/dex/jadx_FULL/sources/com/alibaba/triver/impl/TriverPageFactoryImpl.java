package com.alibaba.triver.impl;

import android.os.Bundle;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.integration.proxy.impl.DefaultPageFactoryImpl;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.app.TriverAuthPageNode;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.point.RenderPreloadPoint;
import com.alibaba.triver.preload.b.c.d;
import com.alibaba.triver.trace.b;
import com.alibaba.triver.trace.c;
import com.alibaba.triver.utils.CommonUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverPageFactoryImpl extends DefaultPageFactoryImpl {
    @Override // com.alibaba.ariver.integration.proxy.impl.DefaultPageFactoryImpl, com.alibaba.ariver.app.proxy.RVPageFactory
    public PageNode createPage(App app, String str, Bundle bundle, Bundle bundle2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageUrl", (Object) str);
        PageNode triverAuthPageNode = TRiverUtils.isAuthPage(str) ? new TriverAuthPageNode(app, str, bundle, bundle2) : super.createPage(app, str, bundle, bundle2);
        if (app != null) {
            b.a(c.f, c.P, TRiverUtils.getSessionId(app), app.getAppId(), jSONObject);
            ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class);
            if (iSnapshotProxy != null && iSnapshotProxy.isSnapshotFileExist(app)) {
                b.a(c.f, c.Q, TRiverUtils.getSessionId(app), app.getAppId(), String.valueOf(triverAuthPageNode.getPageId()), jSONObject);
                return triverAuthPageNode;
            }
            if (CommonUtils.isRrenderPreloadVHost(CommonUtils.getVhost(app))) {
                d dVar = TRiverUrlUtils.isShop(app) ? (d) PreloadScheduler.getInstance().getAndRemoveReadyResult(app.getStartToken(), d.class) : (d) PreloadScheduler.getInstance().getAndRemoveReadyResult(app.getStartToken(), com.alibaba.triver.preload.b.c.c.class);
                if (dVar != null) {
                    if (TROrangeController.enableACLeakFix()) {
                        ExtensionPoint.invalidateExtensionCache(triverAuthPageNode, PageInitPoint.class);
                    }
                    triverAuthPageNode.setNodeId(dVar.b());
                    if (dVar instanceof com.alibaba.triver.preload.b.c.c) {
                        triverAuthPageNode.setData(com.alibaba.triver.preload.b.c.c.class, (com.alibaba.triver.preload.b.c.c) dVar);
                    } else {
                        triverAuthPageNode.setData(d.class, dVar);
                    }
                    ((RenderPreloadPoint) ExtensionPoint.as(RenderPreloadPoint.class).node(app).create()).onPreloadRender(app);
                }
            }
        }
        if (app != null && triverAuthPageNode != null) {
            b.a(c.f, c.Q, TRiverUtils.getSessionId(app), app.getAppId(), String.valueOf(triverAuthPageNode.getPageId()), jSONObject);
        }
        return triverAuthPageNode;
    }
}
