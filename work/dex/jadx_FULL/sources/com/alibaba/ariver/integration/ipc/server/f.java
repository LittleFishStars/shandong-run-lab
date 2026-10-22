package com.alibaba.ariver.integration.ipc.server;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class f {
    public static void a(Page page) {
        if ((page instanceof PageNode) && page.getRender() == null) {
            ((PageNode) page).setRender(new com.alibaba.ariver.integration.ipc.server.a.c(page.getApp().getEngineProxy(), null, page, null));
        }
    }

    public static void a(App app) {
        if ((app instanceof AppNode) && app.getEngineProxy() == null) {
            ((AppNode) app).setEngineProxy(new com.alibaba.ariver.integration.ipc.server.a.b(app));
        }
    }
}
