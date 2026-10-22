package com.alibaba.ariver.commonability.device.jsapi.clipboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVClipboardProxy extends Proxiable {

    public interface a<T> {
        void a(T t);
    }

    void getText(@Nullable String str, @NonNull a<String> aVar);

    void setText(@Nullable String str, @NonNull String str2, @NonNull a<Boolean> aVar);
}
