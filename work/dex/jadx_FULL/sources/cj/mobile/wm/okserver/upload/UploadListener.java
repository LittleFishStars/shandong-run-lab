package cj.mobile.wm.okserver.upload;

import cj.mobile.wm.okserver.ProgressListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class UploadListener<T> implements ProgressListener<T> {
    public final Object tag;

    public UploadListener(Object obj) {
        this.tag = obj;
    }
}
