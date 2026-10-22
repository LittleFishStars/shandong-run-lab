package com.alibaba.alibcprotocol.container;

import android.content.Context;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AlibcBaseContainer {
    void closeContainer();

    String getContainerTag();

    void goBack(boolean z);

    void initContainer(AlibcTradeContext alibcTradeContext, AlibcPluginCallback alibcPluginCallback, AlibcContainerCallback alibcContainerCallback);

    void reload();

    void runTask(RouteRequest routeRequest, String str, String str2);

    void runTask(String str, AlibcComponentReRenderCallback alibcComponentReRenderCallback);

    void runTask(String str, String str2);

    void runTask(String str, String str2, Context context);
}
