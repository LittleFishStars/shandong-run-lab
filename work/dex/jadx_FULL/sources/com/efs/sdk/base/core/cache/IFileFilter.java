package com.efs.sdk.base.core.cache;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IFileFilter {
    boolean filter(File file);

    void finish();

    void finish(boolean z, boolean z2);

    boolean hasTask();
}
