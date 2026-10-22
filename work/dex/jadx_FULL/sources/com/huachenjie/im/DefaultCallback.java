package com.huachenjie.im;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class DefaultCallback<T> implements OperateCallback<T> {
    @Override // com.huachenjie.im.OperateCallback
    public void onException(Throwable th) {
        onResult(1000, null, th);
    }

    @Override // com.huachenjie.im.OperateCallback
    public void onFailed(int i) {
        onResult(i, null, null);
    }

    public abstract void onResult(int i, @Nullable T t, @Nullable Throwable th);

    @Override // com.huachenjie.im.OperateCallback
    public void onSuccess(T t) {
        onResult(200, t, new Exception());
    }
}
