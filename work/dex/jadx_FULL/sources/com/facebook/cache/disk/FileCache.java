package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface FileCache extends DiskTrimmable {
    DiskStorage.a a() throws IOException;

    long c(long j);

    void clearAll();

    boolean d(CacheKey cacheKey);

    void e(CacheKey cacheKey);

    boolean f(CacheKey cacheKey);

    long getSize();

    BinaryResource h(CacheKey cacheKey);

    boolean i(CacheKey cacheKey);

    BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException;

    boolean isEnabled();
}
