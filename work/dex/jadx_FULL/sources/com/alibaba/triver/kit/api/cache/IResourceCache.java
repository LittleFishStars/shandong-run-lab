package com.alibaba.triver.kit.api.cache;

import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IResourceCache {
    String getCache(String str);

    byte[] getCacheByteArray(String str);

    InputStream getCacheStream(String str);

    void removeCache(String str);

    void saveCache(String str, String str2);
}
