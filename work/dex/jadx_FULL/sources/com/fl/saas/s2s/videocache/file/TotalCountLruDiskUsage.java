package com.fl.saas.s2s.videocache.file;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    private final int maxCount;

    public TotalCountLruDiskUsage(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.maxCount = i;
    }

    @Override // com.fl.saas.s2s.videocache.file.LruDiskUsage
    public boolean accept(File file, long j, int i) {
        return i <= this.maxCount;
    }
}
