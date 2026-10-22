package com.kc.aw.lib.interf;

import com.kc.aw.lib.model.AppInfo;
import com.kc.aw.lib.model.PtgImageInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface NativeAdvertData {
    void destroy();

    int getAction();

    int getAid();

    AppInfo getApp();

    String getBrand();

    String getButtonText();

    String getDesc();

    long getDuration();

    int getHeight();

    List<PtgImageInfo> getImageList();

    String getLandUrl();

    String getLogo();

    String getMaterialId();

    String getMime();

    String getStyle();

    String getTitle();

    int getType();

    String getVideoCover();

    String getVideoUrl();

    int getWidth();

    boolean isSupportShake();
}
