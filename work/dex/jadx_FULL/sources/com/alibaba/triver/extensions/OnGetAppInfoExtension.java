package com.alibaba.triver.extensions;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.resource.api.extension.AppModelInitPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OnGetAppInfoExtension implements NodeAware<App>, AppModelInitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<App> f24951a;

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.resource.api.extension.AppModelInitPoint
    public void onGetAppInfo(AppModel appModel) {
        App app;
        LaunchMonitorData subMonitorData;
        WeakReference<App> weakReference = this.f24951a;
        if (weakReference == null || (app = weakReference.get()) == null || (subMonitorData = LaunchMonitorUtils.getSubMonitorData(app)) == null) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_APP_INFO_FINISH);
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_REQUEST_START);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.f24951a = weakReference;
    }
}
