package com.byazt.fdg;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 137})
public class nu extends Exception {
    public final int c;

    public nu(int i, String str) {
        super(str);
        this.c = i;
    }

    public nu(int i, String str, Throwable th) {
        super(str, th);
        this.c = i;
    }
}
