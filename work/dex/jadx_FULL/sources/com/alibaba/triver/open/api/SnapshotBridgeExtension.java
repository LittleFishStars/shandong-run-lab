package com.alibaba.triver.open.api;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SnapshotBridgeExtension extends com.alibaba.ariver.jsapi.resource.SnapshotBridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25033a = "AriverAPI:SnapshotBridgeExtension";

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public BridgeResponse saveSnapshot(@BindingNode(Page.class) Page page, @BindingNode(App.class) App app, @BindingParam({RVStartParams.KEY_ENABLE_SNAPSHOT}) String str, @BindingParam({"pagePath"}) String str2) {
        if (page != null && (page.getPageContext() instanceof com.alibaba.triver.open.container.a)) {
            ((com.alibaba.triver.open.container.a) page.getPageContext()).b();
        }
        return super.saveSnapshot(app, str, str2);
    }
}
