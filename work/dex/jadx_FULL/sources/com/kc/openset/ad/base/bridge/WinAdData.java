package com.kc.openset.ad.base.bridge;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WinAdData {
    private String adTitle;
    private String adUserName;
    private String advertisers;
    private boolean isBidding;
    private double price;

    static {
        OSETSDKProtected.interface11(3786);
    }

    public native String getAdTitle();

    public native String getAdUserName();

    public native String getAdvertisers();

    public native double getDoublePrice();

    public native int getPrice();

    public native boolean isBidding();

    public native void setAdTitle(String str);

    public native void setAdUserName(String str);

    public native void setAdvertisers(String str);

    public native void setBidding(boolean z);

    public native void setPrice(double d);

    public native String toString();
}
