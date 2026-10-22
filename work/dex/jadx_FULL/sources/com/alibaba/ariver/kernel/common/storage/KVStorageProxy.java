package com.alibaba.ariver.kernel.common.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface KVStorageProxy extends Proxiable {
    void clear(@NonNull String str);

    @Nullable
    String getString(@NonNull String str, @NonNull String str2);

    void putString(@NonNull String str, @NonNull String str2, @NonNull String str3);

    void remove(@NonNull String str, @NonNull String str2);
}
