package com.kc.openset.util;

import android.app.Application;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ContextUtils {
    static {
        OSETSDKProtected.interface11(4927);
    }

    public static native Application getApplication();

    public static native Context getContext();
}
