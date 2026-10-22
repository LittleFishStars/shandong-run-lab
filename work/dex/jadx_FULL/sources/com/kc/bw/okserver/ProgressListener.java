package com.kc.bw.okserver;

import com.kc.bw.okhttp.model.Progress;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ProgressListener<T> {
    void onError(Progress progress);

    void onFinish(T t, Progress progress);

    void onProgress(Progress progress);

    void onRemove(Progress progress);

    void onStart(Progress progress);
}
