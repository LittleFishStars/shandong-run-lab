package com.alibaba.alibctriver;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.remote.internal.DefaultRemoteControlManagement;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends DefaultRemoteControlManagement {
    @Override // com.alibaba.ariver.kernel.api.remote.internal.DefaultRemoteControlManagement, com.alibaba.ariver.kernel.api.remote.RemoteControlManagement
    public boolean isRemoteExtension(Extension extension, Method method) {
        if (ProcessUtils.isMainProcess() || com.alibaba.alibcprotocol.utils.ProcessUtils.isComponentProcess(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext())) {
            return false;
        }
        return hasRemoteAnnotation(extension, method);
    }
}
