package com.alibaba.triver.appinfo.core;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.appinfo.channel.AppInfoResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AppInfoClient extends Proxiable {
    boolean needCache(AppRequestParams appRequestParams);

    AppInfoResult requestAppInfo(AppRequestParams appRequestParams);
}
