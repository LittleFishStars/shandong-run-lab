package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class QDImages {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39704a;
    private int b;
    private int c;

    static {
        OSETSDKProtected.interface11(4301);
    }

    public QDImages(String str, int i, int i2) {
        this.f39704a = str;
        this.b = i;
        this.c = i2;
    }

    public native int getHeight();

    public native String getUrl();

    public native int getWidth();

    public native void setHeight(int i);

    public native void setUrl(String str);

    public native void setWidth(int i);
}
