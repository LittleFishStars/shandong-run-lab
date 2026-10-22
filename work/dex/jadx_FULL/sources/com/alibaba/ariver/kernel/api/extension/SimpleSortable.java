package com.alibaba.ariver.kernel.api.extension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface SimpleSortable {
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int NONE = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    int priority();
}
