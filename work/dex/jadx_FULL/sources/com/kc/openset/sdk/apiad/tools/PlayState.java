package com.kc.openset.sdk.apiad.tools;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public enum PlayState {
    INITIALIZE,
    PLAYING,
    PAUSE,
    DONE,
    ERROR;

    static {
        OSETSDKProtected.interface11(4880);
    }

    public static native PlayState valueOf(String str);

    public static native PlayState[] values();
}
