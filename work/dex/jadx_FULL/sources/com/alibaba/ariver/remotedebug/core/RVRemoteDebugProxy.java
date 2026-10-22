package com.alibaba.ariver.remotedebug.core;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.remotedebug.core.DefaultRemoteDebugProxyImpl")
public interface RVRemoteDebugProxy extends Proxiable {
    boolean enableTyroBlock(String str);

    String getRemoteDebugWebSocketUrl(String str, String str2);

    String getRemoteDebugWebSocketUrlForDebug(String str, String str2);

    boolean supportRemoteDebug(String str);

    boolean tyroRequestHasPermission(String str, String str2);
}
