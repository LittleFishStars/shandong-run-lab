package com.kc.openset.ad.bid;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class BidAdInfo {
    private String adTitle;
    private String adUserName;
    private String adnName;
    private boolean isBidding;
    private double price;
    private String reason;

    static {
        OSETSDKProtected.interface11(3845);
    }

    public native String getAdTitle();

    public native String getAdUserName();

    public native String getAdnName();

    public native double getPrice();

    public native String getReason();

    public native boolean isBidding();

    public native void setAdTitle(String str);

    public native void setAdUserName(String str);

    public native void setAdnName(String str);

    public native void setBidding(boolean z);

    public native void setPrice(double d);

    public native void setPrice(float f);

    public native void setPrice(int i);

    public native void setReason(String str);
}
