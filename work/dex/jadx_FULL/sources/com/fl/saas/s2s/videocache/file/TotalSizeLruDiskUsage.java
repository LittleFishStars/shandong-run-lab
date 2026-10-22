package com.fl.saas.s2s.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long maxSize;

    public TotalSizeLruDiskUsage(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.maxSize = j;
    }

    @Override // com.fl.saas.s2s.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i) {
        return j <= this.maxSize;
    }
}
