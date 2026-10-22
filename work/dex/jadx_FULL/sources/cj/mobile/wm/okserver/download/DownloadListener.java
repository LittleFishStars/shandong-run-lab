package cj.mobile.wm.okserver.download;

import cj.mobile.wm.okserver.ProgressListener;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class DownloadListener implements ProgressListener<File> {
    public final Object tag;

    public DownloadListener(Object obj) {
        this.tag = obj;
    }
}
