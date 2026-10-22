package com.alibaba.ariver.app.proxy;

import android.os.Bundle;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultPageFactoryImpl")
public interface RVPageFactory extends Proxiable {
    PageNode createPage(App app, String str, Bundle bundle, Bundle bundle2);
}
