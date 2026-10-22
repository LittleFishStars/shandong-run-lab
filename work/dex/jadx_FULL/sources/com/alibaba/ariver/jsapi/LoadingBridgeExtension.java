package com.alibaba.ariver.jsapi;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoadingBridgeExtension implements BridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideLoading(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page) {
        boolean zUseSuperSplash = SplashUtils.useSuperSplash(app.getStartParams());
        SplashView splashView = app.getAppContext() == null ? null : app.getAppContext().getSplashView();
        if (zUseSuperSplash && splashView != null && splashView.getStatus() == SplashView.Status.LOADING) {
            splashView.exit(null);
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext != null && pageContext.getLoadingView() != null) {
            pageContext.getLoadingView().dismiss();
            ((EventTrackStore) page.getData(EventTrackStore.class, true)).isShowLoading = false;
        }
        return BridgeResponse.SUCCESS;
    }

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

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse showLoading(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"text"}) String str, @BindingParam({"delay"}) int i, @BindingParam(booleanDefault = true, value = {"cancelable"}) boolean z) {
        PageContext pageContext = page.getPageContext();
        if (pageContext != null && pageContext.getLoadingView() != null) {
            pageContext.getLoadingView().dismiss();
            pageContext.getLoadingView().show(str, i, z);
            ((EventTrackStore) page.getData(EventTrackStore.class, true)).isShowLoading = true;
        }
        return BridgeResponse.SUCCESS;
    }
}
