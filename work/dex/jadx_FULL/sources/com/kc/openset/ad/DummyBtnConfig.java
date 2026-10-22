package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class DummyBtnConfig {
    private String icon;
    private int position;

    static {
        OSETSDKProtected.interface11(3713);
    }

    public native String getIcon();

    public native int getPosition();

    public native void setIcon(String str);

    public native void setPosition(int i);

    public native String toString();
}
