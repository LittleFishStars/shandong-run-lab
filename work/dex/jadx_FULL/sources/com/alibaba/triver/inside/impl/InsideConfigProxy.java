package com.alibaba.triver.inside.impl;

import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InsideConfigProxy implements IConfigProxy {
    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public Map<String, String> getConfigsByGroup(String str) {
        return new HashMap();
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public String getConfigsByGroupAndName(String str, String str2, String str3) {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public String getCustomConfigsByGroup(String str) {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public void registerListener(String str, IConfigProxy.ConfigListener configListener) {
    }

    @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy
    public void unregisterListener(String str, IConfigProxy.ConfigListener configListener) {
    }
}
