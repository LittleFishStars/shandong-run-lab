package com.kwad.sdk.liteapi;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.a.b;
import com.kwad.sdk.api.loader.DexLoadError;
import com.kwad.sdk.api.loader.q;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.liteapi.report.LiteApiReporter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KsLiteApiImpl implements q {
    private static final String TAG = "KsLiteApiImpl";

    @Override // com.kwad.sdk.api.loader.q
    public String getAESKey(Context context) {
        return LiteEncryptUtils.getKey(context, 0);
    }

    @Override // com.kwad.sdk.api.loader.q
    public void holdSdkConfig(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            InputParamHolder.holderSdkConfig(sdkConfig);
        }
    }

    @Override // com.kwad.sdk.api.loader.q
    public void onInit(Context context) {
        LiteOAIDHelper.getAppOAID(context);
    }

    @Override // com.kwad.sdk.api.loader.q
    public void reportDexLoadError(final Context context, final DexLoadError dexLoadError) {
        LiteApiLogger.d(TAG, "reportDexLoadError dexLoadError: " + dexLoadError);
        if (dexLoadError != null) {
            com.kwad.sdk.api.a.a.a(new b() { // from class: com.kwad.sdk.liteapi.KsLiteApiImpl.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    LiteApiLogger.d(KsLiteApiImpl.TAG, "reportDexLoadError doTask: ");
                    LiteApiReporter.reportDexError(context, dexLoadError.getErrorMsg(), dexLoadError.getErrorCode());
                }
            });
        }
    }
}
