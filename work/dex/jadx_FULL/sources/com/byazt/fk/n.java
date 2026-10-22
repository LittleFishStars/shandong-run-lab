package com.byazt.fk;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface n {
    int getCover_height();

    String getCover_url();

    int getCover_width();

    String getEndcard();

    int getEndcardRender();

    int getExecuteCachedType();

    int getFallbackEndCardJudge();

    String getFileHash();

    float getPlay_speed_ratio();

    int getPlayableLoadingHide();

    int getPlayableLoadingShow();

    String getPlayableZipUrl();

    int getReplayTime();

    String getResolution();

    int getRewardVideoCachedType();

    long getSize();

    double getStart();

    int getVideoPreloadSize();

    double getVideo_duration();

    String getVideo_url();

    int[] getWidthAndHeight();

    boolean isCacheAllVideo();

    boolean isExecCallbackWhenFail();

    void setCover_height(int i);

    void setCover_url(String str);

    void setCover_width(int i);

    void setEndcard(String str);

    void setEndcardRender(int i);

    void setExecuteCachedType(int i);

    void setFallbackEndCardJudge(int i);

    void setFileHash(String str);

    void setPlay_speed_ratio(float f);

    void setPlayableLoadingHide(int i);

    void setPlayableLoadingShow(int i);

    void setPlayableZipUrl(String str);

    void setReplayTime(int i);

    void setResolution(String str);

    void setRewardVideoCachedType(int i);

    void setSize(long j);

    void setStart(double d);

    void setVideoPreloadSize(int i);

    void setVideo_duration(double d);

    void setVideo_url(String str);

    JSONObject toJsonObj();
}
