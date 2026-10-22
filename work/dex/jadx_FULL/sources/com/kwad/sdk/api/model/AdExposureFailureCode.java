package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface AdExposureFailureCode {
    public static final int BID_FAILED = 2;
    public static final int CACHE_INVALID = 3;
    public static final int CALLBACK_TIME_OUT = 5;
    public static final int EMPTY = -9999;
    public static final int EXPOSURE_PRIORITY_REDUCED = 4;
    public static final int MEDIA_BLOCK = 6;
    public static final int MEDIA_SIDE_PRICE_FILTER = 1;
    public static final int OTHER = 0;
}
