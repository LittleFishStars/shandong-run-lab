package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IPrefetchResultProxy extends Proxiable {
    void addDynamicPrefetchResult(App app, String str);

    void addStaticPrefetchResult(App app, String str);
}
