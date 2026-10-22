package com.alibaba.triver.inside.impl;

import com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverRemoteDebugProxyImpl implements RVRemoteDebugProxy {
    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean enableTyroBlock(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public String getRemoteDebugWebSocketUrl(String str, String str2) {
        return null;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public String getRemoteDebugWebSocketUrlForDebug(String str, String str2) {
        return null;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean supportRemoteDebug(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.remotedebug.core.RVRemoteDebugProxy
    public boolean tyroRequestHasPermission(String str, String str2) {
        return true;
    }
}
