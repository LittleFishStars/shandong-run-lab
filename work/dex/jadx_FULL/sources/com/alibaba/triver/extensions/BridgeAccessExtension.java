package com.alibaba.triver.extensions;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.AppPermissionManager;
import com.alibaba.ariver.permission.api.PermissionManager;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.model.RVGroupInit;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.permission.a;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeAccessExtension implements BridgeAccessPoint, NodeAware<Page> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24947a = ":Permission";
    private PermissionManager b;
    private Page c = null;

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public boolean asyncCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean zAsyncCheckPermission = this.b.asyncCheckPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        RVLogger.d(f24947a, nativeCallContext.getId() + "|" + permission.authority() + "|accessor" + accessor.hashCode() + "#async check permission result=" + zAsyncCheckPermission);
        return zAsyncCheckPermission;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public boolean bizCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        boolean zBizCheckPermission = this.b.bizCheckPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        String str = nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + permission.authority() + TRiverConstants.TOOL_SPLIT + "accessor" + accessor.hashCode() + "#biz check permission result=" + zBizCheckPermission;
        RVLogger.d(f24947a, str);
        if (zBizCheckPermission) {
            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
            Page page = this.c;
            String appId = (page == null || page.getApp() == null) ? "" : this.c.getApp().getAppId();
            Page page2 = this.c;
            rVMonitor.flowLog("CHECK_PERMISSION_SUCCESS", str, "Api", appId, page2 != null ? page2.getPageURI() : "", null);
        } else {
            RVMonitor rVMonitor2 = (RVMonitor) RVProxy.get(RVMonitor.class);
            Page page3 = this.c;
            String appId2 = (page3 == null || page3.getApp() == null) ? "" : this.c.getApp().getAppId();
            Page page4 = this.c;
            rVMonitor2.flowLog("CHECK_PERMISSION_FAILED", str, "Api", appId2, page4 != null ? page4.getPageURI() : "", null);
        }
        return zBizCheckPermission;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public ApiPermissionCheckResult checkPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        ApiPermissionCheckResult apiPermissionCheckResultCheckPermission = this.b.checkPermission(permission, accessor, nativeCallContext, bridgeResponseHelper);
        String str = nativeCallContext.getId() + TRiverConstants.TOOL_SPLIT + permission.authority() + TRiverConstants.TOOL_SPLIT + "accessor" + accessor.hashCode() + TRiverConstants.TOOL_SPLIT + "check permission result=" + apiPermissionCheckResultCheckPermission;
        RVLogger.d(f24947a, str);
        if (ApiPermissionCheckResult.ALLOW == apiPermissionCheckResultCheckPermission || ApiPermissionCheckResult.IGNORE == apiPermissionCheckResultCheckPermission) {
            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
            Page page = this.c;
            String appId = (page == null || page.getApp() == null) ? "" : this.c.getApp().getAppId();
            Page page2 = this.c;
            rVMonitor.flowLog("CHECK_PERMISSION_SUCCESS", str, "Api", appId, page2 != null ? page2.getPageURI() : "", null);
        } else {
            RVMonitor rVMonitor2 = (RVMonitor) RVProxy.get(RVMonitor.class);
            Page page3 = this.c;
            String appId2 = (page3 == null || page3.getApp() == null) ? "" : this.c.getApp().getAppId();
            Page page4 = this.c;
            rVMonitor2.flowLog("CHECK_PERMISSION_FAILED", str, "Api", appId2, page4 != null ? page4.getPageURI() : "", null);
        }
        return apiPermissionCheckResultCheckPermission;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public Group manageAccessorGroup(Accessor accessor) {
        RVGroupInit.init(null);
        Group groupManageAccessorGroup = this.b.manageAccessorGroup(accessor);
        RVLogger.d(f24947a, "accessor" + accessor.hashCode() + " group=" + groupManageAccessorGroup.groupName());
        return groupManageAccessorGroup;
    }

    @Override // com.alibaba.ariver.engine.api.security.BridgeAccessPoint
    public boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list) {
        if (this.b == null) {
            AppPermissionManager appPermissionManager = new AppPermissionManager(null);
            this.b = appPermissionManager;
            appPermissionManager.init(accessor);
        }
        if (list != null && list.size() > 0) {
            for (Guard guard : list) {
                if (guard.permit() != null && a.a(guard.permit().authority())) {
                    return false;
                }
            }
        }
        Page page = this.c;
        if (page == null || page.getApp() == null || ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).hasPermissionModel(this.c.getApp().getAppId(), this.c)) {
            return true;
        }
        RVLogger.d(f24947a, "accessor" + accessor.hashCode() + " dont have permission model");
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.c = weakReference.get();
    }
}
