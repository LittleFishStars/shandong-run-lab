package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkApi
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface KsNativeConvertType {
    public static final int CONVERT = 1;
    public static final int CONVERT_CLICK = 3;
    public static final int CONVERT_SLIDE = 5;
    public static final int SHOW_DOWNLOAD_TIPS_DIALOG = 2;
    public static final int SHOW_DOWNLOAD_TIPS_DIALOG_CLICK = 4;
    public static final int SHOW_DOWNLOAD_TIPS_DIALOG_SLIDE = 6;
}
