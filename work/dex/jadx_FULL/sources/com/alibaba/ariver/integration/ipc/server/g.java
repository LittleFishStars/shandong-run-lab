package com.alibaba.ariver.integration.ipc.server;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.common.extension.BindBridgeExtensionInvoker;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.ShadowNodePool;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24088a = "AriverKernel:ServerSideRemoteApiCaller";
    private final ExtensionManager b;

    public g(ExtensionManager extensionManager) {
        this.b = extensionManager;
    }

    public void a(RemoteCallArgs remoteCallArgs) {
        long j;
        Render render;
        String str;
        Bundle bundle;
        Object obj;
        ExtensionInvoker extensionInvoker;
        Method method;
        try {
            RVLogger.d(f24088a, "begin remoteCall for " + remoteCallArgs);
            long nodeId = remoteCallArgs.getNodeId();
            String action = remoteCallArgs.getAction();
            Node nodeCreateOrGetNode = ShadowNodePool.getInstance().createOrGetNode(remoteCallArgs.getNode(), nodeId);
            if (nodeCreateOrGetNode instanceof Page) {
                App app = ((Page) nodeCreateOrGetNode).getApp();
                String appId = app.getAppId();
                long startToken = app.getStartToken();
                Bundle startParams = ((Page) nodeCreateOrGetNode).getStartParams();
                f.a(app);
                f.a((Page) nodeCreateOrGetNode);
                render = ((Page) nodeCreateOrGetNode).getRender();
                str = appId;
                j = startToken;
                bundle = startParams;
            } else if (nodeCreateOrGetNode instanceof App) {
                String appId2 = ((App) nodeCreateOrGetNode).getAppId();
                long startToken2 = ((App) nodeCreateOrGetNode).getStartToken();
                Bundle startParams2 = ((App) nodeCreateOrGetNode).getStartParams();
                f.a((App) nodeCreateOrGetNode);
                str = appId2;
                j = startToken2;
                bundle = startParams2;
                render = null;
            } else {
                j = -1;
                render = null;
                str = null;
                bundle = null;
            }
            if (TextUtils.isEmpty(action)) {
                obj = null;
                extensionInvoker = null;
                method = null;
            } else {
                Parcelable data = remoteCallArgs.getData();
                if (!(data instanceof NativeCallContext)) {
                    throw new IllegalStateException("Remote call of BridgeExtension not transact NativeCallContext!");
                }
                NativeCallContext nativeCallContext = (NativeCallContext) data;
                SendToNativeCallback sendToNativeCallbackA = a(str, nativeCallContext.getId(), j, nodeId);
                d dVar = new d(render, j, str, bundle, remoteCallArgs.getSourceProcessName(), nativeCallContext.getPluginId(), nativeCallContext.getContextId());
                InstanceType instanceTypeFromParam = MultiInstanceUtils.getInstanceTypeFromParam(nativeCallContext.getParams());
                ActionMeta actionMetaFindActionMeta = instanceTypeFromParam != null ? this.b.findActionMeta(instanceTypeFromParam, nodeCreateOrGetNode, action) : this.b.findActionMeta(nodeCreateOrGetNode, action);
                ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
                BridgeResponseHelper bridgeResponseHelper = new BridgeResponseHelper(sendToNativeCallbackA);
                obj = null;
                ExtensionInvoker extensionInvokerCreateScheduleExtensionInvoker = extensionInvokerFactory.createScheduleExtensionInvoker(new BindBridgeExtensionInvoker(nodeCreateOrGetNode, nativeCallContext, bridgeResponseHelper, actionMetaFindActionMeta, dVar, null));
                Method method2 = actionMetaFindActionMeta.actionMethod;
                extensionInvokerCreateScheduleExtensionInvoker.attacheTargetExtensions(this.b.getBridgeExtensionByActionMeta(nodeCreateOrGetNode, actionMetaFindActionMeta));
                extensionInvoker = extensionInvokerCreateScheduleExtensionInvoker;
                method = method2;
            }
            if (method == null) {
                RVLogger.e(f24088a, "action method not found");
            } else {
                extensionInvoker.invoke(obj, method, remoteCallArgs.getArgs());
            }
        } catch (Throwable th) {
            RVLogger.e(f24088a, "remoteCall exception!", th);
        }
    }

    private SendToNativeCallback a(String str, String str2, long j, long j2) {
        return (SendToNativeCallback) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{SendToNativeCallback.class}, new b(str, str2, j, j2));
    }
}
