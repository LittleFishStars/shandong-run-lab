package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ExtensionCallback<T> extends ExtensionInvoker.InvokeCallback<T> {
    void onException(Extension extension, Throwable th);

    void onInterrupt(Extension extension);

    void onProgress(Extension extension, T t);

    void onStart(List<Extension> list);
}
