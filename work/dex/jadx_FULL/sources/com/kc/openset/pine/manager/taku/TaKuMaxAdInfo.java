package com.kc.openset.pine.manager.taku;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class TaKuMaxAdInfo {
    private double maxPrice;
    private String networkName;

    static {
        OSETSDKProtected.interface11(4623);
    }

    public native double getMaxPrice();

    public native String getNetworkName();

    public native void setMaxPrice(double d);

    public native void setNetworkName(String str);
}
