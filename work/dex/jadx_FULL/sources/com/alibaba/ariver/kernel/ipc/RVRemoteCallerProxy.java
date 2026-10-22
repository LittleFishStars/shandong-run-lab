package com.alibaba.ariver.kernel.ipc;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.ipc.RemoteCallerImpl")
public interface RVRemoteCallerProxy extends Proxiable {
    @Nullable
    <T> T getRemoteCaller(Class<T> cls);

    <T> void registerServiceBean(Class<T> cls, T t);
}
