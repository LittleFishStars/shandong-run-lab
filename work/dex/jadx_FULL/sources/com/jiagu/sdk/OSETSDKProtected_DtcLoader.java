package com.jiagu.sdk;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OSETSDKProtected_DtcLoader {
    static {
        try {
            OSETSDKProtected.interface11(5196);
            System.loadLibrary(OSETSDKProtected.getString2("4056"));
        } catch (Error | Exception unused) {
        }
    }

    public static native void init();
}
