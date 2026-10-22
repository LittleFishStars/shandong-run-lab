package com.alibaba.ariver.resource.api.prepare;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVParams;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum OfflineMode {
    SYNC_FORCE(2),
    SYNC_TRY(1),
    ASYNC(0);

    public int value;

    OfflineMode(int i) {
        this.value = i;
    }

    public static OfflineMode fromString(String str, String str2) {
        if (NativeCallContext.CALL_MODE_SYNC.equals(str)) {
            return RVParams.DEFAULT_LONG_UP_STRATEGY.equals(str2) ? SYNC_TRY : SYNC_FORCE;
        }
        return ASYNC;
    }

    public boolean isSync() {
        return this.value > 0;
    }
}
