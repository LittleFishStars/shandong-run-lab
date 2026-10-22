package com.kc.bw.okserver.upload;

import com.kc.bw.okserver.ProgressListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class UploadListener<T> implements ProgressListener<T> {
    public final Object tag;

    public UploadListener(Object obj) {
        this.tag = obj;
    }
}
