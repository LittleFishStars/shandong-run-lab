package com.byazt.fk;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface u {
    String getCacheParentDir();

    String getCid();

    String getCodeId();

    int getConnectTimeOutMills();

    long getCurrent();

    n getCurrentVideoInfo();

    Object getExtra(String str);

    String getFileNameKey();

    int getHeight();

    String getLogExtra();

    JSONObject getPassThroughJson();

    int getPitayaCacheSize();

    int getPitayaCode();

    String getPitayaErrorMsg();

    float getPlaySpeedRatio();

    List<String> getPlayTrackUrls();

    int getPlayerType();

    int getPreloadSize();

    int getReadTimeOutMills();

    int getScene();

    int getSourceType();

    String getUrl();

    int getVideoEncodeType();

    n getVideoH264();

    n getVideoH265();

    long getVideoSize();

    int getVideoSkipResult();

    int getWidth();

    int getWriteTimeOutMills();

    boolean isAudio();

    boolean isH265();

    boolean isPreloadAll();

    boolean isQuiet();

    void putExtra(String str, Object obj);

    Object removeExtra(String str);

    void setAudio(boolean z);

    void setCacheParentDir(String str);

    void setCid(String str);

    void setCodeId(String str);

    void setConnectTimeOutMills(int i);

    void setCurrent(long j);

    void setHeight(int i);

    void setLogExtra(String str);

    void setPlayTrackUrls(List<String> list);

    void setPlayerType(int i);

    void setQuiet(boolean z);

    void setReadTimeOutMills(int i);

    void setScene(int i);

    void setSourceType(int i);

    void setVideoEncodeType(int i);

    void setVideoH264(n nVar);

    void setVideoH265(n nVar);

    void setVideoSkipResult(int i);

    void setWidth(int i);

    void setWriteTimeOutMills(int i);
}
