package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class SensitivityBean {
    private int adType;
    private final List<String> buttonTextList = new ArrayList();
    private final List<String> ignoreTextList = new ArrayList();
    private List<ClickRangeBean> mClickRangeBeanList;
    private float magnification;
    private String plat;
    private double probability;
    private int thresholds;

    static {
        OSETSDKProtected.interface11(4448);
    }

    public native void addButtonText(String str);

    public native void addIgnoreText(String str);

    public native int getAdType();

    public native List<String> getButtonTextList();

    public native List<ClickRangeBean> getClickRangeBeanList();

    public native List<String> getIgnoreTextList();

    public native float getMagnification();

    public native String getPlat();

    public native double getProbability();

    public native int getThresholds();

    public native void setAdType(int i);

    public native void setClickRangeBeanList(List<ClickRangeBean> list);

    public native void setMagnification(float f);

    public native void setPlat(String str);

    public native void setProbability(double d);

    public native void setThresholds(int i);

    public native String toString();
}
