package com.ipd.dsp.api;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface ReasonCode {
    public static final int BID_FAILED = 1001;
    public static final int CACHE_INVALID = -2;
    public static final int EXPOSURE_PRIORITY_REDUCED = -3;
    public static final int MEDIA_SIDE_PRICE_FILTER = -1;
    public static final int OTHER = 1005;
    public static final int REQUEST_FAILED = 1002;
    public static final int REQUEST_IGNORE = 1004;
    public static final int REQUEST_TIMEOUT = 1003;
}
