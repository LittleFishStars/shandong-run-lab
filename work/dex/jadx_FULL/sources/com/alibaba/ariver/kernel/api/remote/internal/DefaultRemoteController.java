package com.alibaba.ariver.kernel.api.remote.internal;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteCallResult;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultRemoteController implements RemoteController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RemoteControlManagement f24219a;

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public void bindExtensionManager(ExtensionManager extensionManager) {
    }

    public RemoteControlManagement createRemoteControlManagement() {
        return new DefaultRemoteControlManagement();
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public synchronized RemoteControlManagement getRemoteControlManagement() {
        if (this.f24219a == null) {
            this.f24219a = createRemoteControlManagement();
        }
        return this.f24219a;
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public boolean isRemoteCallExtension(Extension extension, Method method) {
        return getRemoteControlManagement().isRemoteExtension(extension, method);
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) {
        IRemoteCaller remoteCallerProxy = getRemoteControlManagement().getRemoteCallerProxy();
        if (remoteCallerProxy != null) {
            return remoteCallerProxy.remoteCall(remoteCallArgs);
        }
        throw new IllegalStateException("RemoteCaller Not Found");
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public void setRemoteControlManagement(RemoteControlManagement remoteControlManagement) {
        this.f24219a = remoteControlManagement;
    }
}
