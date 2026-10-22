package com.alibaba.ariver.app.proxy;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultAppFactoryImpl")
public interface RVAppFactory extends Proxiable {
    AppNode createApp();
}
