package com.alibaba.ariver.jsapi.toast;

import android.app.Activity;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ToastBridgeExtension implements BridgeExtension {
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse hideToast(@BindingNode(Page.class) Page page) {
        ((ToastPoint) ExtensionPoint.as(ToastPoint.class).node(page).create()).hideToast();
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
    public void toast(@BindingParam({"content"}) String str, @BindingParam(intDefault = 2000, value = {"duration"}) int i, @BindingParam({"type"}) String str2, @BindingParam({"xOffset"}) int i2, @BindingParam({"yOffset"}) int i3, @BindingNode(Page.class) Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        Activity activity = page.getPageContext().getActivity();
        final ToastPoint toastPoint = (ToastPoint) ExtensionPoint.as(ToastPoint.class).node(page).create();
        toastPoint.showToast(activity, str, i, str2, i2, i3);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.jsapi.toast.ToastBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                toastPoint.hideToast();
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        }, i);
    }
}
