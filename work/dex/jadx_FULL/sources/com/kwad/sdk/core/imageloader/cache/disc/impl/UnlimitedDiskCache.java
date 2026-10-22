package com.kwad.sdk.core.imageloader.cache.disc.impl;

import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class UnlimitedDiskCache extends BaseDiskCache {
    public UnlimitedDiskCache(File file) {
        super(file);
    }

    public UnlimitedDiskCache(File file, File file2) {
        super(file, file2);
    }

    public UnlimitedDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        super(file, file2, fileNameGenerator);
    }
}
