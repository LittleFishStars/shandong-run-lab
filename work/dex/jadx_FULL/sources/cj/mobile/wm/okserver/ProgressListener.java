package cj.mobile.wm.okserver;

import cj.mobile.wm.okhttp.model.Progress;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ProgressListener<T> {
    void onError(Progress progress);

    void onFinish(T t, Progress progress);

    void onProgress(Progress progress);

    void onRemove(Progress progress);

    void onStart(Progress progress);
}
