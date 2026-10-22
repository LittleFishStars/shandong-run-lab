package com.alibaba.ariver.kernel.api.remote;

import com.alibaba.ariver.kernel.api.extension.Extension;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RemoteControlManagement {
    IRemoteCaller getRemoteCallerProxy();

    boolean isRemoteExtension(Extension extension, Method method);
}
