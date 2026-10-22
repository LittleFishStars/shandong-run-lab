package com.alibaba.ariver.kernel.api.extension;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Action {

    public interface Complete<T> extends Action {
        void onComplete(T t);
    }

    public interface Exception extends Action {
        void onException(Extension extension, Throwable th);
    }

    public interface Interrupt extends Action {
        void onInterrupt(Extension extension);
    }

    public interface Progress<T> extends Action {
        void onProgress(Extension extension, T t);
    }

    public interface Start extends Action {
        void onStart(List<Extension> list);
    }
}
