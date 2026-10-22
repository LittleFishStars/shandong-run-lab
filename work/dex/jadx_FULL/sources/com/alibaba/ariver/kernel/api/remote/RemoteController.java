package com.alibaba.ariver.kernel.api.remote;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RemoteController {
    void bindExtensionManager(ExtensionManager extensionManager);

    RemoteControlManagement getRemoteControlManagement();

    boolean isRemoteCallExtension(Extension extension, Method method);

    RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs);

    void setRemoteControlManagement(RemoteControlManagement remoteControlManagement);
}
