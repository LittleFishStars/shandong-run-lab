package com.alibaba.ariver.permission;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.security.BridgeAccessPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.DefaultGroup;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;
import com.alibaba.ariver.permission.api.proxy.JsapiInterceptorProxy;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultAccessControlManagement implements AccessControlManagement {
    public static String TAG = "AriverPermission:DefaultAccessControlManagement";
    private static List<String> WHITE_LIST;
    private BridgeAccessPoint bridgeAccessPoint;
    private NativeCallContext bridgeContext;
    private boolean checkInnerAppPermissionForH5 = "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_checkInnerAppPermissionForH5", "no"));
    private BridgeResponseHelper helper;

    static {
        ArrayList arrayList = new ArrayList();
        WHITE_LIST = arrayList;
        arrayList.add("registerWorker");
        WHITE_LIST.add("handleLoggingAction");
        WHITE_LIST.add("initialTraceDebug");
        WHITE_LIST.add("postMethodTrace");
    }

    public DefaultAccessControlManagement(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ExtensionManager extensionManager) {
        this.bridgeContext = nativeCallContext;
        this.helper = bridgeResponseHelper;
        this.bridgeAccessPoint = (BridgeAccessPoint) ExtensionPoint.as(BridgeAccessPoint.class).extensionManager(extensionManager).useCache(true).node(nativeCallContext.getNode()).create();
    }

    private boolean commonCheckIgnorePermission(boolean z) {
        App app;
        Page page = (Page) this.bridgeContext.getNode().bubbleFindNode(Page.class);
        if (page == null || (app = page.getApp()) == null) {
            return false;
        }
        IgnorePermissionPoint ignorePermissionPoint = (IgnorePermissionPoint) ExtensionPoint.as(IgnorePermissionPoint.class).node(app).useCache(true).create();
        if (ignorePermissionPoint != null && ignorePermissionPoint.ignoreAppPermission(app.getAppId())) {
            RVLogger.d(TAG, "commonCheckIgnorePermission ignore by IgnorePermissionPoint");
            return true;
        }
        TinyAppInnerProxy tinyAppInnerProxy = (TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class);
        if (!z && tinyAppInnerProxy != null) {
            if (tinyAppInnerProxy.isInner(app) && !tinyAppInnerProxy.isEmbedWebViewInnerAppBlack(page)) {
                if (!this.checkInnerAppPermissionForH5) {
                    RVLogger.d(TAG, "commonCheckIgnorePermission ignore by isInner");
                    return true;
                }
                if (app.isTinyApp()) {
                    RVLogger.d(TAG, "commonCheckIgnorePermission ignore by isInner");
                    return true;
                }
            }
            if (RVResourceUtils.needSkipPermissionCheck(app) && !tinyAppInnerProxy.isEmbedWebViewInnerAppBlack(page)) {
                RVLogger.d(TAG, "commonCheckIgnorePermission ignore by checkPermission");
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean asyncInterceptJsapi(Permission permission, Accessor accessor) {
        Page activePage;
        if (this.bridgeContext.getNode() instanceof App) {
            activePage = ((App) this.bridgeContext.getNode()).getActivePage();
        } else {
            activePage = this.bridgeContext.getNode() instanceof Page ? (Page) this.bridgeContext.getNode() : null;
        }
        boolean zAsyncInterceptor = activePage != null ? ((JsapiInterceptorProxy) RVProxy.get(JsapiInterceptorProxy.class)).asyncInterceptor(permission, this.bridgeContext, this.helper, activePage) : false;
        RVLogger.d(TAG, "asyncInterceptJsapi: " + zAsyncInterceptor);
        return zAsyncInterceptor;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean asyncPermissionCheck(Permission permission, Accessor accessor) {
        return this.bridgeAccessPoint.asyncCheckPermission(permission, accessor, this.bridgeContext, this.helper);
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean bizPermissionCheck(Permission permission, Accessor accessor) {
        return this.bridgeAccessPoint.bizCheckPermission(permission, accessor, this.bridgeContext, this.helper);
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public Group manageAccessorGroup(Accessor accessor) {
        return TextUtils.isEmpty(this.bridgeContext.getPluginId()) ? this.bridgeAccessPoint.manageAccessorGroup(accessor) : DefaultGroup.EXTERNAL;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public boolean needPermissionCheck(Accessor accessor, List<? extends Guard> list) {
        if (WHITE_LIST.contains(this.bridgeContext.getName())) {
            RVLogger.d(TAG, "needPermissionCheck ignore by WHITE_LIST");
            return false;
        }
        if (!TextUtils.isEmpty(this.bridgeContext.getPluginId())) {
            return !commonCheckIgnorePermission(true);
        }
        if (commonCheckIgnorePermission(false)) {
            return false;
        }
        return this.bridgeAccessPoint.needPermissionCheck(accessor, list);
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessControlManagement
    public ApiPermissionCheckResult permissionCheck(Permission permission, Accessor accessor) {
        return this.bridgeAccessPoint.checkPermission(permission, accessor, this.bridgeContext, this.helper);
    }
}
