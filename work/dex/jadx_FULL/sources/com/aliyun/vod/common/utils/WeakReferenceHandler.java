package com.aliyun.vod.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class WeakReferenceHandler<T> extends Handler {
    private WeakReference<T> mReference;

    public WeakReferenceHandler(Looper looper, T t) {
        super(looper);
        this.mReference = new WeakReference<>(t);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        T t = this.mReference.get();
        if (t == null) {
            return;
        }
        handleMessage(t, message);
    }

    public abstract void handleMessage(T t, Message message);
}
