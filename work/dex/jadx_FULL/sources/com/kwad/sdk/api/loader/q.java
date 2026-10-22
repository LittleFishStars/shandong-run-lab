package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public interface q {
    String getAESKey(Context context);

    void holdSdkConfig(SdkConfig sdkConfig);

    void onInit(Context context);

    void reportDexLoadError(Context context, DexLoadError dexLoadError);
}
