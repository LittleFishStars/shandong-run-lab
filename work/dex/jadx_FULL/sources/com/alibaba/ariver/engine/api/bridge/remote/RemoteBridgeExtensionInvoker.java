package com.alibaba.ariver.engine.api.bridge.remote;

import android.os.Bundle;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteBridgeExtensionInvoker extends ExtensionInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24053a = "AriverKernel:ExtensionInvoker:Remote";
    private RemoteController b;
    private SendToNativeCallback c;
    private NativeCallContext d;

    public RemoteBridgeExtensionInvoker(SendToNativeCallback sendToNativeCallback, NativeCallContext nativeCallContext, RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.c = sendToNativeCallback;
        this.b = remoteController;
        this.d = nativeCallContext;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        Node node = this.d.getNode();
        if (node == null) {
            RVLogger.w(f24053a, "RemoteBridgeExtensionInvoker can only call with a node!!!");
            return ExtensionInvoker.InvokeResult.proceed();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.b != null) {
            Extension extension = immutableList.get(0);
            if (this.b.isRemoteCallExtension(extension, method)) {
                RVLogger.d(f24053a, "extension: " + extension.getClass() + " method: " + method + " isRemote!");
                RemoteCallbackPool.getInstance().registerCallback(this.d, this.c);
                RemoteCallArgs remoteCallArgs = new RemoteCallArgs(node, extension, method, objArr, this.d);
                Bundle bundle = new Bundle();
                bundle.putParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_ARGS, remoteCallArgs);
                IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, 6, bundle);
                RVLogger.debug(f24053a, "extension " + extension + " method: " + method + " call remote cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                return ExtensionInvoker.InvokeResult.decide(null);
            }
        }
        return ExtensionInvoker.InvokeResult.proceed();
    }
}
