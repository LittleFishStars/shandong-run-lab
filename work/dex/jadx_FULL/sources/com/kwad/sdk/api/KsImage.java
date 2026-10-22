package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkApi
@Keep
public interface KsImage {
    @KsAdSdkApi
    @Keep
    int getHeight();

    @KsAdSdkApi
    @Keep
    String getImageUrl();

    @KsAdSdkApi
    @Keep
    int getWidth();

    @KsAdSdkApi
    @Keep
    boolean isValid();
}
