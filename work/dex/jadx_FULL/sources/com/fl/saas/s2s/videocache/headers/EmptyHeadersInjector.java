package com.fl.saas.s2s.videocache.headers;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class EmptyHeadersInjector implements HeaderInjector {
    @Override // com.fl.saas.s2s.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String str) {
        return new HashMap();
    }
}
