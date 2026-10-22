package com.alibaba.ariver.permission.api;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.permission.api.proxy.JsapiInterceptorProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppPermissionManager implements PermissionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24353a = "AriverPermission:" + AppPermissionManager.class.getSimpleName();
    private static List<String> b;
    private AuthenticationProxy c;
    private JsapiInterceptorProxy d;
    private BizPermissionManager e;
    private String f;

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add("registerWorker");
        b.add("handleLoggingAction");
    }

    public AppPermissionManager(BizPermissionManager bizPermissionManager) {
        this.e = bizPermissionManager;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public boolean asyncCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        if (!(accessor instanceof Page)) {
            return false;
        }
        Page page = (Page) accessor;
        if (this.c.checkShowPermissionDialog(permission, nativeCallContext, bridgeResponseHelper, page)) {
            return true;
        }
        boolean zAsyncInterceptor = this.d.asyncInterceptor(permission, nativeCallContext, bridgeResponseHelper, page);
        RVLogger.d(f24353a, "JsapiInterceptorProxy need intercepted " + zAsyncInterceptor);
        return zAsyncInterceptor;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public boolean bizCheckPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        BizPermissionManager bizPermissionManager = this.e;
        if (bizPermissionManager != null && !bizPermissionManager.checkBizParamPermission(permission.authority(), this.f, nativeCallContext.getParams())) {
            RVLogger.d(f24353a, permission.authority() + " is not supported by param!");
            if (bridgeResponseHelper != null) {
                bridgeResponseHelper.sendError(2, permission.authority() + " is not supported by param!");
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public ApiPermissionCheckResult checkPermission(Permission permission, Accessor accessor, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        Page page;
        App app;
        if (accessor instanceof Page) {
            Page page2 = (Page) accessor;
            app = page2.getApp();
            page = page2;
        } else {
            page = null;
            app = accessor instanceof App ? (App) accessor : null;
        }
        if (page == null && app == null) {
            return ApiPermissionCheckResult.DENY;
        }
        ApiPermissionCheckResult apiPermissionCheckResultCheckJSApi = this.c.checkJSApi(permission, nativeCallContext, bridgeResponseHelper, app, page);
        if (ApiPermissionCheckResult.ALLOW == apiPermissionCheckResultCheckJSApi) {
            RVLogger.d(f24353a, "checkPermission allowed:\t " + nativeCallContext.getName());
            return this.c.checkSPJSApi(permission, nativeCallContext, bridgeResponseHelper, app, page);
        }
        if (ApiPermissionCheckResult.IGNORE == apiPermissionCheckResultCheckJSApi) {
            RVLogger.d(f24353a, "checkPermission ignored:\t " + nativeCallContext.getName());
        }
        return apiPermissionCheckResultCheckJSApi;
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public void init(Accessor accessor) {
        this.f = AppPermissionUtils.getPermissionAppId(accessor);
        this.c = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
        this.d = (JsapiInterceptorProxy) RVProxy.get(JsapiInterceptorProxy.class);
    }

    @Override // com.alibaba.ariver.permission.api.PermissionManager
    public Group manageAccessorGroup(Accessor accessor) {
        return RVGroup.LEVEL_APP_DEFAULT;
    }
}
