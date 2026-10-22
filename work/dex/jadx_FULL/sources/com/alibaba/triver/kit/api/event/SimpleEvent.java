package com.alibaba.triver.kit.api.event;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SimpleEvent implements Event {
    private Object param;
    private ThreadMode threadMode;
    private String type;

    private SimpleEvent(@NonNull String str, Object obj, ThreadMode threadMode) {
        this.type = str;
        this.param = obj;
        this.threadMode = threadMode;
    }

    public static SimpleEvent obtain(@NonNull String str) {
        return new SimpleEvent(str, null, null);
    }

    @Override // com.alibaba.triver.kit.api.event.Event
    public Object getParam() {
        return this.param;
    }

    @Override // com.alibaba.triver.kit.api.event.Event
    public ThreadMode getThreadMode() {
        return this.threadMode;
    }

    @Override // com.alibaba.triver.kit.api.event.Event
    @NonNull
    public String getType() {
        return this.type;
    }

    public static SimpleEvent obtain(@NonNull String str, Object obj, ThreadMode threadMode) {
        return new SimpleEvent(str, obj, threadMode);
    }
}
