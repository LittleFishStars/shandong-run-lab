package com.alibaba.triver.open.prefetch;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PrefectchCallback extends Serializable {

    public enum PrefetchCallbackType {
        TYPE_HIT,
        TYPE_MISS
    }

    void onPreload(PrefetchCallbackType prefetchCallbackType, Object obj);
}
