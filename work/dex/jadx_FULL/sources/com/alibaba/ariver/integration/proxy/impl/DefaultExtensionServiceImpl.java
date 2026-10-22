package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultExtensionServiceImpl implements RVExtensionService {
    @Override // com.alibaba.ariver.kernel.common.service.RVExtensionService
    public ExtensionManager getExtensionManager() {
        return RVInitializer.getExtensionManager();
    }
}
