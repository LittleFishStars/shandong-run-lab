package com.alibaba.ariver.app.proxy;

import android.app.Activity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultSinglePageAppProxyImpl")
public interface RVSinglePageAppProxy extends Proxiable {
    AppContext createAppContext(App app, Activity activity);

    PageContext createPageContext(App app, Activity activity);
}
