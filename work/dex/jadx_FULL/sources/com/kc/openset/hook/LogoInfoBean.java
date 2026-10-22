package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LogoInfoBean {
    private String logo;
    private String name;
    private String plat;

    static {
        OSETSDKProtected.interface11(4447);
    }

    public native String getLogo();

    public native String getName();

    public native String getPlat();

    public native void setLogo(String str);

    public native void setName(String str);

    public native void setPlat(String str);
}
