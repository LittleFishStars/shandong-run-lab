package com.alibaba.ariver.engine.common.bridge.dispatch;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.remote.RemoteBridgeExtensionInvoker;
import com.alibaba.ariver.engine.api.proxy.RVJsStatTrackService;
import com.alibaba.ariver.engine.common.extension.BindBridgeExtensionInvoker;
import com.alibaba.ariver.engine.common.extension.NativePermissionExtensionInvoker;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.permission.DefaultAccessControlManagement;
import com.alibaba.ariver.remotedebug.b;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeDispatcher {
    public static final String TAG = "AriverEngine:" + BridgeDispatcher.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile BridgeDispatcher f24062a;
    private ExtensionManager b;
    private RVConfigService c = (RVConfigService) RVProxy.get(RVConfigService.class);
    private JSONObject d;
    private RVJsStatTrackService e;
    private RVConfigService.OnConfigChangeListener f;

    private BridgeDispatcher() {
        this.f = null;
        RVConfigService.OnConfigChangeListener onConfigChangeListener = new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.engine.common.bridge.dispatch.BridgeDispatcher.1
            @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
            public void onChange(String str) {
                try {
                    BridgeDispatcher.this.d = JSON.parseObject(str);
                } catch (Exception unused) {
                    BridgeDispatcher.this.d = null;
                }
            }
        };
        this.f = onConfigChangeListener;
        try {
            this.d = JSON.parseObject(this.c.getConfig("ta_extension_dispatch_whitelist", null, onConfigChangeListener));
        } catch (Exception unused) {
            this.d = null;
        }
        this.e = (RVJsStatTrackService) RVProxy.get(RVJsStatTrackService.class);
    }

    private ExtensionInvoker a(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z, ExtensionManager extensionManager, ActionMeta actionMeta, @Nullable ApiContext apiContext) {
        ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
        BindBridgeExtensionInvoker bindBridgeExtensionInvoker = new BindBridgeExtensionInvoker(nativeCallContext.getNode(), nativeCallContext, bridgeResponseHelper, actionMeta, apiContext, null);
        NativePermissionExtensionInvoker nativePermissionExtensionInvoker = new NativePermissionExtensionInvoker(nativeCallContext.getNode(), bridgeResponseHelper, !ProcessUtils.isMainProcess() ? extensionInvokerFactory.createScheduleExtensionInvoker(new RemoteBridgeExtensionInvoker(bridgeResponseHelper == null ? null : bridgeResponseHelper.getInnerBridgeResponse(), nativeCallContext, extensionManager.getRemoteController(), bindBridgeExtensionInvoker)) : extensionInvokerFactory.createScheduleExtensionInvoker(bindBridgeExtensionInvoker), actionMeta);
        if (!z) {
            return nativePermissionExtensionInvoker;
        }
        DefaultAccessControlManagement defaultAccessControlManagement = new DefaultAccessControlManagement(nativeCallContext, bridgeResponseHelper, extensionManager);
        DefaultAccessController defaultAccessController = new DefaultAccessController();
        defaultAccessController.setAccessControlManagement(defaultAccessControlManagement);
        return extensionInvokerFactory.createPermissionExtensionInvoker(actionMeta, defaultAccessController, nativePermissionExtensionInvoker);
    }

    public static BridgeDispatcher getInstance() {
        if (f24062a == null) {
            synchronized (BridgeDispatcher.class) {
                if (f24062a == null) {
                    f24062a = new BridgeDispatcher();
                }
            }
        }
        return f24062a;
    }

    public void bindExtensionManager(ExtensionManager extensionManager) {
        this.b = extensionManager;
    }

    public boolean dispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z) {
        return dispatch(nativeCallContext, bridgeResponseHelper, z, this.b);
    }

    public ExtensionManager getExtensionManager() {
        return this.b;
    }

    public boolean dispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z, ExtensionManager extensionManager) {
        return dispatch(nativeCallContext, bridgeResponseHelper, z, extensionManager, null);
    }

    public boolean dispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, boolean z, ExtensionManager extensionManager, @Nullable ApiContext apiContext) {
        ActionMeta actionMetaFindActionMeta;
        StringBuilder sb;
        if (!b.e.equals(nativeCallContext.getName()) && !"tinyAppConfig".equals(nativeCallContext.getName()) && !"internalAPI".equals(nativeCallContext.getName()) && !"remoteLog".equals(nativeCallContext.getName()) && !"handleLoggingAction".equals(nativeCallContext.getName()) && !com.alibaba.triver.embed.webview.b.f24908a.equals(nativeCallContext.getName()) && (nativeCallContext.getNode() instanceof Page)) {
            Page page = (Page) nativeCallContext.getNode();
            int intValue = page.getIntValue(RVConstants.JSAPI_COUNT);
            if (intValue == 0) {
                page.putIntValue(RVConstants.JSAPI_COUNT, 1);
            } else {
                page.putIntValue(RVConstants.JSAPI_COUNT, intValue + 1);
            }
        }
        int length = 0;
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            RVLogger.w(TAG, "BridgeDispatcher dispatch context.getName() == null!");
            return false;
        }
        InstanceType instanceTypeFromParam = MultiInstanceUtils.getInstanceTypeFromParam(nativeCallContext.getParams());
        if (instanceTypeFromParam != null) {
            actionMetaFindActionMeta = extensionManager.findActionMeta(instanceTypeFromParam, nativeCallContext.getNode(), nativeCallContext.getName());
        } else {
            actionMetaFindActionMeta = extensionManager.findActionMeta(nativeCallContext.getNode(), nativeCallContext.getName());
        }
        ActionMeta actionMeta = actionMetaFindActionMeta;
        if (actionMeta == null) {
            RVLogger.w(TAG, "BridgeDispatcher dispatch findActionMeta == null!\t" + nativeCallContext.getName());
            return false;
        }
        JSONObject jSONObject = this.d;
        if (jSONObject != null && jSONObject.containsKey(nativeCallContext.getName())) {
            JSONArray jSONArray = this.d.getJSONArray(nativeCallContext.getName());
            if (!CollectionUtils.isEmpty(jSONArray) && nativeCallContext.getNode() != null && !jSONArray.contains(((App) nativeCallContext.getNode().bubbleFindNode(App.class)).getAppId()) && !jSONArray.contains("all")) {
                RVLogger.d(TAG, "BridgeDispatch dispatch fallback extension " + nativeCallContext.getName());
                return false;
            }
        }
        try {
            BridgeExtension bridgeExtensionByActionMeta = extensionManager.getBridgeExtensionByActionMeta(nativeCallContext.getNode(), actionMeta);
            if (bridgeExtensionByActionMeta == null) {
                RVLogger.w(TAG, "BridgeDispatcher dispatch getBridgeExtensionByAction == null!");
                return false;
            }
            ExtensionInvoker extensionInvokerA = a(nativeCallContext, bridgeResponseHelper, z, extensionManager, actionMeta, apiContext);
            extensionInvokerA.attacheTargetExtensions(bridgeExtensionByActionMeta);
            try {
                try {
                    RVTraceUtils.traceBeginSection(RVTraceKey.RV_JSAPI_Dispatch_ + nativeCallContext.getName());
                    Method method = actionMeta.actionMethod;
                    Class[] clsArr = actionMeta.paramTypes;
                    if (clsArr != null) {
                        length = clsArr.length;
                    }
                    Object[] objArr = new Object[length];
                    RVJsStatTrackService rVJsStatTrackService = this.e;
                    if (rVJsStatTrackService != null) {
                        try {
                            rVJsStatTrackService.onInvoke(nativeCallContext);
                        } catch (AccessControlException e) {
                            e = e;
                            String message = e.getMessage();
                            if (bridgeResponseHelper != null) {
                                if (message.startsWith("N22")) {
                                    bridgeResponseHelper.sendNoRigHtToInvoke(message);
                                } else {
                                    bridgeResponseHelper.sendNoRigHtToInvoke();
                                }
                            }
                            RVLogger.e(TAG, "bridge extension fail AccessControlException:", e);
                            sb = new StringBuilder();
                        } catch (Throwable th) {
                            th = th;
                            if (bridgeResponseHelper != null) {
                                bridgeResponseHelper.sendError(3, th.getMessage());
                            }
                            String str = TAG;
                            RVLogger.e(str, "bridge extension fail Throwable:", th);
                            String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_throwjsapiexception", "");
                            String productId = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getProductId();
                            if ("yes".equalsIgnoreCase(configWithProcessCache) && !"Android-container".equalsIgnoreCase(productId)) {
                                RVLogger.d(str, "unpublished version throw exception " + th.getMessage());
                                throw new RuntimeException(th);
                            }
                            sb = new StringBuilder();
                        }
                    }
                    extensionInvokerA.invoke(bridgeExtensionByActionMeta, method, objArr);
                    sb = new StringBuilder();
                } catch (Throwable th2) {
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_JSAPI_Dispatch_ + nativeCallContext.getName());
                    throw th2;
                }
            } catch (AccessControlException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
            sb.append(RVTraceKey.RV_JSAPI_Dispatch_);
            sb.append(nativeCallContext.getName());
            RVTraceUtils.traceEndSection(sb.toString());
            return true;
        } catch (Throwable th4) {
            RVLogger.e(TAG, "dispatch BridgeExtension error", th4);
            return false;
        }
    }
}
