package com.kc.bw.okhttp.model;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface Priority {
    public static final int BG_LOW = Integer.MIN_VALUE;
    public static final int BG_NORMAL = -1000;
    public static final int BG_TOP = -100;
    public static final int DEFAULT = 0;
    public static final int UI_LOW = 100;
    public static final int UI_NORMAL = 1000;
    public static final int UI_TOP = Integer.MAX_VALUE;
}
