package com.fl.saas.ydsdk.api;

import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.ConfigUtils;
import com.fl.saas.ydsdk.manager.YdConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdSDK {
    public static void loadMixNative(Context context, AdParams adParams, NativeLoadListener nativeLoadListener) {
        if (!YdConfig.isInit()) {
            if (nativeLoadListener != null) {
                nativeLoadListener.onAdFailed(YdError.create(20402, "Please initialize the SDK first"));
            }
        } else if (adParams == null || !ConfigUtils.checkImpressFreq(adParams.getKey())) {
            ReportHelper.getInstance().reportSDKInit();
            new MixNativeManager(context, adParams, nativeLoadListener).load();
        } else if (nativeLoadListener != null) {
            nativeLoadListener.onAdFailed(YdError.create(20406, "Request too frequently"));
        }
    }
}
