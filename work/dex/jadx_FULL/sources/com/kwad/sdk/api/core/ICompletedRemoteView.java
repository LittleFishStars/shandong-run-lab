package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicApi
@Keep
public interface ICompletedRemoteView {
    @KsAdSdkDynamicApi
    @Keep
    RemoteViews build();

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(@DrawableRes int i);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    @Keep
    void setInstallText(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setName(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setSize(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setStatus(String str);
}
