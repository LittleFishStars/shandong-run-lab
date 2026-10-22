package com.alibaba.ariver.integration.ipc.server;

import android.os.SystemClock;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvokerFactory;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteCallResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import com.alibaba.ariver.kernel.ipc.ShadowNodePool;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ServerSideRemoteExtensionCaller extends IRemoteCaller.Stub {
    private static final String TAG = "AriverKernel:ServerSideRemoteApiCaller";
    private final ExtensionManager mExtensionManager;
    private long mRemoteCallCounter = SystemClock.elapsedRealtime();

    public ServerSideRemoteExtensionCaller(ExtensionManager extensionManager) {
        this.mExtensionManager = extensionManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.ariver.kernel.api.remote.IRemoteCaller
    public RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) {
        RemoteCallResult remoteCallResult;
        StringBuilder sb;
        long j = this.mRemoteCallCounter;
        this.mRemoteCallCounter = 1 + j;
        try {
            RVLogger.d(TAG, "begin remoteCall id: " + j + " args: " + remoteCallArgs);
            Node nodeCreateOrGetNode = ShadowNodePool.getInstance().createOrGetNode(remoteCallArgs.getNode(), remoteCallArgs.getNodeId());
            Class<?> cls = Class.forName(remoteCallArgs.getClassName());
            ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) RVProxy.get(ExtensionInvokerFactory.class);
            ExtensionInvoker extensionInvokerCreateScheduleExtensionInvoker = extensionInvokerFactory.createScheduleExtensionInvoker(extensionInvokerFactory.createAwareExtensionInvoker(nodeCreateOrGetNode, null, cls));
            Method methodFindMethod = ReflectUtils.findMethod(cls, remoteCallArgs.getMethodName(), remoteCallArgs.getArgTypes());
            Extension extensionByName = this.mExtensionManager.getExtensionByName(nodeCreateOrGetNode, remoteCallArgs.getClassName());
            RVLogger.d(TAG, "remoteCall found targetExtension: " + extensionByName);
            extensionInvokerCreateScheduleExtensionInvoker.attacheTargetExtensions(extensionByName);
            if (methodFindMethod != null) {
                remoteCallResult = new RemoteCallResult(extensionInvokerCreateScheduleExtensionInvoker.invoke(null, methodFindMethod, remoteCallArgs.getArgs()));
                sb = new StringBuilder();
                sb.append("end remoteCall id: ");
                sb.append(j);
                String string = sb.toString();
                return remoteCallResult;
            }
            RVLogger.e(TAG, "action method not found");
            RemoteCallResult remoteCallResult2 = new RemoteCallResult((Object) null);
            RVLogger.d(TAG, "end remoteCall id: " + j);
            return remoteCallResult2;
        } catch (Throwable th) {
            try {
                RVLogger.e(TAG, "remoteCall exception!", th);
                remoteCallResult = new RemoteCallResult(th);
                sb = new StringBuilder();
            } finally {
                RVLogger.d(TAG, "end remoteCall id: " + j);
            }
        }
    }
}
