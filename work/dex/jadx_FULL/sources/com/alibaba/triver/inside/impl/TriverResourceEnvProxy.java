package com.alibaba.triver.inside.impl;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverResourceEnvProxy implements RVResourceEnviromentProxy {
    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy
    public String getConfigVariable() {
        return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appName");
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy
    @Nullable
    public String getLegacySignPublicKey() {
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy
    @Nullable
    public String getNewSignPublicKey() {
        return null;
    }
}
