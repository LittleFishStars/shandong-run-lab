package com.huachenjie.im;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface OperateCallback<T> {
    void onException(Throwable th);

    void onFailed(int i);

    void onSuccess(T t);
}
