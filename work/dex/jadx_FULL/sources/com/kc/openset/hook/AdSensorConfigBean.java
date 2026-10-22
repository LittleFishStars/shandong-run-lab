package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class AdSensorConfigBean {
    private AdType adType;
    private List<String> buttonTextList;
    private List<String> ignoreTextList;
    private boolean isClick;
    private boolean isReward;
    private boolean isSecondClick;
    private boolean isShow;
    private List<ClickRangeBean> mClickRangeBeanList;
    private List<String> mExtList;
    private WeakReference<OnFlowFinishedListener> mOnFlowFinishedListener;
    private float magnification;
    private String plat;
    private double probability;
    private String requestId;
    private int thresholds;
    private boolean triggered;

    @Keep
    public interface OnFlowFinishedListener {
        void onFlowFinish();
    }

    static {
        OSETSDKProtected.interface11(4432);
    }

    public native AdType getAdType();

    public native List<String> getButtonTextList();

    public native List<ClickRangeBean> getClickRangeBeanList();

    public native List<String> getExtList();

    public native List<String> getIgnoreTextList();

    public native float getMagnification();

    public native String getPlat();

    public native double getProbability();

    public native String getRequestId();

    public native int getThresholds();

    public native boolean isClick();

    public native boolean isReward();

    public native boolean isSecondClick();

    public native boolean isShow();

    public native boolean isTriggered();

    public native void onFlowFinish();

    public native void setAdType(AdType adType);

    public native void setButtonTextList(List<String> list);

    public native void setClick(boolean z);

    public native void setClickRangeBeanList(List<ClickRangeBean> list);

    public native void setExtList(List<String> list);

    public native void setIgnoreTextList(List<String> list);

    public native void setMagnification(float f);

    public native void setOnFlowFinishedListener(OnFlowFinishedListener onFlowFinishedListener);

    public native void setPlat(String str);

    public native void setProbability(double d);

    public native void setRequestId(String str);

    public native void setReward(boolean z);

    public native void setSecondClick(boolean z);

    public native void setShow(boolean z);

    public native void setThresholds(int i);

    public native void setTriggered(boolean z);

    public native String toString();
}
