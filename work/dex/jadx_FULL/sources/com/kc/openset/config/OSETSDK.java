package com.kc.openset.config;

import android.app.Application;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.config.controller.OSETCustomController;
import com.kc.openset.listener.OSETInitListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class OSETSDK {
    private static volatile OSETSDK INSTANCE;

    static {
        OSETSDKProtected.interface11(4395);
    }

    public static native OSETSDK getInstance();

    public abstract int getVersionCode();

    public abstract String getVersionName();

    public abstract void init(Application application, String str, OSETInitListener oSETInitListener);

    public abstract OSETSDK setChannel(ChannelType channelType);

    public abstract OSETSDK setCustomController(OSETCustomController oSETCustomController);

    public abstract OSETSDK setDebug(boolean z);

    public abstract OSETSDK setUserId(String str);
}
