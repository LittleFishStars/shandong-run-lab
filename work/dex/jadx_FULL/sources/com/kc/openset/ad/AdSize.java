package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private int adHeight;
    private int adWidth;

    static {
        OSETSDKProtected.interface11(3705);
    }

    public AdSize(int i, int i2) {
        this.adWidth = i;
        this.adHeight = i2;
    }

    public native int getAdHeight();

    public native int getAdWidth();

    public native void setAdHeight(int i);

    public native void setAdWidth(int i);
}
