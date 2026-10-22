package com.alibaba.ariver.integration.proxy.impl;

import android.app.Activity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.proxy.RVSinglePageAppProxy;
import com.alibaba.ariver.integration.singlepage.SinglePageAppContext;
import com.alibaba.ariver.integration.singlepage.SinglePageContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultSinglePageAppProxyImpl implements RVSinglePageAppProxy {
    @Override // com.alibaba.ariver.app.proxy.RVSinglePageAppProxy
    public AppContext createAppContext(App app, Activity activity) {
        return new SinglePageAppContext(app, activity);
    }

    @Override // com.alibaba.ariver.app.proxy.RVSinglePageAppProxy
    public PageContext createPageContext(App app, Activity activity) {
        return new SinglePageContext(app, activity);
    }
}
