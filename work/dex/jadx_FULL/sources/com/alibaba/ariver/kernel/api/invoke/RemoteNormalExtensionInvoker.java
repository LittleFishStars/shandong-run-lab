package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteCallResult;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteNormalExtensionInvoker extends ExtensionInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24211a = "AriverKernel:ExtensionInvoker:Remote";
    private boolean b;
    private RemoteController c;

    public RemoteNormalExtensionInvoker(RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.b = ProcessUtils.isMainProcess();
        this.c = remoteController;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws Throwable {
        Extension extension;
        boolean zIsRemoteCallExtension;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.b || this.c == null || !(zIsRemoteCallExtension = this.c.isRemoteCallExtension((extension = immutableList.get(0)), method))) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        RVLogger.d(f24211a, "extension: " + extension.getClass() + " method: " + method + " isRemote: " + zIsRemoteCallExtension);
        RemoteCallResult remoteCallResultRemoteCall = this.c.remoteCall(new RemoteCallArgs(this.targetNode, extension, method, objArr, null));
        Object value = remoteCallResultRemoteCall.getValue();
        if (remoteCallResultRemoteCall.isError() && (value instanceof Throwable)) {
            throw ((Throwable) value);
        }
        RVLogger.debug(f24211a, "extension " + extension + " method: " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return ExtensionInvoker.InvokeResult.decide(remoteCallResultRemoteCall.getValue());
    }
}
