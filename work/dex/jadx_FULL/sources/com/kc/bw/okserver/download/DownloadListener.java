package com.kc.bw.okserver.download;

import com.kc.bw.okserver.ProgressListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class DownloadListener implements ProgressListener<File> {
    public final Object tag;

    public DownloadListener(Object obj) {
        this.tag = obj;
    }
}
