package com.fl.saas.adx.api;

import android.content.Context;
import com.fl.saas.A;
import com.fl.saas.E0;
import com.fl.saas.adx.api.FLSDK;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.manager.MixNativeManager;
import com.fl.saas.c1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLSDK {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadMixNative$0(Context context, AdParams adParams, NativeLoadListener nativeLoadListener) {
        E0.a().e();
        new MixNativeManager(context, adParams, nativeLoadListener).load();
    }

    public static void loadMixNative(final Context context, final AdParams adParams, final NativeLoadListener nativeLoadListener) {
        if (!FLConfig.isInit()) {
            if (nativeLoadListener != null) {
                nativeLoadListener.onAdFailed(FLError.create(20402, "Please initialize the SDK first"));
            }
        } else if (adParams == null || !A.a(adParams.getKey())) {
            c1.a().b(new Runnable() { // from class: com.zj.adlib.yc3
                @Override // java.lang.Runnable
                public final void run() {
                    FLSDK.lambda$loadMixNative$0(context, adParams, nativeLoadListener);
                }
            });
        } else if (nativeLoadListener != null) {
            nativeLoadListener.onAdFailed(FLError.create(20406, "Request too frequently"));
        }
    }
}
