package com.alibaba.ariver.integration.proxy.impl;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.proxy.RVAppFactory;
import com.alibaba.ariver.kernel.common.RVProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultAppFactoryImpl implements RVAppFactory {
    @Override // com.alibaba.ariver.app.proxy.RVAppFactory
    public AppNode createApp() {
        return new AppNode((AppManager) RVProxy.get(AppManager.class));
    }
}
