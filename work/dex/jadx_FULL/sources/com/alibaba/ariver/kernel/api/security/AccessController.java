package com.alibaba.ariver.kernel.api.security;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AccessController {

    public interface ApplyCallback {
        void onFailure(List<? extends Permission> list);

        void onSuccess();
    }

    boolean check(Accessor accessor, List<? extends Guard> list, @Nullable ApplyCallback applyCallback);

    void setAccessControlManagement(AccessControlManagement accessControlManagement);
}
