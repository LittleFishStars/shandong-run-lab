package com.alibaba.triver.kit.api.event;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Event {
    Object getParam();

    ThreadMode getThreadMode();

    @NonNull
    String getType();
}
