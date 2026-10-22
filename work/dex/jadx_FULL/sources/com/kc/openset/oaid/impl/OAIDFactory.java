package com.kc.openset.oaid.impl;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class OAIDFactory {
    private static final String TAG = OSETSDKProtected.getString2(1884);
    private static IOAID ioaid;

    static {
        OSETSDKProtected.interface11(4487);
    }

    private OAIDFactory() {
    }

    public static native IOAID create(Context context);

    private static native IOAID createManufacturerImpl(Context context);

    private static native IOAID createUniversalImpl(Context context);

    public static native IOAID ofGms(Context context);

    public static native IOAID ofMsa(Context context);
}
