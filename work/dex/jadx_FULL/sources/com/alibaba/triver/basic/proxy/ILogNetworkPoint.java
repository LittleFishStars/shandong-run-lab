package com.alibaba.triver.basic.proxy;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ILogNetworkPoint extends Proxiable {
    void onHttpCacheHit(String str, App app, boolean z);

    void onHttpRequestCost(String str, App app, long j);

    void onMtopCacheHit(String str, App app, boolean z);

    void onMtopRequestCost(String str, App app, long j);
}
