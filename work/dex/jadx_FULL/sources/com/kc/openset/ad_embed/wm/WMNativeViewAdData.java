package com.kc.openset.ad_embed.wm;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMNativeViewAdData {
    private String actBtnText;
    private String adLogoUrl;
    private String adSource;
    private String appDesc;
    private String appDeveloper;
    private String appName;
    private String appPackageName;
    private String appVersion;
    private String desc;
    private int ecpm;
    private String iconUrl;
    private List<String> imageUrls;
    private String introductionInfoUrl;
    private boolean isDownload;
    private String permissionsUrl;
    private String privacyPolicyUrl;
    private String requestId;
    private String title;
    private String videoCoverImgUrl;
    private String videoUrl;

    static {
        OSETSDKProtected.interface11(4192);
    }

    public native String getActBtnText();

    public native String getAdLogoUrl();

    public native String getAdSource();

    public native String getAppDesc();

    public native String getAppDeveloper();

    public native String getAppName();

    public native String getAppPackageName();

    public native String getAppVersion();

    public native String getDesc();

    public native int getEcpm();

    public native String getIconUrl();

    public native List<String> getImageUrls();

    public native String getIntroductionInfoUrl();

    public native String getPermissionsUrl();

    public native String getPrivacyPolicyUrl();

    public native String getRequestId();

    public native String getTitle();

    public native String getVideoCoverImgUrl();

    public native String getVideoUrl();

    public native boolean isDownload();

    public native void setActBtnText(String str);

    public native void setAdLogoUrl(String str);

    public native void setAdSource(String str);

    public native void setAppDesc(String str);

    public native void setAppDeveloper(String str);

    public native void setAppName(String str);

    public native void setAppPackageName(String str);

    public native void setAppVersion(String str);

    public native void setDesc(String str);

    public native void setDownload(boolean z);

    public native void setEcpm(int i);

    public native void setIconUrl(String str);

    public native void setImageUrls(List<String> list);

    public native void setIntroductionInfoUrl(String str);

    public native void setPermissionsUrl(String str);

    public native void setPrivacyPolicyUrl(String str);

    public native void setRequestId(String str);

    public native void setTitle(String str);

    public native void setVideoCoverImgUrl(String str);

    public native void setVideoUrl(String str);
}
