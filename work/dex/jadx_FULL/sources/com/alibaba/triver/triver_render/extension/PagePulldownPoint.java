package com.alibaba.triver.triver_render.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PagePulldownPoint extends Extension {
    @ThreadType(ExecutorType.URGENT)
    void onReachPullRefreshDistance(App app, int i);

    @ThreadType(ExecutorType.URGENT)
    void onRefresh(App app);
}
