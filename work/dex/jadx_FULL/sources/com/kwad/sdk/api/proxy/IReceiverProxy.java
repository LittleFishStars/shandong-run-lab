package com.kwad.sdk.api.proxy;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicApi
@Keep
public interface IReceiverProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @Keep
    void onReceive(Context context, Intent intent);
}
