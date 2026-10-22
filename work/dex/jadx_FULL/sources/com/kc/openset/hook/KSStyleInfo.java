package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSStyleInfo {
    private String componentDatas;
    private String endCardInfo;
    private String playCardInfo;

    static {
        OSETSDKProtected.interface11(4443);
    }

    public native String getComponentDatas();

    public native String getEndCardInfo();

    public native String getPlayCardInfo();

    public native void setComponentDatas(String str);

    public native void setEndCardInfo(String str);

    public native void setPlayCardInfo(String str);

    public native String toString();
}
