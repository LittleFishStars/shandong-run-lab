package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicApi
@Keep
public interface IProgressRemoteView {
    @KsAdSdkDynamicApi
    @Keep
    RemoteViews build();

    @KsAdSdkDynamicApi
    @Keep
    void setControlBtnPaused(boolean z);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(@DrawableRes int i);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    @Keep
    void setName(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setPercentNum(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setProgress(int i, int i2, boolean z);

    @KsAdSdkDynamicApi
    @Keep
    void setSize(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setStatus(String str);
}
