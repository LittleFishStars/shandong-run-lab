package com.kc.openset.hook.hapi;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class Reflection {
    private static final String DEX = OSETSDKProtected.getString2(1810);
    private static final String TAG = OSETSDKProtected.getString2(1813);

    static {
        OSETSDKProtected.interface11(4459);
    }

    private static native File getCodeCacheDir(Context context);

    public static native int unseal(Context context);

    private static native boolean unsealByDexFile(Context context);
}
